package leetcode.feb;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC895MaxFreqStack {
    
    /*
     * Maintain the frequency of each number
     * Maintain frequency vs Stack of numbers
     * Maintain maxFrequency
     */

    Map<Integer, Stack<Integer>> frequencyStack;
    Map<Integer, Integer> frequencyMap;
    int maxFrequency = 0;

    public LC895MaxFreqStack() {
        frequencyStack = new HashMap<>();
        frequencyMap = new HashMap<>();
        maxFrequency = 0;

    }

    /*
     * Every push check if its in freq map, if not add , if it exist increase the freq
     * find the max freq, after you add new element maxfreq is changed or not.
     * Append the element into the freq stack if it exist not just add it
     * 
     */
    public void push(int x) {
        int frequency;
        if (frequencyMap.containsKey(x)) {
             frequency = frequencyMap.get(x);
            frequencyMap.put(x, frequency + 1);
            frequency = frequency+1;
        } else {
            frequencyMap.put(x, 1);
            frequency=1;
        }
        maxFrequency = Math.max(frequency,maxFrequency);

        Stack<Integer> stack = frequencyStack.get(frequency);
        if (stack == null) {
            stack = new Stack<Integer>();
        }
        stack.push(x);
        frequencyStack.put(frequency, stack);

        System.out.println(frequencyStack);
        System.out.println(frequencyMap);
        System.out.println("===========");
    }
    
    /*
     * During POP Operation 
     * 
     * Take the max freq element return 
     * if the stack is empty just remove the entry from map and remove the entry from  frequencyStack
     * 
     * Update the frequency map as well.
     * 
     */

    public int pop() {

        Stack<Integer> stack = frequencyStack.get(maxFrequency);
        int value = stack.pop();
        if (stack.isEmpty()) {
            frequencyStack.remove(maxFrequency);
            maxFrequency = maxFrequency - 1;

        }
        int frequency = frequencyMap.get(value);
        if (frequency == 1) {
            frequencyMap.remove(value);
        } else {
            frequencyMap.put(value, frequency - 1);
        }

        return value;
    }

    public static void main(String[] args) {
        LC895MaxFreqStack obj = new LC895MaxFreqStack();
        obj.push(5);
        obj.push(1);
        obj.push(2);
        obj.push(5);
        obj.push(5);
        obj.push(5);
        obj.push(1);
        obj.push(6);
        obj.push(1);
        obj.push(5);

        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
       
        /*
         * ["FreqStack","push","push","push","push","push","push","push","push","push",
         * "push","pop","pop","pop","pop","pop","pop","pop","pop","pop","pop"]
         * [[],[5],[1],[2],[5],[5],[5],[1],[6],[1],[5],[],[],[],[],[],[],[],[],[],[]]
         */
    }
}
