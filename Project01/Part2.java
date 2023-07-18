/*
 * AUTHOR: Cooper Harris
 * FILE: Part2.java
 * PURPOSE: Contains a single method that pushes all 0s in an array to the far right side
 */

public class Part2 {
	
	/*
     * This method alters an array to place all 0s in the array on the right hand side.
     * 
     * @param a - an Array
     * 
     * @return null 
     */
	public static void pushZeroes(Array a) {
		int i = 0;
		
		for (int j = 0; j < a.length(); j++) {
			// if the current value is not equal to 0, swap it with the index of the last
			// found 0. i increments only on non 0s
            if (a.getVal(j) != 0) {
            	int temp = a.getVal(j);
                a.setVal(j, a.getVal(i));
                a.setVal(i, temp);
                i++;
            }
        }
	}
}
