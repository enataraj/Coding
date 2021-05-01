package leetcode.recursion;

public class LC733FloodFill {
    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }

        int currentColor = image[sr][sc];
        if (image[sr][sc] == newColor) {
            return image;
        }

        dfsHelpher(image, sr, sc, newColor, currentColor, image.length, image[0].length);
        return image;

    }

    private void dfsHelpher(int[][] image, int row, int col, int newColor, int currentCol, int maxR, int maxC) {
        if (isValid(image, row, col, maxR, maxC, currentCol)) {
            image[row][col] = newColor;

            for (int[] dir : directions) {
                int newR = row + dir[0];
                int newC = col + dir[1];
                dfsHelpher(image, newR, newC, newColor, currentCol, maxR, maxC);
            }

        }

    }

    private boolean isValid(int[][] image, int r, int c, int maxR, int maxC, int currentCol) {
        if (r >= 0 && r < maxR && c >= 0 && c < maxC && image[r][c] == currentCol) {
            return true;
        }
        return false;
    }

}
