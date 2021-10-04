package leetcode.sep2021;

public class LC405HExConverstion {

    public String toHex(int num) {
        StringBuffer result = new StringBuffer();

        int bitNum = 8;
        if (num < 0) {

            num = -num - 1;
            while (bitNum > 0) {
                int rest = num % 16;
                if (rest < 6) {
                    result.append((char) ('f' - rest));
                } else {
                    result.append(15 - rest);
                }
                num /= 16;
                bitNum--;
            }
            return result.reverse().toString();
        }

        else if (num > 0) {
            while (num > 16) {
                result.append(hexValue(num % 16));
                num = num / 16;
            }
            if (num != 0) {
                result.append(hexValue(num % 16));
            }
            return result.reverse().toString();
        }
        return "0";

    }

    private String hexValue(int num) {
        if (num < 10) {
            return "" + num;
        } else if (num == 10) {
            return "a";
        } else if (num == 11) {
            return "b";
        } else if (num == 12) {
            return "c";
        } else if (num == 13) {
            return "d";
        } else if (num == 14) {
            return "f";
        }
        return "f";

    }

}
