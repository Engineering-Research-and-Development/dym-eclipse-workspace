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

package it.eng.rd.sandbox.request.service.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;

import it.eng.rd.hubcap.sandbox.request.constants.SandboxConstants;
import it.eng.rd.hubcap.sandbox.request.model.JSONResponse;
import it.eng.rd.sandbox.request.service.base.SandboxServiceBaseImpl;

/**
 * The implementation of the sandbox remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.rd.sandbox.request.service.SandboxService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SandboxServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=sandbox",	
		"json.web.service.context.path=Sandbox"
	},
	service = AopService.class
)
public class SandboxServiceImpl extends SandboxServiceBaseImpl {
	
	private final static Log LOG = LogFactoryUtil.getLog(SandboxServiceImpl.class);
	
	String sandboxAccessService = GetterUtil.getString(PropsUtil.get(SandboxConstants.SANDBOX_ACCESS_SERVICE));
	
	String sandboxPopulateService = GetterUtil.getString(PropsUtil.get(SandboxConstants.SANDBOX_ACCESS_SERVICE));
	
	@SuppressWarnings("null")
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "getSendName", method = "GET")
	public com.liferay.portal.kernel.json.JSONObject getSendName() throws PortalException, SystemException {
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("-----------------------------------------------------------------------------------------------------------------------");
			LOG.debug("getSendName method");
		}
		
		ServiceContext serviceContext = new ServiceContext();
		String ritorno = null;
		String status = null;
		JSONObject article;
		String message = null;
			
		long uid2 = ServiceContextThreadLocal.getServiceContext().getUserId();
		if (LOG.isDebugEnabled())
			LOG.debug("current user, uid2: "+uid2);
		long uid = serviceContext.getUserId();
		User uu = UserServiceUtil.getUserById(uid2);
		String screenname = uu.getScreenName();
		 
		JSONResponse jResponse = new JSONResponse();
		
//		List<Team> teams = TeamLocalServiceUtil.getUserTeams(uu.getUserId());	
		
		HttpServletRequest httpServletRequest = ServiceContextThreadLocal.getServiceContext().getRequest();
		
		List<String> teams = getTeams(httpServletRequest);
		
//		if (LOG.isDebugEnabled())
//			LOG.debug("teams of user: "+teams.toString());		 
					 
		JSONArray stateArray = JSONFactoryUtil.createJSONArray();	
			
		DefaultHttpClient client = new DefaultHttpClient();

		//String sandboxURL = "http://sboxmanager.local/sandboxfromportal/users/accessSandbox";
		/*test url*/
		//String sandboxURL = "http://195.201.83.104/api/dservice/api/v1/import/accessSandbox";
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("screenname "+screenname);
			LOG.debug("sandboxURL "+sandboxAccessService);
		}
		
		
				 
		if( !(teams != null && teams.isEmpty() )){
					 
			/*POST*/
			HttpPost post = new HttpPost(sandboxAccessService);
			post.addHeader("Content-Type","application/json");
			String json = "{\"screenname\":\""+screenname+"\"}";
			
			/*GET check TODO*/
//			HttpGet get = new HttpGet(sandboxURL);	 
//			get.addHeader("Content-Type","application/json");
				 
			try {
				StringEntity se = new StringEntity(json);
				post.setEntity(se);
				
				HttpResponse  ServerResponse = client.execute(post);
				
				BufferedReader rd = new BufferedReader(new InputStreamReader(ServerResponse.getEntity().getContent()));
				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}
				LOG.info("POST Response: " + result.toString());
				status = (new JSONFactoryUtil().createJSONObject(result.toString())).getString("status");
				message = (new JSONFactoryUtil().createJSONObject(result.toString())).getString("message");
				
				article = JSONFactoryUtil.createJSONObject();
				article.put("status", status);
				article.put("message", message);
				
				stateArray.put(article);
				
				if (LOG.isDebugEnabled()) {
					LOG.debug("status: " + status);
					LOG.debug("message: " + message);
				}

				if (status.equals("SUCCESS")) {
					jResponse.setSuccess(true);
					jResponse.setData(stateArray);
					if (LOG.isDebugEnabled()) {
						LOG.debug("status success IN ");
						LOG.debug("stateArray "+stateArray.toString());
					}
			    }else{
			    	if (LOG.isDebugEnabled())
						LOG.debug("status success OUT ");
					jResponse.setSuccess(false);
					jResponse.setData(stateArray);
			    }
			 	ritorno = "{\"status\":\""+status+"\\,\"message\":\""+message+"\"}"; 	
					 
			} catch (Exception e) {
				LOG.error("An error occurred in getSendName method, POST screenname");
				LOG.error(e.getMessage(), e);
				stateArray.put("An error occurred in getSendName method, POST screenname");
				jResponse.setSuccess(false);
				jResponse.setData(stateArray);
			}
		} else {
			article = JSONFactoryUtil.createJSONObject();
			article.put("status", "false");
			article.put("message", "You don't have permission to access the sandbox. Please contact the administrator");
			stateArray.put(article);
			jResponse.setSuccess(false);
			jResponse.setData(stateArray);
		}
		return jResponse.toJSONObject();
	 }

	
	@SuppressWarnings("null")
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "getSendModel", method = "GET")
	public JSONObject getSendModel(String m_id, String t_id) throws PortalException, SystemException {
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("-----------------------------------------------------------------------------------------------------------------------");
			LOG.debug("getSendModel method");
		}
			
		ServiceContext serviceContext = new ServiceContext();
		String ritorno = null;
		String status = null;
		JSONObject article;
		String message = null;
		
		long uid2 = ServiceContextThreadLocal.getServiceContext().getUserId();
		if (LOG.isDebugEnabled())
			LOG.debug("current user, uid2: "+uid2);
		long uid = serviceContext.getUserId();
		 
		User uu = UserServiceUtil.getUserById(uid2);
		String screenname = uu.getScreenName();
		 
		JSONResponse jResponse = new JSONResponse();
		 
