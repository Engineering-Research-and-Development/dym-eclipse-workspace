<%@ include file="/init.jsp" %>

<%
String keywords = ParamUtil.getString(request, "keywords", null);
String challengeFilter = ParamUtil.getString(request, "challengeFilter", null);
List<Cocreation> myCocreations = new ArrayList();
List<Cocreation> allMyCocreations = new ArrayList();
List<Cocreation> allCocreations = new ArrayList();
List<Challenge> myChallengeOwnerChallenges = new ArrayList();
List<Challenge> filterChallenges = new ArrayList();
List<Cocreation> filteredCocreations = new ArrayList();
int cocreationsSize = 1;
/*Se sono Challenge Owner acquisisco tutte le co-creazioni delle mie gare*/
if (isChallengeOwner){
	myChallengeOwnerChallenges = ChallengeLocalServiceUtil.getChallengesByUserId(themeDisplay.getUserId(), themeDisplay.getScopeGroupId());
	if (keywords != null && !keywords.equalsIgnoreCase("")){        
		allCocreations = CocreationLocalServiceUtil.getCocreationsBySearchGroupId(keywords, themeDisplay.getScopeGroupId(), true);   
	}else{
		allCocreations = CocreationLocalServiceUtil.getCocreationsByGroupId(themeDisplay.getScopeGroupId(), true);
	}
	for (int i=0; i < allCocreations.size(); i++){
		for (int l=0; l < myChallengeOwnerChallenges.size(); l++){
			if (allCocreations.get(i).getChallengeId() == myChallengeOwnerChallenges.get(l).getChallengeId()){
				allMyCocreations.add(allCocreations.get(i));
				if (i > 0){
					if (allCocreations.get(i).getChallengeId() != allCocreations.get(i-1).getChallengeId()){
						filterChallenges.add(ChallengeLocalServiceUtil.getChallenge(allCocreations.get(i).getChallengeId()));
					}
				}else{
					filterChallenges.add(ChallengeLocalServiceUtil.getChallenge(allCocreations.get(i).getChallengeId()));
				}
			}
		}
	}
}
/*Acquisisco tutte le co-creazioni di cui sono co-creatore e, se sono Challenge Owner, verifico in quali, fra le co-cocreazioni delle mie gare, sono co-creatore*/
if (keywords != null && !keywords.equalsIgnoreCase("")){        
	myCocreations = CocreationLocalServiceUtil.getCocreationsBySearchUserId(keywords, themeDisplay.getUser().getUserId(), themeDisplay.getScopeGroupId(), true);   
}else{
	myCocreations = CocreationLocalServiceUtil.getCocreationsByCocreatorId(themeDisplay.getUser().getUserId(), themeDisplay.getScopeGroupId(), true);
}
for (int i=0; i < myCocreations.size(); i++){
	boolean found = false;
	for (int l=0; l < allMyCocreations.size(); l++){
		if (myCocreations.get(i).getChallengeId() == allMyCocreations.get(l).getChallengeId()){
			found = true;
		}
	}
	if (!found){
		allMyCocreations.add(myCocreations.get(i));
		filterChallenges.add(ChallengeLocalServiceUtil.getChallenge(myCocreations.get(i).getChallengeId()));
	}
}
/*Gestione filtro gara*/
if (challengeFilter == null){
	challengeFilter = "";
}
for (Cocreation cocreation : allMyCocreations) {
	 if (!challengeFilter.equalsIgnoreCase("")){
		 if (ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getChallengeId() == Long.parseLong(challengeFilter)){
		   	filteredCocreations.add(cocreation);
		 }	 
	 }else{
		 filteredCocreations.add(cocreation);
	 }
}

cocreationsSize = filteredCocreations.size();
%>

<portlet:renderURL var="search">
    <portlet:param name="jspPage" value="/previous-cocreations.jsp" />
</portlet:renderURL>

<portlet:renderURL var="farmerProfile">
    <portlet:param name="jspPage" value="/farmerProfile.jsp" />
    <portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:renderURL>

