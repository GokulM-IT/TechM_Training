package Task_01;

import java.util.Arrays;

//Demonstrate with an example with the difference between equals() vs deepEquals() method?

public class EqualsVsDeepEqualsComparison {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = nums1;

        System.out.println("Using equals():");
        System.out.println(nums1.equals(nums2));

        System.out.println("Using deepEquals():");
        System.out.println(Arrays.equals(nums1, nums2));

        System.out.println("nums1 == nums3: " + (nums1 == nums3));
    }
}
