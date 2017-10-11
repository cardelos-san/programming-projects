import java.util.*;

public class RecursiveDistanceCalculator {
	
	
	RandomCoordinatePoint randomP;
	DistanceCalculator calc;
	
	double dmax;
	int n;
	ArrayList<CoordinatePoint> list;
	CoordinatePoint midP;
	
	
	
	public void initializeData(){
		
		
		dmax = 0;
		list = new ArrayList<CoordinatePoint>();
		randomP = new RandomCoordinatePoint();
		calc = new DistanceCalculator();
		
		double x1;
		double y1;
		
		
		//Creating input size
		n = 10;
		for(int i = 0; i<n;i++){
			list.add(randomP.randomizeP());
		}
		
		//Testing subLists
		//Sorting data
		Collections.sort(list);
		
		//Printing sub lists
		ArrayList<CoordinatePoint> sublistL = new ArrayList<CoordinatePoint>(list.subList(0, n/2));
		ArrayList<CoordinatePoint> sublistR = new ArrayList<CoordinatePoint>(list.subList(n/2+1, n));
		
		//Printing whole list
		for(int i=0 ; i < list.size() ;i++){
		x1 = list.get(i).getX();
		y1 = list.get(i).getY();
		
		System.out.printf("%f, %f \n", x1, y1);
		}
		
		System.out.println("\n********Whole list done********\n");
		
		//Printing middle left list
		for(int i=0 ; i < sublistL.size() ;i++){
			x1 = sublistL.get(i).getX();
			y1 = sublistL.get(i).getY();
			
			System.out.printf("%f, %f \n", x1, y1);
			}
		
		System.out.println("\n********Left list done********\n");
		
		//Printing middle right list
		for(int i=0 ; i < sublistR.size() ;i++){
			x1 = sublistR.get(i).getX();
			y1 = sublistR.get(i).getY();
			
			System.out.printf("%f, %f \n", x1, y1);
			}
		
		System.out.println("\n********Right list done********\n");
		
		
		
		
		//Calculate shortest distance recursively
		
		System.out.println("The shortest distance in left side is " + this.calculateShortest(list, n));
		
		
	}
	
	public double calculateShortest(ArrayList<CoordinatePoint> list, int n){
		
		if(n<=3){
			
			return this.bruteForce(list, n);
		}
		
		int mid = n/2;
		
		//midP = list.get(mid);
		
		
		//double distanceL = calculateShortest((new ArrayList<CoordinatePoint>(list.subList(0, n/2))), mid);
		//double distanceR = calculateShortest((new ArrayList<CoordinatePoint>(list.subList(n/2+1, n))), n - mid);
		
	
		
		//if(distanceL < distanceR){shortestD=distanceL;}
		
		//else{shortestD = distanceR;}
		
		return calculateShortest(list, mid);
		
		
		
		
		
	}
	
	public double bruteForce(ArrayList<CoordinatePoint> list, int n){
		
		double x1;
		double y1;
		double x2;
		double y2;
		double distance;
		double dmin = Double.POSITIVE_INFINITY;	
		
		for(int i=0 ; i < n - 1 ;i++){
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
	

