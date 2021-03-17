package com.project.User.validator;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.project.User.dto.BuyerDTO;
import com.project.User.dto.SellerDTO;

@Component
public class Validator {
	
	@Autowired
	Environment environment;
	
	public void validateBuyer(BuyerDTO buyer) throws Exception {
		if(!validateName(buyer.getName())) {
			throw new Exception(environment.getProperty("INVALID_NAME"));
		}
		if(!validateEmail(buyer.getEmail())){
			throw new Exception(environment.getProperty("INVALID_EMAIL"));
		}
		if(!validatePassword(buyer.getPassword())) {
			throw new Exception(environment.getProperty("INVALID_PASSWORD"));
		}
		if(!validatePhoneNumber(buyer.getPhoneno())) {
			throw new Exception(environment.getProperty("INVALID_PHONENUMBER"));
		}
		
	}
	
	public void validateSeller(SellerDTO seller) throws Exception {
		if(!validateName(seller.getName())) {
			throw new Exception(environment.getProperty("INVALID_NAME"));
		}
		if(!validateEmail(seller.getEmail())){
			throw new Exception(environment.getProperty("INVALID_EMAIL"));
		}
		if(!validatePassword(seller.getPassword())) {
			throw new Exception(environment.getProperty("INVALID_PASSWORD"));
		}
		if(!validatePhoneNumber(seller.getPhoneno())) {
			throw new Exception(environment.getProperty("INVALID_PHONENUMBER"));
		}
		
	}
	
	public static boolean validateName(String name) throws Exception {
		String regex="([A-Za-z]+\\s?)+[^@#$%^&*_!0-9. ]";
		 if(name.matches(regex)){
	            return true;
	        }
		 else
			   return false;
	}
	
	public static boolean validateEmail(String email) throws Exception {
		String regex = "[a-zA-Z0-9]+@[a-zA-Z]+\\.com";
		 if(email.matches(regex)){
	            return true;
	        }
		 else
			   return false;
	}
	
	public static boolean validatePassword(String password) throws Exception{
		String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
		if(password.matches(regex)) {
			return true;
		}
		else 
		    return false;
	}
	
	public static boolean validatePhoneNumber(String phoneno) throws Exception {
		 String regex="[0-9]{10}";
		 if(phoneno.matches(regex)) {
			 return true;
		 }
		 else 
			 return false;
	}
	
	public static boolean validateRewardPointsForPrivilege(int rewardPoints) throws Exception {
		 if(rewardPoints>=10000)
		    return true;
		 else
			 return false;
	}

}

