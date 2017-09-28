import java.util.*;


public class Calculator {
	
	
	public Calculator(int x, int b){
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		double x1;
		
		double x2;
		
		double y1;
		
		double y2;
		
		double sum;
		
		
		System.out.println("Enter x1");
		
		x1 = scan.nextDouble();
		
		System.out.println("Enter x2");
		
		x2 = scan.nextDouble();
		
		System.out.println("Enter y1");
		
		y1 = scan.nextDouble();
		
		System.out.println("Enter y2");
		
		y2 = scan.nextDouble();
		
		
		sum = Math.sqrt((Math.pow(y2-y1,2))+(Math.pow(x2-x1,2)));
		
		System.out.println(sum);
		
		System.exit(0);
		
		
		
	}

}
