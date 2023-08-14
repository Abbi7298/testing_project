package com.nagarro.validator;

public class Validation {
	public boolean checkPreference(String choice) {
		if (choice.equalsIgnoreCase("rating") || choice.equalsIgnoreCase("price")) {
			return true;
		}
		return false;
	}

	public boolean checkGender(String gender) {
		if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")) {
			return true;
		}
		return false;
	}

	public boolean checkSize(String size) {
		if (size.equalsIgnoreCase("S") || size.equalsIgnoreCase("M") || size.equalsIgnoreCase("L")
				|| size.equalsIgnoreCase("XL") || size.equalsIgnoreCase("XXL")) {
			return true;
		}
		return false;
		
	}

}
