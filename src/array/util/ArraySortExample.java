package array.util;

import java.util.Arrays;

public class ArraySortExample {

    // Sorting Single Dimentional Array

    private static void sortSingleDimentationArray(int[] arr) {

        printArray("Input  : ", arr);
        Arrays.sort(arr);
        printArray("Output : ", arr);
    }

    private static void sortMultiDimentationArray(int[][] arr) {

        printTwoDimentionalArray("Input                          :  ", arr);

        // Sort Based on First Value in Array
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        printTwoDimentionalArray("Sorting based on first Value   :  ", arr);
        
        
        // Sort Based on Second Value in Array
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        printTwoDimentionalArray("Sorting based on second Value  :  ", arr);
        
        
        // Sort Based on Second Value in Array
        Arrays.sort(arr, (a, b) -> a[2] - b[2]);
        printTwoDimentionalArray("Sorting based on third Value   :  ", arr);
        
        // Sorting based on first value if its same then based on second value
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        printTwoDimentionalArray("Sorting based on third Value   :  ", arr);
        
        
        System.out.println("\n\nDECENDING ORDERS\n\n");
        
     // Sort Based on First Value in Array
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        printTwoDimentionalArray("Sorting based on first Value   :  ", arr);
        
        
        // Sort Based on Second Value in Array
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        printTwoDimentionalArray("Sorting based on second Value  :  ", arr);
        
        
        // Sort Based on Second Value in Array
        Arrays.sort(arr, (a, b) -> b[2] - a[2]);
        printTwoDimentionalArray("Sorting based on third Value   :  ", arr);
        
        // Sorting based on first value if its same then based on second value
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        printTwoDimentionalArray("Sorting based on third Value   :  ", arr);
        
    }

    private static void printArray(String str, int arr[]) {
        System.out.println();
        System.out.print(str);
        System.out.println(Arrays.toString(arr));
    }

    private static void printTwoDimentionalArray(String str, int[][] people) {
        System.out.print(str);
        for (int[] arr : people) {
            System.out.print("\t" + Arrays.toString(arr));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 2, 56, 2, 6, 234, 5, 3 };
        sortSingleDimentationArray(arr);
        int[][] twoDarr = { { 1, 240, 4 },{ 1, 232, 4 }, { 4, 234, 5 }, { 235, 6, 7 }, { 56, 23, 34 }, { 2, 1, 53 } };
        sortMultiDimentationArray(twoDarr);
    }

}
