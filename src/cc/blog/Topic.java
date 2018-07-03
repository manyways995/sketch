package cc.blog;

import java.time.LocalDateTime;

public class Topic {
	private int id;
	private String title;
	private String content;
	private LocalDateTime postDate;

	public String getContent() {
		return content;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getPostDate() {
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

	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", title=" + title + ", content=" + content + ", postDate=" + postDate + "]";
	}
}
