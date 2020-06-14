package array;

public class NextLargestElement {

    public static void main(String[] args) {

        int a[] = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int res[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] < a[j]) {
                    System.out.println("Next Max " + a[j]);
                    System.out.println("( " + i + "," + j + " )");
                    res[i] = j - i;
                    break;
                }

            }

        }

        for (int i = 0; i < res.length; i++) {
            System.out.print("  " + res[i]);

        }
    }

    public int[] dailyTemperatures(int[] T) {
        int res[] = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i; j < T.length; j++) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

}
