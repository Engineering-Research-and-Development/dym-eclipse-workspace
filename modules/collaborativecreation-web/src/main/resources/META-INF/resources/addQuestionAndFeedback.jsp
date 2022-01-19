<%@ include file="/init.jsp" %>

<aui:fieldset>
	<div class="clearfix" style="margin-right:20px; margin-left:20px;">
        <aui:input label="Type your question here" name="question" id="question" type="textarea"/>
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
	 		title: "<b>Question posted successfully</b>",
	 		bodyContent: "<b>Question posted successfully !</b>",
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