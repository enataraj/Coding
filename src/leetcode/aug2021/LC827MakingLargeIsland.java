package leetcode.aug2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC827MakingLargeIsland {
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int localResult = 0;
    int result = 1;
    List<Set<String>> isLandGroup = new ArrayList<>();

    public int largestIsland(int[][] grid) {

        // Find  all  Islands and size
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        int maxResult = grid.length * grid[0].length;
        int isLandIdentifier = 1000;

        Map<Integer, Integer> isLandSizeMap = new HashMap<>(); // Marking each Island with unique Identifier and isLandSize

        // Regular DFS find all isLand and update the uniqueIdentifier to the isLand also use that as visited as well.
        // Get the size of each isLand
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (grid[i][j] == 1) {
                    isLandIdentifier++;
                    localResult = 1;
                    grid[i][j] = isLandIdentifier;
                    dfsHelper(grid, i, j, rows, cols, isLandIdentifier);
                    if (localResult == maxResult) {
                        return localResult;
                    }
                    isLandSizeMap.put(isLandIdentifier, localResult);
                }
            }
        }
        
        for(int i=0;i<grid.length;i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        
        System.out.println(isLandSizeMap);

        // Go over all zero location in Grid, Look all nearest Unique isLand and make biggest isLand
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                Set<Integer> mergeIdxSet = new HashSet<>();
                int sum = 0;
                if (grid[i][j] == 0) {
                    for (int[] dir : dirs) {
                        int newRow = dir[0] + i;
                        int newCol = dir[1] + j;
                        if (isValid(newRow, newCol, rows, cols) && grid[newRow][newCol] != 0) {
                            int isLandId = grid[newRow][newCol];
                            if (!mergeIdxSet.contains(isLandId)) {
                                mergeIdxSet.add(isLandId);
                                sum += isLandSizeMap.get(isLandId);
                            }
                        }

                    }
                }
                result = Math.max(result, sum + 1);
            }
        }
        return result;
    }

    private void dfsHelper(int[][] grid, int row, int col, int rows, int cols, int isLandIdentifier) {
        for (int[] dir : dirs) {
            int newR = dir[0] + row;
            int newC = dir[1] + col;
            if (isValid(newR, newC, rows, cols) && grid[newR][newC] == 1) {

                grid[newR][newC] = isLandIdentifier;
                localResult++;
                dfsHelper(grid, newR, newC, rows, cols, isLandIdentifier);
            }
        }
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row <= rows && col >= 0 && col <= cols;

    }

    public static void main(String[] args) {

        LC827MakingLargeIsland obj = new LC827MakingLargeIsland();

        int[][] grid = { { 1, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1 } };
        //   int[][] grid = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 },
        //         { 1, 1, 1, 1, 1 } };

        System.out.println(obj.largestIsland(grid));

    }
}

/*
 * 
 * 
 * 
 
 
 public class LC827MakingLargeIsland {

    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int localResult = 1;
    int result = 1;

    public int largestIsland(int[][] grid) {
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        int maxResult = grid.length * grid[0].length;
        boolean hasZero = false;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    boolean[][] visited = new boolean[rows + 1][cols + 1];
                    visited[i][j] = true;
                    grid[i][j] = 1;
                    localResult = 1;
                    dfsHelper(grid, i, j, rows, cols, visited);
                    if (localResult == maxResult) {
                        return localResult;
                    }
                    result = Math.max(localResult, result);
                    grid[i][j] = 0;
                }
            }
        }
        if (!hasZero) {
            return maxResult;
        }

        return result;
    }

    private void dfsHelper(int[][] grid, int row, int col, int rows, int cols, boolean[][] visited) {
        for (int[] dir : dirs) {
            int newR = dir[0] + row;
            int newC = dir[1] + col;
            if (isValid(newR, newC, rows, cols) && !visited[newR][newC] && grid[newR][newC] == 1) {
                visited[newR][newC] = true;
                localResult++;
                dfsHelper(grid, newR, newC, rows, cols, visited);
            }

        }

    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row <= rows && col >= 0 && col <= cols;

    }

    public static void main(String[] args) {

        LC827MakingLargeIsland obj = new LC827MakingLargeIsland();

        int[][] grid = { { 1, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1 } };
        //   int[][] grid = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 },
        //         { 1, 1, 1, 1, 1 } };

        System.out.println(obj.largestIsland(grid));

    }

}
 
 */

