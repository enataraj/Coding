package leetcode.oct;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CumulativeSum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        if (candidates.length == 1 && target % candidates[0] == 0) {

            result.add(oneElementCase(candidates[0], target));
            return result;
        }

        Set<Integer> candidateSet = new TreeSet<>();
        for (int i = 0; i < candidates.length; i++) {
            candidateSet.add(candidates[i]);
        }

        int[] newCandidates = new int[candidateSet.size()];
        int i = 0;
        for (int num : candidateSet) {
            newCandidates[i] = num;
            i++;

        }

        if (newCandidates.length == 1 && target % newCandidates[0] == 0) {
            result.add(oneElementCase(newCandidates[0], target));
            return result;

        }

        for (i = 0; i < newCandidates.length; i++) {
            if (target % newCandidates[i] == 0) {
                result.add(oneElementCase(newCandidates[i], target));
            }
            int tmpTarget = target - newCandidates[i];
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(newCandidates[i]);

            for (int j = i + 1; j < newCandidates.length; j++) {

                if (candidateSet.contains(tmpTarget)) {
                    for (int k = 0; k < target / tmpTarget; k++) {
                        tmpList.add(tmpTarget);
                    }

                    result.add(tmpList);
                } else {

                    tmpList.add(newCandidates[i]);
                    if (tmpTarget % newCandidates[j] == 0) {
                        for (int k = 0; k < tmpTarget / newCandidates[j]; k++) {
                            tmpList.add(newCandidates[k]);
                        }

                        result.add(tmpList);

                    } else {
                        tmpList.add(newCandidates[j]);
                        tmpTarget = tmpTarget - newCandidates[j];

                    }
                }

            }
        }

        return result;

    }

    private List<Integer> oneElementCase(int num, int target) {

        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < target / num; i++) {
            tmp.add(num);
        }

        return tmp;

    }

    public static void main(String[] args) {
        CumulativeSum obj = new CumulativeSum();
        // int[] candidates = { 2, 3, 5 };
        // int target = 8;
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;

        System.out.println(obj.combinationSum(candidates, target));

    }

}
