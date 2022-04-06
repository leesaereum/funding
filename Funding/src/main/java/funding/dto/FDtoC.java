package funding.dto;

public class FDtoC {

	String customer_id;
	String customer_pw;
	String customer_name;
	String customer_phone;
	String customer_pw_q;
	String customer_pw_a;
	
	
	public FDtoC(){
		
	}
	
	public FDtoC(String customer_id, String customer_pw, String customer_name, String customer_phone, String customer_pw_q, String customer_pw_a) {
		super();
		this.customer_id = customer_id;
		this.customer_pw = customer_pw;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.customer_pw_q = customer_pw_q;
		this.customer_pw_a = customer_pw_a;
	}
	
	public FDtoC(String customer_id, String customer_name, String customer_phone) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
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
	
}
