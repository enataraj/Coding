package leetcode.july2021;

public class LC927ThreeEqualParts {

    public int[] threeEqualParts(int[] arr) {
        int numberOfOnes = 0;
        for (int num : arr) {
            if (num == 1) {
                numberOfOnes++;
            }
        }

        if (numberOfOnes == 0) {
            return new int[] { 0, 2 };
        }
        if (numberOfOnes % 3 != 0) {
            return new int[] { -1, -1 };
        }

        int numOfOnesInEachPart = numberOfOnes / 3;
        int startIdxPart1One = -1;
        int startIdxPart2One = -1;
        int startIdxPart3One = -1;

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                cnt++;
                if (cnt == numOfOnesInEachPart + 1) {
                    startIdxPart2One = i;

                } else if (cnt == 2 * numOfOnesInEachPart + 1) {
                    startIdxPart3One = i;
                    break;
                }
                if (cnt == 1) {
                    startIdxPart1One = i;

                }
            }

        }

        while (startIdxPart3One < arr.length) {
            if (arr[startIdxPart1One] == arr[startIdxPart3One] && arr[startIdxPart2One] == arr[startIdxPart3One]) {
                startIdxPart1One++;
                startIdxPart2One++;
                startIdxPart3One++;

            } else {
                return new int[] { -1, -1 };
            }

        }

        return new int[] { startIdxPart1One - 1, startIdxPart2One };

    }

}
