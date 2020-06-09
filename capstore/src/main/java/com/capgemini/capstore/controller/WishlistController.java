package com.capgemini.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.bean.WishlistBean;
import com.capgemini.capstore.response.CapStoreResponse;
import com.capgemini.capstore.service.WishlistService;

@RestController
//To connect rest with angular
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;
	
	@PostMapping(path = "/addToWishlist")
	public CapStoreResponse addToWishlist(@RequestParam String email, @RequestParam int productId) {
		boolean isAdded = wishlistService.addToWishlist(email, productId);
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		if (isAdded) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Product added to wishlist !");

		} else {
			capStoreResponse.setStatusCode(401);
			capStoreResponse.setMessage("Failed");
			capStoreResponse.setDescription("Enable to add product to wishlist !");
		}
		return capStoreResponse;
	}
	
	@DeleteMapping(path = "/removeFromWishlist")
	public CapStoreResponse removeFromWishlist(@RequestParam String email, @RequestParam int productId) {
		boolean isRemoved = wishlistService.removeFromWishlist(email, productId);
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		if (isRemoved) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Product removed from wishlist !");
		} else {
			capStoreResponse.setStatusCode(401);
			capStoreResponse.setMessage("Failed");
			capStoreResponse.setDescription("Unable to remove product from wishlist !");
		}
		return capStoreResponse;
	}
	
	@GetMapping(path = "/displayWishlist")
	public CapStoreResponse displayWishlist(@RequestParam String email) {
		List<WishlistBean> displayWishlist = wishlistService.displayWishlist(email);
//		ProductBean productBean = null;
//		productBean = wishlistService.getProduct(productBean.getProductId());
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		if (displayWishlist != null) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDisplayWishlist(displayWishlist);
//			capStoreResponse.setProductBean(productBean);
			capStoreResponse.setDescription("Wishlist displayed !");
		} else {
			capStoreResponse.setStatusCode(401);
			capStoreResponse.setMessage("Failed");
			capStoreResponse.setDescription("Unable to display wishlist !");
		}
		return capStoreResponse;
	}
}
