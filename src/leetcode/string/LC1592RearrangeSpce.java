package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class LC1592RearrangeSpce {

    public String reorderSpaces(String text) {
        int cnt = 0;
        int length = text.length();
        int i = 0;
        StringBuffer strBuffer = new StringBuffer();
        List<StringBuffer> list = new ArrayList<>();
        int size = 0;
        while (i < length) {

            while (i < length && text.charAt(i) == ' ') {
                cnt++;
                i++;
            }

            while (i < length && text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                strBuffer.append(text.charAt(i));
                i++;
            }

            if (strBuffer.length() > 0) {
                list.add(strBuffer);
                strBuffer = new StringBuffer();
                size++;
            }
        }

        if (list.size() == 1) {
            StringBuffer resultString = new StringBuffer(list.get(0));
            for (i = 0; i < cnt; i++) {
                resultString.append(' ');
            }
            return resultString.toString();
        }

        int space = cnt / (size - 1);
        int extrSpace = cnt % (size - 1);

        StringBuffer spaceBuffer = new StringBuffer();
        for (i = 0; i < space; i++) {
            spaceBuffer.append(' ');
        }

        StringBuffer resultString = new StringBuffer();
        for (i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                resultString.append(list.get(i));
                resultString.append(spaceBuffer);
            } else {
                resultString.append(list.get(i));
            }

        }

        for (i = 0; i < extrSpace; i++) {
            resultString.append(' ');
        }
        return resultString.toString();

    }
    
    
    public String reorderSpacesSol(String text) {
        int length = text.length();
        int spaceCount = 0;
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                spaceCount++;
                if (sb.length() > 0) {
                    words.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }
        
        if (sb.length() > 0) {
            words.add(sb.toString());
            sb.setLength(0);
        }
        
        int wordCount = words.size();
        for (int i = 0; i < wordCount - 1; i++) {
            sb.append(words.get(i));
            for (int j = 0; j < spaceCount / (wordCount - 1); j++) {
                sb.append(" ");
            }
        }
        
        sb.append(words.get(wordCount - 1));
        for (int i = wordCount > 1 ? spaceCount % (wordCount - 1) : spaceCount; i > 0; i--) {
            sb.append(" ");
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        LC1592RearrangeSpce obj = new LC1592RearrangeSpce();
        System.out.println(obj.reorderSpaces("  this   is  a sentence "));
    }

}
