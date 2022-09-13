package it.eng.rd.idp.registration.constants;

import com.liferay.petra.string.StringPool;

/**
 * @author ENGRD
 */
public class IdpRegistrationPortletKeys {

	public static final String IDPREGISTRATION = "it_eng_rd_idp_registration_IdpRegistrationPortlet";
	
	public static final String IDM_API_USERS = "/v1/users";
	
	public static final String IDM_API_AUTH_TOKENS = "/v1/auth/tokens";
	
	public static final String PAGE_RESULT = StringPool.SLASH + "result.jsp";
	
	public static final String PAGE_VIEW = StringPool.SLASH + "view.jsp";
	
	public static final String TEMPLATE_ID = "registration.template.id";
	
	public static final String TMPL = StringPool.PERIOD + "tmpl";

	public static final String ADMIN_NOTIFICATION = "admin_notification";
	
	public static final String USER_NOTIFICATION = "user_notification";
	
	public static final String FROM_DEFAULT = "noreply@server.com";
	
	public static final String MAIL_SUBJECT_DEFAULT = "Collaboration Portal registration";
	
	public static final String NEW_ACCOUNT = "New Account";
	
	public static final String NEW_ACCOUNT_IT = "Nuovo Account";
	
	public static final String DIH = "DIH";
	
	public static final String YES = "Yes";
	
	public static final String NO = "No";
	
	public static final String ADD_CONTENT_QUESTION = "Would you like to be enabled to insert content into the portal?";
	
	public static final String ENABLED= "e";
	
	public static final String DEFAULT= "default";
	
	public static final String REPOSITORY_TEMPLATES = "/content/templates/";
	
	public static final String LANGUAGE_DEFAULT = "en";
	
	public static final String COUNTRY_DEFAULT = "US";
	
	public static final int MAX_LENGHT = 30;
	
	public static final String PATTERN = "[^a-zA-Z0-9._-]";
	
	public static final String DEFAULT_ORGANIZATIONS =  "DIH" + StringPool.NEW_LINE + "RTO"+ StringPool.NEW_LINE + "SME" + StringPool.NEW_LINE + "University"+StringPool.NEW_LINE + "Other"+ StringPool.NEW_LINE + "Industry" +StringPool.NEW_LINE+ "Large Enterprise";
	
	public static final String IDM_ADMIN_DEFAULT = "admin@test.com";
	
	public static final String ON = "on";
	
	public static final String COPYRIGHT_COMPANY_DEFAULT = "Engineering S.p.A.";
	
	public static final String COPYRIGHT_COMPANY_URL_DEFAULT = "https://www.eng.it";
}