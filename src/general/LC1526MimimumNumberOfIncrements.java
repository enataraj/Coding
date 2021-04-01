package general;

import java.util.Stack;

public class LC1526MimimumNumberOfIncrements {

    /*
     * Initial Thought process, Put the target into minheap, Take the number from minheap , go to that index expand left and right and reduce one.
     * 
     * Again pick the next min value from heap go to that index, Go left and right. This may be N^2 Solution.
     */

    public int minNumberOperations(int[] target) {

        int result = 0;
        int pre = 0;
        for (int num : target) {
            if (num > pre) {
                result += num - pre;
            }
            pre = num;
        }
        return result;
    }

    public int minNumberOperationsBuildingDiffArray(int[] A) {
        int neg = 0, pos = 0;
        for (int i = 0; i < A.length; i++) {
            int dif = A[i] - get(A, i - 1);
            if (dif > 0)
                pos += dif;
            else
                neg -= dif;
        }
        return Math.max(pos, neg);
    }

    public int get(int A[], int i) {
        if (i < 0)
            return 0;
        return A[i];
    }

    public int minNumberOperationsMonotanicStack(int[] target) {
        if (target.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(target[0]);
        int ans = 0;
        for (int i = 1; i < target.length; ++i) {
            if (target[i] < stack.peek()) {
                ans += stack.pop() - target[i];
                stack.add(target[i]);
            } else if (target[i] > stack.peek()) {
                stack.add(target[i]);
            }
        }
        return ans + (stack.empty() ? 0 : stack.peek());
    }
    
    
    public int minNumberOperationsStack(int[] target) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < target.length; i++){
            int tmp = 0;
            if(!stack.isEmpty() && stack.peek() > target[i]){
                tmp = stack.peek() - target[i];
                while(!stack.isEmpty() && stack.peek() > target[i])
                    stack.pop();
            }
            res += tmp;
            stack.push(target[i]);
        }
        if(!stack.isEmpty())
            res += stack.peek();
        return res;
    }

    public static void main(String[] args) {
        LC1526MimimumNumberOfIncrements obj = new LC1526MimimumNumberOfIncrements();
        int[] target = { 1, 2, 3, 2, 1 };
        System.out.println(obj.minNumberOperations(target));
    }

}
