<%@ include file="/init.jsp" %>

<aui:fieldset>
	<div class="clearfix" style="margin-right:20px; margin-left:20px;">
        <div class="form-group"><label class="control-label" for="title">Title</label>
             <div><input class="form-control" id="title" maxlength="30" type="text" value="" name="title" /></div>
        </div>
        <div class="form-group"><label class="control-label" for="inviteParticipants">Invite Participants</label>
             <div><input class="form-control" id="inviteParticipants" maxlength="30" type="text" value="" name="inviteParticipants" /></div>
        </div>
        <div class="form-group">
             <aui:input label="Message" placeholder="Type a message here..." name="message" id="message" type="textarea" />
        </div>
    </div>            
</aui:fieldset>

<aui:button-row>
  	<div id="aui_popup_click">
       	<aui:button type="submit" value="Send Request" cssClass="btn-outline-info"></aui:button>
   	</div>
   	<div id="aui_popup_content" ></div>
</aui:button-row>     

<aui:script use="liferay-util-window">
	A.one("#aui_popup_click").on('click',function(event){
 		var dialog = new A.Modal({
	 		title: "<b>Requested to Co-Create</b>",
	 		bodyContent: "<b>Challenge</b> : Sensor integration of soil humidity with weather data to predict future harvest.<br><b>Posted by</b> : Johannes Antoniadis",
	 		headerContent: "<b>Requested to Co-Create !</b>",
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