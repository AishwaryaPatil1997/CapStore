package com.capgemini.capstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.capstore.bean.CartBean;

@Repository
@SuppressWarnings("unchecked")
public class CartDAOImpl implements CartDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean addToCart(String email, int productId) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		String userEmailQuery = "from LoginBean where email = :email";
		Query query = entityManager.createQuery(userEmailQuery);
		query.setParameter("email", email);
		
		String productIdQuery = "from ProductBean where productId = :productId";
		Query query1 = entityManager.createQuery(productIdQuery);
		query1.setParameter("productId", productId);
		
		boolean isproductAdded = false;
		CartBean cartBean = new CartBean();
		cartBean.setEmail(email);
		cartBean.setProductId(productId);
		
		try {
			entityTransaction.begin();
			entityManager.persist(cartBean);
			entityTransaction.commit();
			isproductAdded = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isproductAdded;
	}

	@Override
	public boolean removeFromCart(String email, int productId) {
		boolean isproductRemoved = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		String productIdQuery = "from CartBean where email = :email AND productId = :productId";
		Query query1 = entityManager.createQuery(productIdQuery);
		query1.setParameter("productId", productId);
		query1.setParameter("email", email);
		CartBean cartBean = (CartBean) query1.getSingleResult();

		try {
			entityTransaction.begin();
			entityManager.remove(cartBean);
			entityTransaction.commit();
			isproductRemoved = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isproductRemoved;
	}

	@Override
	public List<CartBean> displayCart(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
