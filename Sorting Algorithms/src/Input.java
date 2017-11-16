
public class Input {
	
	private double RANGE = (30000) + 1; 
	private int inputList[];
	
	public void createInput(int n){
		inputList = new int [n];
		
		for(int i = 0; i < n; i++){
			inputList[i] = (int) (Math.random()*RANGE);
		}
	}
	
	public void printArray(){
		int n = inputList.length;
		
		for(int i = 0; i<n;i++){
			System.out.println(inputList[i]);
		}
	}
	
	public int [] getArray(){
		return inputList;
	}

}
