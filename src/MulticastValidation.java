import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MulticastValidation {

    public Set<String> findMulticastIssueRead(String fileName) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            Set<String> file1Set = new HashSet<>();

            String str;

            while ((str = in.readLine()) != null) {
                String[] splitStr = str.split("MULTICAST_PIM");

                file1Set.add(splitStr[0]);

            }
            return file1Set;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        Set<String> finalDeviceSet = new HashSet<>();
        MulticastValidation obj = new MulticastValidation();
        String file1 = "/Users/enataraj/Downloads/file1.txt";
        Set<String> mutliSet_915 = obj.findMulticastIssueRead(file1);
        String file2 = "/Users/enataraj/Downloads/file2.txt";
        Set<String> mutliSet_715 = obj.findMulticastIssueRead(file2);
        String file3 = "/Users/enataraj/Downloads/deviceinfo.txt";
        Set<String> deviceinfoSet = obj.findMulticastIssueRead(file3);
        String file4 = "/Users/enataraj/Downloads/Duplicate.txt";
        Set<String> duplicateSet = obj.findMulticastIssueRead(file4);

        System.out.println(mutliSet_915.size());
        System.out.println(mutliSet_715.size());
        System.out.println(deviceinfoSet.size());

        System.out.println("Missing in 915");
        for (String str : deviceinfoSet) {
            if (!mutliSet_915.contains(str)) {
                finalDeviceSet.add(str);
                System.out.println(str);
            }
        }

        System.out.println("Missing in 715");
        for (String str : deviceinfoSet) {

            if (!mutliSet_715.contains(str)) {
                System.out.println(str);
                finalDeviceSet.add(str);
            }
        }
        
        

        finalDeviceSet.addAll(duplicateSet);
        System.out.println(finalDeviceSet.size());
        System.out.println("Final Device clear");
        for (String str : finalDeviceSet) {
            System.out.println(str);
        }

    }

}
