package funding.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoS;
import funding.dto.FDtoFundingQuestion;

public class SFAnswerCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		FDaoS dao = new FDaoS();
		ArrayList<FDtoFundingQuestion> myfq = dao.myfq(id);
		request.setAttribute("myfq", myfq);
	}

}
