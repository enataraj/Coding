package leetcode.string;

public class LC1455CheckIfPrefix {

    public int isPrefixOfWord(String sentence, String searchWord) {
        int idx = 1;
        for (String str : sentence.split(" ")) {

            if (str.length() >= searchWord.length()) {
                int i = 0;
                boolean flag = true;
                for (i = 0; i < searchWord.length() && flag; i++) {
                    if (str.charAt(i) != searchWord.charAt(i)) {
                        flag = false;
                        ;
                    }

                }
                if (flag)
                    return idx;
            }
            idx++;
        }
        return -1;
    }

}
