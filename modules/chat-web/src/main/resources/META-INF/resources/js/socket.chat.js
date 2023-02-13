var websocket = null;

function initWebSocket(socketChatEndPointPath) {
	var socketChatEndPoint = getSocketEndPoint(socketChatEndPointPath);
    try {
        if (typeof MozWebSocket == 'function')
            WebSocket = MozWebSocket;
        if ( websocket && websocket.readyState == 1 )
            websocket.close();
        if(socketChatEndPointPath != '') {
        	websocket = new WebSocket( socketChatEndPoint );
        	websocket.onopen = function(message){ wsOpen(message);};
        	websocket.onmessage = function(message){ wsGetMessage(message);};
        	websocket.onerror = function(message){ wsError(message);};
        }
       
    } catch (exception) {
        debug('ERROR: ' + exception);
    }
}

function wsOpen(message){
//	console.log('Info: Chat socket connection opened.');
}
function wsSendMessage(message){
	websocket.send(message);
}

function wsGetMessage(message){
	var data = $.parseJSON(message.data);
	
	if(data.writing !== undefined) {
		$('[rel="'+data.fromUserId+'"] .msg_writing').text("typing");
		$('[rel="'+data.fromUserId+'"] .msg_writing').append("<img class='typing img-responsive' src='/o/it.eng.rd.chat.web/images/typing.gif'></img>");
		setTimeout(function () {
			$('[rel="'+data.fromUserId+'"] .msg_writing').empty();
		}, 6000);
	} else if(data.onlineUserIds !== undefined){
		var onlineUserSize = Object.keys(data.onlineUserIds).length;
		if(onlineUserSize < 0) {
			onlineUserSize = 0;
		}
		
		$('#totalUnreadCount').empty();
		$('#totalUnreadCount').append(onlineUserSize);
		
		/*data.onlineUserIds.forEach(function(item, index){
			$("#"+item).append("<span class='online-user'></span>");
		});*/
		updateOnlineUser(data.onlineUserIds);
		getUsers();
	} else if(data.chat !== undefined) {
		var activeWindows =  localStorage.getItem("userChatWindow");
		var isOpen = false;
		if(activeWindows != undefined || activeWindows != null) {
			var json = JSON.parse(activeWindows);
			$.each(json, function( key, value ) {
				if(key == data.toUser) {
					isOpen = true;
				}
		    });
		}
		$("#to_userId").val(data.toUser);
		$("#actu_userId").val(data.fromUser);
  	   
  	   $("#totalRecords_"+data.toUser).val(data.totalRecords);
  	   $("#count_"+data.toUser).val(data.count);
  	   //stopSpinner(userId);
  	   
  	   //Unread chat hide and calculate
  	   $("."+data.toUser+" .unread").css("display","none");
  	   var thisUserUnread = Number($("."+data.toUser+" .unread").text());
  	   var toalUnread = Number($("#totalUnreadCount").text());
  	   $("#totalUnreadCount").text(toalUnread - thisUserUnread)
  	   $("."+data.toUser+" .unread").text(0);
  	   if(isOpen){
			$('[rel="'+data.toUser+'"] .msg_wrap').css("display","block");
			userChatHistory(data.chat, data.fromUser, data.toUser, false);
		} else {
			 setTimeout(function(){ 
				 createUserChatBox(data.fromUserName, data.toUser);
			 }, 500);
		}
		notifyMe('New message arrive from '+ data.fromUserName, data.chat[0].message);
	} else if(data.sendRequest !== undefined) {
		notifyMe(data.from + ' want to connect with you', '');
		getUsers();
	} else if(data.requestAction !== undefined) {
		notifyMe('Your requset '+ data.requestAction +' by '+ data.from, '');
		getUsers();
	} else if(data.clearStorage !== undefined) {
		localStorage.removeItem("userChatWindow");
	}
}

function wsClose(message){
//	console.log('Info: Chat socket is closed.');
}

function wsError(message){
	console.log('Error ',message)
}

function resizeUrlInputText(message) {
    urlInputText.size=message.length;
}

function debug(message) {
    debugTextArea.value += message + "\n\n";
    debugTextArea.scrollTop = debugTextArea.scrollHeight;
}

function stopWebSocket() {
    if (websocket) {
        websocket.close();
    }
}

function checkSocket() {
	if (websocket != null) {
		var stateStr;
		switch (websocket.readyState) {
			case 0: {
				break;
			}
			case 1: {
	            break;
	        }
	        case 2: {
	            break;
	        }
	        case 3: {
	            break;
	        }
	        default: {
	            break;
	        }
	    }
		console.log("WebSocket state = " + websocket.readyState + " ( " + stateStr + " )");
	} else {
		console.log("WebSocket is null");
    }
}

/*function sendMessage() {
    var msg = document.getElementById("inputText").value;
    if ( websocket != null ) {
        document.getElementById("inputText").value = "";
        websocket.send(msg);
        debug("Message sent: " + msg);
        console.log( "string sent :", '"'+msg+'"' );
    }
    else {
        debug("Can't sent message, the connection is not open");
    }
}*/