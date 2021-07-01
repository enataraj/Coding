package leetcode.weekly.week245;

public class LC1904NumberOfFullRounds {

    public int numberOfRounds(String startTime, String finishTime) {
        int startMinutes = getInMinutes(startTime);
        int finishMinutes = getInMinutes(finishTime);
        finishMinutes += (startMinutes > finishMinutes) ? (24 * 60) : 0;
        startMinutes = (startMinutes % 15 == 0) ? startMinutes : startMinutes + (15 - startMinutes % 15);
        finishMinutes -= (finishMinutes % 15);
        return (finishMinutes < startMinutes) ? 0 : (finishMinutes - startMinutes) / 15;
    }

    private int getInMinutes(String time) {
        return Integer.valueOf(time.substring(0, 2)) * 60 + Integer.valueOf(time.substring(3));
    }

    public static void main(String[] args) {

        LC1904NumberOfFullRounds obj = new LC1904NumberOfFullRounds();
        System.out.println(obj.numberOfRounds("00:47", "00:57"));

    }

}
