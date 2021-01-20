package MaxAndMin;

public class MaxAndMin {

    public static int MaxAndMin_Original(int arr[]) {
        int max = arr[0];
        int min = arr[0];
        int countOfStep = 0;
        for (int i = 1; i < arr.length; i++) { // ביותר הפשוט באופן המערך כל על ריצה
            countOfStep++;
            if (arr[i] > max) max = arr[i];
            countOfStep++;
            if (arr[i] < min) min = arr[i];
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        return countOfStep;
    }

    public static int MaxAndMin_LessStep(int arr[]) {

        int max = arr[0];
        int min = arr[0];
        int countOfStep = 0;
        for (int i=1; i<arr.length-1; i=i+2) { // 2 של בדילוג, המערך חצי על ריצה
            countOfStep++;
            if (arr[i]>arr[i+1]) {
                countOfStep = countOfStep + 2;
                if (arr[i] > max) max = arr[i];
                if (arr[i + 1] < min) min = arr[i + 1];
            }
                else {
                    countOfStep = countOfStep + 2;
                    if (arr[i + 1] > max) max = arr[i + 1];
                    if (arr[i] < min) min = arr[i];
            }
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        return countOfStep;
    }

    public static void main(String[] args){
        int[] arr = {2, 6, 8, 4, 1, 9, 5, 4};
        System.out.println(MaxAndMin_Original(arr));
        System.out.println(MaxAndMin_LessStep(arr));
    }
}
