<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>

<portlet:actionURL name="/saveConfiguration" var="saveConfig">
</portlet:actionURL>

<liferay-ui:error key="not-allow-group" message="not-allow-group"></liferay-ui:error>

<aui:form action="<%=saveConfig %>" method="post" name="fm">
	<aui:row>
		<aui:col span="4">
			<aui:select name="site">
				<c:forEach var="group" items="${groups }">
					<aui:option label="${group.groupKey }" value="${group.groupId }"></aui:option>
				</c:forEach>
			</aui:select>
		</aui:col>
		<aui:col span="4">
		</aui:col>
	</aui:row>
	
	<liferay-ui:panel-container accordion="false">
		<liferay-ui:panel title="chat-setting">
			<aui:row>
				<aui:col span="4">
					<aui:input name="enable" type="checkbox"></aui:input>
				</aui:col>
				<aui:col span="4">
					<aui:input name="chat-request" type="checkbox"></aui:input>
				</aui:col>		
			</aui:row>
		</liferay-ui:panel>
	   <liferay-ui:panel title="chat-color">
	        <aui:row>
				<aui:col span="4">
					<aui:input name="header-text-color" type="text" cssClass="chatColorPicker"></aui:input>
				</aui:col>
				<aui:col span="4">
					<aui:input name="content-text-color" type="text" cssClass="chatColorPicker"></aui:input>
				</aui:col>
				<aui:col span="4">
					<aui:input name="chat-right-color" type="text" cssClass="chatColorPicker"></aui:input>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="4">
					<aui:input name="header-color" type="text" cssClass="chatColorPicker"></aui:input>
				</aui:col>
				<aui:col span="4">
					<aui:input name="back-ground-color" type="text" cssClass="chatColorPicker"></aui:input>
				</aui:col>
				<aui:col span="4">
					<aui:input name="chat-left-color" type="text" cssClass="chatColorPicker"></aui:input>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="4">
<%-- 					<aui:input name="text-change-position" type="text"></aui:input> --%>
					
					<aui:select name="text-change-position">
					    <aui:option value="footerChat">Footer Chat</aui:option>
					    <aui:option value="sidebarChat">Sidebar Chat</aui:option>
					</aui:select>
					
				</aui:col>
			</aui:row>
	   </liferay-ui:panel>
	
	  <liferay-ui:panel title="chat-role">
	        <aui:row>
				<aui:col span="12">
				<aui:input name="selectItems" type="hidden" />
		    	<aui:input name="availableItems" type="hidden" />
			    <liferay-ui:input-move-boxes
			        leftBoxName="availableValues"
			        leftList="${leftList }"
			        leftTitle="available"
			        rightBoxName="selectedValues"
			        rightList="${rightList }"
			        rightTitle="selected"
			        rightReorder="false"
			    />
			    </aui:col>
			</aui:row>
	 </liferay-ui:panel>
	</liferay-ui:panel-container>
	
	<aui:row>
		<aui:col span="12">
			<aui:button-row>
				<aui:button type="submit"></aui:button>
			</aui:button-row>
		</aui:col>
	</aui:row>
</aui:form>

<portlet:resourceURL id="/getSiteData" var="getSiteData">
</portlet:resourceURL>

<aui:script use="liferay-util-list-fields">
A.one('#<portlet:namespace/>fm').on('submit', function(event) {
    var selectedValues = Liferay.Util.listSelect('#<portlet:namespace/>selectedValues');
    A.one('#<portlet:namespace/>selectItems').val(selectedValues);
    
    var availableValues = Liferay.Util.listSelect('#<portlet:namespace/>availableValues');
    A.one('#<portlet:namespace/>availableItems').val(availableValues);
    
    submitForm('#<portlet:namespace/>fm');
});

YUI().use(
  'aui-color-picker-popover',
  function(Y) {
  
    var colorPicker = new Y.ColorPickerPopover(
      {
        trigger: '.chatColorPicker',
        zIndex: 2
      }
    ).render();

    colorPicker.on('select',
      function(event) {
        event.trigger.setStyle('backgroundColor', event.color);
        event.trigger.val(event.color);
      }
    );
  }
);
</aui:script>
<script>
$(window).ready(function() {
	var siteIdInitial = $('#<portlet:namespace/>site').val();
	getData(siteIdInitial);
	
	$('.chatColorPicker').on("input", function(){
		$(this).css('background-color', this.value);
	});
});
$('#<portlet:namespace/>site').on('change', function() {
	getData(this.value);
});

function getData(siteId){
	var fd = new FormData();
	 fd.append('<portlet:namespace/>groupId', siteId);
	 $.ajax({
		 type: "POST",
         url : "<%= getSiteData.toString() %>",
		data:  fd,
      contentType:  false,
      processData: false,
      success: function(res){ 
//        console.log('getData function');
   	   var data = $.parseJSON(res);
//    		console.log('getData data= ' + data);
   	   $('#<portlet:namespace/>chat-request').prop('checked', data.requestFeature);
   	   $('#<portlet:namespace/>enable').prop('checked', data.isEnable);
   	   
   	   $('#<portlet:namespace/>header-color').val(data.headerColor);
   	   $('#<portlet:namespace/>header-color').css('background-color', data.headerColor);
   	   $('#<portlet:namespace/>chat-right-color').val(data.chatRightColor);
   	   $('#<portlet:namespace/>chat-right-color').css('background-color', data.chatRightColor);
   	   $('#<portlet:namespace/>chat-left-color').val(data.chatLeftColor);
   	   $('#<portlet:namespace/>chat-left-color').css('background-color', data.chatLeftColor);
   	   
   	   $('#<portlet:namespace/>header-text-color').css('background-color', data.headerTextColor);
   	   $('#<portlet:namespace/>header-text-color').val(data.headerTextColor);
   	   $('#<portlet:namespace/>content-text-color').css('background-color', data.contentTextColor);
   	   $('#<portlet:namespace/>content-text-color').val(data.contentTextColor);
   	   $('#<portlet:namespace/>back-ground-color').css('background-color', data.backColor);
   	   $('#<portlet:namespace/>back-ground-color').val(data.backColor);
   	   
   	   $('#<portlet:namespace/>text-change-position').val(data.fontFamily);
   	   
   	   var array = data.selectedRole.split(",");
   	   $('#<portlet:namespace/>selectedValues').empty();
   	   $('#<portlet:namespace/>availableValues').empty();
   	   $.each(data.roles, function( index, item ) {
   		   var isFind = array.indexOf(item.roleId.toString());
   		   if(isFind != -1){
   			   $('#<portlet:namespace/>selectedValues').append("<option class='' value='"+item.roleId+"' data-selected='true'>"+item.name+"</option>");
   		   } else {
   			   $('#<portlet:namespace/>availableValues').append("<option class='' value='"+item.roleId+"' data-selected='true'>"+item.name+"</option>");
   		   }
		});
      },
      error: function(XMLHttpRequest, textStatus,errorThrown){
      	console.log('errorThrown = ' + errorThrown);
      	console.log('textStatus = ' + textStatus);
      	console.log('XMLHttpRequest = ' + XMLHttpRequest);
      }
	});
}
</script>