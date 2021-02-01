package recursion;

public class LC526BeautifulArrangement {
    int count = 0;

    public int countArrangementTLE(int n) {
        if (n == 1) {
            return 1;
        }
        permutation(1, n, new boolean[n + 1]);
        return count;

    }

    private void permutation(int left, int right, boolean[] visited) {
        if (left == right + 1) {
            count++;
        } else {
            for (int i = 1; i <= right; i++) {
                if (visited[i] || (left % i != 0 && i % left != 0)) {
                    continue;
                }
                visited[i] = true;
                permutation(left + 1, right, visited);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        LC526BeautifulArrangement obj = new LC526BeautifulArrangement();
        int n = 7;
        System.out.println(obj.countArrangementTLE(n));
    }

}
