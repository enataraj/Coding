package leetcode.weekly.week251;

import java.util.HashSet;
import java.util.Set;

public class MaxCompatabilityCodeSum {
    
    
    class Solution {
        int max;
        public int maxCompatibilitySum(int[][] students, int[][] mentors) {
            boolean[] visited = new boolean[students.length];
            helper(visited, students, mentors, 0, 0);
            return max;
        }
        public void helper(boolean[] visited, int[][] students, int[][] mentors, int pos, int score){
            if(pos >= students.length){
                max = Math.max(max, score);
                return;
            }
            for(int i = 0; i < mentors.length; i++)
                if(!visited[i]){
                    visited[i] = true;
                    helper(visited, students, mentors, pos + 1, score + score(students[pos], mentors[i]));
                    visited[i] = false;
                }
        }
        public int score(int[] a, int[] b){
            int count = 0;

            for(int i = 0; i < b.length; i++)
                if(a[i] == b[i]) count += 1;
            return count;
        }
    }
    

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        Set<Integer> pickedMentor = new HashSet<>();

        int finalScore = 0;
        for (int i = 0; i < students.length; i++) {
            int[] student_ans = students[i];
            int maxScore = 0;
            int mentor = -1;
            for (int j = 0; j < mentors.length; j++) {
                if (!pickedMentor.contains(j)) {
                    int[] mentor_ans = mentors[j];
                    //  System.out.println(Arrays.toString(student_ans));
                    // System.out.println(Arrays.toString(mentor_ans));
                    int score = 0;
                    for (int k = 0; k < mentor_ans.length; k++) {
                        if (student_ans[k] == mentor_ans[k]) {
                            score++;
                        }
                    }

                    if (score > maxScore) {
                        maxScore = score;
                        mentor = j;
                    }
                }

            }
            // System.out.println(maxScore+"  "+mentor);
            pickedMentor.add(mentor);
            finalScore += maxScore;
        }
        return finalScore;
    }

    public static void main(String[] args) {
        MaxCompatabilityCodeSum obj = new MaxCompatabilityCodeSum();
        int[][] students = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 1 } };
        int[][] mentors = { { 1, 0, 0 }, { 0, 0, 1 }, { 1, 1, 0 } };
        System.out.println(obj.maxCompatibilitySum(students, mentors));

    }

}
