package it.eng.rd.idp.registration.model;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;

import it.eng.rd.idp.registration.constants.IdpRegistrationPortletKeys;

public class RegistrationInfo {
	private String name;
	private String surname;
	private String email;
	private String password1;
	private String password2; 
	private String organizationType;
	private String organizationName;
	private String organizationWebSite;
	private String termsOfUse;
	private String grantToAddContent;
	private String question;
	
	private boolean termsOfUseEnabled;
	private boolean addContentEnabled;
	private String username;
	private String reply;
	
	private static final Log _log = LogFactoryUtil.getLog(RegistrationInfo.class);
	
	public RegistrationInfo() {
		this.name = "";
		this.surname = "";
		this.email = "";
		this.password1 = "";
		this.password2 = ""; 
		this.organizationType = "";
		this.organizationName = "";
		this.organizationWebSite = "";
		this.termsOfUse = "";
		this.grantToAddContent = "";
		this.question = "";
		
		this.termsOfUseEnabled = false;
		this.addContentEnabled = false;
		this.username = "";
		this.reply = "";
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = StringUtil.trim(name);
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = StringUtil.trim(surname);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = StringUtil.trim(email);
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = StringUtil.trim(password1);
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = StringUtil.trim(password2);
	}
	public String getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(String organizationType) {
		this.organizationType = StringUtil.trim(organizationType);
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = StringUtil.trim(organizationName);
	}
	public String getOrganizationWebSite() {
		return organizationWebSite;
	}
	public void setOrganizationWebSite(String organizationWebSite) {
		this.organizationWebSite = StringUtil.trim(organizationWebSite);
	}
	public String getTermsOfUse() {
		return termsOfUse;
	}
	public void setTermsOfUse(String termsOfUse) {
		this.termsOfUse = termsOfUse;
	}
	public String getGrantToAddContent() {
		return grantToAddContent;
	}
	public void setGrantToAddContent(String grantToAddContent) {
		this.grantToAddContent = grantToAddContent;
	}
	public boolean isAddContentEnabled() {
		if (this.grantToAddContent!=null) {
			if (this.grantToAddContent.equalsIgnoreCase(IdpRegistrationPortletKeys.ON)) {
				return true;
			}
			return false;
		}
		return false;
	}
	public boolean isTermsOfUseEnabled() {
		if (this.termsOfUse!=null) {
			if (this.termsOfUse.equalsIgnoreCase(IdpRegistrationPortletKeys.ON)) {
				return true;
			}
			return false;
		}
		return false;
	}
	public String getUsername() {
		String dName = this.name.replaceAll("\\s+", "").toLowerCase();
		String dSurname = this.surname.replaceAll("\\s+", "").toLowerCase();
		int usernameMaxLength = IdpRegistrationPortletKeys.MAX_LENGHT;
		if ((dName.length() + dSurname.length()) > usernameMaxLength) {
			return (dName.substring(0, getMaxLength(dName)) + StringPool.PERIOD + dSurname.substring(0, getMaxLength(dSurname)));
		}
		return (dName + StringPool.PERIOD + dSurname);
	}
	private int getMaxLength(String field) {
		int maxLength = IdpRegistrationPortletKeys.MAX_LENGHT / 2;
		if (field!=null) {
			maxLength = field.length();
			if (field.length() < maxLength) {
				maxLength = field.length();
			}
			return maxLength;
		}
		return 0;
	}
	public String getQuestion() {
		if (this.organizationType!=null) {
			if (this.organizationType.equalsIgnoreCase(IdpRegistrationPortletKeys.DIH)) {
				return IdpRegistrationPortletKeys.ADD_CONTENT_QUESTION;
			}
		}
		return "";
	}
	public String getReply() {
		if (this.organizationType!=null) {
			if (this.organizationType.equalsIgnoreCase(IdpRegistrationPortletKeys.DIH)) {
				if (isAddContentEnabled()) {
					return IdpRegistrationPortletKeys.YES + StringPool.PERIOD;
				} else {
					return IdpRegistrationPortletKeys.NO + StringPool.PERIOD;
				}
			}	
		}
		return "";
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	@Override
    public String toString() {
		String registrationInfo = "[name: " + this.name + "\n" +
		", surname: " + this.surname + "\n" +
		", email: " + this.email + "\n" +
		", password1: ****" + "\n" +
		", password2: ****" + "\n" +
		", organizationType: " + this.organizationType + "\n" +
		", organizationName: " + this.organizationName + "\n" +
		", organizationWebSite: " + this.organizationWebSite + "\n" +
		", termsOfUse: " + (this.termsOfUse!=null?this.termsOfUse:"---") + "\n" +
		", grantToAddContent: " + (this.grantToAddContent!=null?this.grantToAddContent:"---")  + "\n" +
		", question: " + this.question + "\n" +
		", termsOfUseEnabled: " + isTermsOfUseEnabled() + "\n" +
		", addContentEnabled: " + isAddContentEnabled() + "\n" +
		", username: " + getUsername() + "\n" +
		", reply: " + getReply() +"]";
				
        return registrationInfo;
    }
}
