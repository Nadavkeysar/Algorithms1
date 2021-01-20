package lecture3;

public class Fibonacci {

    public static void main(String[] args) {

        long startTime1 = System.currentTimeMillis();
        System.out.println(recursiveFibonacci(45));
        long endTime1 = System.currentTimeMillis();
        long millis1 = endTime1 - startTime1;
        System.out.println("time execute the algorithm in milliseconds: " + millis1 + "\n");

        long startTime2 = System.currentTimeMillis();
        System.out.println(fibonacciLoop(45));
        long endTime2 = System.currentTimeMillis();
        long millis2 = endTime2 - startTime2;
        System.out.println("time execute the algorithm in milliseconds: " + millis2 + "\n");


    }

    public static long recursiveFibonacci(int n) {
        if(n <= 2) return 1;
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static long fibonacciLoop(int n) {
        if(n <= 2) return 1;
        long f1 = 1, f2 = 1, ans = 0;
        for(int i = 3; i <= n; i++) {
            ans = f1 + f2;
            f1 = f2;
            f2 = ans;
        }
        return ans;
    }
}