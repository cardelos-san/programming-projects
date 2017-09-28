public class Calculator2 {
	
	double x1;
	double x2;
	double y1;
	double y2;
	double sum;
		
	public double calculateDistance(double x1, double x2,
			double y1, double y2){
		
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		sum = Math.sqrt((Math.pow(y2-y1,2))+(Math.pow(x2-x1,2)));
		
		return sum;
		
		
		
	}

}
