package leetcode.sep2021;

public class FinalValueAfterExpe {

    public int finalValueAfterOperations(String[] operations) {
        int res = 0;

        for (String str : operations) {
            if (str.equals("++X") || str.equals("X++"))
                res++;
            if (str.equals("--X") || str.equals("X--"))
                res--;
        }
        return res;
    }

}
