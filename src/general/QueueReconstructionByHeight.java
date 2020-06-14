package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
//        int[][] result = new int[people.length][people[0].length];
        printArray("Input Array :", people);

        Arrays.sort(people, (a, b) -> Integer.compare(b[0], a[0]));
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        printArray("Descending First Attribute :", people);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]); // placing people based on the K value
        }
        return list.toArray(people); // convert list to array

        // Arrays.sort(people, (a, b) -> Integer.compare(a[1], b[1]));
        // printArray("Sorted based on Ascending Second Attribute ", people);

        // Comparator<Integer[]> arrayComparator = new NumberComparator1();
        // Arrays.sort(people,arrayComparator);

    }

    private void printArray(String str, int[][] people) {
        System.out.print(str);
        for (int[] arr : people) {
            System.out.print("  " + Arrays.toString(arr));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        new QueueReconstructionByHeight().reconstructQueue(people);

    }
}

class NumberComparator1 implements Comparator<Integer[]> {

    @Override
    public int compare(Integer[] a, Integer[] b) {
        return b[0] - a[0];
    }

}