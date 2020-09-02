package leetcode.aug;

import java.util.ArrayList;
import java.util.List;

public class FizBuzz {

    public List<String> fizzBuzz(int n) {

        List<String> resultList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                resultList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                resultList.add("Fizz");

            } else if (i % 5 == 0) {
                resultList.add("Buzz");

            } else {
                resultList.add("" + i);
            }

        }

        return resultList;

    }

    public static void main(String[] args) {
        FizBuzz obj = new FizBuzz();
        System.out.println(obj.fizzBuzz(15));
    }

}
