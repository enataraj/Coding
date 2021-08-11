package leetcode.aug2021;

public class LC365WaterAndJugProblem {

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z)
            return false;
        if (x == z || y == z || x + y == z)
            return true;
        return z % gcd(x, y) == 0;
    }

    // Greatest common divisor , Which max number can divide both numbers
    /*
     * 
     * 
I see a lot of solutions using gcd, but no one explains why it works. So I do some research and find out that the problem is just like a implementation of a math theory named "Bezout's Lemma". I copy the definition below, and you can find the proof of it on google if you are interested in it.

Bezout's Lemma states that if x and y are nonzero integers and g = gcd(x,y), then there exist integers a and b such that ax+by=g. In other words, there exists a linear combination of x and y equal to g.

Furthermore, g is the smallest positive integer that can be expressed in this form, i.e. g = min{ax+by | a, b in Z, ax+by > 0}.


     */
    private int gcd(int x, int y) {
        while (y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return x;
    }

    public static void main(String[] args) {
        LC365WaterAndJugProblem obj = new LC365WaterAndJugProblem();
        System.out.println(obj.gcd(10, 5));
    }

}
