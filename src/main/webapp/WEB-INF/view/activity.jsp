<%@ page import="java.util.List" %>
<%@ page import="codeu.model.data.Activity" %>

<%
List<Activity> activities = (List<Activity>) request.getAttribute("activities");
%>

<!DOCTYPE html>
<html>
<head>
  <title>ActivityFeed</title>
  <link rel="stylesheet" href="/css/main.css">
</head>
<body>
  <%@ include file = "/navigations.jsp" %>

  <div id="container">
    <h2 style="color:blue" "text-aligned:left" "margin-bottom:25px"> ACTIVITY </h2>
    <h3> Here's everything that's happened on the site so far! </h3>

    <ul class="mdl-list">
      <% for (Activity activity : activities) { %>
        <li> <%= activity.getAction().name() %> </li>
      <% } %>
    </ul>
  </div>
</body>
</html>
