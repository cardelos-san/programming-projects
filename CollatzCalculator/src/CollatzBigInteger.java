import java.util.Scanner;
import java.math.*;

public class CollatzBigInteger {
	
	static final BigInteger mother = new BigInteger("9990020930143845079440");
	static final BigInteger zero = new BigInteger("0");
	static final BigInteger one = new BigInteger("1");
	static final BigInteger two = new BigInteger("2");
	static final BigInteger three = new BigInteger("3");
	
	public static void main (String[] args) {
			
			
			
			Scanner scan = new Scanner(System.in);
			
			int input = 0;
			
			BigInteger n = new BigInteger("0");
			
			boolean run = true;
			
			while(run == true) {
				System.out.println("Collatz Number Calculator. Select an option");
				System.out.println("1)Calculate Collatz Sequence from N to 0 \n2)Calculate Individual Collatz\n3)Quit");
				
				
				input = scan.nextInt();
				
				
				
				
				switch(input){
					case 1:
						System.out.println("Please enter N");
						n = scan.nextBigInteger();
						allCollatzFrom(n);
						break;
					case 2:
						System.out.println("Please enter N");
						n = scan.nextBigInteger();
						//Temporary to variable mother, original user input 
						individualCollatz(mother);
						break;
					case 3:
						run = false;
						System.exit(1);
					default:
						System.out.println("Not a valid choice");
				}
			}
			
			
			scan.close();
			
		}
	
	public static BigInteger individualCollatz(BigInteger n) {
		
		BigInteger collatzLength = zero;
		System.out.println("Starting with n = " + n);
		
		while (n.compareTo(one) >= 0 ){
			collatzLength = collatzLength.add(one);
			System.out.println(n);
			if(n.equals(one)){
				System.out.println("You reached n = " + n);	
				break;  	
			}  
			else if(n.mod(two).equals(zero)){
			    	
				n = n.divide(two);  	
			}  
			else{	
				n = n.multiply(three).add(one);	
			}    
		}
		
		System.out.println("Collatz Length = " + collatzLength);
		return collatzLength;
	}
	
	public static void allCollatzFrom(BigInteger n) {

		BigInteger n2 = new BigInteger(n.toString());
		BigInteger collatzLength = zero;
		BigInteger longestCollatzLength = zero;
	      
		while (n2.compareTo(one) > 0) {
			collatzLength = individualCollatz(n2);
			if(collatzLength.compareTo(longestCollatzLength) > 0) {
				longestCollatzLength = collatzLength;
				}
			collatzLength = zero;
			n2 = n2.subtract(one);
			}
		   System.out.println("Longest Collatz length was " + longestCollatzLength + "\n");
	}

}
