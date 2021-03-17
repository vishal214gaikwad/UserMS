package com.project.User.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "cart")
@IdClass(Composite.class)
public class Cart  {

    @Id
    @Column(nullable = false, length=11)
    private Integer buyerid;
    @Id
    @Column(nullable = false, length=11)
    private Integer prodid;
    
    @Column(nullable = false, length=11)
    private Integer quantity;

    public Cart() {
    }

    public Cart(Integer buyerid, Integer prodid, Integer quantity) {
        this.buyerid = buyerid;
        this.prodid = prodid;
        this.quantity = quantity;
    }

	public Integer getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(Integer buyerid) {
		this.buyerid = buyerid;
	}

	public Integer getProdid() {
		return prodid;
	}

	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

    
    
}