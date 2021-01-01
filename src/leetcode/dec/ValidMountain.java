package leetcode.dec;

public class ValidMountain {
    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }

        int incrTerPoint = 0;
        int decrTerPoint = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i - 1] < arr[i]) {
                incrTerPoint = i;
                // System.out.println(">" + arr[incrTerPoint]);

            } else {
                break;
            }

        }

        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i]) {
                decrTerPoint = i - 1;
                // System.out.println("<" + arr[decrTerPoint]);

            } else {
                break;
            }

        }
        // System.out.println("incr : " + incrTerPoint + " decrTerPoint " +
        // decrTerPoint);

        if (incrTerPoint != 0 && decrTerPoint != 0 && incrTerPoint == decrTerPoint) {
            return true;
        }
        return false;

    }

    public boolean validMountainArraySol(int[] arr) {
        int n = arr.length;
        int i = 0;

        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1)
            return false;

        while (i < n - 1 && arr[i] > arr[i + 1])
            i++;

        return (i == n - 1) ? true : false;
    }

    public boolean validMountainArraySol2(int[] arr) {

        if (arr.length < 3)
            return false;
        int count = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == arr[i - 1] || arr[i] == arr[i + 1]) {
                return false;
            }
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                count++;
            }
            if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                return false;
            }

        }
        if (count == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidMountain obj = new ValidMountain();
        int[] arr = { 1, 0, 1 };
        System.out.println(obj.validMountainArray(arr));
    }

}
