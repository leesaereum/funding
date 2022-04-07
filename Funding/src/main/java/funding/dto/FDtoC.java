package funding.dto;

public class FDtoC {

	String customer_id;
	String customer_pw;
	String customer_name;
	String customer_phone;
	String customer_pw_q;
	String customer_pw_a;
	
	
	String address_state;
	String address_city;
	String address_line;
	
	
	
	
	public FDtoC(){
		
	}
	
	public FDtoC(String customer_id, String customer_pw, String customer_name, String customer_phone, String customer_pw_q, String customer_pw_a, String address_state, String address_city, String address_line) {
		super();
		this.customer_id = customer_id;
		this.customer_pw = customer_pw;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.customer_pw_q = customer_pw_q;
		this.customer_pw_a = customer_pw_a;
		
		this.address_state = address_state;
		this.address_city = address_city;
		this.address_line = address_line;
	}
	
	public FDtoC(String customer_id, String customer_name, String customer_phone, String address_state, String address_city, String address_line) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		
		this.address_state = address_state;
		this.address_city = address_city;
		this.address_line = address_line;
		
	}

	public FDtoC(String customer_id, String customer_name) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_pw() {
		return customer_pw;
	}

	public void setCustomer_pw(String customer_pw) {
		this.customer_pw = customer_pw;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getCustomer_pw_q() {
		return customer_pw_q;
	}

	public void setCustomer_pw_q(String customer_pw_q) {
		this.customer_pw_q = customer_pw_q;
	}

	public String getCustomer_pw_a() {
		return customer_pw_a;
	}

	public void setCustomer_pw_a(String customer_pw_a) {
		this.customer_pw_a = customer_pw_a;
	}

	public String getAddress_state() {
		return address_state;
	}

	public void setAddress_state(String address_state) {
		this.address_state = address_state;
	}

	public String getAddress_city() {
		return address_city;
	}

	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}

	public String getAddress_line() {
		return address_line;
	}

	public void setAddress_line(String address_line) {
		this.address_line = address_line;
	}
}

	