package leetcode.oct;

public class MaxDistanceBetweenPerson {

    public int maxDistToClosest(int[] seats) {

        int maxDist = 0;
        int tmp = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                tmp = 0;
            } else {
                tmp++;
                maxDist = Math.max(maxDist, (tmp+1) / 2);
            }
        }

        // Edge case for left side is empty
        tmp = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                tmp++;
            } else {
                maxDist = Math.max(maxDist, tmp);
                break;
            }
        }
        // Edge case for right side is empty
        tmp = 0;
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 0) {
                tmp++;
            } else {
                maxDist = Math.max(maxDist, tmp);
                break;
            }
        }

        return maxDist;

    }

    public int maxDistToClosestOld(int[] seats) {

        int firstPersonPlace = Integer.MIN_VALUE;
        int lastPersonPlace = Integer.MIN_VALUE;
        int maxDist = 1;
        boolean firstOneSeen = false;
        boolean flag = true;
        int start = 0;
        int end;

        for (int i = 0; i < seats.length; i++) {
            if (firstPersonPlace == Integer.MIN_VALUE && seats[i] == 1) {
                firstPersonPlace = i;
            } else if (seats[i] == 1) {

                lastPersonPlace = Math.max(lastPersonPlace, i);

            }
            if (seats[i] == 1) {
                if (!firstOneSeen) {
                    firstOneSeen = true;
                    maxDist = i;
                    System.out.println("Determine here 1--> " + maxDist);
                }

                if (flag) {
                    flag = false;
                    start = i;
                } else {
                    end = i;
                    maxDist = Math.max((end - start - 1) / 2, maxDist);
                    System.out.println("Determine here 2 -->" + maxDist);
                    start = i;
                    flag = true;

                }

            }
        }

        // Corner case for 00001 or 10000

        if (lastPersonPlace == Integer.MIN_VALUE && (firstPersonPlace == 0 || firstPersonPlace == seats.length - 1)) {
            System.out.println("Determine here 4-->" + (seats.length - 1));
            return seats.length - 1;
        } else if (lastPersonPlace == Integer.MIN_VALUE) { // Corner case for 00010000
            System.out
                    .println("Determine here 5--->" + Math.max(firstPersonPlace, seats.length - firstPersonPlace - 1));
            return Math.max(firstPersonPlace, seats.length - firstPersonPlace - 1);

        } else if (!flag) {
            maxDist = Math.max(maxDist, seats.length - start);
            System.out.println("Determine here 3 -->" + maxDist);

        }

        return maxDist;

    }

    public static void main(String[] args) {

        MaxDistanceBetweenPerson obj = new MaxDistanceBetweenPerson();
        // int seats[] = { 1, 0, 0, 0, 1, 0, 1 };
        int seats[] = { 1, 0, 1, 0, 0, 1, 0, 1, 0, 1 };
        System.out.println(obj.maxDistToClosest(seats));

    }

}
