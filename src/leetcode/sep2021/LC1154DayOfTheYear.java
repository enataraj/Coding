package leetcode.sep2021;

public class LC1154DayOfTheYear {
    public int dayOfYear(String date) {

        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int days = 0;
        for (int i = 0; i < month - 1; i++) {
            days += months[i];
        }
        days += day;
        if (year % 4 == 0 && month > 2) {
            days += 1;
        }

        return days;
    }

}
