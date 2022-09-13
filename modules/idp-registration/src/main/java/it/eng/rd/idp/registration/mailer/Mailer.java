package it.eng.rd.idp.registration.mailer;

import com.liferay.petra.content.ContentUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.NoSuchGroupException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import it.eng.rd.idp.registration.constants.IdpRegistrationPortletKeys;


public class Mailer {
	
	public void sentMail(String mailSubject, String from, String to, boolean adminNotification, boolean idmEnabled, String templateID, String[] placeholders, String[] values) {
		try {
			MailMessage mailMessage = new MailMessage();
			
			String body = getBodyMail(idmEnabled, adminNotification, templateID, placeholders, values);
			
			mailMessage = new MailMessage();
			mailMessage.setFrom(new InternetAddress(from));
			mailMessage.setTo(new InternetAddress(to));
			mailMessage.setSubject(mailSubject);
			mailMessage.setHTMLFormat(true);
			mailMessage.setBody(body);
		
			MailServiceUtil.sendEmail(mailMessage);
		} catch(AddressException e1) {
			_log.error("An error occurred in sendMail method, check <from> and <to> fields: "+e1.getMessage());
		} catch(Exception e) {
			_log.error("An error occurred in sendMail method: "+e.getMessage());
			_log.error(e,e);
		}
	}
	
	private String[] getTemplateNames(boolean idmEnabled, boolean adminNotification, String templateID) {
		Locale locale = LocaleUtil.getDefault();
		
		String LANG_SUFFIX=StringPool.BLANK;
		if (locale!=null && !locale.getLanguage().equalsIgnoreCase(IdpRegistrationPortletKeys.LANGUAGE_DEFAULT) && !locale.getCountry().equalsIgnoreCase(IdpRegistrationPortletKeys.COUNTRY_DEFAULT)) {
			LANG_SUFFIX = StringPool.UNDERLINE+locale.getLanguage()+StringPool.UNDERLINE+locale.getCountry();
		}
		
		String ID = StringPool.BLANK;
		if (Validator.isNotNull(templateID)) {
			ID = StringPool.UNDERLINE + templateID;
		}
		
		//if "Enable self-registering users on Identity Manager" is checked
		String ADMIN_NOTIFICATION = IdpRegistrationPortletKeys.ADMIN_NOTIFICATION+LANG_SUFFIX + ID+IdpRegistrationPortletKeys.TMPL;
		String USER_NOTIFICATION = IdpRegistrationPortletKeys.USER_NOTIFICATION+LANG_SUFFIX + ID+IdpRegistrationPortletKeys.TMPL;
		
		String ADMIN_NOTIFICATION_DEFAULT = IdpRegistrationPortletKeys.ADMIN_NOTIFICATION + StringPool.UNDERLINE + IdpRegistrationPortletKeys.DEFAULT + IdpRegistrationPortletKeys.TMPL;
		String USER_NOTIFICATION_DEFAULT = IdpRegistrationPortletKeys.USER_NOTIFICATION + StringPool.UNDERLINE + IdpRegistrationPortletKeys.DEFAULT + IdpRegistrationPortletKeys.TMPL;
		String E_ADMIN_NOTIFICATION_DEFAULT = IdpRegistrationPortletKeys.ENABLED + StringPool.UNDERLINE + ADMIN_NOTIFICATION_DEFAULT;
		String E_USER_NOTIFICATION_DEFAULT = IdpRegistrationPortletKeys.ENABLED + StringPool.UNDERLINE + USER_NOTIFICATION_DEFAULT;
		
		String name = StringPool.BLANK;
		String defaultTemplateName = StringPool.BLANK;
        if (idmEnabled && adminNotification) {
        	name = IdpRegistrationPortletKeys.ENABLED + StringPool.UNDERLINE + ADMIN_NOTIFICATION;
        	defaultTemplateName = E_ADMIN_NOTIFICATION_DEFAULT;
        }
        if (idmEnabled && !adminNotification) {
        	name = IdpRegistrationPortletKeys.ENABLED + StringPool.UNDERLINE + USER_NOTIFICATION;
        	defaultTemplateName = E_USER_NOTIFICATION_DEFAULT;
        }
        if (!idmEnabled && adminNotification) {
        	_log.info("idmEnabled: false, adminNotification: true");
        	name = ADMIN_NOTIFICATION;
        	defaultTemplateName = ADMIN_NOTIFICATION_DEFAULT;
        }
        if (!idmEnabled && !adminNotification) {
        	_log.info("idmEnabled: false, adminNotification: false");
        	name = USER_NOTIFICATION;
        	defaultTemplateName = USER_NOTIFICATION_DEFAULT;
        }
        if (_log.isDebugEnabled()) {
        	_log.debug("default language: "+locale.getLanguage());
        	_log.debug("default country: "+locale.getCountry());
        	_log.debug("idmEnabled: "+idmEnabled+", adminNotification: "+adminNotification);
        	_log.debug("templateName: "+name);
        	_log.debug("defaultTemplateName: "+defaultTemplateName);
        }
       
        return new String[]{name, defaultTemplateName};
	}
	
