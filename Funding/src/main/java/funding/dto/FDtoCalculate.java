package funding.dto;


public class FDtoCalculate {

	int calculate_num;
	int calculate_funding;
	String calculate_seller;
	String calculate_admin;
	int calculate_cost;
	String calculate_state;
	
	public FDtoCalculate() {
		
	}

	public FDtoCalculate(int calculate_num, int calculate_funding, String calculate_seller, int calculate_cost,
			String calculate_state) {
		super();
		this.calculate_num = calculate_num;
		this.calculate_funding = calculate_funding;
		this.calculate_seller = calculate_seller;
		this.calculate_cost = calculate_cost;
		this.calculate_state = calculate_state;
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

	public String getCalculate_state() {
		return calculate_state;
	}

	public void setCalculate_state(String calculate_state) {
		this.calculate_state = calculate_state;
	}
	
}
