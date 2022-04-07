package funding.dto;

public class FDtoAddress {
	
	int address_num;
	String address_customer;
	String address_seller;
	String address_state;
	String address_city;
	String address_line;
	
	public FDtoAddress() {
		// TODO Auto-generated constructor stub
	}

	public FDtoAddress(int address_num, String address_customer, String address_seller, String address_state,
			String address_city, String address_line) {
		super();
		this.address_num = address_num;
		this.address_customer = address_customer;
		this.address_seller = address_seller;
		this.address_state = address_state;
		this.address_city = address_city;
		this.address_line = address_line;
	}

	public int getAddress_num() {
		return address_num;
	}

	public void setAddress_num(int address_num) {
		this.address_num = address_num;
	}

	public String getAddress_customer() {
		return address_customer;
	}

	public void setAddress_customer(String address_customer) {
		this.address_customer = address_customer;
	}

	public String getAddress_seller() {
		return address_seller;
	}

	public void setAddress_seller(String address_seller) {
		this.address_seller = address_seller;
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
