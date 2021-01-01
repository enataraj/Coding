package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class LC1656OrderedStream {
    String[] strArr;
    int ptr = 0;

    public LC1656OrderedStream(int n) {
        strArr = new String[n];
    }

    public List<String> insert(int id, String value) {
        id = id - 1;
        strArr[id] = value;
        List<String> result = new ArrayList<>();

        if (ptr == id) {

            while (ptr < strArr.length && strArr[ptr] != null) {
                result.add(strArr[ptr]);
                ptr++;
            }

        }
        return result;

    }

    public static void main(String[] args) {
        LC1656OrderedStream obj = new LC1656OrderedStream(5);
        System.out.println(obj.insert(3, "ccccc"));
        System.out.println(obj.insert(1, "aaaaa"));
        System.out.println(obj.insert(2, "bbbbb"));
        System.out.println(obj.insert(5, "eeeee"));
        System.out.println(obj.insert(4, "ddddd"));

    }

}
