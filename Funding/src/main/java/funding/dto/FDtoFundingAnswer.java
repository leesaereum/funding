package funding.dto;

import java.sql.Timestamp;

public class FDtoFundingAnswer {

	int answer_num;
	String answer_seller;
	int answer_question;
	String answer_content;
	Timestamp answer_at;
	
	public FDtoFundingAnswer() {
		// TODO Auto-generated constructor stub
	}

	public FDtoFundingAnswer(int answer_num, String answer_seller, int answer_question, String answer_content,
			Timestamp answer_at) {
		super();
		this.answer_num = answer_num;
		this.answer_seller = answer_seller;
		this.answer_question = answer_question;
		this.answer_content = answer_content;
		this.answer_at = answer_at;
	}

	public int getAnswer_num() {
		return answer_num;
	}

	public void setAnswer_num(int answer_num) {
		this.answer_num = answer_num;
	}

	public String getAnswer_seller() {
		return answer_seller;
	}

	public void setAnswer_seller(String answer_seller) {
		this.answer_seller = answer_seller;
	}

	public int getAnswer_question() {
		return answer_question;
	}

	public void setAnswer_question(int answer_question) {
		this.answer_question = answer_question;
	}

	public String getAnswer_content() {
		return answer_content;
	}

	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}

	public Timestamp getAnswer_at() {
		return answer_at;
	}

	public void setAnswer_at(Timestamp answer_at) {
		this.answer_at = answer_at;
	}
	
	
	
}
