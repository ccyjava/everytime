package cn.edu.pku.everytime.model;

public class Memo {
	String content;
	String date;

	public Memo(String content, String date) {
		super();
		this.content = content;
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
