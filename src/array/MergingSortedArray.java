package array;

public class MergingSortedArray {

    public static void main(String[] args) {
        int[] a = {14, 15, 16, 17, 18, 19};
        int[] b = {  3, 4, 6, 7, 8  };

        mergeSortedArray(a, b);

    }

    private static void mergeSortedArray(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
       while(i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                res[k] = a[i];
                i++;
                k++;
            } else {
                res[k] = b[j];
                j++;
                k++;
            }
        }

        while (i < a.length) {
            res[k] = a[i];
            k++;
            i++;
        }
        while (j < b.length) {
            res[k] = b[j];
            k++;
            j++;
        }
        
        System.out.println("Result ");
        for(int l=0;l<k;l++) {
            System.out.print("  "+res[l]);
        }
    }
}
