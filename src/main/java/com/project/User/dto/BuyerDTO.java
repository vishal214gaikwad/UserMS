package com.project.User.dto;

import com.project.User.dto.BuyerDTO;
import com.project.User.entity.Buyer;

public class BuyerDTO {

	int buyerid;
	
	String name;
	
	String email;
	
	String phoneno;

	String password;
	
	int isprivileged;
	
	int rewardpoints;
	
	int isactive;
	
	public BuyerDTO() {
		super();
	}

	public BuyerDTO(int buyerid, String name, String email, String phoneno, String password, int isprivileged,int rewardpoints, int isactive ) {
		this();
		this.buyerid = buyerid;
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
		this.isprivileged = isprivileged;
		this.rewardpoints = rewardpoints;
		this.isactive = isactive;
	}

	public int getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
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

	public int getIsprivileged() {
		return isprivileged;
	}

	public void setIsprivileged(int isprivileged) {
		this.isprivileged = isprivileged;
	}

	public int getRewardpoints() {
		return rewardpoints;
	}

	public void setRewardpoints(int rewardpoints) {
		this.rewardpoints = rewardpoints;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	// Converts Entity into DTO
	public static BuyerDTO valueOf(Buyer buyer) {
		BuyerDTO buyerDTO = new BuyerDTO();
		buyerDTO.setBuyerid(buyer.getBuyerid());
		buyerDTO.setName(buyer.getName());
		buyerDTO.setEmail(buyer.getEmail());
		buyerDTO.setPhoneno(buyer.getPhoneno());
		buyerDTO.setPassword(buyer.getPassword());
		buyerDTO.setIsprivileged(buyer.getIsprivileged());
		buyerDTO.setRewardpoints(buyer.getRewardpoints());
		buyerDTO.setIsactive(buyer.getIsactive());
		
		return buyerDTO;
	}
	
	// Converts DTO into Entity
			public Buyer createEntity() {
				Buyer buyer = new Buyer();
				buyer.setBuyerid(this.getBuyerid());
				buyer.setName(this.getName());
				buyer.setEmail(this.getEmail());
				buyer.setPhoneno(this.getPhoneno());
				buyer.setPassword(this.getPassword());
				buyer.setIsprivileged(this.getIsprivileged());
				buyer.setRewardpoints(this.getRewardpoints());
				buyer.setIsactive(this.getIsactive());
				return buyer;
			}

	@Override
	public String toString() {
		return "BuyerDTO [buyerid=" + buyerid + ", name=" + name + ", email=" + email + ", phoneno=" + phoneno
				+ ", password=" + password + ", isprivileged=" + isprivileged + ", rewardpoints=" + rewardpoints
				+ ", isactive=" + isactive + "]";
	}

}
