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
	String funding_categori;
	String funding_state;
	int funding_fee;
	
	public FDtoFunding() {
		
	}

	public FDtoFunding(int funding_num, String funding_seller, String funding_title, Timestamp funding_openAt,
			Timestamp funding_closeAt) {
		super();
		this.funding_num = funding_num;
		this.funding_seller = funding_seller;
		this.funding_title = funding_title;
		this.funding_openAt = funding_openAt;
		this.funding_closeAt = funding_closeAt;
		// TODO Auto-generated constructor stub
	}

	public FDtoFunding(int funding_num, String funding_seller, String funding_banner, String funding_title,
			Timestamp funding_createAt, Timestamp funding_deleteAt, Timestamp funding_openAt, Timestamp funding_closeAt,
			int funding_purpose, int funding_hits, String funding_categori, String funding_state, int funding_fee) {
		super();
		this.funding_num = funding_num;
		this.funding_seller = funding_seller;
		this.funding_banner = funding_banner;
		this.funding_title = funding_title;
		this.funding_createAt = funding_createAt;
		this.funding_deleteAt = funding_deleteAt;
		this.funding_openAt = funding_openAt;
		this.funding_closeAt = funding_closeAt;
		this.funding_purpose = funding_purpose;
		this.funding_hits = funding_hits;
		this.funding_categori = funding_categori;
		this.funding_state = funding_state;
		this.funding_fee = funding_fee;
	}

	public int getFunding_num() {
		return funding_num;
	}

	public void setFunding_num(int funding_num) {
		this.funding_num = funding_num;
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

	public String getFunding_categori() {
		return funding_categori;
	}

	public void setFunding_categori(String funding_categori) {
		this.funding_categori = funding_categori;
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
	
}
