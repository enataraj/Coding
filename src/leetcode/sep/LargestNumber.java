package leetcode.sep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        if (nums.length == 1) {
            return "" + nums[0];
        }

        List<String> list = new ArrayList<>();
        int zeroCount = 0;
        for (int num : nums) {
            list.add("" + num);
            if (num == 0) {
                zeroCount++;
            }
        }

        if (zeroCount == list.size()) {
            return "0";
        }
        System.out.println(list);

        Collections.sort(list, new StringComparator());
        StringBuffer buffer = new StringBuffer();
        for (int i = list.size() - 1; i >= 0; i--) {

            buffer.append(list.get(i));

        }
        return buffer.toString();

    }

    class StringComparator implements Comparator<String> {

        @Override
        public int compare(String str1, String str2) {
         //   System.out.println(str1+"  "+str2);
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            
            return s1.compareTo(s2);
        /*    Long l1 = Long.parseLong(s1);
           
            Long l2 = Long.parseLong(s2);
            return Long.compare(l1, l2);*/

        }

    }

    public String largestNumber_Irina(int[] nums) {
        List<String> l = new ArrayList<>();
        for (int a : nums)
            l.add(String.valueOf(a));
        Collections.sort(l, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.charAt(0) == o2.charAt(0)) {
                    String o12 = o1 + o2;
                    String o21 = o2 + o1;
                    return o21.compareTo(o12);
                } else // divide by "first digit" buckets
                    return Character.compare(o2.charAt(0), o1.charAt(0));
            }
        });
        if ("0".equals(l.get(0)))
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : l)
            sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber obj = new LargestNumber();
        int[] nums = { 3, 30, 34, 5, 9 };
        // int[] nums = { 1, 1, 1 };
        System.out.println(obj.largestNumber(nums));

    }

}
