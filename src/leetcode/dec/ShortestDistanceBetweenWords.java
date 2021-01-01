package leetcode.dec;

public class ShortestDistanceBetweenWords {

    public int shortestDistance(String[] words, String word1, String word2) {

        int idx1 = -1;
        int idx2 = -1;
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {

            if (words[i].equals(word1)) {
                idx1 = i;
            }
            if (words[i].equals(word2)) {
                idx2 = i;
            }
            if (idx1 != -1 && idx2 != -1) {

                shortest = Math.min(shortest, (Math.abs(idx1 - idx2)));
            }

        }
        return shortest;
    }
    
    
    public int shortestDistanceParin(String[] words, String word1, String word2) {
        int idx1 = -1,
            idx2 = -1,
            shortest = words.length + 1;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1 = i;
            }
            
            if (words[i].equals(word2)) {
                idx2 = i;
            }
            
            if (idx1 != -1 && idx2 != -1) {
                shortest = Math.min(shortest, Math.abs(idx1 - idx2));
            }
        }
        
        return shortest;
    }

    public static void main(String[] args) {
        ShortestDistanceBetweenWords obj = new ShortestDistanceBetweenWords();
        String[] words = { "practice", "makes", "perfect", "coding", "makes" };
        String word1 = "coding";
        String word2 = "makes";
        System.out.println(obj.shortestDistance(words, word1, word2));
    }

}
