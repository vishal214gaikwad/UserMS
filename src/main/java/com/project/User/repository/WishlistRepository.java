package com.project.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.project.User.entity.Composite;
import com.project.User.entity.Wishlist;



public interface WishlistRepository extends JpaRepository<Wishlist,Composite>{
	public Wishlist findByBuyerid(Integer buyerid);

}
