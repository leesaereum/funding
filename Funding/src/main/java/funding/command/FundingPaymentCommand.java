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
		

		String order_customer = request.getParameter("order_customer");
		
		int order_funding = Integer.parseInt(request.getParameter("order_funding"));
		
		Integer order_address = Integer.parseInt(request.getParameter("order_address"));
		
		
		FDaoC dao = new FDaoC();
		
		if (request.getParameter("order_option0") != null) {
			
			Integer order_option0 = Integer.parseInt(request.getParameter("order_option0"));
			Integer order_price0 = Integer.parseInt(request.getParameter("order_price0"));
			Integer order_count0 = Integer.parseInt(request.getParameter("order_count0"));
			dao.OrderInsert(order_customer, order_funding, order_option0, order_price0, order_count0, order_address);
}
		
		if (request.getParameter("order_option1") != null) {
			Integer order_option1 = Integer.parseInt(request.getParameter("order_option1"));
			Integer order_price1 = Integer.parseInt(request.getParameter("order_price1"));
			Integer order_count1 = Integer.parseInt(request.getParameter("order_count1"));
			dao.OrderInsert(order_customer, order_funding, order_option1, order_price1, order_count1, order_address);
			
		}
		
		if (request.getParameter("order_option2") != null) {
			Integer order_option2 = Integer.parseInt(request.getParameter("order_option2"));
			Integer order_price2 = Integer.parseInt(request.getParameter("order_price2"));
			Integer order_count2 = Integer.parseInt(request.getParameter("order_count2"));
			dao.OrderInsert(order_customer, order_funding, order_option2, order_price2, order_count2, order_address);
		}
		
		if (request.getParameter("order_option3") != null) {
			Integer order_option3 = Integer.parseInt(request.getParameter("order_option3"));
			Integer order_price3 = Integer.parseInt(request.getParameter("order_price3"));
			Integer order_count3 = Integer.parseInt(request.getParameter("order_count3"));
			dao.OrderInsert(order_customer, order_funding, order_option3, order_price3, order_count3, order_address);
		}
		
		
		if (request.getParameter("order_option4") != null) {
			Integer order_option4 = Integer.parseInt(request.getParameter("order_option4"));
			Integer order_price4 = Integer.parseInt(request.getParameter("order_price4"));
			Integer order_count4 = Integer.parseInt(request.getParameter("order_count4"));
			dao.OrderInsert(order_customer, order_funding, order_option4, order_price4, order_count4, order_address);
		
}

		
}
}