package cc.blog;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BlogController {
	private int idCounter;
	private List<Topic> topics = new ArrayList<Topic>();

	private static BlogController controller = new BlogController();

	public static BlogController getInstance() {
		return controller;
	}

	public void postTopic(Topic topic) {
		synchronized (this) {
			topic.setId(idCounter++);
			topic.setPostDate(LocalDateTime.now());
			topics.add(topic);
		}
	}

	public List<Topic> getTopics() {
		return new ArrayList<>(topics);
	}
}
