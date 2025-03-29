package Task_06;
import java.util.ArrayList;
import java.util.List;

/*
Write a Java program to create a generic method that takes two lists of the same type and merges them into a single list. This method alternates the elements of each list.
*/

public class MergeListsAlternating {
    public static void main(String[] args) {
        List<String> list1 = List.of("apple", "banana", "cherry");
        List<String> list2 = List.of("date", "elderberry", "fig");

        List<String> mergedList = mergeListsAlternating(list1, list2);
        System.out.println("Merged List: " + mergedList);
    }

    public static <T> List<T> mergeListsAlternating(List<T> list1, List<T> list2) {
        List<T> mergedList = new ArrayList<>();
        int maxSize = Math.max(list1.size(), list2.size());

        for (int i = 0; i < maxSize; i++) {
            if (i < list1.size()) {
                mergedList.add(list1.get(i));
            }
            if (i < list2.size()) {
                mergedList.add(list2.get(i));
            }
        }

        return mergedList;
    }
}
