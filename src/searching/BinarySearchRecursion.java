package searching;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7 };
        int resIdx = binarySearch(a, 0, a.length - 1, 15);
        System.out.println("Result Index " + resIdx);

    }

    private static int binarySearch(int a[], int l, int r, int x) {

        int mid;

        if (l <= r) {
            mid = l + (r - l) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                return binarySearch(a, mid + 1, r, x);

            }
            return binarySearch(a, l, mid - 1, x);
        }
        return -1;

    }

}
