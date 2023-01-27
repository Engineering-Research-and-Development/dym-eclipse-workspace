package it.eng.rd.chat.config.portlet;

import it.eng.rd.chat.config.constants.ChatConfigPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author ENGRD
 */

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Collaboration",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Chat Configuration", 
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/", 
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ChatConfigPortletKeys.CHATCONFIG,
		"javax.portlet.resource-bundle=content.Language", 
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ChatConfigPortlet extends MVCPortlet {
}
