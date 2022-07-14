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

	jQuery(document).ready(function(){
		jQuery("#questionAddContentContainer").toggle();
	});
	
	jQuery(document).on('change','#orgType',function(event){
	    var dataValue=$(this).val();
	    
	    if(dataValue=="DIH"){
		    event.preventDefault();
		    jQuery("#questionAddContentContainer").slideToggle(200);
		    jQuery("#questionAddContentContainer").addClass("active");
	    }else{
	    	
	    	if( jQuery("#questionAddContentContainer").hasClass("active") ){
	    		jQuery("#questionAddContentContainer").toggle();
	    		jQuery("#questionAddContentContainer").removeClass("active")
	    	 }
	    }
	});

   function <portlet:namespace />validateFm(event){
    	
		jQuery('#errorMessage').html('');
		jQuery('#errorMessage').hide();
		let isValid = true;
		let msg = '';
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
		if (!matchRegex(jQuery('#organizationName').val(),lettersNumbersSpaces)){
			msg += ' <%=LanguageUtil.get(request, "the-organization-name-must-contain")%><br/>';
			isValid = false;
		}
		if (!isNull('organization-role')){
			if (!matchRegex(jQuery('#organization-role').val(),lettersNumbersSpaces)){
				msg += ' <%=LanguageUtil.get(request, "the-organization-role-must-contain")%><br/>';
				isValid = false;
			}
		}
// 		if (matchRegex(jQuery('#username').val(),'[^A-Za-z0-9,._-]')){
<%-- 			msg += ' <%=LanguageUtil.get(request, "the-username-must-contain")%><br/>'; --%>
// 			isValid = false;
// 		}
		if (!jQuery('#termsOfUseCheckbox').is(":checked")){
			msg += ' <%=LanguageUtil.get(request, "you-must-accept-terms-of-use")%><br/>';
			isValid = false;
		} 
		if (jQuery('#password1').val() != jQuery('#password2').val()) {
			msg += ' <%=LanguageUtil.get(request, "you-have-to-enter-the-same-password")%><br/>';
			isValid = false;
		}
		
		if (!isNull('website')){
			if(!isValidURL('website')){
				msg += ' <%=LanguageUtil.get(request, "please-enter-a-valid-url")%><br/>';
				isValid = false;
			}
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
   
   function isValidURL(id) {
		  var value = jQuery('#'+id).val();
		  var result = value.match(/(http(s)?:\/\/.)?(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)/g);
		  console.log('isValidURL ',result);
		  if(result == null)
		        return false;
		    else
		        return true;
   };
   
    function matchRegex(val, pattern) {
		if (pattern.test(val)) {
			return true;
		}
		return false;
	}
    
    function isNull(id){
    	if (jQuery('#'+id).val().length === 0) {
    		return true
    	}
    	return false
    }
    
    function isOver30(id){
    	if (jQuery('#'+id).val().length > 30) {
    		return true
    	}
    	return false
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
 				
 				    <div class="row">
		 				   <div class="col-6">
				 				   <div class="form-group ">
				 				      <label class="control-label" for="name"><liferay-ui:message key="name"/>*</label>
                                        <div> <input type="text" class="form-control" placeholder id="name" maxlength="30" type="text" value="" name="name" required></input> </div>
				                   </div>
		 				   </div>
 				           <div class="col-6">
				 				    <div class="form-group ">
				 				      <label class="control-label" for="username"><liferay-ui:message key="surname"/>*</label>
                                        <div> <input type="text" class="form-control" placeholder id="surname" maxlength="30" type="text" value="" name="surname" required></input> </div>
				                   </div>
		 				   </div>
 				   
 				   </div>
 				
 				
 				
<!--                     <div class="form-group "><label class="control-label" for="username" ><liferay-ui:message key="username"/>*</label> -->
<!--                         <div><input class="form-control" id="username" maxlength="30" type="text" value="" name="username" required /> -->
<!--                         <span><label class="control-label"><liferay-ui:message key="you-can-use-letteres-numbers"/></label></span> -->
<!--                         </div> -->
<!--                     </div> -->
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
							<select name="orgType" class="form-control" required="true" id="orgType">
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
                    
                    <div class="form-group" id="questionAddContentContainer">
<!-- 					<span><label class="control-label" for="organization-role"><liferay-ui:message key="organization-role"/>*</label> -->
<!--                    <input class="form-control" id="organization-role" type="text" value="" name="organization-role"  /></span> -->
						    
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
										d="<portlet:namespace />addContent" 
										name="<portlet:namespace />addContent" >
								  <span class="slider2"></span>
								</label>
							</div>
							
						</div>
					</div>                   
                    
					<div class="form-group">
						<span><label class="control-label" for="organization-name"><liferay-ui:message key="organization-name"/>*</label>
                        <input class="form-control" id="organizationName" type="text" value="" name="organizationName" required/></span>
					</div>
					
					<div class="form-group">
						<span><label class="control-label" for="organization-web"><liferay-ui:message key="website"/></label>
                        <input class="form-control" id="website" type="text" value="" name="organizationWeb"  /></span>
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

