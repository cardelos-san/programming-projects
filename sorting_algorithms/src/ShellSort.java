
public class ShellSort {
	
private float inputList[];
private double time;
	
	public ShellSort(float list[]) {
		inputList = list.clone();
	}
	
	
	public void sort(){
		
		//Timing function
	    double start = System.currentTimeMillis();
	    
		float temp;
		
		int n = inputList.length;
		int gap = n/2;
		
		while(gap > 0){
			
			for(int i = gap; i < n; i++){
				temp = inputList[i];
				int j;
				
				for(j = i; j >= gap && temp < inputList[j-gap]; j -= gap ){
					inputList[j] = inputList[j-gap];
				}
				
				inputList[j] = temp;
			}
			
		gap = gap/2;
		}
		
		//Stop timer
		double stop = System.currentTimeMillis();
		time = stop - start;
	}
	
	public void printArray(){
		int n = inputList.length;
		
		for(int i = 0; i<n;i++){
			System.out.println(inputList[i]);
		}
	}
	
	public double execTime(){
		return time;
	}

}
