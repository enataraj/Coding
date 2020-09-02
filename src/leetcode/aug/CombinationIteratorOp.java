package leetcode.aug;

public class CombinationIteratorOp {
    
    char[] cur, dic;
    boolean hasNext;
    int n;
    public CombinationIteratorOp(String characters, int L) {
        cur = characters.substring(0, L).toCharArray();
        dic = characters.toCharArray();
        n = dic.length;
        hasNext = true;
    }
    
    public String next() {
        if(!hasNext) return "";
        String res = new String(cur);
        int L = cur.length;
        int i = cur.length - 1, j = dic.length - 1;
        while(i >= 0 && cur[i] == dic[j]){
            i--;
            j--;
        }
        if(i == -1){
            hasNext = false;
        }else{
            int index = String.valueOf(dic).indexOf(cur[i]);
            for( int k = i; k < L; k++) {
                cur[k] = dic[++index];
            }
        }
        return res;
    }
    
    public boolean hasNext() {
        return hasNext;
    }

}
