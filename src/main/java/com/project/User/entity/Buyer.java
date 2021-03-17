package com.project.User.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, length=11)
	int buyerid;
	@Column(nullable = false, length=45)
	String name;
	@Column(nullable = false, length=45)
	String email;
	@Column(nullable = false, length=45)
	String phoneno;
	@Column(nullable = false, length=45)
	String password;
	@Column(length=1)
	int isprivileged;
	@Column(length=11)
	int rewardpoints;
	@Column(length=1)
	int isactive;
	
	//parameterless constructor
		public Buyer() {
			super();
		}
	    //parametrized constructor
		public Buyer(int buyerid, String name, String password, String email, String phoneno,int isprivileged,
				int rewardpoints, int isactive) {
			super();
			this.buyerid = buyerid;
			this.name = name;
			this.password = password;
			this.email = email;
			this.phoneno = phoneno;
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
	
	
	
	
	
	
	

}
