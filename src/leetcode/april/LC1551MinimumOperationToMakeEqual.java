package leetcode.april;

public class LC1551MinimumOperationToMakeEqual {

    /*  Since the array should be symmetrical about the equalization point, for every array of odd numbers, n is the equalization point( as sum of odd numbers in square of n and n*n is also the same).
    Note-- Sum will never change if we add 1 to a[x[ and subtract 1 from a[y].
    CODE
    */

    public int minOperationsSol(int n) {

        int arrayElement = 1;//initialize to first array element
        int operations = 0;
        //for an array like [1,3,5,7,9], target value is 5
        //we have to make a[0]=5, a[1]=5 .. and so on.
        //this can be achieved by finding the difference of 5 and current arr element till elements are lesser than 5
        //equal decrement is needed for elements >5 and this will take place simultenously.
        while (arrayElement <= n) {
            operations += n - arrayElement;
            arrayElement += 2;
        }
        return operations;
    }

    public int minOperationsSol2(int n) {
        int result = 0;
        int num = 1;
        while (num <= n) {
            result += n - num;
            num += 2;
        }
        return result;
    }

    public int minOperations(int n) {
        if (n % 2 == 1) {
            return (n * n - 1) / 4;
        }
        return (n * n) / 4;

    }

    public int minOperationsSol4(int n) {

        return (n * n) / 4;

    }

}
