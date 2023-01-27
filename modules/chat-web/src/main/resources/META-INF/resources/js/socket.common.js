function getSocketEndPoint(endPointPath) {
	console.log('_getSocketEndPoint');
	var hostName = window.location.host;
	console.log('hostName ', hostName);
	hostName += endPointPath;
	var protocol = window.location.protocol;
	console.log('protocol ', protocol);
	var socketURL="ws://";
	if(protocol === 'http:'){
		socketURL = "ws://";
	} else {
		socketURL = "wss://";
	}
	console.log('socketURL ', socketURL);
	socketURL += hostName;
	return socketURL;
}