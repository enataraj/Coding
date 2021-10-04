package leetcode.oct2021;

public class LC482LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {
        StringBuffer result = new StringBuffer();
        int len = 0;
        for (char ch : s.toCharArray()) {
            if (ch != '-') {
                result.append(Character.toUpperCase(ch));
                len++;
            }

        }

        int firstPart = len % k;
        StringBuffer finalResult = new StringBuffer();

        for (int i = 0; i < firstPart; i++) {
            finalResult.append(result.charAt(i));
        }
        if (firstPart != 0) {
            finalResult.append('-');
        }

        int cnt = 0;
        for (int i = firstPart; i < result.length(); i++) {
            cnt++;
            finalResult.append(result.charAt(i));
            if (cnt % k == 0 && i != result.length() - 1) {
                finalResult.append('-');
            }

        }

        if (finalResult.length()>0 && finalResult.charAt(finalResult.length() - 1) == '-') {
            finalResult.deleteCharAt(finalResult.length() - 1);
        }

        return finalResult.toString();

    }

    public static void main(String[] args) {
        LC482LicenseKeyFormatting obj = new LC482LicenseKeyFormatting();
        String s = "2-5g-3-J";
        int k = 2;
        System.out.println(obj.licenseKeyFormatting(s, k));

    }

}
