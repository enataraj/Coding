package leetcode.nov;

import java.util.Arrays;

public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if ((p1.length != 2 || p2.length != 2 || p3.length != 2 || p4.length != 2)) {
            return false;
        }

        int[][] points = new int[4][2];
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;

        Arrays.sort(points, (a1, a2) -> a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0]);
        p1 = points[0];
        p2 = points[1];
        p3 = points[2];
        p4 = points[3];
        System.out.println(Arrays.toString(p1));
        System.out.println(Arrays.toString(p2));
        System.out.println(Arrays.toString(p3));
        System.out.println(Arrays.toString(p4));

        if (p1[0] != p2[0] && p3[0] != p4[0]) {
            return false;
        }
        if (p1[1] != p3[1] && p2[1] != p4[1]) {
            return false;
        }
        if (p2[1] != p3[0] && p3[0] != p4[1]) {
            return false;
        }
        if (p2[0] != p3[1] && p2[1] != p3[0]) {
            return false;
        }

        return true;

    }
    
public boolean validSquareParin(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        return (!isEqual(p1, p2) && !isEqual(p1, p3) && !isEqual(p1, p4) 
            && !isEqual(p2, p3) && !isEqual(p2, p4) && !isEqual(p3, p4)) // all points are different
            && (helper(p1, p2, p3, p4)
            || helper(p1, p3, p2, p4)
            || helper(p1, p2, p4, p3));
    }
    
    private boolean helper(int[] p1, int[] p2, int[] p3, int[] p4) { // check whether square can be formed with p1 and p3 as diagonal
        
        return distSquare(p1, p3) == distSquare(p2, p4) // diagonals are equal length
            && distSquare(p1, p2) == distSquare(p1, p4) && distSquare(p2, p3) == distSquare(p3, p4)// sides are equal length
            && distSquare(p1, p2) + distSquare(p1, p4) == distSquare(p2, p4); // pythagorus theorum
    }
        
    private long distSquare(int[] p1, int[] p2) {
        return (long)(p1[0] - p2[0]) * (long) (p1[0] - p2[0])
            + (long)(p1[1] - p2[1]) * (long) (p1[1] - p2[1]);
    }
    
    private boolean isEqual(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }
// -1,0
    
    
    public boolean validSquareSol(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d12 = dist(p1,p2);
        int d13 = dist(p1,p3);
        int d14 = dist(p1,p4);
        int d23 = dist(p2,p3);
        int d24 = dist(p2,p4);
        int d34 = dist(p3,p4);
        if(d12==d13)
            return validate(d12, d24, d34, d13, d14, d23);
        if(2*d12==d13)
            return validate(d12, d23, d34, d14, d13, d24);
        if(d12==2*d13)
            return validate(d13, d23, d24, d14, d12, d34);
        return false;
    }
    
    private boolean validate(int a1, int a2, int a3, int a4, int d1, int d2) {
        if(a1==0)
            return false;
        return a1==a2
            && a1==a3
            && a1==a4
            && d1==d2
            && d1==2*a1;
    }
    
    private int dist(int[] a, int[] b) {
        int dx = a[0]-b[0];
        int dy = a[1]-b[1];
        return dx*dx+dy*dy;
    }
    public static void main(String[] args) {

        // int[] p1 = { 0, 0 }; // 2,2
        // int[] p2 = { 0, 5 }; // 2,8
        // int[] p3 = { 5, 0 }; // 8,2
        // int[] p4 = { 5, 5 }; // 8,8

        int[] p1 = { 1, 0 }; // 2,2
        int[] p2 = { -1, 0 }; // 2,8
        int[] p3 = { 0, 1 }; // 8,2
        int[] p4 = { 0, -1 }; // 8,8

        ValidSquare obj = new ValidSquare();
        System.out.println(obj.validSquare(p1, p2, p3, p4));

    }

}
