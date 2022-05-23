<%@page import="com.liferay.ratings.kernel.model.RatingsStats"%>
<%@page import="com.liferay.ratings.kernel.service.RatingsStatsLocalServiceUtil"%>
<%@page import="com.liferay.ratings.kernel.service.RatingsStatsLocalService"%>
<%@page import="com.liferay.ratings.kernel.service.RatingsEntryLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<%
String keywords = ParamUtil.getString(request, "keywords", null);
String active = ParamUtil.getString(request, "active", null);
String inactive = ParamUtil.getString(request, "inactive", null);
String location = ParamUtil.getString(request, "location", null);
String category = ParamUtil.getString(request, "category", null);
/* String hot = ParamUtil.getString(request, "hot", null); */
String topVoted = ParamUtil.getString(request, "topVoted", null);
Map<Long, Double> scoreMap = new HashMap<Long, Double>();
List<Entry<Long, Double>> scoreMapAsList = new ArrayList<Map.Entry<Long, Double>>();

if (location == null){
	location = "";
}
if (category == null){
	category = "";
}
List<Challenge> challenges = new ArrayList();
List<Challenge> filteredChallenges = new ArrayList();

if ((active == null || active.equalsIgnoreCase("false")) && (inactive == null || inactive.equalsIgnoreCase("false")) ||
	 active.equalsIgnoreCase("true") && inactive.equalsIgnoreCase("true")){
	challenges = ChallengeLocalServiceUtil.getChallengesByGroupId(themeDisplay.getScopeGroupId());
}else{
	if ((inactive == null || inactive.equalsIgnoreCase("false")) && active.equalsIgnoreCase("true")){
		challenges = ChallengeLocalServiceUtil.getChallengesByActive(themeDisplay.getScopeGroupId(), true);
	}else{
		challenges = ChallengeLocalServiceUtil.getChallengesByActive(themeDisplay.getScopeGroupId(), false);
	}
}

int challengesSize = challenges.size();

for (Challenge challenge : challenges) {
	 if (!category.equalsIgnoreCase("") && !location.equalsIgnoreCase("")){
		 if (CategoryLocalServiceUtil.getCategory(challenge.getChallengeId(), category) != null && 
		    LocationLocalServiceUtil.getLocation(challenge.getChallengeId(), location) != null){
		   	filteredChallenges.add(challenge);
		 }	 
	 }
	 if (!category.equalsIgnoreCase("") && location.equalsIgnoreCase("")){
		 if (CategoryLocalServiceUtil.getCategory(challenge.getChallengeId(), category) != null){
		   	filteredChallenges.add(challenge);
		 }	 
	 }	 
	 if (category.equalsIgnoreCase("") && !location.equalsIgnoreCase("")){
		 if (LocationLocalServiceUtil.getLocation(challenge.getChallengeId(), location) != null){
		   	filteredChallenges.add(challenge);
		 }	 
	 }
	 if (category.equalsIgnoreCase("") && location.equalsIgnoreCase("")){
		filteredChallenges.add(challenge); 	 
	 }
}	

if (topVoted != null && topVoted.equalsIgnoreCase("true")){
	if (filteredChallenges.size() > 0){
		for (Challenge challenge : filteredChallenges) {
			scoreMap.put(challenge.getChallengeId(), ChallengeLocalServiceUtil.getAverageScore(challenge.getChallengeId()));
		}
		scoreMapAsList.addAll(scoreMap.entrySet());
		Collections.sort(scoreMapAsList, new Comparator<Entry<Long, Double>>(){
		    public int compare(Entry<Long, Double> dataOne, Entry<Long, Double> dataTwo){
		        return dataOne.getValue().compareTo(dataTwo.getValue());
		    }
		});
		filteredChallenges = new ArrayList();
		filteredChallenges.add(ChallengeLocalServiceUtil.getChallenge(scoreMapAsList.get(scoreMapAsList.size()-1).getKey()));
	}
}
/* if (hot != null && hot.equalsIgnoreCase("false")){
	hot = "";
}
*/
if (topVoted != null && topVoted.equalsIgnoreCase("false")){
	topVoted = "";
}

if (keywords != null && !keywords.equalsIgnoreCase("")){        
	filteredChallenges = ChallengeLocalServiceUtil.getChallengesBySearch(keywords);   
}
%>

<portlet:renderURL var="search">
    <portlet:param name="jspPage" value="/challenges.jsp" />
</portlet:renderURL>

