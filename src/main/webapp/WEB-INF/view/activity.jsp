<%@ page import="java.util.List" %>
<%@ page import="codeu.model.data.Activity" %>
<%@ page import="codeu.model.data.Conversation" %>
<%@ page import="codeu.model.data.Message" %>
<%@ page import="codeu.model.data.Action" %>
<%@ page import="codeu.model.store.basic.UserStore" %>
<%@ page import="codeu.model.store.basic.ConversationStore" %>
<%@ page import="codeu.model.store.basic.MessageStore" %>
<%@ page import="codeu.model.util.Util" %>
<%@ page import="java.util.UUID" %>

<%
List<Activity> activities = (List<Activity>) request.getAttribute("activities");
%>

<!DOCTYPE html>
<html>
<head>
  <title>ActivityFeed</title>
  <link rel="stylesheet" href="/css/main.css">

  <style>
    #activityfeed {
      background-color: white;
      height: 500px;
      overflow-y: scroll
    }
  </style>

  <script>
    // scroll the activityfeed div to the bottom
    function scrollChat() {
      var chatDiv = document.getElementById('chat');
      chatDiv.scrollTop = chatDiv.scrollHeight;
    };
  </script>

</head>
<body onload="scrollChat()">
  <%@ include file = "/navigations.jsp" %>

    <div id="container">
      <h2 style="color:blue" "text-aligned:left" "margin-bottom:25px"> ACTIVITY </h2>
      <h3> Here's everything that's happened on the site so far! </h3>
        <div id="activityfeed">
          <ul>
            <%
              for (int i = activities.size() -1; i>-1; i--) {
                Activity activity = activities.get(i);
                if(activity.isPublic()) {
                  Action action = activity.getAction();
                  UUID id = activity.getId();
                  UUID idOwnerId = activity.getOwnerId();
                  String time = Util.DateTimeFormatter(activity.getCreationTime());
                  if(action == Action.REGISTER_USER){
                      String name = UserStore.getInstance().getUser(id).getName();%>
                      <li><b><%= time %>:</b> <%= name %> joined CodeByters!</li>
                  <% } %>
                  <% if(action == Action.CREATE_CONV) {
                       String name = UserStore.getInstance().getUser(idOwnerId).getName();
                       Conversation conv = ConversationStore.getInstance().getConversationById(id);%>
                       <li><b><%= time %>:</b> <%= name %> created a new conversation:
                       <a href="/chat/<%= conv.getTitle() %>"> <%= conv.getTitle() %></a>.</li>
                  <% } %>
                  <% if(action == Action.SEND_MESSAGE) {
                       String name = UserStore.getInstance().getUser(idOwnerId).getName();
                       Message mess = MessageStore.getInstance().getMessageById(id);
                       Conversation conv = ConversationStore.getInstance().getConversationById(mess.getConversationId());%>
                       <li><b><%= time %>:</b> <%= name %> sent a message in
                       <a href="/chat/<%= conv.getTitle() %>"> <%= conv.getTitle() %> </a>: "<%= mess.getContent() %>".</li>
                  <% } %>
                <% } %>
            <% } %>
          </ul>
        </div>
    </div>
</body>
</html>