package build1;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;

import org.jsoup.Jsoup; 
import java.util.Scanner;
//import org.jsoup.nodes.Document;  
//import org.jsoup.nodes.Element;  
//import org.jsoup.select.Elements;  

public class Test{
  	public static void main(String[] args) throws IOException, InterruptedException{
	 
  		
  		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          System.setProperty("https.proxyHost", "43.194.159.120"); // or the IP
	      System.setProperty("https.proxyPort", "80");
	      System.setProperty("http.proxyHost", "43.194.159.120"); // or the IP
	      System.setProperty("http.proxyPort", "80");
	      DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setJavascriptEnabled(true);
	      caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:/project1/phantom/phantomjs-2.0.0-windows/bin/phantomjs.exe");
			
			PhantomJSDriver driver = new PhantomJSDriver(caps);
       
        //driver.get will open www.artoftesting.com in firefox browser
       driver.get("http://www.cricbuzz.com");
       // driver.close();
      
       java.util.List<WebElement> links = driver.findElements(By.tagName("a")); //    
        //TimeUnit.SECONDS.sleep(10);
       
     //   Document doc = Jsoup.parse(driver.getPageSource());
        
       
       // Elements links = doc.select("a"); 
        System.out.println("\n No. of Links :"+links.size() );
       // String doc1 = doc.body().text();
      //  System.out.println(doc1);
       // String unq=null;
        int count2=0;
        String absUrl=null;
        String absUrl2=null;
        Set<String> unqlist = new HashSet<String>();
        Set<String> unqlist2 = new HashSet<String>();
        int count =0;
        //etval ;
        for (int i = 0; i<links.size(); i=i+1) 
        {  
       
        	
        	absUrl	 = links.get(i).getAttribute("href");
        	if(absUrl==null)
               continue;
           // System.out.println("The links are:"+absUrl);
         // boolean   retval=absUrl.contains(" full-commentary") && !(absUrl.contains("mailto"));
            if (absUrl.contains("live-scores")
                    && !(absUrl.contains("mailto")))
            {
            	 unqlist.add(absUrl);
            	 count++;
            }	
         }
            
        	
       
       
        for( String  unq1 : unqlist)
        { 
        	 System.out.println("The count is :"+count+"and absUrl is:"+unq1+""); 	
        	driver.get(unq1);
        	java.util.List<WebElement> links2 = driver.findElements(By.tagName("a")); //  
        	 System.out.println("\n No. of sub-Links in 2nd loop :"+links2.size() );
        	
             for (int j = 0; j<links2.size(); j=j+1) 
             {  
            
             	
             	absUrl2	 = links2.get(j).getAttribute("href");
             	if(absUrl2==null)
                    continue;
             
                  if (absUrl2.contains("cricket-full-commentary")
                     && !(absUrl2.contains("mailto")))
                  {  
                 	 unqlist2.add(absUrl2);
                 	 
                 	
                  }
                 
             	    //  count2++;
                  //System.out.println("The count is :"+count2+"and absUrl is:"+absUrl+""); 
             	
             	
              }
             
        	
        	
        } 
        int cnt=0;
       
        for( String unq2 : unqlist2)
        {
        	//System.out.println(" The live commentary links are :"+unq2+"");
        	driver.get(unq2);
        	TimeUnit.SECONDS.sleep(2);
    		String yourtext= driver.findElement(By.tagName("body")).getText() ;
    		
    		 PrintWriter out= new PrintWriter(new FileOutputStream(new File("D:/project2/clean1/cric1.txt"),true)); 
    	        out.println(yourtext);
    	        out.close();
    	        cnt++;
    	        System.out.println("\n\n\nPrinted the content of website:"+cnt+":"+unq2+"");        	
        }
        
       
        
          	       
         System.out.println("Test Passed");
  }
}