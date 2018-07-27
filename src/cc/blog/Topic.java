package cc.blog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Topic {
	private int id;
	private String title;
	private String content;
	private String postDate;

	public String getContent() {
		return content;
	}

	public int getId() {
		return id;
	}

	public String getPostDate() {
		return postDate;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String convertToDB() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String rightNow = LocalDateTime.now().format(dtf);
		return rightNow;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", title=" + title + ", content=" + content + ", postDate=" + postDate + "]";
	}
}
