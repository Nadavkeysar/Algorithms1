package lecture2;

public class FindMinMax {
    public static void main(String[] args) {

        int len = 10000000;
        int[] a = new int[len];
        for(int i = 0; i < a.length; i++) a[i] = (int)(Math.random() * 100);

        long startTime1 = System.currentTimeMillis();
        firstSolution(a);
        long endTime1 = System.currentTimeMillis();
        long millis1 = endTime1 - startTime1;
        System.out.println("time execute the algorithm in milliseconds: " + millis1 + "\n");

        long startTime2 = System.currentTimeMillis();
        secondSolution(a);
        long endTime2 = System.currentTimeMillis();
        long millis2 = endTime2 - startTime2;
        System.out.println("time execute the algorithm in milliseconds: " + millis2 + "\n");

        long startTime3 = System.currentTimeMillis();
        thirdSolution(a);
        long endTime3 = System.currentTimeMillis();
        long millis3 = endTime3 - startTime3;
        System.out.println("time execute the algorithm in milliseconds: " + millis3 + "\n");

    }

    public static void firstSolution(int[] a) {
        int comparisons = 0;
        int max = a[0];
        for(int i = 1; i < a.length; i++) {
            comparisons++;
            if(max < a[i]) max = a[i];
        }
        int min = a[0];
        for(int i = 1; i < a.length; i++) {
            comparisons++;
            if(min > a[i]) min = a[i];
        }
        System.out.println("\nfirst solution: ");
        System.out.println("max is: " + max + ", min is: " + min);
        System.out.println("number of comparisons: " + comparisons);
    }

    public static void secondSolution(int[] a) {
        int max = a[0], min = a[0], comparisons = 0;
        for(int i = 1; i < a.length; i++) {
            comparisons++;
            if(max < a[i]) max = a[i];
            else {
                comparisons++;
                if(min > a[i]) min = a[i];
            }
        }
        System.out.println("second solution: ");
        System.out.println("max is: " + max + ", min is: " + min);
        System.out.println("number of comparisons: " + comparisons);
    }

    public static void thirdSolution(int[] a) {
        int max = a[1], min = a[0], comparisons = 1, n = a.length;
        if(a[0] > a[1]) { max = a[0];min = a[1]; }
        for(int i = 2; i < a.length; i += 2) {
            if(a[i] <= a[i + 1]) {
                comparisons++;
                if(a[i] < min) min = a[i];
                if(a[i + 1] > max) max = a[i + 1];
            } else {
                comparisons++;
                if(a[i + 1] < min) min = a[i + 1];
                if(a[i] > max) max = a[i];
            }
            if(n % 2 != 0) {
                comparisons++;
                if(a[n - 1] > max) max = a[n - 1];
                else {
                    comparisons++;
                    if(a[n - 1] < min) min = a[n - 1];
                }
            }
        }
        System.out.println("third solution: ");
        System.out.println("max is: " + max + ", min is: " + min);
        System.out.println("number of comparisons: " + comparisons);
    }
}
