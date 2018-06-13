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
import java.util.UUID;

/** Class representing a hashtag. */
public class Hashtag {

  private final UUID id;
  private final UUID ownerId;
  private final Instant creation;
  private final String content;
  private final Boolean createdFromUser;

  /** Constructs a new Hashtag. */
  public Hashtag(UUID id, UUID ownerId, String content, Instant creation, Boolean createdFromUser) {
    this.id = id;
    this.ownerId = ownerId;
    this.content = content;
    this.creation = creation;
    this.createdFromUser = createdFromUser;
  }

  /** Returns the ID of this Hashtag. */
  public UUID getId() {
    return this.id;
  }

  /**
   * Returns the ID of the Owner of this Hashtag. The ownerId refers to the ID of the User when
   * createdFromUser is true; the ownerId refers to the ID of the conversation (not authorID of the
   * conversation) when createdFromUser is false.
   */
  public UUID getOwnerId() {
    return this.ownerId;
  }

  /** Returns the creation time of this Hashtag. */
  public Instant getCreationTime() {
    return this.creation;
  }

  /** Returns the content of this Hashtag. */
  public String getContent() {
    return this.content;
  }

  /** Returns true if the Hashtag was added from a User. */
  public Boolean isCreatedFromUser() {
    return this.createdFromUser;
  }
}
