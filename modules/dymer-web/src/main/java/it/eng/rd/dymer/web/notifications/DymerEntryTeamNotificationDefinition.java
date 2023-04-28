package it.eng.rd.dymer.web.notifications;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.notifications.UserNotificationDeliveryType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.dymer.portlet.constants.DymerPortletKeys;
import it.eng.rd.dymer.portlet.constants.DymerPropsKeys;

@Component(
	immediate = true, property = "javax.portlet.name=" + DymerPortletKeys.DYMER,
	service = UserNotificationDefinition.class
)
public class DymerEntryTeamNotificationDefinition
	extends UserNotificationDefinition {

	public DymerEntryTeamNotificationDefinition() {
		super(
				DymerPortletKeys.DYMER, 0,
				DymerEntryUserNotificationDefinition.NOTIFICATION_TYPE_TEAM_ENTRY,
			"needs-to-send-a-communication-to-a-specific-team");
		
		boolean defaulWebSiteStatus = GetterUtil.getBoolean(PropsUtil.get(DymerPropsKeys.DEFAULT_TEAM_WEBSITE_NOTIFICATION_STATUS), false);

		boolean defaulEmailStatus = GetterUtil.getBoolean(PropsUtil.get(DymerPropsKeys.DEFAULT_TEAM_EMAIL_NOTIFICATION_STATUS), false);

		if (_log.isDebugEnabled()) {
			_log.debug("defaulWebSiteStatus:" + defaulWebSiteStatus);
			_log.debug("defaulEmailStatus:" + defaulEmailStatus);
		}
		
		addUserNotificationDeliveryType(
			new UserNotificationDeliveryType(
				"email", UserNotificationDeliveryConstants.TYPE_EMAIL, defaulEmailStatus,
				true));
		addUserNotificationDeliveryType(
			new UserNotificationDeliveryType(
				"website", UserNotificationDeliveryConstants.TYPE_WEBSITE, defaulWebSiteStatus,
				true));
	}
	
	private static final Log _log = LogFactoryUtil.getLog(
			DymerEntryTeamNotificationDefinition.class);

}