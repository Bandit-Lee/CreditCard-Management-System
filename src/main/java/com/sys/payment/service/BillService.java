package com.sys.payment.service;



import com.sys.payment.entity.Bill;

import java.util.List;

public interface BillService {
	public List<Bill> selectBills(String Id);
	public List<Bill> selectHireBills(String Id);
	public Bill selectBillByBid(String Bid);
	public void updateBillWay(Bill bill);

}
