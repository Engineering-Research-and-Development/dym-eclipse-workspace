<%@ include file="/init.jsp" %>

<aui:fieldset>
	<div class="clearfix" style="margin-right:20px; margin-left:20px;">
        <div class="form-group"><label class="control-label" for="description">Add description</label>
             <div><input class="form-control" id="description" maxlength="30" type="text" value="" name="description"/></div>
        </div>
        <div class="form-group"><label class="control-label" for="uploadDocuments">Upload Documents</label>
             <div><input class="form-control" id="uploadDocuments" maxlength="30" type="text" value="" name="uploadDocuments"/></div>
        </div>
    </div>            
</aui:fieldset>

<aui:button-row>
  	<div id="aui_popup_click">
       	<aui:button type="submit" value="Post" cssClass="btn-outline-info"></aui:button>
   	</div>
   	<div id="aui_popup_content" ></div>
</aui:button-row>     

<aui:script use="liferay-util-window">
	A.one("#aui_popup_click").on('click',function(event){
 		var dialog = new A.Modal({
	 		title: "<b>To-Do added successfully</b>",
	 		bodyContent: "<b>To-Do added successfully !</b>",
	 		headerContent: "",
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