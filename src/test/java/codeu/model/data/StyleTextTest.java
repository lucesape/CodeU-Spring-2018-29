package codeu.model.data;

import org.junit.Assert;
import org.junit.Test;

public class StyleTextTest {
	
  @Test
  public void IndividualTags() {
    String message = "Change messages to [b]bold[/b] [i]italics[/i] and [u]underlined[/u] text";

    String result = StyleText.style(message);

    String expectedOutput =
        "Change messages to <b>bold</b> <i>italics</i> and <u>underlined</u> text";
    Assert.assertEquals(expectedOutput, result);
  }
  
  //multiple of the same tags? 
  @Test
  public void MultipleBoldTags() {
	  String message = "[b]bold[/b][b]bold[/b][b]bold[/b]";
	  
	  String actual = StyleText.style(message);
	  
	  String expected = "<b>bold</b><b>bold</b><b>bold</b>";
	  Assert.assertEquals(expected, actual);
  }
  
  @Test
  public void MultipleItalicsTags() {
	  String message = "[i]italics[/i][i]text[/i]";
	  
	  String actual = StyleText.style(message);
	  
	  String expected = "<i>italics</i><i>text</i>";
	  Assert.assertEquals(expected, actual);
  }
  
  @Test
  public void MultipleUnderlineTags() {
	  String message = "[u]underline[/u][u]text[/u]";
	  
	  String actual = StyleText.style(message);
	  
	  String expected = "<u>underline</u><u>text</u>";
	  Assert.assertEquals(expected, actual);
  }
  
  //Tags inside of tags? 
  @Test
  public void TagsInsideTagsOne() {
	  String message = "[b]style [i]text [u]tags[/u] inside[/i] another[/b]";
	  
	  String actual = StyleText.style(message);
	  
	  String expected = "<b>style <i>text <u>tags</u> inside</i> another</b>";
	  Assert.assertEquals(expected, actual);
  }
  
  @Test
  public void TagsInsideTagsTwo() {
	  String message = "[b]style [i]text [/i]tags[u] inside[/u] another[/b]";
	  
	  String actual = StyleText.style(message);
	  
	  String expected = "<b>style <i>text </i>tags<u> inside</u> another</b>";
	  Assert.assertEquals(expected, actual);
  }
  
  @Test
  public void TagsInsideTagsThree() {
	  String message = "start [b]style [i]text [/i]tags[u] inside[/u] another[/b] end";
	  
	  String actual = StyleText.style(message);
	  
	  String expected = "start <b>style <i>text </i>tags<u> inside</u> another</b> end";
	  Assert.assertEquals(expected, actual);
  }
  
  //Close tags before open tags? 
  @Test
  public void ClosedBeforeOpenOne() {
	  String message = "closed tags[/b] before open tags [b]";
	  
	  String actual = StyleText.style(message);
	  
	  String expected = "closed tags before open tags ";
	  Assert.assertEquals(expected, actual);
  }
  
  @Test
  public void ClosedBeforeOpenTwo() {
	  String message = "closed tags[/b] before[/b] open tags[b] twice[b]";
	  
	  String actual = StyleText.style(message);
	  
	  String expected = "closed tags before open tags twice";
	  Assert.assertEquals(expected, actual);
  }
  
  @Test
  public void ClosedBeforeOpenThree() {
	  String message = "closed tags[/b] before[/b] open tags[b] twice";
	  
	  String actual = StyleText.style(message);
	  
	  String expected = "closed tags before open tags twice";
	  Assert.assertEquals(expected, actual);
  }
  
  //A bunch of open tags at the end of the string? 
  @Test
  public void OpenTagsAtEnd() {
	  String message = "open tags at the end[u][i][b]";
	  
	  String actual = StyleText.style(message);
	  
	  String expected = "open tags at the end";
	  Assert.assertEquals(expected, actual);
  }
  
  @Test
  public void OpenTagsAtEndTwo() {
	  String message = "open tags at the end[b][b][b]";
	  
	  String actual = StyleText.style(message);
	  
	  String expected = "open tags at the end";
	  Assert.assertEquals(expected, actual);
  }
  
  //Tags of different types that aren't properly nested? 
  
  
  //Tags with capital letters? 
  
  
  //Invalid tags?
  
  
}
