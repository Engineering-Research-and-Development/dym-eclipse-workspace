package it.eng.rd.dymer.web.util.crypto;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import it.eng.rd.dymer.portlet.constants.DymerPropsKeys;

public class AesCrypto
{
	private static String ALGORITHM = "AES";
	private static String UNICODE_FORMAT = "UTF-8";
	private static String SHA = "SHA-1";
	
    public static SecretKeySpec setKey(String secretKey) 
    {
        MessageDigest sha = null;
        SecretKeySpec secretKeySpec = null;
        try {
            byte[] key = secretKey.getBytes(UNICODE_FORMAT);
            sha = MessageDigest.getInstance(SHA);
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKeySpec = new SecretKeySpec(key, ALGORITHM);
        } 
        catch (NoSuchAlgorithmException e) {
        	_log.error("Error while generating secretKey: " + e.toString());
        } 
        catch (UnsupportedEncodingException e) {
        	_log.error("Error while generating secretKey: " + e.toString());
        }
        return secretKeySpec;
    }
 
    public static String encrypt(String message, String secret) 
    {
        try
        {
        	SecretKeySpec secretKey = setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            _log.error("Error while encrypting: " + e.toString());
        }
        return null;
    }
    
    
	public static String decrypt(String message, String secret) 
    {
		try 
		{
			SecretKeySpec secretKey = setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(message)));
		} 
		catch (Exception e) 
		{
			_log.error("Error while decrypting: " + e.toString());
		}
		return null;
    }
	
	public static String[] dymerJwts(User currentUser, long groupId) {
		JSONObject userInfoJSONObject = JSONFactoryUtil.createJSONObject();
		JSONArray roleArray = JSONFactoryUtil.createJSONArray();
		List<Role> roles = currentUser.getRoles();
		for (Role role : roles) {
			JSONObject userRole = JSONFactoryUtil.createJSONObject();
			userRole.put("id", role.getRoleId());
			userRole.put("role", role.getName());
			roleArray.put(userRole);
		}
		userInfoJSONObject.put("username", currentUser.getFullName());
		userInfoJSONObject.put("app_azf_domain", "");
		userInfoJSONObject.put("authorization_decision", "");
		userInfoJSONObject.put("id", "");
		userInfoJSONObject.put("email", currentUser.getEmailAddress());
		userInfoJSONObject.put("isGravatarEnabled", false);
		userInfoJSONObject.put("app_id", "");
		userInfoJSONObject.put("roles", roleArray);
		JSONObject extraInfoJSONObject = JSONFactoryUtil.createJSONObject();
		extraInfoJSONObject.put("userId", currentUser.getUserId());
		extraInfoJSONObject.put("groupId", groupId);
		extraInfoJSONObject.put("companyId", currentUser.getCompanyId());
		extraInfoJSONObject.put("cms", "lfr");
		try {
			Company company = CompanyLocalServiceUtil.getCompany(currentUser.getCompanyId());
			extraInfoJSONObject.put("virtualhost", company.getVirtualHostname());
		} catch (PortalException e) {
			extraInfoJSONObject.put("virtualhost", "");
		}
		userInfoJSONObject.put("extrainfo", extraInfoJSONObject);
		
		JSONObject dymerExtraInfoJSONObject = JSONFactoryUtil.createJSONObject();
		dymerExtraInfoJSONObject.put("extrainfo", extraInfoJSONObject);
		String dymerJWT = "";
		String dymerJWTExtra = "";
		if (userInfoJSONObject!=null) {
			dymerJWT = userInfoJSONObject.toJSONString();
		}
		if (dymerExtraInfoJSONObject!=null) {
			dymerJWTExtra = dymerExtraInfoJSONObject.toJSONString();
		}
		return new String[] {dymerJWT, dymerJWTExtra};
	}
	
	
	public static String encrypting(String message) {
		String secretKey = GetterUtil.getString(PropsUtil.get(DymerPropsKeys.AES_SECRET_KEY));
		if (Validator.isNotNull(secretKey) && !secretKey.equalsIgnoreCase("")) {
			message = encrypt(message, secretKey);
			if (_log.isDebugEnabled())
				_log.debug(" message encrypted: "+message);
		}
		return message;
	}
	
	public static String decrypting(String message) {
		String secretKey = GetterUtil.getString(PropsUtil.get(DymerPropsKeys.AES_SECRET_KEY));
		if (Validator.isNotNull(secretKey) && !secretKey.equalsIgnoreCase("")) {
			message = decrypt(message, secretKey);
			if (_log.isDebugEnabled())
				_log.debug(" message decrypted: "+message);
		}
		return message;
	}
	
    private static final Log _log = LogFactoryUtil.getLog(
    		AesCrypto.class);
}
