import java.util.*;

public class Problem7 {

    public static int[] intersect(int[] a1, int[] a2) {

        /*Checking if the arrays passed are null pointers */
        if (a1 == null || a2 == null) {
            throw new IllegalArgumentException("Null Pointer provided");
        }

        /*If anyone of the arrays is the empty array, we return the empty array. */
        if (a1.length == 0 || a2.length == 0) {
            int [] empty = new int [0];
            return empty;
        }

        /*We begin by sorting both arrays using mergeSort.
         * We use merge sort because it has the lowest time complexity, and 
         * there is no cap on Memory complexity for this problem
         */
        Sort.mergeSort(a1);
        Sort.mergeSort(a2);

        /*We retrieve the size of the smallest of the two arrays */
        int minlength = 0;

        if (a1.length < a2.length) {
            minlength = a1.length;
        }
        else {
            minlength = a2.length;
        }

        /*We keep three indices:
         * i for array a1
         * j for array a2
         * k for the newly created intersection array merged[]
         * k represents the index where we would place any newly found intersection.
         * merged[] will be created will all of its values initialized at zero
         */
        int [] merged = new int [minlength];
        int i = 0;
        int j = 0;
        int k = 0;

        /*We iterate as long as i and j are less than the size of their respective arrays 
         * k is always incremented alongside i and j, so no risk of outofbounds
        */
        while (i < a1.length && j < a2.length) {
            /*When the first intersection is found, we put it in the merge[] array*/
            if (a1[i] == a2[j] && k == 0 ) {
                merged[k] = a1[i];
                i++;
                j++;
                k++;   
            }
            /*When the second or higher intersection is found, if it was already present in 
            the merged array, we move on
            */
            else if (a1[i] == a2[j] && a1[i] == merged[k-1]) {
                i++;
                j++;
            }
            /*When the second or higher intersection is found, if it was not already present in
             * the merged array, we place it, and move on
             */
            else if (a1[i] == a2[j] && a1[i] != merged[k-1]) {
                merged[k] = a1[i];
                i++;
                j++;
                k++;
            }
            /*If the values of a1 and a2 don't match, we increment the index of whichever
            *array has the smaller value
            */
            else if (a1[i] < a2[j]) {
                i++;
            }
            else if (a1[i] > a2[j]) {
                j++;
            }
        }

        /*Return the merged array */
        return merged;
    }

    public static void main (String [] args) {
        /*Original test cases */
        int[] a1 = {10, 5, 7, 5, 9, 4};
        int[] a2 = {7, 5, 15, 7, 7, 9, 10};
        int[] result1 = intersect(a1, a2);
        System.out.println(Arrays.toString(result1));

        int[] a3 = {0, 2, -4, 6, 10, 8};
        int[] a4 = {12, 0, -4, 8};
        int[] result2 = intersect(a3, a4);
        System.out.println(Arrays.toString(result2));



        /*Additional test cases: */
        int[] a5 = {-100, -50, 0, 50, 100, 50, 0, -50, -100};
        int[] a6 = {0, 0, 100, 0, 0};
        int[] a7 = {};
        int[] a8 = {50, 2, 8, 100, -3, 7};

        System.out.println("\nTest Case No. 3:");
        System.out.println("The Intersection of " + Arrays.toString(a5) + " and " + Arrays.toString(a6) + " is: \n" + Arrays.toString(intersect(a5, a6)));

        System.out.println("\nTest Case No. 4:");
        System.out.println("The Intersection of " + Arrays.toString(a7) + " and " + Arrays.toString(a8) + " is: \n" + Arrays.toString(intersect(a7, a8)));
 
    }


}