<portlet:renderURL var="needDetails">
    <portlet:param name="jspPage" value="/needDetails.jsp" />
</portlet:renderURL>

<portlet:renderURL var="farmerProfile">
    <portlet:param name="jspPage" value="/farmerProfile.jsp" />
    <portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:renderURL>
	
<liferay-ui:success key="actionSuccess" message="Operation performed"/>
<liferay-ui:error key="actionError" message="Operation performed"/>									
<div class="container-fluid p-0 co-creation">
   <div class="row mb-4 border-bottom">
		<div class="col col-lg-6 col-sm-6 col-6 col-md-12">
			<h3 class="co-title">Challenges</a></h3>
		</div><!-- w-1/2  END-->
		<div class="col col-lg-6 col-sm-6 col-6 col-md-12  "> 
			  <aui:nav cssClass="nav-tabs nav-co-tabs-not-sel">
				<portlet:renderURL var="mycocreationsURL">
					<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
				</portlet:renderURL>
				<%if (isChallengeOwner){%>
					<aui:nav-item href="<%=mycocreationsURL%>" label="Co-Creations"/>
				<%}else{%>
					<aui:nav-item href="<%=mycocreationsURL%>" label="My Co-Creations"/>
				<%}%>
			</aui:nav>	
			<aui:nav cssClass="nav-tabs nav-co-tabs">
				<portlet:renderURL var="challengesURL">
					<portlet:param name="jspPage" value="/challenges.jsp"/>
				</portlet:renderURL>
				<aui:nav-item href="<%=challengesURL%>" label="Challenges"/>
			  </aui:nav>
		</div><!-- w-1/2 END -->
	</div>
    <div class="row">
	    <div class="col col-lg-3 col-sm-3 col-3 col-md-12">
			<div id="trending" class="co-box mt-2 mb-4">
		    	<label class="aui-field-label co-title">Trending</label>    
			    <%-- <aui:input label="Hot" id="hot" name="hot" type="radio" value="<%=hot%>"></aui:input> --%>
				<aui:input label="Top Voted" id="topVoted" name="topVoted" type="radio" value="<%=topVoted%>"></aui:input>
			</div>
			<div id="location" class="co-box mt-2 mb-4">
				<label class="aui-field-label co-title">Location</label> 
				<aui:select label="" id="location" name="location" showEmptyOption="false">
				    <aui:option selected="<%=true%>" value="">Select a country</aui:option>
				    <%
					for (Country country : countries) {
					%>
						<aui:option selected="<%=false%>" value="<%=country.getName()%>"><%=country.getName()%></aui:option>	
					<% 
					}
					%>
			  </aui:select>
			</div>
			<div id="category" class="co-box mt-2 mb-4">
			  <label class="aui-field-label co-title">Category</label> 
	          <aui:select label="" id="category" name="category" showEmptyOption="false">
				    <aui:option selected="<%=true%>" value="">Select a category</aui:option>
				    <%
					for (AssetCategory assetCategory : assetCategories) {
					%>
						<aui:option selected="<%=false%>" value="<%=assetCategory.getName()%>"><%=assetCategory.getName()%></aui:option>	
					<% 
					}
					%>
			  </aui:select>
		    </div>
			<div id="challengeStatus" class="co-box mt-2 mb-4">
		    	<label class="aui-field-label co-title">Status</label>
		    	<aui:input id="active" name="active" label="Active" type="checkbox" value="<%=active%>"></aui:input>
		    	<aui:input id="inactive" name="inactive" label="Inactive" type="checkbox" value="<%=inactive%>"></aui:input>
			</div> 
			<div>
				<aui:button id="filter" name="filter" type="submit" value="Filter" cssClass="btn-outline-info"></aui:button>
				<aui:button id="clearFilter" name="clearFilter" type="button" value="Clear"/>
			</div>
		</div><!-- w-1/4  END-->
		<div class="col col-lg-9 col-sm-9 col-9 col-md-12">    
		    <div id="newChallenge" class="m-1 p-1" >
			 	 <portlet:renderURL var="newchallengeURL">
						<portlet:param name="jspPage" value="/newchallenge.jsp"/>
						<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
				 </portlet:renderURL>
				 <%if(isChallengeOwner){%>
	     	     	<a href="<%=newchallengeURL%>" class="btn btn-primary">Post a New Challenge</a>
	     	     <%}%>
			</div>
			</br>
			<div id="search" class="m-1 p-1">
				<aui:form name="searchForm" action="<%=search%>" method="post">
		    	 	<aui:input id="keywords" name="keywords" placeholder="Title, description, username" inlineLabel="left" label="" size="256" value=""/> 
			    	<aui:button type="submit" value="search" cssClass="append-input-btn"/>
			    	<aui:button type="button" value="Clear" id="clearSearch" name="clearSearch" />
				</aui:form>
			</div>
			</br>
		    <div id="challenges" class="m-1 p-1"> 
				<div class="co-abstract row flex-lg-row flex-sm-row flex-row flex-md-row">     	
			            <div class="col col-lg-10 col-sm-10 col-10 col-md-12">
	            			 <%
					   		 if (challengesSize == 0){
					   		 %>
					   			<h3 class="co-title">There are no challenges</a></h3>
							 <%
							 }else{
						   		 if (filteredChallenges.size() == 0){
						   		 %>
						   			<h3 class="co-title">You have no challenges</a></h3>
								 <%
								 }
							 }
							 for (Challenge challenge : filteredChallenges) {
							 %>
								<aui:form action="" name="<portlet:namespace />fm">
									<liferay-portlet:actionURL name="deleteChallenge" var="deleteChallengeURL">
											<portlet:param name="challengeId" value="<%=String.valueOf(challenge.getChallengeId())%>"/>
											<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
									</liferay-portlet:actionURL>	
									<%String deleteConfirmation = "javascript:deleteConfirmation('"+deleteChallengeURL+"');";%>
									<portlet:renderURL var="viewChallengeDetails">
										<portlet:param name="mvcPath" value="/challengeDetails.jsp" />
										<portlet:param name="challengeId" value="<%=String.valueOf(challenge.getChallengeId())%>"/>
										<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request)%>"></portlet:param>
									</portlet:renderURL>
									<h3 class="sheet-subtitle"></h3>
			          			    <h3 class="co-title"><a href="<%=viewChallengeDetails%>"><%=challenge.getTitle() %></a></h3>
						  		    <div class="co-content">
								    	<%-- <div class="co-summary mb-2">
								           <%=challenge.getDescription() %>					  
										</div> --%>
										<div class="co-info ">
										    <div class="row mt-2">
											     <div class="col col-lg-6 col-sm-6 col-6 col-md-6">
											     	<div id="postedBy" class="challengesLeft">
											      		<span><b><label class="aui-field-label">Posted by</label></b></span> : <span><label class="aui-field-label"><a href="<%=UserLocalServiceUtil.getUserById(challenge.getUserId()).getDisplayURL(themeDisplay)%>"><%=challenge.getUserName()%></a></label></span>
					       						 	</div>
					       						 	<div id="startDate" class="challengesLeft">
														<span><b><label class="aui-field-label">Start</label></b></span> : <span><%=formatter.format(challenge.getStartDate()) %></span>
									       			</div>
									       			<div id="endDate" class="challengesLeft">
														<span><b><label class="aui-field-label">End</label></b></span> : <span><%=formatter.format(challenge.getEndDate()) %></span>
									       			</div>
					     							<div id="status" class="challengesLeft">
												    	<span><b><label class="aui-field-label">Status</label></b></span> : <span><%=challenge.getActive() == true ?  "Active" : "Inactive"%></span>
												    </div> 
												    <div id="location" class="challengesLeft">
												    	<span><b><label class="aui-field-label">Location</label></b></span> : <span><%=LocationLocalServiceUtil.getLocationByChallengeId(challenge.getChallengeId()).getName()%></span>
												    </div> 
												    <div id="tags" class="challengesLeft">
													    <span><b><label class="aui-field-label">Tags</label></b></span> : <span>	
											    	  	<%
														for (Hashtag tag : HashtagLocalServiceUtil.getHashtagsByChallengeId(challenge.getChallengeId())) {
														%>
															<%-- <span><a href="">#<%=tag.getName()%></a></span> --%>
															<span><%=tag.getName()%></span>	
														<% 
														}
														%>
													</div> 
													<div id="categories" class="challengesLeft">
														<span><b><label class="aui-field-label">Categories</label></b></span> : <span>	
											    	  	<%
														for (Category cat : CategoryLocalServiceUtil.getCategoriesByChallengeId(challenge.getChallengeId())) {
														%>
															<%-- <span><a href="">#<%=cat.getName()%></a></span> --%>
															<span><%=cat.getName()%></span>	
														<% 
														}
														%>
											     	</div>
										    	</div>
										    	
										    	<aui:button-row>
										         	<a href="<%=viewChallengeDetails%>" class="btn btn-primary"><i class="fa fa-info-circle" aria-hidden="true"></i>Details</a>
										   		 	<!-- <a href="#" class="btn btn-primary "> <i class="fa fa-bell-o" aria-hidden="true"></i> Follow</a> -->
										   		 	<%if (user != null){
														if(challenge.getUserId() == user.getUserId()){%>
												   		 	<aui:button id="deleteChallenge" name="deleteChallenge" type="button" value="Delete" onClick="<%=deleteConfirmation%>"/>
											   		 	<%}%>
											   		 <%}%>	
										   		</aui:button-row>	
									    	</div>
						        		</div>
						        	</div>	
						       	</aui:form> 
						       	<%-- <liferay-ui:ratings className="<%=Challenge.class.getName()%>" classPK="<%=challenge.getChallengeId()%>" type="like" /> --%>
								<%-- <liferay-ui:ratings className="<%=Challenge.class.getName()%>" classPK="<%=challenge.getChallengeId()%>" type="stars" /> --%>
								<liferay-ui:ratings className="<%=Challenge.class.getName()%>" classPK="<%=challenge.getChallengeId()%>" type="thumbs" />
						       	<%
								AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(Challenge.class.getName(), challenge.getChallengeId());
						        Discussion discussion = CommentManagerUtil.getDiscussion(user.getUserId(), scopeGroupId, Challenge.class.getName(), entry.getEntryId(), new ServiceContextFunction(request));
								%>
						       	<%-- <liferay-ui:panel-container extended="<%=false%>" id='<%="guestbookCollaborationPanelContainer_" + challenge.getChallengeId()%>' persistState="<%=true%>">
  										<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>" id='<%="guestbookCollaborationPanel_" + challenge.getChallengeId()%>' persistState="<%=true%>" title="">
    										<portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />
									    	<liferay-comment:discussion className="<%=Entry.class.getName()%>"
      											classPK="<%=entry.getEntryId()%>"
      											formAction="<%=discussionURL%>" formName="fm2"
      											discussion="<%= discussion %>"
      											ratingsEnabled="<%=true%>" redirect="<%=PortalUtil.getCurrentURL(request)%>"
      											userId="<%=entry.getUserId()%>" />
      									</liferay-ui:panel>
								</liferay-ui:panel-container> --%>
							 <%
							 }
							 %>
			           	</div>    
			  		</div>	    
				</div>
	  	</div><!-- w-3/4 END -->
	</div> 
