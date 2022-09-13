function isChecked(id) {
    var checked = jQuery('#' + id).is(":checked");
    console.log('terms-of-use:', checked);
    if (checked) {
        return true;
    } else {
        return false;
    }
}
   
function isValidURL(id) {
	var value = jQuery('#'+id).val();
	var result = value.match(/(http(s)?:\/\/.)?(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)/g);
	console.log('isValidURL ',result);
	if(result == null)
	     return false;
	else
		return true;
};
   
function matchRegex(val, pattern) {
	if (pattern.test(val)) {
		return true;
	}
	return false;
}
    
function isNull(id){
	if (jQuery('#'+id).val().length === 0) {
		return true
	}
	return false
}
    
function isOver30(id){
	if (jQuery('#'+id).val().length > 30) {
		return true
	}
	return false
}
    
function resetContainer(){
// 		jQuery("#questionAddContentContainer").removeClass("active")
	jQuery('#errorMessage').css('display','none');
	jQuery('#serverError').css('display','none');

	jQuery("#questionAddContentContainer").toggle();
    jQuery("#questionAddContentContainer").removeClass("active")
	window.scrollTo({ top: 0, behavior: 'smooth' });
	return true;
}