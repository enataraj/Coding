package leetcode.sep2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1078OccuranceOfBiagram {

    public String[] findOcurrences(String text, String first, String second) {
        String[] textArray = text.split(" ");
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < textArray.length - 2; i++) {
            if (textArray[i].equals(first) && textArray[i + 1].equals(second)) {
                resultList.add(textArray[i + 2]);
            }
        }
        String[] result = new String[resultList.size()];
        int idx = 0;
        for (String tmp : resultList) {
            result[idx++] = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "we will we will rock you", first = "we", second = "will";
        LC1078OccuranceOfBiagram obj = new LC1078OccuranceOfBiagram();
        System.out.println(Arrays.toString(obj.findOcurrences(text, first, second)));
    }

}
