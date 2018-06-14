package codeu.model.store.basic;

import codeu.model.data.Hashtag;
import codeu.model.data.ModelDataTestHelpers;
import codeu.model.store.persistence.PersistentStorageAgent;
import java.util.Hashtable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HashtagStoreTest {
  private HashtagStore hashtagStore;
  private PersistentStorageAgent mockPersistentStorageAgent;

  @Before
  public void setup() {
    mockPersistentStorageAgent = Mockito.mock(PersistentStorageAgent.class);
    hashtagStore = HashtagStore.getTestInstance(mockPersistentStorageAgent);
  }

  @Test
  public void testAddHashtag() {
    final Hashtable<String, Hashtag> hashtags = new Hashtable<String, Hashtag>();

    final Hashtag hash1 =
        new ModelDataTestHelpers.TestHashtagBuilder().withContent("Soccer").build();
    final Hashtag hash2 = new ModelDataTestHelpers.TestHashtagBuilder().build();
    final Hashtag hash3 =
        new ModelDataTestHelpers.TestHashtagBuilder().withCreatedFromUser(true).build();

    hashtags.put(hash1.getContent(), hash1);
    hashtags.put(hash2.getContent(), hash2);
    hashtags.put(hash3.getContent(), hash3);
    hashtagStore.setHashtags(hashtags);

    Hashtable<String, Hashtag> resultHashtags = hashtagStore.getAllHashtags();

    Assert.assertEquals(hashtags, resultHashtags);
  }
}
