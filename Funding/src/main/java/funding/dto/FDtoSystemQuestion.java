package funding.dto;

import java.sql.Timestamp;

public class FDtoSystemQuestion {

	int question_num;
	String question_customer;
	String question_admin;
	String question_title;
	String question_content;
	Timestamp question_at;
	String question_answer;
	Timestamp question_answer_at;
	String question_state;
	int countQuestion;

	public FDtoSystemQuestion() {
	}

	public FDtoSystemQuestion(int question_num, String question_title, Timestamp question_at, String question_state, int countQuestion) {
		super();
		this.question_num = question_num;
		this.question_title = question_title;
		this.question_at = question_at;
		this.question_state = question_state;
		this.countQuestion = countQuestion;
	}
	
	public FDtoSystemQuestion(int question_num, String question_title, Timestamp question_at, String question_state) {
		super();
		this.question_num = question_num;
		this.question_title = question_title;
		this.question_at = question_at;
		this.question_state = question_state;
	}


	public FDtoSystemQuestion(int question_num, String question_customer, String question_title,
			String question_content, Timestamp question_at, String question_state) {
		super();
		this.question_num = question_num;
		this.question_customer = question_customer;
		this.question_title = question_title;
		this.question_content = question_content;
		this.question_at = question_at;
		this.question_state = question_state;
	}

	public FDtoSystemQuestion(int question_num, String question_customer, String question_admin, String question_title,
			String question_content, Timestamp question_at, String question_answer, Timestamp question_answer_at,
			String question_state) {
		super();
		this.question_num = question_num;
		this.question_customer = question_customer;
		this.question_admin = question_admin;
		this.question_title = question_title;
		this.question_content = question_content;
		this.question_at = question_at;
		this.question_answer = question_answer;
		this.question_answer_at = question_answer_at;
		this.question_state = question_state;
	}

	public int getCountQuestion() {
		return countQuestion;
	}

	public void setCountQuestion(int countQuestion) {
		this.countQuestion = countQuestion;
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

	public String getQuestion_admin() {
		return question_admin;
	}

	public void setQuestion_admin(String question_admin) {
		this.question_admin = question_admin;
	}

	public String getQuestion_title() {
		return question_title;
	}

	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
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

	public Timestamp getQuestion_answer_at() {
		return question_answer_at;
	}

	public void setQuestion_answer_at(Timestamp question_answer_at) {
		this.question_answer_at = question_answer_at;
	}

	public FDtoSystemQuestion(int question_num, String question_customer, String question_title,
			String question_content, String question_answer) {
		super();
		this.question_num = question_num;
		this.question_customer = question_customer;
		this.question_title = question_title;
		this.question_content = question_content;
		this.question_answer = question_answer;
	}



	

	

	
	
	
	
}