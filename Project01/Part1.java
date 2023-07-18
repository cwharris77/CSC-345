/*
 * AUTHOR: Cooper Harris
 * FILE: Part1.java
 * PURPOSE: Contains a single method that multiplies integers
 */

public class Part1 {
	/*
     * This method returns the largest product of m consecutive integers that can be
     * found in the given array.
     * 
     * @param a - an Array
     * @param m - an integer
     * 
     * @return max - The product of m consecutive integers 
     */
	public static int maxProduct(Array a, int m) {
		int max = 0;
		int checkMax = 1; // A temporary max to compare the return max to
		int stop = 1; 	  // A variable tell when the sequence of products is at the right length
		int arrayLen = a.length();
		
		// If m is larger than the whole array set it to the largest index
		if (m >= arrayLen) {
			m = arrayLen - 1;
		}
		
		for (int i = 0; i < arrayLen; i++) {
			// if there is a 0 at the start of the product sequence, skip it
			if (a.getVal(i) == 0 && i < arrayLen - 1) {
				i += 1;
				stop = 1;
				checkMax = 1;
			}
			checkMax *= a.getVal(i); // Get the product of the current values in range m
			
			// if the correct value is reached compare the products and start the next sum with the 
			// current value
			if (stop == m) {
				max = Math.max(max, checkMax);
				checkMax /= a.getVal(i - m + 1);
				stop -= 1;
			}
			stop += 1;
		}
//		System.out.println("accessCount: " + a.getAccessCount());
//		System.out.println("m: " + m);
//		System.out.println("expected: " + (2*arrayLen + 2*m));
		
		return max;
	}
}