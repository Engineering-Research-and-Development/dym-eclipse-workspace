package it.eng.rd.chat.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.chat.web.constants.SocketPortletKeys;


@Component(
		immediate = true, 
		property = {
				"com.liferay.portlet.display-category=category.hidden",
				"com.liferay.portlet.instanceable=false", 
				"com.liferay.portlet.portlet-setup-show-borders=false",
				"javax.portlet.display-name=SocketPortlet", 
				"javax.portlet.init-param.template-path=/", 
				"javax.portlet.init-param.view-template=/", 
				"javax.portlet.name="+SocketPortletKeys.SOCKET,
				"javax.portlet.resource-bundle=content.Language", 
				"javax.portlet.security-role-ref=power-user,user"
		}, 
		service = {Portlet.class}
	)  
public class SocketPortlet extends MVCPortlet {}


