package com.project.User.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "wishlist")
@IdClass(Composite.class)
public class Wishlist implements Serializable {

    @Id
    @Column(nullable = false, length=11)
   Integer buyerid;
    @Id
    @Column(nullable = false, length=11)
    Integer prodid;
    

    public Wishlist() {
    }

    public Wishlist(Integer buyerid, Integer prodid) {
        this.buyerid = buyerid;
        this.prodid = prodid;
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
    
}