package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import funding.dao.FDaoC;
import funding.dto.FDtoFunding;
import funding.dto.FDtoFundingOption;
import funding.dto.FDtoFundingQuestion;
import funding.dto.FDtoOrder;



public class FundingdetailCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//세션이 필요하다면 활성화하기
//		HttpSession session = request.getSession();
//		Object uID = session.getAttribute("uId"); 

		String funding_num  =request.getParameter("funding_num");
		String customer_id  =request.getParameter("customer_id");
		
		FDaoC dao = new FDaoC();
		
		ArrayList<FDtoFunding> dtos = dao.list(funding_num);
		ArrayList<FDtoFundingOption> optionDtos = dao.optionList(funding_num);
		ArrayList<FDtoFundingQuestion> questionDtos = dao.questionList(funding_num);
		ArrayList<FDtoOrder> orderDtos = dao.orderList(funding_num);
		
		
		request.setAttribute("list", dtos);
		request.setAttribute("optionList", optionDtos);
		request.setAttribute("questionList",questionDtos);
		request.setAttribute("orderList",orderDtos);
		
		
	}

}
