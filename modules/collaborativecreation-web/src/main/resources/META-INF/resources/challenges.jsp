<%@ include file="/init.jsp" %>

<style>
	/*.aui .navbar .navbar-inner {
    	min-height: 67px;
	}
   	.challengesRight {
  		background: #ECF0F1;
  		padding: 5px;
  		min-height: 54px !important;
  		border: 10px solid #fff;
  		float:right; 
  		display:block; 
  		width:70%;
  	    height:300px;
   	}
   	.challengesLeft {
  		float:left; 
  		display:block; 
  		width:auto;
  	    height:100px;
  	    margin-bottom: 43px !Important;
  	    margin-right: 1px !Important;
  	    clear:left;
   	}*/
</style>

<portlet:renderURL var="challengeDetails">
    <portlet:param name="jspPage" value="/challengeDetails.jsp" />
</portlet:renderURL>
<portlet:renderURL var="needDetails">
    <portlet:param name="jspPage" value="/needDetails.jsp" />
</portlet:renderURL>

<portlet:renderURL var="farmerProfile">
    <portlet:param name="jspPage" value="/farmerProfile.jsp" />
</portlet:renderURL>




<div class="container-fluid p-0 co-creation">
   
   <div class="row mb-4 border-bottom">
			  <div class="col col-lg-6 col-sm-6 col-6 col-md-12  ">
						    <portlet:renderURL var="cocreationsURL">
								<portlet:param name="jspPage" value="/view.jsp"/>
							</portlet:renderURL>
							<h3 class="co-mainTitle"> <a href="<%=cocreationsURL%>">CHALENGES </a></h3>
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
					<aui:nav-item href="<%=mycocreationsURL%>" label="My Co-Creations"/>
				</aui:nav>	
			  
			  </div><!-- w-1/2 END -->
	</div>


   <div class="row">
   <div class="col col-lg-3 col-sm-3 col-3 col-md-12">
		<div id="trending" class="co-box mt-2 mb-4">
	    	 <label class="aui-field-label co-title">Trending</label>    
		    <aui:input label="Hot" name="trending" type="radio" value="1"/>
			<aui:input label="Top Voted" name="trending" type="radio" value="2"/>
		</div>
		
		<div id="location" class="co-box mt-2 mb-4">
			<label class="aui-field-label co-title">Location</label>   
			<aui:select name="Location">
    			<aui:option value="1">Location 1</aui:option>
    			<aui:option value="2">Location 2</aui:option>
    			<aui:option value="3">Location 3</aui:option>
			</aui:select>
		</div>
		
		<div id="category" class="co-box mt-2 mb-4">
		<label class="aui-field-label co-title">Category</label>   
			<aui:select name="Category">
    			<aui:option value="1">Category 1</aui:option>
    			<aui:option value="2">Category 2</aui:option>
    			<aui:option value="3">Category 3</aui:option>
			</aui:select>
		</div>
		<div id="status" class="co-box mt-2 mb-4">
	    	<label class="aui-field-label co-title">Status</label>
	    	<aui:input name="active" label="Active" type="checkbox" value="1"></aui:input>
			<aui:input name="inactive" label="Inactive" type="checkbox" value="2"></aui:input>
			<aui:input name="inactive" label="Closed" type="checkbox" value="3"></aui:input>
		</div> 
  </div><!-- w-1/4  END-->
  <div class="col col-lg-9 col-sm-9 col-9 col-md-12"> 
	   
	    <div id="newChallenge" class="m-1 p-1" >
		 	 <portlet:renderURL var="newchallengeURL">
					<portlet:param name="jspPage" value="/newchallenge.jsp"/>
			 </portlet:renderURL>
     	     <a href="<%=newchallengeURL%>" class="btn btn-primary">Post a New Challenge</a>
		</div>
		
		<div id="search" class="m-1 p-1">
			<aui:input inlineLabel="left" label="" name="keywords" placeholder="Search" size="256" />
		</div>
	    <div id="challenges" class="m-1 p-1">
		 
		 <div class="co-abstract row flex-lg-row flex-sm-row flex-row flex-md-row">
		         	
		           <div class="col col-lg-2 col-sm-2 col-2 col-md-12">
		          			<div class="co-point">
		          		 		<div id="aui_popup_click1" class="co-round">
						        	<i class="fa fa-long-arrow-up" aria-hidden="true"></i>
						        	 
						        </div>
						        <div  class="co-count">
						        	 <b>28</b>
						         </div>
						        <div id="aui_popup_content" ></div>
		          			</div>
		            </div>
		            <div class="col col-lg-10 col-sm-10 col-10 col-md-12">
		          				 <h3 class="co-title">  Sensor integration of soil humidity with weather data to predict future harvest. </h3>
					  		 	 <div class="co-content">
									  <div class="co-summary mb-2">
								           I find the proposal interesting. I think we need to do something more proactive and not remain in a merely theoretical framework.
										   It is necessary to make the project attractive through merchandising, gamification, .... so that the project reaches them in some way.
										
											  
									  </div>
									  <div class="co-info ">
										    <div class="row mt-2">
										     <div class="col col-lg-8 col-sm-8 col-8 col-md-8">
										      	<span><b>Posted by : </b><a href="<%=farmerProfile%>">Johannes Antoniadis</a></span>
				       						 	<br>
				     							<div id="status" class="challengesLeft">
											    	<span><b><label class="aui-field-label">Status</label></b></span> : <span><label class="aui-field-label">Active</label> </span>
											    </div> 
										     </div>
										     <div class="col col-lg-4 col-sm-4 col-4 col-md-4">
										         <a href="<%=challengeDetails%>" class="btn btn-primary "><i class="fa fa-info-circle" aria-hidden="true"></i> Details</a>
										   		 <a href="#" class="btn btn-primary "> <i class="fa fa-bell-o" aria-hidden="true"></i> Follow</a>
										     </div>
										    </div>
									  </div>
									  <div class="co-tag mb-2"> <span><a href="">#humidity</a></span>
			      						  <span><a href="">#weather</a></span>
			       						  <span><a href="">#harvest</a></span></div>
					        	</div>
		           </div>
		           
		           
		           
		  </div>
		  
		  
		  
		  <div class="co-abstract row align-items-lg-start align-items-sm-start align-items-start align-items-md-start flex-lg-row flex-sm-row flex-row flex-md-row">
		           <div class="col col-lg-2 col-sm-2 col-2 col-md-2">
		          			<div class="co-point">
		          		 		<div id="aui_popup_click1" class="co-round">
						        	<i class="fa fa-long-arrow-up" aria-hidden="true"></i>
						        	 
						        </div>
						        <div  class="co-count">
						        	 <b>28</b>
						         </div>
						        <div id="aui_popup_content" ></div>
		          			</div>
		            </div>
		            <div class="col col-lg-10 col-sm-10 col-10 col-md-10">
		          		 <h3 class="co-title">  Sensor integration of soil humidity with weather data to predict future harvest. </h3>
			  		 	 <div class="co-content">
							  <div class="co-summary">
						           I find the proposal interesting. I think we need to do something more proactive and not remain in a merely theoretical framework.
								   It is necessary to make the project attractive through merchandising, gamification, .... so that the project reaches them in some way.
								
									 
							    </div>
							  <div class="co-info">
							  			 <div class="row mt-2">
										     <div class="col col-lg-6 col-sm-6 col-6 col-md-6">
										      	<span><b>Posted by : </b><a href="<%=farmerProfile%>">Johannes Antoniadis</a></span>
				       						 	<br>
				     							<div id="status" class="challengesLeft">
											    	<span><b><label class="aui-field-label">Status</label></b></span> : <span><label class="aui-field-label">Active</label> </span>
											    </div> 
										     </div>
										     <div class="col col-lg-6 col-sm-6 col-6 col-md-6">
										         <a href="<%=challengeDetails%>" class="btn btn-primary "> <i class="fa fa-info-circle" aria-hidden="true"></i> Details</a>
										   		 <a href="#" class="btn btn-primary "><i class="fa fa-bell-o" aria-hidden="true"></i> Follow</a>
										     </div>
									     </div>
							  </div>
							  <div class="co-tag"> <span><a href="">#humidity</a></span>
	     										   <span><a href="">#weather</a></span>
	   											     <span><a href="">#harvest</a></span></div>
			        </div>
		           </div>
		  </div>
		 
		 
		    
	</div>
	  
  </div><!-- w-3/4 END -->
 
 </div> 
  
</div><!-- container -->

 

<aui:script use="liferay-util-window">
	A.one("#aui_popup_click1").on('click',function(event){
 		var dialog = new A.Modal({
	 		title: "<b>Challenge upvoted successfully !</b>",
	 		bodyContent: "<b>Challenge</b> : Sensor integration of soil humidity with weather data to predict future harvest.<br><b>Posted by</b> : Johannes Antoniadis",
	 		headerContent: "<b>Challenge upvoted successfully !</b>",
		    centered: true,
		    modal: true,
		    height: 200,
		    width:300,
		    render: '#aui_popup_content', 
		    close: true
 		});
 		dialog.render();
 	});
</aui:script>