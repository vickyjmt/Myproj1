package build1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ParseFile {

    public static void main(String[] args) throws IOException {

        String fileName = "D:/project2/news1.txt";

        Document doc = Jsoup.parse(new File(fileName), "utf-8"); 
        //Element divTag = doc.getElementById("mydiv"); 
        String  doc1 = doc.body().text();

        PrintWriter out = new PrintWriter("D:/project2/clean1/cric7.txt");
        out.println(doc1);
        out.close();
       System.out.println("Done");
    }
}
