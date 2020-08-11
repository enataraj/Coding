package leetcode.aug;

public class DeductCaptial {

    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        if (word.length() == 1) {
            return true;
        }

        int firstChar = word.charAt(0);
        int secondChar = word.charAt(1);

        boolean flag = false;
        if (firstChar >= 65 && firstChar <= 90) {
            if (secondChar >= 65 && secondChar <= 90) {
                flag = false;
            } else {
                flag = true;
            }

        } else {
            flag = true;
        }

        System.out.println(flag);

        for (int i = 1; i < word.length(); i++) {
            int cha = word.charAt(i);
            if (cha >= 97 && cha <= 122) {
                if (!flag)
                    return false;

            }

            else if (cha >= 65 && cha <= 90) {
                if (flag)
                    return false;

            }
        }

        return true;

    }
    
    
    public boolean detectCapitalUseOpt(String word) {
        int n = word.length();
        if (n == 1) {
            return true;
        }

        // case 1: All capital
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < n; i++) {
                if (Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        // case 2 and case 3
        } else {
            for (int i = 1; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        // if pass one of the cases
        return true;        
    }
    
    
    public boolean detectCapitalUseOpt1(String word) {
        int lastCap = -1;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                if(lastCap + 1 == i) {
                    lastCap++;
                } else {
                    return false;
                }
            }
        }
        
        if(lastCap == -1 || lastCap == word.length() - 1 || lastCap == 0) {
            return true;
        }
        
        return false;
    }

    public static void main(String[] args) {

        DeductCaptial obj = new DeductCaptial();
        String word = "Sss";
        System.out.println(obj.detectCapitalUse(word));
    }

}
