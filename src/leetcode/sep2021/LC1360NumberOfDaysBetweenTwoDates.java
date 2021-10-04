package leetcode.sep2021;

public class LC1360NumberOfDaysBetweenTwoDates {
    public int daysBetweenDates(String date1, String date2) {

        String[] date_1 = date1.split("-");
        String[] date_2 = date2.split("-");
        int[] days = new int[13];
        days[1] = 31;
        days[2] = days[1] + 28;
        days[3] = days[2] + 31;
        days[4] = days[3] + 30;
        days[5] = days[4] + 31;
        days[6] = days[5] + 30;
        days[7] = days[6] + 31;
        days[8] = days[7] + 31;
        days[9] = days[8] + 30;
        days[10] = days[9] + 31;
        days[11] = days[10] + 30;
        days[12] = days[11] + 31;
        // Days Calculation 
        long totalDay1 = Integer.parseInt(date_1[2]);
        long totalDay2 = Integer.parseInt(date_2[2]);

        // Month Calculation
        totalDay1 += days[Integer.parseInt(date_1[1]) - 1];
        totalDay2 += days[Integer.parseInt(date_2[1]) - 1];

        // Year Calculation
        int year1 = Integer.parseInt(date_1[0]) - 1;
        totalDay1 += (year1 * 365) + Math.floor((year1 / 4));

        int year2 = Integer.parseInt(date_2[0]) - 1;
        totalDay2 += (year2 * 365) + Math.floor((year2 / 4));

        int month1 = Integer.parseInt(date_1[1]);
        if ((year1 + 1) !=2100 && (year1 + 1) % 4 == 0 && month1 > 2) {
            totalDay1 += 1;
        }

        int month2 = Integer.parseInt(date_2[1]);
        if ((year2 + 1) !=2100 && (year2 + 1) % 4 == 0 && month2 > 2) {
            totalDay2 += 1;
        }
        return (int) Math.abs((totalDay2 - totalDay1));
    }

}
