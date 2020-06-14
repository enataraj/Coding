package recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.print("Find Factorial for Number : 15 is - > ");
        int fact = factorial(5);
        System.out.print(fact);

    }

    private static int factorial(int num) {
        if (num == 0)
            return 1;
        return num * factorial(num-1);
                
        
    }
    

}
