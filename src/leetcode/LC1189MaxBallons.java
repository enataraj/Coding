package leetcode;

public class LC1189MaxBallons {
    public int maxNumberOfBalloons(String text) {
        int[] charMap = new int[26];

        for (char ch : text.toCharArray()) {
            charMap[ch - 97]++;
        }
        charMap['l' - 97] = charMap['l' - 97] / 2;
        charMap['o' - 97] = charMap['o' - 97] / 2;

        String balloon = "balloon";

        int count = Integer.MAX_VALUE;
        for (char ch : balloon.toCharArray()) {
            count = Math.min(count, charMap[ch - 97]);

        }
        if (count == Integer.MAX_VALUE) {
            return 0;
        }
        return count;
    }

    public int maxNumberOfBalloonsOpt(String text) {
        int len = text.length();
        if (len < 7) {
            return 0;
        }
        int B = 0;
        int A = 0;
        int L = 0;
        int O = 0;
        int N = 0;
        for (int i = 0; i < len; i++) {

            if (text.charAt(i) == 'b') {
                B++;
            } else if (text.charAt(i) == 'a') {
                A++;
            } else if (text.charAt(i) == 'l') {
                L++;
            } else if (text.charAt(i) == 'o') {
                O++;
            } else if (text.charAt(i) == 'n') {
                N++;
            }
        }
        System.out.println(B);
        int min1 = Math.min(B, A);
        int min2 = Math.min(min1, L / 2);
        int min3 = Math.min(min2, O / 2);
        int min4 = Math.min(min3, N);
        System.out.println(min4);
        return min4;

    }

    public static void main(String[] args) {
        LC1189MaxBallons obj = new LC1189MaxBallons();
        String text = "loonbalxballpoon";
        // String text = "balon";
        System.out.println(obj.maxNumberOfBalloons(text));
    }

}
