package build1;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;

public class webScraper1{
    public static void main(String[] args) {

        URL url;

        try {
            // get URL content
        	System.setProperty("https.proxyHost", "43.194.159.120"); // or the IP
        	System.setProperty("https.proxyPort", "80");
            String a="https://www.cricbuzz.com";
            url = new URL(a);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));
            String parse1=null; 
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
            	    parse1=parse1 + inputLine;
                    System.out.println(inputLine);
            }
         // String parsed =  Jsoup.parse(inputLine).text();
          System.out.println("Printing after parsing the content \n");
          System.out.println(parse1);
            br.close();

            System.out.println("Done");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

