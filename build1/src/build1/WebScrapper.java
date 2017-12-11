package build1;

import java.awt.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
public class WebScrapper {
	public static void main(String[] args) throws Exception
	{ 
		 System.setProperty("https.proxyHost", "43.194.159.120"); // or the IP
	      System.setProperty("https.proxyPort", "80");
	    System.setProperty("http.proxyHost", "43.194.159.120"); // or the IP
	      System.setProperty("http.proxyPort", "80");
	      Component frame = null;
	  	
	    String event = JOptionPane.showInputDialog(frame, "Hey ! What you want?"); 
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:/project1/phantom/phantomjs-2.0.0-windows/bin/phantomjs.exe");
		
		PhantomJSDriver driver = new PhantomJSDriver(caps);
		driver.get("http://www.cricbuzz.com/cricket-series/2637/sri-lanka-tour-of-india-2017/matches");
		TimeUnit.SECONDS.sleep(2);
	/*	Runnable drawRunnable = new Runnable() {
		    public void run() {
		    	
		    	String yourtext= driver.findElement(By.tagName("body")).getText() ;
		
				if(yourtext.contains(event))
				{
					JOptionPane.showMessageDialog(null, "Event Detected");
				}
				else
					JOptionPane.showMessageDialog(null, "Event not Detected");	
		    }
		};
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
		exec.scheduleAtFixedRate(drawRunnable , 0, 20, TimeUnit.SECONDS);
	*/	

	}
}
