import java.util.*;
public class SortingApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Input input = new Input();
		int select;
		System.out.println("Would you like to enter input or create random input?");
		System.out.println("1) Enter input \n2) Create random input");
		select = scan.nextInt();
		switch (select) {
			case 1:
				System.out.println("Please enter your values and press enter. Enter 00 to finish");
				float x = scan.nextFloat();
				while(x != 00) {
					input.userInput(x);
					x = scan.nextFloat();	
				}
				input.userInput2Array();
				break;
			case 2:
				System.out.println("Select input size:");
				System.out.println("1) 10 \n2) 10K \n3) 100K \n4) 10M \n5) 100M ");
				select = scan.nextInt();
				
				switch (select){
					case 1: 
						input.createInput(10);
						break;
					case 2: 
						input.createInput((int) Math.pow(10,4));
						break;
					case 3: 
						input.createInput((int) Math.pow(10,5));
						break;
					case 4: 
						input.createInput((int) Math.pow(10,7));
						break;
					case 5: 
						input.createInput((int) Math.pow(10,8));
						break;
					default:
						System.out.println("Invalid selection");
				}
			default:
				System.out.println("Invalid selection");
		}
			
		System.out.println("Select sorting method: ");
		System.out.println("1) Merge Sort \n2) Shell Sort ");
		select = scan.nextInt();
		
		switch (select){
			case 1: 
				MergeSort mSort = new MergeSort(input.getArray());
				System.out.println("**********Sorting using Merge Sort**********\n");
				input.printArray();
				mSort.sort();
				System.out.println("\n");
				System.out.println("**********Sorting Finished**********\n");
				mSort.printArray();
				System.out.println("\n");
				//input is not sorted, call method to get sorted list
				System.out.println("Mean: " + input.getMean() + "\n" + "Median: " + input.getMedian());
				System.out.println("Execution time was: " + mSort.execTime() + " milliseconds");
				break;
			case 2:
				ShellSort sSort = new ShellSort(input.getArray());
				System.out.println("**********Sorting using Shell Sort**********\n");
				input.printArray();
				sSort.sort();
				System.out.println("\n");
				System.out.println("**********Sorting finished**********\n");
				sSort.printArray();
				System.out.println("\n");
				System.out.println("Execution time was: " + sSort.execTime() + " milliseconds");
				break;
			default:
				System.out.println("Invalid Selection");
		}
		
		scan.close();
		System.exit(0);
	}
}
