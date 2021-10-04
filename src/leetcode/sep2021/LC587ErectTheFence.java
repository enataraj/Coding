package leetcode.sep2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class LC587ErectTheFence {

    private class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] outerTrees(int[][] trees) {

        List<Point> points = new ArrayList<>();
        for (int[] point : trees) {
            points.add(new Point(point[0], point[1]));
        }

        List<Point> res = new ArrayList<>();
        if (points.size() == 1) {

            return trees;
        }
        int n = points.size();
        Collections.sort(points, (a, b) -> a.y == b.y ? a.x - b.x : a.y - b.y);
        HashSet<ArrayList<Integer>> dup = new HashSet();

        Stack<Point> stack = new Stack<>();
        stack.push(points.get(0));
        stack.push(points.get(1));
        // Lower stack
        for (int i = 2; i < n; i++) {
            Point top = stack.pop();
            while (!stack.isEmpty() && crossProduct(stack.peek(), top, points.get(i)) < 0) {
                top = stack.pop();
            }
            stack.push(top);
            stack.push(points.get(i));
        }

        // Upper  stack
        for (int i = n - 2; i >= 0; i--) {
            Point top = stack.pop();
            while (!stack.isEmpty() && crossProduct(stack.peek(), top, points.get(i)) < 0) {
                top = stack.pop();
            }
            stack.push(top);
            stack.push(points.get(i));
        }
        for (Point p : stack) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(p.x);
            tmp.add(p.y);
            if (dup.contains(tmp))
                continue;
            dup.add(tmp);
            res.add(p);
        }

        int[][] ans = new int[res.size()][2];
        int i = 0;
        for (Point p : res) {
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i++;
        }
        return ans;
    }

    public int crossProduct(Point a, Point b, Point c) {
        double crossproduct = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (crossproduct < 0)
            return -1;
        else if (crossproduct > 0)
            return +1;
        else
            return 0;
    }

    public static void main(String[] args) {
        LC587ErectTheFence obj = new LC587ErectTheFence();
        int[][] trees = { { 1, 1 }, { 2, 2 }, { 2, 0 }, { 2, 4 }, { 3, 3 }, { 4, 2 } };
        int[][] res = obj.outerTrees(trees);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }

    }
}
