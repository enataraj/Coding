package leetcode.nov;

public class MinCostToMoveChips {

    public int minCostToMoveChips(int[] position) {
        if (position == null || position.length == 0) {
            return 0;
        }

        int odd = 0;
        int even = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }

        }

        return Math.min(odd, even);

    }
    
    public int minCostToMoveChipsOpt(int[] chips) 
    {
        int step = 0;
        for (int chip : chips)
        {
            if (chip % 2 == 1)
            {
                step++;
            }
        }
        return Math.min(step, chips.length - step);
    }

    public static void main(String[] args) {
        MinCostToMoveChips obj = new MinCostToMoveChips();
        int[] position = { 2, 2, 2, 3, 3 };
        System.out.println(obj.minCostToMoveChips(position));
    }

}
