//Counts the frequency of input

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class FrequencyCounter {
	
	Scanner scan;
	Scanner fileReader;
	String input;
	ArrayList<Class> classes;
	File file;
	
	
	public FrequencyCounter() throws FileNotFoundException{
		
		scan = new Scanner(System.in);
		classes = new ArrayList<Class>();
		file = new File("input/input.txt");
		fileReader = new Scanner(file);
		
	}
	
	public void countFreq() {
		
		System.out.println("How many classes would you like to create?");
		int classNo = scan.nextInt();
		int upperBound, lowerBound;
		
		for(int i = 1; i <= classNo; i++) {
			System.out.println("Enter lower bound for class " + i);
			lowerBound = scan.nextInt();
			System.out.println("Enter upper bound for class " + i);
			upperBound = scan.nextInt();
			classes.add(new Class(lowerBound, upperBound, i));
		}
		
		System.out.println("All classes created");
		System.out.println("");
		while(fileReader.hasNextLine()) {
			int number = fileReader.nextInt();
			for(int i = 0; i < classes.size(); i++) {
				if(number >= classes.get(i).getLowerBound() && number <= classes.get(i).getUpperBound()){
					classes.get(i).updateFrequency();
				}
			}
		}
		
		for(Class statClass: classes) {
			
			System.out.println("Class " + statClass.getClassNo() + "\n" +
								"Range: " + statClass.getLowerBound() + "-" + statClass.getUpperBound() + "\n" +
								"Width: " + statClass.getClassWidth() + "\n" +
								"Frequency: " + statClass.getFrequency() + "\n" +
								"Midpoint: " + statClass.getMidPt());
			System.out.println("");
		}
	}

}
