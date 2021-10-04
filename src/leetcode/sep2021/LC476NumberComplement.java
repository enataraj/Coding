package leetcode.sep2021;

public class LC476NumberComplement {
    public int findComplement(int num) {
        int mask = Integer.MIN_VALUE; // 1000...
        // find first set bit
        while ((mask & num) == 0) {
            mask >>>= 1;
        }
        // flip the rest bits
        while (mask > 0) {
            num = num ^ mask;
            mask >>>= 1;
        }
        return num;
    }
    
    public int findComplementSol(int num) {
        int res = 0;
        int mutiple = 1;
        while(num != 0){
            res += mutiple * ((num % 2) ^ 1);
            num /= 2;
            mutiple *= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        LC476NumberComplement obj = new LC476NumberComplement();
        int num = 6;
        System.out.println(obj.findComplement(num));

    }

}
