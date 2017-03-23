package com.fusion.objects;

public class PhoneNumber {
	
	private int areaCode;
	private int prefix;
	private int lineNumber;
	
	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		setAreaCode(areaCode);
		setPrefix(prefix);
		setLineNumber(lineNumber);
	}
	
	public PhoneNumber(String number) {
		if (number == null) {
			return;
		}
		String[] split = number.split("-");
		if (split.length != 3) {
			throw new RuntimeException("Invalid Phone Number Format");
		}
		try {
			setAreaCode(Integer.parseInt(split[0]));
			setPrefix(Integer.parseInt(split[1]));
			setLineNumber(Integer.parseInt(split[2]));
		} catch (NumberFormatException e) {
			throw new RuntimeException("Invalid Phone Number Format.", e);
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		if (areaCode < 10) {
			s += "00";
		} else if (areaCode < 100) {
			s += "0";
		}
		s += areaCode;
		s += '-';
		if (prefix < 10) {
			s += "00";
		} else if (prefix < 100) {
			s += "0";
		}
		s += prefix;
		s += '-';
		if (lineNumber < 10) {
			s += "000";
		} else if (lineNumber < 100) {
			s += "00";
		} else if (lineNumber < 1000) {
			s += "0";
		}
		s += lineNumber;
		return s;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public int getPrefix() {
		return prefix;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setAreaCode(int areaCode) {
		if (areaCode > 999 || areaCode < 0) {
			throw new RuntimeException("Invalid area code [" + areaCode + "]");
		}
		this.areaCode = areaCode;
	}

	public void setPrefix(int prefix) {
		if (prefix > 999 || prefix < 0) {
			throw new RuntimeException("Invalid area code [" + prefix + "]");
		}
		this.prefix = prefix;
	}

	public void setLineNumber(int lineNumber) {
		if (lineNumber > 9999 || lineNumber < 0) {
			throw new RuntimeException("Invalid area code [" + lineNumber + "]");
		}
		this.lineNumber = lineNumber;
	}
}
