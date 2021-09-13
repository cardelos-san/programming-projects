//Class contains methods to calculate number data
public class Calculator {
	
	final private double STEPS_MIN = 11000;
	final private double STEPS_MAX = 18000;
	final private int workerAmount = 10000;
	private int stepsList[];
	private int boxWeights[];
	final private int MAX_WEIGHT = 50;
	final private int MIN_WEIGHT = 0;
	
	public Calculator() {
		
	}
	
	public int avgSteps() {
		
		stepsList = new int [workerAmount];
		int sum = 0;
		
		for(int i = 0; i < workerAmount; i++){
			stepsList[i] = (int) Math.floor(Math.random()*(STEPS_MAX-STEPS_MIN+1)+STEPS_MIN);
			//System.out.println(inputList[i]);
		}
		
		for(Integer steps: stepsList){
			sum += steps;
			}
		
		return sum / stepsList.length;
		
	}
	
	public int boxCountDay(int rate, int hours) {
		
		return rate * hours;
	}
	
	public int poundsLifted(int totalBoxes) {
		
		int total = 0;
		boxWeights = new int[totalBoxes];
		for(int i = 0; i < boxWeights.length; i++) {
			
			boxWeights[i] = (int) Math.floor(Math.random()*(MAX_WEIGHT-MIN_WEIGHT+1)+MIN_WEIGHT);	
		}
		
		for(Integer weight: boxWeights){
			total += weight;
		}
		
	return total;	
		
		
	}

}
