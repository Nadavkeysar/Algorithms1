package lecture3;

public class Factorial {
    public static void main(String[] args) {

        int n = 25;

        long startTime1 = System.currentTimeMillis();
        System.out.println(recursiveFactorial(n));
        long endTime1 = System.currentTimeMillis();
        long millis1 = endTime1 - startTime1;
        System.out.println("time execute the algorithm in milliseconds: " + millis1 + "\n");

        long startTime2 = System.currentTimeMillis();
        System.out.println(loopFactorial(n));
        long endTime2 = System.currentTimeMillis();
        long millis2 = endTime2 - startTime2;
        System.out.println("time execute the algorithm in milliseconds: " + millis2 + "\n");

    }

    public static long recursiveFactorial(int n) {
        if(n == 0) return 1;
        return n * recursiveFactorial(n - 1);
    }

    public static long loopFactorial(int n) {
        long ans = 1;
        while(n > 0) {
            ans *= n;
            n--;
        }
        return ans;
    }
}
