package hewe.shop.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import hewe.shop.domain.Category;
import hewe.shop.domain.Product;
import hewe.shop.service.ICategoryService;
import hewe.shop.service.IProductService;
import hewe.shop.util.model.Page;

public class InitDataListener implements ServletContextListener {
	private ApplicationContext context = null;
	private IProductService productService = null;
	private ICategoryService categoryService = null;

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("-----------------------------");

		context = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
		categoryService = (ICategoryService) context.getBean("categoryService");
		productService = (IProductService) context.getBean("productService");

		// 所有类别
		List<Category> cateList1 = categoryService.queryAll();
		arg0.getServletContext().setAttribute("cateList", cateList1);
		// ---------------------
		// 最近添加的商品
		Page<Product> page = productService.getAllProduct("", 1, 4);
		List<Product> proList = page.getRows();
		arg0.getServletContext().setAttribute("recentProducts", proList);
	}

}
