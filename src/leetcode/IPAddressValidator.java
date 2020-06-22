package leetcode;

public class IPAddressValidator {

    public String validIPAddressRegEx(String IP) {

        java.util.regex.Pattern ipv4patteren = java.util.regex.Pattern.compile(
                "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])");
        java.util.regex.Matcher ipv4matcher = ipv4patteren.matcher(IP);
        java.util.regex.Pattern ipv6patteren = java.util.regex.Pattern
                .compile("((([0-9a-fA-F]){1,4})\\:){7}(([0-9a-fA-F]){1,4})");
        java.util.regex.Matcher ipv6matcher = ipv6patteren.matcher(IP);

        if (IP == null || IP.length() == 0) {
            return "Neither";

        }

        if (ipv4matcher.matches()) {
            return "IPv4";

        } else if (ipv6matcher.matches()) {
            return "IPv6";
        }

        return "Neither";

    }

    public String validIPAddress(String IP) {

        if (IP == null || IP.length() == 0) {
            return "Neither";
        }

        if (IP.contains(".")) {
            String[] octs = IP.split("\\.");
            if (IP.charAt(IP.length() - 1) == '.') {
                return "Neither";
            }

            if (octs.length == 4) {
                
                for (int i = 0; i < octs.length; i++) {
                    if (octs[i].isEmpty() || (octs[i].length()!=1 && octs[i].charAt(0) == '0')|| octs[i].charAt(0) == '-') {
                        return "Neither";
                    }
                    if (octs[i].isEmpty() || octs[i].length() > 3) {
                        return "Neither";
                    }
                    try {
                        int num = Integer.parseInt(octs[i]);
                        if (num < 0 || num > 255) {
                            return "Neither";
                        }
                    } catch (Exception e) {
                        return "Neither";
                    }
                }
                return "IPv4";
            }
            return "Neither";

        } else if (IP.contains(":")) {
            String[] octs = IP.split("\\:");
            if (octs.length != 8 || IP.charAt(IP.length() - 1) == ':') {
                return "Neither";
            }

            for (int i = 0; i < octs.length; i++) {
                if (octs[i].isEmpty() || octs[i].length() > 4  ) {
                    return "Neither";
                }
                for (int j = 0; j < octs[i].length(); j++) {
                    if (octs[i].isEmpty() || octs[i].length() > 4  ) {
                        return "Neither";
                    }
                    char c = octs[i].charAt(j);
                    if (!(Character.isDigit(c)
                            || (Character.toLowerCase(c) >= 'a' && Character.toLowerCase(c) <= 'f'))) {
                        return "Neither";
                    }
                }
            }

            return "IPv6";
        }
        return "Neither";
    }

    public static void main(String[] args) {
        IPAddressValidator validator = new IPAddressValidator();
//        String IP = "2001:db8:85a3:0::8a2E:0370:7334";
//        String IP = "2001:db8:85a3:0:0:8a2E:0370:7334";
        String IP = "192.0.0.1";
        System.out.println(validator.validIPAddress(IP));

    }
}
