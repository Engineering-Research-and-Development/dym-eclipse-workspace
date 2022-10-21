<%@page import="com.liferay.ratings.kernel.service.RatingsStatsLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<%
String keywords = ParamUtil.getString(request, "keywords", null);
String active = ParamUtil.getString(request, "active", null);
String inactive = ParamUtil.getString(request, "inactive", null);
String location = ParamUtil.getString(request, "location", null);
String category = ParamUtil.getString(request, "category", null);
String topVoted = ParamUtil.getString(request, "topVoted", null);
String challengesAuthor = ParamUtil.getString(request, "challengesAuthor", null);

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

if (challengesAuthor != null && challengesAuthor.equalsIgnoreCase("false")){
	if (filteredChallenges.size() > 0){
		List<Challenge> otherChallengesList = new ArrayList();
		List<Challenge> filteredOtherChallengesList = new ArrayList();
		otherChallengesList = ChallengeLocalServiceUtil.getChallengesByGroupId(themeDisplay.getScopeGroupId());
		for(int i=0; i < filteredChallenges.size(); i++){
			for(int l=0; l < otherChallengesList.size(); l++){	
				if (otherChallengesList.get(l).getUserId() != themeDisplay.getUserId()){
					if (filteredChallenges.get(i).getChallengeId() == otherChallengesList.get(l).getChallengeId()){
						filteredOtherChallengesList.add(otherChallengesList.get(l));	
					}
				}
			}
		}
		filteredChallenges = new ArrayList();
		filteredChallenges = filteredOtherChallengesList;
	}
}

if (challengesAuthor != null && challengesAuthor.equalsIgnoreCase("true")){
	if (filteredChallenges.size() > 0){
		List<Challenge> myChallengesList = new ArrayList();
		List<Challenge> filteredMyChallengesList = new ArrayList();
		myChallengesList = ChallengeLocalServiceUtil.getChallengesByUserId(user.getUserId(), themeDisplay.getScopeGroupId());
		for(int i=0; i < filteredChallenges.size(); i++){
			for(int l=0; l < myChallengesList.size(); l++){	
				if (filteredChallenges.get(i).getChallengeId() == myChallengesList.get(l).getChallengeId()){
					filteredMyChallengesList.add(myChallengesList.get(l));	
				}
			}
		}
		filteredChallenges = new ArrayList();
		filteredChallenges = filteredMyChallengesList;
	}
}

