<%@ include file="/init.jsp" %>

<%
String keywords = ParamUtil.getString(request, "keywords", null);
List<Cocreation> myCocreations = new ArrayList();
int cocreationsSize = 1;
if (isChallengeOwner){
	if (keywords != null && !keywords.equalsIgnoreCase("")){        
		myCocreations = CocreationLocalServiceUtil.getCocreationsBySearchGroupId(keywords, themeDisplay.getScopeGroupId(), false);   
	}else{
		myCocreations = CocreationLocalServiceUtil.getCocreationsByGroupId(themeDisplay.getScopeGroupId(), false);
		cocreationsSize = myCocreations.size();
	}
}else{
	if (keywords != null && !keywords.equalsIgnoreCase("")){        
		myCocreations = CocreationLocalServiceUtil.getCocreationsBySearchUserId(keywords, themeDisplay.getUser().getUserId(), themeDisplay.getScopeGroupId(), false);   
	}else{
		myCocreations = CocreationLocalServiceUtil.getCocreationsByCocreatorId(themeDisplay.getUser().getUserId(), themeDisplay.getScopeGroupId(), false);
		cocreationsSize = myCocreations.size();
	}
}
%>

<portlet:renderURL var="search">
    <portlet:param name="jspPage" value="/ongoing-cocreations.jsp" />
</portlet:renderURL>

<portlet:renderURL var="farmerProfile">
    <portlet:param name="jspPage" value="/farmerProfile.jsp" />
    <portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:renderURL>

