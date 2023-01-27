<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<c:if test="<%= themeDisplay.isSignedIn() %>">
	

	<c:if test="${userHaveRole && isEnable}" >
	<c:choose>
		<c:when test="${fontFamily eq 'footerChat'}">
			<div class="chat-minimized" id="chat-sidebar">
			 	<div class="chat_box">
			 		<div class="chat_head" onclick="chatHeadClick(this)" style="background-color: ${headerColor}; color: ${headerTextColor};">
						Chat (<span id="totalUnreadCount">0</span>)
						<div class="main-win">
							<span class="fa fa-window-maximize"></span>
						</div>
					</div>
					<div class="chat_wrap" style="display: none; background-color:${backColor}">
						<div class="searchme">
							<div class="input-group">
							    <input type="text" class="form-control" id="searchUser" placeholder="Search" onkeyup="userSearchFilter()">
							    <div class="input-group-btn">
							      <button class="btn btn-default" type="submit">
							        <i class="fa fa-search"></i>
							      </button>
							    </div>
							  </div>
							<!-- <input type="text" id="searchUser" placeholder="Search" onkeyup="userSearchFilter()" />  -->
						</div>
						
						<c:choose>
							<c:when test="${requestFeature }">
								<liferay-ui:tabs names="Chats,Users" param="user" refresh="false" type="tabs nav-tabs-default" onClick="selectTab(this)">
									<liferay-ui:section>
								        <ul id="chatUserList" class="list-group list-group-flush">
											<!--  Here show the online and offline requested and accepted user list -->
										</ul>
								    </liferay-ui:section>
								    <liferay-ui:section>
								        <ul id="userList" class="list-group list-group-flush">
											<!--  Here show the online and offline user list -->
										</ul>
								    </liferay-ui:section>
								</liferay-ui:tabs>
							</c:when>
							<c:otherwise>
								<ul id="allUserList" class="list-group list-group-flush">
									<!--  Here show the online and offline user list -->
								</ul>
							</c:otherwise>
						</c:choose>
						
					</div>
			 	</div>
			</div>
		    </c:when>
			<c:when test="${fontFamily eq 'sidebarChat'}">
				<div class="chat_wrap" style="background-color:${backColor}">
					<div class="searchme">
						<div class="input-group">
						    <input type="text" class="form-control" id="searchUser" placeholder="Search" onkeyup="userSearchFilter()">
						    <div class="input-group-btn">
						      <button class="btn btn-default" type="submit">
						        <i class="fa fa-search"></i>
						      </button>
						    </div>
						  </div>
						<!-- <input type="text" id="searchUser" placeholder="Search" onkeyup="userSearchFilter()" />  -->
					</div>
					
					<c:choose>
						<c:when test="${requestFeature }">
							<liferay-ui:tabs names="Chats,Users" param="user" refresh="false" type="tabs nav-tabs-default" onClick="selectTab(this)">
								<liferay-ui:section>
							        <ul id="chatUserList" class="list-group list-group-flush">
										<!--  Here show the online and offline requested and accepted user list -->
									</ul>
							    </liferay-ui:section>
							    <liferay-ui:section>
							        <ul id="userList" class="list-group list-group-flush">
										<!--  Here show the online and offline user list -->
									</ul>
							    </liferay-ui:section>
							</liferay-ui:tabs>
						</c:when>
						<c:otherwise>
							<ul id="allUserList" class="list-group list-group-flush">
								<!--  Here show the online and offline user list -->
							</ul>
						</c:otherwise>
					</c:choose>
					
				</div>
			</c:when>
		</c:choose>


	</c:if>
 </c:if>
 <input id="request-feature-m" type="hidden" value="${requestFeature}">
 <input id="header-color-m" type="hidden" value="${headerColor }">
 <input id="chat-right-color-m" type="hidden" value="${chatRightColor }">
 <input id="chat-left-color-m" type="hidden" value="${chatLeftColor }">
 <input id="header-text-color-m" type="hidden" value="${headerTextColor }">
 <input id="content-text-color-m" type="hidden" value="${contentTextColor }">
 <input id="back-color-m" type="hidden" value="${backColor }">
 <input id="font-family-m" type="hidden" value="${fontFamily }">
 <c:set var="isSignIn" value="<%=themeDisplay.isSignedIn() %>"></c:set>
 <portlet:resourceURL id="/getUsers" var="getUsers">
 </portlet:resourceURL>
 
 <portlet:resourceURL id="/saveMessage" var="saveMessage">
 </portlet:resourceURL>
 
 <portlet:resourceURL id="/getMessages" var="getMessages">
 </portlet:resourceURL>
 
 <portlet:resourceURL id="/downloadFile" var="downloadFile">
 	<portlet:param name="fileId" value="ASSET_INFO" />
 </portlet:resourceURL>
 
 <portlet:resourceURL id="/getUnreadMessageCount" var="getUnreadMessageCount">
 </portlet:resourceURL>
 
 <portlet:resourceURL id="/chatMarkAsRead" var="chatMarkAsRead">
 </portlet:resourceURL>
 
  <portlet:resourceURL id="/deleteMessage" var="deleteMessage">
 </portlet:resourceURL>
 
 <portlet:resourceURL id="/deleteAllMessages" var="deleteAllMessages">
 </portlet:resourceURL>
 
 <portlet:resourceURL id="/userTyping" var="userTyping">
 </portlet:resourceURL>
 
 <portlet:resourceURL id="/sendChatRequest" var="sendChatRequest">
 </portlet:resourceURL>
 
 <portlet:resourceURL id="/actionChatRequest" var="actionChatRequest">
 </portlet:resourceURL>
 
 <script>
 var userProfiles = new Map();
 $(document).ready(function(){
	 notifyMePermision();
	 var isSign = ${isSignIn};
	 var userHaveRole = ${userHaveRole};
	 var isEnable = ${isEnable};
	 $('.msg_box').remove();
	 if(isSign && userHaveRole && isEnable) {
		getUsers();
		var activeWindows =  localStorage.getItem("userChatWindow");
		if(activeWindows != undefined || activeWindows != null) {
			var json = JSON.parse(activeWindows);
			$.each(json, function( key, value ) {  
				userChatWindow.set(key, value); 
				createUserChatBox(value, key, userProfiles[key]);
				$('[rel="'+key+'"] .msg_wrap');
		    });
			$(".uc-window .fa-window-minimize").removeClass("fa-window-minimize").addClass("fa-window-maximize");
		}
	 }
 }); 
 
 function getUsers(){
	 console.log('gu');
	 var url = "<%= getUsers.toString() %>";
	 if(url != 'undefined'){
		 $.ajax({
	   			url : url,
	            type: "POST",
	            async: false,
	            contentType:  false,
	            processData: false,
	            xhrFields: {
	                withCredentials: true
	            },
	            success: function(res){
	            	getUsersLogic(res);
	            },
	            error: function(XMLHttpRequest, textStatus,errorThrown){
	            	console.log('errorThrown = ' + errorThrown);
	            	console.log('textStatus = ' + textStatus);
	            	console.log('XMLHttpRequest = ' + XMLHttpRequest);
	            }
	        });
		}
 }
 
 function getUsersLogic(obj){
	 try {
 		var data = $.parseJSON(obj);
//  	start
//      	console.log('getUsersLogic, data: ', data);
 		userProfiles = data._jsonObject.map.userPortrait;
 		
     	if(${requestFeature} && ${userHaveRole}) {
     		$('#chatUserList').empty();
     		var unreadMessageAllUser = 0;
         	data._jsonObject.map.users.forEach(function(item, index){
         		var sendRequest = data._jsonObject.map.requestedUser.find(function(obj) {
         			  return obj._toUserId === item._userId
         		});
         		
         		var getRequest = data._jsonObject.map.requestedUser.find(function(obj) {
         			  return obj._fromUserId === item._userId
         		});
         		
         		var user;
         		if(sendRequest !== undefined) {
         			user = sendRequest
         		} else {
         			user = getRequest;
         		}
         		
         		if(user !== undefined && user._isRejected === false) {
         			var li = document.createElement("li");
	            		li.setAttribute('class', 'list-group-item');
	            		li.setAttribute('id', item._userId+'_on');
	            		li.setAttribute('style', 'background-color:transparent;');
	            		
	            		var img = document.createElement('img');
	            		//img.setAttribute('src', imgsrc+item._portraitId);
	            		img.setAttribute('src', data._jsonObject.map.userPortrait[item._userId]);
	            		img.setAttribute('class', 'img-responsive user-list-profile');
	            		
	            		var span = document.createElement("span");
	            		var userName = item._firstName+" "+item._lastName;
	            		span.setAttribute('title', userName);
	            		span.setAttribute('isaccepted', user._isAccepted);
	            		span.setAttribute('isrejected', user._isRejected);
	            		span.setAttribute('touserid', user._toUserId);
	            		span.setAttribute('id', item._userId);
	            		span.setAttribute('class', 'user-cur');
	            		span.setAttribute('onclick', 'curUserClick(this)');
	            		span.setAttribute('style', 'color:${contentTextColor};');
	            		span.innerHTML = userName;
	            		
	            		li.appendChild(img);
	            		li.appendChild(span);

	            		var unreadMessage = data._jsonObject.map.userUnreadMessage[item._userId];
	            		if(unreadMessage > 0) {
	            			unreadMessageAllUser = unreadMessageAllUser + unreadMessage;
	            			var badgeSpan = document.createElement("span");
         				badgeSpan.setAttribute('class', 'badge badge-primary badge-margin-left');
         				badgeSpan.innerHTML = unreadMessage;
         				li.appendChild(badgeSpan);
	            		}
	            		
	            		if(user._isAccepted === false) {
	            			var rSpan = document.createElement("span");
	            			rSpan.setAttribute('class', 'request-label');
	            			rSpan.innerHTML = '<i class="fa fa-handshake-o" aria-hidden="true"></i>';
	            			li.appendChild(rSpan);
	            		}
	            		
	            		$('#chatUserList').append(li);
         		}
         		$('#totalUnreadCount').empty();
         		$('#totalUnreadCount').append(unreadMessageAllUser);
         	});
         	$('#userList').empty();
     		data._jsonObject.map.users.forEach(function(item, index){
     			
     			var sendRequest = data._jsonObject.map.requestedUser.find(function(obj) {
         			  return obj._toUserId === item._userId
         		});
         		
         		var getRequest = data._jsonObject.map.requestedUser.find(function(obj) {
         			  return obj._fromUserId === item._userId
         		});
         		
         		
         		var user;
         		if(sendRequest !== undefined) {
         			user = sendRequest
         		} else {
         			user = getRequest;
         		}
         		
         		if(user === undefined) {
         			
         			var p_li = document.createElement("li");
	            		p_li.setAttribute('class', 'list-group-item');
	            		p_li.setAttribute('style', 'background-color:transparent;');
	            		
	            		var p_img = document.createElement('img');
	            		//img.setAttribute('src', imgsrc+item._portraitId);
	            		p_img.setAttribute('src', data._jsonObject.map.userPortrait[item._userId]);
	            		p_img.setAttribute('class', 'img-responsive user-list-profile');
						
	            		var p_span = document.createElement("span");
	            		var p_userName = item._firstName+" "+item._lastName;
	            		p_span.setAttribute('title', p_userName);
	            		p_span.setAttribute('id', 'p_'+item._userId);
	            		p_span.setAttribute('class', 'user-cur-p');
	            		p_span.setAttribute('style', 'color:${contentTextColor};');
	            		p_span.innerHTML = p_userName;
	            		
	            		p_li.appendChild(p_img);
	            		p_li.appendChild(p_span);
         			
	            		var p_i = document.createElement("i");
		            	p_i.setAttribute('class', 'fa fa-user-plus add-user-icon');
		            	p_i.setAttribute('onclick', 'addUserClick(this)');
		            	p_i.setAttribute('id', 'r_'+item._userId);
	    	        	p_i.setAttribute('aria-hidden', 'true');	
	        	    	p_li.appendChild(p_i);
         		} else if(user._isRejected === true) {
         			var p_li = document.createElement("li");
	            		p_li.setAttribute('class', 'list-group-item');
	            		p_li.setAttribute('style', 'background-color:transparent;');
	            		
	            		var p_img = document.createElement('img');
	            		//img.setAttribute('src', imgsrc+item._portraitId);
	            		p_img.setAttribute('src', data._jsonObject.map.userPortrait[item._userId]);
	            		p_img.setAttribute('class', 'img-responsive user-list-profile');
						
	            		var p_span = document.createElement("span");
	            		var p_userName = item._firstName+" "+item._lastName;
	            		p_span.setAttribute('title', p_userName);
	            		p_span.setAttribute('id', 'p_'+item._userId);
	            		p_span.setAttribute('class', 'user-cur-p');
	            		p_span.setAttribute('style', 'color:${contentTextColor};');
	            		p_span.innerHTML = p_userName;
	            		
	            		p_li.appendChild(p_img);
	            		p_li.appendChild(p_span);
         			
         			var p_i = document.createElement("i");
		            	p_i.setAttribute('class', 'fa fa-user-plus add-user-icon');
		            	p_i.setAttribute('onclick', 'addUserClick(this)');
		            	p_i.setAttribute('id', 'r_'+item._userId);
	    	        	p_i.setAttribute('aria-hidden', 'true');	
	        	    	p_li.appendChild(p_i);
         		}
     			
         		$('#userList').append(p_li);
     		});
     	} else {
     		$('#allUserList').empty();
     		var unreadMessageAllUser = 0;
         	data._jsonObject.map.users.forEach(function(item, index){
         		
     			var li = document.createElement("li");
         		li.setAttribute('class', 'list-group-item');
         		li.setAttribute('id', item._userId+'_on');
         		li.setAttribute('style', 'background-color:transparent;');
         		
         		var img = document.createElement('img');
         		//img.setAttribute('src', imgsrc+item._portraitId);
         		img.setAttribute('src', data._jsonObject.map.userPortrait[item._userId]);
         		img.setAttribute('class', 'img-responsive user-list-profile');
         		
         		var span = document.createElement("span");
         		var userName = item._firstName+" "+item._lastName;
         		span.setAttribute('title', userName);
         		span.setAttribute('id', item._userId);
         		span.setAttribute('class', 'user-cur');
         		span.setAttribute('onclick', 'curUserClick(this)');
         		span.setAttribute('requestFeature', ${requestFeature});
         		span.setAttribute('style', 'color:${contentTextColor};');
         		span.innerHTML = userName;
         		
         		li.appendChild(img);
         		li.appendChild(span);

         		var unreadMessage = data._jsonObject.map.userUnreadMessage[item._userId];
         		if(unreadMessage > 0) {
         			unreadMessageAllUser = unreadMessageAllUser + unreadMessage;
         			var badgeSpan = document.createElement("span");
     				badgeSpan.setAttribute('class', 'badge badge-primary badge-margin-left');
     				badgeSpan.innerHTML = unreadMessage;
     				li.appendChild(badgeSpan);
         		}
         		
         		$('#allUserList').append(li);	
         	});
         	$('#totalUnreadCount').empty();
         	$('#totalUnreadCount').append(unreadMessageAllUser);
     	}
     	
     	setOnlineUser();
     //end
     } catch(e) {
     	console.log('JSON parse error ');
     	console.log(e);
     }
 }
 
 function sendMessage(userId) {
		var message = $('[rel="'+userId+'"] #messageArea').val();
		var fileInputElement = $('[rel="'+userId+'"] #attachment');
		var messageTrim = message.trim();
		if( messageTrim.length  != 0 || fileInputElement.prop('files')[0]) {
			var fd = new FormData();
			fd.append("<portlet:namespace/>toUser", userId);
			fd.append("<portlet:namespace/>text", message); 
			fd.append("<portlet:namespace/>attachment", fileInputElement.prop('files')[0]);
			loaderStart(userId);
	        $.ajax({
	            url: "<%= saveMessage.toString() %>",
	            type: "POST",
	            data:  fd,
	            contentType:  false,
	            processData: false,
	            xhrFields: {
	                withCredentials: true
	            },
	            success: function (data) {
	            	console.log('sendMessage ok');
	                var data = $.parseJSON(data);
	                userChatHistory(data.chat, data.fromUser, userId, false);
	                clearChatArea(userId);
	                getUsers();
	                loaderOff(userId);
	            },
			    error: function (XMLHttpRequest, textStatus, errorThrown) {
			    	clearChatArea(userId);
			    	loaderOff(userId);
			    	console.log(textStatus);
			    }
			});
		}
	}
 
