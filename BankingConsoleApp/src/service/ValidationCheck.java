package service;

import java.util.*;
import java.util.regex.*;

public class ValidationCheck {
	public boolean validName(String name) {
	    if (name == null || name.trim().isEmpty()) return false;

	    for (char ch : name.toCharArray()) {
	        if (!Character.isLetter(ch) && ch != ' ') {
	            return false; 
	        }
	    }
	    return true; 
	}
	
	public boolean validAddress(String address) {
		 if (address == null || address.trim().isEmpty()) return false;

		 for (char ch : address.toCharArray()) {
		        if (Character.isLetter(ch)) {
		            return true; 
		        }
		    }
		    return false;
		
	}
	
	public boolean validEmail(String email){
        Pattern pattern = Pattern.compile("^[a-z][a-z0-9]*@gmail\\.com$");
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            return true;
        } 
        else {
            return false;
        }
	}
	
}

