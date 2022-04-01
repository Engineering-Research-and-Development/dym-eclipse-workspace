<%@ include file="/init.jsp" %>

<%
String keywords = ParamUtil.getString(request, "keywords", null);
List<Cocreation> myCocreations = new ArrayList();
if ((GroupLocalServiceUtil.getGroup(themeDisplay.getScopeGroupId()).getCreatorUserId() == themeDisplay.getUser().getUserId()) || isSiteOwner){
	if (keywords != null && !keywords.equalsIgnoreCase("")){        
		myCocreations = CocreationLocalServiceUtil.getCocreationsBySearchGroupId(keywords, themeDisplay.getScopeGroupId(), false);   
	}else{
		myCocreations = CocreationLocalServiceUtil.getCocreationsByGroupId(themeDisplay.getScopeGroupId(), false);
	}
}else{
	if (keywords != null && !keywords.equalsIgnoreCase("")){        
		myCocreations = CocreationLocalServiceUtil.getCocreationsBySearchUserId(keywords, themeDisplay.getUser().getUserId(), themeDisplay.getScopeGroupId(), false);   
	}else{
		myCocreations = CocreationLocalServiceUtil.getCocreationsByCocreatorId(themeDisplay.getUser().getUserId(), themeDisplay.getScopeGroupId(), false);
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
					<portlet:renderURL var="challengesURL">
						<portlet:param name="jspPage" value="/challenges.jsp"/>
					</portlet:renderURL>
					<aui:nav-item href="<%=challengesURL%>" label="Challenges"/>
				
					<portlet:renderURL var="mycocreationsURL">
						<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
					</portlet:renderURL>
					<aui:nav-item href="<%=mycocreationsURL%>" label="Co-Creations"/>
				</aui:nav>	
			</div><!-- w-1/2 END -->
		</div>
   </div>
   <div class="container-fluid p-0 co-creation">
	   <div class="row mb-4 border-bottom">
			<div class="col col-lg-4-2 col-sm-4 col-4 col-md-12  "> 
				  <aui:nav cssClass="nav-tabs nav-co-tabs">
					<portlet:renderURL var="ongoingCocreationsURL">
						<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
					</portlet:renderURL>
					<aui:nav-item href="<%=ongoingCocreationsURL%>" label="Ongoing Co-Creations"/>
				
					<portlet:renderURL var="previousCocreationsURL">
						<portlet:param name="jspPage" value="/previous-cocreations.jsp"/>
					</portlet:renderURL>
					<aui:nav-item href="<%=previousCocreationsURL%>" label="Previous Co-Creations"/>
				</aui:nav>	
			</div><!-- w-1/2 END -->
		</div>
   </div>
   <div id="search" class="m-1 p-1">
		<aui:form name="searchForm" action="<%=search%>" method="post">
			<%if ((GroupLocalServiceUtil.getGroup(themeDisplay.getScopeGroupId()).getCreatorUserId() == themeDisplay.getUser().getUserId()) || isSiteOwner){%>
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
						   		if (myCocreations.size() == 0){
						   		%>
						   			<h3 class="co-title">There are no co-creations</a></h3>
								<%
								}
								for (Cocreation cocreation : myCocreations) {
								%>
									<portlet:actionURL name="deleteCocreation" var="deleteCocreationURL">
										<portlet:param name="cocreationId" value="<%=String.valueOf(cocreation.getCocreationId())%>"/>
										<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
									</portlet:actionURL>
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
							                    <h3 class="co-title"><%=cocreation.getTitle() != "" ?  cocreation.getTitle() : "To be developed"%></h3>
											    <div class="col-12 p0 mb-2">
											    	<div id="challenge" class="challengesLeft">
							                        	<span><b><label class="aui-field-label">Challenge</label></b></span> : <span><label class="aui-field-label"><a href="<%=viewChallengeDetails%>"><%=ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getTitle() %></a></label></span>
							                    	</div>
							                    	<div id="postedBy" class="challengesLeft">
							                    		<span><b><label class="aui-field-label">Posted by</label></b></span> : <span><label class="aui-field-label"><a href="<%=UserLocalServiceUtil.getUserById(ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getUserId()).getDisplayURL(themeDisplay)%>"><%=ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getUserName() %></a></label></span>
							                    	</div>
							                    	<div id="cocreators" class="challengesLeft">
							                    		<span><b><label class="aui-field-label">Co-creators</label></b></span> : <span>
							                    	</div>	
							                    	<%
													List<Cocreator> cocreators = CocreatorLocalServiceUtil.getCocreatorsByCocreationId(cocreation.getCocreationId());
													Iterator<Cocreator> cocreatorsIt = cocreators.iterator();
													while(cocreatorsIt.hasNext()){
														Cocreator cocreator = cocreatorsIt.next();
														%>
										      			<span><label class="aui-field-label"><a href="<%=UserLocalServiceUtil.getUserById(cocreator.getUserId()).getDisplayURL(themeDisplay)%>"><%=cocreator.getUserName()%></a></label></span>
														<%		
													}	
												    %>
												    <div id="date" class="challengesLeft">
												    	<span><b><label class="aui-field-label">Started on</label></b></span> : <span><label class="aui-field-label"><%=formatter.format(cocreation.getCreateDate())%></label></span>
							                    	</div>
							                    </div>
							                    <p id="desc-"<%=cocreation.getCocreationId()%> class="card-text group inner list-group-item-text resourse-card">
							                        <%=cocreation.getDescription()%></p>
							                    <hr>
							                    <div class="row">
							                        <div class="col-12">
							                            <a href="<%=viewCocreationDetails%>" class="btn btn-primary "><i class="fa fa-info-circle" aria-hidden="true"></i>Details</a>
									   		 			<aui:button name="deleteCocreation" type="button" value="Delete"  onClick="<%=\"window.location.href='\"+deleteCocreationURL.toString() +\"'\"%>"/>
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
