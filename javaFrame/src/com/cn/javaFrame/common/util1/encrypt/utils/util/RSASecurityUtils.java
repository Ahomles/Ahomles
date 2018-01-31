package com.cn.javaFrame.common.util1.encrypt.utils.util;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import com.thoughtworks.xstream.core.util.Base64Encoder;
  
public class RSASecurityUtils {  
    /** 
     * 解密 
     * @param cipherText 密文 
     * @return 返回解密后的字符串 
     * @throws Exception  
     */  
    public static String decrypt(String cipherText) throws Exception{  
         // 从文件中得到私钥  
        FileInputStream inPrivate = new FileInputStream(  
                RSASecurityUtils.class.getClassLoader().getResource("").getPath() + "/pkcs8_private_key.pem");  
        PrivateKey privateKey = RSAUtils.loadPrivateKey(inPrivate);  
        byte[] decryptByte = RSAUtils.decryptData(Base64Utils.decode(cipherText), privateKey);  
        String decryptStr = new String(decryptByte,"utf-8");  
        return decryptStr;  
    }  
    /** 
     * 加密 
     * @param plainTest 明文 
     * @return  返回加密后的密文 
     * @throws Exception  
     */  
    public static String encrypt(String plainTest) throws Exception{  
        FileInputStream inPublic = new FileInputStream(  
                RSASecurityUtils.class.getClassLoader().getResource("").getPath() + "/rsa_public_key.pem");  
        PublicKey publicKey = RSAUtils.loadPublicKey(inPublic);  
        // 加密  
        byte[] encryptByte = RSAUtils.encryptData(plainTest.getBytes(), publicKey);  
        String afterencrypt = Base64Utils.encode(encryptByte);  
        return afterencrypt;  
    } 
    
    public static String encryptByPublicKey(String plainTest,String publicKey,String modulus) throws Exception{  
    	PublicKey pubKey = RSAUtils.getPublicKey(modulus, publicKey);
    	byte[] encryptByte = RSAUtils.encryptData(plainTest.getBytes(), pubKey);  
    	String afterencrypt = Base64Utils.encode(encryptByte);  
        return afterencrypt;  
    }
    
    public static String decryptByprivateKey(String cipherText,String privateKey,String modulus) throws Exception{
    	PrivateKey priKey = RSAUtils.getPrivateKey(modulus, privateKey);
    	  byte[] decryptByte = RSAUtils.decryptData(Base64Utils.decode(cipherText), priKey);  
          String decryptStr = new String(decryptByte,"utf-8");  
          return decryptStr;  
    }
    
    public static void main(String[] args) {
    	KeyPair keyPair = RSAUtils.generateRSAKeyPair();
        RSAUtils.printPublicKeyInfo(keyPair.getPublic());
        RSAUtils.printPrivateKeyInfo(keyPair.getPrivate());
    }
}  