package com.cvpedgram.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashingEncoder {

	
	// md5 통한 암호화 기능
		public static String encode(String message) {
			 
			String result = "";
			try {
			MessageDigest MessageDigets =  MessageDigest.getInstance("md5");
			
			byte[] bytes = message.getBytes();
			
			MessageDigets.update(bytes);
			
			byte[] digest = MessageDigets.digest();
			
			for(int i = 0; i < digest.length; i++) {
				Integer.toHexString(digest[i] & 0xff);
			}
				
					
			} catch(NoSuchAlgorithmException e) {
				e.printStackTrace();
				return null;
			}
			return result;
		}
}
