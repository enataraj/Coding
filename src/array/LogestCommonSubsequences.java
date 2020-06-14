package array;

import array.util.ArrayUtil;

public class LogestCommonSubsequences {

    public static void main(String[] args) {

        String str1 = "abcdef";
        String str2 = "kdesfg";
        int res = longestCommonSubsequence(str1, str2, 0, 0);
        System.out.println("Result " + res);
        int[][] DbTable = new int[str1.length()][str2.length()];
        int result2 = longestCommonSubsequenceDp(str1, str2, 0, 0, DbTable);
        printArray(DbTable, str1, str2);
        ArrayUtil.printMatrix(DbTable);
        System.out.println("Result " + result2);

    }

    private static int longestCommonSubsequence(String a, String b, int i, int j) {
        if (a.length() == i || b.length() == j) {
            return 0;
        }
        if (a.charAt(i) == b.charAt(j))
            return 1 + longestCommonSubsequence(a, b, i + 1, j + 1);

        return Math.max(longestCommonSubsequence(a, b, i + 1, j), longestCommonSubsequence(a, b, i, j + 1));
    }

    private static int longestCommonSubsequenceDp(String a, String b, int i, int j, int[][] DbTable) {
        if (a.length() == i || b.length() == j) {
            return 0;
        }
        if (a.charAt(i) == b.charAt(j))
            return DbTable[i][j] = 1 + longestCommonSubsequenceDp(a, b, i + 1, j + 1, DbTable);

        return DbTable[i][j] = Math.max(longestCommonSubsequenceDp(a, b, i + 1, j, DbTable),
                longestCommonSubsequenceDp(a, b, i, j + 1, DbTable));

    }
    
    private static void printArray(int[][] DbTable,String str1,String str2) {
        for(int i=0;i<str1.length();i++) {
            System.out.println();
            for(int j=0;j<str2.length();j++) {
                System.out.print(" "+DbTable[i][j]);
            }
        }
    }

}
