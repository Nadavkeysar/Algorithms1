package MaxAndMax;

import java.util.Stack;

/**
 * Three algorithms search for 2 largest elements of an array.
 * Each function returns the number of comparisons
 * A={arr[0], arr[1], . . . ,arr[arr.length]}
 * max1 = maximum{A}
 * max2 = maximum{A\max1}
 * Remark: the start values of max1, max2 must be different.
 * Assumptions:
 * 1)elements of the array are different
 * 2) array length > 2
 **/
public class max1max2 {

    public static int twoMaxPairs1(int arr[]) {//(3/2)*n comparisons
        // initialization
        int max1 = arr[0];
        int max2 = arr[1];
        if (max1 < max2) {
            max1 = arr[1];
            max2 = arr[0];
        }
        int comparisons = 0;//arr.length/2 - 1;
        // the main loop
        for (int i = 2; i < arr.length - 1; i = i + 2) {
            comparisons++;
            if (arr[i] > arr[i + 1]) {
                comparisons++;
                if (arr[i] > max1) {
                    // max2 = max(max1, arr[i+1])
                    comparisons++;
                    if (max1 > arr[i + 1]) {
                        max2 = max1;
                    }
                    else {
                        max2 = arr[i + 1];
                    }
                    max1 = arr[i];
                }
                else {
                    comparisons++;
                    if (arr[i] > max2) max2 = arr[i];
                }
            }
            else {
                comparisons++;
                if (arr[i + 1] > max1) {
                    // max2 = max(max1, arr[i])
                    comparisons++;
                    if (max1 > arr[i]) {
                        max2 = max1;
                    }
                    else {
                        max2 = arr[i];
                    }
                    max1 = arr[i + 1];
                }
                else {
                    comparisons++;
                    if (arr[i + 1] > max2) max2 = arr[i + 1];
                }
            }
        }
        comparisons++;
        if (arr.length % 2 != 0) {
            comparisons++;
            if (arr[arr.length - 1] > max1) {
                max2 = max1;
                max1 = arr[arr.length - 1];
            }
            else {
                comparisons++;
                if (arr[arr.length - 1] > max2) max2 = arr[arr.length - 1] ;
            }
        }
        // print the result:
        System.out.println("max1 = " + max1 + ", max2 = " + max2);
        return comparisons;
    }


    public static void checkCorrectness() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int comparisons = twoMaxPairs1(arr);
        System.out.println("loop comparisons = " + comparisons);
    }

    public static void main(String[] args) {
        checkCorrectness();
    }
}
