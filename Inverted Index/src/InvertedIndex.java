import java.util.*;
import java.io.*;
public class InvertedIndex {
	
	
	//HashMap<String, ArrayList<Document> -- Each key term has a list of documents
	private HashMap <String, ArrayList<Document>> inverted_index = new HashMap<String, ArrayList<Document>>();
	private ArrayList<Document> documentList = new ArrayList<Document>();
	private ArrayList<Document> termDocumentList;
	private BufferedReader reader;
	private File documentDir;
	private File[] filePaths;
	private View view = new View();
	private String[] terms;
	
	public void loadDocuments(){
	
		//Getting files pathnames in samples directory
		documentDir = new File("samples/");
		filePaths = documentDir.listFiles();
		
		//Creating Document objects, defining their ID and pathname
		for(int i = 0; i < filePaths.length;i++){
			documentList.add(new Document(i+1, filePaths[i].getPath()));
		}
	}
	
	public void createIndex(){
		loadDocuments();
		for(Document document : documentList){
			view.printMsg("Priting document: " + document.getDocumentID());
			try{
				reader = new BufferedReader(new FileReader(document.getDocumentPath()));
				String line = "";
				while ((line = reader.readLine()) != null) {
					terms = line.split("\\W");
					termDocumentList = new ArrayList<Document>();
					for(String term: terms ){
						if(!inverted_index.containsKey(term)){
								termDocumentList.add(document);
							inverted_index.put(term, termDocumentList);
						}
					}
				}
			}
			catch(Exception noFileFound){
				view.printMsg("Error reading file");
			}
		}
		/*for (String term: inverted_index.keySet()){

            String key = term.toString();
            String value = inverted_index.get(term).toString();  
            System.out.println(key + " " + value);  

		} */
	}
}
