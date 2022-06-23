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
		/* filteredChallenges.add(ChallengeLocalServiceUtil.getChallenge(scoreMapAsList.get(scoreMapAsList.size()-1).getKey())); */
		for(int i=1; i < scoreMapAsList.size() + 1; i++){	
			filteredChallenges.add(ChallengeLocalServiceUtil.getChallenge(scoreMapAsList.get(scoreMapAsList.size()-i).getKey()));
		}
	}
}

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
			<div id="trending" class="co-box mt-2 mb-4  card-1">
		    	<label class="aui-field-label co-title">Trending</label>    
				<%-- <aui:input label="Top Voted" id="topVoted" name="topVoted" type="radio" value="<%=topVoted%>"></aui:input> --%>
				<aui:input label="sortByVote" id="topVoted" name="topVoted" type="radio" value="<%=topVoted%>"></aui:input>
			</div>
			<div id="location" class="co-box mt-2 mb-4 card-1">
				<label class="aui-field-label co-title"><liferay-ui:message key="location"/></label> 
				<aui:select label="" id="location" name="location" showEmptyOption="false">
				    <aui:option selected="<%=true%>" value=""><liferay-ui:message key="selectCountry"/></aui:option>
				    <%
					for (Country country : countries) {
					%>
						<aui:option selected="<%=false%>" value="<%=country.getName()%>"><%=country.getName()%></aui:option>	
					<% 
					}
					%>
			  </aui:select>
			</div>
			<div id="category" class="co-box mt-2 mb-4 card-1">
			<label class="aui-field-label co-title"><liferay-ui:message key="category"/></label> 
	          <aui:select label="" id="category" name="category" showEmptyOption="false">
				    <aui:option selected="<%=true%>" value=""><liferay-ui:message key="selectCategory"/></aui:option>
				    <%
					for (AssetCategory assetCategory : assetCategories) {
					%>
						<aui:option selected="<%=false%>" value="<%=assetCategory.getName()%>"><%=assetCategory.getName()%></aui:option>	
					<% 
					}
					%>
			  </aui:select>
		   </div>
		   <div id="challengeStatus" class="co-box mt-2 mb-4 card-1">
		    	<label class="aui-field-label co-title"><liferay-ui:message key="status"/></label>
		    	<aui:input id="active" name="active" label="active" type="checkbox" value="<%=active%>"></aui:input>
		    	<aui:input id="inactive" name="inactive" label="inactive" type="checkbox" value="<%=inactive%>"></aui:input>
			</div> 
			<div>
				<aui:button id="filter" name="filter" type="submit" value="filter" cssClass="btn-outline-info"></aui:button>
				<aui:button id="clearFilter" name="clearFilter" type="button" value="clear"/>
			</div>
		</div><!-- w-1/4  END-->
		<div class="col col-lg-9 col-sm-9 col-9 col-md-12">    
		    <div id="newChallenge" class="m-1 p-1" >
			 	<div class="rightContent">
			 	 <portlet:renderURL var="newchallengeURL">
						<portlet:param name="jspPage" value="/newchallenge.jsp"/>
						<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
				 </portlet:renderURL>
				 <%if(isChallengeOwner){%>
	     	     	<a href="<%=newchallengeURL%>" class="btn btn-primary btn-hover"><i class="fa fa-plus" aria-hidden="true"></i> <liferay-ui:message key="postNewChallenge"/></a>
	     	     <%}%>
	     	     <a href="#" id="filterbutton" class="btn btn-primary btn-hover"> <i class="fa fa-search" aria-hidden="true"></i> Search</a>
			 	</div>
		 	</div> 
			<div id="search" class="m-1 p-1">
				<aui:form name="searchForm" action="<%=search%>" method="post">
		    	 	<aui:input id="keywords" name="keywords" placeholder="titleDescriptionUsername" inlineLabel="left" label="" size="256" value=""/> 
			    	<aui:button type="submit" value="search" cssClass="append-input-btn"/>
			    	<aui:button type="button" value="clear" id="clearSearch" name="clearSearch" />
				</aui:form>
			</div>
			<aui:form action="" name="<portlet:namespace />fm">
		    		<div id="challenges" class="row"> 
			             <ul class="cards">
			            			<%
							   		if (challengesSize == 0){
							   		%>
							   			<h3 class="co-title"><liferay-ui:message key="thereAreNoChallenges"/></a></h3>
									<%
									}else{
								   		 if (filteredChallenges.size() == 0){
								   		 %>
								   			<h3 class="co-title"><liferay-ui:message key="youHaveNoChallenges"/></a></h3>
										 <%
										 }
									}
									for (Challenge challenge : filteredChallenges) {
									%>
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
									<li class="user-card-item" d-pagegroup="1">
									    <div class="user-card">
									      <div class="user-card-pb card__image--fence"><a href="<%=UserLocalServiceUtil.getUserById(challenge.getUserId()).getDisplayURL(themeDisplay)%>"><img class="userProfilePicture" src="https://eu.ui-avatars.com/api/?name=<%=challenge.getUserName()%>&amp;background=222e5a&amp;color=fff"></a></div>			 	 
									      <div class="user-card-img"></div>
									      <div class="user-card-cont">
									        <div class="user-card-title"><a href="<%=viewChallengeDetails%>"><%=challenge.getTitle() %></a></div>
									        <p class="user-id"><i class="fa fa-map-marker" aria-hidden="true"></i> <liferay-ui:message key="location"/></label> : <span><%=LocationLocalServiceUtil.getLocationByChallengeId(challenge.getChallengeId()).getName()%></span></p>
									        <div id="startDate" class="challengesLeft">
												<span><b><label class="aui-field-label"><i class="fa fa-calendar-check-o" aria-hidden="true"></i> <liferay-ui:message key="start"/></label></b></span> : <span><%=formatter.format(challenge.getStartDate()) %></span>
										    </div>
										    <div id="endDate" class="challengesLeft">
												<span><b><label class="aui-field-label"><i class="fa fa-calendar-times-o" aria-hidden="true"></i> <liferay-ui:message key="end"/></label></b></span> : <span><%=formatter.format(challenge.getEndDate()) %></span>
										    </div>
						     				<%-- <div id="status" class="challengesLeft">
											   	<span><b><label class="aui-field-label"><liferay-ui:message key="status"/></label></b></span> : <span><%=challenge.getActive() == true ?  "Active" : "Inactive"%></span>
											</div>  --%>
											<div id="status" class="challengesLeft">
											   	<span><b><label class="aui-field-label"><i class="fa fa-lightbulb-o" aria-hidden="true"></i> <liferay-ui:message key="status"/></label></b></span> : <span><label class="aui-field-label"><%=challenge.getEndDate().after(nowDate) == true ?  "Active" : "Inactive"%></label></span>
											</div> 
											<div id="tags" class="challengesLeft">
											    <span><b><label class="aui-field-label"><i class="fa fa-tag" aria-hidden="true"></i> Tags</label></b></span> : <span>	
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
												<span><b><label class="aui-field-label"><i class="fa fa-cog" aria-hidden="true"></i> <liferay-ui:message key="categories"/></label></b></span> : <span>	
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
									      <liferay-ui:ratings className="<%=Challenge.class.getName()%>" classPK="<%=challenge.getChallengeId()%>" type="thumbs" />
									      <%
										  AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(Challenge.class.getName(), challenge.getChallengeId());
									      Discussion discussion = CommentManagerUtil.getDiscussion(user.getUserId(), scopeGroupId, Challenge.class.getName(), entry.getEntryId(), new ServiceContextFunction(request));
										  %>
										  <div class="btn-row">
											  <%-- <div class="btn-row"><button onClick="<%=viewChallengeDetails%>" class="blue"><i class="fa fa-info-circle" aria-hidden="true"></i> <liferay-ui:message key="details"/></button> --%>
											  <a href="<%=viewChallengeDetails%>" class="btn btn-primary"><i class="fa fa-info-circle" aria-hidden="true"></i><liferay-ui:message key="details"/></a>
											  <%if (user != null){
													if(challenge.getUserId() == user.getUserId()){%>
											   		 	<button id="deleteChallenge" name="deleteChallenge"  class="red" onClick="<%=deleteConfirmation%>"> <i class="fas fa-trash-alt edit-btn red"></i> Delete</button>
										   		 	<%}%>
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
</div><!-- w-3/4 END -->
	
<script>
$(document).ready(function(){
     $("#search").toggle();
     $("#filterbutton").click(function(event){
          event.preventDefault();
     	  $("#search").slideToggle(200);
  	});
});

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
