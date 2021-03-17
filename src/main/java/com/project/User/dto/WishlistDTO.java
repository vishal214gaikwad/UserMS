package com.project.User.dto;

import com.project.User.entity.Wishlist;

public class WishlistDTO {

	int buyerid;
	
	int prodid;

	public WishlistDTO() {
		super();
	}

	public WishlistDTO(int buyerid, int prodid) {
		this();
		this.buyerid = buyerid;
		this.prodid = prodid;
		
	}

	public int getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	// Converts Entity into DTO
	public static WishlistDTO valueOf(Wishlist wishlist) {
		WishlistDTO wishlistDTO = new WishlistDTO();
		wishlistDTO.setBuyerid(wishlist.getBuyerid());
		wishlistDTO.setProdid(wishlist.getProdid());
		return wishlistDTO;
	}

	public Wishlist createEntity() {
		Wishlist wishlist = new Wishlist();
		wishlist.setBuyerid(this.getBuyerid());
		wishlist.setProdid(this.getProdid());
		return wishlist;
	}
	
	@Override
	public String toString() {
		return "WishlistDTO [buyerid=" + buyerid + ", prodid=" + prodid + "]";
	}

}
