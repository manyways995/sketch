package cc.blog;

import cc.blog.linkedDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BlogController2DB {
	private List<Topic> topics = new ArrayList<>();
	private static BlogController2DB controller = null;

	static BlogController2DB getInstance() {
		controller = new BlogController2DB();
		return controller;
	}

	public void postTopic(Topic topic) {
		String sqlUpdate = "INSERT INTO message VALUES(?,?,?,?)";
		try(Connection conn = linkedDB.getConnection();
			PreparedStatement pst = conn.prepareStatement(sqlUpdate)) {
			synchronized (this) {
				pst.setString(2, topic.getTitle());
				pst.setString(3, topic.getContent());
				pst.setString(4, topic.convertToDB());
				pst.executeUpdate();
			}
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}

	public List<Topic> getTopics() {
		String sqlAll = "SELECT * FROM message";
		
		try(Connection conn = linkedDB.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sqlAll)) {
			
			while(rs.next()) {
				Topic topic = new Topic();
				topic.setId(rs.getInt("id"));
				topic.setTitle(rs.getString("title"));
				topic.setContent(rs.getString("content"));
				topic.setPostDate(rs.getString("postDate"));
				topics.add(topic);	
			}
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}			
		return topics;
	}
	
}


