var arr = [];
var userChatWindow = new Map();
var onlineUsers = [];
var selectedTab;

var loggedUserId=-1;

function isChatPossible(toUserId){
//	console.log("chatIsAbailable: "+toUserId);
	if(loggedUserId<0){
		// Check if current user is logged in
		if(Liferay.ThemeDisplay.isSignedIn()){ // Check to verify the user is logged in
		    loggedUserId = Liferay.ThemeDisplay.getUserId();
		    // ...
		    
		}
		else {
		    console.log('Current user is not logged.');
		    return false;
		}
	}
	console.log('Logged user id is ' + loggedUserId + '.');
    if(parseInt(loggedUserId)!=parseInt(toUserId)){
//    	console.log("Chat is available from different users");
    	return true;
    }else{
//    	console.log("Chat is not possible to himself!");
    	return false;
    }

}

function addUserClick(obj){
	var userId = $(obj).attr('id');
//	console.log('addUserClick userId: ', userId);
	if(!isChatPossible(userId)){
		console.log("I won't send a chat request!");
		return false;
	}
	sendChatRequest(userId.split("_")[1]);
}

function userClose(objClose) {
//	console.log('userClose');
	var chatbox = $(objClose).parents().parents().parents().attr("rel") ;
	$('[rel="'+chatbox+'"]').remove();
	arr.splice($.inArray(chatbox, arr), 1);
	displayChatBox();
	userChatWindow.delete(chatbox);
	var obj = map_to_object(userChatWindow);
	localStorage.setItem("userChatWindow", JSON.stringify(obj));
}

function curUserClick(obj) {
	var userId = $(obj).attr("id");
//	console.log('curUserClick userId: ', userId);
	if(!isChatPossible(userId)){
		console.log("I won't show chat frame!");
		return false;
	}
	var username = $(obj).text();
	var requestFeature = $(obj).attr("requestFeature");
	var isAccepted = $(obj).attr("isaccepted");
	var isRejected = $(obj).attr("isrejected");
	var toUserId = $(obj).attr("touserid");
	var userProfile = $(obj).siblings()[0].src;
	if(isAccepted == 'true' || requestFeature == 'false') {
		createUserChatBox(username, userId);
	} else {
		createUserRequestChatBox(username, userId, toUserId, isRejected, userProfile);
	}
}

function msgHeadClick(obj){
//	console.log('msgHeadClick');
	var chatbox = $(obj).parents().attr("rel") ;
	var isUserChatWindowOpen = $('[rel="'+ chatbox +'"] .msg_wrap').css("display") == 'block' ? true : false;
	if(isUserChatWindowOpen) {
		$('[rel="'+ chatbox +'"] .uc-window .fa-window-minimize').removeClass("fa-window-minimize").addClass("fa-window-maximize");
	} else {
		$('[rel="'+ chatbox +'"] .uc-window .fa-window-maximize').removeClass("fa-window-maximize").addClass("fa-window-minimize");
	}
	$('[rel="'+chatbox+'"] .msg_wrap').slideToggle('slow');
}

function chatHeadClick(obj) {
//	console.log('chatHeadClick');
	var isChatWindowOpen = $(".chat_box .chat_wrap").css("display") == 'block' ? true : false;
	if(isChatWindowOpen){
		$(".chat_head .main-win .fa-window-minimize").removeClass("fa-window-minimize").addClass("fa-window-maximize");
	} else {
		$(".chat_head .main-win .fa-window-maximize").removeClass("fa-window-maximize").addClass("fa-window-minimize");
	}
	$('.chat_wrap').slideToggle('slow', function(){});
}

function updateOnlineUser(onlineUser){
//	console.log('updateOnlineUser');
	onlineUsers = onlineUser;
}

function setOnlineUser() {
//	console.log('setOnlineUser');
	onlineUsers.forEach(function(item, index){
		$("#"+item+'_on').append("<span class='online-user'></span>");
	});
}

function isEmptyString(str) {
//	console.log('isEmptyString');
    return (!str || 0 === str.length);
}

