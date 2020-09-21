package leetcode.sep;

import java.util.HashMap;
import java.util.Map;

public class RobotBoundedCircle {

    public boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 0) {
            return false;
        }

        Map<Character, Character[]> directionMap = new HashMap<>();
        Map<Character, Integer[]> positionMap = new HashMap<>();

        Character[] dir = new Character[2];
        dir[0] = 'W';
        dir[1] = 'E';
        directionMap.put('N', dir);

        dir = new Character[2];
        dir[0] = 'E';
        dir[1] = 'W';
        directionMap.put('S', dir);

        dir = new Character[2];
        dir[0] = 'N';
        dir[1] = 'S';
        directionMap.put('E', dir);

        dir = new Character[2];
        dir[0] = 'S';
        dir[1] = 'N';
        directionMap.put('W', dir);

        Integer[] pos = new Integer[2];
        pos[0] = 0;
        pos[1] = 1;
        positionMap.put('N', pos);

        pos = new Integer[2];
        pos[0] = 0;
        pos[1] = -1;
        positionMap.put('S', pos);

        pos = new Integer[2];
        pos[0] = 1;
        pos[1] = 0;
        positionMap.put('E', pos);

        pos = new Integer[2];
        pos[0] = -1;
        pos[1] = 0;
        positionMap.put('W', pos);

        pos = new Integer[2];
        pos[0] = 0;
        pos[1] = 0;

        char facing = 'N';

        for (int i = 0; i < instructions.length(); i++) {
            char inst = instructions.charAt(i);
            if (inst == 'G') {
                pos[0] = pos[0] + positionMap.get(facing)[0];
                pos[1] = pos[1] + positionMap.get(facing)[1];
            }

            if (inst == 'L') {
                facing = directionMap.get(facing)[0];

            }

            if (inst == 'R') {
                facing = directionMap.get(facing)[1];

            }

        }

        if (pos[0] == 0 && pos[1] == 0) {
            return true;
        }

        if (facing == 'N') {
            return false;
        }

        return true;

        /*
         * if (instructions.length() == 1) { if (instructions.charAt(0) == 'G') { return
         * true; } return false; }
         * 
         * boolean rotatedFlag = false; for (int i = 0; i < instructions.length(); i++)
         * { char ch = instructions.charAt(i);
         * 
         * if (ch == 'G' && rotatedFlag) { return false; }
         * 
         * if (ch != 'G' && !rotatedFlag) { rotatedFlag = true; }else if (ch != 'G' &&
         * rotatedFlag) { rotatedFlag = false; }
         * 
         * }
         * 
         * return true;
         */

    }
    
    public boolean isRobotBoundedOpt(String instructions) {
        int x = 0;
        int y = 0;
        int i = 0;
        int[][] directions = {{0,1}, {1,0},{0,-1}, {-1,0}};
        for(int j = 0; j < instructions.length(); j++){
            if(instructions.charAt(j) == 'R')
                i = (i+1) % 4;
            else if(instructions.charAt(j) == 'L')
                i = (i+3) % 4;
            else{
                x += directions[i][0];
                y +=  directions[i][1];
            }
        }
        return x == 0 && y == 0 || i > 0;
    }

    public static void main(String[] args) {
        RobotBoundedCircle obj = new RobotBoundedCircle();
        String instructions = "GLLGLGLL";
        System.out.println(obj.isRobotBounded(instructions));

    }

}
