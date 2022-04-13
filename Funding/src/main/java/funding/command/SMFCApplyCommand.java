package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoS;
import funding.dto.FDtoCalculate;

public class SMFCApplyCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String nNUM= (String) session.getAttribute("calculate_num");
		System.out.println("nNUM :" + nNUM);
		
		int num =Integer.parseInt(request.getParameter("calculate_num"));
		int funding =Integer.parseInt(request.getParameter("calculate_funding"));
		String id = request.getParameter("calculate_seller");
		System.out.println("id : "+ id);
		FDaoS daoS = new FDaoS();
		ArrayList<FDtoCalculate> list = daoS.list(nNUM,funding,id);
		request.setAttribute("list", list);
//		daoS.sMFCapply(funding, id);
		
		
		
		
		
	}

}
