package hewe.shop.control;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/admin")
public class AdminControl {

	private static final Logger log = Logger.getLogger(AdminControl.class);

	@RequestMapping(path = "/view", method = RequestMethod.GET)
	public String view() {
		log.debug("show aindex");
		return "aindex";
	}

}
