// package whatever; // don't place package name!

import java.io.*;
import java.util.*;
import java.math.*;

class MyCode {
	public static void main (String[] args) {
		
		System.out.println("Collatz Number Calculator. Select an option");
		
		System.out.println("1)Calculate Collatz Sequence from N to 0 \n2)Calculate Individual Collatz");
		
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		
		double n = 0;

		switch(input){
			case 1:
				System.out.println("Please enter N");
				n = scan.nextDouble();
				allCollatzFrom(n);
				break;
			case 2:
				System.out.println("Please enter N");
				n = scan.nextDouble();
				individualCollatz(n);
				break;
			default:
				System.out.println("Not a valid choice");
		}
		scan.close();
		
	}
	
	public static int individualCollatz(double n) {
		
	    int collatzLength = 0;

			System.out.println("Starting with n = " + n);
			while (n >= 1 ){
				collatzLength++;
			    System.out.println(n);
			    
			    if(n == 1){
			    	System.out.println("You reached n = " + n);	
			    	break;
			    	}
			    else if(n%2 == 0){
			    	n = n/2;
			    	}
			    else{
			    	n = 3*n+1;
			    	}
			    }
			System.out.println("Collatz Length = " + collatzLength);
			
		return collatzLength;
				
	}
	
	public static void allCollatzFrom(double n) {

		double n2 = n;
	    int collatzLength = 0;
	    int longestCollatzLength = 0;
	      
		while (n2 > 1) {
			collatzLength = individualCollatz(n2);
			if(collatzLength > longestCollatzLength) {
				longestCollatzLength = collatzLength;
				}
			collatzLength = 0;
			--n2;
			}
		   System.out.println("Longest Collatz length was " + longestCollatzLength + "\n");
	}
}



/*

Collatz sequence

n is even => n / 2
n is odd => 3 * n + 1

13 => 40 => 20 => 10 => 5 => 16 => 8 => 4 => 2 => 1 => length 10

1 to 100 ... which is the longest?

*/
