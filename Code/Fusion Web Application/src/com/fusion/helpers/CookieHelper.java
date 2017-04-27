package com.fusion.helpers;

import javax.servlet.http.Cookie;

public class CookieHelper {
	
	private Cookie[] cookies;
	
	public CookieHelper() throws CookieHelperException {
		cookies = null;
	}
	
	public CookieHelper(Cookie[] c) throws CookieHelperException {
		cookies = c;
	}
	
	public String getValue(String Name){
		
		String val = new String();
		
		Cookie cookie = null;
		if( cookies != null ){
		    for (int i = 0; i < cookies.length; i++){
		       cookie = cookies[i];
		       if(cookie.getName().equals(Name)){
		    	   val = cookie.getValue();
		       }
		    }
		}
		
		if(val.isEmpty()){
			System.out.println("CookieHelper: No value for " + Name);
		}
		
		return val;
	}
	
	public static void removeCookieByName(Cookie[] cs, String Name){
		
		if( cs != null ){
		    for (int i = 0; i < cs.length; i++){
		       if(cs[i].getName().equals(Name)){
		    	   cs[i].setMaxAge(0);
		    	   System.out.println("CookieHelper: Cookie [" + Name + "] deleted");
		       }
		    }
		} else{
			System.out.println("CookieHelper: No cookie [" + Name + "] found");
		}

	}
	
	public void setCookies(Cookie[] c){
		cookies = c;
	}
	
	public Cookie[] getCookies(Cookie[] c){
		return cookies;
	}

	public static class CookieHelperException extends Exception {
			
			private static final long serialVersionUID = 1L;
	
			public CookieHelperException() {
				super();
			}
			
			public CookieHelperException(String message) {
				super(message);
			}
			
			public CookieHelperException(String message, Throwable cause) {
				super(message, cause);
			}
			
	}
}
