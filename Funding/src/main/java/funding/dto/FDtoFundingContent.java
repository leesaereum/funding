package funding.dto;

public class FDtoFundingContent {

	int content_num;
	int content_funding;
	int content_numbering;
	String content_content;
	public int getContent_num() {
		return content_num;
	}
	public void setContent_num(int content_num) {
		this.content_num = content_num;
	}
	public int getContent_funding() {
		return content_funding;
	}
	public void setContent_funding(int content_funding) {
		this.content_funding = content_funding;
	}
	public int getContent_numbering() {
		return content_numbering;
	}
	public void setContent_numbering(int content_numbering) {
		this.content_numbering = content_numbering;
	}
	public String getContent_content() {
		return content_content;
	}
	public void setContent_content(String content_content) {
		this.content_content = content_content;
	}
	
	public FDtoFundingContent(int content_num, int content_funding, int content_numbering, String content_content) {
		super();
		this.content_num = content_num;
		this.content_funding = content_funding;
		this.content_numbering = content_numbering;
		this.content_content = content_content;
	}
	
	
	
}