function userSearchFilter() {
//	console.log('userSearchFilter');
	var input, filter, ul, li, a, i;
	var requestFeature = $('#request-feature-m').val();
	input = document.getElementById('searchUser');
	filter = input.value.toUpperCase();
	if(requestFeature == 'true') {
		if(selectedTab === undefined || selectedTab === 'Chats') {
			ul = document.getElementById("chatUserList");
		} else {
			ul = document.getElementById("userList");
		}
	} else {
		ul = document.getElementById("allUserList");
	}
	
	
	li = ul.getElementsByTagName('li');
    // Loop through all list items, and hide those who don't match the search query
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("span")[0];
        if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function createUserChatBox(username, userId) {
//	console.log('createUserChatBox');
	if(!isChatPossible(userId)){
		console.log("I won't create user chat box!");
		return false;
	}
	userChatWindow.set(userId, username);
	var headerColor = $('#header-color-m').val();
	var headerTextColor = $('#header-text-color-m').val();
	var backColor = $('#back-color-m').val();
	var fontFamily = $('#font-family-m').val();
	var isInchat = false;
	if ($.inArray(userId, arr) != -1) {
		 arr.splice($.inArray(userId, arr), 1);
		 isInchat = true;
	} else {
		 isInchat = false;
	}
	 arr.unshift(userId);
	 chatPopup =  '<div class="msg_box" style="right:300px; display:table-column-group !important;" rel="'+ userId+'">'+
					'<div class="msg_head" onclick="msgHeadClick(this)" style="background-color:'+headerColor+'!important; color:'+headerTextColor+'!important;">' +
					'<div class="uc-window"><span class="fa fa-window-minimize"></span><span id="uc-close" onclick="userClose(this)" class="fa fa-window-close"></span> </div> <div>'+
					'<div><img src="'+userProfiles[userId]+'" style="float:left" class="user-chat-box-profile"></div><div class="header_name" title="'+username+'">'+username + '</div></div> <div class="msg_writing" style="color:'+headerTextColor+'"></div></div>'+
					'<div class="msg_wrap"><input type="hidden" id="totalRecords_'+userId+'" value=""/><input type="hidden" id="count_'+userId+'" value=""/> <div class="msg_body" style="background-color:'+backColor+';"><div class="msg_push"></div> </div>'+
					'<div class="msg_footer"><textarea class="msg_input" rows="2" id="messageArea" maxlength="75" onkeydown="multilineChat(event, this, '+userId+')"></textarea>'+
					'<input type="text" id="fileText" disabled="true" class="file-text">'+
					'<span class="fa fa-times" title="Clear" onclick="clearChatArea('+userId+')"></span>'+
					'<span class="fa fa-trash-o" title="Delete all chats" onclick="deleteAllChatMsg('+userId+')"></span>'+
					'<label><span title="Add attachment" class="fa fa-paperclip"><input id="attachment" type="file" accept=".pdf,.doc,.docx,.xlsx,.xls,.txt,image/*" style="display: none;"></span></label>' +
					'<span id="sendMsg" onclick="sendMsg(this)" class="fa fa-paper-plane" title="Send message"></span></div>' +
					'</div></div>';
	
	 if(isInchat){
		 var isUserChatWindowOpen = $('[rel="'+ userId +'"] .msg_wrap').css("display") == 'block' ? true : false;
		 if(!isUserChatWindowOpen){
			 $('[rel="'+userId+'"] .msg_wrap').slideToggle('slow');
		 }
		 $('[rel="' + userId + '"] .msg_body').scrollTop($('[rel="' + userId + '"] .msg_body')[0].scrollHeight);
	 } else {
		 $("body").append(chatPopup);
		 getUserChatHistory(userId, 6, false);
	 }
	 displayChatBox();
	 scrollChat(userId);
	 removeUnreadCount(userId);
	 var obj = map_to_object(userChatWindow);
	 localStorage.setItem("userChatWindow", JSON.stringify(obj));
	 $('[rel="'+ userId +'"] .uc-window .fa-window-maximize').removeClass("fa-window-maximize").addClass("fa-window-minimize");
}

function displayChatBox(){ 
//	console.log('displayChatBox');
    i = 300 ; // start position
	j = 305;  //next position
	$.each( arr, function( index, value ) {  
	   if(index < 4){
         $('[rel="'+value+'"]').css("right",i);
		 $('[rel="'+value+'"]').show();
	     i = i+j;			 
	   }
	   else{
		 $('[rel="'+value+'"]').hide();
		 //stopSpinner(value);
	   }
    });		
}

function sendMsg(obj) {
	console.log('sendMsg');
	var userId = $(obj).parents().parents().parents().attr("rel");
	if(!isChatPossible(userId)){
		console.log("I won't send the message!");
		return false;
	}
	sendMessage(userId);
}

$(document).on('change', '#attachment', function(){
//	console.log('onchange_attachment');
	var fileName = $(this).prop('files')[0].name;
	var userId = $(this).parents().parents().parents();
	$('[rel="'+userId[2].getAttribute('rel')+'"] #fileText')[0].setAttribute('title', fileName);
	$('[rel="'+userId[2].getAttribute('rel')+'"] #fileText').val(fileName);
});

function multilineChat(event, object, userId) {
//	console.log('multilineChat');
	if(!isChatPossible(userId)){
		console.log("I won't go on with multiline chat!");
		return false;
	}
	typingMessage(userId);
	if (event.keyCode == 10 || event.keyCode == 13 && event.ctrlKey){
		object.value += '\n';
	} else if (event.keyCode == 13) {
		sendMessage(userId);
	}
}

function clearUserChatBody(userId){
//	console.log('clearUserChatBody');
	$('[rel="'+userId+'"] div.msg_body').empty();
	$('<div class="msg_push"></div>').appendTo('[rel="'+userId+'"] div.msg_body');
}

function clearChatArea(userId){
//	console.log('clearChatArea');
	$('[rel="'+userId+'"] #messageArea').val('');
	$('[rel="'+userId+'"] #attachment').val('');
	$('[rel="'+userId+'"] #fileText').val('');
	//stopSpinner(userId);
}

function userChatHistory(userChats,fromUserId, toUserId, isScrollTop){
//	console.log('userChatHistory');
	if(!isChatPossible(toUserId)){
		console.log("I won't send the message!");
		return false;
	}
	var test;
	var chatRightColor = $('#chat-right-color-m').val(); 
	var chatLeftColor = $('#chat-left-color-m').val();
	var rightBorderColor;
	var leftBorderColor;
	if(chatRightColor === undefined || chatRightColor === '') {rightBorderColor = '#94c2ed';} else {rightBorderColor = chatRightColor;}
	if(chatLeftColor === undefined || chatLeftColor === '') {leftBorderColor = '#86bb71';} else {leftBorderColor = chatLeftColor;}
	var contentTextColor = $('#content-text-color-m').val();
	$.each(userChats,function(index,chat){
		var date =  moment(chat.sentDate).format('MM/DD/YYYY');
		var time =  moment(chat.sentDate).format('h:mm A');
		var lastApendDate = $('[rel="'+toUserId+'"]  .chat_date h6').last().text().trim();
		var today = moment().format('MM/DD/YYYY');
		var temp = date == today ? 'Today': date;
		if(lastApendDate != date && lastApendDate != "Today"){
			$('<div class="chat_date"><h6>&nbsp;'+ temp +'&nbsp;</h6></div>').insertBefore('[rel="' + toUserId + '"] .msg_push');
		}
		if(chat.fromUser == fromUserId){
			if(!isEmptyString(chat.message) && !isEmptyString(chat.fileName)) {
				
				$('<div class="msg-right '+chat.id+'" title="'+time+'" style="background-color:'+chatRightColor+'!important; border-color:'+rightBorderColor+'; color:'+contentTextColor+';"><div class="msg-header">'
						+ '<a class="cursor-pointer" onclick="deleteChatMsg('
						+ chat.id
						+ ')"><span class="fa fa-trash float-right" style="color:'+contentTextColor+';"></span></a></div>'
						+ '<div>'+chat.message+'</div><div class="msg-with-attachment"><span class="fa fa-download" onclick="downloadAttachment('+ chat.fileId + ')"> &nbsp;'+chat.fileName+'</span></div></div>').insertBefore('[rel="' + toUserId + '"] .msg_push');
			} else {
				
				if(!isEmptyString(chat.message)) {
					$('<div class="msg-right '+chat.id+'"  title="'+time+'" style="background-color:'+chatRightColor+'!important; border-color:'+rightBorderColor+'; color:'+contentTextColor+';"><div class="msg-header">'
									+ '<a class="cursor-pointer" onclick="deleteChatMsg('
									+ chat.id
									+ ')"><span class="fa fa-trash float-right" style="color:'+contentTextColor+';"></span></a></div>'
									+ chat.message + '</div>').insertBefore('[rel="' + toUserId + '"] .msg_push');
				}
				
				if(!isEmptyString(chat.fileName)) {
					$('<div class="msg-right '+chat.id+'"  title="'+time+'" style="background-color:'+chatRightColor+'!important; border-color:'+rightBorderColor+'; color:'+contentTextColor+';"><div class="msg-header">'
							+ '<a class="cursor-pointer" onclick="deleteChatMsg('
							+ chat.id
							+ ')"><span class="fa fa-trash float-right" style="color:'+contentTextColor+';"></span></a></div>'
							+ '<span class="fa fa-download" onclick="downloadAttachment('
							+ chat.fileId +')"> &nbsp;'
							+ chat.fileName + '</span></div>').insertBefore('[rel="' + toUserId + '"] .msg_push');
				}
			}
		} else {
			if(!isEmptyString(chat.message) && !isEmptyString(chat.fileName)) {
				
				$('<div class="msg-left '+chat.id+'"  title="'+time+'" style="background-color:'+chatLeftColor+'!important; border-color:'+leftBorderColor+'; color:'+contentTextColor+';"><div class="msg-header">'
						+ '</div>'
						+ '<div>'+chat.message+'</div><div class="msg-with-attachment"><span class="fa fa-download" onclick="downloadAttachment('+ chat.fileId + ')"> &nbsp;'+chat.fileName+'</span></div></div>').insertBefore('[rel="' + toUserId + '"] .msg_push');
			} else {
				if(!isEmptyString(chat.message)) {
					$('<div class="msg-left '+chat.id+'"  title="'+time+'" style="background-color:'+chatLeftColor+'!important; border-color:'+leftBorderColor+'; color:'+contentTextColor+';"><div class="msg-header">'
									+ '</div>'
									+ chat.message + '</div>').insertBefore('[rel="' + toUserId + '"] .msg_push');
				}
				if(!isEmptyString(chat.fileName)) {
					$('<div class="msg-left '+chat.id+'"  title="'+time+'" style="background-color:'+chatLeftColor+'!important; border-color:'+leftBorderColor+'; color:'+contentTextColor+';"><div class="msg-header">'
							+ '</div>'
							+ '<span class="fa fa-download" onclick="downloadAttachment('
							+ chat.fileId + ')"> &nbsp;'
							+ chat.fileName + '</span></div>').insertBefore('[rel="' + toUserId + '"] .msg_push');
				}
			}
		}
	});
	
	var scrollObj = $('[rel="' + toUserId + '"] .msg_body').scrollTop($('[rel="' + toUserId + '"] .msg_body')[0]);
	if(isScrollTop && scrollObj != null){
		$('[rel="' + toUserId + '"] .msg_body').scrollTop($('[rel="' + toUserId + '"] .msg_body')[0].scrollWidth - 8);
	} else if(scrollObj != null) {
		$('[rel="' + toUserId + '"] .msg_body').scrollTop($('[rel="' + toUserId + '"] .msg_body')[0].scrollHeight);
	}
}

function scrollChat(userId) {
//	console.log('scrollChat');
	if(!isChatPossible(userId)){
		console.log("I won't scroll the chat!");
		return false;
	}
	$('[rel="'+userId+'"] div.msg_body').scroll(function() {
		if($(this).scrollTop() == ($(this).height() - $(this).height())) {
			var total =  $("#totalRecords_"+userId).val();
			var count =  $("#count_"+userId).val();
			if(count != 0){
				//startSpinner(userId);
				clearUserChatBody(userId);
				getUserChatHistory(userId, (Number(total) + Number(20)), true);
			}
		}
	});
}
function deleteChatMsg(chatId) {
//	console.log('deleteChatMsg');
	var isConfirm = confirm('Are you sure delete this message?');
	if(isConfirm){
		deleteMessage(chatId);
		$(".msg-right."+chatId).remove();
	}
}

function deleteAllChatMsg(userId){
//	console.log('deleteAllChatMsg');
	var isConfirm = confirm('Are you sure delete all messages?');
	if(isConfirm){
		deleteAllMessage(userId);
		$('[rel="'+userId+'"] .msg-right').remove();
	}
}

function removeUnreadCount(userId) {
//	console.log('removeUnreadCount');
	$('#'+userId).parent().children('.badge-margin-left').remove();
	chatMarkAsRead(userId);
}

function selectTab(obj){
//	console.log('selectTab');
	document.getElementById('searchUser').value = '';
	userSearchFilter();
	selectedTab = obj.innerText;
}

function createUserRequestChatBox(username, userId, toUserId, isRejected, userProfile) {
//	console.log('createUserRequestChatBox');
	// Prevents you to chat with yourself
	if(parseInt(userId)==parseInt(toUserId)){
		console.log("I won't create the user chat request!");
		return false;
	}
	
	userChatWindow.set(userId, username);
	var headerColor = $('#header-color-m').val();
	var headerTextColor = $('#header-text-color-m').val();
	var backColor = $('#back-color-m').val();
	var fontFamily = $('#font-family-m').val();
	var buttonColor;
	var buttonTextColor;
	if(headerColor === undefined || headerColor === '') { buttonColor = '#3c5b9b';} else { buttonColor = headerColor;}
	if(headerTextColor === undefined || headerTextColor === '') {buttonTextColor = '#ffffff'; } else {buttonTextColor = headerTextColor}
	var isInchat = false;
	var requestPop;
	if ($.inArray(userId, arr) != -1) {
		 arr.splice($.inArray(userId, arr), 1);
		 isInchat = true;
	} else {
		 isInchat = false;
	}
	if(toUserId == userId && isRejected=='false') {
		requestPop = '<div class="request-pop">You send request to '+ username+'</div>';
	} else if(isRejected=='false') {
		requestPop = '<div class="request-pop">'+
					'<div>'+username+' want to connect with you</div>'+
					'<div class="btn-group">'+
					'<button class="btn btn-sm" style="background-color:'+buttonColor+'; color:'+buttonTextColor+';" onClick="requestAction('+userId+', \''+String(username)+'\', true)">Accept</button>'+
					'<button class="btn btn-sm" style="background-color:'+buttonColor+'; color:'+buttonTextColor+';" onClick="requestAction('+userId+', \''+String(username)+'\', false)">Reject</button>'+
					'</div>'+
					'</div>';
	} else if(isRejected=='true') {
		requestPop = '<div class="request-pop">Your request rejected by '+ username+'</div>';
	}
	 arr.unshift(userId);
	 chatPopup =  '<div class="msg_box" id="p_r_'+userId+'" style="right:300px;display:table-column-group !important;" rel="'+ userId+'">'+
					'<div class="msg_head" onclick="msgHeadClick(this)" style="background-color:'+headerColor+'!important; color:'+headerTextColor+'!important;">' +
					'<div class="uc-window"><span class="fa fa-window-minimize"></span><span id="uc-close" onclick="userClose(this)" class="fa fa-window-close"></span> </div> <div>'+
					'<div><img src="'+userProfile+'" style="float:left" class="user-chat-box-profile"></div><div class="header_name" title="'+username+'">'+username + '</div></div> <div class="msg_writing" style="color:'+headerTextColor+'"></div></div>'+
					'<div class="msg_wrap"><input type="hidden" id="totalRecords_'+userId+'" value=""/><input type="hidden" id="count_'+userId+'" value=""/> <div class="msg_body" style="background-color:'+backColor+';">'+requestPop+'<div class="msg_push"></div> </div>'+
					'<div class="msg_footer">'+
					'</div></div>';
	
	 if(isInchat){
		 var isUserChatWindowOpen = $('[rel="'+ userId +'"] .msg_wrap').css("display") == 'block' ? true : false;
		 if(!isUserChatWindowOpen){
			 $('[rel="'+userId+'"] .msg_wrap').slideToggle('slow');
		 }
		 //$('[rel="' + userId + '"] .msg_body').scrollTop($('[rel="' + userId + '"] .msg_body')[0].scrollHeight);
	 } else {
		 //getUserChatHistory(userId, 6, false);
		 $("body").append(chatPopup);
	 }
	 
	 displayChatBox();
	 scrollChat(userId);
	 removeUnreadCount(userId);
	 //localStorage.setItem("userChatWindow", JSON.stringify(obj));
	 $('[rel="'+ userId +'"] .uc-window .fa-window-maximize').removeClass("fa-window-maximize").addClass("fa-window-minimize");
}

function requestAction(userId, username, actionStatus) {
//	console.log('requestAction');
	// It shouldn't come here, however I do the check
	if(!isChatPossible(userId)){
		console.log("I won't request the action!");
		return false;
	}
	
	arr.splice($.inArray(userId, arr), 1);
	actionChatRequest(userId, username, actionStatus);
}

function map_to_object(map) {
//	console.log('map_to_object');
    const out = Object.create(null)
    map.forEach(function(value, key) {
      if (value instanceof Map) {
        out[key] = map_to_object(value)
      }
      else {
        out[key] = value
      }
    })
   return out
}


function loaderStart(userId){
//	console.log('loaderStart');
	$('[rel="'+userId+'"] div.msg_wrap').append('<div class="modal"></div>');
	$('[rel="'+userId+'"] div.msg_wrap').addClass("loading");
}

function loaderOff(userId){
//	console.log('loaderOff');
	$('[rel="'+userId+'"] div.msg_wrap').removeClass("loading");
	$('[rel="'+userId+'"] div.msg_wrap .modal').remove()
}
