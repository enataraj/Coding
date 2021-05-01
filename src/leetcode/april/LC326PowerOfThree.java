package leetcode.april;

public class LC326PowerOfThree {
    public static void main(String[] args) {
        int n=3;
        while(n<1000) {
            n=n*3;
            System.out.println(Integer.toString(n,3));
        }
    }

}
