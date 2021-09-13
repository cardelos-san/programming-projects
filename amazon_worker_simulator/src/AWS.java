

import java.util.*;
public class AWS {
	
	View view;
	Calculator calculate;
	Scanner scan;
	int avgSteps;
	int stepstoMiles;
	int suv_weight;
	int breakTimeHours;
	
	
	
	public AWS() {
		view = new View();
		calculate = new Calculator();
		scan = new Scanner(System.in);
		avgSteps = calculate.avgSteps();
		stepstoMiles = 2250;
		suv_weight = 3590;
		breakTimeHours = 1;
	}
	
	
	public void run() {
		
		view.print("This program simulates what it is like being an amazon worker. Data is generated based on input, real life surveys, and estimates");
		view.print("Working at Amazon as a Tier 1 Associate can be very demanding. Workers usually work 40 hours a week, and sometimes 50 hours depending on mandatory overtime");
		
		view.print("Please enter a name for your Amazon Worker");
		String name = scan.next();
		view.print("Please enter how many hours you work in day");
		int hours = scan.nextInt();
		view.print("Please enter the scanning rate at your station");
		int rate = scan.nextInt();
		view.print("How many steps do you take at work?");
		int steps = scan.nextInt();
		
		
		Worker worker = new Worker(name, rate, steps, hours);
		int totalBoxes = calculate.boxCountDay(worker.getRate(), (worker.getHours()-breakTimeHours));
		System.out.println(worker.getHours());
		
		view.print("According to survery data, the average amazon worker takes " + avgSteps + " steps in one day, which is around " + (avgSteps/stepstoMiles) + 
				" miles and has to lift anywhere from 0 to 50 pounds");
		view.print("As a Amazon Associate who sorts packages, " + worker.getName() + " has to walk this many steps, " + "roughly " + (worker.getHours()- breakTimeHours) + 
				" hours a day (accounting for 1 hour of break time)");
		view.print(worker.getName() + " carries about " + totalBoxes + " boxes");
		int totalWeight = calculate.poundsLifted(totalBoxes);
		view.print("And lifts an average total of " + totalWeight + " pounds everyday at work, which is equivalent to " + (totalWeight/suv_weight) + " compact SUV's");
		
		
		
		
		
	}
	 

	

}
