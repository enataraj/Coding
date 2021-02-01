package leetcode.jan;

import java.util.Arrays;

public class LC881BoatToSavePeople {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int boatCnt = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
                boatCnt++;
            } else {
                boatCnt++;
                j--;
            }

        }

        return boatCnt;

    }

    public int numRescueBoatsSol(int[] people, int limit) {
        int[] weights = new int[limit];
        for (int weight : people) {
            weights[weight - 1]++;
        }
        int i = 1, j = weights.length;
        int count = 0;
        while (i <= j) {
            while (i <= j && weights[i - 1] <= 0)
                i++;
            while (i <= j && weights[j - 1] <= 0)
                j--;
            if (i > j)
                break;
            if (i + j <= limit) {
                weights[i - 1]--;
            }
            weights[j - 1]--;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LC881BoatToSavePeople obj = new LC881BoatToSavePeople();
        int[] people = { 3, 5, 3, 4 };
        int limit = 5;
        // int[] people = {3,2,2,1};
        // int limit = 3;

        // int[] people = {5,1,7,4,2,4};
        // int limit = 7;
        System.out.println(obj.numRescueBoats(people, limit));
    }
    /*
     * else if ((i + 2) <= j) { if ((people[i] + people[i + 1]) <= limit) { i = i +
     * 2; boatCnt++; System.out.println("second"); }else { i++; boatCnt++;
     * System.out.println("tird"); } } else { i++; boatCnt++;
     * System.out.println("fourth"); }
     */
}
