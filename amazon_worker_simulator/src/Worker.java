//Model of an Amazon worker
public class Worker {
	
	private String Name;
	private int rate; int steps; int hours; int breakTime;
	public Worker(String Name, int rate, int steps, int hours) {		
		this.Name = Name;
		this.rate = rate;
		this.steps = rate;	
		this.hours = hours;
	}
	
	public String getName() {
		return Name;
	}
	
	public int getRate() {
		return rate;
	}
	
	public int getSteps() {
		return steps;
	}
	
	public int getHours() {
		return hours;
	}
	
	


}
