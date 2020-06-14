package array.util;

import java.util.Arrays;

public class ArraysFill {
    public static void main(String[] args) {
        int a[][] = new int[3][5];
        int oneD[] = new int[25];
        for (int i = 0; i < a.length; i++) {
            // Fill the entire inner array as zero
            Arrays.fill(a[i], 10);
            System.out.println("  " + Arrays.toString(a[i]));

            // Fill index 1 to 3 as 30
            Arrays.fill(a[i], 1, 3, 30);
            System.out.println("  " + Arrays.toString(a[i]));

        }

        System.out.println("Filling One D Array");
        // If we Fill it whole array , again index based filling is not working
        //Arrays.fill(oneD, 45);
        System.out.println("  " + Arrays.toString(oneD));
        Arrays.fill(oneD, 1, 4, 45);
        Arrays.fill(oneD, 10, 14, 25);
        System.out.println("  " + Arrays.toString(oneD));
        
        // But overwriting Index based is working
        Arrays.fill(oneD, 1, 4, 85);
        System.out.println("  " + Arrays.toString(oneD));
    }

}
