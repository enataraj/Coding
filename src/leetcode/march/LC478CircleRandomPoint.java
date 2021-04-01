package leetcode.march;

import java.util.Arrays;
import java.util.Random;

public class LC478CircleRandomPoint {
    
    /*
     * 
     *  Consider a,b is center of the circle and x,y is some point and 'r' is radius
     *  Range of x co-ordinate : a-r,a+r
     *  Range of y co-ordinate : b-r , b+r
     *  
     *  
     *  
     *  
     *  (x-a) ^ 2 + (y-b) ^ 2 = r^2  // x,y is on the circle
     *   
     *  (x-a) ^ 2 + (y-b) ^ 2 < r^2  // x,y is inside the circle
     *  
     *  (x-a) ^ 2 + (y-b) ^ 2 > r^2  // x,y is outside the circle.
     *  
     *  So Objective is needs to generate the x,y by random which should inside the circle.
     *  
     *  Distance : (x-a)^2 + (y-b)^2
     *  
     *  co-ordinate
     *  
     *  x-radius+Math.random() * (2*radius)
     * 
     * 
     */

    double radius, x_center, y_center;
    Random random;

    public void Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        random = new Random();
    }

    public double[] randPoint() {
        double x = getRandomCoordinate(radius, x_center);
        double y = getRandomCoordinate(radius, y_center);
        while (getDistance(x, y) >= radius * radius) {
            x = getRandomCoordinate(x_center);
            y = getRandomCoordinate(y_center);
        }

        return new double[] { x, y };

    }

    private double getDistance(double x, double y) {
        return (x - x_center) * (x - x_center) + (y - y_center) * (y - y_center);
    }
    
    private double getRandomCoordinate(double c) {
        return c - radius + Math.random() * (2 * radius);

    }


    private double getRandomCoordinate(double r, double c) {
        return c - r + Math.random() * (2 * r);

    }

    public double[] randPointParin() {
        while (true) {
            double xr = (2.0 * radius * (random.nextDouble()) - radius) + x_center,
                    yr = (2.0 * radius * (random.nextDouble()) - radius) + y_center;

            if ((xr - x_center) * (xr - x_center) + (yr - y_center) * (yr - y_center) <= radius * radius) {
                return new double[] { xr, yr };
            }
        }
    }
    
    
    
   
    
    public double[] randPointCos() {
        double len = Math.sqrt(Math.random()) * radius;
        double deg = Math.random() * 2 * Math.PI;
        return new double[]{x_center + len * Math.cos(deg), y_center + len * Math.sin(deg)};
    }

    public static void main(String[] args) {
        LC478CircleRandomPoint obj = new LC478CircleRandomPoint();
        obj.Solution(1, 0, 0);
        System.out.println(Arrays.toString(obj.randPoint()));
        System.out.println(Arrays.toString(obj.randPoint()));
        System.out.println(Arrays.toString(obj.randPoint()));

    }

}
