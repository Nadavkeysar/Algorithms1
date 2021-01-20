package Balls;

public class Balls {
//    public static void useFloorPotential(int a, int[] arr) {
//        int num = 1;
//        int numFloors = arr.length;
//        int number = 0;
//        while (numFloors > num * (num + 1) / 2)
//            number++;
//        int jump = num;
//        int step = num - 1;
//        while (arr[jump] < a) {
//            jump += step;
//            step -= 1;
//        }
//        System.out.println("The first ball breaks at floor" + jump);
//        int floor = jump - (step + 1);
//        while (arr[floor] < a)
//            floor++;
//        System.out.println("The second ball is broken at floor number" + floor);
//    }
//
//    public static int numberOfChecking(int n) {
//        int numChecks = 0;
//        int[] f = new int[n + 1];
//        if (n == 1) numChecks = 1;
//        else if (n == 2) numChecks = 2;
//        else {
//            f[0] = 0;
//            f[1] = 1;
//            f[2] = 2;
//            for (int i = 3; i < n; i++) {
//                int min = n;
//                for (int j = 1; j < i; j++) {
//                    int x = Math.max(j, f[i - j]);
//                    if (x < min) min = x;
//                }
//                f[i] = min;
//            }
//            numChecks = f[n];
//        }
//        return numChecks;
//    }

    static int compares = 0;

    /**
     * complexity: O(2 * sqrt (n))
     */
    public static int break_ball(int[] floor, int ball) {
        if (ball >= floor[floor.length - 1]) return -1; // doesn't break
        compares = 0;
        int index = 1;
        int d = (int) Math.sqrt(floor.length);
        int i = d;
        while (i <= floor.length) {
            compares++;
            if (ball < floor[i - 1]) {
                index = i - d + 1;
                while (ball >= floor[index - 1]) {
                    compares++;
                    index++;
                }
                break;
            }
            i += d;
            if (i > floor.length) i = floor.length;
        }
        return index;
    }

    /**
     * complexity: O(sqrt (2) * sqrt (n))
     */
    public static int break_ball2(int[] floor, int ball) {
        if (ball >= floor[floor.length - 1]) return -1;  // doesn't break
        compares = 0;
        int index = 1;
        int d = 0;

        while (floor.length > d * (d + 1) / 2) {
            d++;
        }
        int i = d;

        while (i <= floor.length) {
            compares++;
            if (ball < floor[i - 1]) {
                index = i - d + 1;
                while (ball >= floor[index - 1]) {
                    compares++;
                    index++;
                }
                break;
            }
            d--;
            i += d;
            if (i > floor.length) i = floor.length;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 40, 50, 70, 80};
        int b = 5;
        System.out.println(break_ball2(array, b));
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int a = 0;
        System.out.println(break_ball2(arr, a));
        int[] array2 = {10, 20, 30, 40, 50, 60, 70};
        int b2 = 25;
        System.out.println(break_ball2(array2, b2));
    }
}
