package funding.command;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;

public class SMFDetailModifyCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String funding_num =request.getParameter("funding_num");
		FDaoS daoS = new FDaoS();
		
		String banner = request.getParameter("funding_banner");
		String title= request.getParameter("funding_title");
		String openAt = request.getParameter("funding_openAt");
		String closeAt = request.getParameter("funding_closeAt");
		String purpose = request.getParameter("funding_purpose");
		String fee= request.getParameter("funding_fee");
		daoS.modifySelectDetail(funding_num, banner, title, openAt, closeAt, purpose, fee);
		
		String name = request.getParameter("option_name");
		String price = request.getParameter("option_price");
		String amount = request.getParameter("option_amount");
		daoS.modifySelectDetail1(funding_num,name,price,amount);
		
		String content = request.getParameter("content_content");
		daoS.modifySelectDetail2(funding_num,content);
		
	}

}
