package funding.command;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;


public class FundingPaymentCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//
		String order_customer = "abc123";
		int order_funding = 1;
		Integer order_option1 = 1;
		Integer order_price1 = 10000;
		Integer order_count1 = 5;
		Integer order_address = 5;
	
		Integer order_option2 = 2;
		Integer order_price2 = 20000;
		Integer order_count2 = 10;
		
		Integer order_option3 = null;
		Integer order_price3 = null;
		Integer order_count3 = null;
		
		Integer order_option4 = null;
		Integer order_price4 = null;
		Integer order_count4 = null;
		
		Integer order_option5 = null;
		Integer order_price5 = null;
		Integer order_count5 = null;
		
		FDaoC dao = new FDaoC();
		
		
		if (order_option1 != null) {
			dao.OrderInsert(order_customer, order_funding, order_option1, order_price1, order_count1, order_address);
		}
		
		if (order_option2 != null) {
			dao.OrderInsert(order_customer, order_funding, order_option2, order_price2, order_count2, order_address);
		}
		
		if (order_option3 != null) {
			dao.OrderInsert(order_customer, order_funding, order_option3, order_price3, order_count3, order_address);
		}
		
		if (order_option4 != null) {
			dao.OrderInsert(order_customer, order_funding, order_option4, order_price4, order_count4, order_address);
		
}
		if (order_option5 != null) {
			dao.OrderInsert(order_customer, order_funding, order_option5, order_price5, order_count5, order_address);
		
}
		
}
}