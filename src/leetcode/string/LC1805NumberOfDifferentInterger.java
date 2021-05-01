package leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class LC1805NumberOfDifferentInterger {

    public int numDifferentIntegers(String word) {
        StringBuffer buffer = new StringBuffer();
        Set<String> numberSet = new HashSet<>();
        for (char ch : word.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                buffer.append(ch);
            } else if (buffer.length() != 0 && buffer.charAt(buffer.length() - 1) != ' ') {
                buffer.append(' ');

            }
        }
        if (buffer.length() == 0) {
            return 0;
        }
     
        for (String str : buffer.toString().split(" ")) {
            if (str.replace("0", "").isEmpty()) {
                numberSet.add("0");
            } else if (str.charAt(0) == '0') {
                StringBuffer tmpBuffer = new StringBuffer();
                boolean flag = true;
                for (char ch : str.toCharArray()) {
                    if (ch != '0') {
                        flag = false;
                    }
                    if (!flag) {
                        tmpBuffer.append(ch);
                    }

                }
                numberSet.add(tmpBuffer.toString());
            } else {
                numberSet.add(str);
            }
        }
        return numberSet.size();
    }

    public static void main(String[] args) {
        LC1805NumberOfDifferentInterger obj = new LC1805NumberOfDifferentInterger();
        System.out.println(obj.numDifferentIntegers("4w31am001ets6sl5go5ufytjtjpb7b01sxqbee2blg9ss"));
    }
}