//Get chat messages
 function getUserChatHistory(userId, totalRecords, isScrollTop){
	 var fd = new FormData();
	 fd.append("<portlet:namespace/>userId", userId);
	 fd.append("<portlet:namespace/>totalRecord", totalRecords);
	 loaderStart(userId);
    $.ajax({
        //url: contextPath + '/widgets/chat/to/userchat.sf?userId='+userId+'&totalRecords='+totalRecords,
       	url : "<%= getMessages.toString() %>",
        type: "POST",
        data: fd,
        contentType:  false,
        processData: false,
        xhrFields: {
            withCredentials: true
        },
        success: function (data) {
        	var data = $.parseJSON(data);
     	   $("#to_userId").val(data.toUser);
     	   $("#actu_userId").val(data.fromUser);
     	   userChatHistory(data.chat, data.fromUser, data.toUser, isScrollTop);
     	   $("#totalRecords_"+userId).val(data.totalRecords);
     	   $("#count_"+userId).val(data.count);
     	   //stopSpinner(userId);
     	   
     	   //Unread chat hide and calculate
     	   $("."+userId+" .unread").css("display","none");
     	   var thisUserUnread = Number($("."+userId+" .unread").text());
     	   var toalUnread = Number($("#totalUnreadCount").text());
     	   $("#totalUnreadCount").text(toalUnread - thisUserUnread)
     	   $("."+userId+" .unread").text(0);
     	   loaderOff(userId);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
     	   console.log(errorThrown);
     	  	loaderOff(userId);
        }
    });
 }
 
 function downloadAttachment(fileId) {
	 var link = '<%= downloadFile.toString() %>'.replace("ASSET_INFO",fileId);
	 window.location = link;
 }
 
 function chatMarkAsRead(userId){
	 var fd = new FormData();
	 fd.append('<portlet:namespace/>userId', userId);
	 $.ajax({
		 type: "POST",
         url : "<%= chatMarkAsRead.toString() %>",
		data:  fd,
        contentType:  false,
        processData: false,
        xhrFields: {
            withCredentials: true
        },
        success: function(res){
        	getUsers();        	
        },
        error: function(XMLHttpRequest, textStatus,errorThrown){
        	console.log('errorThrown = ' + errorThrown);
        	console.log('textStatus = ' + textStatus);
        	console.log('XMLHttpRequest = ' + XMLHttpRequest);
        }
	});
 }
 
 function deleteMessage(messageId){
	 var fd = new FormData();
	 fd.append('<portlet:namespace/>id', messageId);
	 $.ajax({
		 type: "POST",
         url : "<%= deleteMessage.toString() %>",
		data:  fd,
        contentType:  false,
        processData: false,
        xhrFields: {
            withCredentials: true
        },
        success: function(res){        	
        },
        error: function(XMLHttpRequest, textStatus,errorThrown){
        	console.log('errorThrown = ' + errorThrown);
        	console.log('textStatus = ' + textStatus);
        	console.log('XMLHttpRequest = ' + XMLHttpRequest);
        }
	});
 }
 
 function deleteAllMessage(userId){
	 var fd = new FormData();
	 fd.append('<portlet:namespace/>userId', userId);
	 $.ajax({
		 type: "POST",
         url : "<%= deleteAllMessages.toString() %>",
		data:  fd,
        contentType:  false,
        processData: false,
        xhrFields: {
            withCredentials: true
        },
        success: function(res){        	
        },
        error: function(XMLHttpRequest, textStatus,errorThrown){
        	console.log('errorThrown = ' + errorThrown);
        	console.log('textStatus = ' + textStatus);
        	console.log('XMLHttpRequest = ' + XMLHttpRequest);
        }
	});
 }
 
 function typingMessage(userId){
	 var fd = new FormData();
	 //console.log('typingMessage userId: ', userId);
	 fd.append('<portlet:namespace/>userId', userId);
	 $.ajax({
		 type: "POST",
         url : "<%= userTyping.toString() %>",
		data:  fd,
        contentType:  false,
        processData: false,
        xhrFields: {
            withCredentials: true
        },
        success: function(res){        	
        },
        error: function(XMLHttpRequest, textStatus,errorThrown){
        	console.log('errorThrown = ' + errorThrown);
        	console.log('textStatus = ' + textStatus);
        	console.log('XMLHttpRequest = ' + XMLHttpRequest);
        }
	});
 }
 
 function sendChatRequest(userId){
	 var fd = new FormData();
	 //fd.append('<portlet:namespace/>userId', userId);
	 fd.append('userId', userId);
	 $.ajax({
		type: "POST",
		url : "<%= sendChatRequest.toString() %>",
		data:  fd,
        contentType:  false,
        processData: false,
        xhrFields: {
            withCredentials: true
        },
        success: function(res){ 
        	getUsers();
        },
        error: function(XMLHttpRequest, textStatus,errorThrown){
        	console.log('errorThrown = ' + errorThrown);
        	console.log('textStatus = ' + textStatus);
        	console.log('XMLHttpRequest = ' + XMLHttpRequest);
        }
	});
 }
 
 function actionChatRequest(userId, username, actionStatus) {
	 var fd = new FormData();
	 fd.append('<portlet:namespace/>userId', userId);
	 fd.append('<portlet:namespace/>actionStatus', actionStatus);
	 $.ajax({
		 type: "POST",
         url : "<%= actionChatRequest.toString() %>",
		data:  fd,
        contentType:  false,
        processData: false,
        xhrFields: {
            withCredentials: true
        },
        success: function(res){
        	var data = $.parseJSON(res);
        	//console.log(data);
        	getUsers();
        	$('#p_r_'+userId).remove();
        	arr.splice($.inArray(userId, arr), 1);
    		displayChatBox();
    		//stopSpinner(chatbox);
    		userChatWindow.delete(userId);
    		if(actionStatus === true) {
    			createUserChatBox(username, userId); }
        	
        },
        error: function(XMLHttpRequest, textStatus,errorThrown){
        	console.log('errorThrown = ' + errorThrown);
        	console.log('textStatus = ' + textStatus);
        	console.log('XMLHttpRequest = ' + XMLHttpRequest);
        }
	});
 }
 </script>
