package leetcode.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1268SearchSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);

        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            List<String> tempList = new ArrayList<>();
            for (int j = 0; j < products.length; j++) {
                if (products[j].startsWith(prefix)) {
                    tempList.add(products[j]);
                    if (tempList.size() == 3) {
                        break;
                    }
                }
            }
            result.add(tempList);
        }
        return result;

    }

}
