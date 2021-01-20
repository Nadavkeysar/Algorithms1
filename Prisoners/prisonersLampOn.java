package Prisoners;

public class prisonersLampOn {

    public static int prisonersLampOn(int n){
        boolean[] enter = new boolean[n];
        for (int i = 0; i < enter.length; i++)
            enter[i] = false;
        boolean lamp = true;
        int count = 0, steps = 0;
        while (count < n){
            steps++;
            int p = (int)(Math.random()*n);
            if(p == 0){
                enter[p] = true;
                count++;
            }
            if(!lamp){
                lamp = true;
                count++;
            }
            else{
                if (!enter[p] && lamp){
                    lamp = false;
                    enter[p] = true;
                }
            }
        }
        boolean ans = true;
        for (int i = 0; ans && i < enter.length; i++){
            if (!enter[i]) ans = false;
        }
        return steps;
    }

    public static boolean prisonersLampUnknown(int n){
        int[] enter = new int[n];
        for (int i = 0; i < enter.length; i++) enter[i] = 0;
        int count = 0, steps = 0;
        boolean lamp = ((int)(Math.random()*2) == 0) ? false : true;
        while (count < 2*n){
            steps++;
            int p = (int)(Math.random()*n);
            if (p == 0 && !lamp){
                lamp = true;
                count++;
                if (enter[0] == 0){
                    enter[0]++;
                    count++;
                }
            }
            else{
                if (enter[p] < 2 && lamp){
                    enter[p]++;
                    lamp = false;
                }
            }
        }
        boolean ans = true;
        for (int i = 0; ans && i < enter.length; i++) {
            if (enter[i] == 0)
                ans = false;
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(prisonersLampOn(10));
        System.out.println(prisonersLampUnknown(7));
    }
}
