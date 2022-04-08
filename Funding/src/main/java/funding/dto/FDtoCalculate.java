package funding.dto;

import java.sql.Timestamp;

public class FDtoCalculate {

	int calculate_num;
	int calculate_funding;
	String calculate_seller;
	String calculate_admin;
	int calculate_cost;
	Timestamp calculate_At;
	Timestamp calculate_approveAt;
	
	public FDtoCalculate() {
		// TODO Auto-generated constructor stub
	}

	public FDtoCalculate(int calculate_num, int calculate_funding, String calculate_seller, String calculate_admin,
			int calculate_cost, Timestamp calculate_At, Timestamp calculate_approveAt) {
		super();
		this.calculate_num = calculate_num;
		this.calculate_funding = calculate_funding;
		this.calculate_seller = calculate_seller;
		this.calculate_admin = calculate_admin;
		this.calculate_cost = calculate_cost;
		this.calculate_At = calculate_At;
		this.calculate_approveAt = calculate_approveAt;
	}

	public int getCalculate_num() {
		return calculate_num;
	}

	public void setCalculate_num(int calculate_num) {
		this.calculate_num = calculate_num;
	}

	public int getCalculate_funding() {
		return calculate_funding;
	}

	public void setCalculate_funding(int calculate_funding) {
		this.calculate_funding = calculate_funding;
	}

	public String getCalculate_seller() {
		return calculate_seller;
	}

	public void setCalculate_seller(String calculate_seller) {
		this.calculate_seller = calculate_seller;
	}

	public String getCalculate_admin() {
		return calculate_admin;
	}

	public void setCalculate_admin(String calculate_admin) {
		this.calculate_admin = calculate_admin;
	}

	public int getCalculate_cost() {
		return calculate_cost;
	}

	public void setCalculate_cost(int calculate_cost) {
		this.calculate_cost = calculate_cost;
	}

	public Timestamp getCalculate_At() {
		return calculate_At;
	}

	public void setCalculate_At(Timestamp calculate_At) {
		this.calculate_At = calculate_At;
	}

	public Timestamp getCalculate_approveAt() {
		return calculate_approveAt;
	}

	public void setCalculate_approveAt(Timestamp calculate_approveAt) {
		this.calculate_approveAt = calculate_approveAt;
	}
	
	
}
