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
	
	public float getMean() {
		int n = inputList.length;
		float mean = 0;
		for(int i = 0; i < n; i++) {
			mean = mean + inputList[i];
		}
		mean = mean/n;
		return mean;
	}
	
	public float getMedian() {
		
		//Even get mdpt - 1 and mdpt + 1 /2
		int n = inputList.length;
		float median = 0;
		if(n % 2 == 0) {
			int mdpt = n/2;
			float mdpt1, mdpt2;
			mdpt1 = inputList[mdpt+1];
			mdpt2 = inputList[mdpt-1];
			median = (mdpt1+mdpt2)/2;	
		}
		//Odd list
		else {
			int mdpt = (int) Math.floor(n/2);
			median = inputList[mdpt];
			
		}
		return median;
	}
	
	public float [] getArray(){
		return inputList;
	}

}