<liferay-ui:success key="actionSuccess" message="Operation performed"/>
<liferay-ui:error key="actionError" message="Operation performed"/>
<div id="previousCocreations">
	<div class="container-fluid p-0 co-creation">
	   <div class="row mb-4 border-bottom">
			<div class="col col-lg-6 col-sm-6 col-6 col-md-12">
				<h3 class="co-title"><liferay-ui:message key="previousCocreations"/></a></h3>
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
				  <aui:nav cssClass="nav-tabs nav-co-tabs">
					<portlet:renderURL var="previousCocreationsURL">
						<portlet:param name="jspPage" value="/previous-cocreations.jsp"/>
					</portlet:renderURL>
					<aui:nav-item href="<%=previousCocreationsURL%>" label="previousCocreations"/>
				</aui:nav>	
				<aui:nav cssClass="nav-tabs nav-co-tabs-not-sel">
					<portlet:renderURL var="ongoingCocreationsURL">
						<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
					</portlet:renderURL>
					<aui:nav-item href="<%=ongoingCocreationsURL%>" label="ongoingCocreations"/>
				  </aui:nav>
			</div><!-- w-1/2 END -->
		</div>
		<div class="container">
			<!-- Stack the columns on mobile by making one full-width and the other half-width -->
		  	<div class="row">
		     	<!-- Colonna ricerca -->
		    	<div class="col-12 col-md-3">
		        	<div class="col col-lg-12 col-sm-12 col-12  col-md-12"> 
				    	<div class="co-box mt-2 mb-4 card-1">
							<label class="aui-field-label co-title">Challenge</label> 
				     		<aui:select label="" id="challengeFilter" name="challengeFilter" showEmptyOption="false">
								<aui:option selected="<%=true%>" value=""><liferay-ui:message key="select"/></aui:option>
								<%
								for (Challenge challenge : filterChallenges) {
								%>
									<aui:option selected="<%=false%>" value="<%=challenge.getChallengeId()%>"><%=challenge.getTitle()%></aui:option>	
								<% 
								}
								%>
						   </aui:select>
						   <div>
								<aui:button id="filter" name="filter" type="submit" value="filter" cssClass="btn-outline-info"></aui:button>
								<aui:button id="clearFilter" name="clearFilter" type="button" value="clear"/>
						  </div>	
				       </div>
			       </div>	
				   <%-- <div class="col col-lg-12 col-sm-12 col-12  col-md-12"> 
					  <div class="co-box mt-2 mb-4 card-1">
					  		<label class="aui-field-label co-title">Co-creation</label> 
						    <aui:form name="searchForm" action="<%=search%>" method="post">
								<%if (isChallengeOwner){%>
					    	 		<aui:input id="keywords" name="keywords" placeholder="titleDescriptionUsername" inlineLabel="left" label="" size="256" value=""/> 
					    	 	<%}else{%>
					    	 		<aui:input id="keywords" name="keywords" placeholder="titleDescription" inlineLabel="left" label="" size="256" value=""/>
					    	 	<%}%>
						    	<aui:button type="submit" value="search" cssClass="append-input-btn"/>
						    	<aui:button type="button" value="clear" id="clearSearch" name="clearSearch" />
							</aui:form>
					 </div>
				 </div> --%>
		      </div>
		      <div class="col col-lg-9 col-sm-9 col-9 col-md-12"> 
				  	<div class="m-1 p-1"">
				  		<label class="aui-field-label co-title">Co-creation</label> 
					    <aui:form name="searchForm" action="<%=search%>" method="post">
							<%if (isChallengeOwner){%>
				    	 		<aui:input id="keywords" name="keywords" placeholder="titleDescriptionUsername" inlineLabel="left" label="" size="256" value=""/> 
				    	 	<%}else{%>
				    	 		<aui:input id="keywords" name="keywords" placeholder="titleDescription" inlineLabel="left" label="" size="256" value=""/>
				    	 	<%}%>
					    	<aui:button type="submit" value="search" cssClass="append-input-btn"/>
					    	<aui:button type="button" value="clear" id="clearSearch" name="clearSearch" />
						</aui:form>
				 	</div> 
		      		<aui:form action="" name="<portlet:namespace />fm">
					   	<div id="products" class="row">
					   		<ul class="cards">
						   		<%
						   		if (cocreationsSize == 0){
						   		%>
						   			<h3 class="co-title"><liferay-ui:message key="thereAreNoPreviousCocreations"/></a></h3>
								<%
						   		}else{
							   		if (filteredCocreations.size() == 0){
							   		%>
							   			<h3 class="co-title"><liferay-ui:message key="youHaveNoPreviousCocreations"/></a></h3>
									<%
									}
						   		}
								for (Cocreation cocreation : filteredCocreations){
									boolean isCocreator = false;
									%>
									<portlet:renderURL var="previousCocreationsURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
										<portlet:param name="jspPage" value="/previous-cocreations.jsp"/>
									</portlet:renderURL>
									<portlet:actionURL name="deleteCocreation" var="deleteCocreationURL">
										<portlet:param name="cocreationId" value="<%=String.valueOf(cocreation.getCocreationId())%>"/>
										<portlet:param name="redirectTo" value="<%=previousCocreationsURL %>"></portlet:param>
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
									<li class="user-card-item" d-pagegroup="1">
							        	<div class="user-card">
								      		<div class="user-card-pb card__image--fence"><a href="<%=UserLocalServiceUtil.getUserById(ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getUserId()).getDisplayURL(themeDisplay)%>"><img class="userProfilePicture" src="https://eu.ui-avatars.com/api/?name=<%=ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getUserName() %>&amp;background=222e5a&amp;color=fff"></a></div>	 	 
								      		<div class="user-card-img"></div>
								      		<div class="user-card-cont">
								        		<div class="user-card-title"> 
									        		<label class="aui-field-label">
									        			<i class="fa fa-edit" aria-hidden="true"></i><a href="<%=viewCocreationDetails%>"><%=cocreation.getTitle() != "" ?  cocreation.getTitle() : "To be developed"%></a>     
									         		</label>
								          		</div>
								        		<p class="user-id" style="font-size: 1rem;"><a href="<%=viewChallengeDetails%>"><%=ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getTitle() %></a>  </p>
								        		<b><i class="fa fa-calendar" aria-hidden="true"></i> <label class="aui-field-label">Challenge</label></b>
								        		<div id="postedBy" class="challengesLeft">
													<span><b><label class="aui-field-label"><!-- <i class="fa fa-calendar-check-o" aria-hidden="true"></i> --> <liferay-ui:message key="postedBy"/></label></b></span> : <span><label class="aui-field-label"><a href="<%=UserLocalServiceUtil.getUserById(ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getUserId()).getDisplayURL(themeDisplay)%>"><%=ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getUserName() %></a></label></span>
									       		</div>
								        		<div id="startDate" class="challengesLeft">
													<span><b><label class="aui-field-label"><!-- <i class="fa fa-calendar-check-o" aria-hidden="true"></i> --> <liferay-ui:message key="start"/></label></b></span> : <span><%=formatter.format(ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getStartDate()) %></span>
									       		</div>
									       		<div id="endDate" class="challengesLeft">
													<span><b><label class="aui-field-label"><!-- <i class="fa fa-calendar-times-o" aria-hidden="true"></i> --> <liferay-ui:message key="end"/></label></b></span> : <span><%=formatter.format(ChallengeLocalServiceUtil.getChallengeByCocreationId(cocreation.getCocreationId(), themeDisplay.getScopeGroupId()).getEndDate()) %></span>
									       		</div>
											    <div id="cocreators" class="challengesLeft">
							                    		<b><i class="fa fa-user" aria-hidden="true"></i> <label class="aui-field-label">Co-creators</label></b>: 
								                    	<%
														List<Cocreator> cocreators = CocreatorLocalServiceUtil.getCocreatorsByCocreationId(cocreation.getCocreationId());
														Iterator<Cocreator> cocreatorsIt = cocreators.iterator();
														while(cocreatorsIt.hasNext()){
															Cocreator cocreator = cocreatorsIt.next();
															User userDisplay = UserLocalServiceUtil.getUserById(cocreator.getUserId());
															if (user.getUserId() == cocreator.getUserId()){
																/*L'utente loggato è uno dei co-creatori*/
																isCocreator = true;
															}
															%>
											      			<label class="aui-field-label"><a href="<%=UserLocalServiceUtil.getUserById(cocreator.getUserId()).getDisplayURL(themeDisplay)%>"><%=cocreator.getUserName()%></a></label>
															<%
											      			if (cocreatorsIt.hasNext()){
											      			%>
											      				<span><label class="aui-field-label">,</label></span>
															<%
											      			}		
														}	
													    %>
									    	    </div>
											    <div id="cocreationDate" class="card-text group inner list-group-item-text challengesLeft">
											    	    <b><i class="fa fa-calendar" aria-hidden="true"></i> <label class="aui-field-label">Co-creation</label></b></br>
											    	 	<b><label class="aui-field-label"><liferay-ui:message key="createdOn"/></label></b> : <%=formatter.format(cocreation.getCreateDate())%></br>
											    	 	<b><label class="aui-field-label"><liferay-ui:message key="completedOn"/></label></b> : <%=formatter.format(cocreation.getCompletionDate())%></br>
						                    	</div>
						                    	<%-- <div id="desc-"<%=cocreation.getCocreationId()%> class="card-text group inner list-group-item-text">
						                            <span><b><i class="fa fa-align-justify" aria-hidden="true"></i> <label class="aui-field-label"><liferay-ui:message key="description"/></label></b></span> : <span><%=cocreation.getDescription()%></span>
						                        </div>   --%>	 
									  		</div>
								         	<div class="btn-row">
								           		<%-- <button onClick="<%=viewCocreationDetails%>" class="blue"><i class="fa fa-info-circle" aria-hidden="true"></i> <liferay-ui:message key="details"/></button> --%>   
								           		<a href="<%=viewCocreationDetails%>" class="btn btn-primary"><i class="fa fa-info-circle" aria-hidden="true"></i><liferay-ui:message key="details"/></a>
								           		<%if (isCocreator){%>			 
									   				<button id="deleteCocreation" name="deleteCocreation" class="red" onClick="<%=deleteConfirmation%>"> <i class="fas fa-trash-alt edit-btn red"></i> Delete</button>
							                   	<%}%>
								         	</div>
								    	</div>   
							  		</li>	
							   <%
							   }
							   %>
							</ul>
					   	</div>
				   </aui:form>
	   			</div>
	    	</div>	 
   		</div><!-- w-1/4  END-->
	</div>		   
