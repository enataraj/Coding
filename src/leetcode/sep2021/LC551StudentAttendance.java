package leetcode.sep2021;

public class LC551StudentAttendance {

    public boolean checkRecord(String s) {
        if (s.indexOf("LLL") != -1) {
            return false;
        }
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'A') {
                cnt++;
            }
        }
        return cnt < 2 ? true : false;
    }
}
