package it.eng.rd.idp.registration.mailer;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.IOException;
import java.time.YearMonth;
import java.util.Locale;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class Mailer {
	
	private String TMPL = ".tmpl";
	

	public void sentMail(String mailSubject, String from, String projectName, String logoLiferayPortalUrl, String liferayPortalName, String liferayPortalUrl, String to, String registeredUserEmail, String password, String idmUrl, boolean adminNotification, boolean idmEnabled, String organizationType, String organization, String copyrightCompany, String copyrightCompanyUrl, String name, String surname, String question, String reply, String website) throws AddressException {
		
		String ID = StringPool.BLANK; 
//		if (Validator.isNotNull(GetterUtil.getString(PropsUtil.get("registration.template.id")) {
			ID = GetterUtil.getString(PropsUtil.get("registration.template.id"));
//		}
				
		String LIFERAY_HOME = PropsUtil.get(PropsKeys.LIFERAY_HOME);
		
		MailMessage mailMessage = new MailMessage();
		int year = YearMonth.now().getYear();
		String copyrightYear = String.valueOf(year);
		
		String body = StringPool.BLANK;
		Locale locale = LocaleUtil.getDefault();
		
		
		String IT=StringPool.BLANK;
		if (locale.getLanguage().equalsIgnoreCase("it")) {
			IT = StringPool.UNDERLINE+locale.getLanguage();
		}
//		String IT = StringPool.UNDERLINE+"it";
		String IDM_ADMIN_NOTIFICATION_TO_ENABLE_REGISTERED_USER = "notification"+ID+IT+TMPL;
		String IDM_ADMIN_NOTIFICATION_ENABLED_USER = "notification"+ID+"e"+IT+TMPL;
		String USER_NOTIFICATION_DISABLED_IDM_REGISTRATION = "registration"+ID+IT+TMPL;
		String USER_NOTIFICATION_ENABLED_REGISTRATION = "registration"+ID+"e"+IT+TMPL;
		
		
		if (_log.isDebugEnabled()) {
			_log.debug("------------------Configuration Template----------------");
			_log.debug("LIFERAY_HOME: "+LIFERAY_HOME);
			_log.debug("ID (ex. _portalName_DDMMYYYY): "+ID);
			_log.debug("default language: "+locale.getLanguage());
			
			_log.debug("template IDM_ADMIN_NOTIFICATION_TO_ENABLE_REGISTERED_USER: "+IDM_ADMIN_NOTIFICATION_TO_ENABLE_REGISTERED_USER);
			_log.debug("template USER_NOTIFICATION_DISABLED_IDM_REGISTRATION: "+USER_NOTIFICATION_DISABLED_IDM_REGISTRATION);
			_log.debug("template USER_NOTIFICATION_ENABLED_REGISTRATION: "+USER_NOTIFICATION_ENABLED_REGISTRATION);
			_log.debug("template USER_NOTIFICATION_ENABLED_REGISTRATION: "+USER_NOTIFICATION_ENABLED_REGISTRATION);
			
			_log.debug("------------------Template Info----------------");
			
			_log.debug("mailSubject: "+mailSubject);
			_log.debug("from: "+from);
			_log.debug("projectName: "+projectName);
			_log.debug("logoLiferayPortalUrl: "+logoLiferayPortalUrl);
			_log.debug("liferayPortalName: "+liferayPortalName);
			_log.debug("liferayPortalUrl: "+liferayPortalUrl);
			_log.debug("to: "+to);
			_log.debug("registeredUserEmail: "+registeredUserEmail);
			_log.debug("password: "+password);
			_log.debug("idmUrl: "+idmUrl);
			_log.debug("adminNotification: "+adminNotification);
			_log.debug("idmEnabled: "+idmEnabled);
			_log.debug("organizationType: "+organizationType);
			_log.debug("organization: "+organization);
			_log.debug("copyrightCompany: "+copyrightCompany);
			_log.debug("copyrightCompanyUrl: "+copyrightCompanyUrl);
			_log.debug("name: "+name);
			_log.debug("surname: "+surname);
			_log.debug("question: "+question);
			_log.debug("reply: "+reply);
//			_log.debug("organizationRole: "+organizationRole);
			_log.debug("website: "+website);
		}
		
		try {
			/*
			if (!idmEnabled) {
				_log.info("idmEnabled = false ");
				if (adminNotification) {
					_log.info("adminNotification = true ");
					body = FileUtil.read(new File(LIFERAY_HOME + "/data/templates/"+IDM_ADMIN_NOTIFICATION_TO_ENABLE_REGISTERED_USER));
					body = StringUtil.replace(body, new String[] { "[$PROJECT_NAME$]", "[$LOGO_LIFERAY_PORTAL_URL$]", "[$LIFERAY_PORTAL_NAME$]", "[$LIFERAY_PORTAL_URL$]", "[$COPYRIGHT_COMPANY_URL$]", "[$COPYRIGHT_COMPANY$]", "[$COPYRIGHT_YEAR$]", "[$TO$]", "[$EMAIL$]", "[$PASSWORD$]", "[$IDM$]", "[$ORGANIZATION_TYPE$]", "[$ORGANIZATION$]", "[$NAME$]", "[$SURNAME$]", "[$QUESTION$]", "[$REPLY$]", "[$WEBSITE$]"}, 
							                                new String[] {projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, copyrightCompanyUrl, copyrightCompany, copyrightYear, to, registeredUserEmail, password, idmUrl, organizationType, organization, name, surname, question, reply, website});
				} else {
					_log.info("adminNotification = false ");
					body = FileUtil.read(new File(LIFERAY_HOME + "/data/templates/"+USER_NOTIFICATION_DISABLED_IDM_REGISTRATION));
					body = StringUtil.replace(body, new String[] { "[$PROJECT_NAME$]", "[$LOGO_LIFERAY_PORTAL_URL$]", "[$LIFERAY_PORTAL_NAME$]", "[$LIFERAY_PORTAL_URL$]", "[$COPYRIGHT_COMPANY_URL$]", "[$COPYRIGHT_COMPANY$]", "[$COPYRIGHT_YEAR$]", "[$TO$]", "[$EMAIL$]", "[$PASSWORD$]", "[$IDM$]", "[$ORGANIZATION_TYPE$]", "[$ORGANIZATION$]", "[$NAME$]", "[$SURNAME$]", "[$QUESTION$]", "[$REPLY$]", "[$WEBSITE$]"}, 
							                                new String[] {projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, copyrightCompanyUrl, copyrightCompany, copyrightYear, to, registeredUserEmail, password, idmUrl, organizationType, organization, name, surname, question, reply, website});
				}
			} else {
				_log.info("idmEnabled = true ");
				body = FileUtil.read(new File(LIFERAY_HOME + "/data/templates/"+USER_NOTIFICATION_ENABLED_REGISTRATION));
				body = StringUtil.replace(body, new String[] { "[$PROJECT_NAME$]", "[$LOGO_LIFERAY_PORTAL_URL$]", "[$LIFERAY_PORTAL_NAME$]", "[$LIFERAY_PORTAL_URL$]", "[$COPYRIGHT_COMPANY_URL$]", "[$COPYRIGHT_COMPANY$]", "[$COPYRIGHT_YEAR$]", "[$TO$]", "[$EMAIL$]", "[$PASSWORD$]", "[$IDM$]", "[$ORGANIZATION_TYPE$]", "[$ORGANIZATION$]", "[$NAME$]", "[$SURNAME$]", "[$QUESTION$]", "[$REPLY$]", "[$WEBSITE$]"}, 
						                                new String[] {projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, copyrightCompanyUrl, copyrightCompany, copyrightYear, to, registeredUserEmail, password, idmUrl, organizationType, organization, name, surname, question, reply, website});
			}*/
			
			if (!idmEnabled) {
				_log.info("idmEnabled = false ");
				if (adminNotification) {
					_log.info("adminNotification = true ");
					_log.debug("template: "+IDM_ADMIN_NOTIFICATION_TO_ENABLE_REGISTERED_USER);
					body = FileUtil.read(new File(LIFERAY_HOME + "/data/templates/"+IDM_ADMIN_NOTIFICATION_TO_ENABLE_REGISTERED_USER));
					body = StringUtil.replace(body, new String[] { "[$PROJECT_NAME$]", "[$LOGO_LIFERAY_PORTAL_URL$]", "[$LIFERAY_PORTAL_NAME$]", "[$LIFERAY_PORTAL_URL$]", "[$COPYRIGHT_COMPANY_URL$]", "[$COPYRIGHT_COMPANY$]", "[$COPYRIGHT_YEAR$]", "[$TO$]", "[$EMAIL$]", "[$PASSWORD$]", "[$IDM$]", "[$ORGANIZATION_TYPE$]", "[$ORGANIZATION$]", "[$NAME$]", "[$SURNAME$]", "[$QUESTION$]", "[$REPLY$]", "[$WEBSITE$]"}, 
							                                new String[] {projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, copyrightCompanyUrl, copyrightCompany, copyrightYear, to, registeredUserEmail, password, idmUrl, organizationType, organization, name, surname, question, reply, website});
				} else {
					_log.info("adminNotification = false ");
					_log.debug("template: "+USER_NOTIFICATION_DISABLED_IDM_REGISTRATION);
					body = FileUtil.read(new File(LIFERAY_HOME + "/data/templates/"+USER_NOTIFICATION_DISABLED_IDM_REGISTRATION));
					body = StringUtil.replace(body, new String[] { "[$PROJECT_NAME$]", "[$LOGO_LIFERAY_PORTAL_URL$]", "[$LIFERAY_PORTAL_NAME$]", "[$LIFERAY_PORTAL_URL$]", "[$COPYRIGHT_COMPANY_URL$]", "[$COPYRIGHT_COMPANY$]", "[$COPYRIGHT_YEAR$]", "[$TO$]", "[$EMAIL$]", "[$PASSWORD$]", "[$IDM$]", "[$ORGANIZATION_TYPE$]", "[$ORGANIZATION$]", "[$NAME$]", "[$SURNAME$]", "[$QUESTION$]", "[$REPLY$]", "[$WEBSITE$]"}, 
							                                new String[] {projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, copyrightCompanyUrl, copyrightCompany, copyrightYear, to, registeredUserEmail, password, idmUrl, organizationType, organization, name, surname, question, reply, website});
				}
			} else {
				_log.info("idmEnabled = true ");
				if (adminNotification) {
					_log.info("adminNotification = true ");
					_log.debug("template: "+IDM_ADMIN_NOTIFICATION_ENABLED_USER);
					body = FileUtil.read(new File(LIFERAY_HOME + "/data/templates/"+IDM_ADMIN_NOTIFICATION_ENABLED_USER));
					body = StringUtil.replace(body, new String[] { "[$PROJECT_NAME$]", "[$LOGO_LIFERAY_PORTAL_URL$]", "[$LIFERAY_PORTAL_NAME$]", "[$LIFERAY_PORTAL_URL$]", "[$COPYRIGHT_COMPANY_URL$]", "[$COPYRIGHT_COMPANY$]", "[$COPYRIGHT_YEAR$]", "[$TO$]", "[$EMAIL$]", "[$PASSWORD$]", "[$IDM$]", "[$ORGANIZATION_TYPE$]", "[$ORGANIZATION$]", "[$NAME$]", "[$SURNAME$]", "[$QUESTION$]", "[$REPLY$]", "[$WEBSITE$]"}, 
                            new String[] {projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, copyrightCompanyUrl, copyrightCompany, copyrightYear, to, registeredUserEmail, password, idmUrl, organizationType, organization, name, surname, question, reply, website});
				} else {
					_log.info("adminNotification = false ");
					_log.debug("template: "+USER_NOTIFICATION_ENABLED_REGISTRATION);
					body = FileUtil.read(new File(LIFERAY_HOME + "/data/templates/"+USER_NOTIFICATION_ENABLED_REGISTRATION));
					body = StringUtil.replace(body, new String[] { "[$PROJECT_NAME$]", "[$LOGO_LIFERAY_PORTAL_URL$]", "[$LIFERAY_PORTAL_NAME$]", "[$LIFERAY_PORTAL_URL$]", "[$COPYRIGHT_COMPANY_URL$]", "[$COPYRIGHT_COMPANY$]", "[$COPYRIGHT_YEAR$]", "[$TO$]", "[$EMAIL$]", "[$PASSWORD$]", "[$IDM$]", "[$ORGANIZATION_TYPE$]", "[$ORGANIZATION$]", "[$NAME$]", "[$SURNAME$]", "[$QUESTION$]", "[$REPLY$]", "[$WEBSITE$]"}, 
							                                new String[] {projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, copyrightCompanyUrl, copyrightCompany, copyrightYear, to, registeredUserEmail, password, idmUrl, organizationType, organization, name, surname, question, reply, website});
				}
			}
			
			
			mailMessage = new MailMessage();
			mailMessage.setFrom(new InternetAddress(from));
			mailMessage.setTo(new InternetAddress(to));
			mailMessage.setSubject(mailSubject);
			mailMessage.setHTMLFormat(true);
			mailMessage.setBody(body);
			try {
			  MailServiceUtil.sendEmail(mailMessage);
			  if (_log.isDebugEnabled()) {
				  _log.debug("-----------------------------------e-mail body sended-----------------------------------");
				  if (Validator.isNotNull(mailMessage)) {
					  _log.debug(mailMessage.getBody());
				  }
			  }
				  	
			} catch(Exception e) {
				_log.error(e,e);
			}
		} catch (IOException e1) {
			_log.error("An error occurred while reading template: " + e1.getMessage());
			_log.error(e1,e1);
		}
	}
		
	
	
	private static final Log _log = LogFactoryUtil.getLog(
			Mailer.class);
} 