package funding.dto;

import java.sql.Timestamp;

public class FDtoOrder {

	int order_num;
	String order_customer;
	int order_funding;
	int order_option;
	int order_price;
	int order_count;
	Timestamp order_At;
	String order_request;
	int order_address;
	String option_name;
	int order_cost;
	
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public String getOrder_customer() {
		return order_customer;
	}
	public void setOrder_customer(String order_customer) {
		this.order_customer = order_customer;
	}
	public int getOrder_funding() {
		return order_funding;
	}
	public void setOrder_funding(int order_funding) {
		this.order_funding = order_funding;
	}
	public int getOrder_option() {
		return order_option;
	}
	public void setOrder_option(int order_option) {
		this.order_option = order_option;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	public Timestamp getOrder_At() {
		return order_At;
	}
	public void setOrder_At(Timestamp order_At) {
		this.order_At = order_At;
	}
	public String getOrder_request() {
		return order_request;
	}
	public void setOrder_request(String order_request) {
		this.order_request = order_request;
	}
	public int getOrder_address() {
		return order_address;
	}
	public void setOrder_address(int order_address) {
		this.order_address = order_address;
	}
	
	
	public String getOption_name() {
		return option_name;
	}
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}
	public FDtoOrder(String order_customer) {
		super();
		this.order_customer = order_customer;
	}
	public FDtoOrder(int order_price, int order_count, Timestamp order_At, String option_name) {
		super();
		this.order_price = order_price;
		this.order_count = order_count;
		this.order_At = order_At;
		this.option_name = option_name;
	}
	public int getOrder_cost() {
		return order_cost;
	}
	public void setOrder_cost(int order_cost) {
		this.order_cost = order_cost;
	}
	public FDtoOrder(String order_customer, Timestamp order_At, int order_cost) {
		super();
		this.order_customer = order_customer;
		this.order_At = order_At;
		this.order_cost = order_cost;
	}

	
}
