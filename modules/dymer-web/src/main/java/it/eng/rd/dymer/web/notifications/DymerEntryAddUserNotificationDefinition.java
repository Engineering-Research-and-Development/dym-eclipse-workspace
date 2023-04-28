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
public class DymerEntryAddUserNotificationDefinition
	extends UserNotificationDefinition {

	public DymerEntryAddUserNotificationDefinition() {
		super(
				DymerPortletKeys.DYMER, 0,
			UserNotificationDefinition.NOTIFICATION_TYPE_ADD_ENTRY,
			"adds-a-dymer-resource");
		
		boolean defaulWebSiteStatus = GetterUtil.getBoolean(PropsUtil.get(DymerPropsKeys.DEFAULT_ADD_WEBSITE_NOTIFICATION_STATUS), false);

		boolean defaulEmailStatus = GetterUtil.getBoolean(PropsUtil.get(DymerPropsKeys.DEFAULT_ADD_EMAIL_NOTIFICATION_STATUS), false);

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
			DymerEntryAddUserNotificationDefinition.class);

}