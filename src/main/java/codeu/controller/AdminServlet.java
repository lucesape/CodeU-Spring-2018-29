// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package codeu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codeu.model.store.basic.ConversationStore;
import codeu.model.store.basic.MessageStore;
import codeu.model.store.basic.UserStore;

import codeu.model.data.User;

/** Servlet class responsible for the chat page. */
public class AdminServlet extends HttpServlet {

  /** Store class that gives access to Conversations. */
  private static ConversationStore conversationStore;

  /** Store class that gives access to Messages. */
  private static MessageStore messageStore;

  /** Store class that gives access to Users. */
  private static UserStore userStore;

  /** Set up state for handling data collection for the Admin Page. */
  @Override
  public void init() throws ServletException {
    super.init();
    setConversationStore(ConversationStore.getInstance());
    setMessageStore(MessageStore.getInstance());
    setUserStore(UserStore.getInstance());
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    request.getRequestDispatcher("/WEB-INF/view/admin.jsp").forward(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    String username = (String) request.getSession().getAttribute("user");
    Boolean admin = userStore.getUser(username).isAdmin();
    if (!admin) {
      response.sendRedirect("/index");
      return;
    }
  }

  /**
   * Sets the ConversationStore used by this servlet. This function provides a common setup method
   * for use by the test framework or the servlet's init() function.
   */
  void setConversationStore(ConversationStore conversationStore) {
    AdminServlet.conversationStore = conversationStore;
  }

  /**
   * Sets the MessageStore used by this servlet. This function provides a common setup method for
   * use by the test framework or the servlet's init() function.
   */
  void setMessageStore(MessageStore messageStore) {
    AdminServlet.messageStore = messageStore;
  }

  /**
   * Sets the UserStore used by this servlet. This function provides a common setup method for use
   * by the test framework or the servlet's init() function.
   */
  void setUserStore(UserStore userStore) {
    AdminServlet.userStore = userStore;
  }

  /** Returns Data: the total number of users in the system */
  public static int getTotalUsers() {
    return userStore.getTotalUsers();
  }

  /** Returns Data: the total number of conversations in the system. */
  public static int getTotalConversations() {
    return conversationStore.getTotalConversations();
  }

  /** Returns Data: the total number of messages in the system. */
  public static int getTotalMessages() {
    return messageStore.getTotalMessages();
  }

  public static String getMostActiveUser(){
    User currentMostActive = userStore.getUsers().get(0);
    int currentMostMessages = 0;  
    for(User user: userStore.getUsers()){
      if(messageStore.getNumberOfMessagesByUser(user.getName()) > currentMostMessages){
        currentMostMessages = messageStore.getNumberOfMessagesByUser(user.getName());
        currentMostActive = user;
      } 
    }
    return currentMostActive.getName();
  }
}
