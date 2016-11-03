package hewe.shop.control;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import hewe.shop.domain.Customer;
import hewe.shop.service.ICustomerService;

@Controller
@RequestMapping(path = "/customer")
@SessionAttributes("customer")
public class CustomerControl {
	private static final Logger log = Logger.getLogger(CustomerControl.class);

	@Autowired
	private ICustomerService cService;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(String loginname, String password, ModelMap map) {
		log.debug("login:" + loginname + " , " + password);

		Customer customer = cService.findCustomer(loginname, password);
		if (customer == null) {
			log.debug("用户不存在");
			map.put("message", "登录失败!!!!!!!!!!!!!!");
			return "loginsuccess";
		}
		map.put("customer", customer);
		map.put("message", "登录成功");
		return "loginsuccess";
	}
}
