package collections.mapOperations;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapOperations {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        Hashtable<Integer, String> hashTable = new Hashtable<>();
        hashTable.put(1, "one");
        hashTable.put(2, "two");
        hashTable.put(3, "three");
        System.out.println("Initial HashMap hm1 are : " + hashTable);
        hashTable.put(2, "For");
        System.out.println("Updated Map " + hashTable);
        hashTable.remove(1);
        System.out.println("Mappings after removal are : " + hashTable);
        System.out.println("Map traversal:");

        for (Map.Entry<Integer, String> e : hashTable.entrySet())
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
    }
}
