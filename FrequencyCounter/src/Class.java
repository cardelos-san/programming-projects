
public class Class {
	
	private int lowerBound;
	private int upperBound;
	private int classNo;
	private int frequency;
	private float midpt;
	private int width;
	
	public Class(int lowerBound, int upperBound, int classNo) {
		
		this.classNo = classNo;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.frequency = 0;
	}
	
	public float getMidPt() {
		midpt = (upperBound + lowerBound) /2;
		return midpt;
	}
	
	public int getClassWidth() {
		width = upperBound - lowerBound;
		return width;
	}
	
	public void updateFrequency() {
		frequency++;
	}
	public int getClassNo() {return classNo;}
	
	public int getFrequency() {return frequency;}
	
	public int getLowerBound() {return lowerBound;}
	
	public int getUpperBound(){return upperBound;}
}
