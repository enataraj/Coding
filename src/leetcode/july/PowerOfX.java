package leetcode.july;

import java.util.HashMap;
import java.util.Map;

public class PowerOfX {

    public double myPow(double x, int n) {
        if (x == 1.0 || n == 1)
            return x;
        if (n == 0)
            return 1.0;
        if (x == 0.0)
            return 0.0;
        boolean flag = false;
        if (n <= 0) {
            flag = true;
            n = n * -1;
        }

        double result = 1.0;
        Map<Integer, Double> powerMap = new HashMap<>();

        int key = 2;
        powerMap.put(key, (x * x));
        int i = 0;

        while (n > 1) {
            i++;
           
            if (powerMap.get(n) != null) {
                result = result * powerMap.get(n);
                break;
            } else {
                result = result * (x * x);
                powerMap.put(key, result);
            }

            key = key + 2;
            n = n - 2;
        }

        System.out.println(i);
        if (n == 1) {
            result = result * x;
        }

        if (flag) {
            result = 1 / result;
        }
        return result;

    }
    
    
    public double myPowCustomize(double x, int n) {
        if (x == 1.0 || n == 1)
            return x;
        if (n == 0)
            return 1.0;
        if (x == 0.0)
            return 0.0;
        boolean flag = false;
        if (n <= 0) {
            flag = true;
            n = n * -1;
        }

        double result = 1.0;
        Map<Integer, Double> powerMap = new HashMap<>();

        int key = 2;
        powerMap.put(key, (x * x));
        int i = 0;
       
        

        while (n > 1) {
            int tmpkey = key*2;
            if(tmpkey<n) {
                result = powerMap.get(key)*powerMap.get(key);
                key=key*2;
                powerMap.put(key, result);
            }
            n=n/2;
            System.out.println(key);
            
            
            
            
            
           
        }

        
        return result;

    }

    public double myPowOpt(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (x == 1.0)
            return 1;

        if (x > 0 && n == Integer.MIN_VALUE)
            return 0;
        if (x < 0 && n == Integer.MIN_VALUE)
            return 1;
        if (x > 0 && n == Integer.MAX_VALUE)
            return 0;
        if (x < 0 && n == Integer.MAX_VALUE)
            return -1;

        double res = 1;
        boolean powIsNegative = (n < 0);

        res = fastpow(x, n);

        // System.out.println(res);
        if (powIsNegative)
            return 1 / res;

        return res;
    }

    private double fastpow(double x, int n) {
        if (n == 0)
            return 1;

        double half = fastpow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }

    }

    public static void main(String[] args) {

        PowerOfX obj = new PowerOfX();
        double x = 2;
        int n = 200;
        double resu = obj.myPowCustomize(x, n);
        System.out.println("Result : " + resu);
        System.out.println(Math.pow(x, n));

    }

}
