package leetcode.oct;

public class ComplimentBase10 {

    public int bitwiseComplementNaive(int N) {
        if (N == 0) {
            return 1;
        }
        StringBuffer buf = new StringBuffer();
        int result = 0;
        int mul = 1;

        while (N > 0) {

            int reminder = N % 2;
            if (reminder == 0) {
                buf.insert(0, 1);
                result += mul;

            }
            N = N / 2;
            mul *= 2;
        }
        return result;
    }
    
    public int bitwiseComplement(int N) {
        int bitLen = (int)(Math.log(N)/Math.log(2))+1;
        int bit = 1 << bitLen;
        bit -= 1;
        return N ^ bit;
    }

    public static void main(String[] args) {
        ComplimentBase10 obj = new ComplimentBase10();
        System.out.println(obj.bitwiseComplement(10));

    }

}
