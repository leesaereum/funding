package funding.dto;

import java.sql.Timestamp;

public class FDtoFundingReview {

	int review_num;
	String review_customer;
	int review_funding;
	String review_title;
	String review_content;
	Timestamp review_at;
	int review_rate;
	
	public FDtoFundingReview() {
		// TODO Auto-generated constructor stub
	}
	
	public FDtoFundingReview(int review_num, String review_customer, int review_funding, String review_title,
			String review_content, Timestamp review_at, int review_rate) {
		super();
		this.review_num = review_num;
		this.review_customer = review_customer;
		this.review_funding = review_funding;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_at = review_at;
		this.review_rate = review_rate;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public String getReview_customer() {
		return review_customer;
	}

	public void setReview_customer(String review_customer) {
		this.review_customer = review_customer;
	}

	public int getReview_funding() {
		return review_funding;
	}

	public void setReview_funding(int review_funding) {
		this.review_funding = review_funding;
	}

	public String getReview_title() {
		return review_title;
	}

	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public Timestamp getReview_at() {
		return review_at;
	}

	public void setReview_at(Timestamp review_at) {
		this.review_at = review_at;
	}

	public int getReview_rate() {
		return review_rate;
	}

	public void setReview_rate(int review_rate) {
		this.review_rate = review_rate;
	}
	
}
