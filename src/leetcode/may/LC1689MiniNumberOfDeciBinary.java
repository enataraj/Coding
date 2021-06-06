package leetcode.may;

public class LC1689MiniNumberOfDeciBinary {
    public int minPartitions(String n) {
        int res = 0;
        for (char ch : n.toCharArray()) {
            res = Math.max(res, ch - '0');
        }
        return res;
    }
    
    public int minPartitionsSol(String n) {
        for(char ch='9' ;ch>='0';ch--) {
            if(n.contains(ch+"")) {
                return ch-'0';
            }
        }
        return 0;      
    }

    public static void main(String[] args) {
        LC1689MiniNumberOfDeciBinary obj = new LC1689MiniNumberOfDeciBinary();
    }

}
