package codeu.model.data;

import org.junit.Assert;
import org.junit.Test;

public class StyleTextTest {

  @Test
  public void testStyleText() {
    String message = "Change messages to [b]bold[/b] [i]italics[/i] and [u]underlined[/u] text";

    String result = StyleText.style(message);

    String expectedOutput =
        "Change messages to <b>bold</b> <i>italics</i> and <u>underlined</u> text";
    Assert.assertEquals(expectedOutput, result);
  }
}
