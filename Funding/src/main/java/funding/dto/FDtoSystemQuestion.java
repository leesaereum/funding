package funding.dto;

import java.sql.Timestamp;

public class FDtoSystemQuestion {

	int question_num;
	String question_customer;
	String question_admin;
	String question_title;
	String question_content;
	Timestamp question_at;
	String question_state;

	public FDtoSystemQuestion() {
	}

	public FDtoSystemQuestion(int question_num, String question_title, Timestamp question_at, String question_state) {
		super();
		this.question_num = question_num;
		this.question_title = question_title;
		this.question_at = question_at;
		this.question_state = question_state;
	}
	
}