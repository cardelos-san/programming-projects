import java.util.*;

public class RecursiveDistanceCalculator {
	RandomCoordinatePoint randomP;
	DistanceCalculator calc;
	double dmax;
	int n;
	ArrayList<CoordinatePoint> list;
	CoordinatePoint midP;
	CoordinatePoint p1,p2,p3,p4,p5,p6,p7;
	
	public void initializeData(){
		dmax = 0;
		list = new ArrayList<CoordinatePoint>();
		randomP = new RandomCoordinatePoint();
		calc = new DistanceCalculator();
		double x1;
		double y1;
	
		//Creating predefined set of 6 points
		//this.inputPreset();
		
		//Creating random input size
		this.inputRandom(1000000);
		
		//Testing subLists
		//Sorting data
		Collections.sort(list);
		
		//Printing sub lists
		ArrayList<CoordinatePoint> sublistL = new ArrayList<CoordinatePoint>(list.subList(0, n/2));
		ArrayList<CoordinatePoint> sublistR = new ArrayList<CoordinatePoint>(list.subList(n/2+1, n));
		
		/*Printing whole list
		for(int i=0 ; i < list.size() ;i++){
			x1 = list.get(i).getX();
			y1 = list.get(i).getY();
			System.out.printf("%f, %f \n", x1, y1);
		}
		System.out.println("\n********Whole list done********\n");*/
		
		//Printing left list
		for(int i=0 ; i < sublistL.size() ;i++){
			x1 = sublistL.get(i).getX();
			y1 = sublistL.get(i).getY();
			System.out.printf("%f, %f \n", x1, y1);
			}
		System.out.println("\n********Left list done********\n");
		
		/*Printing right list
		for(int i=0 ; i < sublistR.size() ;i++){
			x1 = sublistR.get(i).getX();
			y1 = sublistR.get(i).getY();
			
			System.out.printf("%f, %f \n", x1, y1);
			}
		System.out.println("\n********Right list done********\n");*/
		
		//Calculate shortest distance recursively
		System.out.println("The shortest distance in left side is " + this.calculateShortest(sublistL, n));
	}
	
	public double calculateShortest(ArrayList<CoordinatePoint> list, int n){
		if(n<=3){
			return this.bruteForce(list, n);
		}
		int mid = n/2;
		//midP = list.get(mid);
		double distanceL = calculateShortest(list, mid);
		//double distanceR = calculateShortest((new ArrayList<CoordinatePoint>(list.subList(n/2+1, n))), n - mid);
		//if(distanceL < distanceR){shortestD=distanceL;}
		//else{shortestD = distanceR;}
		return distanceL;
	}
	
	public void inputPreset(){
		p1 = new CoordinatePoint(2,3);
		p2 = new CoordinatePoint(12,30);
		p3 = new CoordinatePoint(2,4);
		p4 = new CoordinatePoint(40,50);
		p5 = new CoordinatePoint(5,1);
		p6 = new CoordinatePoint(12,10);
		p7 = new CoordinatePoint(3,4);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		n = 7;
	}
	
	public void inputRandom(int inputSize){
		n = inputSize;
		for(int i = 0; i<n;i++){
			list.add(randomP.randomizeP());
		}
	}
	
	public double bruteForce(ArrayList<CoordinatePoint> list, int n){
		double x1;
		double y1;
		double x2;
		double y2;
		double distance;
		double dmin = Double.POSITIVE_INFINITY;	
		for(int i=0 ; i < n ;i++){
			for (int j = i+1 ;j<n;j++){
			x1 = list.get(i).getX();
			y1 = list.get(i).getY();
			x2 = list.get(j).getX();
			y2 = list.get(j).getY();
			distance = calc.calculateDistance(x1, x2, y1, y2);
				if(distance < dmin){
					dmin = distance;
				}
			}
		}
		return dmin;
	}
}