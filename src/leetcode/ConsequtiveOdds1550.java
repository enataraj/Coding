package leetcode;

public class ConsequtiveOdds1550 {

    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;

    }
    
    public boolean threeConsecutiveOddsDiff(int[] arr) {
        if( arr.length<=2) return false;
        
        for(int i=2;i<arr.length;i++){
            if( arr[i]%2 != 0 && arr[i-2]%2 != 0 && arr[i-1]%2 != 0 ) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ConsequtiveOdds1550 obj = new ConsequtiveOdds1550();
        int arr[] = { 1, 2, 34, 3, 4, 5, 70, 23, 12 };
        System.out.println(obj.threeConsecutiveOdds(arr));

    }

}
