package it.eng.rd.util.crypto;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AesCrypto
{
		private static SecretKeySpec secretKey;
		private static byte[] key;	
		private static String ALGORITHM = "AES";
		private static String UNICODE_FORMAT = "UTF-8";
		private static String SHA = "SHA-1";
		
	    public static SecretKeySpec setKey(String myKey) 
	    {
	        MessageDigest sha = null;
	        SecretKeySpec secretKey = null;
	        try {
	            byte[] key = myKey.getBytes(UNICODE_FORMAT);
	            sha = MessageDigest.getInstance(SHA);
	            key = sha.digest(key);
	            key = Arrays.copyOf(key, 16); 
	            secretKey = new SecretKeySpec(key, ALGORITHM);
	        } 
	        catch (NoSuchAlgorithmException e) {
	        	_log.error("Error while generating secretKey: " + e.toString());
	        } 
	        catch (UnsupportedEncodingException e) {
	        	_log.error("Error while generating secretKey: " + e.toString());
	        }
        return secretKey;
    }
 
    public static String encrypt(String strToEncrypt, String secret) 
    {
        try
        {
        	SecretKeySpec secretKey = setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            _log.error("Error while encrypting: " + e.toString());
        }
        return null;
    }
    
    private static final Log _log = LogFactoryUtil.getLog(
    		AesCrypto.class);
}