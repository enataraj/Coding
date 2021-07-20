package leetcode.weekly.week248;

import java.util.Arrays;

public class LC1921EliminateMaxMonster {

    public int eliminateMaximum(int[] dist, int[] speed) {

        double[] distance = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            distance[i] = dist[i] / (double) speed[i];
        }
        Arrays.sort(distance);
        // System.out.println(Arrays.toString(distance));
        int count = 0;
        for (int minute = 0; minute < distance.length; minute++) {
            if (minute < distance[minute]) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public int eliminateMaximumNW(int[] dist, int[] speed) {

        for (int i = 0; i < dist.length; i++) {
            dist[i] = dist[i] / speed[i];
        }
        Arrays.sort(dist);
        System.out.println(Arrays.toString(dist));
        int count = 0;
        for (int minute = 0; minute < dist.length; minute++) {
            if (minute < dist[minute]) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LC1921EliminateMaxMonster obj = new LC1921EliminateMaxMonster();
        int[] dist = { 3, 2, 4 };
        int[] speed = { 5, 3, 2 };
        System.out.println(obj.eliminateMaximum(dist, speed));
        System.out.println(obj.eliminateMaximumNW(dist, speed));
    }

}
