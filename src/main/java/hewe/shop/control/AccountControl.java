package hewe.shop.control;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hewe.shop.domain.Account;
import hewe.shop.service.IAccountService;

@Controller
@RequestMapping(path = "/account")
public class AccountControl {
	private static final Logger log = Logger.getLogger(AccountControl.class);
	@Autowired
	private IAccountService aservice;

	@RequestMapping(path = "/queryAll", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody List<Account> queryAccount() {
		log.debug("account : queryAll");
		List<Account> list = aservice.queryAll();
		return list;
	}
}
