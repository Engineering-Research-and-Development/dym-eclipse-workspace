<%@ include file="/init.jsp" %>

<%
String redirectTo = request.getParameter("redirectTo");
%>

<portlet:actionURL name="addChallenge" var="addChallengeURL">
	<portlet:param name="redirectTo" value="<%=redirectTo%>"/>
</portlet:actionURL>

<div id="challengeFormContainer" class="container">
	 <div class="container-fluid p-0 co-creation">
	     <div class="row mb-4 border-bottom">
			<div class="col col-lg-6 col-sm-6 col-6 col-md-12">
				<portlet:renderURL var="challengesURL">
					<portlet:param name="jspPage" value="/challenges.jsp"/>
				</portlet:renderURL>
				<%-- <a href="<%=challengesURL%>"><i class="fa fa-arrow-circle-left" aria-hidden="true"></i></a><span class="co-title">Post a new challenge</span> --%>
				<span class="co-title">Post a new challenge</span>
			</div><!-- w-1/2  END-->
			<div class="col col-lg-6 col-sm-6 col-6 col-md-12"> 
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
     </div>
	 <div class="row">
		 <div class="col-12 col-md-6">
			<c:if test="${error}">
				<div class="alert alert-danger">${message}</div>
			</c:if>
		 </div>
	 </div>
	 <aui:form id="formChallenge" name="fm" method="post" enctype="multipart/form-data" action="<%= addChallengeURL.toString()%>">
         <div class="row">
		    <div class="col-12 col-md-12">
	        	<div class="pb-2">
                       <div><aui:input label="Title" name="title" id="title" type="text" required='true'/></div>
                </div>
			</div>
			<div class="col-12 col-md-12">
                <div class="pb-2">
                       <div><aui:input class="form-control col-12 span12 " label="Description" name="description" id="description" type="textarea" required='true'/></div>
                </div>
			</div>
			<div class="col-12 col-md-12">
                <div class="pb-2">
                       <div><aui:input class="form-control col-12 span12 " label="Desired Outcome" name="desiredOutcome" id="desiredOutcome" type="textarea" required='true'/></div>
                </div>
			</div>
			<div class="col-sm-6 col-md-6">
		        <div class=" pb-2 borderGroup">
			          <aui:select label="Location" id="location" name="location" showEmptyOption="false" required="true">
						    <aui:option selected="<%=true%>" value="">Select...</aui:option>
						    <%
							for (Country country : countries) {
							%>
								<aui:option selected="<%=false%>" value="<%=country.getName()%>"><%=country.getName()%></aui:option>	
							<% 
							}
							%>
					  </aui:select>
				</div>
		   </div>
		   <div class="col-sm-6 col-md-6">
	           <div class=" pb-2 borderGroup">
					<aui:select label="Status" id="active" name="active" showEmptyOption="true" required="true">
						<aui:option selected="<%=true%>" value="">Select...</aui:option>
					    <aui:option selected="<%=false%>" value="true">Active</aui:option>
					    <aui:option selected="<%=false%>" value="false">Inactive</aui:option>
				    </aui:select>
		  		</div>
			</div>
			<h3 class="sheet-subtitle"></h3>
			<div class="col-sm-6 col-md-6">
		        <div class=" pb-2 borderGroup">
		        	  <label class="control-label">Tags</label>
			          <select label="Tags" id="tags" name="tags" showEmptyOption="false" multiple="true" style="width: 100%;" required>
						    <%
							for (AssetTag assetTag : assetTags) {
							%>
								<option value="<%=assetTag.getName()%>"><%=assetTag.getName()%></option>	
							<% 
							}
							%>
					  </select>
				</div>
		    </div>
			<div class="col-sm-6 col-md-6">
		        <div class=" pb-2 borderGroup">
		        	  <label class="control-label">Categories</label>
			          <select label="Categories" id="categories" name="categories" showEmptyOption="false" multiple="true" style="width: 100%;" required>
						    <%
							for (AssetCategory assetCategory : assetCategories) {
							%>
								<option value="<%=assetCategory.getName()%>"><%=assetCategory.getName()%></option>	
							<% 
							}
							%>
					  </select>
				</div>
		    </div>
		    <h3 class="sheet-subtitle"></h3>
		    <div class="col-sm-6 col-md-6">
	           <div class=" pb-2 borderGroup"> 
                  <label class="control-label">Start Date</label>
				  <input id="startDate" name="startDate" class="form-control date" type="text" placeholder="dd/mm/yyyy" required='true'>
		 	   </div>
			</div>
			<div class="col-sm-6 col-md-6">
	           <div class=" pb-2 borderGroup">   
				  <label class="control-label">End Date</label>
				  <input id="endDate" name="endDate" class="form-control date" type="text" placeholder="dd/mm/yyyy" required='true'>
		 	   </div>
			</div>
		    <h3 class="sheet-subtitle"></h3>
			<div class="col-12 col-md-12">
		       	   <div class="pb-2">
		       			<div id="fileList"></div>
						<span style="display:block; height: 10px;"></span>
						<div class="btn-group">
							<label for="uploadedFile" class="btn btn-primary pull-left">Upload pictures and documents</label>
						    <div id="clearFileList" style="display:none">
								<liferay-ui:icon
										cssClass="btn-outline-info"
										id="clearFileListLink"
										image="delete"
										label="<%=true%>"
										url="javascript:void(0)" onClick="clearFileList();"  
								/> 
							</div>
						    <input type="file" id="uploadedFile" name="uploadedFile" style="visibility:hidden;" multiple="multiple" accept="image/*, .xlsx, .xls, .doc, .docx, .ppt, .pptx, .txt, .pdf" onchange="javascript:updateFileList()"/>
						</div>
					</div>
			 </div> 
		 </div>
         <div class="row">
		    <div class="col-12 col-md-12">
	           <aui:button-row>
		        	<aui:button type="submit" value="Publish" cssClass="btn-outline-info"></aui:button> 
		        	<aui:button name="cancel" type="button" value="Cancel" onClick="<%=challengesURL%>"/>	 
		        </aui:button-row>  		 
			</div>
		</div>
	</aui:form>      
</div>

<aui:script>
	AUI().use(
        'aui-datepicker',
        function(A) {
            new A.DatePicker({
                trigger: '.date',
                mask: '%d/%m/%Y',
                popover: {
                    zIndex: 1000
                }
            });
        }
	);
</aui:script>
