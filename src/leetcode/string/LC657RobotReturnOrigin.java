package leetcode.string;

public class LC657RobotReturnOrigin {
    public boolean judgeCircle(String moves) {
        int i = 0, j = 0;

        for (int k = 0; k < moves.length(); k++) {
            switch (moves.charAt(k)) {
            case 'L':
                i = i - 1;
                break;
            case 'R':
                i = i + 1;
                break;
            case 'U':
                j = j - 1;
                break;
            case 'D':
                j = j + 1;
                break;
            }

        }

        if (i == 0 && j == 0) {
            return true;
        }
        return false;
    }

    public boolean judgeCircleSol(String moves) {
        int[] map = new int[100];
        for (char ch : moves.toCharArray()) {
            ++map[ch];
        }

        return map['U'] == map['D'] && map['L'] == map['R'];
    }
}
