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
		
	}

}
