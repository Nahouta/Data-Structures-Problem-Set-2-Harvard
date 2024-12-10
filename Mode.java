import java.util.Arrays;

public class Mode {

    private static int findMode(int[] arr) {
        /*We begin by sorting the array. Once sorted, all equal elements will be grouped together */
        mergeSort(arr);

        /*We start by assuming that the first element of the sorted array is the mode with one occurence*/
        int mode = arr[0];
        int maxNum = 0;

        /*tempNum tracks the number of occurences of each element being evaluated as mode */
        int tempNum = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] == arr[i]) {
                tempNum ++;
            }
            else {
                /*If the next element is different from the previous one, the previous would be the mode
                 * only if its total number of occurences is larger than the highest recorded.
                 * In this case, we assign the new mode and reset the count.
                 */
                if (tempNum > maxNum) {

                    maxNum = tempNum;
                    mode = arr[i];
                    
                    tempNum = 1;
                }
                else {
                /*If the next element is different from the previous one, and the previous element has a lower
                 * number of counts, then it failed to be the new mode. We just reset the temporary count and
                 * evaluate the next element.
                 */
                    tempNum = 1; 
                }
            }
        }

        /*We finally verify if the last element is the mode, since the end of its series is 
        * caused by the end of the array and we couldn't verify how many occurences it was at the end
        */       
        if (tempNum > maxNum) {
            mode = arr[arr.length-1];
        }


        return mode;
    }

    /* merge - helper method for mergesort */
    private static void merge(int[] arr, int[] temp, 
                              int leftStart, int leftEnd, int rightStart, int rightEnd)
    {
        int i = leftStart;    // index into left subarray
        int j = rightStart;   // index into right subarray
        int k = leftStart;    // index into temp
        
        while (i <= leftEnd && j <= rightEnd) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++; k++;
            } else {
                temp[k] = arr[j];
                j++; k++;
            }
        }
        
        while (i <= leftEnd) {
            temp[k] = arr[i];
            i++; k++;
        }
        while (j <= rightEnd) {
            temp[k] = arr[j];
            j++; k++;
        }
        
        for (i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
        }
    }
    
    /** mSort - recursive method for mergesort */
    private static void mSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int middle = (start + end)/2;
        mSort(arr, temp, start, middle);
        mSort(arr, temp, middle + 1, end);
        merge(arr, temp, start, middle, middle + 1, end);
    }
    
    /** mergesort */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mSort(arr, temp, 0, arr.length - 1);
    }






    public static void main (String [] args) {
        int [] array1 = {10, 8, 12, 8, 10, 5, 8};
        int [] array2 = {15, 5, 29, 2, 5, 11, 56, 23, 15, 2, 5, 2, 2, 5, 23};
  
        System.out.println("\nThe mode of the array " + Arrays.toString(array1) + " is: " + findMode(array1));
        System.out.println("\nThe mode of the array " + Arrays.toString(array2) + " is: " + findMode(array2));
    }


}
