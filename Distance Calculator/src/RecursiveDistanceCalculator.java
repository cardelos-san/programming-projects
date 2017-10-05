import java.util.*;

public class RecursiveDistanceCalculator {
	
	/*for(int i=0 ; i < list.size() ;i++){
	x1 = list.get(i).getX();
	y1 = list.get(i).getY();
	
	System.out.printf("%f, %f \n", x1, y1);
}*/
	
	RandomCoordinatePoint randomP;
	Calculator2 calc;
	double x1;
	double x2;
	double y1;
	double y2;
	double distance;
	double dmin;
	double dmax;
	int n;
	ArrayList<CoordinatePoint> list;
	
	
	
	public void initializeData(){
		
		dmin = Double.POSITIVE_INFINITY;	
		dmax = 0;
		list = new ArrayList<CoordinatePoint>();
		randomP = new RandomCoordinatePoint();
		calc = new Calculator2();
		
		
		//Creating input size
		n = 1000000;
		for(int i = 0; i<n;i++){
			list.add(randomP.randomizeP());
		}
		
		//Sorting data
		Collections.sort(list);
		
		for(int i=0 ; i < list.size() ;i++){
		x1 = list.get(i).getX();
		y1 = list.get(i).getY();
		
		System.out.printf("%f, %f \n", x1, y1);
	}
		
		
		//Calculate shortest distance recursively
		//this.calculateShortest(n);
		
	}
	
	public int calculateShortest(int n){
		
		
		
		return calculateShortest(n/2);
	}
		
		
		
		
		
		
		
		
		

}
	

