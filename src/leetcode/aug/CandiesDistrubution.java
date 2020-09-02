package leetcode.aug;

import java.util.Arrays;

public class CandiesDistrubution {

    public int[] distributeCandies(int candies, int num_people) {
        if (candies == 0) {
            int[] res = new int[1];
            return res;
        }
        int[] result = new int[num_people];

        for (int i = 1; i <= candies; i++) {
            int idx = (i - 1) % num_people;

            int neededCandies = ((i * (i + 1)) / 2);
            if (neededCandies <= candies) {
                result[idx] = result[idx] + i;

            } else {

                result[idx] = result[idx] + (candies - ((i - 1) * (i) / 2));
                break;

            }
            System.out.println(Arrays.toString(result));

        }

        return result;

    }

    public int[] distributeCandiesOpt(int candies, int num_people) {
        int[] arr = new int[num_people];

        for (int i = 0; candies > 0; i++) {
            arr[i % num_people] += Math.min(candies, i + 1);
            candies -= i + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        CandiesDistrubution obj = new CandiesDistrubution();
        int candies = 7;
        int num_people = 4;
        int[] result = obj.distributeCandies(candies, num_people);
        System.out.println(Arrays.toString(result));

    }

}
