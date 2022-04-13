package funding.dto;

import java.sql.Timestamp;

public class FDtoFunding {

	int funding_num;
	String funding_seller;
	String funding_banner;
	String funding_title;
	Timestamp funding_createAt;
	Timestamp funding_deleteAt;
	Timestamp funding_openAt;
	Timestamp funding_closeAt;
	int funding_purpose;
	int funding_hits;
	String funding_state;
	int funding_fee;
	int funding_achievement;
	int total;
	int count;
	String seller_name;
	String seller_profile;
	
	
	//funding_content 태이블에 있는건데 같이 받기 위해서 가져왔습니다.
	String content_content;
//	String option_name;
//	int option_price;
//	int option_amount;
	
	int order_num;
	public FDtoFunding() {
	}

	
	public FDtoFunding(int funding_num, String funding_title, int total) {
		super();
		this.funding_num = funding_num;
		this.funding_title = funding_title;
		this.total = total;
	}


	public FDtoFunding(int funding_num, String funding_seller, String funding_banner, String funding_title, Timestamp funding_createAt, Timestamp funding_deleteAt, Timestamp funding_openAt, Timestamp funding_closeAt, int funding_purpose, int funding_hits, String funding_state, int funding_fee) {
		
		this.funding_num = funding_num;
	}
	
	
	public FDtoFunding(String funding_seller, String funding_banner, String funding_title,
			 Timestamp funding_openAt, Timestamp funding_closeAt,
			int funding_purpose, int funding_hits, String funding_state, int funding_fee) {
		super();
		this.funding_seller = funding_seller;
		this.funding_banner = funding_banner;
		this.funding_title = funding_title;
		this.funding_openAt = funding_openAt;
		this.funding_closeAt = funding_closeAt;
		this.funding_purpose = funding_purpose;
		this.funding_hits = funding_hits;
		this.funding_state = funding_state;
		this.funding_fee = funding_fee;
		
	}
	

	public FDtoFunding(int funding_num, String funding_seller, String funding_title, String funding_state) {
		super();
		this.funding_num = funding_num;
		this.funding_seller = funding_seller;
		this.funding_title = funding_title;
		this.funding_state = funding_state;
	}

	public int getFunding_num() {
		return funding_num;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}

	public void setFunding_num(int funding_num) {
		this.funding_num = funding_num;
	}

	public String getSeller_profile() {
		return seller_profile;
	}


	public void setSeller_profile(String seller_profile) {
		this.seller_profile = seller_profile;
	}


	public String getFunding_seller() {
		return funding_seller;
	}

	public void setFunding_seller(String funding_seller) {
		this.funding_seller = funding_seller;
	}

	public String getFunding_banner() {
		return funding_banner;
	}

	public void setFunding_banner(String funding_banner) {
		this.funding_banner = funding_banner;
	}

	public String getFunding_title() {
		return funding_title;
	}

	public void setFunding_title(String funding_title) {
		this.funding_title = funding_title;
	}

	public Timestamp getFunding_createAt() {
		return funding_createAt;
	}

	public void setFunding_createAt(Timestamp funding_createAt) {
		this.funding_createAt = funding_createAt;
	}

	public Timestamp getFunding_deleteAt() {
		return funding_deleteAt;
	}

	public void setFunding_deleteAt(Timestamp funding_deleteAt) {
		this.funding_deleteAt = funding_deleteAt;
	}

	public Timestamp getFunding_openAt() {
		return funding_openAt;
	}

	public void setFunding_openAt(Timestamp funding_openAt) {
		this.funding_openAt = funding_openAt;
	}

	public Timestamp getFunding_closeAt() {
		return funding_closeAt;
	}

	public void setFunding_closeAt(Timestamp funding_closeAt) {
		this.funding_closeAt = funding_closeAt;
	}

	public int getFunding_purpose() {
		return funding_purpose;
	}

	public void setFunding_purpose(int funding_purpose) {
		this.funding_purpose = funding_purpose;
	}

	public int getFunding_hits() {
		return funding_hits;
	}

	public void setFunding_hits(int funding_hits) {
		this.funding_hits = funding_hits;
	}

	public String getFunding_state() {
		return funding_state;
	}

	public void setFunding_state(String funding_state) {
		this.funding_state = funding_state;
	}

	public int getFunding_fee() {
		return funding_fee;
	}

	public void setFunding_fee(int funding_fee) {
		this.funding_fee = funding_fee;
	}

