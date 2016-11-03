package shop.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hewe.shop.domain.Account;
import hewe.shop.domain.Cart;
import hewe.shop.domain.Customer;
import hewe.shop.domain.ItemCart;
import hewe.shop.domain.Product;
import hewe.shop.domain.Student;
import hewe.shop.domain.Teacher;
import hewe.shop.service.IAccountService;
import hewe.shop.service.ICartService;
import hewe.shop.service.ICategoryService;
import hewe.shop.service.ICustomerService;
import hewe.shop.service.IProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/config/spring-root.xml")
public class SpringTest {
	private static final Logger log = Logger.getLogger(SpringTest.class);

	@Resource(name = "categoryService")
	private ICategoryService service;

	@Resource(name = "accountService")
	private IAccountService aservice;

	@Autowired
	private IProductService pService;

	@Autowired
	private ICustomerService cService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private SessionFactory factory;

	@Test
	public void test() {
		log.debug("ttttt");
		Account a = new Account();
		/*
		 * a.setId("test"); a.setLogin("test"); a.setName("ttt");
		 * a.setPassword("pass"); Category c = new Category();
		 * c.setType("ttsete"); c.setAccount(a); service.save(c);
		 */
		System.out.print("test");
	}

	@Test
	public void testQueryCategory() {
		/*
		 * List<Category> list = service.getAllCategory("", 2, 1); for (Category
		 * c : list) { System.out.println(c.getType()); }
		 */
	}

	@Test
	public void testQueryByCid() {
		/*
		 * List<Category> list = service.getAllCategory("", 2, 1); for (Category
		 * c : list) { System.out.println(c.getType()); }
		 */
		List<Product> list = pService.queryByCid(3);
		for (Product p : list) {
			System.out.println(p.getP_name());
		}
	}

	@Test
	public void testCustomer() {
		/*
		 * Customer c = cService.get(1); Cart cart = new Cart();
		 * cart.setC_customer(c); cartService.save(cart);
		 * System.out.println("cart:" + cart.getC_id()); // cService.save(c);
		 */
		Cart cart = new Cart();
		cart.setC_price((float) 0);
		cart.setC_quantity(0);
		Customer customer = new Customer();
		customer.setC_id(1);
		cart.setC_customer(customer);
		cartService.save(cart);
		System.out.println("cart :" + cart.getC_id() + "," + cart.getC_customer().getC_name());
	}

	@Test
	public void testCart() {
		Cart cart = cartService.get(0);

		// Product p = pService.get(2);
		/*
		 * ItemCart item = new ItemCart(p, 2);
		 * cart.setC_price(item.getI_sumprice());
		 * cart.setC_quantity(item.getI_quantity());
		 */
		/*
		 * cart.getC_items().remove(0); cartService.update(cart);
		 */

		/*
		 * Product p = pService.get(2); ItemCart item = new ItemCart(p, 2);
		 */
		cartService.removeItem(cart, "2");

	}

	/**
	 * 测试往购物车添加物品
	 */
	@Test
	public void testCartAdd() {
		/*
		 * Cart cart = cartService.get(0);
		 * 
		 * Product p = pService.get(2); ItemCart item = new ItemCart(p, 2);
		 * 
		 * 
		 * cart.getC_items().remove(0); cartService.update(cart);
		 * 
		 * 
		 * 
		 * Product p = pService.get(2); ItemCart item = new ItemCart(p, 2);
		 * 
		 * // cart.getC_items().put(p.getP_id().toString(), item);
		 * cartService.addItem(cart, item);
		 */
		// 条件: 用户登录(id),参数:商品id
		// 获取购物车
		Cart cart = cartService.getCart(2);
		// 获取产品
		Product product = pService.get(2);
		// 判断是否存在
		ItemCart item = cart.getC_items().get(product.getP_id().toString());
		if (item == null) {
			item = new ItemCart(product);
			cartService.addItem(cart, item);
		} else {
			cartService.changeItem(cart, product.getP_id().toString(), 2);
		}
		//

	}

	@Test
	public void testCartGet() {
		Cart cart = cartService.getCart(2);
		System.out.println("cart :" + cart.getC_price());
	}

	@Test
	public void testStudent() {
		Student s = new Student();
		s.setName("student1");
		Session ss = factory.openSession();
		Transaction t = ss.beginTransaction();
		ss.save(s);
		t.commit();
		ss.close();

	}

	@Test
	public void testTeacher() {
		Teacher t = new Teacher();
		t.setName("teacher1");
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		ss.save(t);
		tr.commit();
		ss.close();

	}