if (topVoted != null && topVoted.equalsIgnoreCase("true")){
	if (filteredChallenges.size() > 0){
		for (Challenge challenge : filteredChallenges) {
			for (int l=0; l < RatingsStatsLocalServiceUtil.getRatingsStatses(0, Integer.MAX_VALUE).size(); l++) {
				if (RatingsStatsLocalServiceUtil.getRatingsStatses(0, Integer.MAX_VALUE).get(l).getClassPK() == challenge.getChallengeId()){
					/*Per determinare il ranking considero la somma calcolata fra i voti positivi e la media determinata fra i voti positivi e il totale dei voti espressi*/
					scoreMap.put(challenge.getChallengeId(), RatingsStatsLocalServiceUtil.getStats(Challenge.class.getName(), challenge.getChallengeId()).getTotalScore() + RatingsStatsLocalServiceUtil.getStats(Challenge.class.getName(), challenge.getChallengeId()).getAverageScore());
				}
			}
		}
		scoreMapAsList.addAll(scoreMap.entrySet());
		Collections.sort(scoreMapAsList, new Comparator<Entry<Long, Double>>(){
		    public int compare(Entry<Long, Double> dataOne, Entry<Long, Double> dataTwo){
		        return dataOne.getValue().compareTo(dataTwo.getValue());
		    }
		});
		filteredChallenges = new ArrayList();
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

<portlet:renderURL var="farmerProfile">
    <portlet:param name="jspPage" value="/farmerProfile.jsp" />
    <portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:renderURL>
	
<liferay-ui:success key="actionSuccess" message="Operation performed"/>
<liferay-ui:error key="actionError" message="Operation performed"/>									
<div class="container-fluid p-0 co-creation">
	<div class="row">
		<div class="userRole">
			<h4><a href="<%=UserLocalServiceUtil.getUserById(themeDisplay.getUserId()).getDisplayURL(themeDisplay)%>"><%=themeDisplay.getUser().getFullName()%></a></h4>
			<%if (isChallengeOwner){%>
				<h4>Farmer</h4>
			<%}else{%>
				<h4>Technology developer </h4>
			<%}%>
		</div>		
   </div>	
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
			<aui:nav cssClass="nav-tabs nav-co-tabs-not-sel">
				<portlet:renderURL var="viewURL">
					<portlet:param name="jspPage" value="/view.jsp"/>
				</portlet:renderURL>
				<aui:nav-item href="<%=viewURL%>" label="Help"/>
			</aui:nav>
		</div><!-- w-1/2 END -->
	</div>
    <div class="row">
	    <div class="col col-lg-3 col-sm-3 col-3 col-md-12">
			<div id="trending" class="co-box mt-2 mb-4  card-1">
		    	<!-- <label class="aui-field-label co-title">Trending</label> -->    
				<%-- <aui:input label="Top Voted" id="topVoted" name="topVoted" type="radio" value="<%=topVoted%>"></aui:input> --%>
				<aui:input label="sortByVote" id="topVoted" name="topVoted" type="radio" value="<%=topVoted%>"></aui:input>
			</div>
			<%if (isChallengeOwner){%>
				<div id="challengesAuthor" class="co-box mt-2 mb-4  card-1" style="display:block;">    
					<aui:input label="myChallenges" id="challengesAuthor" name="challengesAuthor" type="radio" value="true" checked="null"></aui:input>
					<aui:input label="otherChallenges" id="challengesAuthor" name="challengesAuthor" type="radio" value="false" checked="null"></aui:input>
				</div>
			<%}else{%>
				<div id="challengesAuthor" class="co-box mt-2 mb-4  card-1" style="display:none;">    
					<aui:input label="myChallenges" id="challengesAuthor" name="challengesAuthor" type="radio" value="true" checked="null"></aui:input>
					<aui:input label="otherChallenges" id="challengesAuthor" name="challengesAuthor" type="radio" value="false" checked="null"></aui:input>
				</div>
			<%}%>
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
			 	</div>
		 	</div> 
			<div id="challengesSearch" class="m-1 p-1">
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
									      <!-- <div class="user-card-img"></div> -->
									      <div class="user-card-cont">
									        <div class="user-card-title"><a href="<%=viewChallengeDetails%>"><%=challenge.getTitle() %></a></div>
									        <p class="user-id"><i class="fa fa-map-marker" aria-hidden="true"></i> <liferay-ui:message key="location"/></label> : <span><%=LocationLocalServiceUtil.getLocationByChallengeId(challenge.getChallengeId()).getName()%></span></p>
									        <div id="author">
											   	<span><b><label class="aui-field-label"><i class="fa fa-user-circle-o" aria-hidden="true"></i> <liferay-ui:message key="author"/></label></b></span> : <span><label class="aui-field-label"><a href="<%=UserLocalServiceUtil.getUserById(challenge.getUserId()).getDisplayURL(themeDisplay)%>"><%=challenge.getUserName()%></a></label></span>
											</div>
									        <div id="description">
											   	<span><b><label class="aui-field-label"><i class="fa fa-vcard-o" aria-hidden="true"></i> <liferay-ui:message key="description"/></label></b></span> : <span><label><%=challenge.getDescription()%></label></span>
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
      	    getChallenges.setParameter("topVoted", A.one('#<portlet:namespace />topVoted').attr('checked'));
      	    getChallenges.setParameter("challengesAuthor", A.one('#<portlet:namespace />challengesAuthor').attr('checked'));
            window.location.href=getChallenges; 
      });
      A.one("#<portlet:namespace/>clearFilter").on('click',function(event){
      		A.one('#<portlet:namespace />active').val("");	
      	    A.one('#<portlet:namespace />inactive').val("");
      	    A.one('#<portlet:namespace />location').val("");	
      	    A.one('#<portlet:namespace />category').val("");
      	    A.one('#<portlet:namespace />topVoted').val("");
      	    A.one('#<portlet:namespace />challengesAuthor').val("");
      	    window.location.href=getChallenges;     
      });
      A.one("#<portlet:namespace/>clearSearch").on('click',function(event){
      		A.one('#<portlet:namespace />keywords').val("");	
      	    window.location.href=getChallenges;     
      });
 	});
</aui:script>
