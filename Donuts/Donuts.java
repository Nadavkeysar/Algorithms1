package Donuts;

public class Donuts {
    public static int getTime(int numOfSuf, int numOfPlace){
        int tempTime = 0;
        if (numOfPlace >= numOfSuf) return 2;
        if (numOfSuf % numOfPlace == 0) return (numOfSuf/numOfPlace)*2;
        int shalem = (numOfSuf/numOfPlace) - 1;
        tempTime = shalem*2 + 3;
        return tempTime;
    }

    public static void main(String[] args){
        System.out.println(getTime(9, 3));
    }
}
