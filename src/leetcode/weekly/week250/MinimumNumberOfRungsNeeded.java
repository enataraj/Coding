package leetcode.weekly.week250;

public class MinimumNumberOfRungsNeeded {
    public int addRungs(int[] rungs, int dist) {
        int pre = 0;
        int result = 0;
        for (int num : rungs) {
            int gap = num - pre;
            if (gap > dist) {
                if (gap % dist == 0) {
                    result += gap / dist - 1;
                } else {
                    result += (int) Math.ceil((gap) / dist);
                }
            }
            pre = num;
        }
        return result;
    }
    
    public int addRungsSol(int[] rungs, int dist) {
        int cnt = 0, prev = 0;
        for (int r : rungs) {
            cnt += (r - prev - 1) / dist;
            prev = r;
        }
        return cnt;
    }
    

    public static void main(String[] args) {
        MinimumNumberOfRungsNeeded obj = new MinimumNumberOfRungsNeeded();
        int[] nums = { 12, 24 };
        int dist = 4;
        System.out.println(obj.addRungs(nums, dist));

        System.out.println(obj.addRungs(new int[] { 3, 6, 8, 10 }, 3));
        System.out.println(obj.addRungs(new int[] { 1, 3, 5, 10 }, 2));
        System.out.println(obj.addRungs(new int[] { 3, 4, 6, 7 }, 2));
        System.out.println(obj.addRungs(new int[] { 5 }, 10));
    }

}
