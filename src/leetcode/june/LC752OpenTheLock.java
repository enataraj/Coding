package leetcode.june;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC752OpenTheLock {
    public int openLock(String[] deadends, String target) {

        Set<String> deadEndSet = new HashSet<>();
        for (String str : deadends) {
            deadEndSet.add(str);
            if (str.equals("0000")) {
                return -1;
            }
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        queue.add("0000");
        int result = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            max = Math.max(max, size);
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                char[] curentStr = cur.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char[] tmp = curentStr;
                    tmp[j] = (char) (((curentStr[j] - '0' + 1) % 10) + '0');
                    String tmpStr = new String(tmp);
                    if (target.equals(tmpStr)) {
                        System.out.println(max);
                        return result;
                    }
                    if (!visited.contains(tmpStr) && !deadEndSet.contains(tmpStr)) {
                        visited.add(tmpStr);
                        queue.add(tmpStr);
                    }
                    curentStr = cur.toCharArray();
                    tmp[j] = (char) (((curentStr[j] - '0' - 1 + 10) % 10) + '0');
                    tmpStr = new String(tmp);
                    if (target.equals(tmpStr)) {
                        System.out.println(max);
                        return result;
                    }
                    if (!visited.contains(tmpStr) && !deadEndSet.contains(tmpStr)) {
                        visited.add(tmpStr);
                        queue.add(tmpStr);
                    }
                }

            }

        }
        System.out.println(max);
        return -1;
    }

    public int openLockSol(String[] deadends, String target) {
        int[] pow10 = { 1, 10, 100, 1000 };
        int[] visit = new int[10000]; // 0: not visited, 1: visited through forward direction, -1: visited through backward direction, 2: deadends
        for (String dead : deadends) {
            visit[Integer.parseInt(dead)] = 2;
        }
        int src = 0, dest = Integer.parseInt(target), steps = 0, dir = 1;
        if (visit[src] == 2 || visit[dest] == 2)
            return -1;
        if (src == dest)
            return 0;
        Queue<Integer> forward = new LinkedList<>(), backward = new LinkedList<>();
        forward.add(src);
        visit[src] = 1;
        backward.add(dest);
        visit[dest] = -1;
        while (!forward.isEmpty() && !backward.isEmpty()) {
            if (forward.size() > backward.size()) {
                Queue<Integer> tmp = forward;
                forward = backward;
                backward = tmp;
                dir = -dir;
            }
            steps++;
            int size = forward.size();
            while (size-- > 0) {
                int cur = forward.poll();
                for (int p : pow10) {
                    int d = (cur / p) % 10;
                    for (int i = -1; i <= 1; i += 2) {
                        int z = d + i;
                        z = z == -1 ? 9 : (z == 10 ? 0 : z);
                        int next = cur + (z - d) * p;
                        if (visit[next] == -dir)
                            return steps;
                        if (visit[next] == 0) {
                            forward.add(next);
                            visit[next] = dir;
                        }
                    }
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        String[] deadends = { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" };
        String target = "8888";
        LC752OpenTheLock obj = new LC752OpenTheLock();
        System.out.println(obj.openLock(deadends, target));
    }

}
