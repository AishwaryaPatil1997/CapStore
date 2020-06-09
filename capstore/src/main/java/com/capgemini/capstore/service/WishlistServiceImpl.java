package com.capgemini.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.bean.WishlistBean;
import com.capgemini.capstore.dao.WishlistDAO;

@Service
public class WishlistServiceImpl implements WishlistService{

	@Autowired
	private WishlistDAO wishlistDAO;
	
	@Override
	public boolean addToWishlist(String email, int productId) {
		return wishlistDAO.addToWishlist(email, productId);
	}

	@Override
	public boolean removeFromWishlist(String email, int productId) {
		return wishlistDAO.removeFromWishlist(email, productId);
	}

	@Override
	public List<WishlistBean> displayWishlist(String email) {
		return wishlistDAO.displayWishlist(email);
	}

	@Override
	public ProductBean getProduct(int productId) {
		return wishlistDAO.getProduct(productId);
	}

}
