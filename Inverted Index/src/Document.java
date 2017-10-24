
public class Document {
	
	private int fileID;
	private String filePath;
	
	public Document(int fileID, String filePath){
		this.fileID = fileID;
		this.filePath = filePath;
	}
	
	public int getDocumentID(){
		
		return fileID;
	}
	
	public String getDocumentPath(){
			
			return filePath;
		}
	
	public String toString(){
		String result;
		result = "DocumentID: " + getDocumentID() + " Location: " + getDocumentPath() + "\n";
		return result;
	}

}
