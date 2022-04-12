package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoS;
import funding.dto.FDtoFunding;
import funding.dto.FDtoFundingContent;
import funding.dto.FDtoFundingOption;

public class SMFDetailCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String funding_num =request.getParameter("funding_num");
		FDaoS daoS = new FDaoS();
		FDtoFunding dto = daoS.selectDetail(funding_num);
		request.setAttribute("Mfunding", dto);
		
		ArrayList<FDtoFundingOption> options = daoS.selectOption(funding_num);
		//System.out.println(options.get(0).getOption_name());
		request.setAttribute("Mfunding_options", options);
		
		
		FDtoFundingContent dto1 = daoS.selectDetail1(funding_num);
		request.setAttribute("Mfunding1", dto1);
		
		String banner = request.getParameter("funding_banner");
		String title= request.getParameter("funding_title");
		String openAt = request.getParameter("funding_openAt");
		String closeAt = request.getParameter("funding_closeAt");
		int purpose = Integer.parseInt(request.getParameter("funding_purpose"));
		int fee = Integer.parseInt(request.getParameter("funding_fee"));
		daoS.modifySelectDetail(funding_num, banner, title, openAt, closeAt, purpose, fee);
		
		String name = request.getParameter("option_name");
		int price = Integer.parseInt(request.getParameter("option_price"));
		int amount = Integer.parseInt(request.getParameter("option_amount"));
		daoS.modifySelectDetail1(funding_num,name,price,amount);
		
		String content = request.getParameter("content_content");
		daoS.modifySelectDetail2(funding_num,content);
		
	}

}
