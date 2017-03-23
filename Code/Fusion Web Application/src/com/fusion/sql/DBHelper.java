package com.fusion.sql;

public class DBHelper {
	
	public static class DBHelperException extends Exception {
		
		public DBHelperException() {
			super();
		}
		
		public DBHelperException(String message) {
			super(message);
		}
		
		public DBHelperException(String message, Throwable cause) {
			super(message, cause);
		}
		
	}

}
