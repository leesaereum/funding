package funding.dto;

import java.sql.Timestamp;

public class FDtoFundingLike {

	
	int like_num;
	String like_customer;
	int like_funding;
	Timestamp like_At;
	
	public int getLike_num() {
		return like_num;
	}
	public void setLike_num(int like_num) {
		this.like_num = like_num;
	}
	public String getLike_customer() {
		return like_customer;
	}
	public void setLike_customer(String like_customer) {
		this.like_customer = like_customer;
	}
	public int getLike_funding() {
		return like_funding;
	}
	public void setLike_funding(int like_funding) {
		this.like_funding = like_funding;
	}
	public Timestamp getLike_At() {
		return like_At;
	}
	public void setLike_At(Timestamp like_At) {
		this.like_At = like_At;
	}
	
	
	
	public FDtoFundingLike(String like_customer, int like_funding, Timestamp like_At) {
		super();
		this.like_customer = like_customer;
		this.like_funding = like_funding;
		this.like_At = like_At;
	}

	
	
}
