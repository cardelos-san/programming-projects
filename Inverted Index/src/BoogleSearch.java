import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoogleSearch {
	
	View view;
	InvertedIndex accessIndex;
	Scanner scanner;
	String[] query;
	
	public BoogleSearch(){
		view = new View();
		accessIndex = new InvertedIndex();
		scanner = new Scanner(System.in);
		}
	
	public void initializeIndex(){
		
		try {
			accessIndex.createIndex();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void boogleSearch(){
		
		initializeIndex();	
		
		view.printMsg("Welcome to Boogle Search");
		view.printMsg("Boogle can search and find what you are looking for! (Due to limited resources,"
				+ " Boogle can only search one word a time)\n");
		view.printMsg("List of current documents that you can search in:\n");
		view.printMsg(accessIndex.indexedDocuments());
		view.printMsg("What would you like to search? ");
		
		String query = scanner.nextLine();
		String _query = query.toLowerCase();
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(_query);
		boolean found = matcher.find();

		if(found){
		view.printMsg("Sorry, we can only process one word terms!");
		}
		
		else{
			
			view.printMsg("Your term " + "'" +_query + "'" + " appears in the following documents: ");
			view.printMsg(accessIndex.searchIndex(_query));
			
		}
	}
	
	
	

}
