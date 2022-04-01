package it.eng.rd.collaborativecreation.portlet.portlet;

import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.collaborativecreation.model.Activity;
import it.eng.rd.collaborativecreation.model.Challenge;
import it.eng.rd.collaborativecreation.model.Cocreation;
import it.eng.rd.collaborativecreation.model.Cocreator;
import it.eng.rd.collaborativecreation.model.Task;
import it.eng.rd.collaborativecreation.portlet.constants.CollaborativecreationPortletKeys;
import it.eng.rd.collaborativecreation.service.ActivityLocalService;
import it.eng.rd.collaborativecreation.service.ActivityLocalServiceUtil;
import it.eng.rd.collaborativecreation.service.CategoryLocalServiceUtil;
import it.eng.rd.collaborativecreation.service.ChallengeLocalService;
import it.eng.rd.collaborativecreation.service.ChallengeLocalServiceUtil;
import it.eng.rd.collaborativecreation.service.CocreationLocalServiceUtil;
import it.eng.rd.collaborativecreation.service.CocreatorLocalServiceUtil;
import it.eng.rd.collaborativecreation.service.HashtagLocalServiceUtil;
import it.eng.rd.collaborativecreation.service.LocationLocalServiceUtil;
import it.eng.rd.collaborativecreation.service.TaskLocalServiceUtil;

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
	
	/*Gestione properties*/
	private ResourceBundle properties = ResourceBundle.getBundle("portlet");
	private boolean webNotification = Boolean.parseBoolean(properties.getString("collaborativecreation.webNotification"));
	private boolean emailNotification = Boolean.parseBoolean(properties.getString("collaborativecreation.emailNotification"));
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	    throws IOException, PortletException {

	    try {
	        ServiceContext serviceContext = ServiceContextFactory.getInstance(
	            Challenge.class.getName(), renderRequest);

	        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	        
	        long groupId = serviceContext.getScopeGroupId();
	        long userId = serviceContext.getUserId();
		    long challengeId = ParamUtil.getLong(renderRequest, "challengeId");
		    long cocreationId = ParamUtil.getLong(renderRequest, "cocreationId");
		    String active = ParamUtil.getString(renderRequest, "active");
		    String inactive = ParamUtil.getString(renderRequest, "inactive");
		    
		    renderRequest.setAttribute("challengeId", challengeId);
		    renderRequest.setAttribute("cocreationId", cocreationId);
		    renderRequest.setAttribute("active", active);
		    renderRequest.setAttribute("inactive", inactive);
		    
	        _log.info("CollaborativecreationPortlet - Render Method");
	        _log.info("groupId: "+groupId);
	        _log.info("userId: "+userId);
	        _log.info("challengeId: "+challengeId);
	        _log.info("cocreationId: "+cocreationId);
	        _log.info("active: "+active);
	        _log.info("inactive: "+inactive);
	        
	    } catch (Exception e) {

	        throw new PortletException(e);
	    }

	    super.render(renderRequest, renderResponse);
	}
	
	@ProcessAction(name = "addChallenge")
	public void addChallenge(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException, ParseException {

	    ServiceContext serviceContext = ServiceContextFactory.getInstance(Challenge.class.getName(), request);
	    UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    
	    String redirectTo = ParamUtil.getString(request, "redirectTo");
	    String title = ParamUtil.getString(request, "title");
	    String description = ParamUtil.getString(request, "description");
	    String desiredOutcome = ParamUtil.getString(request, "desiredOutcome");
	    String location = ParamUtil.getString(request, "location");
		/* String[] tags = ParamUtil.getParameterValues(request, "tags"); */
	    /* String[] categories = ParamUtil.getParameterValues(request, "categories"); */
	    String[] tags = uploadRequest.getParameterValues("tags");
	    String[] categories = uploadRequest.getParameterValues("categories");
	    Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(uploadRequest.getParameter("startDate"));
	    Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(uploadRequest.getParameter("endDate"));
	    boolean active = Boolean.parseBoolean(ParamUtil.getString(request, "active"));	
	    
	    Map<String, FileItem[]> files = uploadRequest.getMultipartParameterMap();
	    String folderTitle = title.replaceAll("[^a-zA-Z0-9]", "_");
	    String folder = folderTitle;
    	createFolder(request, themeDisplay, folder);
		fileUpload(themeDisplay, request, files, "CHALLENGE_", "uploadedFile", folder);
    	
	    _log.info("CollaborativecreationPortlet - addChallenge");
        _log.info("title: "+title);
        _log.info("description: "+description);
        _log.info("desiredOutcome: "+desiredOutcome);
        _log.info("startDate: "+startDate);
        _log.info("endDate: "+endDate);
        _log.info("active: "+active);
        
        /*Recupero di immagini e documenti dalla Document Library*/
		Map<String, String>  allFiles = getAllFileLinks(themeDisplay, folder);
		Iterator iterator = allFiles.entrySet().iterator();
	    while (iterator.hasNext()) {
	        Map.Entry pair = (Map.Entry)iterator.next();
	        _log.info(pair.getKey() + " ====> " + pair.getValue());
	        iterator.remove(); 
	    }
	    
	    try {
	    	Challenge challenge = ChallengeLocalServiceUtil.addChallenge(title, description, desiredOutcome, startDate, endDate, active, serviceContext);
	    	LocationLocalServiceUtil.addLocation(challenge.getChallengeId(), location, "", "", serviceContext);  
	    	for(String tag : tags){
	    		HashtagLocalServiceUtil.addHashtag(challenge.getChallengeId(), tag, serviceContext);
	    	}
	    	for(String category : categories){
	    		CategoryLocalServiceUtil.addCategory(challenge.getChallengeId(), category, serviceContext);
	    	}
	    	SessionMessages.add(request, "actionSuccess");
	        response.sendRedirect(redirectTo);
	    } catch (Exception e) {
	    	SessionErrors.add(request, "actionError");
	        response.setRenderParameter("mvcPath", "/newchallenge.jsp");
	    }
	}
	
	@ProcessAction(name = "updateChallenge")
	public void updateChallenge(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException, ParseException {

	    ServiceContext serviceContext = ServiceContextFactory.getInstance(Challenge.class.getName(), request);
	    UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    
	    String redirectTo = ParamUtil.getString(request, "redirectTo");
	    long challengeId = ParamUtil.getLong(request, "challengeId");
	    String title = ParamUtil.getString(request, "title");
	    String description = ParamUtil.getString(request, "description");
	    String desiredOutcome = ParamUtil.getString(request, "desiredOutcome");
	    String location = ParamUtil.getString(request, "location");
	    /* String[] tags = ParamUtil.getParameterValues(request, "tags"); */
	    /* String[] categories = ParamUtil.getParameterValues(request, "categories"); */
	    String[] tags = uploadRequest.getParameterValues("tags");
	    String[] categories = uploadRequest.getParameterValues("categories");
	    Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(uploadRequest.getParameter("startDate"));
	    Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(uploadRequest.getParameter("endDate"));
	    boolean active = Boolean.parseBoolean(ParamUtil.getString(request, "active"));
	    
	    Map<String, FileItem[]> files = uploadRequest.getMultipartParameterMap();
	    String folderTitle = title.replaceAll("[^a-zA-Z0-9]", "_");
	    String folder = folderTitle;
    	createFolder(request, themeDisplay, folder);
		fileUpload(themeDisplay, request, files, "CHALLENGE_", "uploadedFile", folder);
		
	    _log.info("CollaborativecreationPortlet - updateChallenge");
	    _log.info("challengeId: "+challengeId);
	    _log.info("title: "+title);
        _log.info("description: "+description);
        _log.info("desiredOutcome: "+desiredOutcome);
        _log.info("startDate: "+startDate);
        _log.info("endDate: "+endDate);
        _log.info("active: "+active);
        
        /*Recupero di immagini e documenti dalla Document Library*/
		Map<String, String>  allFiles = getAllFileLinks(themeDisplay, folder);
		Iterator iterator = allFiles.entrySet().iterator();
	    while (iterator.hasNext()) {
	        Map.Entry pair = (Map.Entry)iterator.next();
	        _log.info(pair.getKey() + " ====> " + pair.getValue());
	        iterator.remove(); 
	    }
	    
	    try {
	    	ChallengeLocalServiceUtil.updateChallenge(challengeId, title, description, desiredOutcome, startDate, endDate, active, serviceContext);
	    	LocationLocalServiceUtil.updateLocation(challengeId, location, "", "", serviceContext); 
	    	HashtagLocalServiceUtil.deleteHashtagsByChallengeId(challengeId);
	    	CategoryLocalServiceUtil.deleteCategoriesByChallengeId(challengeId);
	    	for(String tag : tags){
	    		HashtagLocalServiceUtil.addHashtag(challengeId, tag, serviceContext);
	    	}
	    	for(String category : categories){
	    		CategoryLocalServiceUtil.addCategory(challengeId, category, serviceContext);
	    	}
	    	List<Cocreation> cocreations = CocreationLocalServiceUtil.getCocreationsByChallengeId(challengeId);
			Iterator<Cocreation> cocreationsIt = cocreations.iterator();
			while(cocreationsIt.hasNext()){
				Cocreation cocreation = cocreationsIt.next();
				List<Cocreator> cocreators = CocreatorLocalServiceUtil.getCocreatorsByCocreationId(cocreation.getCocreationId());
				Iterator<Cocreator> cocreatorsIt = cocreators.iterator();
				while(cocreatorsIt.hasNext()){
					Cocreator cocreator = cocreatorsIt.next();
					sendChallengeNotification("Dear user", "Have a nice day!", 
			    			"The challenge "+ ChallengeLocalServiceUtil.getChallenge(challengeId).getTitle() + 
			    			" has been updated.", challengeId, cocreator.getUserId(), serviceContext.getUserId(), 
			    			UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName(), false, serviceContext);
				}
			}	
	        SessionMessages.add(request, "actionSuccess");
	        response.sendRedirect(redirectTo);
	    } catch (Exception e) {
	    	SessionErrors.add(request, "actionError");
	        response.setRenderParameter("mvcPath", "/challengeDetails.jsp");
	    }
	}
	
	@ProcessAction(name = "deleteChallenge")
	public void deleteChallenge(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException, ParseException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Challenge.class.getName(), request);
		
		String redirectTo = ParamUtil.getString(request, "redirectTo");
	    long challengeId = ParamUtil.getLong(request, "challengeId");
	    Challenge challenge = ChallengeLocalServiceUtil.getChallenge(challengeId);
	    
	    _log.info("CollaborativecreationPortlet - deleteChallenge");
        _log.info("challengeId: "+challengeId);
      
	    try {
	    	List<Cocreation> cocreations = CocreationLocalServiceUtil.getCocreationsByChallengeId(challengeId);
			Iterator<Cocreation> cocreationsIt = cocreations.iterator();
			while(cocreationsIt.hasNext()){
				Cocreation cocreation = cocreationsIt.next();
				List<Cocreator> cocreators = CocreatorLocalServiceUtil.getCocreatorsByCocreationId(cocreation.getCocreationId());
				Iterator<Cocreator> cocreatorsIt = cocreators.iterator();
				while(cocreatorsIt.hasNext()){
					Cocreator cocreator = cocreatorsIt.next();
					CocreatorLocalServiceUtil.deleteCocreator(cocreator);
					sendChallengeNotification("Dear user", "Have a nice day!", 
			    			"The challenge "+ ChallengeLocalServiceUtil.getChallenge(challengeId).getTitle() + 
			    			",you are co-creator of,has been deleted.", challengeId, cocreator.getUserId(), serviceContext.getUserId(), 
			    			UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName(), false, serviceContext);
				}
			}	
			CocreationLocalServiceUtil.deleteCocreationsByChallengeId(challengeId);
	    	ChallengeLocalServiceUtil.deleteChallenge(challengeId);
	    	AssetEntryLocalServiceUtil.deleteEntry(Challenge.class.getName(), challenge.getPrimaryKey());
	        SessionMessages.add(request, "actionSuccess");
	        response.sendRedirect(redirectTo);
	    } catch (Exception e) {
	    	SessionErrors.add(request, "actionError");
	        response.setRenderParameter("mvcPath", "/challenges.jsp");
	    }
	}
	
	@ProcessAction(name = "updateCocreation")
	public void updateCocreation(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException, ParseException {

	    ServiceContext serviceContext = ServiceContextFactory.getInstance(Challenge.class.getName(), request);
	    UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    
	    String redirectTo = ParamUtil.getString(request, "redirectTo");
	    long cocreationId = ParamUtil.getLong(request, "cocreationId");
	    String title = ParamUtil.getString(request, "title");
	    String description = ParamUtil.getString(request, "description");
	    boolean completed = Boolean.parseBoolean(ParamUtil.getString(request, "completed"));
	    
	    Map<String, FileItem[]> files = uploadRequest.getMultipartParameterMap();
	    String folderTitle = ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreationId, serviceContext.getScopeGroupId()).getTitle().replaceAll("[^a-zA-Z0-9]", "_");
	    String folder = folderTitle;
    	createFolder(request, themeDisplay, folder);
		fileUpload(themeDisplay, request, files, "COCREATION_", "uploadedFile", folder);
		
	    _log.info("CollaborativecreationPortlet - updateCocreation");
	    _log.info("cocreationId: "+cocreationId);
	    _log.info("title: "+title);
        _log.info("description: "+description);
        _log.info("completed: "+completed);
       
        /*Recupero di immagini e documenti dalla Document Library*/
		Map<String, String>  allFiles = getAllFileLinks(themeDisplay, folder);
		Iterator iterator = allFiles.entrySet().iterator();
	    while (iterator.hasNext()) {
	        Map.Entry pair = (Map.Entry)iterator.next();
	        _log.info(pair.getKey() + " ====> " + pair.getValue());
	        iterator.remove(); 
	    }
	    
	    try {
	    	CocreationLocalServiceUtil.updateCocreation(cocreationId, title, description, completed, serviceContext);
	    	sendCocreationNotification("Dear user", "Have a nice day!", 
	    			"The co-creation " + title + ",in the challenge " + ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreationId, serviceContext.getScopeGroupId()).getTitle() +
	    			" has been updated.", ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreationId, serviceContext.getScopeGroupId()).getUserId(), serviceContext.getUserId(), 
	    			UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName(), cocreationId, 
	    			ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreationId, serviceContext.getScopeGroupId()).getTitle(), 
	    			ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreationId, serviceContext.getScopeGroupId()).getDesiredOutcome(), 
	    			serviceContext);
	        SessionMessages.add(request, "actionSuccess");
			/* response.sendRedirect(redirectTo); */
	        response.setRenderParameter("mvcPath", "/ongoing-cocreations.jsp");
	    } catch (Exception e) {
	        SessionErrors.add(request, "actionError");
	        response.setRenderParameter("mvcPath", "/cocreationDetails.jsp");
	    }
	}
	
	@ProcessAction(name = "deleteCocreation")
	public void deleteCocreation(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Challenge.class.getName(), request);
		
		String redirectTo = ParamUtil.getString(request, "redirectTo");
	    long cocreationId = ParamUtil.getLong(request, "cocreationId");
	    Cocreation cocreation = CocreationLocalServiceUtil.getCocreation(cocreationId);
	    
	    _log.info("CollaborativecreationPortlet - deleteCocreation");
        _log.info("cocreationId: "+cocreationId);
      
	    try {
			List<Cocreator> cocreators = CocreatorLocalServiceUtil.getCocreatorsByCocreationId(cocreation.getCocreationId());
			Iterator<Cocreator> cocreatorsIt = cocreators.iterator();
			while(cocreatorsIt.hasNext()){
				Cocreator cocreator = cocreatorsIt.next();
				CocreatorLocalServiceUtil.deleteCocreator(cocreator);
				sendCocreationNotification("Dear user", "Have a nice day!", 
		    			"The co-creation "+ cocreation.getTitle() + 
		    			" has been deleted.", cocreator.getUserId(), serviceContext.getUserId(), 
		    			UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName(), cocreationId, "", "", serviceContext);
			}
			CocreationLocalServiceUtil.deleteCocreationByCocreationId(cocreationId);
	    	AssetEntryLocalServiceUtil.deleteEntry(Cocreation.class.getName(), cocreationId);
	        SessionMessages.add(request, "actionSuccess");
	        response.sendRedirect(redirectTo);
	    } catch (Exception e) {
	    	SessionErrors.add(request, "actionError");
	        response.setRenderParameter("mvcPath", "/ongoing-cocreations.jsp");
	    }
	}
	
	@ProcessAction(name = "addMilestone")
	public void addMilestone(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException, ParseException {

	    ServiceContext serviceContext = ServiceContextFactory.getInstance(Challenge.class.getName(), request);
	    UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    
	    String redirectTo = ParamUtil.getString(request, "redirectTo");
	    long challengeId = ParamUtil.getLong(request, "challengeId");
	    long cocreationId = ParamUtil.getLong(request, "cocreationId");
	    String description = ParamUtil.getString(request, "description");
	    Date expirationDate = new SimpleDateFormat("dd/MM/yyyy").parse(uploadRequest.getParameter("expirationDate"));	
	    String[] participants = ParamUtil.getParameterValues(request, "participants");
	    
	    Map<String, FileItem[]> files = uploadRequest.getMultipartParameterMap();
	    String folderTitle = ChallengeLocalServiceUtil.getChallenge(challengeId).getTitle().replaceAll("[^a-zA-Z0-9]", "_");
	    String folder = folderTitle;
    	createFolder(request, themeDisplay, folder);
		fileUpload(themeDisplay, request, files, "CHALLENGE_", "uploadedFile", folder);
    	
	    _log.info("CollaborativecreationPortlet - addMilestone");
        _log.info("description: "+description);
        _log.info("expirationDate: "+expirationDate);
        
        /*Recupero di immagini e documenti dalla Document Library*/
		Map<String, String>  allFiles = getAllFileLinks(themeDisplay, folder);
		Iterator iterator = allFiles.entrySet().iterator();
	    while (iterator.hasNext()) {
	        Map.Entry pair = (Map.Entry)iterator.next();
	        _log.info(pair.getKey() + " ====> " + pair.getValue());
	        iterator.remove(); 
	    }
	    
	    try {
			  Activity activity = ActivityLocalServiceUtil.addActivity(cocreationId, description, expirationDate, serviceContext);
			  for(String participant : participants){
				  _log.info("participant: "+participant); 
				  User user = UserLocalServiceUtil.getUser(Long.parseLong(participant));
				  CocreatorLocalServiceUtil.addCocreator(activity.getActivityId(), user.getUserId(), serviceContext);  	
				  sendCocreationNotification("Dear user", "Have a nice day!", "You have a milestone for the co-creation "+ CocreationLocalServiceUtil.getCocreation(cocreationId).getTitle() + ": " + CocreationLocalServiceUtil.getCocreation(cocreationId).getDescription(),
						  user.getUserId(), serviceContext.getUserId(),
						  UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName(),
						  cocreationId, 
			    		  ChallengeLocalServiceUtil.getChallenge(challengeId).getTitle(), ChallengeLocalServiceUtil.getChallenge(challengeId).getDesiredOutcome(), serviceContext);
			  }
			 
			  SessionMessages.add(request, "actionSuccess");
	          response.sendRedirect(redirectTo);
	    } catch (Exception e) {
	    	SessionErrors.add(request, "actionError");
	        response.setRenderParameter("mvcPath", "/addMilestone.jsp");
	    }
	}
	
	@ProcessAction(name = "deleteMilestone")
	public void deleteMilestone(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Challenge.class.getName(), request);
		
		String redirectTo = ParamUtil.getString(request, "redirectTo");
	    long activityId = ParamUtil.getLong(request, "activityId");
	    Activity activity = ActivityLocalServiceUtil.getActivity(activityId);
	    
	    _log.info("CollaborativecreationPortlet - deleteActivity");
        _log.info("activityId: "+activityId);
      
	    try {
			List<Cocreator> cocreators = CocreatorLocalServiceUtil.getCocreatorsByCocreationId(activity.getActivityId());
			Iterator<Cocreator> cocreatorsIt = cocreators.iterator();
			while(cocreatorsIt.hasNext()){
				Cocreator cocreator = cocreatorsIt.next();
				CocreatorLocalServiceUtil.deleteCocreator(cocreator);
				sendCocreationNotification("Dear user", "Have a nice day!", 
		    			"The milestone "+ activity.getDescription() + 
		    			" has been deleted.", cocreator.getUserId(), serviceContext.getUserId(), 
		    			UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName(), activityId, "", "", serviceContext);
			}
			ActivityLocalServiceUtil.deleteActivity(activityId);
	        SessionMessages.add(request, "actionSuccess");
	        response.sendRedirect(redirectTo);
	    } catch (Exception e) {
	    	SessionErrors.add(request, "actionError");
	        response.setRenderParameter("mvcPath", "/cocreationDetails.jsp");
	    }
	}
	
	@ProcessAction(name = "addToDo")
	public void addToDo(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException, ParseException {

	    ServiceContext serviceContext = ServiceContextFactory.getInstance(Challenge.class.getName(), request);
	    UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    
	    String redirectTo = ParamUtil.getString(request, "redirectTo");
	    long challengeId = ParamUtil.getLong(request, "challengeId");
	    long cocreationId = ParamUtil.getLong(request, "cocreationId");
	    String description = ParamUtil.getString(request, "description");
	    Date expirationDate = new SimpleDateFormat("dd/MM/yyyy").parse(uploadRequest.getParameter("expirationDate"));	
	    
	    _log.info("CollaborativecreationPortlet - addToDo");
        _log.info("description: "+description);
        _log.info("expirationDate: "+expirationDate);
        
	    try {
			  TaskLocalServiceUtil.addTask(cocreationId, serviceContext.getUserId(), description, expirationDate, serviceContext);   	
			  sendCocreationNotification("Dear user", "Have a nice day!", "You have a to-do for the co-creation "+ CocreationLocalServiceUtil.getCocreation(cocreationId).getTitle() + ": " + CocreationLocalServiceUtil.getCocreation(cocreationId).getDescription(),
					  serviceContext.getUserId(), serviceContext.getUserId(),
					  UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName(),
					  cocreationId, 
		    		  ChallengeLocalServiceUtil.getChallenge(challengeId).getTitle(), ChallengeLocalServiceUtil.getChallenge(challengeId).getDesiredOutcome(), serviceContext);
			  SessionMessages.add(request, "actionSuccess");
	          response.sendRedirect(redirectTo);
	    } catch (Exception e) {
	    	SessionErrors.add(request, "actionError");
	        response.setRenderParameter("mvcPath", "/addToDo.jsp");
	    }
	}
	
	@ProcessAction(name = "deleteToDo")
	public void deleteToDo(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Challenge.class.getName(), request);
		
		String redirectTo = ParamUtil.getString(request, "redirectTo");
	    long taskId = ParamUtil.getLong(request, "taskId");
	    Task task = TaskLocalServiceUtil.getTask(taskId);
	    
	    _log.info("CollaborativecreationPortlet - deleteTask");
        _log.info("taskId: "+taskId);
      
	    try {
			sendCocreationNotification("Dear user", "Have a nice day!", 
	    			"The to-do "+ task.getDescription() + 
	    			" has been deleted.", serviceContext.getUserId(), serviceContext.getUserId(), 
	    			UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName(), taskId, "", "", serviceContext);
			TaskLocalServiceUtil.deleteTask(taskId);
	        SessionMessages.add(request, "actionSuccess");
	        response.sendRedirect(redirectTo);
	    } catch (Exception e) {
	    	SessionErrors.add(request, "actionError");
	        response.setRenderParameter("mvcPath", "/cocreationDetails.jsp");
	    }
	}
	
	@ProcessAction(name = "addParticipant")
	public void addParticipant(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException, ParseException {

	    ServiceContext serviceContext = ServiceContextFactory.getInstance(
	        Challenge.class.getName(), request);

	    String redirectTo = ParamUtil.getString(request, "redirectTo");
	    long challengeId = ParamUtil.getLong(request, "challengeId");
	    long cocreationId = ParamUtil.getLong(request, "cocreationId");
	    String[] participants = ParamUtil.getParameterValues(request, "participants");
	    String req = ParamUtil.getString(request, "request");
	    String message = ParamUtil.getString(request, "message");
	    
	    _log.info("CollaborativecreationPortlet - addParticipant");
        _log.info("challengeId: "+challengeId);
       
	    try {
	    	Cocreation cocreation;     
	    	if (cocreationId == 0) {
	    	   cocreation = CocreationLocalServiceUtil.addCocreation(challengeId, serviceContext.getUserId(), req, message, serviceContext);
	    	}else{
	    	   cocreation = CocreationLocalServiceUtil.getCocreation(cocreationId);
	    	}
	    	for(String participant : participants){
	    		 _log.info("participant: "+participant);
	    		User user = UserLocalServiceUtil.getUser(Long.parseLong(participant));
	    		CocreatorLocalServiceUtil.addCocreator(cocreation.getCocreationId(), user.getUserId(), serviceContext);
	    		sendCocreationNotification("Dear user", "Have a nice day!", 
		    			"You became co-creator for the challenge "+ ChallengeLocalServiceUtil.getChallenge(challengeId).getTitle() + 
		    			": " + ChallengeLocalServiceUtil.getChallenge(challengeId).getDescription(), 
		    			user.getUserId(), serviceContext.getUserId(), 
		    			UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName(), cocreation.getCocreationId(), 
		    			ChallengeLocalServiceUtil.getChallenge(challengeId).getTitle(), ChallengeLocalServiceUtil.getChallenge(challengeId).getDesiredOutcome(), serviceContext);
	    	}
	    	
	        SessionMessages.add(request, "actionSuccess");
	        if (redirectTo.equalsIgnoreCase("")) {
	        	response.setRenderParameter("mvcPath", "/challenges.jsp");
	        }else {
	        	response.sendRedirect(redirectTo);
	        }
	    } catch (Exception e) {
	    	SessionErrors.add(request, "actionError");
	    	response.setRenderParameter("mvcPath", "/challenges.jsp");
	    }
	}
	
	@ProcessAction(name = "requestParticipation")
	public void requestParticipation(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException, ParseException {

	    ServiceContext serviceContext = ServiceContextFactory.getInstance(
	        Challenge.class.getName(), request);

	    String redirectTo = ParamUtil.getString(request, "redirectTo");
	    long challengeId = ParamUtil.getLong(request, "challengeId");
	    String req = ParamUtil.getString(request, "request");
	    
	    _log.info("CollaborativecreationPortlet - requestParticipation");
        _log.info("challengeId: "+challengeId);
       
	    try {
	    	sendChallengeNotification("Dear user", "Have a nice day!", 
	    			"The user " + UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName() + " requests to participate in the challenge "+ ChallengeLocalServiceUtil.getChallenge(challengeId).getTitle() + 
	    			": " + req, challengeId,
	    			ChallengeLocalServiceUtil.getChallenge(challengeId).getUserId(), serviceContext.getUserId(), 
	    			UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName(), true, serviceContext);
	        SessionMessages.add(request, "actionSuccess");
		    response.sendRedirect(redirectTo);
	    } catch (Exception e) {
	    	SessionErrors.add(request, "actionError");
	        response.setRenderParameter("mvcPath", "/challengeDetails.jsp");
	    }
	}
	
	@ProcessAction(name = "declineRequest")
	public void declineRequest(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException, ParseException {

	    ServiceContext serviceContext = ServiceContextFactory.getInstance(
	        Challenge.class.getName(), request);

	    String redirectTo = ParamUtil.getString(request, "redirectTo");
	    long challengeId = ParamUtil.getLong(request, "challengeId");
	    String participant = ParamUtil.getString(request, "participant");
	    
	    _log.info("CollaborativecreationPortlet - declineRequest");
        _log.info("challengeId: "+challengeId);
       
	    try {
	    	User user = UserLocalServiceUtil.getUser(Long.parseLong(participant));
	    	sendChallengeNotification("Dear user", "I'm sorry to tell you that", 
	    			"the user " + UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName() + " has rejected your request to participate in the challenge "+ ChallengeLocalServiceUtil.getChallenge(challengeId).getTitle(), 
	    			challengeId,
	    			user.getUserId(), serviceContext.getUserId(), 
	    			UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName(), false, serviceContext);
	        SessionMessages.add(request, "actionSuccess");
			/* response.sendRedirect(redirectTo); */
	        response.setRenderParameter("mvcPath", "/challenges.jsp");
	    } catch (Exception e) {
	    	SessionErrors.add(request, "actionError");
	    	response.setRenderParameter("mvcPath", "/challenges.jsp");
	    }
	}
	
	public void sendCocreationNotification(String dearUser, String regards, String textMessage, long destinationUderId, long senderUserId, String senderUserName, long cocreationId, String challengeTitle, String desiredOutcome, ServiceContext serviceContext) throws PortalException, SystemException{
		
		_log.info("CollaborativecreationPortlet - sendCocreationNotification");
        _log.info("destinationUderId: "+destinationUderId);
        _log.info("senderUserId: "+senderUserId);
        _log.info("senderUserName: "+senderUserName);
        _log.info("cocreationId: "+cocreationId);
        _log.info("challengeTitle: "+challengeTitle);
        _log.info("desiredOutcome: "+desiredOutcome);
		
		if(webNotification){
			JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();
			notificationEventJSONObject.put("title","Co-creation Notification");
			notificationEventJSONObject.put("text-message",textMessage);
			notificationEventJSONObject.put("userId",senderUserId);
			notificationEventJSONObject.put("challengeTitle",challengeTitle);
			notificationEventJSONObject.put("desiredOutcome",desiredOutcome);
			notificationEventJSONObject.put("sender",senderUserName);
			notificationEventJSONObject.put("classPK", cocreationId);	
			notificationEventJSONObject.put("type", "cocreation");
			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(destinationUderId, CollaborativecreationPortletKeys.COLLABORATIVECREATION, System.currentTimeMillis(), UserNotificationDeliveryConstants.TYPE_WEBSITE, senderUserId, notificationEventJSONObject.toString(), false, serviceContext);
		}

		if(emailNotification){
			User destinationUser = UserLocalServiceUtil.fetchUser(destinationUderId);
			User senderUser = UserLocalServiceUtil.fetchUser(senderUserId);
			
			try {
				String adminEmailFromAddress = senderUser.getEmailAddress();
				String adminEmailFromName = senderUser.getFullName();
				InternetAddress from = new InternetAddress(adminEmailFromAddress,adminEmailFromName);
				String textMail = dearUser + ",\n\n" + textMessage;		
				textMail += "\n\n"+ regards +"\n";	
				/* textMail += extractPortalHomeURL(); */
				
				 _log.info("destinationUser.getEmailAddress(): "+destinationUser.getEmailAddress());
			     _log.info("from.getAddress(): "+from.getAddress());
			        
				sendMail(from.getAddress(), "Notifications service", destinationUser.getEmailAddress(), destinationUser.getFullName(), "Co-creation Notification", textMail, false);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendChallengeNotification(String dearUser, String regards, String textMessage, long challengeId, long destinationUserId, long senderUserId, String senderUserName, boolean request, ServiceContext serviceContext) throws PortalException, SystemException{
		
		_log.info("CollaborativecreationPortlet - sendChallengeNotification");
        _log.info("challengeId: "+challengeId);
        _log.info("destinationUserId: "+destinationUserId);
        _log.info("senderUserId: "+senderUserId);
        _log.info("senderUserName: "+senderUserName);
        _log.info("textMessage: "+textMessage);
		
		if(webNotification){
			JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();
			notificationEventJSONObject.put("title","Co-creation Notification");
			notificationEventJSONObject.put("text-message",textMessage);
			notificationEventJSONObject.put("userId",senderUserId);
			notificationEventJSONObject.put("sender",senderUserName);
			notificationEventJSONObject.put("participant",senderUserId);
			notificationEventJSONObject.put("classPK", challengeId);
			notificationEventJSONObject.put("request", request);
			notificationEventJSONObject.put("type", "challenge");
			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(destinationUserId, CollaborativecreationPortletKeys.COLLABORATIVECREATION, System.currentTimeMillis(), UserNotificationDeliveryConstants.TYPE_WEBSITE, senderUserId, notificationEventJSONObject.toString(), false, serviceContext);
		}
	
		if(emailNotification){
			User destinationUser = UserLocalServiceUtil.fetchUser(destinationUserId);
			User senderUser = UserLocalServiceUtil.fetchUser(senderUserId);
			
			try {
				String adminEmailFromAddress = senderUser.getEmailAddress();
				String adminEmailFromName = senderUser.getFullName();
				InternetAddress from = new InternetAddress(adminEmailFromAddress,adminEmailFromName);
				String textMail = dearUser + ",\n\n" + textMessage;		
				textMail += "\n\n"+ regards +"\n";	
				/* textMail += extractPortalHomeURL(); */
				
				 _log.info("destinationUser.getEmailAddress(): "+destinationUser.getEmailAddress());
			     _log.info("from.getAddress(): "+from.getAddress());
			        
				sendMail(from.getAddress(), "Notifications service", destinationUser.getEmailAddress(), destinationUser.getFullName(), "Co-creation Notification", textMail, false);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String extractPortalHomeURL() {
		
		//HTTPS SERVER PARAMETER
		boolean secure = false; 
		Company company;
		try {
			company = CompanyLocalServiceUtil.getCompanies().get(0);
			
			if (company == null)
				return StringPool.BLANK;
			
			String portalURL = PortalUtil.getPortalURL(company.getVirtualHostname(), PortalUtil.getPortalLocalPort(secure), secure);
		
			if (portalURL != null && !portalURL.isEmpty()) {
				URL url = new URL(portalURL);
				return url.getProtocol() + "://" + url.getHost();
			}
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return StringPool.BLANK;
	}
	
	public static void sendMail(String fromMail, String fromName,
			String toMail, String toName,
			String subject, String mailBody, boolean htmlFormat) throws UnsupportedEncodingException{

		InternetAddress from = new InternetAddress(fromMail, fromName);
		InternetAddress to = new InternetAddress(toMail, toName);
		
		MailMessage message = new MailMessage(from, to, subject, mailBody, htmlFormat);
		
		Message myMessage = new Message();
		myMessage.setDestinationName(DestinationNames.MAIL);
		myMessage.setPayload(message);
		MessageBusUtil.sendMessage(myMessage.getDestinationName(), myMessage);
	}
	
	/*Creazione cartella nella Document Library*/
	public Folder createFolder(ActionRequest actionRequest,ThemeDisplay themeDisplay, String name){
        boolean folderExist = isFolderExist(themeDisplay, name);
        Folder folder = null;
		if (!folderExist){
			long repositoryId = themeDisplay.getScopeGroupId();		
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
				folder = DLAppServiceUtil.addFolder(repositoryId, PARENT_FOLDER_ID, name, ROOT_FOLDER_DESCRIPTION, serviceContext);
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}			
		}
		return folder;
	}
	
	/*Verifica esistenza cartella*/
	public boolean isFolderExist(ThemeDisplay themeDisplay, String name){
		boolean folderExist = false;
		try {
			DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, name);
			folderExist = true;
		} catch (Exception e) {	
		}
		return folderExist;
	}
	
	/*Seleziona cartella*/
	public Folder getFolder(ThemeDisplay themeDisplay, String name){
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, name);
		} catch (Exception e) {}
		return folder;
	}
	
	/*Caricamento file nella Document Library*/
	public void fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest, Map<String, FileItem[]> files, String prefix, String field, String name){
		Folder folder = getFolder(themeDisplay, name);
		InputStream is;
		File file;
		String title, description, mimeType;
		long repositoryId;
		for (Entry<String, FileItem[]> file2 : files.entrySet()) {
			FileItem item[] = file2.getValue();
			try {
				for (FileItem fileItem : item) {
					title = fileItem.getFileName();
					description = title;
					repositoryId = themeDisplay.getScopeGroupId();
					mimeType = fileItem.getContentType();	
					file = fileItem.getStoreLocation();
					is = fileItem.getInputStream();
					if (!title.equalsIgnoreCase("") && fileItem.getFieldName().equalsIgnoreCase(field)){
				    	try {
							ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
							DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), title, mimeType, prefix+title, description, "", is, file.getTotalSpace(), serviceContext);
				    	} catch (PortalException e) {
							e.printStackTrace();
						} catch (SystemException e) {
							e.printStackTrace();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}
	
	/*Seleziona tutti i file*/
	public Map<String, String> getAllFileLinks(ThemeDisplay themeDisplay, String name){
		Map<String, String> urlMap = new HashMap<String, String>();
		long repositoryId = themeDisplay.getScopeGroupId();
		try {
			Folder folder = getFolder(themeDisplay, name);
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
			 for (FileEntry file : fileEntries) {
				String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" + file.getFolderId() +  "/" +file.getTitle();
				/*urlMap.put(file.getTitle().split("\\.")[0], url);*/
				urlMap.put(file.getTitle(), url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return urlMap;
	}
	
	private static String ROOT_FOLDER_NAME = "DEMETER";
	private static String ROOT_FOLDER_DESCRIPTION = "DEMETER Documents Repository";
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	
	private static final Log _log = LogFactoryUtil.getLog(
			CollaborativecreationPortlet.class);
	
	@Reference
	private ChallengeLocalService _challengeLocalService;
}