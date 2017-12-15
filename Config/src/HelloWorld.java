import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

public class HelloWorld {
  public static void main(String[] args) {
    String data;
    String msg;

    Hashtable h = new Hashtable(20);

   h.put("one", new Integer(1));
   h.put("name", "A");
   h.put("date", new Date());
   h.put("one", new Integer(4));

    Enumeration e = h.keys();
    
    while (e.hasMoreElements())
      System.out.println(e.nextElement());

    e = h.elements();
    while (e.hasMoreElements())
      System.out.println(e.nextElement());
  }
}