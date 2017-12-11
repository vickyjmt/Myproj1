package build1;

import java.awt.Component;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
public class htmlParser1 {

    public static void main(String[] args) throws IOException, InterruptedException {
   
    	    
    	 Component frame = null;
 	  	
 	    String event = JOptionPane.showInputDialog(frame, "Hey ! What you want?"); 
 	    StringTokenizer st1 = new StringTokenizer(event);
 	  //  StringTokenizer st2=st1;
 	    
 	   int total = st1.countTokens();
		System.out.println("The total number of tokens :"+total);
 	 //  for (int i = 1; st1.hasMoreTokens(); i++)
	   //      System.out.println("Token "+i+": "+st1.nextToken());
 	   
 	    
 		DesiredCapabilities caps = new DesiredCapabilities();
 		caps.setJavascriptEnabled(true);
 		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:/project1/phantom/phantomjs-2.0.0-windows/bin/phantomjs.exe");
 		
 		PhantomJSDriver driver = new PhantomJSDriver(caps);
 		driver.get("http://www.cricbuzz.com/cricket-full-commentary/19193/ind-vs-sl-1st-odi-sri-lanka-tour-of-india-2017");
 		TimeUnit.SECONDS.sleep(4);
        String str=null;
 		String yourtext= driver.findElement(By.tagName("body")).getText() ;
 		//if(yourtext.contains(event))
	
		//	JOptionPane.showMessageDialog(null, "Event Detected");
 		int count=0;
 		
 		 for (; st1.hasMoreTokens();)
 		 { 
 			 str=st1.nextToken();
 			 System.out.println("The "+(count +1) +"token is:"+str);
 			 if(yourtext.contains(str))
 			 {	 count++; 
 			 }
 				 
 		 }
 		 
 		 if(count==total)
 		 {
 			//JOptionPane.showMessageDialog(null, "Event Detected");
 			 System.out.println(" Alert ! System detects an event");
 		 }
 		 else
 		 System.out.println(" Tested successfully , event not detected");	
 		 
 		 System.out.println(" Total value of count is :"+count);
 		
       
    }
}


/*
  PrintWriter out = new PrintWriter("D:/project2/clean1/test1.txt");
        out.println(doc1);
        out.close();
        
 */
   