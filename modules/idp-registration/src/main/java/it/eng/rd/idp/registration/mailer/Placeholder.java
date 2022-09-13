package it.eng.rd.idp.registration.mailer;

public enum Placeholder {

	PROJECT_NAME("[$PROJECT_NAME$]"), LOGO("[$LOGO_LIFERAY_PORTAL_URL$]"), PORTAL_NAME("[$LIFERAY_PORTAL_NAME$]"),
	PORTAL_URL("[$LIFERAY_PORTAL_URL$]"), COPYRIGHT_COMPANY_URL("[$COPYRIGHT_COMPANY_URL$]"),
	COPYRIGHT_COMPANY("[$COPYRIGHT_COMPANY$]"), COPYRIGHT_YEAR("[$COPYRIGHT_YEAR$]"), RECIPIENT("[$TO$]"),
	REGISTERED_USER_EMAIL("[$EMAIL$]"), PASSWORD("[$PASSWORD$]"), IDM_URL("[$IDM$]"),
	ORGANIZATION_TYPE("[$ORGANIZATION_TYPE$]"), ORGANIZATION_NAME("[$ORGANIZATION$]"), REGISTERED_USER_NAME("[$NAME$]"),
	REGISTERED_USER_SURNAME("[$SURNAME$]"), QUESTION("[$QUESTION$]"), REPLY("[$REPLY$]"),
	ORGANIZATION_WEBSITE("[$WEBSITE$]");

	private String placeholderName;

	private Placeholder(String name) throws IllegalArgumentException {
		if (name == null)
			throw new IllegalArgumentException("Name not accepted.");
		this.placeholderName = name;
	}

	public String getValue() {
        return this.placeholderName;
    }
}