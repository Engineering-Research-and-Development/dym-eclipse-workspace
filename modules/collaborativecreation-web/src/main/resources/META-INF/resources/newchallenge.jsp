<%@ include file="/init.jsp" %>

<style>
	.aui .navbar .navbar-inner {
    	min-height: 67px;
	}
</style>

<aui:nav cssClass="nav-tabs">
	<portlet:renderURL var="cocreationsURL">
		<portlet:param name="jspPage" value="/view.jsp"/>
	</portlet:renderURL>
	<aui:nav-item href="<%=cocreationsURL%>" label="Welcome !"/>
</aui:nav>

<aui:nav cssClass="nav-tabs">
	<portlet:renderURL var="challengesURL">
		<portlet:param name="jspPage" value="/challenges.jsp"/>
	</portlet:renderURL>
	<aui:nav-item href="<%=challengesURL%>" label="Challenges"/>

	<portlet:renderURL var="mycocreationsURL">
		<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
	</portlet:renderURL>
	<aui:nav-item href="<%=mycocreationsURL%>" label="My Co-Creations"/>
</aui:nav>	

<portlet:actionURL name="addChallenge" var="addChallengeURL">
	<portlet:param name="active" value="true"/>
</portlet:actionURL>

<div id="challengeFormContainer">
	<aui:form id="formChallenge" name="fm" method="post" action="<%= addChallengeURL.toString() %>">
        <aui:fieldset>
 				<div class="clearfix">
                    <div class="form-group">
                        <aui:input label="Title" name="title" id="title" type="text" />
                    </div>
                    <div class="form-group">
                        <aui:input label="Description" name="description" id="description" type="textarea" />
                    </div>
                    <div class="form-group">
                        <aui:input label="Start Date" name="startDate" id="startDate" type="date" />
                    </div>
                    <div class="form-group">
                        <aui:input label="End Date" name="endDate" id="endDate" type="date" />
                    </div>
                </div> 
        </aui:fieldset>
		 
        <aui:button-row>
        	<aui:button type="submit" value="Post" cssClass="btn-outline-info"></aui:button>
        </aui:button-row>   
	</aui:form>      
</div>

