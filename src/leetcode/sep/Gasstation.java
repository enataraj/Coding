package leetcode.sep;

public class Gasstation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }

        int idx = 0, balance = 0, total = 0;
        for (int i = 0; i < gas.length; ++i) {
            int gain = gas[i] - cost[i];
            total += gain;
            balance += gain;
            if (balance < 0) {
                balance = 0;
                idx = i + 1;
            }
        }
        return total < 0 ? -1 : idx;

    }

    public int canCompleteCircuit_Leet(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];

            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return sumGas < sumCost ? -1 : start;
    }
    
    
    
    /* Parin Two Pass Solution
     * 
     * find the lowest point where it needs gas
     * 
     * Assume that is ur start point and calcualte , if final resulet becomes negative just return -1 else that's ur answer
     * 
     */
    
    public int canCompleteCircuit_Parin(int[] gas, int[] cost) {
        int n = gas.length,
            minIdxSoFar = 0,
            minGasReading = 0,
            current = 0; // current volume of gas in the tank
        
        for (int i = 0; i < n; i++) {
            if (minGasReading > current) {
                current = minGasReading;
                minIdxSoFar = i;
            }
            
            current += gas[i]; // fill up the gas tank
            current -= cost[i]; // spend the gas to reach to the next station
        }
        
        // test if the minIdxSoFar satisfies the condition or not
        int i = minIdxSoFar;
        current = 0;
        
        do {
            current += gas[i];
            current -= cost[i];
            i = (i + 1) % n;
        } while (i != minIdxSoFar);
        
        return current < 0 ? -1 : minIdxSoFar;
    }

    public static void main(String[] args) {
        Gasstation obj = new Gasstation();
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };
        System.out.println(obj.canCompleteCircuit(gas, cost));

    }

}
