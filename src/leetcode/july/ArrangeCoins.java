package leetcode.july;

public class ArrangeCoins {

	public int arrangeCoins(int n) {
		int result = 0;
		long sum = 0;
		for (int i = 1; sum <= n; i++) {
			sum = sum + i;
			System.out.println("i --> "+i+"  sum :"+sum);
			if (sum <= n) {
				result++;
			}
		}

		return result;

	}
	
	public long arrangeCoinsBinary(int sum) {
        long low = 0, hi = 0, result = 1;
        while (low <= hi) {
            long mid = low + (hi-low)/2;
            long midsum = mid*(mid+1)/2;
            if (midsum == sum)
                return mid;
            if (midsum < sum) {
                result = mid;
                low = mid + 1;
                hi = 2*low;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }

	public static void main(String[] args) {
		int n = 2147483647;
		ArrangeCoins obj = new ArrangeCoins();
		int result = obj.arrangeCoins(n);
		System.out.println(result);

	}

}
