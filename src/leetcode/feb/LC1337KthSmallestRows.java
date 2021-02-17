package leetcode.feb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LC1337KthSmallestRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        int result[] = new int[k];
        Map<Integer, List<Integer>> weekestMap = new TreeMap<>();

        for (int i = 0; i < mat.length; i++) {
            int numOfSol = 0;

            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    numOfSol++;

                } else {
                    break;
                }
            }
            if (weekestMap.containsKey(numOfSol)) {
                List<Integer> list = weekestMap.get(numOfSol);
                list.add(i);
                weekestMap.put(numOfSol, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                weekestMap.put(numOfSol, list);
            }
        }
        int idx = 0;
        for (int key : weekestMap.keySet()) {
            List<Integer> list = weekestMap.get(key);
            for (int row : list) {
                if (idx < k) {
                    result[idx] = row;
                    idx++;
                } else {
                    break;
                }
            }
            if (idx == k) {
                break;
            }
        }
        return result;
    }

    public int[] kWeakestRowsUsingPQ(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);

        int i = 0;
        for (int[] row : mat) {
            pq.offer(new int[] { countOnes(row), i });
            i++;
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[k];
        while (k > 0) {
            ans[--k] = pq.poll()[1];
        }

        return ans;
    }

    public int countOnes(int[] row) {
        int lo = 0;
        int hi = row.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (row[mid] == 1) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int sumRow(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                s += arr[i];
            } else
                break;
        }

        return s;
    }

    public int[] kWeakestRowsSor(int[][] mat, int k) {
        int[] fa = new int[mat.length];
        int[] res = new int[k];
        for (int i = 0; i < mat.length; i++) {
            int sum = sumRow(mat[i]) * 1000 + i;
            fa[i] = sum;
        }
        Arrays.sort(fa);

        for (int i = 0; i < k; i++) {
            res[i] = fa[i] % 1000;
        }
        return res;
    }

    public int[] kWeakestRowsSreeKanth(int[][] mat, int k) {
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> ((a[0] == b[0]) ? b[1] - a[1] : b[0] - a[0]));
        for (int rowIndex = 0; rowIndex < mat.length; rowIndex++) {
            int lastOneIndex = binarySearch(mat[rowIndex]);
            pq.add(new int[] { lastOneIndex, rowIndex });
            if (pq.size() > k)
                pq.poll();
        }
        while (!pq.isEmpty())
            result.add(pq.poll()[1]);
        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int binarySearch(int[] row) {
        int low = 0;
        int high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        LC1337KthSmallestRows obj = new LC1337KthSmallestRows();
        // int[][] mat = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1,
        // 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };
        int[][] mat = { { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 1 } };
        int k = 4;
        System.out.println(Arrays.toString(obj.kWeakestRows(mat, k)));
    }
}
