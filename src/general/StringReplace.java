package general;

public class StringReplace {

    public String defangIPaddr(String address) {

        return address.replace(".", "[.]");

    }

    public String defangIPaddrWithoutAPI(String address) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) != '.') {
                sb.append(address.charAt(i));
            } else {
                sb.append("[.]");
            }

        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String address = "10.1.1.1";
//        address=new StringReplace().defangIPaddr(address);
        address = new StringReplace().defangIPaddrWithoutAPI(address);
        System.out.println(address);
    }

}
