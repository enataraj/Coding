package general.java.example;

import java.util.HashMap;
import java.util.Map;

public class MapExamples {

    public void mapExample() {

        // Get or Default

        Map<Integer, String> hm = new HashMap<>();
        hm.put(2, "Nishanth");
        hm.put(3, "Krish");
        System.out.println(hm.getOrDefault(1, "Elumalai"));
        hm.put(1, "Kani");
        System.out.println(hm.getOrDefault(1, "Elumalai"));

        // Null key is permitted, But Concurrent Hasmap or Tree Map will not Allow null
        // keys

        hm.put(null, "Elumalai");
        System.out.println(hm.get(null));

        hm.put(5, "Elumalai");
        System.out.println(hm.get(5));
        hm.put(null, "Nish");
        System.out.println(hm.get(null));

        // putIfAbsent
        String res = hm.putIfAbsent(10, "10Elumalai");
        System.out.println(res);
        System.out.println(hm);
        res = hm.putIfAbsent(10, "10   Elumalai");

        System.out.println("    "+res);
        System.out.println(hm);
        
        
        
    

    }

    public static void main(String[] args) {

        MapExamples obj = new MapExamples();
        obj.mapExample();

    }

}
