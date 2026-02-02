import HashMap.*;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        // 1) add + get
        map.add("a", 1);
        map.add("b", 2);
        System.out.println(map.get("a")); 
        System.out.println(map.get("b")); 
        System.out.println(map.get("c")); 

        // 2) update existing key
        map.add("a", 99);
        System.out.println(map.get("a")); 

        // 3) remove
        System.out.println(map.remove("b")); 
        System.out.println(map.get("b"));    
        System.out.println(map.remove("b"));

        // 4) trigger grow
        for (int i = 0; i < 100; i++) {
            map.add("k" + i, i);
        }

        // after grow we should find eveything again
        System.out.println(map.get("k0"));   
        System.out.println(map.get("k50"));  
        System.out.println(map.get("k99"));

        
    }

}
