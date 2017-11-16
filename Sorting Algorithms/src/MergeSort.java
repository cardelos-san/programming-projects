import java.util.Arrays;

public class MergeSort {
	private int inputList[];
	
	public MergeSort(int list[]) {
		inputList = list.clone();
	}
	
	void sort(){
		int left = 0;
		int right = inputList.length - 1;
		this.sort(left, right);
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
		
		int leftArr[] = new int [nLeft];
		int rightArr[] = new int [nRight];
		
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
	
}
