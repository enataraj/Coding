package leetcode.array;

public class LC1232CheckIfStrightLine {
    
    // Slop Formula 
    //

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length == 0) {
            return false;

        }

        if (coordinates.length == 2) {
            return true;
        }

        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];

        for (int i = 2; i < coordinates.length; i++) {
            if (dx * (coordinates[i][1] - coordinates[i - 1][1]) == dy * (coordinates[i][0] - coordinates[i - 1][0])) {
                continue;
            }
            return false;
        }
        return true;

    }
    
    
    private double getSlope(int[] coordinate0, int[] coordinate1) {
        int vx = coordinate1[0] - coordinate0[0];
        int vy = coordinate1[1] - coordinate0[1];
        
        return vx != 0
            ? ((double)vy) / vx
            : 1e10;
    }
    
    public boolean checkStraightLineAlt(int[][] coordinates) {        
        double slope = getSlope(coordinates[0], coordinates[1]);
        for(int i = 2 ; i < coordinates.length ; i++) {
            if (getSlope(coordinates[0], coordinates[i]) != slope) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC1232CheckIfStrightLine obj = new LC1232CheckIfStrightLine();
        // int[][] coordinates = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, {
        // 6, 7 } };

        int[][] coordinates = { { 0, 0 }, { 0, 1 }, { 0, -1 } };
        System.out.println(obj.checkStraightLine(coordinates));
    }

}
