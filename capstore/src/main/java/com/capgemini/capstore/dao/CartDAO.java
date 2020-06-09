package com.capgemini.capstore.dao;

import java.util.List;

import com.capgemini.capstore.bean.CartBean;

public interface CartDAO {

	public boolean addToCart(String email, int productId);

	public boolean removeFromCart(String email, int productId);

	public List<CartBean> displayCart(String email);
}
