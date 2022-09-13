<%@ include file="/init.jsp" %>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ page import="javax.portlet.PortletConfig"%>
<%@ page import="javax.portlet.PortletSession" %>

<%@ page import="com.liferay.petra.string.StringPool"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaException" %>
<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Locale" %>
<%@ page import="it.eng.rd.idp.registration.model.RegistrationInfo" %>

<%@ page import="it.eng.rd.idp.registration.constants.IdpRegistrationPortletKeys" %>

<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	Log log = LogFactoryUtil.getLog("view.jsp");
	RegistrationInfo ri = (RegistrationInfo) request.getAttribute("registrationInfo");
	if (ri==null){
		ri = new RegistrationInfo();
	}
	
 	String active = StringPool.BLANK;
	if (ri.getOrganizationType()!=null && ri.getOrganizationType().equals(IdpRegistrationPortletKeys.DIH)){
		active = "active";
	}
	boolean termsOfUse = ri!=null && ri.getTermsOfUse()!=null && ri.getTermsOfUse().equals(IdpRegistrationPortletKeys.ON);
	boolean grantAddContent = ri!=null && ri.getGrantToAddContent()!=null && ri.getGrantToAddContent().equals(IdpRegistrationPortletKeys.ON);
	
// 	log.info("[view.jsp] registrationInfo: "+ri.toString());
// 	log.info("[view.jsp] active: "+active);
// 	log.info("[view.jsp] termsOfUse: "+termsOfUse);
// 	log.info("[view.jsp] grantAddContent: "+grantAddContent);
	
%>

<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script type="text/javascript">

	jQuery(document).ready(function(){
		jQuery("#questionAddContentContainer").toggle();
		showHideQuestion();
		
		<%if (termsOfUse){%>
			jQuery('#termsOfUseCheckbox').prop( "checked", true );
			jQuery('#termsOfUseCheckbox').val('on');
		<%} %>
		
		<%if (grantAddContent){%>
			jQuery('#addContentCheckBox').prop( "checked", true );
			jQuery('#addContentCheckBox').val('on');
		<%} %>
	});
	
	jQuery('#termsOfUseCheckbox').change(function() {
	    if(this.checked != true) {
			jQuery('#termsOfUseCheckbox').prop( "checked", false );
			jQuery('#termsOfUseCheckbox').val('off');
	    } else {
			jQuery('#termsOfUseCheckbox').prop( "checked", true );
			jQuery('#termsOfUseCheckbox').val('on');
	    } 
	});
	
	jQuery('#addContentCheckBox').change(function() {
    	if(this.checked != true) {
			jQuery('#addContentCheckBox').prop( "checked", false );
			jQuery('#addContentCheckBox').val('off');
	    } else {
			jQuery('#addContentCheckBox').prop( "checked", true );
			jQuery('#addContentCheckBox').val('on');
	    } 
	});
	
	function showHideQuestion(){
	    var dataValue=jQuery('#orgType').val();
	    if(dataValue=="<%=IdpRegistrationPortletKeys.DIH%>"){
		    jQuery("#questionAddContentContainer").slideToggle(200);
		    jQuery("#questionAddContentContainer").addClass("active");
	    }else{
	    	if( jQuery("#questionAddContentContainer").hasClass("active") ){
	    		jQuery("#questionAddContentContainer").toggle();
	    		jQuery("#questionAddContentContainer").removeClass("active")
	    	 }
	    }
    }
	
	function hideQuestion(event){
		//console.log('hideQuestion');
	    var dataValue=jQuery('#orgType').val();
	    
	    if(dataValue=="<%=IdpRegistrationPortletKeys.DIH%>"){
		    event.preventDefault();
		    jQuery("#questionAddContentContainer").slideToggle(200);
		    jQuery("#questionAddContentContainer").addClass("active");
	    }else{
	    	if( jQuery("#questionAddContentContainer").hasClass("active") ){
	    		jQuery("#questionAddContentContainer").toggle();
	    		jQuery("#questionAddContentContainer").removeClass("active")
	    	 }
	    }
    }
	
   function <portlet:namespace />validationFm(event){
    	//console.log('validationFm');
		jQuery('#errorMessage').html('');
		jQuery('#errorMessage').hide();
		let isValid = true;
		let msg = ' ';
		var lettersspaces = /^[a-zA-Z\s]+$/;
		var lettersNumbersSpaces = /^[a-zA-Z0-9._-\s]+$/;
		
		if (isOver30('name')){
			msg += ' <%=LanguageUtil.get(request, "name-has-more-than-x-characters")%><br/>';
			isValid = false;
		}
		if (isOver30('surname')){
			msg += ' <%=LanguageUtil.get(request, "surname-has-more-than-x-characters")%><br/>';
			isValid = false;
		}
		if (!matchRegex(jQuery('#name').val(),lettersspaces)){
			msg += ' <%=LanguageUtil.get(request, "the-name-must-contain")%><br/>';
			isValid = false;
		}
		if (!matchRegex(jQuery('#surname').val(),lettersspaces)){
			msg += ' <%=LanguageUtil.get(request, "the-surname-must-contain")%><br/>';
			isValid = false;
		}
		if (jQuery('#password1').val() != jQuery('#password2').val()) {
			msg += ' <%=LanguageUtil.get(request, "you-have-to-enter-the-same-password")%><br/>';
			isValid = false;
		}
		if (!matchRegex(jQuery('#organizationName').val(),lettersNumbersSpaces)){
			msg += ' <%=LanguageUtil.get(request, "the-organization-name-must-contain")%><br/>';
			isValid = false;
		}
		if (!isNull('website')){
			if(!isValidURL('website')){
				msg += ' <%=LanguageUtil.get(request, "please-enter-a-valid-website")%><br/>';
				isValid = false;
			}
		}
		if (!jQuery("#termsOfUseCheckbox").is(":checked")){
			msg += ' <%=LanguageUtil.get(request, "you-must-accept-terms-of-use")%><br/>';
			isValid = false;
		}
		//isValid = true;//test
		if (!isValid){
			event.preventDefault();
			jQuery('#errorMessage').html(msg);
			jQuery('#errorMessage').show();
			window.scrollTo({ top: 0, behavior: 'smooth' });
		}
		
		
		console.log('isValid ',isValid);
		return isValid;
    }
