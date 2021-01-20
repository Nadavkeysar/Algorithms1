package maraton2;

import java.util.Arrays;
import java.util.Comparator;

public class Race {

    /**
     * n^2 horses - an array of speeds
     * @param horses
     * @return count - number of races
     */

    public static int print3Most(int[] horses) {
        int n = (int)Math.sqrt(horses.length);
        int[][] ans = new int[n][n];
        int k = 0, count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ans[i][j] = horses[k++];
            }
            count++;
            race(ans[i], n);
        }
        count++; race(ans, n);
        int cand[] = { ans[n-1][n-2], ans[n-1][n-3], ans[n-2][n-1], ans[n-2][n-2], ans[n-3][n-1] };
        count++; race(cand, 5);

        System.out.println("1nd: " + cand[n-1]);
        System.out.println("2nd: " + cand[n-2]);
        System.out.println("3nd: " + cand[n-3]);
        return count;
    }

    // n^2 horses - horses speed array
    // n - number of horses in a race
    public static void race(int[] horses, int n) {
        if(horses.length == n) Arrays.sort(horses);
    }

    public static void race(int[][] horses, int n) {
        if(horses.length == n) Arrays.sort(horses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[n-1] < o2[n-1]) return -1;
                if(o1[n-1] > o2[n-1]) return 1;
                return 0;
            }
        });
    }

    public static void main(String[] args) {
        int[] horses = {4,6,12,12,20,1,2,3,7,15,11,13,17,21,25,4,5,14,23,24,9,16,17,18,19};
        System.out.println(print3Most(horses));
    }
}