	private String getBodyMail(boolean idmEnabled, boolean adminNotification, String templateID, String[] placeholders, String[] values) {
		String body = StringPool.BLANK;
		String[] templateNames = getTemplateNames(idmEnabled, adminNotification, templateID);
		String templateName = templateNames[0];
		String defaultTemplateName = templateNames[1];
		body = getTemplate(templateName, defaultTemplateName);
		body = StringUtil.replace(body, placeholders, values);
		if (_log.isDebugEnabled()) {
			_log.debug("------------------------------body Mail using template " + templateName + "------------------------------");
			_log.debug(body);
		}
		return body;
	}
		
	private String getTemplate(String name, String defaultName) {
		long groupId = 0;
		String defaultTemplate = StringPool.BLANK;
		try {
			groupId = getGlobalGroupId();
			long rootId = 0;
			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.fetchFileEntryByFileName(groupId, rootId, name);
			
			if (dlFileEntry!=null) {
				int bufferSize = 1024;
				char[] buffer = new char[bufferSize];
				StringBuilder out = new StringBuilder();
				Reader in = new InputStreamReader(dlFileEntry.getContentStream(), StandardCharsets.UTF_8);
				for (int numRead; (numRead = in.read(buffer, 0, buffer.length)) > 0; ) {
				    out.append(buffer, 0, numRead);
				}
				String template = out.toString();
				if (_log.isDebugEnabled()) {
					_log.debug("------------------------------template------------------------------");
					_log.debug(template);
				}
				return template;
			} else {
				defaultTemplate = ContentUtil.get(this.getClass().getClassLoader(), IdpRegistrationPortletKeys.REPOSITORY_TEMPLATES+defaultName, true);
				if (_log.isDebugEnabled()) {
					_log.debug("------------------------------defaultTemplate------------------------------");
					_log.debug(defaultTemplate);
				}
				return defaultTemplate;
			}
		} catch (NoSuchGroupException e) {
			defaultTemplate = ContentUtil.get(this.getClass().getClassLoader(), IdpRegistrationPortletKeys.REPOSITORY_TEMPLATES+defaultName, true);
			_log.error("An error occurred while getting template: " + e.getMessage());
			return defaultTemplate;
		} catch (PortalException e) {
			_log.error("An error occurred while getting template: " + e.getMessage());
			return defaultTemplate;
		} catch (IOException e) {
			_log.error("An error occurred while getting template: " + e.getMessage());
			return defaultTemplate;
		}
	}
	
	private long getGlobalGroupId() throws NoSuchGroupException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Group.class);
		dynamicQuery.add(RestrictionsFactoryUtil.like("name", "%"+GroupConstants.GLOBAL+"%") );
		List<Group> group =  DLFileEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		if (group!=null && group.size()==1) {
			if (_log.isDebugEnabled()) {
				_log.debug("globalGroupId: "+group.get(0).getGroupId());
			}
			return group.get(0).getGroupId();
		} else {
			throw new NoSuchGroupException("No Group exists with the name Global");
		}
	}
	
	
	private static final Log _log = LogFactoryUtil.getLog(
			Mailer.class);
} 