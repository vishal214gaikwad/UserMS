package com.project.User.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.User.entity.Seller;



@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

	public Seller findByEmail(String email);
	public Seller deleteByEmail(String email);
	public Optional<Seller> findByPhoneno(String phoneno);
}

