package funding.dto;

public class FDtoSeller {

	String seller_id;
	String seller_pw;
	String seller_license;
	String seller_number;
	String seller_profile;
	String seller_name;
	String seller_phone;
	String seller_person_name;
	String seller_person_phone;
	String seller_state;
	
	public FDtoSeller() {
		
	}
	
	
	public FDtoSeller(String seller_id, String seller_pw, String seller_license, String seller_number, String seller_profile, String seller_name, String seller_phone, String seller_person_name, String seller_person_phone, String seller_state) {
		
		this.seller_id = seller_id;
		this.seller_pw = seller_pw;
		this.seller_license = seller_license;
		this.seller_number = seller_number;
		this.seller_profile = seller_profile;
		this.seller_name = seller_name;
		this.seller_phone = seller_phone;
		this.seller_person_name = seller_person_name;
		this.seller_person_phone = seller_person_phone;
		this.seller_state = seller_state;
	}
	
	public FDtoSeller(String seller_id, String seller_license, String seller_number, String seller_profile, String seller_name, String seller_phone, String seller_person_name, String seller_person_phone, String seller_state) {
		
		this.seller_id = seller_id;
		this.seller_license = seller_license;
		this.seller_number = seller_number;
		this.seller_profile = seller_profile;
		this.seller_name = seller_name;
		this.seller_phone = seller_phone;
		this.seller_person_name = seller_person_name;
		this.seller_person_phone = seller_person_phone;
		this.seller_state = seller_state;
	}


	public String getSeller_id() {
		return seller_id;
	}


	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}


	public String getSeller_pw() {
		return seller_pw;
	}


	public void setSeller_pw(String seller_pw) {
		this.seller_pw = seller_pw;
	}


	public String getSeller_license() {
		return seller_license;
	}


	public void setSeller_license(String seller_license) {
		this.seller_license = seller_license;
	}


	public String getSeller_number() {
		return seller_number;
	}


	public void setSeller_number(String seller_number) {
		this.seller_number = seller_number;
	}


	public String getSeller_profile() {
		return seller_profile;
	}


	public void setSeller_profile(String seller_profile) {
		this.seller_profile = seller_profile;
	}


	public String getSeller_name() {
		return seller_name;
	}


	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}


	public String getSeller_phone() {
		return seller_phone;
	}


	public void setSeller_phone(String seller_phone) {
		this.seller_phone = seller_phone;
	}


	public String getSeller_person_name() {
		return seller_person_name;
	}


	public void setSeller_person_name(String seller_person_name) {
		this.seller_person_name = seller_person_name;
	}


	public String getSeller_person_phone() {
		return seller_person_phone;
	}


	public void setSeller_person_phone(String seller_person_phone) {
		this.seller_person_phone = seller_person_phone;
	}


	public String getSeller_state() {
		return seller_state;
	}


	public void setSeller_state(String seller_state) {
		this.seller_state = seller_state;
	}
	

}




