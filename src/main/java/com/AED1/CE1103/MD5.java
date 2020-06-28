package com.AED1.CE1103;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;

public class MD5 {
	public static String encriptar(String pass) throws NoSuchAlgorithmException  {
		MessageDigest md = MessageDigest.getInstance("MD5");
	      md.update(pass.getBytes());
	      byte[] digest = md.digest();


	      for (byte b : digest) {
	         System.out.print(Integer.toHexString(0xFF & b));
	      }
	      System.out.println();


	      byte[] encoded = Base64.encodeBase64(digest);
	      System.out.println("ENCRIPTADA"+new String(encoded));
	      return new String(encoded);
		
	}

}
