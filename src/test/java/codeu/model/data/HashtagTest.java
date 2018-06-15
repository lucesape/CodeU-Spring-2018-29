package codeu.model.data;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class HashtagTest {

  @Test
  public void testCreate() {
    String contentUpper = "Football";
    String contentLower = "football";
    Hashtag hashtag1 = new Hashtag(contentUpper);
    Hashtag hashtag2 = new Hashtag(contentLower);
    Assert.assertEquals(contentUpper.toLowerCase(), hashtag1.getContent());
    Assert.assertEquals(contentLower, hashtag2.getContent());
  }

  @Test
  public void testAddUser() {
    String content = "Football";
    Hashtag hashtag = new Hashtag(content);

    UUID userID1 = UUID.randomUUID();
    UUID userID2 = UUID.randomUUID();

    Assert.assertEquals(0, hashtag.getUserSource().length());
    Assert.assertTrue(hashtag.addUser(userID1));
    Assert.assertTrue(hashtag.addUser(userID2));
    Assert.assertFalse(hashtag.addUser(userID1));

    Assert.assertTrue(hashtag.getUserSource().indexOf(',') != -1);
  }

  @Test
  public void testAddConversation() {
    String content = "Football";
    Hashtag hashtag = new Hashtag(content);

    UUID convID1 = UUID.randomUUID();
    UUID convID2 = UUID.randomUUID();

    Assert.assertEquals(0, hashtag.getUserSource().length());
    Assert.assertTrue(hashtag.addUser(convID1));
    Assert.assertTrue(hashtag.addUser(convID2));
    Assert.assertFalse(hashtag.addUser(convID1));

    Assert.assertTrue(hashtag.getUserSource().indexOf(',') != -1);
  }
}