<liferay-ui:success key="actionSuccess" message="Operation performed"/>
<liferay-ui:error key="actionError" message="Operation performed"/>
<div id="oingoingCocreations">
	<div class="container-fluid p-0 co-creation">
	   <div class="row mb-4 border-bottom">
			<div class="col col-lg-6 col-sm-6 col-6 col-md-12">
				<h3 class="co-title">Ongoing co-creations</a></h3>
			</div><!-- w-1/2  END-->
			<div class="col col-lg-6 col-sm-6 col-6 col-md-12  "> 
				  <aui:nav cssClass="nav-tabs nav-co-tabs"> 	
					<portlet:renderURL var="mycocreationsURL">
						<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
					</portlet:renderURL>
					<%if (isChallengeOwner){%>
						<aui:nav-item href="<%=mycocreationsURL%>" label="Co-Creations"/>
					<%}else{%>
						<aui:nav-item href="<%=mycocreationsURL%>" label="My Co-Creations"/>
					<%}%>
				</aui:nav>
				<aui:nav cssClass="nav-tabs nav-co-tabs-not-sel">
					<portlet:renderURL var="challengesURL">
						<portlet:param name="jspPage" value="/challenges.jsp"/>
					</portlet:renderURL>
					<aui:nav-item href="<%=challengesURL%>" label="Challenges"/>
				  </aui:nav>		
			</div><!-- w-1/2 END -->
		</div>
   </div>
   <div class="container-fluid p-0 co-creation">
	   <div class="row mb-4 border-bottom">
			<div class="col col-lg-4-2 col-sm-4 col-4 col-md-12  "> 
				  <aui:nav cssClass="nav-tabs nav-co-tabs-not-sel">
					<portlet:renderURL var="previousCocreationsURL">
						<portlet:param name="jspPage" value="/previous-cocreations.jsp"/>
					</portlet:renderURL>
					<aui:nav-item href="<%=previousCocreationsURL%>" label="Previous Co-Creations"/>
				</aui:nav>
				<aui:nav cssClass="nav-tabs nav-co-tabs">
					<portlet:renderURL var="ongoingCocreationsURL">
						<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
					</portlet:renderURL>
					<aui:nav-item href="<%=ongoingCocreationsURL%>" label="Ongoing Co-Creations"/>
				  </aui:nav>	
			</div><!-- w-1/2 END -->
		</div>
   </div>
   <div id="search" class="m-1 p-1">
		<aui:form name="searchForm" action="<%=search%>" method="post">
			<%if (isChallengeOwner){%>
    	 		<aui:input id="keywords" name="keywords" placeholder="Title, description, username" inlineLabel="left" label="" size="256" value=""/> 
    	 	<%}else{%>
    	 		<aui:input id="keywords" name="keywords" placeholder="Title, description" inlineLabel="left" label="" size="256" value=""/>
    	 	<%}%>
	    	<aui:button type="submit" value="search" cssClass="append-input-btn"/>
	    	<aui:button type="button" value="Clear" id="clearSearch" name="clearSearch" />
		</aui:form>
   </div>
   <!-- <div class="container-fluid p-0 co-creation">
	   <div id="cocreations" class="m-1 p-1"> 
			<div class="co-abstract row flex-lg-row flex-sm-row flex-row flex-md-row"> 
			   <div class="col col-lg-10 col-sm-10 col-10 col-md-12"> -->
				   		<aui:form action="" name="<portlet:namespace />fm">
					   		<div id="products" class="row view-group">
						   		<%
						   		if (cocreationsSize == 0){
						   		%>
						   			<h3 class="co-title">There are no ongoing co-creations</a></h3>
								<%
								}else{
							   		if (myCocreations.size() == 0){
							   		%>
							   			<h3 class="co-title">You have no ongoing co-creations</a></h3>
									<%
									}
								}
								for (Cocreation cocreation : myCocreations) {
									boolean isCocreator = false;
									%>
									<portlet:renderURL var="ongoingCocreationsURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
										<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
									</portlet:renderURL>
									<portlet:actionURL name="deleteCocreation" var="deleteCocreationURL">
										<portlet:param name="cocreationId" value="<%=String.valueOf(cocreation.getCocreationId())%>"/>
										<portlet:param name="redirectTo" value="<%=ongoingCocreationsURL %>"></portlet:param>
									</portlet:actionURL>
									<%String deleteConfirmation = "javascript:deleteConfirmation('"+deleteCocreationURL+"');";%>
									<portlet:renderURL var="viewCocreationDetails">
										<portlet:param name="mvcPath" value="/cocreationDetails.jsp" />
										<portlet:param name="cocreationId" value="<%=String.valueOf(cocreation.getCocreationId())%>" />
										<portlet:param name="challengeTitle" value="<%=ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getTitle()%>" />
										<portlet:param name="desiredOutcome" value="<%=ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getDesiredOutcome()%>" />
										<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
									</portlet:renderURL>
									<portlet:renderURL var="viewChallengeDetails">
										<portlet:param name="mvcPath" value="/challengeDetails.jsp" />
										<portlet:param name="challengeId" value="<%=String.valueOf(ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getChallengeId())%>" />
										<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
									</portlet:renderURL>
							        <div class="item col-xs-4 col-lg-4" d-pagegroup="1">
							            <div class="thumbnail card">
							                <div class="caption card-body">
											    <h3 style="margin-bottom: 2px;" class="co-title group font-weight-bold inner list-group-item-heading resource-title">
								                     <a href="<%=viewCocreationDetails%>"><%=cocreation.getTitle() != "" ?  cocreation.getTitle() : "To be developed"%></a>
								                </h3>
											    <div class="col-12 p0 mb-2">
											    	<p id="challenge" class="resource-title">
							                        	<b><label class="aui-field-label">Challenge</label></b> : <label class="aui-field-label"><a href="<%=viewChallengeDetails%>"><%=ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getTitle() %></a></label>
							                    	</p>
							                    	<p id="postedBy" class="card-text group inner list-group-item-text">
							                    		<b><label class="aui-field-label">Posted by</label></b> : <label class="aui-field-label"><a href="<%=UserLocalServiceUtil.getUserById(ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getUserId()).getDisplayURL(themeDisplay)%>"><%=ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getUserName() %></a></label>
							                    	</p>
							                    	<p id="cocreators" class="card-text group inner list-group-item-text">
							                    		<b><label class="aui-field-label">Co-creators</label></b> : 
							                    	</p>	
							                    	<%
													List<Cocreator> cocreators = CocreatorLocalServiceUtil.getCocreatorsByCocreationId(cocreation.getCocreationId());
													Iterator<Cocreator> cocreatorsIt = cocreators.iterator();
													while(cocreatorsIt.hasNext()){
														Cocreator cocreator = cocreatorsIt.next();
														User userDisplay = UserLocalServiceUtil.getUserById(cocreator.getUserId());
														if (user.getUserId() == cocreator.getUserId()){
															/*L'utente loggato � uno dei co-creatori*/
															isCocreator = true;
														}
														%>
										      			<label class="aui-field-label"><a href="<%=UserLocalServiceUtil.getUserById(cocreator.getUserId()).getDisplayURL(themeDisplay)%>"><%=cocreator.getUserName()%></a></label>
														<%		
													}	
												    %>
												    <p id="date" class="card-text group inner list-group-item-text">
												    	<b><label class="aui-field-label">Started on</label></b> : <label class="aui-field-label"><%=formatter.format(cocreation.getCreateDate())%></label>
							                    	</p>
							                    </div>
							                    <p id="desc-"<%=cocreation.getCocreationId()%> class="card-text group inner list-group-item-text resourse-card">
							                        <%=cocreation.getDescription()%></p>
							                    <hr>
							                    <div class="row">
							                        <div class="col-12">
							                            <a href="<%=viewCocreationDetails%>" class="btn btn-primary "><i class="fa fa-info-circle" aria-hidden="true"></i>Details</a>
									   		 			<%if (isCocreator){%>
									   		 				<aui:button name="deleteCocreation" type="button" value="Delete" onClick="<%=deleteConfirmation%>"/>
							                        	<%}%>
							                        </div>
							                    </div>
							                </div>
							            </div>
							        </div>					   
							   <%
							   }
							   %>
					   	</div>
				   </aui:form> 
			   <!-- </div>
	   		</div>
		</div>
	</div>	 -->
</div>

<script type="text/javascript">
	function deleteConfirmation(url) {
		msg = "Are you sure you want to proceed with the delete operation?";
		if(confirm(msg)) {
			window.location.href = url;
		}else{
			return false;
		}
	}
</script>

<aui:script use="liferay-portlet-url,aui-io,aui-io-plugin-deprecated,liferay-util-window,aui-base">
 	var getOngoingCocreations = Liferay.PortletURL.createRenderURL();
	getOngoingCocreations.setPortletId('it_eng_rd_collaborativecreation_portlet_CollaborativecreationPortlet');
	getOngoingCocreations.setParameter("mvcPath","/ongoing-cocreations.jsp");
			
 	AUI().ready('aui-base','node', 'event', function (A) {
      A.one("#<portlet:namespace/>clearSearch").on('click',function(event){
      		A.one('#<portlet:namespace />keywords').val("");	
      	    window.location.href=getOngoingCocreations;     
      });
 	});
</aui:script>
