<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="/css/main.css">
</head>
<body>
  <nav>
    <a id="navTitle" href="/">CodeByter's Chat App</a>
    <a href="/conversations">Conversations</a>
    <% if (request.getSession().getAttribute("user") != null) { %>
      <a>Hello <%= request.getSession().getAttribute("user") %>!</a>
      <a href="/users/<%= request.getSession().getAttribute("user")%>">My Profile</a>
      <a href="/logout.jsp">Logout</a>
    <% } else { %>
      <a href="/login">Login</a>
    <% } %>
    <a href="/activityfeed">ActivityFeed</a>
    <a href="/about.jsp">About</a>
  </nav>
</body>
</html>