import java.lang.Math;
public class RandomCoordinatePoint {
	
	double RANGE = (30000) + 1;   
	
	public CoordinatePoint randomizeP(){
		
	CoordinatePoint randomP = new CoordinatePoint(Math.random()*RANGE, Math.random()*RANGE);
	
	return randomP;
	}
}
