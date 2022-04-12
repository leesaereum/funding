package funding.dto;

import java.sql.Timestamp;

public class FDtoNotice {

	int notice_num;
	String notice_admin;
	String notice_title;
	String notice_content;
	Timestamp notice_At;
	
	public FDtoNotice() {
		
	}
	public FDtoNotice(int notice_num, String notice_admin, String notice_title, Timestamp notice_At) {
		super();
		this.notice_num = notice_num;
		this.notice_admin = notice_admin;
		this.notice_title = notice_title;
		this.notice_At = notice_At;
	}
	public FDtoNotice(int notice_num, String notice_admin, String notice_title, String notice_content,
			Timestamp notice_At) {
		super();
		this.notice_num = notice_num;
		this.notice_admin = notice_admin;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_At = notice_At;
	}

	public FDtoNotice(int notice_num, String notice_title, Timestamp notice_At) {
		super();
		this.notice_num = notice_num;
		this.notice_title = notice_title;
		this.notice_At = notice_At;
	}

	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}

	public String getNotice_admin() {
		return notice_admin;
	}

	public void setNotice_admin(String notice_admin) {
		this.notice_admin = notice_admin;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public Timestamp getNotice_At() {
		return notice_At;
	}

	public void setNotice_At(Timestamp notice_At) {
		this.notice_At = notice_At;
	}
	
	
}
