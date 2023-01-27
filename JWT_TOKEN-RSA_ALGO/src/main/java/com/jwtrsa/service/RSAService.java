package com.jwtrsa.service;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class RSAService {
	String token;
	
	 public static Map<String, Object> map = new HashMap();
	    public static final String ALGORITHM = "RSA";
	    public static final String publicKey ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgCv3o3RajQmntoTLFIiOJ9hp/QQBvmnj"
	    		+ "/OyivhXNuO3WoIWYComEy6XPeyKkuaGNC+0f7Pn9U4lJvqDX1Ehw//WOH0URGtJuNy/gkxJ64lMV"
	    		+ "4l9qrsfZJbGe5KZbk+kyiBx3cHETDn0XFd4TBlY/jl9WHgFBL0vacyihCGbUWVJE1DgywPrT0LyL"
	    		+ "h9GqkdITjQfRHwOiNmguYewthOrNZNg7hPMMcI1UNkoA2pD8Mxqazx7Il4LdDGN6NDb3Ro2ynQDN"
	    		+ "R5mYeLwNzOFljvARpbdVLh/tBj5AyE/QsCGvcatHyBJKzvS3iRv+TBhIH5BbMNeLIMPqFz1CtSFv"
	    		+ "akiK8wIDAQAB";
	    
	    public static final String privateKey ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCAK/ejdFqNCae2hMsUiI4n2Gn9"
	    		+ "BAG+aeP87KK+Fc247daghZgKiYTLpc97IqS5oY0L7R/s+f1TiUm+oNfUSHD/9Y4fRREa0m43L+CT"
	    		+ "EnriUxXiX2qux9klsZ7kpluT6TKIHHdwcRMOfRcV3hMGVj+OX1YeAUEvS9pzKKEIZtRZUkTUODLA"
	    		+ "+tPQvIuH0aqR0hONB9EfA6I2aC5h7C2E6s1k2DuE8wxwjVQ2SgDakPwzGprPHsiXgt0MY3o0NvdG"
	    		+ "jbKdAM1HmZh4vA3M4WWO8BGlt1UuH+0GPkDIT9CwIa9xq0fIEkrO9LeJG/5MGEgfkFsw14sgw+oX"
	    		+ "PUK1IW9qSIrzAgMBAAECggEAGIfRsn/vYLTrW1xY/coQ4wFhb6JXrxjXIK4ti5HiuLUUcc5/xeyB"
	    		+ "9PP8HMYJntmThCfTB2jlGhrZeVmRVTi0H9jgZY2zc1246GkKYzuTN0PNmXDHm0H2hmdTUNGiD1H/"
	    		+ "cNt55JRPoGNCitXg8EKLkXUfp0h4MFQlMAsjntcHZzy40IoEogaOYE/xgK6GXIS7ydE6biGyhOOH"
	    		+ "gUbQ345LpuGYA9L0WkJitO4xvZ2ojc3rO+2bz0qagTlwhc7Vq4LyzaqOzXciZ4SkL/xv7PagkQ0Q"
	    		+ "o0ROKkFqldb3yWRIzhkYnGs/IMAC/g4fJwMiEdod98cZXthrZId31tptEildcQKBgQDLVjn21gKI"
	    		+ "8zp1Ka2zLNF7abA50C06QuzGJ2b3qf+I1/9rpbLIinsnv5HP4RhLGEBkstXbHXYJtBRRb5JlTz9R"
	    		+ "anhbIJ9FU3y12W9L7dsFRddB5XABD/xBZFXWp6Qkd9v6nErGjedgSBeXsS8YBGnf7mGfegmBtBdG"
	    		+ "IwkQSkpG6QKBgQChXhiUX3xLdbfE1pk4QYc2BFbfJKCiJdo5FgAtIfEPVpe6MDeg1y1cN1lfxyxv"
	    		+ "98IghSIX2XpUCD4khJG44WTS8vL5tq84K7yf9tye4GcLR2lWZ6ugeZ+uisjbornJ3vkQ2X1wNjYv"
	    		+ "ox/t61cNWTZyE81vRnBlog3gB/9E4usRewKBgEIsPZDm9Mw827llZvH4k/Pl4UPvS8i6HvQdvpS6"
	    		+ "7j5KjQUrV5OL/ahh38IXLyDBM7ORv6cfX1qpEDOwa6Qsth5419JQO4UENoG30VCUh8Kfh/4Z/Olb"
	    		+ "mmxtisHgrLpxh1V3p54WcEYVMBhdwUW/qfUGTx7nSFC9mxVoMXrrsmCBAoGBAJVfvy0JvsszayuA"
	    		+ "41CaCAnOtoPVKgUvOPSDEyK0OqtSIx2tKLFwvoKQkeEBRHdZR5BG7SpanMxQ3QV82k/kBSrozlat"
	    		+ "70D166PAJrXDUF+2eSIM0Wi5bUFrI0d9OLJP/wrD6UQIStyKCjJ5GZo3rRiokBCjicPq4SEzBe/E"
	    		+ "hoklAoGBALDjqkGjHZaCEc53yMFTGsAcx5IslqiearrPl5/1qgl52EedlRRKG5K5UVOnktA+360o"
	    		+ "LViZ720hynaPcGR9F14+W8yYw+LbnPglb+dxQcJ5ZYVxASp57hejicwCTQMpUM1Yrl7jQDE5s8wY"
	    		+ "XaN5FcN99xNRbQdcXft/DBwXVEZE";
	    
	    public String getValue() {
	        try {
	            final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
	            keyGen.initialize(4096);
	            
	            //Public key converting String to PublicKey
	            byte[] publicBytesss = Base64.getDecoder().decode(publicKey);
	            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
	            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
	            final PublicKey pubKey = keyFactory.generatePublic(keySpec);
	            
	            
	            //Private key converting String to PrivateKey     
	            byte[] privateBytesss = Base64.getDecoder().decode(privateKey);
	            PKCS8EncodedKeySpec keySpecPrivate = new PKCS8EncodedKeySpec(privateBytesss);
	            KeyFactory keyFactorySecond = KeyFactory.getInstance(ALGORITHM);
	            PrivateKey priK = keyFactory.generatePrivate(keySpecPrivate);
	           
	            this.token=generateJwtToken(priK);

	          
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return token;
	    }
	    
	    public String generateJwtToken(PrivateKey privateKey) {
	    	Random random = new Random();
			Long number = (long) random.nextInt(999999);
			String token = Jwts.builder().setId(String.valueOf(number)).setSubject("7310db9e-a698-4f7c-b035-b8baebbfbef5")
					.setAudience("https://app.uat-opt.idfcfirstbank.com/platform/oauth/oauth2/token")
					.setIssuer("7310db9e-a698-4f7c-b035-b8baebbfbef5")
					.setExpiration(new Date(2022, 12, 12,0,30))
					.signWith(SignatureAlgorithm.RS256, privateKey).compact();
			return token;
	    
}}