//		List<Team> tt= TeamLocalServiceUtil.getUserTeams(uu.getUserId());
		HttpServletRequest httpServletRequest = ServiceContextThreadLocal.getServiceContext().getRequest();
		
		List<String> tt = getTeams(httpServletRequest);
		
		if (LOG.isDebugEnabled()) {
//			LOG.debug("teams of user: "+tt.toString());		 
			LOG.debug("model_id: "+m_id.toString());	
			LOG.debug("tool_id: "+t_id.toString());
		}
		
		JSONArray stateArray = JSONFactoryUtil.createJSONArray();	
			
		DefaultHttpClient client = new DefaultHttpClient();
		
//		String  sandboxURL =  "http://sboxmanager.local/sandboxfromportal/cart/populateSandboxCart";
//		String  sandboxURL =  "http://195.201.83.104/api/dservice/api/v1/import/populateSandboxCart";
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("screenname: "+screenname);
			LOG.debug("sandboxURL: "+sandboxPopulateService);
		}
				 
		if( !(tt != null && tt.isEmpty() )) 
		{
			
			if(!(m_id.isEmpty()) && !(t_id.isEmpty())) 
			{	
				/*POST*/
				HttpPost post = new HttpPost(sandboxPopulateService);
				post.addHeader("Content-Type","application/json");
				String json = "{\"screen_name\":\""+screenname+"\",\"model_id\":\""+m_id+"\",\"tool_id\":\""+t_id+"\"}";
	 
				try {
					StringEntity se= new StringEntity(json);
					post.setEntity(se);
					
					HttpResponse  ServerResponse = client.execute(post);
	
					BufferedReader rd = new BufferedReader(new InputStreamReader(ServerResponse.getEntity().getContent()));
					StringBuffer result = new StringBuffer();
					String line = "";
					while ((line = rd.readLine()) != null) {
						result.append(line);
					}
	
					if (LOG.isDebugEnabled())
						LOG.debug("Response: " + result.toString());
					
					status = (new JSONFactoryUtil().createJSONObject(result.toString())).getString("status");
					message = (new JSONFactoryUtil().createJSONObject(result.toString())).getString("message");
	
					article = JSONFactoryUtil.createJSONObject();
					article.put("status", status);
					article.put("message", message);
					stateArray.put(article);
	
					if (LOG.isDebugEnabled()) {
						LOG.debug("status: " + status);
						LOG.debug("message: " + message);
					}
	
					if (status.equals("SUCCESS")) 
					{
						if (LOG.isDebugEnabled()) {
							LOG.debug("status success IN");
							LOG.debug("stateArray: "+stateArray.toString());
						}
						jResponse.setSuccess(true);
						jResponse.setData(stateArray);
						
					} else {
						if (LOG.isDebugEnabled())
							LOG.debug("status success OUT");
						jResponse.setSuccess(false);
						jResponse.setData(stateArray);
					}
					ritorno = "{\"status\":\""+status+"\\,\"message\":\""+message+"\"}"; 	
	 
				} catch (Exception e) {
					LOG.error("An error occurred in getSendName method, POST screenname, model_id, tool_id");
					LOG.error(e.getMessage(), e);
					stateArray.put("An error occurred in getSendName method, POST screenname, model_id, tool_id");
					jResponse.setSuccess(false);
					jResponse.setData(stateArray);
				}
 
			} else {
				article = JSONFactoryUtil.createJSONObject();
				article.put("status", "false");
				article.put("message", "Please check Model Id and Tool Id. Contact the administrator");
				stateArray.put(article);
				jResponse.setSuccess(false);
				jResponse.setData(stateArray);
			}
		 
		} else {
			article = JSONFactoryUtil.createJSONObject();
			article.put("status", "false");
			article.put("message", "You don't have permission to access the sandbox. Please contact the administrator");
			stateArray.put(article);
			jResponse.setSuccess(false);
			jResponse.setData(stateArray);
		}
		return jResponse.toJSONObject();
	} 

	@SuppressWarnings("null")
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "getSendTool", method = "GET")
	public JSONObject getSendTool(String t_id) throws PortalException, SystemException {
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("-----------------------------------------------------------------------------------------------------------------------");
			LOG.debug("getSendTool method");
		}
		
		ServiceContext serviceContext = new ServiceContext();
		String ritorno=null;
		String status = null;
		JSONObject article;
		String message = null;
			
		long uid2 = ServiceContextThreadLocal.getServiceContext().getUserId();
		if (LOG.isDebugEnabled())
			LOG.debug("current user, uid2: "+uid2);
		long uid= serviceContext.getUserId();
			 
		User uu = UserServiceUtil.getUserById(uid2);
		 
		String screenname = uu.getScreenName();
		 
		JSONResponse jResponse = new JSONResponse();
		 
