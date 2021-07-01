package leetcode.biweekly55;

public class RemoveSubSting {

    public String removeOccurrences(String s, String part) {
        while (s.length() > 0 && s.indexOf(part) != -1) {
            s = s.substring(0, s.indexOf(part)) + s.substring(s.indexOf(part) + part.length());
        }
        return s;
    }
    
    public String removeOccurrencesAlt(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part , "");
        }
        return s;
    }


    public static void main(String[] args) {
        RemoveSubSting obj = new RemoveSubSting();
        String s = "axxxxyyyyb", part = "xy";
        System.out.println(obj.removeOccurrences(s, part));

    }

}
