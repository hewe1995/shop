package hewe.shop.control;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import hewe.shop.domain.Cart;
import hewe.shop.domain.Customer;
import hewe.shop.domain.ItemCart;
import hewe.shop.domain.Product;
import hewe.shop.domain.ShopCart;
import hewe.shop.service.ICartService;
import hewe.shop.service.IProductService;
import hewe.shop.service.IShopCartService;

@Controller
@RequestMapping(path = "/cart")
@SessionAttributes("customer")
public class CartControl {
	private static final Logger log = Logger.getLogger(CartControl.class);

	@Autowired
	private ICartService cartService;
	@Autowired
	private IProductService proService;

	@Autowired
	private IShopCartService cService;

	@RequestMapping(path = "/addToCart/{pid}", method = RequestMethod.GET)
	public String addTocart(@PathVariable int pid, @CookieValue(required = false, value = "userkey") String cookie,
			HttpServletResponse response, ModelMap map) {

		Customer customer = (Customer) map.get("customer");

		log.debug("addToCart:" + pid);
		log.debug("customer:" + customer);
		Product product = null;
		Cookie cook = null;
		ShopCart cart = null;
		ShopCart cookCart = null;
		// 用户标识符
		String uuid = null;

		product = proService.get(pid);
		// 查看商品是否可用
		if (product == null) {
			log.debug("访问的商品已不存在!");
			map.put("message", "访问的商品已不存在!");
			return "error";
		}
		// 获取cookie的购物车
		if (cookie != null && !cookie.equals("")) {
			log.debug("存在cookie:" + cookie);
			uuid = cookie;
			cookCart = cService.getCart(cookie);
			if (cookCart != null) {
				log.debug("存在cook cart:" + cookCart);
				cookCart.add(product);
			}
		} else {
			uuid = UUID.randomUUID().toString();

		}
		if (customer == null) {
			cook = new Cookie("userkey", uuid);
			cook.setPath("/shop/cart/");
			response.addCookie(cook);
		} else {
			cook = new Cookie("userkey", null);
			cook.setMaxAge(0);
			cook.setPath("/shop/cart/");
			response.addCookie(cook);
		}
		// 是否登录
		if (customer == null) {
			// 是否有cookie cart
			if (cookCart == null) {
				// 为空,就创建一个cart并保存
				cookCart = new ShopCart();
				cookCart.setUserkey(uuid);
				cookCart.add(product);
				cService.save(cookCart);
			} else {
				cService.update(cookCart);
			}
		} else {

			// 获取此用户的cart
			cart = cService.getCart(customer.getC_id());
			// 是否有cookie cart
			if (cookCart == null) {
				if (cart == null) {
					// 用户没用cart
					cart = new ShopCart();
					cart.setCcustomer(customer);
					cart.add(product);
					cService.save(cart);
				} else {
					// 用户有cart
					cart.add(product);
					cService.update(cart);
				}
			} else {
				// 不为空
				if (cart == null) {
					// 用户购物车为空,就把cookCart作为用户的购物车
					cookCart.setCcustomer(customer);
					cService.update(cookCart);
				} else {
					// 用户购物车不为空,那就把cookcart 复制到用户购物车中
					cart.putAll(cookCart);
					cService.update(cookCart);
				}
			}

		}

		return "redirect:/addcartsuccess.jsp";
	}

	@RequestMapping(path = "/showCart", method = RequestMethod.GET)
	public String showCart(ModelMap map, @CookieValue(required = false, value = "userkey") String cookie) {
		Customer customer = (Customer) map.get("customer");
		log.debug("customer:" + customer);
		log.debug("cookie:" + cookie);
		// 获取此用户的cart
		ShopCart cart = null;
		ShopCart cookCart = null;
		if (customer != null) {
			cart = cService.getCart(customer.getC_id());

			if (cookie != null && !cookie.equals("")) {
				cookCart = cService.getCart(cookie);
			}
			// 是否有cookie cart
			if (cookCart != null) {
				// 不为空
				if (cart == null) {
					// 用户购物车为空,就把cookCart作为用户的购物车
					cookCart.setCcustomer(customer);
					cart = cookCart;
					cService.update(cookCart);
				} else {
					// 用户购物车不为空,那就把cookcart 复制到用户购物车中
					cart.putAll(cookCart);
					cService.update(cookCart);
				}
			}
		} else {
			if (cookie != null && !cookie.equals("")) {
				cookCart = cService.getCart(cookie);
				cart = cookCart;
			}
		}

		map.put("cart", cart);
		return "cart";
	}

	@RequestMapping(path = "/testAdd/{pid}", method = RequestMethod.GET)
	public String testAddToCart(@PathVariable int pid, @CookieValue(required = false, value = "userkey") String cookie,
			HttpServletResponse response, ModelMap map) {
		log.debug("pid :" + pid);
		log.debug("cookie:" + cookie);
		Cookie cook = null;
		ShopCart cart = null;
		Product product = proService.get(pid);
		if (product == null) {
			map.put("message", "商品不存在");
			return "error";
		}
		if (cookie != null) {
			cart = cService.getCart(cookie);
		}
		String uuid = UUID.randomUUID().toString();
		if (cart == null) {
			cart = new ShopCart();
			cart.setUserkey(uuid);
			cart.add(product);
			cService.save(cart);
		} else {
			cart.add(product);
			cService.update(cart);
		}
		cook = new Cookie("userkey", cart.getUserkey());
		response.addCookie(cook);
		map.put("cart", cart);
		return "forward:/cart/testView";
	}

	@RequestMapping(path = "/testView", method = RequestMethod.GET)
	public String testView() {

		return "testcart";
	}
}
