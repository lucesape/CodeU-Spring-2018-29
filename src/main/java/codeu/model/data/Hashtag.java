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

package codeu.model.data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/** Class representing a Hashtag. */
public class Hashtag {

  private final UUID id;
  private final String content;
  private List<String> userSource;
  private List<String> conversationSource;
  private final Instant creation;

  /** Constructs a new Hashtag. */
  public Hashtag(
      UUID id,
      String content,
      Instant creation,
      List<String> userSource,
      List<String> conversationSource) {
    this.id = id;
    this.content = content.toLowerCase();
    this.creation = creation;
    this.userSource = userSource;
    this.conversationSource = conversationSource;
  }

  /** Returns the ID of this Hashtag. */
  public UUID getId() {
    return this.id;
  }

  /** Returns the creation time of this Hashtag. */
  public Instant getCreationTime() {
    return this.creation;
  }

  /** Returns the content of this Hashtag. */
  public String getContent() {
    return this.content;
  }

  /** Returns the String representation of the users that contain this Hashtag. */
  public String getUserSource() {
    return String.join(",", this.userSource);
  }

  /** Returns the String representation of the conversations that contain this Hashtag. */
  public String getConversationSource() {
    return String.join(",", this.conversationSource);
  }

  /**
   * Add the ID of the user to the userSource. Returns true if the String representation of the User
   * is added; returns false if the String representation of the User exists.
   */
  public boolean addUser(UUID userID) {
    if (userSource.contains(userID.toString())) {
      return false;
    }
    this.userSource.add(userID.toString());
    return true;
  }

  /**
   * Add the ID of the conversation to the conversationSource. Returns true if the String
   * representation of the conversation is added; returns false if the String representation of the
   * conversation exists.
   */
  public boolean addConversation(UUID convID) {
    if (conversationSource.contains(convID.toString())) {
      return false;
    }
    this.conversationSource.add(convID.toString());
    return true;
  }
}
