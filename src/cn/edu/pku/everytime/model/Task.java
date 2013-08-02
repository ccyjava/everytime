package cn.edu.pku.everytime.model;

public class Task {
	String title;
	String content;
	double importance;
	double complate;

	public Task(String title, String content, double importance, double complate) {
		super();
		this.title = title;
		this.content = content;
		this.importance = importance;
		this.complate = complate;
	}

	public Task() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getImportance() {
		return importance;
	}

	public void setImportance(double importance) {
		this.importance = importance;
	}

	public double getComplate() {
		return complate;
	}

	public void setComplate(double complate) {
		this.complate = complate;
	}

}
