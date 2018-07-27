<%@page import="cc.blog.Topic"%>
<%@page import="java.util.List, java.util.Iterator, java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mainview here</title>
</head>
<body>
	<%=LocalDateTime.now()%>
	<form action="posts.do" method="POST" name="message">
		subject <input type="text" name="title" size="50"> <br>
		<textarea name="content" rows="5" cols="50"></textarea>
		<br> 
		<input type="submit" value="Submit">
		<a href="reads.do">show up</a>
	</form>
	
	<%
		// SERVER 重啟時 scriptlet 剪貼重跑
		// 應該要用 Bean
		List<Topic> topics = (List<Topic>) request.getAttribute("topics");
		//int get = topics.size();
		for (int ibot = 0; ibot < topics.size(); ibot++) {
			Topic topic = (Topic) topics.get(ibot);
			
	%>
			<hr>
			#<%= topic.getId() %>
			subject
			<%= topic.getTitle() %>
			(<%= topic.getPostDate() %>)
			<pre><%= topic.getContent() %></pre>
	<%
		}
	%>	
	
</body>
</html>