//		List<Team> tt = TeamLocalServiceUtil.getUserTeams(uu.getUserId());	 
		
		HttpServletRequest httpServletRequest = ServiceContextThreadLocal.getServiceContext().getRequest();
		
		List<String> tt = getTeams(httpServletRequest);
		
		if (LOG.isDebugEnabled()) {
//			LOG.debug("teams of user: "+tt.toString());
			LOG.debug("tool_id "+t_id.toString());
		}
			
		JSONArray stateArray = JSONFactoryUtil.createJSONArray();	
		DefaultHttpClient client = new DefaultHttpClient();
		
//		String sandboxURL = "http://sboxmanager.local/sandboxfromportal/cart/populateSandboxCart";
//		String  sandboxURL =  "http://195.201.83.104/api/dservice/api/v1/import/populateSandboxCart";
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("screenname: "+screenname);
			LOG.debug("sandboxURL: "+sandboxPopulateService);
		}
				 
		if( !(tt != null && tt.isEmpty())) {
				   
			if(!(t_id.isEmpty())) {	
					 
				HttpPost post = new HttpPost(sandboxPopulateService);
				post.addHeader("Content-Type","application/json");
				String json = "{\"screen_name\":\""+screenname+"\",\"tool_id\":\""+t_id+"\"}";
					 
				try {
					StringEntity se= new StringEntity(json);
					post.setEntity(se);
					HttpResponse  ServerResponse = client.execute(post);
					BufferedReader rd = new BufferedReader(new InputStreamReader(ServerResponse.getEntity().getContent()));
					StringBuffer result = new StringBuffer();
					String line = "";
					while ((line = rd.readLine()) != null) {
						result.append(line);
					}
					if (LOG.isDebugEnabled())
						LOG.debug("Response: " + result.toString());
					status = (new JSONFactoryUtil().createJSONObject(result.toString())).getString("status");
					message = (new JSONFactoryUtil().createJSONObject(result.toString())).getString("message");
					article = JSONFactoryUtil.createJSONObject();
					article.put("status", status);
					article.put("message", message);
					stateArray.put(article);
					if (LOG.isDebugEnabled()) {
						LOG.debug("status: " + status);
						LOG.debug("message: " + message);
					}

					if (status.equals("SUCCESS")) {
						if (LOG.isDebugEnabled()) {
							LOG.debug("status success IN");
							LOG.debug("stateArray: "+stateArray.toString());
						}
						jResponse.setSuccess(true);
						jResponse.setData(stateArray);
						 
					}else{
						if (LOG.isDebugEnabled())
							LOG.debug("status success OUT");
						jResponse.setSuccess(false);
						jResponse.setData(stateArray);
					}
					ritorno = "{\"status\":\""+status+"\\,\"message\":\""+message+"\"}"; 	
					 
				} catch (Exception e) {
					LOG.error("An error occurred in getSendTool method, POST screenname, tool_id");
					LOG.error(e.getMessage(), e);
					stateArray.put("An error occurred in getSendTool method, POST screenname, tool_id");
					jResponse.setSuccess(false);
			    	jResponse.setData(stateArray);
				}

			} else {
				article = JSONFactoryUtil.createJSONObject();
				article.put("status", "false");
				article.put("message","Please check Model Id and Tool Id. Contact the administrator");
				stateArray.put(article);
				jResponse.setSuccess(false);
				jResponse.setData(stateArray);
			}
		} else {
			article = JSONFactoryUtil.createJSONObject();
			article.put("status", "false");
			article.put("message", "You don't have permission to access the sandbox. Please contact the administrator");
			stateArray.put(article);
			jResponse.setSuccess(false);
			jResponse.setData(stateArray);
		}
	    return jResponse.toJSONObject();
	}
	
	
	/*IDM endpoint to get IDM user roles*/
	
	
	
	private List<String> getUserInfo(String idm_host, String access_token) throws PortalException {
		LOG.info("Invoking IDM user endpoint: "+idm_host+SandboxConstants.IDM_USER_INFO);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("idm_host: "+idm_host);
	        LOG.debug("access_token: "+access_token);
		}
		List<String> roles = new ArrayList<String>();
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpGet getUserInfo = new HttpGet(idm_host+SandboxConstants.IDM_USER_INFO);
			getUserInfo.addHeader(SandboxConstants.CONTENT_TYPE,SandboxConstants.APPLICATION_JSON);
			getUserInfo.addHeader(SandboxConstants.AUTHORIZATION,SandboxConstants.BEARER +" " + access_token);
    		
			HttpResponse  httpUserInfoResponse = client.execute(getUserInfo);
			int statusUserInfo = httpUserInfoResponse.getStatusLine().getStatusCode();
			
			if (statusUserInfo == HttpStatus.SC_OK) {
				HttpEntity userInfoEntity = httpUserInfoResponse.getEntity();
				String userInfoResponse = EntityUtils.toString(userInfoEntity);
				JSONObject userInfoJSON = JSONFactoryUtil.createJSONObject(userInfoResponse);
				
				if (LOG.isDebugEnabled())
					LOG.debug("IDM User Info response: "+userInfoJSON.toJSONString());
				
				JSONArray idmUserRoles = userInfoJSON.getJSONArray("roles");
				
				idmUserRoles.forEach(item -> {
				    JSONObject obj = (JSONObject) item;
				    
				    if (Validator.isNotNull(obj.getString("name"))) {
				    	if (obj.getString("name").equals("provider") | obj.getString("name").equals("consumer")) {
				    		roles.add(obj.getString("name"));
				    		LOG.info("role_name: "+obj.getString("name"));
				    	}
				    }
				});
				
			}
			return roles;
			
		} catch (PortalException | IOException e) {
			throw new PortalException("An error occurred while invoking IDM user endpoint: " + e.getMessage());
		}
	}
	
	private List<String> getTeams(HttpServletRequest httpServletRequest) throws PortalException {
		String id = StringPool.BLANK;
		String id_app = StringPool.BLANK;
		String idm_host = GetterUtil.getString(PropsUtil.get(SandboxConstants.IDM_HOST));
		
		HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(httpServletRequest);
		String logoutDYMAT = CookieKeys.getCookie(originalRequest, "LODYMAT");
        if (LOG.isDebugEnabled()) {
        	LOG.debug("logoutDYMAT "+logoutDYMAT);
        }
        
        List<String> roles = new ArrayList<String>();
        roles = getUserInfo(idm_host, logoutDYMAT);
        
        return roles;
	}

