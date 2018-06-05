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

package codeu.model.store.basic;

import codeu.model.data.Hashtag;
import codeu.model.store.persistence.PersistentStorageAgent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HashtagStore {

  /** Singleton instance of HashtagStore. */
  private static HashtagStore instance;

  /**
   * Returns the singleton instance of HashtagStore that should be shared between all servlet
   * classes. Do not call this function from a test; use getTestInstance() instead.
   */
  public static HashtagStore getInstance() {
    if (instance == null) {
      instance = new HashtagStore(PersistentStorageAgent.getInstance());
    }
    return instance;
  }

  /**
   * Instance getter function used for testing. Supply a mock for PersistentStorageAgent.
   *
   * @param persistentStorageAgent a mock used for testing
   */
  public static HashtagStore getTestInstance(PersistentStorageAgent persistentStorageAgent) {
    return new HashtagStore(persistentStorageAgent);
  }

  /**
   * The PersistentStorageAgent responsible for loading Users from and saving Users to Datastore.
   */
  private PersistentStorageAgent persistentStorageAgent;

  /** The in-memory list of Hashtags. */
  private List<Hashtag> hashtags;

  /** This class is a singleton, so its constructor is private. Call getInstance() instead. */
  private HashtagStore(PersistentStorageAgent persistentStorageAgent) {
    this.persistentStorageAgent = persistentStorageAgent;
    hashtags = new ArrayList<>();
  }

  /** Add a new Hashtag to the current set of Hashtags known to the applications. */
  public void addHashtag(UUID id, UUID ownerId, String content, Instant creation) {
    Hashtag hashtag = new Hashtag(UUID.randomUUID(), UUID.randomUUID(), content, Instant.now());
    this.hashtags.add(hashtag);
    persistentStorageAgent.writeThrough(hashtag);
  }
}
