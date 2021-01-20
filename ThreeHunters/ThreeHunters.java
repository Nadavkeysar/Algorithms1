package ThreeHunters;

import java.util.Arrays;

public class ThreeHunters {
    static int count_hunt1;
    static int count_hunt2;
    static int count_hunt3;

    public ThreeHunters() {
        count_hunt1 = 0;
        count_hunt2 = 0;
        count_hunt3 = 0;
    }

    public static int[] ranHunt() {
        int random = (int) (Math.random() * 6);
        int[][] mat = {{1, 2, 3}, {1, 3, 2}, {3, 1, 2}, {3, 2, 1}, {2, 1, 3}, {2, 3, 1}};
        return mat[random];
    }

    public static void shoot() {
        double hunt2 = 0.8;
        double hunt3 = 0.5;
        double hunt2_chance;
        double hunt3_chance;
        int a = 1;
        int b = 2;
        int c = 3;
        boolean flag = true;
        int[] random = ranHunt();
        int first = random[0];
        switch (first) {
            case 1:
                hunt3_chance = Math.random();
                if (hunt3_chance < hunt3) count_hunt3++;
                else count_hunt1++;
                break;
            case 2:
                hunt2_chance = Math.random();
                if (hunt2_chance < hunt2) {
                    flag = true;
                    while (flag) {
                        hunt3_chance = Math.random();
                        if (hunt3_chance < hunt3) {
                            count_hunt3++;
                            flag = false;
                        } else {
                            hunt2_chance = Math.random();
                            if (hunt2_chance < hunt2) {
                                count_hunt2++;
                                flag = false;
                            }
                        }
                    }
                } else {
                    if (random[1] == a) {
                        hunt3_chance = Math.random();
                        if (hunt3_chance < hunt3) count_hunt3++;
                        else count_hunt1++;
                    } else if (random[1] == c) {
                        hunt3_chance = Math.random();
                        if (hunt3_chance < hunt3) count_hunt3++;
                        else count_hunt1++;
                    }
                    break;
                }
            case 3:
                if (random[1] == a) {
                    hunt3_chance = Math.random();
                    if (hunt3_chance < hunt3) count_hunt3++;
                    else count_hunt1++;
                } else if (random[1] == b) {
                    hunt2_chance = Math.random();
                    if (hunt2_chance < hunt2) {
                        flag = true;
                        while (flag) {
                            hunt3_chance = Math.random();
                            if (hunt3_chance < hunt3) {
                                count_hunt3++;
                                flag = false;
                            } else {
                                hunt2_chance = Math.random();
                                if (hunt2_chance < hunt2) {
                                    count_hunt2++;
                                    flag = false;
                                }
                            }
                        }
                    } else {
                        hunt3_chance = Math.random();
                        if (hunt3_chance < hunt3) count_hunt3++;
                        else count_hunt1++;
                    }
                }
                break;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        shoot();
        System.out.println(Arrays.toString(ranHunt()));
    }
}
