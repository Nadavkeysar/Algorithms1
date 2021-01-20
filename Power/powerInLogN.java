package Power;

public class powerInLogN {
    /**
     * returns x^n
     * Complexity: O(log n)
     */
    public static double powInd(double x, int n) {
        double ans = 1;
        while (n != 0) {
            if (n % 2 == 1) ans *= x;
            x = x * x;
            n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println("2^" + i + " = " + (int) powInd(2, i));
        }
    }
}
