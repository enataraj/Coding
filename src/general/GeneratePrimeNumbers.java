package general;

public class GeneratePrimeNumbers {

    private static void generatePrimeNumbers(int num) {

        boolean prime[] = new boolean[num + 1];
        for (int i = 0; i < prime.length; i++) {
            prime[i] = true;
        }

        for (int i = 2; (i * i) <= num; i++) {

            if (prime[i] == true) {
                for (int j = (i * i); j <= num; j += i) {
                    prime[j] = false;
                }
            }

        }

        System.out.println("Prime Numbers ");
        for (int i = 2; i < prime.length; i++) {
            if (prime[i] == true) {
                System.out.print(" " + i);
            }
        }

    }

    public static void main(String[] args) {
        generatePrimeNumbers(115);
    }

}
