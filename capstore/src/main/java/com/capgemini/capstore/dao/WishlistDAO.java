package com.capgemini.capstore.dao;

import java.util.List;

import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.bean.WishlistBean;

public interface WishlistDAO {

	public boolean addToWishlist(String email, int productId);

	public boolean removeFromWishlist(String email, int productId);

	public List<WishlistBean> displayWishlist(String email);
	
	public ProductBean getProduct(int productId);
}
