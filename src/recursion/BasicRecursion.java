package recursion;

public class BasicRecursion {

    public void printRecurs(int n) {
        if (n < 1) {
            return;
        }
        System.out.println(n);
        printRecurs(n - 1);
        System.out.println("After Recursion");
        System.out.println(n);
        /*
         * 
         * 
        3
        2
        1
        After Recursion
        1
        After Recursion
        2
        After Recursion
        3
         */
    }

    public void printRecurs1(int n) {
        if (n >= 3) {
            return;
        }
        System.out.println(n);
        printRecurs1(n + 1);
        System.out.println("After Recursion");
        System.out.println(n);

        /*
        1
        2
        After Recursion
        2
        After Recursion
        1
        
         */

    }

    public void printBinaryEqualent(int n) {
        if (n == 0) {
            return;
        }
        printBinaryEqualent(n / 2);
        System.out.print(n % 2);

    }

    public static void main(String[] args) {
        BasicRecursion obj = new BasicRecursion();
        // obj.printRecurs(3);
        obj.printRecurs1(1);
        obj.printBinaryEqualent((int)Math.pow(2, 32));
    }

}
