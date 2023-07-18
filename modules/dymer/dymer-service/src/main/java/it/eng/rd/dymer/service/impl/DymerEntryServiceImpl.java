/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.rd.dymer.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ModelHintsUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.Team;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.TeamLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.dymer.model.DymerEntry;
import it.eng.rd.dymer.service.DymerEntryLocalServiceUtil;
import it.eng.rd.dymer.service.DymerLocalServiceUtil;
import it.eng.rd.dymer.service.base.DymerEntryServiceBaseImpl;
import it.eng.rd.dymer.service.constants.DymerServicePropsKeys;
import it.eng.rd.dymer.service.notifications.DymerUserNotificationDefinition;
import it.eng.rd.dymer.service.persistence.DymerEntryUtil;
import com.liferay.portal.kernel.json.JSONArray;

@Component(
	property = {
		"json.web.service.context.name=dym",
		"json.web.service.context.path=DymerEntry"
	},
	service = AopService.class
)
public class DymerEntryServiceImpl extends DymerEntryServiceBaseImpl {
	
	private final String portletId = "it_eng_rd_dymer_portlet_DymerPortlet";
	
	String catalague_resource_email = GetterUtil.getString(PropsUtil.get(DymerServicePropsKeys.CATALOGUE_RESOURCE_EMAIL));
	
	/**
	 * Add/Update Dymer Resource
	 *
	 * @param  dymerDomainName 
	 * @param  emailAddress the emailAddress of user owner of the resource
	 * @param  companyId the primary key of the user's company
	 * @param  groupId 
	 * @param  index the index name of the Dymer resource
	 * @param  type the type name of the Dymer resource
	 * @param  id the Dymer resource ID (e.g. basedyml-eym6-4168-3806-138016813806)
	 * @param  url the Dymer Portal URL
	 * @param  title the title Dymer resource
	 * @param  extContent the Dymer resource description
	 * @param  notify, if notify is true the system enables the sending of notifications; the user receives the notification according to the configuration he has set
	 */
	
