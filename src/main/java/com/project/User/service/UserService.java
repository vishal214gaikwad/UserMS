package com.project.User.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.User.validator.Validator;
import com.project.User.dto.BuyerDTO;
import com.project.User.dto.CartDTO;
import com.project.User.dto.SellerDTO;
import com.project.User.dto.WishlistDTO;
import com.project.User.entity.Buyer;
import com.project.User.entity.Composite;
import com.project.User.entity.Cart;
import com.project.User.entity.Seller;
import com.project.User.entity.Wishlist;
import com.project.User.repository.BuyerRepository;
import com.project.User.repository.CartRepository;
import com.project.User.repository.SellerRepository;
import com.project.User.repository.WishlistRepository;

@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BuyerRepository buyerRepository;
	
	@Autowired
	SellerRepository sellerRepository;
	
	@Autowired
	WishlistRepository wishlistRespository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	Environment environment;
	
	@Autowired
	Validator validator;
	
	@Autowired
	EntityManager entityManager;
	
	public void registerBuyer(BuyerDTO buyerDTO) throws Exception {
		logger.info("Register request for buyer {}", buyerDTO);
		validator.validateBuyer(buyerDTO);
		Optional<Buyer> buyerphone = buyerRepository.findByPhoneno(buyerDTO.getPhoneno());
		Buyer buyeremail = buyerRepository.findByEmail(buyerDTO.getEmail());
		if(buyerphone.isPresent()) {
			System.out.println("in user phone number valid");
			throw new Exception(environment.getProperty("USER_PHONE_EXISTS"));
		}
		if(buyeremail != null) {
			System.out.println("in user email valid");
			throw new Exception(environment.getProperty("USER_EMAIL_EXISTS"));
		}
		Buyer buyer = buyerDTO.createEntity();
		buyerRepository.save(buyer);
	}
	public void registerSeller(SellerDTO sellerDTO) throws Exception {
		logger.info("Register request for seller {}", sellerDTO);
		validator.validateSeller(sellerDTO);
		Optional<Seller> sellerphone = sellerRepository.findByPhoneno(sellerDTO.getPhoneno());
		Seller selleremail = sellerRepository.findByEmail(sellerDTO.getEmail());
		if(sellerphone.isPresent()) {
			throw new Exception(environment.getProperty("USER_PHONE_EXISTS"));
		}
		if(selleremail != null) {
			throw new Exception(environment.getProperty("USER_EMAIL_EXISTS"));
		}
		Seller seller = sellerDTO.createEntity();
		sellerRepository.save(seller);
	}
	
	//login buyer
	public boolean loginBuyer(BuyerDTO buyerDTO) throws Exception {
		logger.info("Login request for buyer {} with buyerid {}", buyerDTO.getEmail());
		boolean status=false;
		Buyer buyer = buyerRepository.findByEmail(buyerDTO.getEmail());
		if(buyer!=null) {
			//System.out.println("Print");
			//Buyer buyer1 = buyer.get();
			if (buyer.getPassword().equals(buyerDTO.getPassword())) {
				status=true;
			}else {
				status=false;
			}
		}
		if(status==true) {
			logger.info("Successfully login");
		}else {
			logger.info(environment.getProperty("UserService.INVALID_LOGIN"));
		}
		return status;
	}
	//login seller
	public boolean loginSeller(SellerDTO sellerDTO) throws Exception {
			logger.info("Login request for buyer {} with sellerid {}", sellerDTO.getEmail());
			boolean status=false;
			Seller seller = sellerRepository.findByEmail(sellerDTO.getEmail());
			if(seller!=null) {
				System.out.println("Print");
				if (seller.getPassword().equals(sellerDTO.getPassword())) {
					status=true;
				}else {
					status=false;
				}
			}
			
			if(status==true) {
				logger.info("Successfully login");
			}else {
				logger.info(environment.getProperty("UserService.INVALID_LOGIN"));
			}
			return status;
	}
	
	//fetch all buyers
	public List<BuyerDTO> getAllBuyers(){
		List<Buyer> buyer = buyerRepository.findAll();
		List<BuyerDTO> buyerDTOs = new ArrayList<>();
		for(Buyer b:buyer) {
			BuyerDTO buyerDTO = BuyerDTO.valueOf(b);
			buyerDTOs.add(buyerDTO);
		}
		return buyerDTOs;
	}
	
	//fetch buyer by buyerid
	public BuyerDTO getBuyer(Integer buyerid) {
		
		Buyer buyer = buyerRepository.findByBuyerid(buyerid);
		BuyerDTO buyerDTO = BuyerDTO.valueOf(buyer);
		return buyerDTO;
	}
	//fetch all sellers
	public List<SellerDTO> getAllSellers(){
		List<Seller> seller = sellerRepository.findAll();
		List<SellerDTO> sellerDTOs = new ArrayList<>();
		for(Seller s:seller) {
			SellerDTO sellerDTO = SellerDTO.valueOf(s);
			sellerDTOs.add(sellerDTO);
		}
		return sellerDTOs;
	}
	
	//de-activate buyer account
	public void deleteBuyer(Integer id) {
		buyerRepository.deleteById(id);
	}
	
	//de-activate seller account
	public void deleteSeller(Integer id) {
		sellerRepository.deleteById(id);
	}
	
	//de-activate buyer account
	public boolean deleteBuyer(String email) {
		Buyer buyer = buyerRepository.findByEmail(email);
		if(buyer!=null) {
			buyerRepository.deleteById(buyer.getBuyerid());
			return true;
		}
		else {
			return false;
		}
	}
	
	//de-activate buyer account
	public boolean deleteSeller(String email) {
		Seller seller = sellerRepository.findByEmail(email);
		if(seller!=null) {
			sellerRepository.deleteById(seller.getSellerid());
			return true;
		}
		else {
			return false;
		}
	}
	
	// add product to wishlist (buyer)
	public boolean addBuyerWishlist(WishlistDTO wishlistDTO) {
		Optional<Wishlist> wishlist = wishlistRespository.findById(new Composite(wishlistDTO.getBuyerid(),wishlistDTO.getProdid()));
		if(!wishlist.isPresent()) {
			Wishlist wishlist1 = wishlistDTO.createEntity();
			wishlistRespository.save(wishlist1);
			return true;
		}
		else {
			return false;
		}
	}
	
	// add product to cart (Buyer)
	public boolean addToCart(CartDTO cartDTO) {
		Optional<Cart> cart = cartRepository.findById(new Composite(cartDTO.getBuyerid(),cartDTO.getProdid()));
		if(!cart.isPresent()) {
			Cart cart1 = cartDTO.createEntity();
			cartRepository.save(cart1);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	// remove product from wishlist
	public boolean removeProductFromWishlist(WishlistDTO wishlistDTO) {
		Optional<Wishlist> wishlist = wishlistRespository.findById(new Composite(wishlistDTO.getBuyerid(),wishlistDTO.getProdid()));
		if(wishlist.isPresent()) {
			wishlistRespository.deleteById(new Composite(wishlistDTO.getBuyerid(),wishlistDTO.getProdid()) );
			return true;
		}else {
			return false;
		}
	}
	
	//remove product from cart
	public boolean removeProductFromCart(CartDTO cartDTO) {
		Optional<Cart> cart = cartRepository.findById(new Composite(cartDTO.getBuyerid(),cartDTO.getProdid()));
		if(cart.isPresent()) {
			cartRepository.deleteById(new Composite(cartDTO.getBuyerid(),cartDTO.getProdid()) );
			return true;
		}else {
			return false;
		}
	}
	
	//get CART items
	public List<CartDTO> getCart(int buyerid){
		List<Cart> carts = cartRepository.findByBuyerid(buyerid);
		List<CartDTO> cartDTOs = new ArrayList<>();
		for(Cart cart : carts) {
		CartDTO cartDTO = CartDTO.valueOf(cart);
		cartDTOs.add(cartDTO);
		}
		return cartDTOs;
	}
	
	//inactivate a buyer
	public boolean inactivateBuyer(BuyerDTO buyerDTO)
	{
		Buyer buyer = buyerRepository.findByEmail(buyerDTO.getEmail());
		if(buyer!=null) {
			buyer.setIsactive(0);
			buyerRepository.save(buyer);
			return true;
		}else {
			return false;
		}
	}
	//activate a buyer
		public boolean activateBuyer(BuyerDTO buyerDTO)
		{
			Buyer buyer = buyerRepository.findByEmail(buyerDTO.getEmail());
			if(buyer!=null) {
				buyer.setIsactive(1);
				buyerRepository.save(buyer);
				return true;
			}else {
				return false;
			}
		}
		
		//inactivate a seller
		public boolean inactivateSeller(SellerDTO sellerDTO)
		{
			Seller seller = sellerRepository.findByEmail(sellerDTO.getEmail());
			if(seller!=null) {
				seller.setIsactive(0);
				sellerRepository.save(seller);
				return true;
			}else {
				return false;
			}
		}
		//activate a seller
		public boolean activateSeller(SellerDTO sellerDTO)
		{
			Seller seller= sellerRepository.findByEmail(sellerDTO.getEmail());
			if(seller!=null) {
				seller.setIsactive(1);
				sellerRepository.save(seller);
				return true;
			}else {
				return false;
			}
		}
		

		public WishlistDTO getWishlist(Integer buyerid) {
			Wishlist wishlist = wishlistRespository.findByBuyerid(buyerid);
			WishlistDTO wishlistDTO = WishlistDTO.valueOf(wishlist);
			return wishlistDTO;
		}
		
		//updatePrivilege
		public boolean updatePrivilege(BuyerDTO buyerDTO) throws Exception {

			Buyer buyer = buyerRepository.findByEmail(buyerDTO.getEmail());
			if(buyer!=null) {
				if(buyer.getIsprivileged()==0) {
					if(Validator.validateRewardPointsForPrivilege(buyer.getRewardpoints()))
					{
						buyer.setIsprivileged(1);
						buyer.setRewardpoints(buyer.getRewardpoints()-10000);
						buyerRepository.save(buyer);
					}
					else
						throw new Exception(environment.getProperty("INSUFFICIENT_REWARDPOINTS"));
				}
				else
					throw new Exception(environment.getProperty("ALREADY_PRIVILEGED"));
			}
			else
				throw new Exception(environment.getProperty("EMAIL_DOES_NOT_EXIST"));

			return true;
		}
		
		
		public BuyerDTO updateRewards(Integer buyerid, BuyerDTO buyerDTO) {
			Buyer buyer = buyerRepository.findByBuyerid(buyerid);
			BuyerDTO buyerDTO1 = null;
			if(buyer!=null) {
				buyer.setRewardpoints(buyerDTO.getRewardpoints());
				buyerDTO1 = BuyerDTO.valueOf(buyer);
				
				buyerRepository.save(buyer);
			}
			return buyerDTO1;
		}

}
