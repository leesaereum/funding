package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoC;
import funding.dto.FDtoFunding;
import funding.dto.FDtoSystemQuestion;

public class MypageCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesstion = request.getSession();
		String id = (String) sesstion.getAttribute("id");
		
		FDaoC dao = new FDaoC();
		ArrayList<FDtoFunding> myfundinglist = dao.myfundinglist(id);		
		ArrayList<FDtoFunding> mylikelist = dao.mylikelist(id);
		ArrayList<FDtoSystemQuestion> myquestionlist = dao.myquestion_list(id);
		
		request.setAttribute("funding", myfundinglist);
		request.setAttribute("like", mylikelist);
		request.setAttribute("question", myquestionlist);
	}

}
