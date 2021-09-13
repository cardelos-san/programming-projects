import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class stopWords {
	
	private File document;
	private BufferedReader reader;
	private ArrayList <String> stopWords;
	private ArrayList <String> temp;
	private String stopWord;
	private View view = new View();
	
	public void loadFile() throws IOException{
		
		document = new File("stop-words.txt");
		stopWords =  new ArrayList<String>();
		try{
			reader = new BufferedReader(new FileReader(document));
			String line = "";
			while ((line = reader.readLine()) != null) {
				temp =  new ArrayList<String>(Arrays.asList(line.split("\\s")));
				stopWord = temp.get(0);
				stopWords.add(stopWord);
			}
		}
		catch(Exception noFileFound){
			view.printMsg("Error reading file");
		}
		
		reader.close();
	}
	
	public ArrayList <String> getStopWords() throws IOException{
		
		loadFile();
		
		return stopWords;
		
	}

}
