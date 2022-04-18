package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoS;
import funding.dto.FDtoCalculate;
import funding.dto.FDtoFunding;

public class SMFCApplyCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String funding_num = request.getParameter("funding_num");
		//String funding_seller = request.getParameter(funding_num);
		
		FDaoS daoS = new FDaoS();
		FDtoFunding dto = daoS.calfunding(funding_num);
		String result = daoS.calinf(funding_num);
		request.setAttribute("funding", dto);
		request.setAttribute("cal", result);
		
		System.out.println("funding_num : " + funding_num);
		
		String num = request.getParameter("calculate_num");
		String seller =request.getParameter("funding_seller");
		System.out.println("seller" + seller);
		ArrayList<FDtoCalculate> list = daoS.list(num, funding_num, seller);
		request.setAttribute("list", list);
		daoS.sMFCapply(funding_num,seller);
		
		
	}

}
