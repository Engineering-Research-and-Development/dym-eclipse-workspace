package it.eng.rd.dymer.web.notifications;

import com.liferay.portal.kernel.notifications.UserNotificationDefinition;

public class DymerEntryUserNotificationDefinition extends UserNotificationDefinition{

	public DymerEntryUserNotificationDefinition(String portletId, long classNameId, int notificationType,
			String description) {
		super(portletId, classNameId, notificationType, description);
	}

	public static final int NOTIFICATION_TYPE_DELETE_ENTRY = 2;
}