/*
 * 
 * 
 * 
 
 
 public class LC827MakingLargeIsland {

    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int localResult = 0;
    int result = 1;
    List<Set<String>> isLandGroup = new ArrayList<>();
    List<Integer> isLandSize = new ArrayList<>();

    public int largestIsland(int[][] grid) {

        // Find  all  Islands and size

        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        int maxResult = grid.length * grid[0].length;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (grid[i][j] == 1) {
                    Set<String> visitedIdxSet = new HashSet<>();
                    visitedIdxSet.add(i + "#" + j);
                    localResult = 1;
                    grid[i][j] = 2;// marking visited
                    dfsHelper(grid, i, j, rows, cols, visitedIdxSet);
                    if (localResult == maxResult) {
                        return localResult;
                    }
                    isLandGroup.add(visitedIdxSet);
                    isLandSize.add(localResult);
                }
            }
        }

   
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                Set<Integer> mergeIdxSet = new HashSet<>();
                int sum = 0;
                if (grid[i][j] == 0) {
                    for (int[] dir : dirs) {
                        int newRow = dir[0] + i;
                        int newCol = dir[1] + j;
                        if (isValid(newRow, newCol, rows, cols) && grid[newRow][newCol] != 0) {
                            for (int k = 0; k < isLandGroup.size(); k++) {
                                if (isLandGroup.get(k).contains(newRow + "#" + newCol) && !mergeIdxSet.contains(k)) {
                                    mergeIdxSet.add(k);
                                    sum += isLandSize.get(k);
                                }
                            }
                        }

                    }
                }
                result = Math.max(result, sum+1);

            }
        }

        return result;
    }

    private void dfsHelper(int[][] grid, int row, int col, int rows, int cols, Set<String> visitedIdxList) {
        for (int[] dir : dirs) {
            int newR = dir[0] + row;
            int newC = dir[1] + col;
            if (isValid(newR, newC, rows, cols) && grid[newR][newC] == 1) {
                visitedIdxList.add(newR + "#" + newC);
                grid[newR][newC] = 2; // Marking visited
                localResult++;
                dfsHelper(grid, newR, newC, rows, cols, visitedIdxList);
            }

        }

    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row <= rows && col >= 0 && col <= cols;

    }

    public static void main(String[] args) {

        LC827MakingLargeIsland obj = new LC827MakingLargeIsland();

        int[][] grid = { { 1, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1 } };
        //   int[][] grid = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 },
        //         { 1, 1, 1, 1, 1 } };

        System.out.println(obj.largestIsland(grid));

    }

}

 
 * 
 * 
 */

/*
 * 
 * 
 * 
 
 package leetcode.aug2021;

import java.util.HashSet;
import java.util.Set;

public class LC827MakingLargeIsland {

    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int localResult = 0;
    int result = 0;

    public int largestIsland(int[][] grid) {

        Set<String> zeroCellsSet = new HashSet<>();
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        int totalOnes = 0;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                boolean flag = false;
                if (grid[i][j] == 0) {
                    for (int[] dir : dirs) {
                        int newRow = dir[0] + i;
                        int newCol = dir[1] + j;
                        if (isValid(newRow, newCol, rows, cols) && grid[newRow][newCol] == 1) {
                            flag = true;
                            break;
                        }

                    }
                } else {
                    totalOnes++;
                }
                if (flag) {
                    zeroCellsSet.add(i + "#" + j);
                }

            }
        }

        // Early Exist all of them are one.
        if (totalOnes == ((rows + 1) * (cols + 1))) {
            return totalOnes;
        }

        // Find once all potential largest Islands
        findlargestIsland(grid);

        // None of the adjacent zero cells are connected to Island
        // So Just find only once largest Island
        if (zeroCellsSet.isEmpty()) {
            return result + 1;
        }

        for (String cell : zeroCellsSet) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            String[] celStr = cell.split("#");
            int row = Integer.parseInt(celStr[0]);
            int col = Integer.parseInt(celStr[1]);
            localResult = 1;
            visited[row][col] = true;
            dfsHelper(grid, row, col, rows, cols, visited);
            result = Math.max(result, localResult);

        }

        if (!zeroCellsSet.isEmpty()) {
            return result;
        }

        return result;
    }

    private void findlargestIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    localResult = 1;
                    visited[i][j] = true;
                    dfsHelper(grid, i, j, rows, cols, visited);
                    result = Math.max(result, localResult);
                }
            }
        }

    }

    private void dfsHelper(int[][] grid, int row, int col, int rows, int cols, boolean[][] visited) {
        for (int[] dir : dirs) {
            int newR = dir[0] + row;
            int newC = dir[1] + col;
            if (isValid(newR, newC, rows, cols) && !visited[newR][newC] && grid[newR][newC] == 1) {
                visited[newR][newC] = true;
                localResult++;
                dfsHelper(grid, newR, newC, rows, cols, visited);
            }

        }

    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row <= rows && col >= 0 && col <= cols;

    }

    public static void main(String[] args) {

        Set<String> zeroCellsSet = new HashSet<>();

        zeroCellsSet.add(0 + "#+" + 0);
        zeroCellsSet.add(0 + "#+" + 0);
        zeroCellsSet.add(0 + "#+" + 0);
        System.out.println(zeroCellsSet.size());
        for (String str : zeroCellsSet) {
            String st1 = str.substring(0, str.indexOf('#'));
            String st2 = str.substring(str.indexOf('#') + 2, str.length());
            System.out.println(st1);
            System.out.println(st2);
        }

        LC827MakingLargeIsland obj = new LC827MakingLargeIsland();

        int[][] grid = {};
        System.out.println(obj.largestIsland(grid));

    }

}

 
 
 */
