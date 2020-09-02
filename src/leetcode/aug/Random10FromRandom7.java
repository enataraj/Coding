package leetcode.aug;

import java.util.Random;

public class Random10FromRandom7 {
    public int rand10() {
        int ran7_1 = rand7();
        int ran7_2 = rand7();

        return ran7_1 + (ran7_2 % 4);

    }

    public int rand7() {
        Random random = new Random();
        return random.nextInt(8);
    }

    public int rand10Parin() {
        Integer random1 = null, random2 = null, base10 = null;

        do {
            random1 = rand7();
            random2 = rand7();

            base10 = random1 * 7 + random2;

        } while (base10 <= 10 || base10 > 50);

        return base10 % 10 == 0 ? 10 : base10 % 10;
    }

    public int rand10Opt() {
        while (true) {
            int rand = 7 * (rand7() - 1) + (rand7() - 1);
            if (rand < 40) {
                return rand % 10 + 1;
            }
        }
    }

    public static void main(String[] args) {
        Random10FromRandom7 obj = new Random10FromRandom7();
        int i = 0;
        while (i < 10) {

            System.out.println(obj.rand10());
            i++;
        }

    }
}
