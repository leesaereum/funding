package funding.dto;

public class FDtoDelivery {

	int deliver_num;
	int delivery_order;
	String delivery_customer;
	String delivery_address;
	String delivery_name;
	String delivery_phone;
	String delivery_request;
	String delivery_billing;
	String delivery_courier;
	int deliver_address;
	
	public FDtoDelivery() {
		// TODO Auto-generated constructor stub
	}
	
	
	public FDtoDelivery(int deliver_num, int delivery_order, String delivery_customer, String delivery_address,
			String delivery_name, String delivery_phone, String delivery_request, String delivery_billing,
			String delivery_courier, int deliver_address) {
		super();
		this.deliver_num = deliver_num;
		this.delivery_order = delivery_order;
		this.delivery_customer = delivery_customer;
		this.delivery_address = delivery_address;
		this.delivery_name = delivery_name;
		this.delivery_phone = delivery_phone;
		this.delivery_request = delivery_request;
		this.delivery_billing = delivery_billing;
		this.delivery_courier = delivery_courier;
		this.deliver_address = deliver_address;
	}


	public int getDeliver_num() {
		return deliver_num;
	}


	public void setDeliver_num(int deliver_num) {
		this.deliver_num = deliver_num;
	}


	public int getDelivery_order() {
		return delivery_order;
	}


	public void setDelivery_order(int delivery_order) {
		this.delivery_order = delivery_order;
	}


	public String getDelivery_customer() {
		return delivery_customer;
	}


	public void setDelivery_customer(String delivery_customer) {
		this.delivery_customer = delivery_customer;
	}


	public String getDelivery_address() {
		return delivery_address;
	}


	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}


	public String getDelivery_name() {
		return delivery_name;
	}


	public void setDelivery_name(String delivery_name) {
		this.delivery_name = delivery_name;
	}


	public String getDelivery_phone() {
		return delivery_phone;
	}


	public void setDelivery_phone(String delivery_phone) {
		this.delivery_phone = delivery_phone;
	}


	public String getDelivery_request() {
		return delivery_request;
	}


	public void setDelivery_request(String delivery_request) {
		this.delivery_request = delivery_request;
	}


	public String getDelivery_billing() {
		return delivery_billing;
	}


	public void setDelivery_billing(String delivery_billing) {
		this.delivery_billing = delivery_billing;
	}


	public String getDelivery_courier() {
		return delivery_courier;
	}


	public void setDelivery_courier(String delivery_courier) {
		this.delivery_courier = delivery_courier;
	}


	public int getDeliver_address() {
		return deliver_address;
	}


	public void setDeliver_address(int deliver_address) {
		this.deliver_address = deliver_address;
	}
	
	
}