	public String getContent_content() {
		return content_content;
	}

	public void setContent_content(String content_content) {
		this.content_content = content_content;
	}
	
	public FDtoFunding(int funding_num, String funding_seller, String funding_title,
			 Timestamp funding_openAt, Timestamp funding_closeAt,
			int funding_purpose, int funding_hits, String funding_state, int funding_fee) {
		super();
		this.funding_num = funding_num;
		this.funding_seller = funding_seller;
		this.funding_title = funding_title;
		this.funding_openAt = funding_openAt;
		this.funding_closeAt = funding_closeAt;
		this.funding_purpose = funding_purpose;
		this.funding_hits = funding_hits;
		this.funding_state = funding_state;
		this.funding_fee = funding_fee;
	}

	
	
	

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getFunding_achievement() {
		return funding_achievement;
	}

	public void setFunding_achievement(int funding_achievement) {
		this.funding_achievement = funding_achievement;
	}

	public FDtoFunding(String funding_title, Timestamp funding_openAt, Timestamp funding_closeAt, int funding_purpose,
			String content_content, String funding_banner) {
		super();
		this.funding_title = funding_title;
		this.funding_openAt = funding_openAt;
		this.funding_closeAt = funding_closeAt;
		this.funding_purpose = funding_purpose;
		this.content_content = content_content;
		this.funding_banner = funding_banner;
	}


	public FDtoFunding(int funding_num, String funding_seller, String funding_title, Timestamp funding_openAt,
			Timestamp funding_closeAt) {
		super();
		this.funding_num = funding_num;
		this.funding_seller = funding_seller;
		this.funding_title = funding_title;
		this.funding_openAt = funding_openAt;
		this.funding_closeAt = funding_closeAt;
	}

	public FDtoFunding(int funding_num, String funding_title,
			Timestamp funding_openAt,Timestamp funding_closeAt, String funding_state) {
		super();
		this.funding_num = funding_num;
		this.funding_title = funding_title;
		this.funding_openAt = funding_openAt;
		this.funding_closeAt = funding_closeAt;
		this.funding_state = funding_state;
	}
	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public FDtoFunding(int funding_num, String funding_seller, String funding_title, Timestamp funding_openAt,
			Timestamp funding_closeAt, String funding_state, int order_num) {
		super();
		this.funding_num = funding_num;
		this.funding_seller = funding_seller;
		this.funding_title = funding_title;
		this.funding_openAt = funding_openAt;
		this.funding_closeAt = funding_closeAt;
		this.funding_state = funding_state;
		this.order_num = order_num;
	}

	public FDtoFunding(int funding_num, String funding_seller, String funding_banner, String funding_title,
			Timestamp funding_openAt, Timestamp funding_closeAt, String funding_state, int funding_achievement, int total) {
		super();
		this.funding_num = funding_num;
		this.funding_seller = funding_seller;
		this.funding_banner = funding_banner;
		this.funding_title = funding_title;
		this.funding_openAt = funding_openAt;
		this.funding_closeAt = funding_closeAt;
		this.funding_state = funding_state;
		this.funding_achievement = funding_achievement;
		this.total = total;
	}

	public FDtoFunding(String funding_banner, String funding_seller, String funding_title, Timestamp funding_openAt, Timestamp funding_closeAt,
			int funding_purpose, int funding_achievement, int total, String content_content, int count, int funding_num, String seller_profile) {
		super();
		this.funding_banner = funding_banner;
		this.funding_seller = funding_seller;
		this.funding_title = funding_title;
		this.funding_openAt = funding_openAt;
		this.funding_closeAt = funding_closeAt;
		this.funding_purpose = funding_purpose;
		this.funding_achievement = funding_achievement;
		this.total = total;
		this.content_content = content_content;
		this.count = count;
		this.funding_num = funding_num;
		this.seller_profile = seller_profile;
	}



	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	public FDtoFunding(int funding_num, String funding_banner, String funding_title, Timestamp funding_openAt,
			Timestamp funding_closeAt, int funding_purpose, int funding_fee) {
		super();
		this.funding_num = funding_num;
		this.funding_banner = funding_banner;
		this.funding_title = funding_title;
		this.funding_openAt = funding_openAt;
		this.funding_closeAt = funding_closeAt;
		this.funding_purpose = funding_purpose;
		this.funding_fee = funding_fee;
//		this.content_content = content_content;
	}
	
}