</div><!-- container -->

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
 	var getChallenges = Liferay.PortletURL.createRenderURL();
	getChallenges.setPortletId('it_eng_rd_collaborativecreation_portlet_CollaborativecreationPortlet');
	getChallenges.setParameter("mvcPath","/challenges.jsp");
		
 	AUI().ready('aui-base','node', 'event', function (A) {
      A.one("#<portlet:namespace/>filter").on('click',function(event){
      		getChallenges.setParameter("active", A.one('#<portlet:namespace />active').attr('checked'));	
      	    getChallenges.setParameter("inactive", A.one('#<portlet:namespace />inactive').attr('checked'));
      	    getChallenges.setParameter("location", A.one('#<portlet:namespace />location').val());	
      	    getChallenges.setParameter("category", A.one('#<portlet:namespace />category').val());
      	    <%-- getChallenges.setParameter("hot", A.one('#<portlet:namespace />hot').attr('checked')); --%>
      	    getChallenges.setParameter("topVoted", A.one('#<portlet:namespace />topVoted').attr('checked'));
            window.location.href=getChallenges; 
      });
      A.one("#<portlet:namespace/>clearFilter").on('click',function(event){
      		A.one('#<portlet:namespace />active').val("");	
      	    A.one('#<portlet:namespace />inactive').val("");
      	    A.one('#<portlet:namespace />location').val("");	
      	    A.one('#<portlet:namespace />category').val("");
      	    <%-- A.one('#<portlet:namespace />hot').val(""); --%>
      	    A.one('#<portlet:namespace />topVoted').val("");
      	    window.location.href=getChallenges;     
      });
      A.one("#<portlet:namespace/>clearSearch").on('click',function(event){
      		A.one('#<portlet:namespace />keywords').val("");	
      	    window.location.href=getChallenges;     
      });
 	});
</aui:script>
