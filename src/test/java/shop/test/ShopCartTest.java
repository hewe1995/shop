package shop.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hewe.shop.domain.Category;
import hewe.shop.domain.Customer;
import hewe.shop.domain.Product;
import hewe.shop.domain.ShopCart;
import hewe.shop.domain.ShopCartItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/config/spring-root.xml")
public class ShopCartTest {
	@Autowired
	private SessionFactory factory;

	@Test
	public void addItem() {

	}

	@Test
	public void addCart() {
		ShopCart cart = new ShopCart();
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		try {
			Product product = ss.get(Product.class, 2);
			// cart = ss.get(ShopCart.class, 1);
			cart.add(product);
			ss.saveOrUpdate(cart);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		} finally {
			ss.close();
		}

	}

	@Test
	public void removeItemTest() {
		ShopCart cart = new ShopCart();
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		try {
			Product product = ss.get(Product.class, 2);
			cart = ss.get(ShopCart.class, 1);
			cart.clear();
			ss.saveOrUpdate(cart);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		} finally {
			ss.close();
		}
	}

	@Test
	public void testClazz() {

		try {
			ShopCartItem item = (ShopCartItem) Class.forName("hewe.shop.domain.ShopCart$ShopCartItem").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void getProduct() {
		Product product = null;
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		try {
			product = ss.get(Product.class, 2);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		} finally {
			ss.close();
		}
		System.out.println(product);
	}
}
