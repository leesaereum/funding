package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;
import funding.dto.FDtoNotice;

public class NoticeDetailCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String notice_num = request.getParameter("notice_num");
		FDaoC dao = new FDaoC();
		FDtoNotice dto = dao.notice_detail(notice_num);
		
		request.setAttribute("notice", dto);
	}

}