	@Test
	public void testStudentAddTeacher() {
		Student stu = null;
		Teacher t = null;
		Session ss = factory.openSession();
		stu = ss.find(Student.class, 1);
		t = ss.find(Teacher.class, 1);
		if (stu != null && t != null) {
			t.getStudents().add(stu);
			Transaction tr = ss.beginTransaction();
			ss.saveOrUpdate(t);
			tr.commit();
			ss.close();
		}

	}

	@Test
	public void testStudentQueryTeacher() {
		Student stu = null;
		Teacher t = null;
		Session ss = factory.openSession();
		stu = ss.find(Student.class, 1);

		if (stu != null && !stu.getTeachers().isEmpty()) {
			for (Teacher tea : stu.getTeachers()) {
				System.out.println(tea.getName());
			}
		}
		/*
		 * Transaction tr = ss.beginTransaction(); stu.getTeachers().clear();
		 * ss.update(stu); tr.commit(); ss.close();
		 */

	}

	@Test
	public void testTeacherQueryStuden() {
		Student stu = null;
		Teacher t = null;
		Session ss = factory.openSession();
		t = ss.find(Teacher.class, 1);

		if (t != null && !t.getStudents().isEmpty()) {
			for (Student sss : t.getStudents()) {
				System.out.println(sss.getName());
			}
		}
		// Transaction tr = ss.beginTransaction();
		// t.getStudents().clear();
		// ss.update(t);
		// tr.commit();
		ss.close();

	}

	/**
	 * 新建老师,学生,老师插入学生,会进行插入操作并建立联系
	 */
	@Test
	public void testTeacherAddstudent() {
		Teacher t = new Teacher();
		t.setName("teacher5");
		Student s = new Student();
		s.setName("student5");
		t.getStudents().add(s);
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		ss.save(t);
		tr.commit();
		// ss.close();

	}

	/**
	 * 新建学生添加新建的老师,学生能插入,老师会去按id寻找是否存在存在的话,建立关系,不存在,不操作
	 */
	@Test
	public void tesstudenttInsertTeacher() {
		Teacher t = new Teacher();
		t.setName("teacher3");
		Student s = new Student();
		s.setName("student3");
		s.getTeachers().add(t);
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		ss.save(s);
		tr.commit();
		ss.close();

	}

	/**
	 * 测试老师更改学生信息 result: 老师可以改变学生的信息
	 */
	@Test
	public void testTeacherUpdateStuden() {
		Student stu = null;
		Teacher t = null;
		Session ss = factory.openSession();
		t = ss.find(Teacher.class, 3);

		if (t != null && !t.getStudents().isEmpty()) {
			for (Student sss : t.getStudents()) {
				sss.setName("eecheddde1");
			}
		}
		Transaction tr = ss.beginTransaction();

		ss.update(t);
		tr.commit();
		ss.close();
	}

	/**
	 * 测试学生端改变老师信息 可以改变老师的信息
	 */
	@Test
	public void testStudentUpdateTeacher() {
		Student stu = null;
		Teacher t = null;
		Session ss = factory.openSession();
		stu = ss.find(Student.class, 1);

		if (stu != null && !stu.getTeachers().isEmpty()) {
			for (Teacher tea : stu.getTeachers()) {
				tea.setName("tttt111");
			}
		}
		Transaction tr = ss.beginTransaction();
		ss.update(stu);
		tr.commit();
		ss.close();

	}

	/**
	 * 测试删除老师
	 */
	@Test
	public void testTeacherdelete() {
		Student stu = null;
		Teacher t = null;
		Session ss = factory.openSession();
		t = ss.find(Teacher.class, 3);

		if (t != null && !t.getStudents().isEmpty()) {
			for (Student sss : t.getStudents()) {
				sss.setName("teacherChange1");
			}
		}
		Transaction tr = ss.beginTransaction();

		ss.delete(t);
		tr.commit();
		ss.close();
	}

	/**
	 * 测试删除学生
	 */
	@Test
	public void testStudentdelete() {
		Student stu = null;
		Teacher t = null;
		Session ss = factory.openSession();
		stu = ss.find(Student.class, 1);

		if (stu != null && !stu.getTeachers().isEmpty()) {
			for (Teacher tea : stu.getTeachers()) {
				tea.setName("tttt111");
			}
		}
		Transaction tr = ss.beginTransaction();

		ss.delete(stu);
		tr.commit();
		ss.close();
	}
}
