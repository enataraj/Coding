package leetcode.april;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LC970PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        if (bound <= 1) {
            return Collections.EMPTY_LIST;
        }

        Set<Integer> powxSet = new TreeSet<>();
        Set<Integer> powySet = new TreeSet<>();

        powxSet.add(1);
        powySet.add(1);

        int powx = 1;
        while (x != 1 && powx <= bound) {
            powx *= x;
            powxSet.add(powx);
        }

        // System.out.println(powxSet);
        int powy = 1;
        while (y != 1 && powy <= bound) {
            powy *= y;
            powySet.add(powy);
        }

        //  System.out.println(powySet);

        Set<Integer> resultSet = new HashSet<>();
        for (int num1 : powxSet) {
            for (int num2 : powySet) {
                if (num1 + num2 <= bound) {
                    resultSet.add(num1 + num2);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int num : resultSet) {
            result.add(num);
        }
        return result;

    }

    public List<Integer> powerfulIntegersSimple(int x, int y, int bound) {
        Set<Integer> resultSet = new HashSet<Integer>();
        for (int xi = 1; xi < bound; xi = xi * x) {
            for (int yi = 1; (xi + yi) <= bound; yi = yi * y) {
                resultSet.add(xi + yi);
                if (y == 1)
                    break;
            }
            if (x == 1)
                break;
        }
        return new ArrayList<Integer>(resultSet);
    }

    public List<Integer> powerfulIntegersBF(int x, int y, int bound) {
        if (bound <= 1) {
            return Collections.EMPTY_LIST;
        }

        Set<Integer> powxSet = new TreeSet<>();
        Set<Integer> powySet = new TreeSet<>();

        powxSet.add(1);
        powySet.add(1);

        int powx = 1;
        while (x != 1 && powx <= bound) {
            powx *= x;
            powxSet.add(powx);
        }

        // System.out.println(powxSet);
        int powy = 1;
        while (y != 1 && powy <= bound) {
            powy *= y;
            powySet.add(powy);
        }

        //  System.out.println(powySet);

        Set<Integer> resultSet = new HashSet<>();
        for (int num1 : powxSet) {
            for (int num2 : powySet) {
                if (num1 + num2 <= bound) {
                    resultSet.add(num1 + num2);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int num : resultSet) {
            result.add(num);
        }
        return result;

    }

    public static void main(String[] args) {
        LC970PowerfulIntegers obj = new LC970PowerfulIntegers();
        int x = 2;
        int y = 3;
        int bound = 10;
        System.out.println(obj.powerfulIntegers(x, y, bound));

    }

}
