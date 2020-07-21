package leetcode.array;

public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {

        if (A == null || A.length <= 2)
            return false;

        boolean flag = false;
        for (int i = 1; i < A.length; i++) {
            if(A[i-1]==A[i]) {
                return false;
            }
            if (!flag) {
                if (!(A[i - 1] < A[i])) {
                    flag = true;
                }
                if(flag&&(i-1 ==0)) {
                    return false;
                }

            } else {
                if (!(A[i - 1] > A[i])) {
                    return false;
                }

            }

        }

        if (!flag) {
            return false;
        }
        return true;

    }
    
    
    public boolean validMountainArrayOpt(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < A.length-1 && A[i] < A[i+1]){
            i++;
        }
        while (j > 0 && A[j] < A[j - 1]){
            j--;
        }
        return i == j && (i != 0) && (j != A.length - 1);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3 };
        ValidMountainArray obj = new ValidMountainArray();
        System.out.println(obj.validMountainArray(arr));
    }

}
