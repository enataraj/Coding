package leetcode.feb;

import java.util.Arrays;
import java.util.Stack;

public class LC946ValidatStackSequence {
    
    /*
     * Initialized both start pointer zero
     * If the pushed array value is not equal poped array , Just push the pushed array value into stack
     * If the pushed array value is equal , Just pop the element from the stack until the popped array values match the peek of the stack.
     * Once the pushed array elements are completly covered, Still we see elements in stack return false else return true. 
     */

    public boolean validateStackSequencesSol(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0, j = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // Pointer to point at the top
        int i = 0;
        int j = 0;

        for (int k = 0; k < pushed.length; k++) {
            // point the latest element to the top
            pushed[i] = pushed[k];
            while (i >= 0 && pushed[i] == popped[j]) {
                i--;
                j++;
            }
            i++;
            System.out.println(Arrays.toString(pushed));
        }

        return i == 0;
    }

    public static void main(String[] args) {
        LC946ValidatStackSequence obj = new LC946ValidatStackSequence();
        // int[] pushed = { 1, 2, 3, 4, 5 };
        // int[] popped = { 4, 5, 3, 2, 1 };
        // int[] popped = {4,3,5,1,2};

        int[] pushed = { 2, 1, 0 };
        int[] popped = { 1, 2, 0 };
        System.out.println("Input : "+Arrays.toString(pushed));
        System.out.println("Input : "+Arrays.toString(popped));
        System.out.println(obj.validateStackSequences(pushed, popped));
    }

}
