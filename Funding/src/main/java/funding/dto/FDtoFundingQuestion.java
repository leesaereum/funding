package funding.dto;

import java.sql.Timestamp;

public class FDtoFundingQuestion {

	int question_num;
	String question_customer;
	int question_funding;
	String question_seller;
	String question_content;
	String question_funding_title;
	Timestamp question_at;
	String question_state;
	String question_answer;
	Timestamp question_answer_at;
	
	public FDtoFundingQuestion() {
		// TODO Auto-generated constructor stub
	}
	
	public int getQuestion_num() {
		return question_num;
	}
	public void setQuestion_num(int question_num) {
		this.question_num = question_num;
	}
	public String getQuestion_customer() {
		return question_customer;
	}
	public void setQuestion_customer(String question_customer) {
		this.question_customer = question_customer;
	}
	public int getQuestion_funding() {
		return question_funding;
	}
	public void setQuestion_funding(int question_funding) {
		this.question_funding = question_funding;
	}
	public String getQuestion_content() {
		return question_content;
	}
	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}
	public Timestamp getQuestion_at() {
		return question_at;
	}
	public void setQuestion_at(Timestamp question_at) {
		this.question_at = question_at;
	}
	public String getQuestion_state() {
		return question_state;
	}
	public void setQuestion_state(String question_state) {
		this.question_state = question_state;
	}
	public String getQuestion_answer() {
		return question_answer;
	}
	public void setQuestion_answer(String question_answer) {
		this.question_answer = question_answer;
	}
	
	public String getQuestion_seller() {
		return question_seller;
	}

	public void setQuestion_seller(String question_seller) {
		this.question_seller = question_seller;
	}

	public Timestamp getQuestion_answer_at() {
		return question_answer_at;
	}

	public void setQuestion_answer_at(Timestamp question_answer_at) {
		this.question_answer_at = question_answer_at;
	}

	public FDtoFundingQuestion(String question_customer, String question_content,
			Timestamp question_at, String question_answer, Timestamp question_answer_at) {
		super();
		this.question_customer = question_customer;
		this.question_content = question_content;
		this.question_at = question_at;
		this.question_answer = question_answer;
		this.question_answer_at = question_answer_at;
	}

	
	public FDtoFundingQuestion(int question_num,String question_customer,  String question_content
							,Timestamp question_at, String question_state, String question_funding_title) {
		super();
		this.question_num = question_num;
		this.question_customer = question_customer;
		this.question_content = question_content;
		this.question_at = question_at;
		this.question_state = question_state;
		this.question_funding_title = question_funding_title;
	}

	public FDtoFundingQuestion(int question_num, String question_customer, String question_seller,
		 String question_content, String question_state, String question_answer,
			Timestamp question_answer_at) {
		super();
		this.question_num = question_num;
		this.question_customer = question_customer;
		this.question_seller = question_seller;
		this.question_content = question_content;
		this.question_state = question_state;
		this.question_answer = question_answer;
		this.question_answer_at = question_answer_at;
	}

	public FDtoFundingQuestion(int question_num, String question_state, String question_answer,
			Timestamp question_answer_at) {
		super();
		this.question_num = question_num;
		this.question_state = question_state;
		this.question_answer = question_answer;
		this.question_answer_at = question_answer_at;
	}

	public FDtoFundingQuestion(String question_customer,  String question_content, String question_funding_title,
			Timestamp question_at, String question_state, String question_answer, Timestamp question_answer_at, int question_funding) {
		super();
		this.question_customer = question_customer;
		this.question_content = question_content;
		this.question_funding_title = question_funding_title;
		this.question_at = question_at;
		this.question_state = question_state;
		this.question_answer = question_answer;
		this.question_answer_at = question_answer_at;
		this.question_funding = question_funding;
	}

	public String getQuestion_funding_title() {
		return question_funding_title;
	}

	public void setQuestion_funding_title(String question_funding_title) {
		this.question_funding_title = question_funding_title;
	}

	public FDtoFundingQuestion(int question_num, int question_funding, String question_content,
			String question_funding_title, Timestamp question_at, String question_state) {
		super();
		this.question_num = question_num;
		this.question_funding = question_funding;
		this.question_content = question_content;
		this.question_funding_title = question_funding_title;
		this.question_at = question_at;
		this.question_state = question_state;
	}

}
