import java.awt.Component;
import java.util.StringTokenizer;
import javax.swing.*;

/**
 * JOptionPane showInputDialog example #1.
 * A simple showInputDialog example.
 * @author alvin alexander, http://alvinalexander.com
 */
public class HelloWorld
{
  public static void main(String[] args)
  {
    // a jframe here isn't strictly necessary, but it makes the example a little more real
    JFrame frame = new JFrame("InputDialog Example #1");
    String str = null;

	  StringTokenizer st1 = new StringTokenizer("This is an unplayable wicket");

		      for (; st1.hasMoreTokens();)
		      {
		    	  str=st1.nextToken();
		    	  System.out.println(str);
		      }
    // get the user's input. note that if they press Cancel, 'name' will be null
   // System.out.printf("The user's name is '%s'.\n", name);
    System.exit(0);
  }
}