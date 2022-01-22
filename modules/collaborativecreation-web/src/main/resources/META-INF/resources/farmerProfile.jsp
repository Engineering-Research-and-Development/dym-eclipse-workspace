<%@ include file="/init.jsp" %>

<style>
	.aui .navbar .navbar-inner {
    	min-height: 67px;
	}
   	.farmerProfileRight {
  		background: #ECF0F1;
  		padding: 5px;
  		min-height: 54px !important;
  		border: 10px solid #fff;
  		float:right; 
  		display:block; 
  		width:70%;
  	    height:400px;
   	}	
   	.farmerProfileLeft {
  		float:left; 
  		display:block; 
  		width:auto;
  	    height:100px;
  	    margin-bottom: 43px !Important;
  	    margin-right: 1px !Important;
  	    clear:left;
   	}
   	.landParcelRight {
  		background: #ECF0F1;
  		min-height: 24px !important;
  		border: 5px solid #fff;
  		float:right; 
  		display:block; 
  		width:50%;
  	    height:100px;
   	}	
   	.landParcelLeft {
  		border: 5px solid #fff;
  		float:left; 
  		display:block; 
  		width:40%;
  	    height:100px;
  	    margin-bottom: 23px !Important;
  	    margin-right: 1px !Important;
  	    clear:left;
   	}
   	.addlandParcel {
  		float:right; 
  		display:block; 
  		width:10%;
  	    height:5px;
  	    margin-top: -52px !Important;
  	    margin-right: 233px !Important;
   	}	
</style>

<portlet:renderURL var="details">
    <portlet:param name="jspPage" value="/challengeDetails.jsp" />
</portlet:renderURL>

<%-- <aui:nav cssClass="nav-tabs">
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
</aui:nav>	 --%>



