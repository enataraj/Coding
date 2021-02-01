package recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC754ReachANumber {

    public int reachNumberSol(int target) {
        target = Math.abs(target);
        double n = target;
        double ceil = Math.ceil((-1 + Math.sqrt(1 + 8 * n)) / 2);
        double sum = (ceil * (ceil + 1)) / 2;
        while ((sum - target) % 2 == 1) {
            sum += ++ceil;
        }
        return (int) ceil;
    }

    public int reachNumber(int target) {
        target = Math.abs(target);
        // Keep moving while sum is smaller or difference is odd.
        int sum = 0, step = 0;

        while (sum < target || (sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;

    }

    public int reachNumberTLE(int target) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();
        int reach = 0;
        visited.add(0);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            step += 1;
            System.out.println(queue);
            visited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                int value = queue.poll();
                if (value == target) {
                    return reach;
                }
                if (!visited.contains(value + step)) {
                    queue.add(value + step);
                    visited.add(value + step);

                }
                if (!visited.contains(value - step)) {
                    queue.add(value - step);
                    visited.add(value - step);

                }

            }
            reach += 1;

        }

        return reach;

    }

    static int steps(int source, int step, int dest) {
// base cases
        if (Math.abs(source) > (dest))
            return Integer.MAX_VALUE;

        if (source == dest)
            return step;

// at each point we can go either way

// if we go on positive side
        int pos = steps(source + step + 1, step + 1, dest);

// if we go on negative side
        int neg = steps(source - step - 1, step + 1, dest);

// minimum of both cases
        return Math.min(pos, neg);
    }

    private int dfsHelpher(int target, int step, int count, Set<Integer> visited) {
        if (step == target) {
            return count;
        }
        if (visited.contains(step)) {
            return 0;
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            visited.add(step + i);
            dfsHelpher(target, step + i, count + 1, visited);
            visited.add(step - i);
            dfsHelpher(target, step - i, count + 1, visited);
        }

        return count;
    }

    public static void main(String[] args) {
        LC754ReachANumber obj = new LC754ReachANumber();
        int target = -1000000000;
        System.out.println(obj.reachNumber(target));

    }

}
