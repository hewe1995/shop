package hewe.shop.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hewe.shop.domain.Category;
import hewe.shop.service.ICategoryService;

@Controller
public class TestControl {

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String test() {
		System.out.println("test controller");
		return "test";
	}

	@RequestMapping(path = "/test1", method = RequestMethod.POST)
	public @ResponseBody List<Category> list() {
		// List<Category> list = categoryService.getAllCategory("", 1, 2);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(path = "/testform", method = RequestMethod.POST)
	public String testForm() {
		
		
		return "test";
	}
}
