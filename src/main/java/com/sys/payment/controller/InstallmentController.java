package com.sys.payment.controller;


import com.sys.payment.entity.Bill;
import com.sys.payment.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("payment/")
public class InstallmentController {

	@Autowired
	private BillService billService;

	private static final String PREFIX = "payment/";

	@RequestMapping("installment")
	public String selectHire(HttpServletRequest req,Map<String, Object> map) {
		String id = req.getParameter("Id");
		List<Bill> BillList = billService.selectHireBills(id);
		map.put("billlist", BillList);
		return PREFIX + "Installments";
	}

	@RequestMapping("setinstallment")
	public String setInstallment(HttpServletRequest req,Map<String, Object> map) {
		String bid = req.getParameter("subject");
		Bill Bill = billService.selectBillByBid(bid);
		map.put("bill", Bill);
		return PREFIX + "setInstallment";
	}

	@RequestMapping("confirmInstallment")
	public String confirmInstallment(HttpServletRequest req,Map<String, Object> map) {
		String bid = req.getParameter("subject");
		String way = req.getParameter("test");
		Bill Bill = billService.selectBillByBid(bid);
		Bill.setHway(way);
		billService.updateBillWay(Bill);
		map.put("bill", Bill);
		return PREFIX + "confirmInstallment";
	}

	@RequestMapping("updateInstallment")
	public String selectAlteredHire(HttpServletRequest req,Map<String, Object> map) {
		String id = req.getParameter("Id");
		List<Bill> BillList = billService.selectHireBills(id);
		map.put("billlist", BillList);
		return PREFIX + "Installments";
	}

}
