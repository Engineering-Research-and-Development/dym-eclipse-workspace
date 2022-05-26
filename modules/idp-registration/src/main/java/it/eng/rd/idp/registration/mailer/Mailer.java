package it.eng.rd.idp.registration.mailer;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.content.ContentUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.time.YearMonth;
import java.util.Locale;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class Mailer {
	
//	private String IT = "it";
	
	private String ID = "180320221200";
	
	private String TMPL = ".tmpl";
	

	public void sentMail(String mailSubject, String from, String projectName, String logoLiferayPortalUrl, String liferayPortalName, String liferayPortalUrl, String to, String registeredUserEmail, String password, String idmUrl, boolean adminNotification, boolean idmEnabled, String organizationType, String organization, String copyrightCompany, String copyrightCompanyUrl) throws AddressException {
		MailMessage mailMessage = new MailMessage();
		int year = YearMonth.now().getYear();
		String copyrightYear = String.valueOf(year);
		
		String body = StringPool.BLANK;
		Locale locale = LocaleUtil.getDefault();
		
//		_log.info("default language "+locale.getLanguage());
//		String IT=StringPool.BLANK;
//		if (locale.getLanguage().equalsIgnoreCase("it")) {
//			IT = StringPool.UNDERLINE+locale.getLanguage();
//		}
		String IT = StringPool.UNDERLINE+"it";
		String IDM_ADMIN_NOTIFICATION_TO_ENABLE_REGISTERED_USER = "/content/notification"+ID+IT+TMPL;
		String USER_NOTIFICATION_DISABLED_IDM_REGISTRATION = "/content/registration"+ID+IT+TMPL;
		String USER_NOTIFICATION_ENABLED_REGISTRATION = "/content/registration"+ID+"e"+IT+TMPL;
		
		if (!idmEnabled) {
			if (adminNotification) {
				if (_log.isDebugEnabled())
					_log.debug("template IDM_ADMIN_NOTIFICATION_TO_ENABLE_REGISTERED_USER "+IDM_ADMIN_NOTIFICATION_TO_ENABLE_REGISTERED_USER);
				body = ContentUtil.get(this.getClass().getClassLoader(), IDM_ADMIN_NOTIFICATION_TO_ENABLE_REGISTERED_USER, true);
				body = StringUtil.replace(body, new String[] { "[$PROJECT_NAME$]", "[$LOGO_LIFERAY_PORTAL_URL$]", "[$LIFERAY_PORTAL_NAME$]", "[$LIFERAY_PORTAL_URL$]", "[$COPYRIGHT_COMPANY_URL$]", "[$COPYRIGHT_COMPANY$]", "[$COPYRIGHT_YEAR$]", "[$TO$]", "[$EMAIL$]", "[$PASSWORD$]", "[$IDM$]", "[$ORGANIZATION_TYPE$]", "[$ORGANIZATION$]"}, 
						                                new String[] {projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, copyrightCompanyUrl, copyrightCompany, copyrightYear, to, registeredUserEmail, password, idmUrl, organizationType, organization});
			} else {
				if (_log.isDebugEnabled())
					_log.debug("template USER_NOTIFICATION_DISABLED_IDM_REGISTRATION "+USER_NOTIFICATION_DISABLED_IDM_REGISTRATION);
				body = ContentUtil.get(this.getClass().getClassLoader(), USER_NOTIFICATION_DISABLED_IDM_REGISTRATION, true);
				body = StringUtil.replace(body, new String[] { "[$PROJECT_NAME$]", "[$LOGO_LIFERAY_PORTAL_URL$]", "[$LIFERAY_PORTAL_NAME$]", "[$LIFERAY_PORTAL_URL$]", "[$COPYRIGHT_COMPANY_URL$]", "[$COPYRIGHT_COMPANY$]", "[$COPYRIGHT_YEAR$]", "[$TO$]", "[$EMAIL$]", "[$PASSWORD$]", "[$IDM$]", "[$ORGANIZATION_TYPE$]", "[$ORGANIZATION$]"}, 
						                                new String[] {projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, copyrightCompanyUrl, copyrightCompany, copyrightYear, to, registeredUserEmail, password, idmUrl, organizationType, organization});
			}
		} else {
			if (_log.isDebugEnabled())
				_log.debug("template USER_NOTIFICATION_ENABLED_REGISTRATION "+USER_NOTIFICATION_ENABLED_REGISTRATION);
			body = ContentUtil.get(this.getClass().getClassLoader(), USER_NOTIFICATION_ENABLED_REGISTRATION, true);
			body = StringUtil.replace(body, new String[] { "[$PROJECT_NAME$]", "[$LOGO_LIFERAY_PORTAL_URL$]", "[$LIFERAY_PORTAL_NAME$]", "[$LIFERAY_PORTAL_URL$]", "[$COPYRIGHT_COMPANY_URL$]", "[$COPYRIGHT_COMPANY$]", "[$COPYRIGHT_YEAR$]", "[$TO$]", "[$EMAIL$]", "[$PASSWORD$]", "[$IDM$]", "[$ORGANIZATION_TYPE$]", "[$ORGANIZATION$]"}, 
					                                new String[] {projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, copyrightCompanyUrl, copyrightCompany, copyrightYear, to, registeredUserEmail, password, idmUrl, organizationType, organization});
		}
		
		mailMessage = new MailMessage();
		mailMessage.setFrom(new InternetAddress(from));
		mailMessage.setTo(new InternetAddress(to));
		mailMessage.setSubject(mailSubject);
		mailMessage.setHTMLFormat(true);
		mailMessage.setBody(body);
		try {
		  MailServiceUtil.sendEmail(mailMessage);
		  if (_log.isDebugEnabled())
			  _log.debug("e-mail body sended "+mailMessage.getBody());
		} catch(Exception e) {
			_log.error(e,e);
		}
	}
	
	
	private static final Log _log = LogFactoryUtil.getLog(
			Mailer.class);
} 