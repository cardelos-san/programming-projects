import java.util.*;
public class BruteForceClosestPoint {
	
	CoordinatePoint p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,
	p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30;
	
	RandomCoordinatePoint randomP = new RandomCoordinatePoint();
	Calculator2 calc;
	double x1;
	double x2;
	double y1;
	double y2;
	double distance;
	double dmin = Double.POSITIVE_INFINITY;	
	double dmax = 0;
	int n;
	
	ArrayList<CoordinatePoint> list = new ArrayList<CoordinatePoint>();
	
	public void calculateShortest(){
		
	
		
		
		calc = new Calculator2();
		
		n = 1000;
		for(int i = 0; i<n;i++){
			list.add(randomP.randomizeP());
		}
		
		//Just printing the values of x and y
		/*for(int i=0 ; i < list.size() ;i++){
			x1 = list.get(i).getX();
			y1 = list.get(i).getY();
			
			System.out.printf("%f, %f \n", x1, y1);
		} */
		
		//Calculating distances of all objectsS
		for(int i=0 ; i < list.size() - 1 ;i++){
			for (int j = i+1 ;j<list.size();j++){
			x1 = list.get(i).getX();
			y1 = list.get(i).getY();
			x2 = list.get(j).getX();
			y2 = list.get(j).getY();
			distance = calc.calculateDistance(x1, x2, y1, y2);
			System.out.println(distance);
			
				if(distance < dmin){
					dmin = distance;
				}
				
				else if(distance > dmax){
					dmax = distance;
				}
			}
			
		 }
		
		
		System.out.println("The shortest distance was " + dmin);
		System.out.println("THe longest distance was " + dmax);
	}
}
