package searching;

public class BinarySearch {

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7 };
        int resIdx = binarySearch(a, 0, a.length - 1, 5);
        System.out.println("Result Index " + resIdx);

    }

    private static int binarySearch(int a[], int l, int r, int x) {

        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                l = mid + 1;

            } else {
                r = mid - 1;
            }
        }

        return -1;

    }

}
