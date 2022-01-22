<%@ include file="/init.jsp" %>

<style>
	.aui .navbar .navbar-inner {
    	min-height: 67px;
	}
</style>

<!-- <aui:nav cssClass="nav-tabs"> -->
<!-- 	<portlet:renderURL var="cocreationsURL"> -->
<!-- 		<portlet:param name="jspPage" value="/view.jsp"/> -->
<!-- 	</portlet:renderURL> -->
<%-- 	<aui:nav-item href="<%=cocreationsURL%>" label="Welcome !"/> --%>
<!-- </aui:nav> -->

<!-- <aui:nav cssClass="nav-tabs"> -->
<!-- 	<portlet:renderURL var="challengesURL"> -->
<!-- 		<portlet:param name="jspPage" value="/challenges.jsp"/> -->
<!-- 	</portlet:renderURL> -->
<%-- 	<aui:nav-item href="<%=challengesURL%>" label="Challenges"/> --%>

<!-- 	<portlet:renderURL var="mycocreationsURL"> -->
<!-- 		<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/> -->
<!-- 	</portlet:renderURL> -->
<%-- 	<aui:nav-item href="<%=mycocreationsURL%>" label="My Co-Creations"/> --%>
<!-- </aui:nav>	 -->

<portlet:actionURL name="addChallenge" var="addChallengeURL">
	<portlet:param name="active" value="true"/>
</portlet:actionURL>

<div id="challengeFormContainer" class="container">
	
	<div class="row">
			 <div class="col-12 col-md-12 border-bottom">
				 	<div id=" " class="m-1 p-1" >
					 	 <portlet:renderURL var="challengesURL">
								<portlet:param name="jspPage" value="/challenges.jsp"/>
						</portlet:renderURL>
		
					      <a href="<%=challengesURL%>" class="newChallenge"><i class="fa fa-arrow-circle-left" aria-hidden="true"></i> <span class="co-title dark">Post a Challenge</span></a>   
					</div>
			 </div>
			 
		 </div>
		<div class="row">
			 <div class="col-12 col-md-6">
				<c:if test="${error}">
					<div class="alert alert-danger">${message}</div>
				</c:if>
			 </div>
		 </div>
	
	
	
	<aui:form id="formChallenge" name="fm" method="post" action="<%= addChallengeURL.toString() %>">
         
         <div class="row">
		    <div class="col-12 col-md-12">
		        	<div class="pb-2">
		        	    <label class="control-label" for="title">Title</label>
                        <div><input class="form-control" id="title" type="text" value="" name="title" /></div>
                    </div>
                    <div class="pb-2">
                        <div class="  ">
				            <label class="control-label">Description</label>
				            <textarea class="form-control col-12 span12 " name="description" id="description"></textarea>
				        </div>
                    </div>
			
			</div>
			<div class="col-12 col-sm-6 col-md-6">
		         
			           <div class=" pb-2 borderGroup">
                               <label class=" control-label">Start Date</label>
							 <input label="Start Date" name="startDate" id="startDate" type="date">
                                 <small class="form-text text-muted">  </small>
				 </div>
			</div>
			<div class="col-12 col-sm-6 col-md-6">
		           
			 <div class=" pb-2 borderGroup">
                                       <label class=" control-label">End Date</label>
                                         <input label="End Date" name="endDate" id="endDate" type="date">
                                         <small class="form-text text-muted">  </small>
                         </div>
			</div>
		
		</div>
         <div class="row">
		    <div class="col-12 col-md-12">
		           <aui:button-row>
			        	<aui:button type="submit" value="Post" cssClass="btn-outline-info"></aui:button>
			        	 
			        </aui:button-row>  
						 
			</div>
		
		</div>
          
	</aui:form>      
</div>

