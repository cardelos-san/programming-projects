import java.util.*;
public class SortingApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Input input = new Input();
		System.out.println("Select input size: ");
		System.out.println("1) 10K \n2) 100K \n3) 10M \n4) 100M ");
		int select = scan.nextInt();
		
		switch (select){
			case 1: 
				input.createInput((int) Math.pow(10,4));
				break;
			case 2: 
				input.createInput((int) Math.pow(10,5));
				break;
			case 3: 
				input.createInput((int) Math.pow(10,7));
				break;
			case 4: 
				input.createInput((int) Math.pow(10,8));
				break;
			case 5: input.createInput(10);
			default:
				System.out.println("Invalid selection");
		}
		
		System.out.println("Select sorting method: ");
		System.out.println("1) Merge Sort \n2) ???? ");
		select = scan.nextInt();
		
		switch (select){
			case 1: 
				MergeSort mSort = new MergeSort(input.getArray());
				System.out.println("*************Printing Original Arrray************* \n");
				input.printArray();
				mSort.sort();
				System.out.println("*************Printing Sorted Arrray*************\n");
				mSort.printArray();
				
				break;
			case 2: 
				break;
			default:
				System.out.println("Invalid Selection");
		}
		
		scan.close();
		System.exit(0);
	}
}
