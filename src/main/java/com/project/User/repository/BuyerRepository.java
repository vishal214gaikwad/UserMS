
package com.project.User.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.User.entity.Buyer;

@Repository
public interface BuyerRepository  extends JpaRepository <Buyer, Integer>{
	
	public Buyer findByEmail(String email);
	public Buyer deleteByEmail(String email);
	public Optional<Buyer> findByPhoneno(String phoneno);
	public Buyer findByBuyerid(Integer buyerid);

}
