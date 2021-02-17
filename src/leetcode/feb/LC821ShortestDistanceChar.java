package leetcode.feb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class LC821ShortestDistanceChar {

    // Collect the char position
    // Iterate each char find floor and ceil value for each char
    // Fill the result

    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        TreeSet<Integer> idxSet = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                idxSet.add(i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            Integer ceil = idxSet.ceiling(i);
            Integer floor = idxSet.floor(i);
            if (ceil == null) {
                result[i] = Math.abs(floor - i);
            } else if (floor == null) {
                result[i] = Math.abs(ceil - i);
            } else {

                result[i] = Math.min(Math.abs(ceil - i), Math.abs(floor - i));
            }
        }

        return result;
    }

    // Find the char idx and put into the list
    // go through the input string and find min distance between each idx seen
    public int[] shortestToCharSol2(String s, char c) {
        int[] result = new int[s.length()];
        List<Integer> idxList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                idxList.add(i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            result[i] = findShortestDistabce(i, idxList);
        }
        return result;

    }

    private int findShortestDistabce(int idx, List<Integer> idxList) {

        if (idx < idxList.get(0)) {
            return idxList.get(0) - idx;
        }

        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < idxList.size(); i++) {
            shortest = Math.min(shortest, Math.abs(idxList.get(i) - idx));
        }

        return shortest;

    }

    // Go Left to right find distance
    // Go right to left find distance and min out of left and right side distance

    public int[] shortestToCharVinit(String s, char c) {
        int n = s.length(), dist = n;
        int[] result = new int[s.length()];

        // left side distance
        for (int i = 0; i < n; i++) {
            dist++;
            if (s.charAt(i) == c)
                dist = 0;
            result[i] = Math.min(result[i], dist);
        }
        dist = n;

        // right side distance
        for (int i = n - 1; i >= 0; i--) {
            dist++;
            if (s.charAt(i) == c)
                dist = 0;
            result[i] = Math.min(result[i], dist);
        }

        return result;
    }

    // Iterate the inout go left to right until finding the mathces and travel back
    // to refil the result.

    public int[] shortestToCharSol(String str, char c) {
        int[] result = new int[str.length()];

        int dist = str.length();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                int pos = i - 1;
                while (pos >= 0 && i - pos < result[pos]) {
                    result[pos] = i - pos;
                    pos--;
                }
                dist = 0;
            }

            result[i] = dist++;
        }

        return result;
    }

    public int[] shortestToCharParin(String s, char c) {
        int n = s.length();
        boolean[] visited = new boolean[n];
        int[] res = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == c) {
                q.add(i);
                visited[i] = true;
            }
        }

        int[] dirs = new int[] { -1, 1 };
        int dist = 0;
        while (!q.isEmpty()) {
            for (int b = q.size(); b > 0; b--) {
                int pos = q.poll();
                for (int d : dirs) {
                    int nextPos = pos + d;
                    if (nextPos >= 0 && nextPos < n && !visited[nextPos]) {
                        visited[nextPos] = true;
                        q.add(nextPos);
                        res[nextPos] = dist + 1;
                    }
                }
            }

            ++dist;
        }

        return res;
    }

    public static void main(String[] args) {
        LC821ShortestDistanceChar obj = new LC821ShortestDistanceChar();
        String s = "loveleetcode";
        char c = 'e';
        // String s = "baaaabaaab";
        // char c = 'b';
        System.out.println(Arrays.toString(obj.shortestToChar(s, c)));

    }

}
