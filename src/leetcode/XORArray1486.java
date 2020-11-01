package leetcode;

public class XORArray1486 {

    public int xorOperation(int n, int start) {

        int result = start;

        for (int i = 1; i < n; i++) {
            result ^= (start+(2 * i));
            

        }
        return result;

    }

    public static void main(String[] args) {
        XORArray1486 obj = new XORArray1486();
        int n = 4;
        int start = 3;
        System.out.println(obj.xorOperation(n, start));

    }

}
