package it.eng.rd.idp.registration.mailer;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.content.ContentUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.time.YearMonth;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class Mailer {

	public void sentMail(String mailSubject, String from, String projectName, String logoLiferayPortalUrl, String liferayPortalName, String liferayPortalUrl, String to, String password, String idmUrl, boolean adminNotification, boolean idmEnabled) throws AddressException {
		MailMessage mailMessage = new MailMessage();
		int year = YearMonth.now().getYear();
		String copyrightYear = String.valueOf(year);
		
		String body = StringPool.BLANK;
		
		if (!idmEnabled) {
			if (adminNotification) {
				body = ContentUtil.get(this.getClass().getClassLoader(), "/content/notification020220221939.tmpl", true);
				body = StringUtil.replace(body, new String[] { "[$PROJECT_NAME$]", "[$LOGO_LIFERAY_PORTAL_URL$]", "[$LIFERAY_PORTAL_NAME$]", "[$LIFERAY_PORTAL_URL$]", "[$COPYRIGHT_YEAR$]", "[$EMAIL$]", "[$PASSWORD$]", "[$IDM$]" }, 
						                                new String[] {projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, copyrightYear, to, password, idmUrl});
			} else {
				body = ContentUtil.get(this.getClass().getClassLoader(), "/content/registration020220221939.tmpl", true);
				body = StringUtil.replace(body, new String[] { "[$PROJECT_NAME$]", "[$LOGO_LIFERAY_PORTAL_URL$]", "[$LIFERAY_PORTAL_NAME$]", "[$LIFERAY_PORTAL_URL$]", "[$COPYRIGHT_YEAR$]", "[$EMAIL$]", "[$PASSWORD$]", "[$IDM$]" }, 
						                                new String[] {projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, copyrightYear, to, password, idmUrl});
			}
		} else {
			body = ContentUtil.get(this.getClass().getClassLoader(), "/content/registration2110051730.tmpl", true);
			body = StringUtil.replace(body, new String[] { "[$PROJECT_NAME$]", "[$LOGO_LIFERAY_PORTAL_URL$]", "[$LIFERAY_PORTAL_NAME$]", "[$LIFERAY_PORTAL_URL$]", "[$COPYRIGHT_YEAR$]", "[$EMAIL$]", "[$PASSWORD$]", "[$IDM$]" }, 
					                                new String[] {projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, copyrightYear, to, password, idmUrl});
		}
		
		
		
		
		if (_log.isDebugEnabled())
			_log.debug("body: "+body);
		
		mailMessage = new MailMessage();
		mailMessage.setFrom(new InternetAddress(from));
		mailMessage.setTo(new InternetAddress(to));
		mailMessage.setSubject(mailSubject);
		mailMessage.setHTMLFormat(true);
		mailMessage.setBody(body);
		try {
		  MailServiceUtil.sendEmail(mailMessage);
		  if (_log.isDebugEnabled())
			  _log.debug("e-mail sended");
		} catch(Exception e) {
			_log.error(e,e);
		}
	}
	
	
	private static final Log _log = LogFactoryUtil.getLog(
			Mailer.class);
} 