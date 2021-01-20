package Secretary;

import java.util.Arrays;

public class Secretary {
    public static double getAverageTime(int[] times){
        Arrays.sort(times);
        double avg = 0;
        for (int i : times) avg = avg + avg + i;
        return  avg/times.length;
    }

    public static void main(String[] args){
        int[] arr = {7, 9, 3, 3, 10, 0, 2};
        System.out.println(getAverageTime(arr));
    }
}