</div>
		     
<script type="text/javascript">
	function deleteConfirmation(url) {
		msg = "<%=deleteOperationConfirmation%>";
		if(confirm(msg)) {
			window.location.href = url;
		}else{
			return false;
		}
	}
</script>

<aui:script use="liferay-portlet-url,aui-io,aui-io-plugin-deprecated,liferay-util-window,aui-base">
 	var getPreviousCocreations = Liferay.PortletURL.createRenderURL();
	getPreviousCocreations.setPortletId('it_eng_rd_collaborativecreation_portlet_CollaborativecreationPortlet');
	getPreviousCocreations.setParameter("mvcPath","/previous-cocreations.jsp");
			
 	AUI().ready('aui-base','node', 'event', function (A) {
 	  A.one("#<portlet:namespace/>filter").on('click',function(event){
      	    getPreviousCocreations.setParameter("challengeFilter", A.one('#<portlet:namespace />challengeFilter').val());	
            window.location.href=getPreviousCocreations; 
      });
 	  A.one("#<portlet:namespace/>clearFilter").on('click',function(event){
      		A.one('#<portlet:namespace />challengeFilter').val("");	
      	    window.location.href=getPreviousCocreations;     
      });
      A.one("#<portlet:namespace/>clearSearch").on('click',function(event){
      		A.one('#<portlet:namespace />keywords').val("");	
      	    window.location.href=getPreviousCocreations;     
      });
 	});
</aui:script>
		     