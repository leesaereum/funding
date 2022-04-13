package funding.dto;

public class FDtoFundingOption {

	int option_num;
	int option_funding;
	int option_numbering;
	String option_name;
	int option_price;
	int option_amount;
	
	public int getOption_num() {
		return option_num;
	}
	public void setOption_num(int option_num) {
		this.option_num = option_num;
	}
	public int getOption_funding() {
		return option_funding;
	}
	public void setOption_funding(int option_funding) {
		this.option_funding = option_funding;
	}
	public int getOption_numbering() {
		return option_numbering;
	}
	public void setOption_numbering(int option_numbering) {
		this.option_numbering = option_numbering;
	}
	public String getOption_name() {
		return option_name;
	}
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}
	public int getOption_price() {
		return option_price;
	}
	public void setOption_price(int option_price) {
		this.option_price = option_price;
	}
	public int getOption_amount() {
		return option_amount;
	}
	public void setOption_amount(int option_amount) {
		this.option_amount = option_amount;
	}
	
	
	public FDtoFundingOption(int option_num, String option_name, int option_price, int option_amount) {
		super();
		this.option_num = option_num;
		this.option_name = option_name;
		this.option_price = option_price;
		this.option_amount = option_amount;
	}
	public FDtoFundingOption(int option_num, int option_numbering, String option_name, int option_price,
			int option_amount) {
		super();
		this.option_num = option_num;
		this.option_numbering = option_numbering;
		this.option_name = option_name;
		this.option_price = option_price;
		this.option_amount = option_amount;
	}
	
	
	
	
}
