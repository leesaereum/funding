package funding.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funding.dao.FDaoC;
import funding.dao.FDaoS;

public class SFOApplyCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//예시로 넣은 값 get으로 받아올거
		
		String funding_seller = "test@seller.com";
		String funding_banner = "banner";
		String funding_title = "title33";
		
		String String_funding_openAt = "2022-04-07";
		java.sql.Date funding_openAt = java.sql.Date.valueOf(String_funding_openAt);
		
		String String_funding_closeAt = "2022-04-17";
		java.sql.Date funding_closeAt = java.sql.Date.valueOf(String_funding_closeAt);
		
		Integer funding_purpose = 15000000;
		String funding_category = "category";
		Integer funding_fee = 10000;
		

		//funding data insert
	
		FDaoS dao = new FDaoS();
		
		dao.fundingDataInsert(funding_seller, funding_banner, funding_title, funding_openAt, funding_closeAt, funding_purpose, funding_category, funding_fee);
		
		
		//funding num 가져오기
		int funding_num = dao.funding_num(funding_title);
		
		System.out.println(funding_num);

		//funding_content data
		String funding_content = "funding_content, content_content";
		dao.fundingContentInsert(funding_num, funding_content);
	
		
		//option data
		String order_customer = "abc123";
		
		int order_funding = funding_num;

		Integer option_numbering_0 = 0;
		String option_name_0 = "sogogi";
		Integer option_price_0 = 50000;
		Integer option_amount_0 = 20;
		
		Integer option_numbering_1 = 1;
		String option_name_1 = "coke";
		Integer option_price_1 = 1500;
		Integer option_amount_1 = 200;
		
		Integer option_numbering_2 = 2;
		String option_name_2 = "bab";
		Integer option_price_2 = 1000;
		Integer option_amount_2 = 50;
		
		Integer option_numbering_3 = 3;
		String option_name_3 = "pizza";
		Integer option_price_3 = 20000;
		Integer option_amount_3 = 20;
		
		Integer option_numbering_4 = 4;
		String option_name_4 = "salad";
		Integer option_price_4 = 5000;
		Integer option_amount_4 = 50;
		
		Integer option_numbering_5 = null;
		String option_name_5 = null;
		Integer option_price_5 = null;
		Integer option_amount_5 = null;

		
		if (option_numbering_0 != null) {
			dao.optionDataInsert(option_numbering_0, option_name_0, option_price_0, option_amount_0, funding_num);
		}
		if (option_numbering_1 != null) {
			dao.optionDataInsert(option_numbering_1, option_name_1, option_price_1, option_amount_1, funding_num);
		}
		if (option_numbering_2 != null) {
			dao.optionDataInsert(option_numbering_2, option_name_2, option_price_2, option_amount_2, funding_num);
		}
		if (option_numbering_3 != null) {
			dao.optionDataInsert(option_numbering_3, option_name_3, option_price_3, option_amount_3, funding_num);
		}
		if (option_numbering_4 != null) {
			dao.optionDataInsert(option_numbering_4, option_name_4, option_price_4, option_amount_4, funding_num);
		}
		if (option_numbering_5 != null) {
			dao.optionDataInsert(option_numbering_5, option_name_5, option_price_5, option_amount_5, funding_num);
		}
		
	
		
		
		 

	}
	
	
	
	
	
	
	

}
