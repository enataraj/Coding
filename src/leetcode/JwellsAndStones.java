package leetcode;

public class JwellsAndStones {

	public int numJewelsInStones(String J, String S) {
		if (J.length() == 0 || S.length() == 0) {
			return 0;
		}
		boolean[] inp = new boolean[128];
		for (int i = 0; i < J.length(); i++) {
			inp[J.charAt(i)] = true;
		}

		int count = 0;
		for (int i = 0; i < S.length(); i++) {
			if (inp[S.charAt(i)]) {
				count++;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		String J = "aA", S = "aAAbbbb";
		int res = new JwellsAndStones().numJewelsInStones(J, S);
		System.out.println(res);
	}

}
