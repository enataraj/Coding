package leetcode.sep2021;

import java.util.Arrays;

public class NumberOfWeekCharacter {
    public int numberOfWeakCharacters(int[][] properties) {
        int cnt = 0;
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        for (int i = 0; i < properties.length; i++) {
            System.out.println(Arrays.toString(properties[i]));
        }

        for (int i = properties.length - 1; i >= 0; i--) {
            int left = i - 1;
            int right = i;
            while (left >= 0) {
                if ((properties[left][0] < properties[right][0]) && (properties[left][1] < properties[right][1])) {
                    cnt++;
                    left--;
                } else {
                    break;
                }
            }
            i = left + 1;
        }

        /*     for (int i = 0; i < properties.length; i++) {
            for (int j = i + 1; j < properties.length; j++) {
                if ((properties[i][0] < properties[j][0]) && (properties[i][1] < properties[j][1])) {
                    cnt++;
                }
            }
        
        }*/
        return cnt;
    }

    public static void main(String[] args) {
        NumberOfWeekCharacter obj = new NumberOfWeekCharacter();
        int[][] properties = { { 7, 7 }, { 1, 2 }, { 9, 7 }, { 7, 3 }, { 3, 10 }, { 9, 8 }, { 8, 10 }, { 4, 3 },
                { 1, 5 }, { 1, 5 } };
        System.out.println(obj.numberOfWeakCharacters(properties));
    }
}
