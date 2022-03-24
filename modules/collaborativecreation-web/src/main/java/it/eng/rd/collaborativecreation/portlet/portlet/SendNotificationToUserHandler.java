package it.eng.rd.collaborativecreation.portlet.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.collaborativecreation.model.Challenge;
import it.eng.rd.collaborativecreation.model.Cocreation;
import it.eng.rd.collaborativecreation.portlet.constants.CollaborativecreationPortletKeys;
import it.eng.rd.collaborativecreation.service.ChallengeLocalServiceUtil;
import it.eng.rd.collaborativecreation.service.CocreationLocalServiceUtil;

/**
 * @author giacal
 */
@Component (service = UserNotificationHandler.class)
public class SendNotificationToUserHandler extends BaseUserNotificationHandler {
	
	public static final String PORTLET_ID = "it_eng_rd_collaborativecreation_portlet_CollaborativecreationPortlet";
	
	public SendNotificationToUserHandler() {
		setPortletId(SendNotificationToUserHandler.PORTLET_ID);
	}
	
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception{
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		String notificationText = jsonObject.getString("text-message");
		String title = jsonObject.getString("title");
		String senderName = jsonObject.getString("sender");
		String body = StringUtil.replace(getBodyTemplate(), new String[] {"[$TITLES]", "[$SENDERNAMES]", "[$BODY TEXTS]"}, new String[] {title, senderName, notificationText});
		return body;
	}
	
	protected String getBodyTemplate() {
		StringBundler sb = new StringBundler(5);
		sb.append("<div class=\"title\">Title : [$TITLES]</div><div>");
		sb.append("Sender : [$SENDERNAMES] <br>Notification : [$BODY TEXTS]</div>");
		return sb.toString();
	}
	
	protected String getLink(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
		throws Exception {
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		PortletURL portletURL = null;
		PortletURL redirectURL = null;
		long plid = 0;
		
		Cocreation coceration;
		Challenge challenge;
		try {
			if (jsonObject.getString("type").equalsIgnoreCase("cocreation")){
				coceration = CocreationLocalServiceUtil.getCocreation(jsonObject.getLong("classPK"));
				plid = PortalUtil.getPlidFromPortletId(coceration.getGroupId(), CollaborativecreationPortletKeys.COLLABORATIVECREATION);
				if (plid > 0){
					portletURL = PortletURLFactoryUtil.create(serviceContext.getRequest(), CollaborativecreationPortletKeys.COLLABORATIVECREATION, plid, PortletRequest.RENDER_PHASE);
				}else{
					plid = PortalUtil.getPlidFromPortletId(coceration.getGroupId(), CollaborativecreationPortletKeys.COLLABORATIVECREATION);
					portletURL = PortletURLFactoryUtil.create(serviceContext.getRequest(), CollaborativecreationPortletKeys.COLLABORATIVECREATION, plid, PortletRequest.RENDER_PHASE);
				}
			    if (jsonObject.getString("type").equalsIgnoreCase("cocreation")){
					portletURL.setParameter("jspPage", "/cocreationDetails.jsp");
					portletURL.setParameter("backURL", serviceContext.getCurrentURL());
					portletURL.setParameter("cocreationId",String.valueOf(jsonObject.getLong("classPK")));
					portletURL.setParameter("challengeTitle",jsonObject.getString("challengeTitle"));
					portletURL.setParameter("desiredOutcome",jsonObject.getString("desiredOutcome"));
			    }
			}
			if (jsonObject.getString("type").equalsIgnoreCase("challenge")){
				challenge = ChallengeLocalServiceUtil.getChallenge(jsonObject.getLong("classPK"));
				plid = PortalUtil.getPlidFromPortletId(challenge.getGroupId(), CollaborativecreationPortletKeys.COLLABORATIVECREATION);
				if (plid > 0){
					portletURL = PortletURLFactoryUtil.create(serviceContext.getRequest(), CollaborativecreationPortletKeys.COLLABORATIVECREATION, plid, PortletRequest.RENDER_PHASE);
				}else{
					plid = PortalUtil.getPlidFromPortletId(challenge.getGroupId(), CollaborativecreationPortletKeys.COLLABORATIVECREATION);
					portletURL = PortletURLFactoryUtil.create(serviceContext.getRequest(), CollaborativecreationPortletKeys.COLLABORATIVECREATION, plid, PortletRequest.RENDER_PHASE);
				}
				if (jsonObject.getBoolean("request") == true){
					portletURL.setParameter("jspPage", "/participationRequestAcceptance.jsp");
					portletURL.setParameter("participationRequest", jsonObject.getString("text-message"));
					portletURL.setParameter("participant", jsonObject.getString("participant"));
				}else {
					portletURL.setParameter("jspPage", "/challengeDetails.jsp");
				}
				portletURL.setParameter("backURL", serviceContext.getCurrentURL());
				portletURL.setParameter("challengeId",String.valueOf(jsonObject.getLong("classPK")));
			}
			
			redirectURL = PortletURLFactoryUtil.create(serviceContext.getRequest(), CollaborativecreationPortletKeys.COLLABORATIVECREATION, plid, PortletRequest.RENDER_PHASE);
			portletURL.setParameter("notified", "true");
			portletURL.setParameter("redirectTo", redirectURL.toString());
			return portletURL.toString();
		} catch (Exception e) {
			return "";
		}
	}
	    
}