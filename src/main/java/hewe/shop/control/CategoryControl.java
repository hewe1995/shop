package hewe.shop.control;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hewe.shop.domain.Account;
import hewe.shop.domain.Category;
import hewe.shop.service.ICategoryService;
import hewe.shop.util.model.Page;

@Controller
@RequestMapping(path = "/category")
public class CategoryControl {
	private static final Logger log = Logger.getLogger(CategoryControl.class);

	@Autowired
	private ICategoryService cservice;

	@RequestMapping(path = "/view", method = RequestMethod.GET)
	public String view() {
		log.debug("show view");
		return "show_category";
	}

	@RequestMapping(path = "/saveView", method = RequestMethod.GET)
	public String saveView() {
		log.debug("save view");
		return "add_category";
	}

	@RequestMapping(path = "/updateView", method = RequestMethod.GET)
	public String updateView() {
		log.debug("update view");
		return "update_category";
	}

	@RequestMapping(path = "/query", method = RequestMethod.POST)
	public @ResponseBody Page<Category> query(@RequestParam(value = "c_type", required = false) String type,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows) {
		log.debug(this.getClass().getName() + " : query");
		log.debug("type:" + type + "," + "page:" + page + "," + "rows:" + rows);
		Page<Category> pageModel = null;
		if (page == null || rows == null) {
			pageModel = cservice.getAllCategory("", 1, 5);
		} else {
			pageModel = cservice.getAllCategory(type, page, rows);
		}

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageModel;
	}

	@ResponseBody
	@RequestMapping(path = "/deleteByIds", method = RequestMethod.POST)
	public String delete(@RequestParam("ids") String ids) {
		log.debug("delete :" + ids);
		try {
			cservice.deleteCategoryByIds(ids);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

	@ResponseBody
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String add(Category cate) {
		log.debug("category : add");
		log.debug("cate :" + cate.getC_hot() + "," + cate.getC_account().getA_id());

		cservice.save(cate);

		return "true";
	}

	@ResponseBody
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public String update() {
		log.debug("category : update");
		return "true";
	}

	@RequestMapping(path = "/queryAll", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody List<Category> queryAllCategory() {
		log.debug("account : queryAll");
		List<Category> list = cservice.queryAll();
		return list;
	}
}
