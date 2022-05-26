<%@page import="javax.portlet.PortletConfig"%>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaException" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="java.util.Set" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script type="text/javascript">
    function <portlet:namespace />validateFm(event){
    	
		jQuery('#errorMessage').html('');
		jQuery('#errorMessage').hide();
		let isValid = true;
		let msg = '';
		
		if (matchRegex(jQuery('#username').val(),'[^A-Za-z0-9,._-]')){
			msg += ' <%=LanguageUtil.get(request, "the-username-must-contain")%><br/>';
			isValid = false;
		}
			
		if (!jQuery('#termsOfUseCheckbox').is(":checked")){
			msg += ' <%=LanguageUtil.get(request, "you-must-accept-terms-of-use")%><br/>';
			isValid = false;
		} 
		
		if (jQuery('#password1').val() != jQuery('#password2').val()) {
			msg += ' <%=LanguageUtil.get(request, "you-have-to-enter-the-same-password")%><br/>';
			isValid = false;
		} 

		if (!isValid){
			event.preventDefault();
			jQuery('#errorMessage').html(msg);
			jQuery('#errorMessage').show();
		}
// 		isValid=false;
// 		console.log('isValid');
		return isValid;	
    }
    
    function matchRegex(val, pattern) {
		var pattern = new RegExp(pattern);
		if (val.match(pattern)) {
			return true;
		}
		return false;
	}
    
    function isNull(val){
    	if(!$.trim(this.val).length) {
    		return false;
    	}
    	return true;
    }
</script>

<portlet:actionURL name="addUser" var="addUserURL"></portlet:actionURL>
<div id="idpFormRegistrationContainer">
<aui:form action="<%= addUserURL.toString() %>" name="signUpFm" id="<portlet:namespace/>registration" method="post" enctype='multipart/form-data' onSubmit='<%= "return " + renderResponse.getNamespace() + "validateFm(event);" %>'>
		

        <aui:fieldset>
        
		        <div id="errorMessage" class="alert alert-danger" style="display:none"></div>
				
				<c:if test="${error}">
					<div class="alert alert-danger"><liferay-ui:message key="${message}"/></div>
				</c:if>
		
 				<div class="clearfix">
 				
                    <div class="form-group "><label class="control-label" for="username" ><liferay-ui:message key="username"/>*</label>
                        <div><input class="form-control" id="username" maxlength="30" type="text" value="" name="username" required />
                        <span><label class="control-label"><liferay-ui:message key="you-can-use-letteres-numbers"/></label></span>
                        </div>
                    </div>
                    <div class="form-group "><label class="control-label" for="email"><liferay-ui:message key="e-mail"/>*</label>
                        <div><input class="form-control" id="email" type="email" value="" name="email"  required /></div>
                    </div>
                    <div class="form-group has-feedback"><label class="control-label" for="password1"><liferay-ui:message key="password"/>*</label>
                        <div>
						<input class="form-control" id="password1" type="password" name="password1" required /></div>
                    </div>
                    <div class="form-group has-feedback"><label class="control-label" for="password2"><liferay-ui:message key="password-again"/>*</label>
                        <div><input class="form-control" id="password2" type="password" name="password2"  required /></div>
                    </div>
                    <div class="form-group">
                    	<span class="input-icon">
                    		<label class="control-label" for="orgType"><liferay-ui:message key="organization-type-list"/>*</label>
							<select name="orgType" class="form-control" required="true" >
								<option value="" disabled selected hidden><liferay-ui:message key="select-org-type"/></option>
								<%
								for (String o : organizationType_NAMES){
 								%>
									<option label="<%= o %>" 				
										 value="<%= o %>" />
								<%
								}
								%>
							</select>
						</span>
                    </div>
					<div class="form-group">
						<span><label class="control-label" for="organization-name"><liferay-ui:message key="organization-name"/>*</label>
                        <input class="form-control" id="organizationName" type="text" value="" name="organizationName" required/></span>
					</div>
					
					<div class="form-group ">
						<input class="field" id="termsOfUseCheckbox" 
					 		name="termsOfUseCheckbox" 
					 		type="checkbox" required >
						<a class="btn btn-outline-primary btn-terms-of-use " href="<%=termsOfUseUrl==StringPool.BLANK ? StringPool.POUND : termsOfUseUrl%>" id="terms-of-use" target="_blank">
							<liferay-ui:message key="accept-term-of-use-and-privacy-policy"/>
						</a>
					</div>
                </div> 
                
                <div class="form-group legend">
		        	<label class="control-label" for="required-fields" >(*) <liferay-ui:message key="required-fields"/></label>
		        </div>
        </aui:fieldset>
        
		<liferay-captcha:captcha />
		
        <aui:button-row>
            <aui:button type="submit" value="Sign up" cssClass="btn-outline-info"></aui:button>
        </aui:button-row>
</aui:form>
</div>

