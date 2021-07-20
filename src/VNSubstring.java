import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class VNSubstring {

    public void readFile(String fileName, Set<String> set, int limit) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str;
            while ((str = in.readLine()) != null) {
                if (str.length() == limit) {
                    set.add(str);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getVN() {

        Set<String> vnNames = new TreeSet<>();
        readFile("/Users/enataraj/Downloads/VN.txt", vnNames, 79);
        System.out.println("===============Virt====================");
        for (String str : vnNames) {
            System.out.println(str);
        }

    }

    public void getDomain() {
        Set<String> domains = new TreeSet<>();
        readFile("/Users/enataraj/Downloads/domain.txt", domains, 77);
        System.out.println("===============Connectivity====================");
        for (String str : domains) {
            System.out.println(str);
        }

    }

    public static void main(String[] args) {
        String name = "VN_BUILDING-Global/Gouvernement_de_Monaco/A1_BRUXELLES_FD_GOUVERNEMENT_DE_MONACO";
        String domain = "Global/Gouvernement_de_Monaco/A1_BRUXELLES_FD_GOUVERNEMENT_DE_MONACO";

        // System.out.println(name.substring(0, name.length() - (domain.length() + 1)));

        //String sample = "test";
        // System.out.println(sample.substring(0, (sample.length()-sample.length()-2)));
        VNSubstring obj = new VNSubstring();
        obj.getVN();
        //obj.getDomain();

    }

}
