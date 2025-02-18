package collections.setOperations;

import java.util.*;
import java.util.stream.Collectors;

public class SetOperations {
    public static void operations(HashSet<Integer> hashSet) {
        System.out.println("Hash Set : " + hashSet);
        hashSet.remove(77);
        System.out.println("After removed: " + hashSet);

        Set<Integer> resultSet = hashSet.stream()
                .filter(num -> num % 7 == 0)
                .collect(Collectors.toSet());

        System.out.println("Element divisible by 7: " + resultSet);

    }

    public static void operations(LinkedHashSet<String> linkedHashSet) {
        System.out.println("Linked Hash Set : " + linkedHashSet);
        linkedHashSet.remove("to");
        System.out.println("After removed: " + linkedHashSet);

        Set<String> resultSet = linkedHashSet.stream()
                .filter(str -> str.length() > 5)
                .collect(Collectors.toSet());

        System.out.println("String size greater than 5: " + resultSet);
    }

    public static void operations(TreeSet<Double> treeSet) {
        System.out.println("Tree Hash Set : " + treeSet);
        treeSet.remove(16.9);
        System.out.println("After removed: " + treeSet);

        Set<Double> resultSet = treeSet.stream()
                .filter(num -> num > 20)
                .collect(Collectors.toSet());

        System.out.println("Elements greater than 20: " + resultSet);
    }

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(83);
        hashSet.add(14);
        hashSet.add(21);
        hashSet.add(35);
        hashSet.add(45);
        hashSet.add(39);
        hashSet.add(77);
        hashSet.add(88);
        SetOperations.operations(hashSet);
        System.out.println();

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Hello");
        linkedHashSet.add("Welcome");
        linkedHashSet.add("to");
        linkedHashSet.add("TechM");
        linkedHashSet.add("Training");
        SetOperations.operations(linkedHashSet);
        System.out.println();

        TreeSet<Double> treeSet = new TreeSet<>();
        treeSet.add(29.9);
        treeSet.add(77.9);
        treeSet.add(64.9);
        treeSet.add(10.9);
        treeSet.add(9.9);
        treeSet.add(16.9);
        treeSet.add(37.9);
        treeSet.add(299.9);
        SetOperations.operations(treeSet);
    }
}