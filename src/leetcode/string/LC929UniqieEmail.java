package leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class LC929UniqieEmail {

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmail = new HashSet<>();
        for (String email : emails) {
            String[] tmpArray = email.split("@");
            String tmp = tmpArray[0].replace(".", "").split("\\+")[0];
            uniqueEmail.add(new String(tmp + "@" + tmpArray[1]));
        }
        return uniqueEmail.size();
    }
    
    
    public int numUniqueEmailsSol(String[] emails) {
        Set<String> normEmails = new HashSet();
        
        for (String email : emails) {
            normEmails.add(normEmail(email));
        }
        
        return normEmails.size();
    }
    
    private String normEmail(String email) {
        int atIndex = email.indexOf("@");
        
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (; i<atIndex; i++) {
            char ch = email.charAt(i);
            
            if (ch == '+') {
                break;
            }
            
            if (ch == '.') {
                continue;
            }
            
            res.append(ch);
        }
        
        return res.append(email.substring(atIndex)).toString();
    }

    public static void main(String[] args) {
        LC929UniqieEmail obj = new LC929UniqieEmail();
        String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com" };
        System.out.println(obj.numUniqueEmails(emails));
    }

}
