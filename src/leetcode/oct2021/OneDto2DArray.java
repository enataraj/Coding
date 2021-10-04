package leetcode.oct2021;

public class OneDto2DArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] res = new int[m][n];
        int row = 0;
        int col = 0;
        for (int i = 0; i < original.length; i++) {
            res[row][col] = original[i];
            col++;
            if (col == n) {
                row++;
                col = 0;
            }
        }
        return res;
    }

    public int numOfPairs(String[] nums, String target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]).equals(target)) {
                    res++;
                }
                if ((nums[j] + nums[i]).equals(target)) {
                    res++;
                }
            }
        }
        return res;
    }



    int result = 0;
    public int maxConsecutiveAnswers(String answerKey, int k) {
        dfs(answerKey.toCharArray(), k, 0);
        return result;
    }

    private void dfs(char[] answerKey, int k, int idx) {
        if(result ==answerKey.length ){
            return;
        }
        if (k == 0) {
            result = Math.max(findAnswer(answerKey), result);
            return;
        }

        if (idx >= answerKey.length) {
            result = Math.max(findAnswer(answerKey), result);
            return;
        }

        if (answerKey[idx] == 'T') {
            answerKey[idx] = 'F';
            dfs(answerKey, k - 1, idx + 1);
        }

        else if (answerKey[idx] == 'F') {
            answerKey[idx] = 'T';
            dfs(answerKey, k - 1, idx + 1);
        }
        dfs(answerKey, k, idx + 1);
    }

    private int findAnswer(char[] answerKey) {
        int fCnt = 0;
        int tCnt = 0;
        int tmpfCnt = 0;
        int tmpTCnt = 0;
        for (int i = 0; i < answerKey.length; i++) {
            if (answerKey[i] == 'T') {
                tmpTCnt++;
            } else {
                tCnt = Math.max(tmpTCnt, tCnt);
                tmpTCnt = 0;
            }
            tCnt = Math.max(tmpTCnt, tCnt);
            if (answerKey[i] == 'F') {
                tmpfCnt++;
            } else {
                fCnt = Math.max(tmpfCnt, fCnt);
                tmpfCnt = 0;
            }
             fCnt = Math.max(tmpfCnt, fCnt);

        }
        return Math.max(fCnt, tCnt);

    }

    public static void main(String[] args) {
        OneDto2DArray obj = new OneDto2DArray();
        String[] str = { "1", "1", "1" };
        String target = "11";
        System.out.println(obj.numOfPairs(str, target));

    }
}
