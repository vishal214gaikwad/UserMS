package com.project.User.dto;

import com.project.User.entity.Seller;

public class SellerDTO {

	int sellerid;
	
	String name;
	
	String email;
	
	String phoneno;
	
	String password;
	
    int isactive;
    
	public SellerDTO() {
		super();
	}

	public SellerDTO(int sellerid, String name, String email, String phoneno, String password, int isactive) {
		this();
		this.sellerid = sellerid;
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
		this.isactive = isactive;
	}
	
	public int getSellerid() {
		return sellerid;
	}

	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	// Converts Entity into DTO
	public static SellerDTO valueOf(Seller seller) {
		SellerDTO sellerDTO = new SellerDTO();
		sellerDTO.setSellerid(seller.getSellerid());
		sellerDTO.setName(seller.getName());
		sellerDTO.setEmail(seller.getEmail());
		sellerDTO.setPhoneno(seller.getPhoneno());
		sellerDTO.setPassword(seller.getPassword());
		sellerDTO.setIsactive(seller.getIsactive());
		return sellerDTO;
	}

	// Converts DTO into Entity
	public Seller createEntity() {
		Seller seller = new Seller();
		seller.setSellerid(this.getSellerid());
		seller.setName(this.getName());
		seller.setEmail(this.getEmail());
		seller.setPhoneno(this.getPhoneno());
		seller.setPassword(this.getPassword());
		seller.setIsactive(this.getIsactive());
		return seller;
	}
	
	
	@Override
	public String toString() {
		return "SellerDTO [sellerid=" + sellerid + ", name=" + name + ", email=" + email + ", phoneno=" + phoneno
				+ ", password=" + password + ", isactive=" + isactive + "]";
	}

	

}
