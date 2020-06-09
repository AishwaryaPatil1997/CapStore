package com.capgemini.capstore.response;

import java.util.List;

import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.bean.WishlistBean;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CapStoreResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<WishlistBean> displayWishlist;
	private ProductBean productBean;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<WishlistBean> getDisplayWishlist() {
		return displayWishlist;
	}

	public void setDisplayWishlist(List<WishlistBean> displayWishlist) {
		this.displayWishlist = displayWishlist;
	}

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
}
