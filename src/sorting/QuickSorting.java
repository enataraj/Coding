package sorting;

import java.util.Arrays;

public class QuickSorting {

    public static void main(String[] args) {
        int a[] = { 3, 2, 6, 8, 7, 34, 8, 36, 564, 4,2,4,4,41,3,2 };
        quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println();
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }

    }
    
    private static void printArray(int [] a){
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }

    private static void quickSort(int a[], int l, int h) {
        if (l < h) {
            int partitionPos = partition(a, l, h);
            quickSort(a, l, partitionPos);
            quickSort(a, partitionPos + 1, h);

        }

    }

    private static int partition(int a[], int l, int h) {
        int pivot = a[h];
        int j = h;
        int i = l;

        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
//                printArray(a);
            }
           

        }
        return j;

    }

    private static void swap(int a[], int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

}
