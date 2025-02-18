package collections.listOperations;

import java.util.*;

class ArraysOperations extends Thread {
    public void run() {
        List<Integer> list = new ArrayList<>();
        //System.out.println("Is list empty? "+list.isEmpty());
        list.add(35);
        list.add(23);
        list.add(67);
        list.add(82);
        list.add(56);
        list.add(49);
        list.add(49);
        list.add(49);
        //System.out.println("Is list empty? "+list.isEmpty());
        //  System.out.println("The given list is:"+list);
        System.out.println("Number of elements in the list: " + list.size());
        //Adding one element
        list.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :" + list);
        System.out.println("The number of elements in the list: " + list.size());
//Checking for an element
        System.out.println("Is 566 available in the list:" + list.contains(566));
        System.out.println("The given list before removing elements is :" + list);
    }
}

class LinkedListOperations extends Thread {
    public void run() {
        List<Integer> linkedList = new LinkedList<>();
        //System.out.println("Is linkedList empty? "+linkedList.isEmpty());
        linkedList.add(35);
        linkedList.add(23);
        linkedList.add(67);
        linkedList.add(82);
        linkedList.add(56);
        linkedList.add(49);
        linkedList.add(49);
        linkedList.add(49);
        //System.out.println("Is linkedList empty? "+linkedList.isEmpty());
        //  System.out.println("The given list is:"+linkedList);
        System.out.println("Number of elements in the list: " + linkedList.size());
        //Adding one element
        linkedList.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :" + linkedList);
        System.out.println("The number of elements in the list: " + linkedList.size());
//Checking for an element
        System.out.println("Is 566 available in the list:" + linkedList.contains(566));
        System.out.println("The given list before removing elements is :" + linkedList);
    }
}

class VectorOperations extends Thread {
    public void run() {
        List<Integer> vectorList = new Vector<>();
        //System.out.println("Is vectorList empty? "+vectorList.isEmpty());
        vectorList.add(35);
        vectorList.add(23);
        vectorList.add(67);
        vectorList.add(82);
        vectorList.add(56);
        vectorList.add(49);
        vectorList.add(49);
        vectorList.add(49);
        //System.out.println("Is vectorList empty? "+vectorList.isEmpty());
        //  System.out.println("The given list is:"+vectorList);
        System.out.println("Number of elements in the list: " + vectorList.size());
        //Adding one element
        vectorList.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :" + vectorList);
        System.out.println("The number of elements in the list: " + vectorList.size());
//Checking for an element
        System.out.println("Is 566 available in the list:" + vectorList.contains(566));
        System.out.println("The given list before removing elements is :" + vectorList);
    }
}

class StackOperations extends Thread {
    public void run() {
        List<Integer> stack = new Stack<>();
        //System.out.println("Is stack empty? "+stack.isEmpty());
        stack.add(35);
        stack.add(23);
        stack.add(67);
        stack.add(82);
        stack.add(56);
        stack.add(49);
        stack.add(49);
        stack.add(49);
        //System.out.println("Is stack empty? "+stack.isEmpty());
        //  System.out.println("The given list is:"+stack);
        System.out.println("Number of elements in the list: " + stack.size());
        //Adding one element
        stack.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :" + stack);
        System.out.println("The number of elements in the list: " + stack.size());
//Checking for an element
        System.out.println("Is 566 available in the list:" + stack.contains(566));
        System.out.println("The given list before removing elements is :" + stack);
    }
}

public class ListSample {
    public static void main(String[] args) {
        ArraysOperations arraysOperations = new ArraysOperations();
        arraysOperations.start();

        LinkedListOperations linkedListOperations = new LinkedListOperations();
        linkedListOperations.start();

        VectorOperations vectorOperations = new VectorOperations();
        vectorOperations.start();

        StackOperations stackOperations = new StackOperations();
        stackOperations.start();
    }
}