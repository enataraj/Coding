package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int num = 5;
        generateFibonacci(num, 0, 1);
        
        System.out.println("\nFiboncaii at posistion : 5 --> " + fibonacci(num));

    }

    private static void generateFibonacci(int num, int pre, int cur) {
        if (num == 0) {
            return;
        }
        System.out.print("  " + pre);
        generateFibonacci(num - 1, cur, pre + cur);
    }

    private static int fibonacci(int num) {
        if (num <= 1) {
            return 1;
        }
        System.out.println("  "+num);
        return fibonacci(num - 1) + fibonacci(num - 2);

    }
}
