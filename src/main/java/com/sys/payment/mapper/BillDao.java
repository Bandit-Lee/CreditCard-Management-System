package com.sys.payment.mapper;


import com.sys.payment.entity.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("billDao")
@Mapper
public interface BillDao {
	public List<Bill> selectBillsById(String Id);
	public List<Bill> selectHireBillsById(String Id);
	public Bill selectHireBillByBid(String Bid);
	public void updateBillWay(Bill bill);
}
