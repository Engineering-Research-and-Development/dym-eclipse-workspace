//package it.eng.rd.idp.registration.web.internal.portlet.route;
//
//import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
//import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
//
//import org.osgi.service.component.annotations.Component;
//
//import it.eng.rd.idp.registration.constants.IdpRegistrationPortletKeys;
//
//
//@Component(
//	property = {
//		"com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
//		"javax.portlet.name=" + IdpRegistrationPortletKeys.IDPREGISTRATION
//	},
//	service = FriendlyURLMapper.class
//)
//public class IdpRegistrationFriendlyURLMapper extends DefaultFriendlyURLMapper {
//
//	@Override
//	public String getMapping() {
//		return _MAPPING;
//	}
//
//	private static final String _MAPPING = "idp";
//
//}