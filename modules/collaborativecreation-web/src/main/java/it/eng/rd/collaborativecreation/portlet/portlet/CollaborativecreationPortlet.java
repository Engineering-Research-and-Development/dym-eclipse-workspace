package it.eng.rd.collaborativecreation.portlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.collaborativecreation.model.Challenge;
import it.eng.rd.collaborativecreation.portlet.constants.CollaborativecreationPortletKeys;
import it.eng.rd.collaborativecreation.service.ChallengeLocalService;

/**
 * @author giacal
 */
@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
		    "javax.portlet.expiration-cache=0",
			"javax.portlet.display-name=Collaborative Creation",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + CollaborativecreationPortletKeys.COLLABORATIVECREATION,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class CollaborativecreationPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	    throws IOException, PortletException {

	    try {
	        ServiceContext serviceContext = ServiceContextFactory.getInstance(
	            Challenge.class.getName(), renderRequest);

	        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	        
	        long groupId = serviceContext.getScopeGroupId();
	        long userId = serviceContext.getUserId();
	        
			/*
			 * long challengeId = ParamUtil.getLong(renderRequest, "challengeId"); String
			 * title = ParamUtil.getString(renderRequest, "title"); String description =
			 * ParamUtil.getString(renderRequest, "description"); Date startDate =
			 * formatter.parse(ParamUtil.getString(renderRequest, "startDate")); Date
			 * endDate = formatter.parse(ParamUtil.getString(renderRequest, "endDate"));
			 * boolean active = Boolean.parseBoolean(ParamUtil.getString(renderRequest,
			 * "active"));
			 * 
			 * List<Challenge> challenges =
			 * _challengeLocalService.getChallengesByUserId(userId, groupId);
			 * 
			 * if (challenges.size() == 0) { Challenge challenge =
			 * _challengeLocalService.addChallenge(title, description, startDate, endDate,
			 * active, serviceContext);
			 * 
			 * challengeId = challenge.getChallengeId();
			 * 
			 * }
			 */
	        
	        _log.info("CollaborativecreationPortlet - Render Method");
	        _log.info("groupId: "+groupId);
	        

	        
			/*
			 * if (!(challengeId > 0)) { challengeId = challenges.get(0).getChallengeId(); }
			 * 
			 * renderRequest.setAttribute("challengeId", challengeId);
			 */

	    } catch (Exception e) {

	        throw new PortletException(e);
	    }

	    super.render(renderRequest, renderResponse);

	}
	
	@ProcessAction(name = "addChallenge")
	public void addChallenge(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException, ParseException {

	    ServiceContext serviceContext = ServiceContextFactory.getInstance(
	        Challenge.class.getName(), request);

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
	    
	    String title = ParamUtil.getString(request, "title");
	    String description = ParamUtil.getString(request, "description");
	    LocalDate startDate = LocalDate.parse(ParamUtil.getString(request, "startDate"), formatter);
	    LocalDate endDate = LocalDate.parse(ParamUtil.getString(request, "endDate"), formatter);
	    boolean active = Boolean.parseBoolean(ParamUtil.getString(request, "active"));	
	    
	    _log.info("CollaborativecreationPortlet - addChallenge");
        _log.info("title: "+title);
        _log.info("description: "+description);
        _log.info("startDate: "+java.sql.Date.valueOf(startDate));
        _log.info("endDate: "+java.sql.Date.valueOf(endDate));
        _log.info("active: "+active);
	    
	    try {
	        _challengeLocalService.addChallenge(title, description, java.sql.Date.valueOf(startDate), java.sql.Date.valueOf(endDate), active, serviceContext);
	        SessionMessages.add(request, "challengeAdded");
	    } catch (Exception e) {
	        SessionErrors.add(request, e.getClass().getName());
	        response.setRenderParameter("mvcPath", "/newchallenge.jsp");
	    }
	}
	
	private static final Log _log = LogFactoryUtil.getLog(
			CollaborativecreationPortlet.class);
	
	@Reference
	private ChallengeLocalService _challengeLocalService;
}