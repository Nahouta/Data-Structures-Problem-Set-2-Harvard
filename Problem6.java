import java.util.*;

public class Problem6{
    
    public static int removeDups (int [] arr) {
        /*Handling the cases of null and empty arrays */
        if (arr == null) {
            throw new IllegalArgumentException("Null Pointer Array");
        }
        else if (arr.length == 0) {
            return 0;
        }

        /*In order to avoid moving one element many times, we create a variable leftshift that keeps track of
         * the shifting between the current index i and the rightmost unique value of the values at the left of the table.
         * For any displacement of value needed, we will directly displace by the shitf amount once and for all.
         * Thus, we only move each element ONCE.
         */

        int leftshift = 0;
        int numUnique = 1;

        for (int i = 1; i < arr.length; i++) {
            /*If there is a duplicate, set it to zero, increase the shift by one */
            if (arr[i] == arr[i - leftshift - 1]) {
                arr[i] = 0;
                leftshift++;
            }
            else {
                /*If current element is different from the previous and there is no shift, simply increase the count of unique values */
                if (leftshift == 0) {
                    numUnique++;
                }
                /*If the current element is a duplicate and there is a shift, make the shift, set the current element to zero and move on */
                else {
                    arr[i - leftshift] = arr[i];
                    arr[i] = 0;
                    numUnique++;
                }

            }
        }

        return numUnique;
    }

    public static void main (String [] args) {
        /*Original Test Case */
        int[] a1 = {2, 5, 5, 5, 10, 12, 12};
        int numUnique = removeDups(a1);
        System.out.println(Arrays.toString(a1));
        System.out.println(numUnique);

        /*Three additional Test cases */
        int[] a2 = {0, 2, 3, 5, 6, 8, 8, 8, 9, 11, 15, 16, 16, 23, 23};
        int numUnique2 = 0;

        int[] a3 = {2, 5, 7, 11, 13, 17, 19, 23, 29};
        int numUnique3 = 0;

        int[] a4 = {};
        int numUnique4 = 0;
        
        System.out.println("\nThe following program will take an already sorted array and remove all duplicates, and return the number of unique values.");
        System.out.println("\nTest 2: array before removal: " + Arrays.toString(a2));
        numUnique2 = removeDups(a2);
        System.out.println("Array after removal: " + Arrays.toString(a2));
        System.out.println("Number of unique values: " + numUnique2);    
        
        System.out.println("\nTest 3: array before removal: " + Arrays.toString(a3));
        numUnique3 = removeDups(a3);
        System.out.println("Array after removal: " + Arrays.toString(a3));
        System.out.println("Number of unique values: " + numUnique3); 

        System.out.println("\nTest 4: array before removal: " + Arrays.toString(a4));
        numUnique4 = removeDups(a4);
        System.out.println("Array after removal: " + Arrays.toString(a4));
        System.out.println("Number of unique values: " + numUnique4); 
        
        
    }
}