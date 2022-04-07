package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;

public class SSignUpCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String seller_id = request.getParameter("seller_id");
		String seller_pw = request.getParameter("seller_pw");
		String seller_licence =request.getParameter("seller_licence");
		String seller_number =request.getParameter("seller_number");
		String seller_profile = request.getParameter("seller_profile");
		String seller_name = request.getParameter("seller_name");
		String seller_phone = request.getParameter("seller_phone");
		String seller_person_name = request.getParameter("seller_person_name");
		String seller_person_phone = request.getParameter("seller_person_phone");
		
		FDaoS daoS = new FDaoS();
		daoS.ssignUp(seller_id, seller_pw, seller_licence, seller_number, seller_profile, seller_name, seller_phone, 
				seller_person_name, seller_person_phone);
	}

}
