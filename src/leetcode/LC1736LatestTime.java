package leetcode;

public class LC1736LatestTime {
    public String maximumTime(String time) {
        char[] timeArray = time.toCharArray();

        if (timeArray[4] == '?') {
            timeArray[4] = '9';
        }
        if (timeArray[3] == '?') {
            timeArray[3] = '5';
        }
        if (timeArray[0] == '?' && timeArray[1] == '?') {
            timeArray[0] = '2';
            timeArray[1] = '3';
        } else if (timeArray[0] == '?') {
            if (timeArray[1] <= '3') {
                timeArray[0] = '2';
            } else {
                timeArray[0] = '1';
            }

        } else if (timeArray[1] == '?') {
            if (timeArray[0] < '2') {
                timeArray[1] = '9';
            } else {
                timeArray[1] = '3';
            }

        }
        return new String(timeArray);
    }

    public String maximumTimeSpaceOptimized(String time) {
        char[] chs = time.toCharArray();
        if (chs[0] == '?') {
            chs[0] = chs[1] <= '3' || chs[1] == '?' ? '2' : '1';
        }
        if (chs[1] == '?') {
            chs[1] = chs[0] == '2' ? '3' : '9';
        }
        if (chs[3] == '?') {
            chs[3] = '5';
        }
        if (chs[4] == '?') {
            chs[4] = '9';
        }
        return new String(chs);

    }

}