/*	private String getXsubjectToken(String idmUrl) throws PortalException {
		String xSubjectToken = StringPool.BLANK;
		
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpPost post = new HttpPost(idmUrl+SandboxConstants.IDM_API_AUTH_TOKENS);
			post.addHeader("Content-Type","application/json");
			
			String idmEmailAdmin = GetterUtil.getString(PropsUtil.get(SandboxConstants.IDM_EMAIL_ADMIN));
			String idmPasswordAdmin = GetterUtil.getString(PropsUtil.get(SandboxConstants.IDM_PWD_ADMIN));
			 
			JSONObject adminInfo = (new JSONFactoryUtil().createJSONObject());
			adminInfo.put("name", idmEmailAdmin);
			adminInfo.put("password", idmPasswordAdmin);
			StringEntity se = new StringEntity(adminInfo.toString());
			post.setEntity(se);
			HttpResponse  httpResponse = client.execute(post);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			
			HttpEntity entityToken = httpResponse.getEntity();
			String getTokenResponse = EntityUtils.toString(entityToken);
			JSONObject jsonObjectToken = JSONFactoryUtil.createJSONObject(getTokenResponse);
	
			if (statusCode == HttpStatus.SC_CREATED) {
			    
				xSubjectToken = httpResponse.getFirstHeader("X-Subject-Token").getValue();
				
				if (LOG.isDebugEnabled()) {
					LOG.debug("xSubjectToken: " + xSubjectToken);
					LOG.debug("Success Case, X-Auth-token response " + jsonObjectToken);
				}
				    
				if (Validator.isNotNull(xSubjectToken)) {
					return xSubjectToken;
				} else {
					throw new PortalException("token is null!");
				}

			} else {
				LOG.error("Failed Case, X-Auth-token response: " + jsonObjectToken);
				JSONObject responseMessage = jsonObjectToken.getJSONObject ("error");
				String message = responseMessage.getString("message");
				throw new PortalException(message);
			}
			
		} catch (PortalException | IOException e) {
			throw new PortalException("error "+e.getMessage());
		}
		
		
	}
 
 	private Object[] getUserInfo(String idm_host, String access_token) throws PortalException {
		LOG.info("Invoking IDM user endpoint: "+idm_host+SandboxConstants.IDM_USER_INFO);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("idm_host: "+idm_host);
	        LOG.debug("access_token: "+access_token);
		}
		
		String idApplication = StringPool.BLANK;
		String idUser = StringPool.BLANK;
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpGet getUserInfo = new HttpGet(idm_host+SandboxConstants.IDM_USER_INFO);
			getUserInfo.addHeader(SandboxConstants.CONTENT_TYPE,SandboxConstants.APPLICATION_JSON);
			getUserInfo.addHeader(SandboxConstants.AUTHORIZATION,SandboxConstants.BEARER +" " + access_token);
    		
			HttpResponse  httpUserInfoResponse = client.execute(getUserInfo);
			int statusUserInfo = httpUserInfoResponse.getStatusLine().getStatusCode();
			
			if (statusUserInfo == HttpStatus.SC_OK) {
				HttpEntity userInfoEntity = httpUserInfoResponse.getEntity();
				String userInfoResponse = EntityUtils.toString(userInfoEntity);
				JSONObject userInfoJSON = JSONFactoryUtil.createJSONObject(userInfoResponse);
				
				idApplication = userInfoJSON.getString("app_id");
				idUser = userInfoJSON.getString("id");
				
				if (LOG.isDebugEnabled()) {
					LOG.debug("userInfo response: "+userInfoJSON.toJSONString());
					LOG.debug("idApplication: "+idApplication);
					LOG.debug("idUser: "+idUser);
				}
				
			}
			return new Object[] {idApplication, idUser};
			
		} catch (Exception e) {
			return new Object[] {"", ""};
		}
	}*/
	
	/*
	private List<String> getUserRole(String idm_host, String id_app, String id, String x_auth_token) throws PortalException {
		String uri = idm_host + SandboxConstants.IDM_APPLICATIONS + id_app + SandboxConstants.IDM_USERS + id +SandboxConstants.IDM_ROLES;
		
		LOG.info("Invoking IDM user roles: "+uri);
		
		List<String> roles = new ArrayList<String>();
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpGet getIdmUserRoles = new HttpGet(uri);
			getIdmUserRoles.addHeader(SandboxConstants.CONTENT_TYPE,SandboxConstants.APPLICATION_JSON);
			getIdmUserRoles.addHeader(SandboxConstants.X_AUTH_TOKEN, x_auth_token);
    		
			HttpResponse  httpIdmUserRolesResponse = client.execute(getIdmUserRoles);
			int statusCode = httpIdmUserRolesResponse.getStatusLine().getStatusCode();
			
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity idmUserRolesEntity = httpIdmUserRolesResponse.getEntity();
				String idmUserRolesResponse = EntityUtils.toString(idmUserRolesEntity);
				JSONObject idmUserRolesJSON = JSONFactoryUtil.createJSONObject(idmUserRolesResponse);
				if (LOG.isDebugEnabled())
					LOG.debug("IDM user roles response: "+idmUserRolesJSON.toJSONString());
				
				JSONArray idmUserRoles = idmUserRolesJSON.getJSONArray("role_user_assignments");
				
				idmUserRoles.forEach(item -> {
				    JSONObject obj = (JSONObject) item;
				    
				    if (Validator.isNotNull(obj.getString("role_id"))) {
				    	if (obj.getString("role_id").equals("provider") | obj.getString("role_id").equals("consumer")) {
				    		roles.add(obj.getString("role_id"));
				    	}
				    }
				});
			}
			
			if (statusCode == HttpStatus.SC_NOT_FOUND) {
				 throw new PortalException("An error occurred while invoking IDM user roles, statusCode: 404");
			}
			
			return roles;
			
		} catch (PortalException | IOException e) {
			throw new PortalException(e);
		}
				
	}*/
	
	/*private List<String> getTeams(HttpServletRequest httpServletRequest) throws PortalException {
		String id = StringPool.BLANK;
		String id_app = StringPool.BLANK;
		String idm_host = GetterUtil.getString(PropsUtil.get(SandboxConstants.IDM_HOST));
		
		HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(httpServletRequest);
		String logoutDYMAT = CookieKeys.getCookie(originalRequest, "LODYMAT");
        String xSubjectToken = getXsubjectToken(idm_host);
        if (LOG.isDebugEnabled()) {
        	LOG.debug("logoutDYMAT "+logoutDYMAT);
            LOG.debug("xSubjectToken "+xSubjectToken);
        }
        
        Object[] userInfo = new Object[] {id_app, id};
        if (!xSubjectToken.startsWith("error")) {
        	userInfo = getUserInfo(idm_host, logoutDYMAT);
        	id_app = (String)userInfo[0]; 
        	id = (String)userInfo[1];
        }
        
        List<String> roles = new ArrayList<String>();
        roles =	getUserRole(idm_host, id_app, id, xSubjectToken);
        return roles;
	}*/
	
	
}