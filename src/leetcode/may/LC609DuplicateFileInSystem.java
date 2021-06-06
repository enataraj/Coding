package leetcode.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC609DuplicateFileInSystem {

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> duplicateFileMap = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            String filePath = files[0] + "/";
            for (int i = 1; i < files.length; i++) {
                int firstIdx = files[i].indexOf('(');
                int lastIdx = files[i].lastIndexOf(')');
                String fileName = files[i].substring(0, firstIdx);
                String content = files[i].substring(firstIdx + 1, lastIdx + 1);
                if (duplicateFileMap.containsKey(content)) {
                    List<String> list = duplicateFileMap.get(content);
                    list.add(filePath + fileName);
                    duplicateFileMap.put(content, list);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(filePath + fileName);
                    duplicateFileMap.put(content, list);
                }
            }
        }

        for (List<String> valueList : duplicateFileMap.values()) {
            if (valueList.size() > 1) {
                result.add(valueList);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] paths = { "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)" };

        LC609DuplicateFileInSystem obj = new LC609DuplicateFileInSystem();
        System.out.println(obj.findDuplicate(paths));

        //[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
    }

}
