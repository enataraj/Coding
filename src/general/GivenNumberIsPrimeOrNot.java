package general;

public class GivenNumberIsPrimeOrNot {

    private static void isPrime(int num) {

        int i;

        if (num <= 2) {
            System.out.println(num + "  Prime Number");
            return;
        }

        for (i = 2; i < num; i++) {
            if (num % i == 0) {
                break;
            }
        }
        if (i == num) {
            System.out.println(num + "  Prime Number");
        } else {
            System.out.println(num + "  Not Prime Number");
        }
    }

    private static void isPrimeEfficent(int num) {

        if (num <= 2) {
            System.out.println(num + "  Prime Number");
            return;
        }

        int i = 0;
        double sqtval = Math.sqrt(num * 1.0);
        System.out.println("Sqt Value : " + sqtval);
        double stval = Math.floor(sqtval);
        System.out.println("Floor Sqt Value :" + stval);

        for (i = 2; i < stval; i++) {
            if (num % i == 0) {
                break;
            }

        }

        if ((i * 1.0) == stval) {
            System.out.println(num + " Prime Number ");
        } else {
            System.out.println(num + "  Not Prime Number");
        }

    }

    public static void main(String[] args) {
        int prime = 17;
        isPrime(prime);
        isPrimeEfficent(prime);
    }
}
