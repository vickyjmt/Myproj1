package vikash;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.util.Span;

/**
 * This class demonstrates how to use NameFinderME class to do Named Entity Recognition/Extraction tasks.
 * @author tutorialkart.com
 */
public class SentenceDetectExample{

	public static void main(String[] args) {
		// find person name
		try {
			System.out.println("-------Finding entities belonging to category : Action name------");
			new SentenceDetectExample().findAction();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// find place
		try {
			System.out.println("-------Finding entities belonging to category : Domain name------");
			new SentenceDetectExample().findDomain();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			System.out.println("-------Finding entities belonging to category : Team name------");
			new SentenceDetectExample().findTeam();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * method to find locations in the sentence
	 * @throws IOException
	 */
	public void findAction() throws IOException {
		//InputStream is = new FileInputStream("en-ner-person.bin");
		InputStream is = new 
		         FileInputStream("C:/models/trained_models/ner-custom-alert.bin"); 
		// load the model from file
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();

		// feed the model to name finder class
		NameFinderME nameFinder = new NameFinderME(model);

		// input string array
		
		 String sentence =" alert the result of bangladesh vs india cricket  match";
		    SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE; 
		    String tokens[] = simpleTokenizer.tokenize(sentence);  

		Span nameSpans[] = nameFinder.find(tokens);

		// nameSpans contain all the possible entities detected
		for(Span s: nameSpans){
			System.out.print(s.toString());
			System.out.print("  :  ");
			// s.getStart() : contains the start index of possible name in the input string array
			// s.getEnd() : contains the end index of the possible name in the input string array
			for(int index=s.getStart();index<s.getEnd();index++){
				System.out.print(tokens[index]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * method to find locations in the sentence
	 * @throws IOException
	 */
	public void findDomain() throws IOException {
		InputStream is1 = new FileInputStream("C:/models/trained_models/ner-custom-domain.bin");

		// load the model from file
		TokenNameFinderModel model = new TokenNameFinderModel(is1);
		is1.close();

		// feed the model to name finder class
		NameFinderME nameFinder = new NameFinderME(model);

		// input string array
		 String sentence ="notify and alert the result of bangladesh vs india cricket  match";
		    SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE; 
		    String tokens[] = simpleTokenizer.tokenize(sentence);  


		Span nameSpans[] = nameFinder.find(tokens);

		// nameSpans contain all the possible entities detected
		for(Span s: nameSpans){
			System.out.print(s.toString());
			System.out.print("  :  ");
			// s.getStart() : contains the start index of possible name in the input string array
			// s.getEnd() : contains the end index of the possible name in the input string array
			for(int index=s.getStart();index<s.getEnd();index++){
				System.out.print(tokens[index]+" ");
			}
			System.out.println();
		}
	}
	
	public void findTeam() throws IOException {
		//InputStream is = new FileInputStream("en-ner-person.bin");
		InputStream is = new 
		         FileInputStream("C:/models/trained_models/ner-custom-team.bin"); 
		// load the model from file
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();

		// feed the model to name finder class
		NameFinderME nameFinder = new NameFinderME(model);

		// input string array
		
		 String sentence =" alert the result of  india vs sri lanka cricket  match";
		    SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE; 
		    String tokens[] = simpleTokenizer.tokenize(sentence);  

		Span nameSpans[] = nameFinder.find(tokens);

		// nameSpans contain all the possible entities detected
		for(Span s: nameSpans){
			System.out.print(s.toString());
			System.out.print("  :  ");
			// s.getStart() : contains the start index of possible name in the input string array
			// s.getEnd() : contains the end index of the possible name in the input string array
			for(int index=s.getStart();index<s.getEnd();index++){
				System.out.print(tokens[index]+" ");
			}
			System.out.println();
		}
	}
	
	
	public void findCondition() throws IOException {
		//InputStream is = new FileInputStream("en-ner-person.bin");
		InputStream is = new 
		         FileInputStream("C:/models/trained_models/ner-custom-condition.bin"); 
		// load the model from file
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();

		// feed the model to name finder class
		NameFinderME nameFinder = new NameFinderME(model);

		// input string array
		
		 String sentence =" alert the result of  india vs sri lanka cricket  match";
		    SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE; 
		    String tokens[] = simpleTokenizer.tokenize(sentence);  

		Span nameSpans[] = nameFinder.find(tokens);

		// nameSpans contain all the possible entities detected
		for(Span s: nameSpans){
			System.out.print(s.toString());
			System.out.print("  :  ");
			// s.getStart() : contains the start index of possible name in the input string array
			// s.getEnd() : contains the end index of the possible name in the input string array
			for(int index=s.getStart();index<s.getEnd();index++){
				System.out.print(tokens[index]+" ");
			}
			System.out.println();
		}
	}
	
	
}