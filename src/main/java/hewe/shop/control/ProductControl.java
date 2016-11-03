package hewe.shop.control;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import hewe.shop.domain.Product;
import hewe.shop.service.IProductService;
import hewe.shop.util.model.IImageUpload;
import hewe.shop.util.model.Page;

@Controller
@RequestMapping(path = "/product")
public class ProductControl {

	@Autowired
	private IImageUpload imageUpload;

	private static final Logger log = Logger.getLogger(ProductControl.class);

	@Autowired
	private IProductService pService;

	@RequestMapping(path = "/view", method = { RequestMethod.GET, RequestMethod.POST })
	public String view() {
		return "show_product";
	}

	@RequestMapping(path = "/saveView", method = RequestMethod.GET)
	public String saveView() {
		log.debug("save view");
		return "add_product";
	}

	@RequestMapping(path = "/updateView", method = RequestMethod.GET)
	public String updateView() {
		log.debug("update view");
		return "update_product";
	}

	@RequestMapping(path = "/query", method = RequestMethod.POST)
	public @ResponseBody Page<Product> query(@RequestParam(value = "p_name", required = false) String name,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows) {
		log.debug(this.getClass().getName() + " : query");
		log.debug("name:" + name + "," + "page:" + page + "," + "rows:" + rows);
		Page<Product> pageModel = null;
		if (page == null || rows == null) {
			pageModel = pService.getAllProduct("", 1, 5);
		} else {
			pageModel = pService.getAllProduct(name, page, rows);
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
			pService.deleteProductByIds(ids);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

	@ResponseBody
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String add(@RequestParam("imagefile") MultipartFile image, Product product) {
		log.debug("filename :" + image.getOriginalFilename());
		log.debug("product :" + product.getP_name());
		String name = imageUpload.upload(image);
		product.setP_pic(name);
		product.setP_date(new Date());
		pService.save(product);
		return "true";
	}

	@RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
	public String getById(@PathVariable String id,ModelMap map) {
		log.debug("get :" + id);
		int findId;
		try {
			findId = Integer.parseInt(id);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "访问错误!");
			return "error";
		}
		Product product = pService.get(findId);
		if (product ==null) {
			map.put("message", "访问的商品已不存在!");
			return "error";
		}
		map.put("product", product);
		return "detail";
	}
}
