package leetcode;

public class HIndex {

    public int hIndexLinear(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int length = citations.length - 1;
        int hIndex = 0;
        for (int i = length; i >= 0; i--) {
            if (citations[length - i] >= i + 1) {
                hIndex = i + 1;
                break;
            }
        }

        return hIndex;
    }

    public int hIndexSimple(int[] citations) {
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i)
                return citations.length - i;
        }
        return 0;
    }

    public int hIndex(int[] citations) {
        int hIndex = 0;
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int low = 0;
        int high = citations.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] >= (len - mid)) {
                hIndex = Math.max(hIndex, len - mid);
                high = mid - 1;

            } else {
                low = mid + 1;
            }

        }

        return hIndex;
    }

    public static void main(String[] args) {
        int[] citations = { 0, 0, 0 };
        int hIndex = new HIndex().hIndex(citations);
        System.out.println("H Index : " + hIndex);

    }

}
