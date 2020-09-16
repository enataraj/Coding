package leetcode.sep;

public class CompareVersionNumbers {

    public int compareVersion1(String version1, String version2) {
        if (version1 == null && version2 == null) {
            return 0;
        }
        if (version1 == null) {
            return -1;
        }
        if (version2 == null) {
            return 1;
        }
        
        

        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");

        int versionLen = Math.min(version1Array.length, version2Array.length);

        for (int i = 0; i < versionLen; i++) {

            if (Integer.parseInt(version1Array[i]) > Integer.parseInt(version2Array[i])) {
                return 1;
            }
            if (Integer.parseInt(version1Array[i]) < Integer.parseInt(version2Array[i])) {
                return -1;
            }

        }

        if (version1Array.length > version2Array.length) {
            for (int i = versionLen; i < version1Array.length; i++) {
                if (Integer.parseInt(version1Array[i]) != 0) {
                    return 1;
                }

            }
        }

        if (version2Array.length > version1Array.length) {
            for (int i = versionLen ; i < version2Array.length; i++) {
                if (Integer.parseInt(version2Array[i]) != 0) {
                    return -1;
                }

            }
        }

        return 0;
    }
    
    public int compareVersion(String version1, String version2) {
        if (version1 == null && version2 == null) {
            return 0;
        }
        if (version1 == null) {
            return -1;
        }
        if (version2 == null) {
            return 1;
        }

        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");

        int versionLen = Math.min(version1Array.length, version2Array.length);

        for (int i = 0; i < versionLen; i++) {

            if (Integer.parseInt(version1Array[i]) > Integer.parseInt(version2Array[i])) {
                return 1;
            }
            if (Integer.parseInt(version1Array[i]) < Integer.parseInt(version2Array[i])) {
                return -1;
            }

        }

        if (version1Array.length > version2Array.length) {
            for (int i = versionLen; i < version1Array.length; i++) {
                if (Integer.parseInt(version1Array[i]) != 0) {
                    return 1;
                }

            }
        }

        if (version2Array.length > version1Array.length) {
            for (int i = versionLen ; i < version2Array.length; i++) {
                if (Integer.parseInt(version2Array[i]) != 0) {
                    return -1;
                }

            }
        }

        return 0;
    }
    
    
    
    

    public static void main(String[] args) {

        CompareVersionNumbers obj = new CompareVersionNumbers();
        // System.out.println(obj.compareVersion("0.1", "1.1"));
        // System.out.println(obj.compareVersion("1.0.1", "1"));
        // System.out.println(obj.compareVersion("7.5.2.4", "7.5.3"));
        // System.out.println(obj.compareVersion("1.01", "1.001"));
        System.out.println(obj.compareVersion("1.0", "1"));
    }

}
