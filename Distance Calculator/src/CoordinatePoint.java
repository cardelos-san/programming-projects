
public class CoordinatePoint implements Comparable<CoordinatePoint> {
	
	private double x;
	private double y;
	final int LESS = -1;
	final int EQUAL = 0;
	final int GREATER = 1;

	public CoordinatePoint(double x, double y){
		this.x = x;
		this.y = y;
	}

	public double getX(){return x;}
	
	public double getY(){return y;}

	@Override
	public int compareTo(CoordinatePoint p) {
		
		
		/*If return GREATER, descending order
		 * If return LESS, ascending order*/
		if(p.getX() > this.x)return LESS;
		
		if(p.getX() == this.x)return EQUAL;
		
		else return GREATER;
	}
	
}
