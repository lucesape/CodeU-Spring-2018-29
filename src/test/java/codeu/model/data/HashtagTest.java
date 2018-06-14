package codeu.model.data;

import java.time.Instant;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class HashtagTest {

  @Test
  public void testCreate() {
    UUID id = UUID.randomUUID();
    UUID ownerId = UUID.randomUUID();
    String content = "Football";
    Instant creation = Instant.now();
    Boolean createdFromUser = true;

    Hashtag hashtag = new Hashtag(id, ownerId, content, creation, createdFromUser);

    Assert.assertEquals(id, hashtag.getId());
    Assert.assertEquals(ownerId, hashtag.getOwnerId());
    Assert.assertEquals(content, hashtag.getContent());
    Assert.assertEquals(createdFromUser, hashtag.isCreatedFromUser());
    Assert.assertEquals(creation, hashtag.getCreationTime());
  }
}
