package com.sys.payment.service.impl;


import com.sys.payment.entity.Bill;
import com.sys.payment.mapper.BillDao;
import com.sys.payment.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("billService")
public class BillServiceImpl implements BillService {

	@Autowired
	private BillDao billDao;

	@Override
	public List<Bill> selectBills(String Id) {
		// TODO Auto-generated method stub
		return billDao.selectBillsById(Id);
	}

	@Override
	public List<Bill> selectHireBills(String Id) {
		// TODO Auto-generated method stub
		return billDao.selectHireBillsById(Id);
	}

	@Override
	public Bill selectBillByBid(String Bid) {
		// TODO Auto-generated method stub
		return billDao.selectHireBillByBid(Bid);
	}

	@Override
	public void updateBillWay(Bill bill) {
		// TODO Auto-generated method stub
		billDao.updateBillWay(bill);
	}

}
