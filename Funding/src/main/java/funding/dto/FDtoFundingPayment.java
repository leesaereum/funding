package funding.dto;

import java.sql.Timestamp;

public class FDtoFundingPayment {

	int payment_num;
	String payment_customer;
	int payment_order;
	int payment_total;
	String payment_way;
	Timestamp payment_At;
	
	public FDtoFundingPayment() {
		// TODO Auto-generated constructor stub
	}

	public FDtoFundingPayment(int payment_num, String payment_customer, int payment_order, int payment_total,
			String payment_way, Timestamp payment_At) {
		super();
		this.payment_num = payment_num;
		this.payment_customer = payment_customer;
		this.payment_order = payment_order;
		this.payment_total = payment_total;
		this.payment_way = payment_way;
		this.payment_At = payment_At;
	}

	public int getPayment_num() {
		return payment_num;
	}

	public void setPayment_num(int payment_num) {
		this.payment_num = payment_num;
	}

	public String getPayment_customer() {
		return payment_customer;
	}

	public void setPayment_customer(String payment_customer) {
		this.payment_customer = payment_customer;
	}

	public int getPayment_order() {
		return payment_order;
	}

	public void setPayment_order(int payment_order) {
		this.payment_order = payment_order;
	}

	public int getPayment_total() {
		return payment_total;
	}

	public void setPayment_total(int payment_total) {
		this.payment_total = payment_total;
	}

	public String getPayment_way() {
		return payment_way;
	}

	public void setPayment_way(String payment_way) {
		this.payment_way = payment_way;
	}

	public Timestamp getPayment_At() {
		return payment_At;
	}

	public void setPayment_At(Timestamp payment_At) {
		this.payment_At = payment_At;
	}
	
	
}
