package leetcode.dec;

public class LC556NextGreatestElement {

    /*
     * Step 1 : Find the Dip from by traverse Right to Left Step 2 : Swap the dip
     * value to the value next to dip value from right side Step 3 : Reverse from
     * the dip value to rest of the values
     * 
     */
    public int nextGreaterElement(int n) {
        char[] number = Integer.toString(n).toCharArray();
        int len = number.length - 1;
        int dipIdx = -1;

        // Find the Dip from Right to Left
        for (int i = len; i > 0; i--) {
            if (number[i - 1] < number[i]) {
                dipIdx = i - 1;
                break;
            }
        }

        // Early termination
        if (dipIdx == -1) {
            return -1;
        }

        // Swap Dip value with next highest value from dip to right side of the array
        char valSwp = number[dipIdx];
        for (int i = len; i > dipIdx; i--) {
            if (number[i] > valSwp) {
                number[dipIdx] = number[i];
                number[i] = valSwp;
                break;
            }
        }

        // Reverse the Array from dip index +1 to till last element

        int j = len;
        int i = dipIdx + 1;
        while (i < j) {
            char tmp = number[i];
            number[i] = number[j];
            number[j] = tmp;
            i++;
            j--;
        }

        // Convert char array to Integer
        String str = new String(number);
        try {
            return Integer.parseInt(str);

        } catch (Exception e) {
            return -1;
        }

    }

    public static void main(String[] args) {
        LC556NextGreatestElement obj = new LC556NextGreatestElement();
        int n = 1999999999;
        System.out.println(obj.nextGreaterElement(n));

    }

}
