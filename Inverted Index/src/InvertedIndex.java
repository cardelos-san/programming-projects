import java.util.*;
import java.io.*;
public class InvertedIndex {
	
	
	//HashMap<String, ArrayList<Document> -- Each key term has a list of documents
	private HashMap <String, ArrayList<Document>> inverted_index;
	private ArrayList<Document> documentList;
	private ArrayList<Document> termDocumentList;
	private BufferedReader reader;
	private File documentDir;
	private File[] filePaths;
	private View view;
	private String[] terms;
	private ArrayList<String> stop_words;
	private stopWords wordFile;
	
	public InvertedIndex(){
		documentList = new ArrayList<Document>();
		inverted_index = new HashMap<String, ArrayList<Document>>();
		view = new View();
		wordFile = new stopWords();
	}
	
	public void loadDocuments() throws IOException{
		stop_words = new ArrayList<String>(wordFile.getStopWords());
		
		//Getting files pathnames in samples directory
		documentDir = new File("samples/");
		filePaths = documentDir.listFiles();
		
		//Creating Document objects, defining their ID and pathname
		for(int i = 0; i < filePaths.length;i++){
			documentList.add(new Document(i+1, filePaths[i].getPath()));
		}
	}
	
	public void createIndex() throws IOException{
		
		//Creating list of all documents
		loadDocuments();
		
		//For each document
		for(Document document : documentList){
			termDocumentList = new ArrayList<Document>();
			//Initializing BuffferedReader to current document
			try{
				reader = new BufferedReader(new FileReader(document.getDocumentPath()));
				String line = "";
				
				//Read each line --> split each line into words
				while ((line = reader.readLine()) != null) {
					terms = line.split("[\\p{Punct}\\s]+");
					for(String term: terms ){
						String _term = term.toLowerCase();
						if(stop_words.contains(_term) || _term.length() == 0 || _term.length() == 1 ){}
						
						//If term is not in index, create new entry
						else if(!inverted_index.containsKey(_term)){
							termDocumentList = new ArrayList<Document>();
							termDocumentList.add(document);
							inverted_index.put(_term, termDocumentList);
						}
						/*If term is in index, but document is not in its list
						of documents, then update term's document list*/
						else if(inverted_index.containsKey(_term) &&
								!(inverted_index.get(_term).contains(document))){
							inverted_index.get(_term).add(document);
						}	
					}
				}	
			}
			catch(Exception noFileFound){
				view.printMsg("Error reading file");
			}
			
			reader.close();
		}
		//Printing inverted index
		/*for (String term: inverted_index.keySet()){

            String key = term.toString();
            String value = inverted_index.get(term).toString();  
            System.out.println(key + " " + value);  

		}*/
	}
	
	public String searchIndex(String query){
		
		//Timing function
		double start = System.currentTimeMillis();
		
		String result = "";
		
		if(inverted_index.containsKey(query)){
			result = inverted_index.get(query).toString() + "\n";
		}
		
		else{result = "No matches\n";}
		
		double stop = System.currentTimeMillis();
		double elapsedTime = stop - start;
		
		String time = "Execution time in milliseconds: " + elapsedTime;
		return result + time;
		
		
	}
	
	public String indexedDocuments(){
		String list = "";
		for(int i = 0; i < documentList.size();i++){
			String document = documentList.get(i).toString();
			list = list + ( document);	
		}
		return list;
	}
}
