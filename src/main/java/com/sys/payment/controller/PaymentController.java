package com.sys.payment.controller;


import com.sys.payment.entity.Bill;
import com.sys.payment.entity.MyUser;
import com.sys.payment.service.BillService;
import com.sys.payment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("payment/")
public class PaymentController {

	@Autowired
	private BillService billService;
	@Autowired
	private UserService userService;

	private static final String PREFIX = "payment/";

	@RequestMapping("payments")
	public String select(HttpServletRequest req,Map<String, Object> map) {
		String id = req.getParameter("Id");
		List<Bill> BillList = billService.selectBills(id);
		MyUser User = userService.selectUser(id);
		map.put("billlist", BillList);
		map.put("user", User);
		return PREFIX + "payments";
	}

	@RequestMapping("yearpayments")
	public String selectyear(HttpServletRequest req,Map<String, Object> map) {
		String id = req.getParameter("Id");
		List<Bill> BillList = billService.selectBills(id);
		map.put("billlist", BillList);
		return PREFIX + "yearPayments";
	}

	@RequestMapping("index")
	public String index() {
		return PREFIX + "index";
	}


}
