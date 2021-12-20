<%@ include file="/init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaException" %>



<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL name="addUser" var="addUserURL"></portlet:actionURL>
<div id="idpFormRegistrationContainer">
<aui:form action="<%= addUserURL.toString() %>" name="fmscreen" method="post" id="<portlet:namespace/>registration">

		<c:if test="${error}">
			<div class="alert alert-danger">${message}</div>
		</c:if>

        <aui:fieldset>
 				<div class="clearfix">
                    <div class="form-group "><label class="control-label" for="username">Username</label>
                        <div><input class="form-control" id="username" maxlength="30" type="text" value="" name="username" /></div>
                    </div>
                    <div class="form-group "><label class="control-label" for="email">E-mail</label>
                        <div><input class="form-control" id="email" type="email" value="" name="email" /></div>
                    </div>
                    <div class="form-group has-feedback"><label class="control-label" for="password1">Password</label>
                        <div>
						<input class="form-control" id="password1" type="password" name="password1" /> </div>
                    </div>
                    <div class="form-group has-feedback"><label class="control-label" for="password2">Password (again)</label>
                        <div><input class="form-control" id="password2" type="password" name="password2" /></div>
                    </div>
                </div> 
        </aui:fieldset>
		
		<liferay-captcha:captcha />
		 
        <aui:button-row>
            <aui:button type="submit" value="Sign up" cssClass="btn-outline-info"></aui:button>
        </aui:button-row>
</aui:form>
</div>