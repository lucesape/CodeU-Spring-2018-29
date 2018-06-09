package codeu.model.store.basic;

import codeu.model.data.Hashtag;
import codeu.model.data.ModelDataTestHelpers;
import codeu.model.store.persistence.PersistentStorageAgent;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

public class HashtagStoreTest {
  private HashtagStore hashtagStore;
  private PersistentStorageAgent mockPersistentStorageAgent;

  @Before
  public void setup() {
    mockPersistentStorageAgent = Mockito.mock(PersistentStorageAgent.class);
    hashtagStore = hashtagStore.getTestInstance(mockPersistentStorageAgent);
  }

  @Test
  public void testAddHashtag() {
    final List<Hashtag> hashtags = new ArrayList<>();
    final Hashtag hash1 = new ModelDataTestHelpers.TestHashtagBuilder().withContent("Soccer").build();
    final Hashtag hash2 = new ModelDataTestHelpers.TestHashtagBuilder().build();
    final Hashtag hash3 = new ModelDataTestHelpers.TestHashtagBuilder().withCreatedFromUser(true).build();
    hashtags.add(hash1);
    hashtags.add(hash2);
    hashtags.add(hash3);
    hashtagStore.setHashtags(Arrays.asList(hash1, hash2, hash3));

    List<Hashtag>  resultHashtags = hashtagStore.getAllHashtags();

    Assert.assertEquals(hashtags, resultHashtags);
  }

}
