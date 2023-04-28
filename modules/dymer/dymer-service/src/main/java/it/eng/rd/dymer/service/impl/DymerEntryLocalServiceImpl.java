package it.eng.rd.dymer.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PortalPreferences;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.notifications.NotificationEvent;
import com.liferay.portal.kernel.notifications.NotificationEventFactoryUtil;
import com.liferay.portal.kernel.notifications.UserNotificationManagerUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.PortalPreferencesLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SubscriptionSender;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import it.eng.rd.dymer.model.Dymer;
import it.eng.rd.dymer.model.DymerEntry;
import it.eng.rd.dymer.service.base.DymerEntryLocalServiceBaseImpl;
import it.eng.rd.dymer.service.constants.DymerServicePropsKeys;
import it.eng.rd.dymer.service.notifications.DymerUserNotificationDefinition;

@Component(property = "model.class.name=it.eng.rd.dymer.model.DymerEntry", service = AopService.class)
public class DymerEntryLocalServiceImpl extends DymerEntryLocalServiceBaseImpl {

	private final String portletId = "it_eng_rd_dymer_portlet_DymerPortlet";

	private final ResourceBundle _resourceBundle = ResourceBundle.getBundle("content/Language",
			new Locale(Locale.getDefault().toString(), Locale.getDefault().getDisplayCountry()));

	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry addDymerEntry(long dymerId, String index, String type, String id, String url, String title,
			String extContent, ServiceContext serviceContext) throws PortalException, SystemException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(serviceContext.getUserId());

		Date now = new Date();

		long entryId = counterLocalService.increment();

		DymerEntry entry = dymerEntryPersistence.create(entryId);

		entry.setUuid(serviceContext.getUuid());
		entry.setUserId(serviceContext.getUserId());
		entry.setGroupId(groupId);
		entry.setCompanyId(user.getCompanyId());
		entry.setUserName(user.getFullName());
		entry.setCreateDate(serviceContext.getCreateDate(now));
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setDymerId(dymerId);
		entry.setIndex(index);
		entry.setType(type);
		entry.setId(id);
		if (url.isEmpty()) {
			url = "#";
		}
		entry.setUrl(url);
		entry.setTitle(title);
		entry.setExtContent(extContent);

		if (_log.isDebugEnabled()) {
			_log.debug("DymerEntryLocalServiceImpl, addDymerEntry method-----------------------------");

			_log.debug("uuid: " + serviceContext.getUuid());
			_log.debug("userId: " + serviceContext.getUserId());
			_log.debug("groupId: " + groupId);
			_log.debug("companyId: " + user.getCompanyId());
			_log.debug("userName: " + user.getFullName());
			_log.debug("createDate: " + now.toString());
			_log.debug("modifiedDate: " + now.toString());
			_log.debug("dymerId: " + dymerId);

			_log.debug("index: " + index);
			_log.debug("type: " + type);
			_log.debug("id: " + id);
			_log.debug("url: " + url);
		}

		entry = dymerEntryPersistence.update(entry);

		Dymer dymer = dymerPersistence.fetchByPrimaryKey(dymerId);
		String dymerDomainName = "";
		if (serviceContext.getAttribute("dymerDomainName") != null) {
			dymerDomainName = (String) serviceContext.getAttribute("dymerDomainName");
		}
		dymer.setName(dymerDomainName);
		dymerPersistence.update(dymer);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(serviceContext.getUserId(), groupId,
				entry.getCreateDate(), entry.getModifiedDate(), DymerEntry.class.getName(), entryId, entry.getUuid(), 0,
				serviceContext.getAssetCategoryIds(), new String[] { index }, true, true, null, null, null, null,
				ContentTypes.TEXT_HTML, entry.getTitle(), entry.getExtContent(), entry.getTitle(), null, null, 0, 0,
				null);

		if (_log.isDebugEnabled())
			_log.debug("generated assetEntry");

		assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);

		if (_log.isDebugEnabled())
			_log.debug("generated assetLink");

		resourceLocalService.addResources(user.getCompanyId(), groupId, serviceContext.getUserId(),
				DymerEntry.class.getName(), entryId, false, true, true);

		if (_log.isDebugEnabled())
			_log.debug("generated permission");

		sendNotifications(entry, getNotificationType(Constants.ADD), entry.getTitle(), entry.getExtContent(), user, portletId, serviceContext);

		return entry;
	}

	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry updateDymerEntry(long dymerId, long entryId, String index, String type, String id, String url,
			String title, String extContent, ServiceContext serviceContext) throws PortalException, SystemException {

		Date now = new Date();

		DymerEntry entry = dymerEntryPersistence.findByPrimaryKey(entryId);

		User user = userLocalService.getUserById(serviceContext.getUserId());

		entry.setUserId(serviceContext.getUserId());
		entry.setUserName(user.getFullName());
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setIndex(index);
		entry.setType(type);
		entry.setId(id);
		if (url.isEmpty()) {
			url = "#";
		}
		entry.setUrl(url);
		entry.setTitle(title);
		entry.setExtContent(extContent);
		// entry.setExpandoBridgeAttributes(serviceContext);

		if (_log.isDebugEnabled()) {
			_log.debug("DymerEntryLocalServiceImpl, updateDymerEntry method-----------------------------");
			_log.debug("dymerId: " + dymerId);
			_log.debug("dymerEntryId: " + entryId);
			_log.debug("userId: " + serviceContext.getUserId());
			_log.debug("companyId: " + user.getCompanyId());
			_log.debug("userName: " + user.getFullName());
			_log.debug("createDate: " + now.toString());
			_log.debug("modifiedDate: " + now.toString());
			_log.debug("dymerId: " + dymerId);

			_log.debug("index: " + index);
			_log.debug("type: " + type);
			_log.debug("id: " + id);
			_log.debug("url: " + url);
		}

		entry = dymerEntryPersistence.update(entry);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(serviceContext.getUserId(),
				serviceContext.getScopeGroupId(), entry.getCreateDate(), entry.getModifiedDate(),
				DymerEntry.class.getName(), entryId, entry.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				new String[] { index }, true, true, entry.getCreateDate(), null, null, null, ContentTypes.TEXT_HTML,
				entry.getTitle(), entry.getExtContent(), entry.getTitle(), null, null, 0, 0,
				serviceContext.getAssetPriority());

		if (_log.isDebugEnabled())
			_log.debug("generated assetEntry");

		assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);

		if (_log.isDebugEnabled())
			_log.debug("generated assetLink");

		sendNotifications(entry, getNotificationType(Constants.UPDATE), entry.getTitle(), entry.getExtContent(), user, portletId, serviceContext);

		return entry;
	}

	@Indexable(type = IndexableType.DELETE)
	public DymerEntry deleteDymerEntry(DymerEntry entry) throws PortalException, SystemException {

		if (_log.isDebugEnabled()) {
			_log.debug("DymerEntryLocalServiceImpl, deleteDymerEntry method");
			_log.debug("entryId " + entry.getEntryId());
		}

		ServiceContext sc = new ServiceContext();
		// sc.setUuid(UUID.randomUUID().toString());
		Date now = new Date();
		sc.setCreateDate(now);
		sc.setModifiedDate(now);
		sc.setAssetCategoryIds(new long[] {});
		sc.setAssetTagNames(new String[] { entry.getType() });
		sc.setAssetLinkEntryIds(new long[] {});

		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(DymerEntry.class.getName(), entry.getEntryId());

		dymerEntryPersistence.remove(entry);

		if (_log.isDebugEnabled())
			_log.debug("removed assetEntry");

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		if (_log.isDebugEnabled())
			_log.debug("removed assetLink");

		try {
			assetEntryLocalService.deleteEntry(assetEntry);
		} catch (PortalException e) {
			long assetEntryId = 0;
			if (assetEntry != null) {
				assetEntryId = assetEntry.getEntryId();
			}
			_log.error("An error occurred while deleting asseEntry " + assetEntryId);
			_log.error(e, e);
		}

		User user = UserLocalServiceUtil.getUser(entry.getUserId());

		sendNotifications(entry, getNotificationType(Constants.DELETE), entry.getTitle(), entry.getExtContent(), user, portletId, sc);

		return entry;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public DymerEntry v2DeleteDymerEntry(DymerEntry entry, User user) throws PortalException, SystemException {

		if (_log.isDebugEnabled()) {
			_log.debug("DymerEntryLocalServiceImpl, deleteDymerEntry method");
			_log.debug("entryId " + entry.getEntryId());
		}

		ServiceContext sc = new ServiceContext();
		// sc.setUuid(UUID.randomUUID().toString());
		Date now = new Date();
		sc.setCreateDate(now);
		sc.setModifiedDate(now);
		sc.setAssetCategoryIds(new long[] {});
		sc.setAssetTagNames(new String[] { entry.getType() });
		sc.setAssetLinkEntryIds(new long[] {});

		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(DymerEntry.class.getName(), entry.getEntryId());

		dymerEntryPersistence.remove(entry);

		if (_log.isDebugEnabled())
			_log.debug("removed assetEntry");

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		if (_log.isDebugEnabled())
			_log.debug("removed assetLink");

		try {
			assetEntryLocalService.deleteEntry(assetEntry);
		} catch (PortalException e) {
			long assetEntryId = 0;
			if (assetEntry != null) {
				assetEntryId = assetEntry.getEntryId();
			}
			_log.error("An error occurred while deleting asseEntry " + assetEntryId);
			_log.error(e, e);
		}
		
		sendNotifications(entry, getNotificationType(Constants.DELETE), entry.getTitle(), entry.getExtContent(), user, portletId, sc);

		return entry;
	}

	@Indexable(type = IndexableType.DELETE)
	public DymerEntry deleteDymerEntry(long entryId, long userId) throws PortalException, SystemException {
		DymerEntry entry = dymerEntryPersistence.findByPrimaryKey(entryId);

		return deleteDymerEntry(entry);
	}

	public DymerEntry deleteDymerEntry(long entryId) throws PortalException, SystemException {

		DymerEntry entry = dymerEntryPersistence.findByPrimaryKey(entryId);

		return deleteDymerEntry(entry);
	}

	public List<DymerEntry> getDymerEntries(long groupId, long dymerId) {
		return dymerEntryPersistence.findByG_D(groupId, dymerId);
	}

	public List<DymerEntry> getDymerEntries(long groupId, long dymerId, int start, int end)
			throws PortalException, SystemException {
		return dymerEntryPersistence.findByG_D(groupId, dymerId, start, end);
	}

	public List<DymerEntry> getDymerEntries(long groupId, long dymerId, int start, int end,
			OrderByComparator<DymerEntry> obc) {
		return dymerEntryPersistence.findByG_D(groupId, dymerId, start, end, obc);
	}

	public DymerEntry getDymerEntry(long entryId) throws PortalException, SystemException {
		return dymerEntryPersistence.findByPrimaryKey(entryId);
	}

	public int getDymerEntriesCount(long groupId, long dymerId) {
		return dymerEntryPersistence.countByG_D(groupId, dymerId);
	}

	public int getNotificationType(String cmd) {
		_log.debug("cmd: " + cmd);
		int notificationType;
		switch (cmd) {
		case Constants.ADD:
			notificationType = DymerUserNotificationDefinition.NOTIFICATION_TYPE_ADD_ENTRY;
			break;
		case Constants.UPDATE:
			notificationType = DymerUserNotificationDefinition.NOTIFICATION_TYPE_UPDATE_ENTRY;
			break;
		case Constants.DELETE:
			notificationType = DymerUserNotificationDefinition.NOTIFICATION_TYPE_DELETE_ENTRY;
			break;
		case DymerServicePropsKeys.PERSONAL:
			notificationType = DymerUserNotificationDefinition.NOTIFICATION_TYPE_PERSONAL_ENTRY;
			break;
		case DymerServicePropsKeys.ROLE:
			notificationType = DymerUserNotificationDefinition.NOTIFICATION_TYPE_ROLE_ENTRY;
			break;
		case DymerServicePropsKeys.TEAM:
			notificationType = DymerUserNotificationDefinition.NOTIFICATION_TYPE_TEAM_ENTRY;
			break;
		default:
			throw new IllegalArgumentException("Invalid cmd: " + cmd);
		}
		return notificationType;
	}
	
	private String[] getNotificationParams() throws PortalException {
		
		List<PortalPreferences> portalPreferences = PortalPreferencesLocalServiceUtil.getPortalPreferenceses(0,
				PortalPreferencesLocalServiceUtil.getPortalPreferencesesCount());
		String fromAddress = StringPool.BLANK;
		for (PortalPreferences pp : portalPreferences) {
			if (fromAddress.isEmpty()) {
				pp.getPortalPreferencesId();
				try {
					String xml = pp.getPreferences();
					if (_log.isDebugEnabled())
						_log.debug("xml:" + xml);
					Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder()
							.parse(new InputSource(new StringReader(xml)));
					Element docEle = dom.getDocumentElement();
					NodeList nl = docEle.getChildNodes();
					int length = nl.getLength();
					for (int i = 0; i < length; i++) {
						if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
							Element el = (Element) nl.item(i);
							if (el.getNodeName().contains("preference")) {
								String name = el.getElementsByTagName("name").item(0).getTextContent();
								if (name.equalsIgnoreCase(DymerServicePropsKeys.MAIL_SMTP_USER)) {
									fromAddress = el.getElementsByTagName("value").item(0).getTextContent();
									if (_log.isDebugEnabled())
										_log.debug("mail.session.mail.smtp.user: "
												+ el.getElementsByTagName("value").item(0).getTextContent());
									continue;
								}
							}
						}
					}
				} catch (SAXException e) {
					_log.error("SAXException in sendNotifications method: " + e.getMessage());
				} catch (IOException e) {
					_log.error("IOException in sendNotifications method: " + e.getMessage());
				} catch (ParserConfigurationException e) {
					_log.error("ParserConfigurationException in sendNotifications method: " + e.getMessage());
				}
			} else {
				continue;
			}

		}

		String fromName = GetterUtil.getString(PropsUtil.get(DymerServicePropsKeys.DEFAULT_PORTAL_NAME),
				StringPool.BLANK);
		String portalUrl = GetterUtil.getString(PropsUtil.get(DymerServicePropsKeys.DEFAULT_PORTAL_URL),
				StringPool.BLANK);

		if (_log.isDebugEnabled()) {
			_log.debug("mail.session.mail.smtp.user: " + fromAddress);
			_log.debug("default.portal.url: " + portalUrl);
			_log.debug("default.portal.name: " + fromName);
		}
		return new String[]{fromAddress, fromName, portalUrl};
	}

	/***************************************************************************************************************************
	 * notifications v1
	 * */
	private void sendNotifications(
			DymerEntry entry,
			int notificationType,
			String title, 
			String description, 
			User sender,
			String portletId,
			ServiceContext serviceContext) throws PortalException {
		
		_log.debug("sendNotifications method, notificationType: " + String.valueOf(notificationType));
		List<User> recipients = new ArrayList<User>();
		
		if (notificationType < 3) {
			recipients = userLocalService.getCompanyUsers(entry.getCompanyId(), 0, userLocalService.getCompanyUsersCount(entry.getCompanyId()));
			sendToRecipients(recipients, entry, notificationType, title, description, sender, portletId, serviceContext);
		}
	}
	
	protected void sendToRecipients(
			List<User> recipients, 
			DymerEntry entry, 
			int notificationType, 
			String title,
			String description, 
			User sender,
			String portletId,
			ServiceContext serviceContext) throws PortalException {

		String[] notificationData = getNotificationParams();
		String fromAddress = notificationData[0];
		String fromName = notificationData[1];
		String portalUrl = notificationData[2];
		
		long classNameId = 0;
		long companyId = 0;
		long groupId = 0;
		long entryId = 0;
		long userId = 0;
		String id = "0";
		String fullName = StringPool.BLANK;
		
		if (sender != null) {
			companyId = sender.getCompanyId();
			userId = sender.getUserId();
			fullName = sender.getFullName();
		}
		
		if (entry != null) {
			groupId = entry.getGroupId();
			entryId = entry.getEntryId();
			id = entry.getId();
		}

		for (User recipient : recipients) {
			long recipientUserId = recipient.getUserId();
			if (recipient.isActive() && !(recipient.isDefaultUser()) && (recipientUserId != sender.getUserId())) {
				if (_log.isDebugEnabled())
					_log.debug("recipient: " + recipient.getEmailAddress() + " [recipientUserId: " + recipient.getUserId()+"]");
				
				if (UserNotificationManagerUtil.isDeliver(recipientUserId, portletId, classNameId, notificationType, UserNotificationDeliveryConstants.TYPE_WEBSITE)) {
					_log.debug("sender: " + fullName);
					notifyByWebsite(recipientUserId, notificationType, title, description, userId, groupId, companyId, fullName, entryId, DymerEntry.class.getName(), portletId, StringPool.BLANK, StringPool.BLANK, serviceContext);
				}
				
				if (UserNotificationManagerUtil.isDeliver(recipientUserId, portletId, classNameId, notificationType, UserNotificationDeliveryConstants.TYPE_EMAIL)) {
					notifyByEmail(recipientUserId, notificationType, title, description, userId, groupId, companyId, fullName, entryId,	DymerEntry.class.getName(), portletId, fromAddress, fromName, portalUrl, id);
				}
			}
		}
	}

	protected void notifyByWebsite(
			long destinationUserId, 
			int notificationType, 
			String title, 
			String extContent,
			long userId, 
			long groupId, 
			long companyId, 
			String fullName, 
			long classPK, 
			String className,
			String portletId,
			String portalUrl,
			String resourceLink,
			ServiceContext serviceContext) {

		Map<Integer, String> map = new HashMap<>();
		map.put(DymerUserNotificationDefinition.NOTIFICATION_TYPE_ADD_ENTRY, Constants.ADD);
		map.put(DymerUserNotificationDefinition.NOTIFICATION_TYPE_UPDATE_ENTRY, Constants.UPDATE);
		map.put(DymerUserNotificationDefinition.NOTIFICATION_TYPE_DELETE_ENTRY, Constants.DELETE);
		map.put(DymerUserNotificationDefinition.NOTIFICATION_TYPE_PERSONAL_ENTRY, DymerServicePropsKeys.PERSONAL);
		map.put(DymerUserNotificationDefinition.NOTIFICATION_TYPE_ROLE_ENTRY, DymerServicePropsKeys.ROLE);
		map.put(DymerUserNotificationDefinition.NOTIFICATION_TYPE_TEAM_ENTRY, DymerServicePropsKeys.TEAM);

		JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();
		notificationEventJSONObject.put("title", title);
		notificationEventJSONObject.put("description", extContent);
		notificationEventJSONObject.put("companyId", companyId);
		notificationEventJSONObject.put("groupId", groupId);
		notificationEventJSONObject.put("userId", userId);
		notificationEventJSONObject.put("sender", fullName);
		notificationEventJSONObject.put("type", className);
		notificationEventJSONObject.put("classPK", classPK);
		notificationEventJSONObject.put("notificationType", notificationType);
		notificationEventJSONObject.put("cmd", map.get(notificationType));
		
		notificationEventJSONObject.put("portalUrl", portalUrl);
		notificationEventJSONObject.put("resourceLink", resourceLink);

		NotificationEvent notificationEvent = NotificationEventFactoryUtil
				.createNotificationEvent(System.currentTimeMillis(), portletId, notificationEventJSONObject);
		notificationEvent.setDeliveryType(UserNotificationDeliveryConstants.TYPE_WEBSITE);
		notificationEvent.setDeliverBy(userId);
		try {
			if (_log.isDebugEnabled())
				_log.debug(fullName + "(userId: " + userId + ") has sent a WEBSITE notification to userId: " + destinationUserId);
			_userNotificationEventLocalService.addUserNotificationEvent(destinationUserId, portletId,
					System.currentTimeMillis(), UserNotificationDeliveryConstants.TYPE_WEBSITE, userId,
					notificationEventJSONObject.toString(), false, serviceContext);
		} catch (Exception e) {
			_log.error("Error in notifyByWebsite method: " + e.getMessage());
		}
	}

	protected void notifyByEmail(
			long destinationUserId, 
			int notificationType, 
			String title, 
			String description,
			long currentUserId, 
			long groupId, 
			long companyId, 
			String fullName, 
			long classPK, 
			String className,
			String portletId, 
			String fromAddress, 
			String fromName, 
			String portalUrl,
			String _id) {

		try {
			Map<Integer, String> map = new HashMap<>();

			map.put(DymerUserNotificationDefinition.NOTIFICATION_TYPE_ADD_ENTRY,
					LanguageUtil.format(_resourceBundle, "new-catalogue-resource-in-x", new Object[] { fromName }));
			map.put(DymerUserNotificationDefinition.NOTIFICATION_TYPE_UPDATE_ENTRY,
					LanguageUtil.format(_resourceBundle, "catalogue-resource-updated-in-x", new Object[] { fromName }));
			map.put(2, LanguageUtil.format(_resourceBundle, "catalogue-deleted-in-x", new Object[] { fromName }));

			Map<Integer, String> map2 = new HashMap<>();
			map2.put(DymerUserNotificationDefinition.NOTIFICATION_TYPE_ADD_ENTRY, "added");
			map2.put(DymerUserNotificationDefinition.NOTIFICATION_TYPE_UPDATE_ENTRY, "updated");
			map2.put(DymerUserNotificationDefinition.NOTIFICATION_TYPE_DELETE_ENTRY, "deleted");

			SubscriptionSender subscriptionSender = new SubscriptionSender();
			if (!(fromName.isEmpty()) && !(portalUrl.isEmpty())) {
				subscriptionSender.setSubject(map.get(notificationType));

				String header = LanguageUtil.format(_resourceBundle,
						"the-user-x-has-y-the-following-catalogue-resource",
						new Object[] { fullName, map2.get(notificationType) });
				String resourceTitle = title;
				
				if (notificationType == DymerUserNotificationDefinition.NOTIFICATION_TYPE_ADD_ENTRY || 
						notificationType == DymerUserNotificationDefinition.NOTIFICATION_TYPE_UPDATE_ENTRY)
					
					resourceTitle = "<a href=\"" + portalUrl + "/group/guest/catalogue-detail?id=" + _id + "\">" + title + "</a>";
				
				_log.debug("resourceTitle: " + resourceTitle);

				String body = "<p><b>" + header + StringPool.SPACE + resourceTitle + "</b></p>"
						+ "<div style=\" background-color: #e1e4ea;\">" + description + "<div>";
				
				subscriptionSender.setBody(body);
				subscriptionSender.setFrom(fromAddress, fromName);
				subscriptionSender.setCompanyId(companyId);
				subscriptionSender.setGroupId(groupId);
				subscriptionSender.setCurrentUserId(currentUserId);
				subscriptionSender.setClassName(className);
				subscriptionSender.setClassPK(classPK);
				subscriptionSender.setNotificationType(notificationType);
				subscriptionSender.setHtmlFormat(true);
				subscriptionSender.setPortletId(portletId);
				
			} else {
				throw new Exception("configure portal-ext.properties with default.portal.name and default.portal.url");
			}

			if (_log.isDebugEnabled())
				_log.debug(fromAddress + " has sent an E-MAIL notification to userId: " + destinationUserId);
			subscriptionSender.sendEmailNotification(destinationUserId);
		} catch (Exception e) {
			_log.error("Error in notifyByEmail method: " + e.getMessage());
		}
	}
	
	/***************************************************************************************************************************
	 * notifications v2
	 * */
	
	public void v2SendNotifications(
			List<User> recipients,
			DymerEntry entry,
			String resourceLink,
			int notificationType,
			String title, 
			String description, 
			User sender,
			String portletId,
			ServiceContext serviceContext) throws PortalException {
		
		_log.debug("v2SendNotifications method, notificationType: " + String.valueOf(notificationType));
		
		if (notificationType >= 3) {
			v2SendToRecipients(recipients, entry, resourceLink, notificationType, title, description, sender, portletId, serviceContext);
		}
	}
	
	protected void v2SendToRecipients(
			List<User> recipients, 
			DymerEntry entry,
			String resourceLink,
			int notificationType, 
			String title,
			String description, 
			User sender,
			String portletId,
			ServiceContext serviceContext) throws PortalException {

		_log.debug("v2SendToRecipients method");
		
		String[] notificationData = getNotificationParams();
		String fromAddress = notificationData[0];
		String fromName = notificationData[1];
		String portalUrl = notificationData[2];
		
		long classNameId = 0;
		long companyId = 0;
		long groupId = 0;
		long entryId = 0;
		long userId = 0;
		String id = "0";
		String fullName = StringPool.BLANK;
		
		if (sender != null) {
			companyId = sender.getCompanyId();
			userId = sender.getUserId();
			fullName = sender.getFullName();
		}
		
		if (entry != null) {
			groupId = entry.getGroupId();
			entryId = entry.getEntryId();
			id = entry.getId();
		}

		for (User recipient : recipients) {
			long recipientUserId = recipient.getUserId();
			if (recipient.isActive() && !(recipient.isDefaultUser()) && (recipientUserId != sender.getUserId())) {
				if (_log.isDebugEnabled())
					_log.debug("recipient: " + recipient.getEmailAddress() + " [recipientUserId: " + recipient.getUserId()+"]");
				
				if (UserNotificationManagerUtil.isDeliver(recipientUserId, portletId, classNameId, notificationType, UserNotificationDeliveryConstants.TYPE_WEBSITE)) {
					_log.debug("sender: " + fullName);
					notifyByWebsite(recipientUserId, notificationType, title, description, userId, groupId, companyId, 
							fullName, entryId, DymerEntry.class.getName(), portletId, portalUrl, resourceLink, serviceContext);
				}
				
				if (UserNotificationManagerUtil.isDeliver(recipientUserId, portletId, classNameId, notificationType, UserNotificationDeliveryConstants.TYPE_EMAIL)) {
					v2NotifyByEmail(recipientUserId, notificationType, title, description, userId, groupId, companyId, 
							fullName, entryId, DymerEntry.class.getName(), portletId, fromAddress, fromName, portalUrl, resourceLink, id);
				}
			}
		}
	}
	
	protected void v2NotifyByEmail(
			long destinationUserId, 
			int notificationType, 
			String title, 
			String description,
			long currentUserId, 
			long groupId, 
			long companyId, 
			String fullName, 
			long classPK, 
			String className,
			String portletId, 
			String fromAddress, 
			String fromName, 
			String portalUrl,
			String resourceLink,
			String _id) {

		try {
			SubscriptionSender subscriptionSender = new SubscriptionSender();
			if (!(fromName.isEmpty()) && !(portalUrl.isEmpty())) {
				String resourceTitle = title;
				
				if (notificationType >= 3) {
					
					//HOW TO COMPOSE LINK
					String link1;
					//String link2;
					
					if (_id.equalsIgnoreCase("0")) {
						link1 = portalUrl + "/group/guest/catalogue-detail?id=" + _id;
						resourceTitle = "<a href=\"" + link1 + "\">" + title + "</a>";
					}
					if (Validator.isNotNull(resourceLink)) {
						//link2 = portalUrl + resourceLink;
						resourceTitle = "<a href=\"" + resourceLink + "\">" + title + "</a>";
					}

					String body = "<p><b>" + resourceTitle + "</b></p>"
							+ "<div style=\" background-color: #e1e4ea;\">" + description + "<div>";
					
					_log.debug("body: " + body);
					
					subscriptionSender.setBody(body);
					subscriptionSender.setFrom(fromAddress, fromName);
					subscriptionSender.setCompanyId(companyId);
					subscriptionSender.setGroupId(groupId);
					subscriptionSender.setCurrentUserId(currentUserId);
					subscriptionSender.setClassName(className);
					subscriptionSender.setClassPK(classPK);
					subscriptionSender.setNotificationType(notificationType);
					subscriptionSender.setHtmlFormat(true);
					subscriptionSender.setPortletId(portletId);
					subscriptionSender.setSubject(title);
				}
				
			} else {
				throw new Exception("configure portal-ext.properties with default.portal.name and default.portal.url");
			}

			if (_log.isDebugEnabled())
				_log.debug(fromAddress + " has sent an E-MAIL notification to userId: " + destinationUserId);
			subscriptionSender.sendEmailNotification(destinationUserId);
			
		} catch (Exception e) {
			_log.error("Error in notifyByEmail method: " + e.getMessage());
		}
	}
	
	/********************************************************************************************************
	 * Old local services
	 */

	@Deprecated
	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry addDymerEntry(long dymerId, long userId, String index, String type, String id, String url,
			String title, String extContent, ServiceContext serviceContext) throws PortalException, SystemException {

		_log.info("DymerEntryLocalServiceImpl, addDymerEntry method");

		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(userId);

		Date now = new Date();

		long entryId = counterLocalService.increment();

		DymerEntry entry = dymerEntryPersistence.create(entryId);

		entry.setUuid(serviceContext.getUuid());
		entry.setUserId(userId);
		entry.setGroupId(groupId);
		entry.setCompanyId(user.getCompanyId());
		entry.setUserName(user.getFullName());
		entry.setCreateDate(serviceContext.getCreateDate(now));
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setDymerId(dymerId);

		entry.setIndex(index);
		entry.setType(type);
		entry.setId(id);
		if (url.isEmpty()) {
			url = "#";
		}
		entry.setUrl(url);
		entry.setTitle(title);
		entry.setExtContent(extContent);

		if (_log.isDebugEnabled()) {
			_log.debug("uuid: " + serviceContext.getUuid());
			_log.debug("userId: " + userId);
			_log.debug("groupId: " + groupId);
			_log.debug("companyId: " + user.getCompanyId());
			_log.debug("userName: " + user.getFullName());
			_log.debug("createDate: " + now.toString());
			_log.debug("modifiedDate: " + now.toString());
			_log.debug("dymerId: " + dymerId);
			_log.debug("index: " + index);
			_log.debug("type: " + type);
			_log.debug("id: " + id);
			_log.debug("url: " + url);
		}

		dymerEntryPersistence.update(entry);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, groupId, entry.getCreateDate(),
				entry.getModifiedDate(), DymerEntry.class.getName(), entryId, entry.getUuid(), 0,
				serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, true, null, null, null,
				null, ContentTypes.TEXT_HTML, entry.getExtContent(), null, null, null, null, 0, 0, null);

		if (_log.isDebugEnabled())
			_log.debug("generated assetEntry");

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);
		if (_log.isDebugEnabled())
			_log.debug("generated assetLink");

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, DymerEntry.class.getName(), entryId,
				false, true, true);

		if (_log.isDebugEnabled())
			_log.debug("generated permission");
		return entry;
	}

	@Deprecated
	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry updateDymerEntry(long dymerId, long userId, long entryId, String index, String type, String id,
			String url, String title, String extContent, ServiceContext serviceContext)
			throws PortalException, SystemException {

		_log.info("DymerEntryLocalServiceImpl, updateDymerEntry method");

		Date now = new Date();

		DymerEntry entry = dymerEntryPersistence.findByPrimaryKey(entryId);

		User user = userLocalService.getUserById(userId);

		entry.setUserId(userId);
		entry.setUserName(user.getFullName());
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setIndex(index);
		entry.setType(type);
		entry.setId(id);
		if (url.isEmpty()) {
			url = "#";
		}
		entry.setUrl(url);
		entry.setTitle(title);
		entry.setExtContent(extContent);

		if (_log.isDebugEnabled()) {
			_log.debug("dymerId: " + dymerId);
			_log.debug("dymerEntryId: " + entryId);
			_log.debug("userId: " + userId);
			_log.debug("companyId: " + user.getCompanyId());
			_log.debug("userName: " + user.getFullName());
			_log.debug("createDate: " + now.toString());
			_log.debug("modifiedDate: " + now.toString());
			_log.debug("dymerId: " + dymerId);
			_log.debug("index: " + index);
			_log.debug("type: " + type);
			_log.debug("id: " + id);
			_log.debug("url: " + url);
		}

		dymerEntryPersistence.update(entry);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, serviceContext.getScopeGroupId(),
				entry.getCreateDate(), entry.getModifiedDate(), DymerEntry.class.getName(), entryId, entry.getUuid(), 0,
				serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, true,
				entry.getCreateDate(), null, null, null, ContentTypes.TEXT_HTML, entry.getExtContent(), null, null,
				null, null, 0, 0, serviceContext.getAssetPriority());

		if (_log.isDebugEnabled())
			_log.debug("generated assetEntry");

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		if (_log.isDebugEnabled())
			_log.debug("generated assetLink");

		return entry;
	}
	

	@Reference
	private UserNotificationEventLocalService _userNotificationEventLocalService;

	private static final Log _log = LogFactoryUtil.getLog(DymerEntryLocalServiceImpl.class);
}