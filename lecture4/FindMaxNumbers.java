package lecture4;

import java.util.Arrays;

public class FindMaxNumbers {
    public static void main(String[] args) {

        int n = 30, i = 0;
        int[] arr = new int[n];
        while(i < n) {
            arr[i] = (int)(Math.random() * 100);
            i++;
        }
        System.out.println(Arrays.toString(arr) + "\n\n\n");

        System.out.println("\ntwoMaxA:");
        twoMaxA(arr);

        System.out.println("\ntwoMaxB:");
        twoMaxB(arr);

        System.out.println("\ntwoMaxC:");
        twoMaxC(arr);

        System.out.println("\ntwoMaxD:");
        twoMaxD(arr);

    }

    public static void twoMaxA(int[] a) {

        int max1 = 0, max2 = 0, comparisons = 0;

        // getting the max number in the array (max1)
        for(int i = 1; i < a.length; i++) {
            comparisons++;
            if(a[i] > a[max1]) max1 = i;
        }

        // swap max1 index and last index
        swap(a, a.length - 1, max1);

        // getting the max number in the array - 1 (max2)
        for(int i = 0; i < a.length - 1; i++) {
            comparisons++;
            if(a[i] > a[max2]) max2 = i;
        }

        System.out.println("max1: " + a[a.length - 1]);
        System.out.println("max2: " + a[max2]); 
        System.out.println("comparisons: " + comparisons);

    }

    public static void twoMaxB(int[] a) {

        int i = 1;
        while(i < a.length && a[i - 1] == a[i]) i++;
        int max1 = Math.max(a[i - 1], a[i]);
        int max2 = Math.min(a[i - 1], a[i]);

        int comparisons = 0;
        i = 2;
        for(; i < a.length; i++) {
            comparisons++;
            if(a[i] > max1) {
                max2 = max1;
                max1 = a[i];
            } else {
                comparisons++;
                if(a[i] > max2) max2 = a[i];
            }
        }

        System.out.println("max1: " + max1);
        System.out.println("max2: " + max2);
        System.out.println("comparisons: " + comparisons);

    }

    public static void twoMaxC(int[] a) {

        int i = 1;
        while (i < a.length && a[i - 1] == a[i]) i++;
        int max1 = Math.max(a[i - 1], a[i]);
        int max2 = Math.min(a[i - 1], a[i]);

        int comparisons = 0;

        i = 2;
        for(; i < a.length; i++) {
            if(a[i] > max2) {
                comparisons++;
                if(a[i] < max1) max2 = a[i];
                else {
                    max2 = max1;
                    max1 = a[i];
                }
            }
        }
        System.out.println("max1: " + max1);
        System.out.println("max2: " + max2);
        System.out.println("comparisons: " + comparisons);

    }

    public static void twoMaxD(int[] a) {

        int i = 1;
        while (i < a.length && a[i - 1] == a[i]) i++;
        int max1 = Math.max(a[i - 1], a[i]);
        int max2 = Math.min(a[i - 1], a[i]);

        int comparisons = 0;

        i = 2;
        for(; i < a.length - 1; i++) {
            comparisons++;
            if(a[i] >= a[i + 1]) {
                comparisons++;
                if(a[i] > max1) {
                    comparisons++;
                    max2 = Math.max(max1, a[i + 1]);
                    max1 = a[i];
                } else {
                    comparisons++;
                    if(a[i] > max2) max2 = a[i];
                }
            } else { // a[i] < a[i + 1]
                comparisons++;
                if(a[i + 1] > max1) {
                    comparisons++;
                    max2 = Math.max(max1, a[i]);
                    max1 = a[i+1];
                } else {
                    comparisons++;
                    if(a[i + 1] > max2) max2 = a[i + 1];
                }
            }
        }
        System.out.println("max1: " + max1);
        System.out.println("max2: " + max2);
        System.out.println("comparisons: " + comparisons);
    }

    private static void swap(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
}