<div class="container-fluid p-0 co-creation">
   
  	<div class="row">
			 <div class="col-12 col-md-12 border-bottom">
				 	<div id=" " class="m-1 p-1" >
					 	 <portlet:renderURL var="challengesURL">
								<portlet:param name="jspPage" value="/challenges.jsp"/>
						</portlet:renderURL>
		
					      <a href="<%=challengesURL%>" class="newChallenge"><i class="fa fa-arrow-circle-left" aria-hidden="true"></i> <span class="co-title dark">Farmer's Profile</span></a>   
					</div>
			 </div>
			 
		 </div>


   <div class="row">
   <div class="col col-lg-3 col-sm-3 col-3 col-md-12">
		
		<div id="userPic" class="co-box mt-2 mb-4">
	    	    <img alt="" src="<%=request.getContextPath()%>/img/user.png" width="100" >
		</div>
		
		
		
		<div class="co-box mt-2 mb-4">
	    	 <label class="aui-field-label co-sub-title">Name:</label>    
		     <span>Jhoannes Antoniadis</span>
		</div>
		<div class="co-box mt-2 mb-4">
	    	 <label class="aui-field-label co-sub-title">Location:</label>    
		     <span>Ireland</span>
		</div>
		<div class="co-box mt-2 mb-4">
	    	 <label class="aui-field-label co-sub-title">Email:</label>    
		     <span>jhon@emai.com</span>
		</div>
		<div class="co-box mt-2 mb-4">
	    	 <label class="aui-field-label co-sub-title">Farmer's Organization:</label>    
		     <span>Farmers United</span>
		</div>
		 
		 
  </div><!-- w-1/4  END-->
  <div class="col col-lg-9 col-sm-9 col-9 col-md-12"> 
	   
	   
	   
	   <liferay-ui:tabs names="Land Parcel 1,Land Parcel 2,Land Parcel 3,Land Parcel 4" refresh="false" tabsValues="Land Parcel 1,Land Parcel 2,Land Parcel 3,Land Parcel 4">
			    <div id="landParcel" class="addlandParcel">
					<img class="journal-image" hspace="0" id="addLandParcel" src="<%=request.getContextPath()%>/img/plus.png" vspace="0"/>
				</div>
			    <liferay-ui:section>
			        <div id="landParcelMeasurements1" class="landParcelLeft">
              			<aui:input label="Measurements" name="measurements1" id="measurements1" type="text" value="123 acres"/>
			        </div>
			        <div id="landParcelCrops1" class="landParcelRight">
              			<label class="control-label">Crops</label>
              			<ul>
						  <li>Apple trees : 20</li>
						  <li>Sugarcane : 91</li>
						  <li>Grapes : 612</li>
						</ul>
			        </div>
					<div id="landParcelLocation1" class="landParcelLeft">
			              <aui:input label="Location" name="lpLocation1" id="lpLocation1" type="text" value="Xyz"/>
			        </div>
			        <div id="landParcelPictures1" class="landParcelRight">
              			<aui:input label="Pictures" name="pictures1" id="pictures1" type="text" value="Picture 1, Picture 2, Picture 3"/>
			        </div>
			    </liferay-ui:section>
			    <liferay-ui:section>
			        <div id="landParcelMeasurements2" class="landParcelLeft">
              			<aui:input label="Measurements" name="measurements2" id="measurements2" type="text" value="432 acres"/>
			        </div>
			        <div id="landParcelCrops2" class="landParcelRight">
              			<label class="control-label">Crops</label>
              			<ul>
						  <li>Apple trees : 50</li>
						  <li>Sugarcane : 21</li>
						  <li>Grapes : 942</li>
						</ul>
			        </div>
					<div id="landParcelLocation2" class="landParcelLeft">
			              <aui:input label="Location" name="lpLocation2" id="lpLocation2" type="text" value="Abc"/>
			        </div>
			        <div id="landParcelPictures2" class="landParcelRight">
              			<aui:input label="Pictures" name="pictures2" id="pictures2" type="text" value="Picture 4, Picture 5, Picture 6"/>
			        </div>
			    </liferay-ui:section>
			    <liferay-ui:section>
			        <div id="landParcelMeasurements3" class="landParcelLeft">
              			<aui:input label="Measurements" name="measurements3" id="measurements3" type="text" value="732 acres"/>
			        </div>
			        <div id="landParcelCrops3" class="landParcelRight">
              			<label class="control-label">Crops</label>
              			<ul>
						  <li>Apple trees : 40</li>
						  <li>Sugarcane : 11</li>
						  <li>Grapes : 992</li>
						</ul>
			        </div>
					<div id="landParcelLocation3" class="landParcelLeft">
			              <aui:input label="Location" name="lpLocation3" id="lpLocation3" type="text" value="Def"/>
			        </div>
			        <div id="landParcelPictures3" class="landParcelRight">
              			<aui:input label="Pictures" name="pictures3" id="pictures3" type="text" value="Picture 7, Picture 8, Picture 9"/>
			        </div>
			    </liferay-ui:section>
			    <liferay-ui:section>
			        <div id="landParcelMeasurements4" class="landParcelLeft">
              			<aui:input label="Measurements" name="measurements4" id="measurements4" type="text" value="132 acres"/>
			        </div>
			        <div id="landParcelCrops4" class="landParcelRight">
              			<label class="control-label">Crops</label>
              			<ul>
						  <li>Apple trees : 10</li>
						  <li>Sugarcane : 61</li>
						  <li>Grapes : 92</li>
						</ul>
			        </div>
					<div id="landParcelLocation4" class="landParcelLeft">
			              <aui:input label="Location" name="lpLocation4" id="lpLocation4" type="text" value="Ghi"/>
			        </div>
			        <div id="landParcelPictures4" class="landParcelRight">
              			<aui:input label="Pictures" name="pictures4" id="pictures4" type="text" value="Picture 10, Picture 11, Picture 12"/>
			        </div>
			    </liferay-ui:section>
			</liferay-ui:tabs>
		 
	     
	  
  </div><!-- w-3/4 END -->
 
 </div> 
  
</div><!-- container -->

 


 