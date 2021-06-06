package leetcode.string;

public class LC1566DeductPattern {

    public boolean containsPattern(int[] arr, int m, int k) {
        if (m * k > arr.length) {
            return false;
        }
        
        StringBuffer sequenceString = new StringBuffer(arr[0]);
        for(int i=1;i<arr.length;i++) {
            sequenceString.append("#");
            sequenceString.append(arr[i]);
        }
        String seq = sequenceString.toString();
        // Generate All SubString Length m
        
        // Check SubString is exist K time.
        String subString = "test";
        StringBuffer buffer = new StringBuffer(subString);
        for(int i=0;i<k;i++) {
            buffer.append("#");
            buffer.append(subString);
        }
        
        return false;

    }

}
