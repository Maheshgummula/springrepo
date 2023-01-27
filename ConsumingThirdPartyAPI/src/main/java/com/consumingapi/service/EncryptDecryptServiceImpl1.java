package com.consumingapi.service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

@Service
public class EncryptDecryptServiceImpl1 {
	
	private Map<String, Object> map=new HashMap<>();
	 public void createKeys() {
		 try {
			 KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
			 keyPairGenerator.initialize(4096);
			 KeyPair keyPair=keyPairGenerator.generateKeyPair();
			 PublicKey publicKey=keyPair.getPublic();
			 PrivateKey privateKey=keyPair.getPrivate();
			 map.put("PublicKey", publicKey);
			 map.put("PrivateKey", privateKey);
			 
			
		} catch (Exception e) {
e.printStackTrace();			
		}
	 }
	 
	 
	 
	 public String encryptRequest(String plaintext) {
		 try {
			 createKeys();
			 Cipher cipher=Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
			 PublicKey publicKey=(PublicKey) map.get("PublicKey");
			 cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			 byte[] encrypt=cipher.doFinal(plaintext.getBytes());
			 String encryptdata=new String(Base64.getEncoder().encodeToString(encrypt));
			  JsonObject object = new JsonObject();
			   object.addProperty("key", encryptdata);
	              String addedString = object.toString();
	              System.out.println("added String is : " + addedString);
	              return addedString;
			 
		} catch (Exception e) {
e.printStackTrace();
		}
		return "";
	 }
	 public String encryptResponse(String plaintext) {
		 try {
//			 createKeys();
			 Cipher cipher=Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
			 PublicKey publicKey=(PublicKey) map.get("PublicKey");
			 cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			 byte[] encrypt=cipher.doFinal(plaintext.getBytes());
			 String encryptdata=new String(Base64.getEncoder().encodeToString(encrypt));
			 JsonObject object = new JsonObject();
			 object.addProperty("key", encryptdata);
			 String addedString = object.toString();
			 System.out.println("added String is : " + addedString);
			 return addedString;
			 
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return "";
	 }
	 
	 public String decryptMessage(String encryptedMessgae) {
		 System.out.println("this is from decrypt method      "+encryptedMessgae);
	       try {
	          Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING"); //
	          PrivateKey thisPrivateKey = (PrivateKey) map.get("PrivateKey");
	          cipher.init(Cipher.DECRYPT_MODE, thisPrivateKey);
	          byte[] decrypt = cipher.doFinal(Base64.getDecoder().decode(encryptedMessgae));
	          return new String(decrypt);
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
	        return "there is something error ";
	    }
	 
	 public String getTExt(String str) {
		 return str;
	 }
	 

}
