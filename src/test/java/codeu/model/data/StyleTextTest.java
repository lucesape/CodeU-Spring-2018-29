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
  
  
  //Close tags before open tags? 
  
  
  //A bunch of open tags at the end of the string? 
  
  
  //Tags of different types that aren't properly nested? 
  
  
  //Tags with capital letters? 
  
  
  //Invalid tags?
  
  
}
