package leetcode.july;

public class UglyNumber {

	public int nthUglyNumber(int n) {
		int[] uglyNumber = new int[n + 1];
		uglyNumber[0] = 1;
		int index2 = 0, index3 = 0, index5 = 0;
		for (int i = 1; i < n; i++) {
			uglyNumber[i] = Math.min(uglyNumber[index2] * 2, Math.min(uglyNumber[index3] * 3, uglyNumber[index5] * 5));

			if (uglyNumber[i] == uglyNumber[index2] * 2)
				index2++;
			if (uglyNumber[i] == uglyNumber[index3] * 3)
				index3++;
			if (uglyNumber[i] == uglyNumber[index5] * 5)
				index5++;
		}
		return uglyNumber[n - 1];
	}

	public static void main(String[] args) {
		UglyNumber obj = new UglyNumber();
		int n = 11;
		int result = obj.nthUglyNumber(n);
		System.out.println(result);

	}

}
