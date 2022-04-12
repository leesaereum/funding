package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;

public class SQApplyCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		String seller_id = request.getParameter("seller_id");
//		String seller_name = request.getParameter("seller_name");
//		String seller_number =request.getParameter("seller_number");
//		String seller_person_name =request.getParameter("seller_person_name");
//		String seller_person_phone = request.getParameter("seller_person_phone");
//		
//		String address_seller = request.getParameter("address_seller");
//		String address_state = request.getParameter("address_state");
//		String address_city = request.getParameter("address_city");
//		String address_line = request.getParameter("address_line");
//
//		FDaoS daoS = new FDaoS();
//		daoS.sQapply(seller_id, seller_name, seller_number, seller_person_name, seller_person_phone
//				, address_seller, address_state, address_city, address_line);
	}

}
