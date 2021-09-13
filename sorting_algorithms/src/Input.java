import java.util.ArrayList;

public class Input {
	
	private double RANGE = (500000) + 1; 
	private float inputList[];
	private ArrayList<Float> userInputList = new ArrayList<Float>();
	
	
	public void createInput(int n){
		inputList = new float [n];
		
		for(int i = 0; i < n; i++){
			inputList[i] = (int) (Math.random()*RANGE);
		}
	}
	
	public void userInput(float x) {
		userInputList.add(x);
	}
	
	public void userInput2Array() {
		int n = userInputList.size();
		inputList = new float [n];
		for(int i = 0; i < n; i++ ){
			inputList[i] = userInputList.get(i);
		}
	}
	
	public void printArray(){
		int n = inputList.length;
		
		for(int i = 0; i<n;i++){
			System.out.println(inputList[i]);
		}
	}
	
	
	
	public float [] getArray(){
		return inputList;
	}

}
