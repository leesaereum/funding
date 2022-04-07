package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoA;

public class ASQualifyCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Object uID = session.getAttribute("uId");
		String uId = (String)uID;
		
		
		String seller_id = request.getParameter("seller_id");

		
		FDaoA dao = new FDaoA();
		dao.sellerqualify(seller_id);
		

	}

}
