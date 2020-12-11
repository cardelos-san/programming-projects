import java.util.Arrays;

public class MergeSort {
	private float inputList[];
	private double time;
	
	public MergeSort(float list[]) {
		inputList = list.clone();
	}
	
	void sort(){
		int left = 0;
		int right = inputList.length - 1;
		
		//Timing function
	    double start = System.currentTimeMillis();
	    
		this.sort(left, right);
		
		//Stop timer
		double stop = System.currentTimeMillis();
		time = stop - start;
		
	}
	
	void sort(int left, int right){
		
		
	    
		if(left < right){
			int mid = (left+right)/2;
			
			sort(left, mid);
			sort(mid + 1, right);
			
			merge(left, mid, right);
		}
	}
	
	void merge(int left, int mid, int right){
		
		int nLeft = mid - left + 1;
		int nRight = right - mid;
		
		float leftArr[] = new float [nLeft];
		float rightArr[] = new float [nRight];
		
		leftArr = Arrays.copyOfRange(inputList, left, mid + 1);
		rightArr = Arrays.copyOfRange(inputList, mid + 1, right + 1);
        
		int i, j, k;
		i = j = 0;
		k = left;
		
		while(i < nLeft && j < nRight) {
			if(leftArr[i]<= rightArr[j]) {
				inputList[k] = leftArr[i];
				i++;
			}
			else {
				inputList[k] = rightArr[j];
				j++;
			}
			k++;
		}
		
		 while (i < nLeft) {
			 inputList[k] = leftArr[i];
	         i++;
	         k++;
	     }
		 
		 while (j < nRight) {
	         inputList[k] = rightArr[j];
	         j++;
	         k++;
	     }	
    }
	
	public void printArraySize(){
		System.out.println(inputList.length);	
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
			mdpt1 = inputList[mdpt-1];
			mdpt2 = inputList[mdpt];
			median = (mdpt1+mdpt2)/2;	
		}
		//Odd list
		else {
			int mdpt = (int) Math.floor(n/2);
			median = inputList[mdpt];
			
		}
		return median;
	}
	
}