	@JSONWebService(value="update",method="POST")
	public DymerEntry update(
			String dymerDomainName,
			String emailAddress,
			long companyId,
			long groupId,
			String index,
			String type,
			String id,
			String url,
			String title,
			String extContent,
			boolean notify
	) {
		
		if (_log.isDebugEnabled()) {
			_log.debug("DymerEntryServiceImpl, update method---------------------------------------------");
			
			_log.debug("dymerDomainName: " +dymerDomainName);
			_log.debug("emailAddress: " +emailAddress);
			_log.debug("companyId: " +companyId);
			_log.debug("groupId: " +groupId);
			_log.debug("index: " +index);
			_log.debug("type: " +type);
			_log.debug("id: " +id);
			_log.debug("url: " +url);
			_log.debug("title: " +title);
			_log.debug("extContent: " +extContent);
			_log.debug("notify: " + notify);
		}
		ServiceContext sc = new ServiceContext();
		sc.setAttribute("dymerDomainName", dymerDomainName);
		sc.setAttribute("notify", notify);//Boolean.TRUE
		User user;
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			sc.setUserId(user.getUserId());
			sc.setScopeGroupId(groupId);
		} catch (NoSuchUserException e) {
			_log.error("No User with "+emailAddress+" in companyId="+companyId);
			try {
				
				emailAddress = DymerServicePropsKeys.DEFAULT_CATALOGUE_RESOURCE_OWNER;
				
				if (Validator.isNotNull(catalague_resource_email)) {
					emailAddress = catalague_resource_email;
				}
				
				user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
				sc.setUserId(user.getUserId());
				sc.setScopeGroupId(groupId);
				_log.warn("Catalogue Resource [index:"+index+",type:"+",id:"+id+"] is related to "+emailAddress);
			} catch (PortalException e1) {
				throw new PortalException(e1);
			}
		} catch (Exception e2) {
			_log.error("An error occurred while invoking remote update service "+e2.getMessage());
		} finally {
			sc.setUuid(UUID.randomUUID().toString());
			Date now = new Date();
			sc.setCreateDate(now);
			sc.setModifiedDate(now);
			sc.setAssetCategoryIds(new long[] {});
			sc.setAssetTagNames(new String[] {});
			sc.setAssetLinkEntryIds(new long[] {});
			
			return updateDymerEntry(dymerDomainName, emailAddress, companyId, groupId, index, type, id, url, title, extContent, sc);
		}
		
	}
	
	/**
	 * Add/Update Dymer Resource
	 *
	 * @param  dymerDomainName 
	 * @param  emailAddress the emailAddress of user owner of the resource
	 * @param  companyId the primary key of the user's company
	 * @param  groupId 
	 * @param  index the index name of the Dymer resource
	 * @param  type the type name of the Dymer resource
	 * @param  id the Dymer resource ID (e.g. basedyml-eym6-4168-3806-138016813806)
	 * @param  url the Dymer Portal URL
	 * @param  title the title Dymer resource
	 * @param  extContent the Dymer resource description
	 * @param  notify is true by default so the system enables the sending of notifications; the user receives the notification according to the configuration he has set
	 */
	
	@Deprecated
	@JSONWebService(value="update",method="POST")
	public DymerEntry update(
			String dymerDomainName,
			String emailAddress,
			long companyId,
			long groupId,
			String index,
			String type,
			String id,
			String url,
			String title,
			String extContent
	) {
		
		if (_log.isDebugEnabled()) {
			_log.debug("@Deprecated DymerEntryServiceImpl, update method---------------------------------------------");
			
			_log.debug("dymerDomainName: " +dymerDomainName);
			_log.debug("emailAddress: " +emailAddress);
			_log.debug("companyId: " +companyId);
			_log.debug("groupId: " +groupId);
			_log.debug("index: " +index);
			_log.debug("type: " +type);
			_log.debug("id: " +id);
			_log.debug("url: " +url);
			_log.debug("title: " +title);
			_log.debug("extContent: " +extContent);
		}
		
		ServiceContext sc = new ServiceContext();
		sc.setAttribute("dymerDomainName", dymerDomainName);
		sc.setAttribute("notify", "true");
		User user;
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			sc.setUserId(user.getUserId());
			sc.setScopeGroupId(groupId);
		} catch (NoSuchUserException e) {
			_log.error("No User with "+emailAddress+" in companyId="+companyId);
			try {
				
				emailAddress = DymerServicePropsKeys.DEFAULT_CATALOGUE_RESOURCE_OWNER;
				
				if (Validator.isNotNull(catalague_resource_email)) {
					emailAddress = catalague_resource_email;
				}
				
				user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
				sc.setUserId(user.getUserId());
				sc.setScopeGroupId(groupId);
				_log.warn("Catalogue Resource [index:"+index+",type:"+",id:"+id+"] is related to "+emailAddress);
			} catch (PortalException e1) {
				throw new PortalException(e1);
			}
		} catch (Exception e2) {
			_log.error("An error occurred while invoking remote update service "+e2.getMessage());
		} finally {
			sc.setUuid(UUID.randomUUID().toString());
			Date now = new Date();
			sc.setCreateDate(now);
			sc.setModifiedDate(now);
			sc.setAssetCategoryIds(new long[] {});
			sc.setAssetTagNames(new String[] {});
			sc.setAssetLinkEntryIds(new long[] {});
			
			return updateDymerEntry(dymerDomainName, emailAddress, companyId, groupId, index, type, id, url, title, extContent, sc);
		}
		
	}
	
	
	
	
	private DymerEntry updateDymerEntry(String dymerDomainName,
			String emailAddress,
			long companyId,
			long groupId,
			String index,
			String type,
			String id,
			String url,
			String title,
			String extContent,
			ServiceContext sc) {
		
		if(_log.isDebugEnabled()){
			_log.debug("sc.userId: "+sc.getUserId());
			_log.debug("sc.groupId: "+sc.getScopeGroupId());
			_log.debug("sc.notificationActive: " + sc.getAttribute("notify"));
		}
		
		try {
			
			DymerEntry dymerEntry = DymerEntryUtil.fetchByForIndexTypeId(index, type, id);
			long dymerId = 0;
			
			if(DymerLocalServiceUtil.getDymersCount(groupId) > 0) {	
				dymerId = DymerLocalServiceUtil.getDymers(groupId).get(0).getDymerId();
			}
			
			if (Validator.isNotNull(title)) {
				int titleMaxLength = ModelHintsUtil.getMaxLength(
					DymerEntry.class.getName(), "title");
				
				title = HtmlUtil.extractText(title);
				
				if (_log.isDebugEnabled())
					_log.debug("title extracted: "+title);
				
				if (title.length() > titleMaxLength) {
					title = StringUtil.shorten(title, titleMaxLength);
					if (_log.isDebugEnabled()) {
						_log.debug("titleMaxLength: "+titleMaxLength);
						_log.debug("shorten title: "+title);
					}
				}
			}
			
			if (Validator.isNotNull(extContent)) {
				extContent = HtmlUtil.extractText(extContent);
				
				if (_log.isDebugEnabled())
					_log.debug("extContent extracted: "+extContent);
				
				if (extContent.length() > DymerServicePropsKeys.MAX_LENGTH) {
					extContent = StringUtil.shorten(extContent, DymerServicePropsKeys.MAX_LENGTH);
					if (_log.isDebugEnabled()) 
						_log.debug("shorten extContent: "+extContent);
				}
			}
			
			
			if(dymerEntry != null) {
				
				long entryId = dymerEntry.getEntryId();
				
				dymerEntry = DymerEntryLocalServiceUtil.updateDymerEntry(
						dymerId,
						entryId,
						index,
						type,
						id,
						url,
						title,
						extContent,
						sc
				);
			} else {
				dymerEntry = DymerEntryLocalServiceUtil.addDymerEntry(
						dymerId,
						index,
						type,
						id,
						url,
						title,
						extContent,
						sc
				);
			}
			
			
			return dymerEntry;
		} catch (PortalException e) {
			_log.error("An error occurred while invoking remote update service");
			_log.error(e,e);
			return null;
		}
	}
	
	/**
	 * Delete Dymer Resource
	 *
	 * @param  emailAddress the emailAddress of user owner of the resource
	 * @param  companyId the primary key of the user's company
	 * @param  index the index name of the Dymer resource
	 * @param  type the type name of the Dymer resource
	 * @param  id the Dymer resource ID (e.g. basedyml-eym6-4168-3806-138016813806)
	 * @param  notify, if true send notification
	 */
	
	@JSONWebService(value="delete",method="POST")
    public void delete(
    		String emailAddress,
    		long companyId,
            String index,
            String type,
            String id,
            boolean notify
    ) {
		if (_log.isDebugEnabled()) {
			_log.debug("DymerEntryServiceImpl, delete method---------------------------------------------");
			
			_log.debug("emailAddress: " +emailAddress);
			_log.debug("companyId: " +companyId);
			_log.debug("index: " +index);
			_log.debug("type: " +type);
			_log.debug("id: " +id);
			_log.debug("notify: " +notify);
		}
        
        DymerEntry dymerEntry = DymerEntryUtil.fetchByForIndexTypeId(index, type, id);
        
        if(dymerEntry != null) {
            try {
            	User user = UserLocalServiceUtil.getUserByEmailAddress(dymerEntry.getCompanyId(), emailAddress);
            	if (_log.isDebugEnabled())
            		_log.debug("user "+user.getScreenName() +" is deleting "+dymerEntry.getTitle());
            	
            	if (user!=null) {
            		DymerEntryLocalServiceUtil.v2DeleteDymerEntry(dymerEntry, user, notify);
            	}
            } catch (PortalException e) {
            	_log.error("An error occured while deleting Dymer resource [id: "+id+", index: "+index+", type: "+type+", email: "+emailAddress+", companyId: "+companyId+"]");
                _log.error(e, e);
            }
        } else {
            _log.warn("No Dymer resource [index:"+index+", type:"+ type+", id:"+ id+"] found");
        }
    }
	
	/**
	 * Delete Dymer Resource
	 *
	 * @param  emailAddress the emailAddress of user owner of the resource
	 * @param  companyId the primary key of the user's company
	 * @param  index the index name of the Dymer resource
	 * @param  type the type name of the Dymer resource
	 * @param  id the Dymer resource ID (e.g. basedyml-eym6-4168-3806-138016813806)
	 * @param  notify, if true send notification
	 */
	
	@Deprecated
	@JSONWebService(value="delete",method="POST")
    public void delete(
    		String emailAddress,
    		long companyId,
            String index,
            String type,
            String id
    ) {
		if (_log.isDebugEnabled()) {
			_log.debug("@Deprecated DymerEntryServiceImpl, delete method---------------------------------------------");
			
			_log.debug("emailAddress: " +emailAddress);
			_log.debug("companyId: " +companyId);
			_log.debug("index: " +index);
			_log.debug("type: " +type);
			_log.debug("id: " +id);
		}
        
        DymerEntry dymerEntry = DymerEntryUtil.fetchByForIndexTypeId(index, type, id);
        
        if(dymerEntry != null) {
            try {
            	User user = UserLocalServiceUtil.getUserByEmailAddress(dymerEntry.getCompanyId(), emailAddress);
            	if (_log.isDebugEnabled())
            		_log.debug("user "+user.getScreenName() +" is deleting "+dymerEntry.getTitle());
            	
            	if (user!=null) {
            		DymerEntryLocalServiceUtil.v2DeleteDymerEntry(dymerEntry, user, true);
            	}
            } catch (PortalException e) {
            	_log.error("An error occured while deleting Dymer resource [id: "+id+", index: "+index+", type: "+type+", email: "+emailAddress+", companyId: "+companyId+"]");
                _log.error(e, e);
            }
        } else {
            _log.warn("No Dymer resource [index:"+index+", type:"+ type+", id:"+ id+"] found");
        }
    }
	
	/**
	 * Get userId and fullName by emailAddress of a Liferay user
	 *
	 * @param  emailAddress the emailAddress of user
	 * @param  companyId the primary key of the user's company
	 * @return service response json with userId and fullName
	 */
	
	@JSONWebService(value="getUserInfoByEmail",method="POST")
	public JSONObject getUserInfoByEmail(String emailAddress, long companyId) {
		
		if (_log.isDebugEnabled()){
			 _log.debug("getUserInfoByEmail method ");
			 _log.debug("emailAddress "+emailAddress);
			 _log.debug("companyId "+companyId);
		}
		
		DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(User.class);
		userQuery.add(PropertyFactoryUtil.forName("emailAddress").eq(emailAddress));
		userQuery.add(PropertyFactoryUtil.forName("companyId").eq(new Long(companyId)));
		List<User> users = userLocalService.dynamicQuery(userQuery);
		JSONObject userJSON = JSONFactoryUtil.createJSONObject();
		/*if (users!=null) {
			_log.info("# of users "+users.size());
		}*/
		
		if (users!=null && users.size()==1) {
			User u = users.get(0);
			userJSON.put("userId", u.getUserId());
			userJSON.put("fullName", u.getFullName());
			return userJSON;
		}
		userJSON.put("error", "No User exists with email "+ emailAddress);
		return userJSON;
	}
	
	/**
	 * Send Dymer notification to a list of Liferay users
	 *
	 * @param  companyId the primary key of the user's company
	 * @param  title the Dymer notification title
	 * @param  description the Dymer notification description
	 * @param  resourceId the Dymer resource ID (e.g. basedyml-eym6-4168-3806-138016813806)
	 * @param  index the index name of the Dymer resource
	 * @param  type the type name of the Dymer resource
	 * @param  resourceLink the relative URL of the resource
	 * @param  sender the email address of the sender of the notification
	 * @param  recipients the email addresses array of the notification recipients
	 * @return service response json: success true if everything went well or success false and the type of error otherwise
	 */
	
	@JSONWebService(value="sendPersonalNotification",method="POST")
	public JSONObject sendPersonalNotification(
			String companyId,
			String title,
			String description,
			String resourceId,
			String index,
			String type,
			String resourceLink,
			String sender,
			String[] recipients) 
	{
		_log.debug("sendPersonalNotification method");
		
		int notificationType = DymerUserNotificationDefinition.NOTIFICATION_TYPE_PERSONAL_ENTRY;
		JSONObject response = JSONFactoryUtil.createJSONObject();
		
		if (Validator.isNull(companyId) || Validator.isNull(title) || Validator.isNull(description) 
				|| Validator.isNull(sender) || recipients == null || (recipients!=null && recipients.length == 0)) {
			response.put("success", false);
			response.put("error", "empty input parameters");
			return response;
		}
		
		User usrSender = userLocalService.fetchUserByEmailAddress(Long.valueOf(companyId), sender);
		
		if (Validator.isNull(usrSender)){
			response.put("success", false);
			response.put("error", "unknown sender");
			return response;
		}
		
		List<User> usrRecipients = new ArrayList<User>();
		for (String r : recipients) {
			User recipient = userLocalService.fetchUserByEmailAddress(Long.valueOf(companyId), r);
			if (recipient!=null) {
				usrRecipients.add(recipient);
			} else {
				_log.warn("recipient "+r+ " unknown");
			}
		}
		
		if (usrRecipients.isEmpty()){
			response.put("success", false);
			response.put("error", "unknown recipients");
			return response;
		}
		
		ServiceContext sc = new ServiceContext();
		
		DymerEntry dymerEntry = null;
				
		boolean dymerResource = Validator.isNull(resourceId) && Validator.isNull(index) && Validator.isNull(type);
		
		if (!dymerResource) {
			dymerEntry = DymerEntryUtil.fetchByForIndexTypeId(index, type, resourceId);
		}
		
		try {
			dymerEntryLocalService.v2SendNotifications(usrRecipients, dymerEntry, resourceLink, notificationType, title, description, usrSender, portletId, sc);
		} catch (PortalException e) {
			response.put("success", false);
			response.put("error", e.getMessage());
		}
		response.put("success", true);
		return response;
	}
	
	/**
	 * Send a Dymer Notification to a list of Liferay users who have the indicated role
	 *
	 * @param  companyId the primary key of the user's company
	 * @param  title the Dymer notification title
	 * @param  description the Dymer notification description
	 * @param  resourceId the Dymer resource ID (e.g. basedyml-eym6-4168-3806-138016813806)
	 * @param  index the index name of the Dymer resource
	 * @param  type the type name of the Dymer resource
	 * @param  resourceLink the relative URL of the resource
	 * @param  sender the email address of the sender of the notification
	 * @param  role the role of the users receiving the notification
	 * @return service response json: success true if everything went well or success false and the type of error otherwise
	 */
	
	@JSONWebService(value="sendNotificationByRole",method="POST")
	public JSONObject sendNotificationByRole(
			String companyId,
			String title,
			String description,
			String resourceId,
			String index,
			String type,
			String resourceLink,
			String sender,
			String role) 
	{
		_log.debug("sendNotificationByRole method");
		
		int notificationType = DymerUserNotificationDefinition.NOTIFICATION_TYPE_ROLE_ENTRY;
		JSONObject response = JSONFactoryUtil.createJSONObject();
		
		if (Validator.isNull(companyId) || Validator.isNull(title) || Validator.isNull(description) 
				|| Validator.isNull(sender) || Validator.isNull(role)) {
			response.put("success", false);
			response.put("error", "empty input parameters");
			return response;
		}
		
		ServiceContext sc = new ServiceContext();
		
		User usrSender = userLocalService.fetchUserByEmailAddress(Long.valueOf(companyId), sender);
		
		if (Validator.isNull(usrSender)){
			response.put("success", false);
			response.put("error", "sender unknown");
			return response;
		}
		
		Role usrRole = RoleLocalServiceUtil.fetchRole(Long.valueOf(companyId), role);
		
		if (Validator.isNull(usrRole)){
			response.put("success", false);
			response.put("error", "role unknown");
			return response;
		}
		
		List<User> usrRecipients = userLocalService.getRoleUsers(usrRole.getRoleId());
		try {
			
			boolean dymerResource = Validator.isNull(resourceId) && Validator.isNull(index) && Validator.isNull(type);
			
			DymerEntry dymerEntry = null;
			
			if (!dymerResource) {
				dymerEntry = DymerEntryUtil.fetchByForIndexTypeId(index, type, resourceId);
			}
			
			dymerEntryLocalService.v2SendNotifications(usrRecipients, dymerEntry, resourceLink, notificationType, title, description, usrSender, portletId, sc);
		} catch (PortalException e) {
			response.put("success", false);
			response.put("error", e.getMessage());
			return response;
		}
		
		response.put("success", true);
		return response;
	}
	
	/**
	 * Send a Dymer Notification to a list of Liferay users who belong to the indicated team
	 *
	 * @param  companyId the primary key of the user's company
	 * @param  title the Dymer notification title
	 * @param  description the Dymer notification description
	 * @param  resourceId the Dymer resource ID (e.g. basedyml-eym6-4168-3806-138016813806)
	 * @param  index the index name of the Dymer resource
	 * @param  type the type name of the Dymer resource
	 * @param  resourceLink the relative URL of the resource
	 * @param  sender the email address of the sender of the notification
	 * @param  team the team of the users receiving the notification
	 * @return service response json: success true if everything went well or success false and the type of error otherwise
	 */
	
	@JSONWebService(value="sendNotificationByTeam",method="POST")
	public JSONObject sendNotificationByTeam(
			String companyId,
			String groupId,
			String title,
			String description,
			String resourceId,
			String index,
			String type,
			String resourceLink,
			String sender,
			String team) 
	{
		
		_log.debug("sendNotificationByTeam method");
		
		int notificationType = DymerUserNotificationDefinition.NOTIFICATION_TYPE_TEAM_ENTRY;
		JSONObject response = JSONFactoryUtil.createJSONObject();
		
		if (Validator.isNull(companyId) || Validator.isNull(title) || Validator.isNull(description) 
				|| Validator.isNull(sender) || Validator.isNull(team)) {
			response.put("success", false);
			response.put("error", "empty input parameters");
			return response;
		}
		
		ServiceContext sc = new ServiceContext();
		
		User usrSender = userLocalService.fetchUserByEmailAddress(Long.valueOf(companyId), sender);
		
		if (Validator.isNull(usrSender)){
			response.put("success", false);
			response.put("error", "sender unknown");
			return response;
		}
		
		Team usrTeam = TeamLocalServiceUtil.fetchTeam(Long.valueOf(groupId), team);
		
		if (Validator.isNull(usrTeam)){
			response.put("success", false);
			response.put("error", "team unknown");
			return response;
		}
		
		List<User> usrRecipients = userLocalService.getTeamUsers(usrTeam.getTeamId());
		try {
			boolean dymerResource = Validator.isNull(resourceId) && Validator.isNull(index) && Validator.isNull(type);
			
			DymerEntry dymerEntry = null;
			
			if (!dymerResource) {
				dymerEntry = DymerEntryUtil.fetchByForIndexTypeId(index, type, resourceId);
			}
			
			if (usrRecipients.size()>0) {
				dymerEntryLocalService.v2SendNotifications(usrRecipients, dymerEntry, resourceLink, notificationType, title, description, usrSender, portletId, sc);
			} else {
				_log.warn("no user belongs to the team "+team);
			}
				
		} catch (PortalException e) {
			response.put("success", false);
			response.put("error", e.getMessage());
		}
		response.put("success", true);
		return response;
	}
	
	
	/********************************************************************************************************
	 * Old remote services
	 */
	
	
	@Deprecated
	private void dymerEntryDelete(
			String emailAddress,
    		long companyId,
            String index,
            String type,
            String id,
            ServiceContext sc) {
		
		if(_log.isDebugEnabled()){
			_log.debug("sc.userId: "+sc.getUserId());
			_log.debug("sc.groupId: "+sc.getScopeGroupId());
		}
		
		DymerEntry dymerEntry = DymerEntryUtil.fetchByForIndexTypeId(index, type, id);

        if(dymerEntry != null) {
            try {
                DymerEntryLocalServiceUtil.deleteDymerEntry(dymerEntry.getEntryId(), sc.getUserId());
            } catch (PortalException e) {
            	_log.error("An error occured while deleting Dymer resource [id: "+id+", index: "+index+", type: "+type+", email: "+emailAddress+", companyId: "+companyId+"]");
                _log.error(e, e);
            }
        } else {
            _log.warn("No Dymer resource [index:"+index+", type:"+ type+", id:"+ id+"] found");
        }
	}
	
	@Deprecated
	@JSONWebService(value="update",method="POST")
	public DymerEntry update(
			long userId,
			long groupId,
			String index,
			String type,
			String id,
			String url,
			String title,
			String extContent
	) {
		 
		_log.warn("Invoked deprecated update method ");
		 
		ServiceContext sc = new ServiceContext();
		
		User user;
		try {
			user = UserLocalServiceUtil.getUser(userId);
			sc.setScopeGroupId(groupId);
			
			sc.setUuid(UUID.randomUUID().toString());
			Date now = new Date();
			sc.setCreateDate(now);
			sc.setModifiedDate(now);
			
			sc.setAssetCategoryIds(new long[] {});
			sc.setAssetTagNames(new String[] {});
			
			sc.setAssetLinkEntryIds(new long[] {});
		} catch (PortalException e1) {
			_log.error("An error occurred while invoking user service");
			_log.error(e1,e1);
		}
		
		try {
			
			DymerEntry dymerEntry = DymerEntryUtil.fetchByForIndexTypeId(index, type, id);
			long dymerId = 0;
			
			if(DymerLocalServiceUtil.getDymersCount(groupId) > 0) {	
				dymerId = DymerLocalServiceUtil.getDymers(groupId).get(0).getDymerId();
			}
			
			if (Validator.isNotNull(title)) {
				int titleMaxLength = ModelHintsUtil.getMaxLength(
					DymerEntry.class.getName(), "title");
				
				if (Validator.isNotNull(title)) {
					
					if (_log.isDebugEnabled()) 
						_log.debug("title: "+title);
					
					title = HtmlUtil.extractText(title);
					
					if (_log.isDebugEnabled()) 
						_log.debug("extracted title: "+title);
					
					if (title.length() > titleMaxLength) {
						title = StringUtil.shorten(title, titleMaxLength);
						
						if (_log.isDebugEnabled()) 
							_log.debug("shorten title: "+title);
					}
					
				}
			}

			if (Validator.isNotNull(extContent)) {
				
				if (_log.isDebugEnabled()) 
					_log.debug("extContent: "+extContent);
				
				extContent = HtmlUtil.extractText(extContent);
				
				if (_log.isDebugEnabled()) 
					_log.debug("extracted extContent: "+extContent);
				
				if (extContent.length() > DymerServicePropsKeys.MAX_LENGTH) {
					extContent = StringUtil.shorten(extContent, DymerServicePropsKeys.MAX_LENGTH);
					
					if (_log.isDebugEnabled()) 
						_log.debug("shorten extContent: "+extContent);
				}
			}
			
			if(dymerEntry != null) {
				
				long entryId = dymerEntry.getEntryId();
				
				DymerEntryLocalServiceUtil.updateDymerEntry(
						dymerId,
						userId,
						entryId,
						index,
						type,
						id,
						url,
						title,
						extContent,
						sc
				);
			} else {
				DymerEntryLocalServiceUtil.addDymerEntry(
						dymerId,
						userId,
						index,
						type,
						id,
						url,
						title,
						extContent,
						sc
				);
			}

		} catch (PortalException e) {
			_log.error("An error occurred while invoking update service");
			_log.error(e,e);
		}
		return null;
		
	}
	
	@Deprecated
	@JSONWebService(value="delete",method="POST")
    public void delete(
            long userId,
            String index,
            String type,
            String id
    ) {
        
		 _log.warn("Invoked deprecated delete method ");
		
        ServiceContext sc = new ServiceContext();
    
        User user;
        try {
            user = UserLocalServiceUtil.getUser(userId);
            
            sc.setUuid(UUID.randomUUID().toString());
            Date now = new Date();
            sc.setCreateDate(now);
            sc.setModifiedDate(now);
            sc.setAssetCategoryIds(new long[] {});
            sc.setAssetTagNames(new String[] {});
            sc.setAssetLinkEntryIds(new long[] {});
        } catch (PortalException e1) {
        	_log.error("An error occurred while invoking user service");
			_log.error(e1,e1);
        }
        
        DymerEntry dymerEntry = DymerEntryUtil.fetchByForIndexTypeId(index, type, id);
        
        if(dymerEntry != null) {
            try {
                DymerEntryLocalServiceUtil.deleteDymerEntry(dymerEntry.getEntryId(), userId);
            } catch (PortalException e) {
            	_log.error("An error occurred while invoking delete service");
    			_log.error(e,e);
            }
                    
        } else {
           _log.warn("No dymerEntry to delete");
        }
    }
	
	private static final Log _log = LogFactoryUtil.getLog(
			DymerEntryServiceImpl.class);
	
}