package com.project.User.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.User.entity.Cart;
import com.project.User.entity.Composite;



public interface CartRepository extends JpaRepository<Cart, Composite> {

	public List<Cart> findByBuyerid(int buyerid);
}