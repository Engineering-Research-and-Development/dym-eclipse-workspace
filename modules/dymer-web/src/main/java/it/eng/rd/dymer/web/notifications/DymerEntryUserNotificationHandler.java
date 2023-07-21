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

package it.eng.rd.dymer.web.notifications;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseModelUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.social.kernel.service.SocialRequestLocalService;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.dymer.constants.DymerPortletKeys;
import it.eng.rd.dymer.model.DymerEntry;
import it.eng.rd.dymer.service.DymerEntryLocalServiceUtil;
import it.eng.rd.dymer.service.persistence.DymerEntryUtil;

@Component(
	immediate = true, property = "javax.portlet.name=" + DymerPortletKeys.DYMER,
	service = UserNotificationHandler.class
)
public class DymerEntryUserNotificationHandler
	extends BaseModelUserNotificationHandler {

	public DymerEntryUserNotificationHandler() {
		setPortletId(DymerPortletKeys.DYMER);
	}
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("content/Language", new Locale(Locale.getDefault().toString(), Locale.getDefault().getDisplayCountry()));
	private String theUser = resourceBundle.getString("the-user");
	
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception{
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
				userNotificationEvent.getPayload());
		String cmd = jsonObject.getString("cmd");
		String title = jsonObject.getString("title");
		String userId = jsonObject.getString("userId");
		
		int notificationType = jsonObject.getInt("notificationType");
		String link = getLink(userNotificationEvent, serviceContext);
		
		User user = UserLocalServiceUtil.getUser(Long.valueOf(userId));
		String body = StringPool.BLANK;
		
		//notification v1
		if (notificationType < 3) {
			String opType;
		    switch (cmd) {
		        case Constants.ADD:
		        	opType = resourceBundle.getString("added"); 
		            break;
		        case Constants.UPDATE:
		        	opType = resourceBundle.getString("updated");
		            break;
		        case Constants.DELETE:
		        	opType = resourceBundle.getString("deleted");
		            break;
		        default:
		        	opType = "unknown";
		            break;
		    }
			
		    String userInfo = theUser + StringPool.SPACE + user.getFullName() +  StringPool.SPACE + opType;
		    
		    StringBundler bodyTemplate = new StringBundler(2);
		    bodyTemplate.append("<div class=\"title\">[$USER_INFO]</div></a>");
		    bodyTemplate.append("<br><div><a href=\"[$URL]\">[$TITLE]</div>");
		    
			body = StringUtil.replace(bodyTemplate.toString(), new String[] {"[$USER_INFO]", "[$TITLE]", "[$URL]"}, new String[] {userInfo, title, link});
			
			if (_log.isDebugEnabled()) {
				_log.debug("userInfo: "+userInfo);
				_log.debug("link: "+link);
				//_log.debug("bodyTemplate: "+bodyTemplate);
				_log.debug("body: "+body);
			}
		} 
		
		//notification v2
		if (notificationType >= 3) {
			
			String description = HtmlUtil.stripHtml(jsonObject.getString("description"));
			
			StringBundler bodyTemplate2 = new StringBundler(2);
			if (!link.equalsIgnoreCase("#")) {
				bodyTemplate2.append("<div class=\"title\">[$TITLE]</div></a>");
				bodyTemplate2.append("<br><div><a href=\"[$URL]\">[$DESCRIPTION]</div>");
			} else {
		    	bodyTemplate2.append("<div class=\"title\">[$TITLE]</div></a>");
		    	bodyTemplate2.append("<br><div>[$DESCRIPTION]</div>");
		    }
		    
			body = StringUtil.replace(bodyTemplate2.toString(), new String[] {"[$TITLE]", "[$DESCRIPTION]", "[$URL]"}, new String[] {title, description, link});

			if (_log.isDebugEnabled()) {
				_log.debug("body: "+body);
			}
		}
		return body;
	}
	
	@Override
	protected String getLink(
			UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext)
		throws Exception {
		
		if (_log.isDebugEnabled())
        	_log.debug("userNotificationEvent.getPayload: "+userNotificationEvent.getPayload());
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
				userNotificationEvent.getPayload());
		
		String cmd = jsonObject.getString("cmd");
		
		int notificationType = jsonObject.getInt("notificationType");
		
		long classPK = jsonObject.getLong("classPK");
		
		DymerEntry entry = DymerEntryLocalServiceUtil.fetchDymerEntry(classPK);
		
		//notification v1
		if (notificationType < 3) {
			if (Validator.isNotNull(entry)) {
				_log.debug("Notified resource url (v1): /group/guest/catalogue-detail?id="+entry.getId());
				return "/group/guest/catalogue-detail?id="+entry.getId();
			}
		} 
		
		//notification v2
		if (notificationType >= 3){
			String resourceLink = jsonObject.getString("resourceLink");
			String portalUrl = jsonObject.getString("portalUrl");
			long groupId = jsonObject.getLong("groupId");
			String groupFriendlyURL = "/guest";
			if (groupId!=0) {
				Group group = GroupLocalServiceUtil.fetchGroup(groupId);
				groupFriendlyURL = group.getFriendlyURL();
			}
			_log.debug("groupFriendlyURL: "+groupFriendlyURL);
			
			
			if (Validator.isNotNull(resourceLink) && !resourceLink.isEmpty()) {
				_log.debug("Notified resource url (v2), resourceLink is "+resourceLink);
				return resourceLink;
			}
			
			if (Validator.isNotNull(entry)) {
				String url = "/group"+groupFriendlyURL+"/catalogue-detail?id="+entry.getId();
				_log.debug("Notified resource url (v2), resource url is "+url);
				return url;
			}
			
			if (classPK==0 && resourceLink.isEmpty()) {
				_log.debug("Notified resource url (v2), resourceLink is empty and dymer resource is null ");
				return "#";
			}
			
		}
		_log.debug("Notified resource url is #");
		return "#";
		
	}

	@Reference
	private SocialRequestLocalService _socialRequestLocalService;

	@Reference
	private UserLocalService _userLocalService;

	@Reference
	private UserNotificationEventLocalService
		_userNotificationEventLocalService;
	
	private static final Log _log = LogFactoryUtil.getLog(
			DymerEntryUserNotificationHandler.class);

}