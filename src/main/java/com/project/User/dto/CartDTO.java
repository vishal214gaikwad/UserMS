package com.project.User.dto;

import com.project.User.entity.Cart;

public class CartDTO {

	int buyerid;
	
	int prodid;
	
	int quantity;
	
	public CartDTO() {
		super();
	}

	public CartDTO(int buyerid, int prodid, int quantity) {
		this();
		this.buyerid = buyerid;
		this.prodid = prodid;
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// Converts Entity into DTO
	public static CartDTO valueOf(Cart cart) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setBuyerid(cart.getBuyerid());
		cartDTO.setProdid(cart.getProdid());
		cartDTO.setQuantity(cart.getQuantity());
		return cartDTO;
	}

	// Converts DTO into Entity
				public Cart createEntity() {
					Cart cart = new Cart();
					cart.setBuyerid(this.getBuyerid());
					cart.setProdid(this.getProdid());
					cart.setQuantity(this.getQuantity());
					return cart;
				}
	@Override
	public String toString() {
		return "CartDTO [buyerid=" + buyerid + ", prodid=" + prodid + ", quantity=" + quantity + "]";
	}

	
}
