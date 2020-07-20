package leetcode.july;

public class ReverseBit {

    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }

        int res = 0;

        for (int i = 32; i >=0; i--) {
            int tmp = n & 1; // Mask the last bit to find either its 1 or 0.
            n = n >> 1; // Right Shift , Removing last bit and push it one position
            res = res | tmp; // Adding with Result
            res = res << i-1; // Push one position left

        }

        return res;
    }

    public int reverseBitsParin(int n) {
        int res = 0;
        for (int i = Integer.SIZE - 1; i >= 0; i--) {
            res |= (((n >> i) & 1) << (Integer.SIZE - 1 - i));
        }

        return res;
    }
    
    
    public int reverseBitsOptimized(int n) {
        int times = 31;
        int ret = 0;
        
        while (times >= 0){
            int lastDigit = n & 1;
            if (lastDigit == 1){
                ret = ret | (lastDigit << times);
            }
            times --;
            n = n >> 1;
        }
        return ret;
    }
    

    public static void main(String[] args) {
        ReverseBit obj = new ReverseBit();
        int n = 5;
        int res = obj.reverseBits(n);
        System.out.println("Result : " + res);
        res = obj.reverseBitsParin(n);
        System.out.println("Result : " + res);

    }

}
