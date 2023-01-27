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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseModelUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.social.kernel.service.SocialRequestLocalService;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.dymer.constants.DymerPortletKeys;
import it.eng.rd.dymer.model.DymerEntry;
import it.eng.rd.dymer.service.DymerEntryLocalServiceUtil;

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
		
		User user = UserLocalServiceUtil.getUser(Long.valueOf(userId));
		
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
	    String link = getLink(userNotificationEvent, serviceContext);
	    
	    StringBundler bodyTemplate = new StringBundler(2);
	    bodyTemplate.append("<div class=\"title\">[$USER_INFO]</div></a>");
	    bodyTemplate.append("<br><div><a href=\"[$URL]\">[$TITLE]</div>");
	    
		String body = StringUtil.replace(bodyTemplate.toString(), new String[] {"[$USER_INFO]", "[$TITLE]", "[$URL]"}, new String[] {userInfo, title, link});
		
		if (_log.isDebugEnabled()) {
			_log.debug("userInfo: "+userInfo);
			_log.debug("link: "+link);
			_log.debug("bodyTemplate: "+bodyTemplate);
			_log.debug("body: "+body);
		}
		 
		return body;
	}
	
	@Override
	protected String getLink(
			UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext)
		throws Exception {
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
				userNotificationEvent.getPayload());
        if (_log.isDebugEnabled())
        	_log.debug("userNotificationEvent.getPayload: "+userNotificationEvent.getPayload());
        
        long classPK = jsonObject.getLong("classPK");
		
		DymerEntry entry = DymerEntryLocalServiceUtil.fetchDymerEntry(classPK);
		
		if (entry!=null) {
			String _id = entry.getId();
			
			return "/group/guest/catalogue-detail?id="+_id;
		}
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