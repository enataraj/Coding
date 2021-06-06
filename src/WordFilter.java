import java.util.LinkedHashMap;
import java.util.Map;

public class WordFilter {

    Map<String, Integer> wordsMap = new LinkedHashMap<>();
    public WordFilter(String[] words) {
        for (int idx = 0; idx < words.length; idx++) {
            for (int i = 0; i < words[idx].length(); i++) {
                for (int j = 0; j < words[idx].length(); j++) {
                    String key = words[idx].substring(0, i) + "#" + words[idx].substring(words[idx].length() - j);
                    wordsMap.put(key, idx);
                }

            }
        }
        // System.out.println(wordsMap);
    }

    public int f(String prefix, String suffix) {
        String key = prefix + "#" + suffix;
        Integer idx = wordsMap.get(key);
        if (idx == null) {
            return -1;
        }
        return idx;

    }

    public static void main(String[] args) {
        String[] words = { "apple" };
        WordFilter obj = new WordFilter(words);
        System.out.println(obj.f("a", "e"));
    }

}
