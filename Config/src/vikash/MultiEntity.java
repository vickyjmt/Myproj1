package vikash;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

import opennlp.tools.namefind.BioCodec;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.namefind.NameSampleDataStream;
import opennlp.tools.namefind.TokenNameFinder;
import opennlp.tools.namefind.TokenNameFinderFactory;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.Span;
import opennlp.tools.util.TrainingParameters;

public class MultiEntity {

	public static void main(String[] args) 
	  {
		try {
			//System.out.println("-------Finding entities belonging to category : place name------");
			String input= "C:/models/Training_file/train_alert.txt";
			String output= "C:/models/trained_models/ner-custom-alert.bin";
			String input1 = "C:/models/Training_file/train_domain.txt";
			String output1 = "C:/models/trained_models/ner-custom-domain.bin";
			String input2 = "C:/models/Training_file/train_team.txt";
			String output2 = "C:/models/trained_models/ner-custom-team.bin";
			String input3 = "C:/models/Training_file/train_condition.txt";
			String output3 = "C:/models/trained_models/ner-custom-condition.bin";
			
			
			
			new MultiEntity().createModel(input1,output1);
			new MultiEntity().createModel(input,output);
			new MultiEntity().createModel(input2,output2);
			new MultiEntity().createModel(input3,output3);
			new SentenceDetectExample().findAction();
			System.out.println();
			new SentenceDetectExample().findDomain();
			System.out.println();
			new SentenceDetectExample().findTeam();
			System.out.println();
			new SentenceDetectExample().findCondition();
			System.out.println();
		   } 
		catch (IOException e)
		  {
			e.printStackTrace();
		  }
	  }
		private void createModel(String input1, String output1) throws IOException {

		InputStreamFactory in = null;
		try {
			in = new MarkableFileInputStreamFactory(new File(input1)); //"C:/models/Training_file/AnnotatedSentences.txt"
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		
		
		ObjectStream sampleStream = null;
		try {
			sampleStream = new NameSampleDataStream(
	            new PlainTextByLineStream(in, StandardCharsets.UTF_8));
		} catch (IOException e4) {
			e4.printStackTrace();
		}
		
		
		
		TrainingParameters params = new TrainingParameters();
	    params.put(TrainingParameters.ITERATIONS_PARAM, 70);
	    params.put(TrainingParameters.CUTOFF_PARAM, 1);
	    
	    
	    TokenNameFinderModel nameFinderModel = null;
		try {
			nameFinderModel = NameFinderME.train("en", null, sampleStream,
			    params, TokenNameFinderFactory.create(null, null, Collections.emptyMap(), new BioCodec()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		try {
			File output = new File(output1);// "C:/models/trained_models/ner-custom-location1.bin"
			FileOutputStream outputStream = new FileOutputStream(output);
			nameFinderModel.serialize(outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
				
		/*
		    try {
					System.out.println("-------Finding entities belonging to category : place name------");
					new SentenceDetectExample().findName();
					System.out.println();
				} 
		    
		    
		       catch (IOException e)
		        {
					e.printStackTrace();
				}	
	    */
}
	
}
