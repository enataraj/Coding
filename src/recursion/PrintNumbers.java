package recursion;

public class PrintNumbers {
    public static void main(String[] args) {
        printNumbers(5);
        
    }
    
    private static void printNumbers(int num) {
        if(num==0) {
            return;
        }
        // Decending
        System.out.println(num);
        printNumbers(num-1);
        //Ascending
        System.out.println(num);
    }

}
