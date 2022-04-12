package funding.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funding.dao.FDaoS;

public class SFOApplyCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 예시로 넣은 값 get으로 받아올거

		HttpSession session = request.getSession();
		String funding_seller = (String) session.getAttribute("id");
		String funding_banner = request.getParameter("funding_banner");
		String funding_title = request.getParameter("funding_title");

		String String_funding_openAt = request.getParameter("funding_openAt");
		Date funding_openAt = Date.valueOf(String_funding_openAt);

		String String_funding_closeAt = request.getParameter("funding_closeAt");
		Date funding_closeAt = Date.valueOf(String_funding_closeAt);

		Integer funding_purpose = Integer.parseInt(request.getParameter("funding_purpose"));
		Integer funding_fee = Integer.parseInt(request.getParameter("funding_fee"));

		// funding data insert

		FDaoS dao = new FDaoS();

		dao.fundingDataInsert(funding_seller, funding_banner, funding_title, funding_openAt, funding_closeAt,
				funding_purpose, funding_fee);

		// funding num 가져오기
		int funding_num = dao.funding_num(funding_title);

		System.out.println(funding_num);

		// funding_content data
		String funding_content = request.getParameter("funding_content");
		dao.fundingContentInsert(funding_num, funding_content);

		Integer option_numbering_0 = Integer.parseInt(request.getParameter("option_numbering_0"));
		String option_name_0 = request.getParameter("option_name_0");
		Integer option_price_0 = Integer.parseInt(request.getParameter("option_price_0"));
		Integer option_amount_0 = Integer.parseInt(request.getParameter("option_amount_0"));
		
		if (option_numbering_0 != null) {
			dao.optionDataInsert(option_numbering_0, option_name_0, option_price_0, option_amount_0, funding_num);
		}

		if (request.getParameter("option_name_1") != null) {
			Integer option_numbering_1 = Integer.parseInt(request.getParameter("option_numbering_1"));
			String option_name_1 = request.getParameter("option_name_1");
			Integer option_price_1 = Integer.parseInt(request.getParameter("option_price_1"));
			Integer option_amount_1 = Integer.parseInt(request.getParameter("option_amount_1"));
			
			dao.optionDataInsert(option_numbering_1, option_name_1, option_price_1, option_amount_1, funding_num);

		}

		if (request.getParameter("option_name_2") != null) {
			Integer option_numbering_2 = Integer.parseInt(request.getParameter("option_numbering_2"));
			String option_name_2 = request.getParameter("option_name_2");
			Integer option_price_2 = Integer.parseInt(request.getParameter("option_price_2"));
			Integer option_amount_2 = Integer.parseInt(request.getParameter("option_amount_2"));
			
			dao.optionDataInsert(option_numbering_2, option_name_2, option_price_2, option_amount_2, funding_num);

		}
		if (request.getParameter("option_name_3") != null) {
			Integer option_numbering_3 = Integer.parseInt(request.getParameter("option_numbering_3"));
			String option_name_3 = request.getParameter("option_name_3");
			Integer option_price_3 = Integer.parseInt(request.getParameter("option_price_3"));
			Integer option_amount_3 = Integer.parseInt(request.getParameter("option_amount_3"));
			
			dao.optionDataInsert(option_numbering_3, option_name_3, option_price_3, option_amount_3, funding_num);

		}
		if (request.getParameter("option_name_4") != null) {
			Integer option_numbering_4 = Integer.parseInt(request.getParameter("option_numbering_4"));
			String option_name_4 = request.getParameter("option_name_4");
			Integer option_price_4 = Integer.parseInt(request.getParameter("option_price_4"));
			Integer option_amount_4 = Integer.parseInt(request.getParameter("option_amount_4"));
			
			dao.optionDataInsert(option_numbering_4, option_name_4, option_price_4, option_amount_4, funding_num);

		}

	}

}