</script>



<portlet:actionURL name="addUser" var="addUserURL">
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
</portlet:actionURL>

<div id="idpFormRegistrationContainer">
	<aui:form action="<%= addUserURL.toString() %>" name="signUpFm" id="<portlet:namespace/>registration" method="post" enctype='multipart/form-data'  
				onSubmit='<%= "return " + renderResponse.getNamespace() + "validationFm(event);" %>'>
			
	        <aui:fieldset>
	        
	        <div id="errorMessage" class="alert alert-danger" style="display:none"></div>
			<c:if test="${error}">
				<div id="serverError" class="alert alert-danger"><liferay-ui:message key="${message}"/></div>
			</c:if>
	        
	        <div class="clearfix">
	        <!------------------------------------------------->
	        <div class="row">
			   <div class="col-6">
 				   <div class="form-group ">
 				      <label class="control-label" for="name"><liferay-ui:message key="name"/>*</label>
                         <div> <input type="text" class="form-control" id="name" maxlength="<%=String.valueOf(IdpRegistrationPortletKeys.MAX_LENGHT) %>" type="text" value="<%=HtmlUtil.escape(ri.getName()) %>" name="name" required></input> </div>
                   </div>
			   </div>
	           <div class="col-6">
 				    <div class="form-group ">
 				      <label class="control-label" for="username"><liferay-ui:message key="surname"/>*</label>
                         <div> <input type="text" class="form-control" id="surname" maxlength="<%=String.valueOf(IdpRegistrationPortletKeys.MAX_LENGHT) %>" type="text" value="<%=HtmlUtil.escape(ri.getSurname()) %>" name="surname" required></input> </div>
                   </div>
			   </div>
		   	</div>
		   	<div class="form-group ">
		   		<label class="control-label" for="email"><liferay-ui:message key="e-mail"/>*</label>
                <div><input class="form-control" id="email" type="email" value="<%=ri.getEmail() %>" name="email" required/></div>
            </div>
            <div class="form-group has-feedback">
            	<label class="control-label" for="password1"><liferay-ui:message key="password"/>*</label>
              	<div><input class="form-control" id="password1" type="password" name="password1" value="<%=ri.getPassword1() %>" required/></div>
            </div>
            <div class="form-group has-feedback">
            	<label class="control-label" for="password2"><liferay-ui:message key="password-again"/>*</label>
                <div><input class="form-control" id="password2" type="password" name="password2" value="<%=ri.getPassword2() %>" required/></div>
            </div>
            <div class="form-group">
                <span class="input-icon">
                <label class="control-label" for="orgType"><liferay-ui:message key="organization-type-list"/>*</label>
				<select name="orgType" class="form-control" id="orgType" required="true" onchange="hideQuestion(event)">
					<option value="<%=ri.getOrganizationType().equalsIgnoreCase(StringPool.BLANK)  ? StringPool.BLANK : ri.getOrganizationType()%>"  selected hidden >
						<% if (ri.getOrganizationType().equalsIgnoreCase(StringPool.BLANK)) { %>
								<liferay-ui:message key="select-org-type"/>
						<% } else { %>
								<%=ri.getOrganizationType()%>
						<% } %>
					</option>
					<%
					for (String o : organizationType_NAMES){
					%>
						<option label="<%= o %>" value="<%= HtmlUtil.escape(o) %>" />
					<%
					}
					%>
				</select>
				</span>
            </div>
            <div class="form-group <%= active %>" id="questionAddContentContainer">
				<div class="row userAddContent">
					<div class="col-4 userAddContentLabel">  
						<span>
							<label class="control-label" for="organization-role">
								<liferay-ui:message key="would-you-like-to-be-enabled-to-insert-content-into-the-portal"/>
							</label>
						</span> 
					</div>
					<div class="col-8">
						<label class="switch2">
							<input type="checkbox" 
								id="addContentCheckBox" 
								name="addContentCheckBox" />
								
						  <span class="slider2"></span>
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<span><label class="control-label" for="organization-name"><liferay-ui:message key="organization-name"/>*</label>
                <input class="form-control" id="organizationName" type="text" value="<%=HtmlUtil.escape(ri.getOrganizationName()) %>" name="organizationName" required /></span>
			</div>
			
			<div class="form-group">
				<span><label class="control-label" for="organization-web"><liferay-ui:message key="website"/></label>
                <input class="form-control" id="website" type="text" value="<%=HtmlUtil.escape(ri.getOrganizationWebSite()) %>" name="organizationWeb"/></span>
			</div>
			<div class="form-group" >
				<div class="row ">
					<div class="col-1">
						<label class="switch2">
							<input type="checkbox"
								id="termsOfUseCheckbox" 
								name="termsOfUseCheckbox" 
								/>
						  <span class="slider2"></span>
						</label>
					</div>
					<div class="col-11 termsOfUseContentLabel">  
						<span>
							<label class="control-label" >
								<a href="<%=termsOfUseUrl==StringPool.BLANK ? StringPool.POUND : termsOfUseUrl%>" id="terms-of-use" target="_blank">
									<liferay-ui:message key="accept-term-of-use-and-privacy-policy"/>
								</a>
							</label>
						</span> 
					</div>
				</div>
			</div>
	        <!------------------------------------------------->
	        </div>
	        
	        <div class="form-group legend">
	        	<label class="control-label" for="required-fields" >(*) <liferay-ui:message key="required-fields"/></label>
	        </div>
	        </aui:fieldset>
	        
			<liferay-captcha:captcha />
			
	        <aui:button-row>
	            <aui:button type="submit" value="Sign up" cssClass="btn-outline-info"  />
				<aui:button name="reset" type="reset" value="Reset" onClick='resetContainer();'/>
	        </aui:button-row>

	</aui:form>
</div>
 <!-- 070922 -->