package leetcode.sep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {

        if (k == 0)
            return Collections.EMPTY_LIST;
        if ((k * (k + 1)) > 2 * n)
            return Collections.EMPTY_LIST;

        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Set<Integer> numberSet = new HashSet<>();
        dfsHelper(k, n, numberSet, result);
        return new ArrayList(result);

    }

    private int findSum(Set<Integer> numberSet) {
        int sum = 0;
        for (int num : numberSet) {
            sum += num;
        }
        return sum;
    }

    private void dfsHelper(int k, int n, Set<Integer> numberSet, Set<List<Integer>> result) {
        if (numberSet.size() == k) {
            if (findSum(numberSet) == n) {
                result.add(new ArrayList(numberSet));
                return;

            }
        } else {
            for (int i = 1; i <= 9; i++) {
                if (!numberSet.contains(i)) {
                    numberSet.add(i);
                    dfsHelper(k, n, numberSet, result);
                    numberSet.remove(i);
                }
            }
        }

    }
    
    
    public List<List<Integer>> combinationSum3Opt(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<Integer>(), k, n, 1);
        return ans;
    }
      
    private void helper(List<List<Integer>> ans, List<Integer> curList, 
                                      int k, int n, int c) {
        if(curList.size() == k && n == 0) {
            ans.add(new ArrayList(curList));
            return;
        }
        if(n < 0) {
            return;
        }
        for(int i = c ; i < 10 ; i++) {
            curList.add(i);
            helper(ans, curList, k, n-i, i+1);
            curList.remove(curList.size()-1);
        }
    }

    
    List<List<Integer>> soln = new ArrayList<>();
    public void helper (int k, int n, List<Integer> list, int start) {
        if (k == 1) {
            if ((n <= 9) && !list.contains(n)) {
                list.add(n);
                List<Integer> solnList = new ArrayList<>(list);
                soln.add(solnList);
                list.remove((Integer)n);
            } 
            return;
        }
        for (int i=start; i <= n/2; i++) {
            list.add(i);
            helper(k-1, n-i, list, i+1);
            list.remove((Integer)i);
        }    
    }
    public List<List<Integer>> combinationSum3Balaji(int k, int n) {
        if (n > 45) {
            return new ArrayList<>();
        }    
        helper(k, n, new ArrayList<Integer>(), 1);
        return soln;
    }
    
    
    public static void main(String[] args) {

        CombinationSum3 obj = new CombinationSum3();
        System.out.println(obj.combinationSum3(5, 15));

    }

}
