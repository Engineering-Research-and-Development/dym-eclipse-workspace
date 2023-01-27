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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.notifications.NotificationEvent;
import com.liferay.portal.kernel.notifications.NotificationEventFactoryUtil;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.notifications.UserNotificationManagerUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SubscriptionSender;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.dymer.model.Dymer;
import it.eng.rd.dymer.model.DymerEntry;
import it.eng.rd.dymer.service.base.DymerEntryLocalServiceBaseImpl;
import it.eng.rd.dymer.service.constants.DymerServicePropsKeys;
import java.util.ResourceBundle;

@Component(
	property = "model.class.name=it.eng.rd.dymer.model.DymerEntry",
	service = AopService.class
)
public class DymerEntryLocalServiceImpl extends DymerEntryLocalServiceBaseImpl {
	
	private final String portletId = "it_eng_rd_dymer_portlet_DymerPortlet";
	
	private final ResourceBundle _resourceBundle = ResourceBundle.getBundle("content/Language", new Locale(Locale.getDefault().toString(), Locale.getDefault().getDisplayCountry()));

	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry addDymerEntry(
			long dymerId,
			String index,
			String type,
			String id,
			String url,
			String title,
			String extContent,
			ServiceContext serviceContext
	)
		throws PortalException, SystemException {
		
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
			
			_log.debug("uuid: " +serviceContext.getUuid());
			_log.debug("userId: " +serviceContext.getUserId());
			_log.debug("groupId: " +groupId);
			_log.debug("companyId: " +user.getCompanyId());
			_log.debug("userName: " +user.getFullName());
			_log.debug("createDate: " +now.toString());
			_log.debug("modifiedDate: " +now.toString());
			_log.debug("dymerId: " +dymerId);
			
			_log.debug("index: " +index);
			_log.debug("type: " +type);
			_log.debug("id: " +id);
			_log.debug("url: " +url);
		}
		
		entry = dymerEntryPersistence.update(entry);
		
		Dymer dymer = dymerPersistence.fetchByPrimaryKey(dymerId);
		String dymerDomainName = "";
		if (serviceContext.getAttribute("dymerDomainName")!=null) {
			dymerDomainName = (String) serviceContext.getAttribute("dymerDomainName");
		}
		dymer.setName(dymerDomainName);
		dymerPersistence.update(dymer);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(serviceContext.getUserId(),
                groupId, entry.getCreateDate(), entry.getModifiedDate(),
                DymerEntry.class.getName(), entryId, entry.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, true, null, null, null, null,
                ContentTypes.TEXT_HTML, entry.getTitle(), entry.getExtContent(), entry.getTitle(), null,
                null, 0, 0, null);
		
		if (_log.isDebugEnabled()) 
			_log.debug("generated assetEntry");

		assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
		                serviceContext.getAssetLinkEntryIds(),
		                AssetLinkConstants.TYPE_RELATED);
		
		if (_log.isDebugEnabled()) 
			_log.debug("generated assetLink");
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, serviceContext.getUserId(),
			    DymerEntry.class.getName(), entryId, false, true, true);

		if (_log.isDebugEnabled()) 
			_log.debug("generated permission");
		
		sendNotifications(entry, entry.getTitle(), entry.getExtContent(), user, portletId, getNotificationType(Constants.ADD), serviceContext);
		
		return entry;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry updateDymerEntry(
			long dymerId,
			long entryId,
			String index,
			String type,
			String id,
			String url,
			String title,
			String extContent,
			ServiceContext serviceContext
	)
		throws PortalException, SystemException {
		
		

		Date now = new Date();

		DymerEntry entry =
			dymerEntryPersistence.findByPrimaryKey(entryId);
		
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
		//entry.setExpandoBridgeAttributes(serviceContext);
		
		if (_log.isDebugEnabled()) {
			_log.debug("DymerEntryLocalServiceImpl, updateDymerEntry method-----------------------------");
			_log.debug("dymerId: " +dymerId);
			_log.debug("dymerEntryId: " +entryId);
			_log.debug("userId: " +serviceContext.getUserId());
			_log.debug("companyId: " +user.getCompanyId());
			_log.debug("userName: " +user.getFullName());
			_log.debug("createDate: " +now.toString());
			_log.debug("modifiedDate: " +now.toString());
			_log.debug("dymerId: " +dymerId);
			
			_log.debug("index: " +index);
			_log.debug("type: " +type);
			_log.debug("id: " +id);
			_log.debug("url: " +url);
		}

		entry = dymerEntryPersistence.update(entry);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(serviceContext.getUserId(),
	              serviceContext.getScopeGroupId(),
	              entry.getCreateDate(), entry.getModifiedDate(),
	              DymerEntry.class.getName(), entryId, entry.getUuid(),
	              0, serviceContext.getAssetCategoryIds(),
	              serviceContext.getAssetTagNames(), true, true,
	              entry.getCreateDate(), null, null, null,
	              ContentTypes.TEXT_HTML, entry.getTitle(), entry.getExtContent(),
	              entry.getTitle(), null, null, 0, 0,
	              serviceContext.getAssetPriority());
		
		if (_log.isDebugEnabled()) 
			_log.debug("generated assetEntry");
	
		assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
		              serviceContext.getAssetLinkEntryIds(),
		              AssetLinkConstants.TYPE_RELATED);
		
		if (_log.isDebugEnabled()) 
			_log.debug("generated assetLink");
				
		sendNotifications(entry, title, extContent, user, portletId, getNotificationType(Constants.UPDATE), serviceContext);
		
		return entry;
	}
	
	/********************************************************************************************************
	 * Old local services
	 */
	
	@Deprecated
	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry addDymerEntry(
			long dymerId,
			long userId,
			String index,
			String type,
			String id,
			String url,
			String title,
			String extContent,
			ServiceContext serviceContext
	)
		throws PortalException, SystemException {
		
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
			_log.debug("uuid: " +serviceContext.getUuid());
			_log.debug("userId: " +userId);
			_log.debug("groupId: " +groupId);
			_log.debug("companyId: " +user.getCompanyId());
			_log.debug("userName: " +user.getFullName());
			_log.debug("createDate: " +now.toString());
			_log.debug("modifiedDate: " +now.toString());
			_log.debug("dymerId: " +dymerId);
			_log.debug("index: " +index);
			_log.debug("type: " +type);
			_log.debug("id: " +id);
			_log.debug("url: " +url);
		}
		
		
		dymerEntryPersistence.update(entry);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
                groupId, entry.getCreateDate(), entry.getModifiedDate(),
                DymerEntry.class.getName(), entryId, entry.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, true, null, null, null, null,
                ContentTypes.TEXT_HTML, entry.getExtContent(), null, null, null,
                null, 0, 0, null);
		
		if (_log.isDebugEnabled())
			_log.debug("generated assetEntry");

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
		                serviceContext.getAssetLinkEntryIds(),
		                AssetLinkConstants.TYPE_RELATED);
		if (_log.isDebugEnabled())
			_log.debug("generated assetLink");
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			    DymerEntry.class.getName(), entryId, false, true, true);

		if (_log.isDebugEnabled())
			_log.debug("generated permission");
		return entry;
	}
	
	@Deprecated
	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry updateDymerEntry(
			long dymerId,
			long userId,
			long entryId,
			String index,
			String type,
			String id,
			String url,
			String title,
			String extContent,
			ServiceContext serviceContext
	)
		throws PortalException, SystemException {
		
		_log.info("DymerEntryLocalServiceImpl, updateDymerEntry method");

		Date now = new Date();

		DymerEntry entry =
			dymerEntryPersistence.findByPrimaryKey(entryId);
		
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
			_log.debug("dymerId: " +dymerId);
			_log.debug("dymerEntryId: " +entryId);
			_log.debug("userId: " +userId);
			_log.debug("companyId: " +user.getCompanyId());
			_log.debug("userName: " +user.getFullName());
			_log.debug("createDate: " +now.toString());
			_log.debug("modifiedDate: " +now.toString());
			_log.debug("dymerId: " +dymerId);
			_log.debug("index: " +index);
			_log.debug("type: " +type);
			_log.debug("id: " +id);
			_log.debug("url: " +url);
		}

		dymerEntryPersistence.update(entry);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
	              serviceContext.getScopeGroupId(),
	              entry.getCreateDate(), entry.getModifiedDate(),
	              DymerEntry.class.getName(), entryId, entry.getUuid(),
	              0, serviceContext.getAssetCategoryIds(),
	              serviceContext.getAssetTagNames(), true, true,
	              entry.getCreateDate(), null, null, null,
	              ContentTypes.TEXT_HTML, entry.getExtContent(), null,
	              null, null, null, 0, 0,
	              serviceContext.getAssetPriority());
		
		if (_log.isDebugEnabled())
			_log.debug("generated assetEntry");
	
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
		              serviceContext.getAssetLinkEntryIds(),
		              AssetLinkConstants.TYPE_RELATED);
		
		if (_log.isDebugEnabled())
			_log.debug("generated assetLink");
		
		return entry;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public DymerEntry deleteDymerEntry(DymerEntry entry) throws PortalException, SystemException {
		
		if (_log.isDebugEnabled()) {
			_log.debug("DymerEntryLocalServiceImpl, deleteDymerEntry method");
			_log.debug("entryId "+entry.getEntryId());
		}
		
		ServiceContext sc = new ServiceContext();
		//sc.setUuid(UUID.randomUUID().toString());
		Date now = new Date();
		sc.setCreateDate(now);
		sc.setModifiedDate(now);
		sc.setAssetCategoryIds(new long[] {});
		sc.setAssetTagNames(new String[] {});
		sc.setAssetLinkEntryIds(new long[] {});
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
                DymerEntry.class.getName(), entry.getEntryId());
		
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
			if (assetEntry!=null) {
				assetEntryId = assetEntry.getEntryId();
			}
			_log.error("An error occurred while deleting asseEntry "+assetEntryId);
			_log.error(e,e);
		}

		User user = UserLocalServiceUtil.getUser(entry.getUserId());
		
		sendNotifications(entry, entry.getTitle(), entry.getExtContent(), user, portletId, getNotificationType(Constants.DELETE), sc);
		
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

	public List<DymerEntry> getDymerEntries(long groupId, long dymerId,
			int start, int end) throws PortalException, SystemException {
		return dymerEntryPersistence.findByG_D(groupId, dymerId, start, end);
	}

	public List<DymerEntry> getDymerEntries(long groupId, long dymerId,
			int start, int end, OrderByComparator<DymerEntry> obc) {
		return dymerEntryPersistence.findByG_D(groupId, dymerId, start, end, obc);
	}

	public DymerEntry getDymerEntry(long entryId) throws PortalException, SystemException {
		return dymerEntryPersistence.findByPrimaryKey(entryId);
	}

	public int getDymerEntriesCount(long groupId, long dymerId) {
		return dymerEntryPersistence.countByG_D(groupId, dymerId);
	}
	
	public int getNotificationType(String cmd) {
		_log.debug("cmd: "+cmd);
	     int notificationType;
	     switch (cmd) {
	         case Constants.ADD:
	        	 notificationType =  UserNotificationDefinition.NOTIFICATION_TYPE_ADD_ENTRY;
	             break;
	         case  Constants.UPDATE:
	        	 notificationType =  UserNotificationDefinition.NOTIFICATION_TYPE_UPDATE_ENTRY;
	             break;
	         case Constants.DELETE:
	        	 notificationType = 2;
	             break;
	         default:
	             throw new IllegalArgumentException("Invalid cmd: " + cmd);
	     }
	     return notificationType;
	}
	
	private void sendNotifications(DymerEntry entry, String title, String extContent, User user, String portletId, int notificationType, ServiceContext serviceContext) throws PortalException {
		_log.debug("sendNotifications method, notificationType: "+String.valueOf(notificationType));
		String fromAddress = GetterUtil.getString(PropsUtil.get(DymerServicePropsKeys.DEFAULT_PORTAL_EMAIL), StringPool.BLANK);
		String fromName = GetterUtil.getString(PropsUtil.get(DymerServicePropsKeys.DEFAULT_PORTAL_NAME), StringPool.BLANK);
		String portalUrl = GetterUtil.getString(PropsUtil.get(DymerServicePropsKeys.DEFAULT_PORTAL_URL), StringPool.BLANK);
		
		if (_log.isDebugEnabled()) {
			_log.debug("fromAddress: "+fromAddress);
			_log.debug("fromName: "+fromName);
		}
		long classNameId =  0;
		List<User> destinationUsers = userLocalService.getCompanyUsers(entry.getCompanyId(), 0, userLocalService.getCompanyUsersCount(entry.getCompanyId()));
		for (User destinationUser : destinationUsers) {
			
			long destinationUserId = destinationUser.getUserId();
			if (destinationUser.isActive() && !(destinationUser.isDefaultUser()) && (destinationUserId!=entry.getUserId())) {
				if (_log.isDebugEnabled())
					_log.debug("destinationUser: "+destinationUser.getEmailAddress() +" destinationUserId: "+destinationUser.getUserId());
				if (UserNotificationManagerUtil.isDeliver(destinationUserId, portletId, classNameId, notificationType, UserNotificationDeliveryConstants.TYPE_WEBSITE)){
					notifyByWebsite(destinationUserId, notificationType, title, extContent, entry.getUserId(), entry.getGroupId(), entry.getCompanyId(), user.getFullName(), entry.getEntryId(),  DymerEntry.class.getName(), portletId, serviceContext);
				}
				if (UserNotificationManagerUtil.isDeliver(destinationUserId, portletId, classNameId, notificationType, UserNotificationDeliveryConstants.TYPE_EMAIL)){
					notifyByEmail(destinationUserId, notificationType, title, extContent, user.getUserId(), entry.getGroupId(), user.getCompanyId(), user.getFullName(), entry.getEntryId(), DymerEntry.class.getName(), portletId, fromAddress, fromName, portalUrl, entry.getId());
				}
			}
		}
	}
	
	protected void notifyByWebsite(long destinationUserId, int notificationType, String title, String extContent,
			long userId, long groupId, long companyId, String fullName, 
			long classPK, String className, String portletId, ServiceContext serviceContext) {
		
		Map<Integer,String> map =  new HashMap<>();
		map.put(UserNotificationDefinition.NOTIFICATION_TYPE_ADD_ENTRY, Constants.ADD);
		map.put(UserNotificationDefinition.NOTIFICATION_TYPE_UPDATE_ENTRY, Constants.UPDATE);
		map.put(2, Constants.DELETE);
		
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
		
		NotificationEvent notificationEvent = NotificationEventFactoryUtil.createNotificationEvent(System.currentTimeMillis(), portletId, notificationEventJSONObject);
		notificationEvent.setDeliveryType(UserNotificationDeliveryConstants.TYPE_WEBSITE);
		notificationEvent.setDeliverBy(userId);
		try {
			if (_log.isDebugEnabled())
				_log.debug(fullName + "(userId: "+userId+") has sent a WEBSITE notification to userId: "+destinationUserId);
			_userNotificationEventLocalService.addUserNotificationEvent(destinationUserId, portletId, System.currentTimeMillis(), UserNotificationDeliveryConstants.TYPE_WEBSITE, userId, notificationEventJSONObject.toString(), false, serviceContext);
		} catch (Exception e) {
			_log.error("Error in notifyByWebsite method: " +e.getMessage());
		}
	}
	
	protected void notifyByEmail(long destinationUserId, int notificationType, String title, String extContent,
			long currentUserId,  
			long groupId, long companyId, String fullName,  
			long classPK, String className, String portletId, String fromAddress, String fromName, String portalUrl, String _id) {
		
		try {
			Map<Integer,String> map =  new HashMap<>();
			
			map.put(UserNotificationDefinition.NOTIFICATION_TYPE_ADD_ENTRY, LanguageUtil.format(_resourceBundle, "new-catalogue-resource-in-x", new Object[] {fromName}));
			map.put(UserNotificationDefinition.NOTIFICATION_TYPE_UPDATE_ENTRY, LanguageUtil.format(_resourceBundle, "catalogue-resource-updated-in-x", new Object[] {fromName}));
			map.put(2, LanguageUtil.format(_resourceBundle, "catalogue-deleted-in-x", new Object[] {fromName}));
			
			Map<Integer,String> map2 =  new HashMap<>();
			map2.put(UserNotificationDefinition.NOTIFICATION_TYPE_ADD_ENTRY, "added");
			map2.put(UserNotificationDefinition.NOTIFICATION_TYPE_UPDATE_ENTRY, "updated");
			map2.put(2, "deleted");
			
			SubscriptionSender subscriptionSender = new SubscriptionSender();
				
			if (!(fromAddress.isEmpty()) && !(fromName.isEmpty()) && !(portalUrl.isEmpty())) {
				subscriptionSender.setSubject(map.get(notificationType));
				
				String header = LanguageUtil.format(_resourceBundle, "the-user-x-has-y-the-following-catalogue-resource", new Object[] {fullName, map2.get(notificationType)});
				String resourceTitle = title;
				if (notificationType!=2)
					resourceTitle = "<a href=\""+portalUrl+"/group/guest/catalogue-detail?id="+_id+"\">"+ title+"</a>";
				
				_log.debug("resourceTitle: "+resourceTitle);
				
				String body = "<p><b>"+header+StringPool.SPACE+resourceTitle+"</b></p>"
						+ "<div style=\" background-color: #e1e4ea;\">"+extContent+"<div>";
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
				throw new Exception("configure portal-ext.properties with default.portal.email, default.portal.name and default.portal.url");
			}
			
			if (_log.isDebugEnabled())
				_log.debug(fromAddress + " has sent an E-MAIL notification to userId: "+destinationUserId);
			subscriptionSender.sendEmailNotification(destinationUserId);
		} catch (Exception e) {
			_log.error("Error in notifyByEmail method: " +e.getMessage());
		}
	}
	
	@Reference
	private UserNotificationEventLocalService
		_userNotificationEventLocalService;

	
	private static final Log _log = LogFactoryUtil.getLog(DymerEntryLocalServiceImpl.class);
}