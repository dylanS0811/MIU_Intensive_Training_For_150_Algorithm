package com.miu.dylan.algorithm.day6;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * day6 with 5 functions
 */
public class Day6 {

    public static void main(String[] args) {
        Day6 day6 = new Day6();
        // System.out.println(day6.smallest(4));
        // System.out.println(Arrays.toString(day6.clusterCompression(new int[]{0, 0, 0, 2, 0, 2, 0, 2, 0, 0})));
        // System.out.println((day6.isRailroadTie(new int[]{3, 3, 0, 3, 3, 0, 3, 3, 0, 3, 3})));
        // System.out.println(day6.fullnessQuotient(9));
        // System.out.println(day6.isPacked(new int[] {2, 2, 1, 2, 2}));
        // System.out.println(day6.isPacked(new int[]{2, 2, 1})); // 1
    }

    /**
     * num 33
     * <p>
     * Time Complexity: the time complexity is O(n * m), where n is the number of multiples to check,
     * and m is the time to check if each number contains digit 2.
     * <p>
     * Space Complexity: the space complexity is O(1), as we only use a constant amount of additional space.
     */
    private int smallest(int n) {

        int num = 1; // Start checking from 1

        // Infinite loop until we find the number that meets the conditions
        while (true) {
            boolean valid = true;
            for (int i = 1; i <= n; i++) {
                if (!containsDigitTwo(i * num)) {
                    valid = false;
                    break;
                }
            }

            // If all multiples contain the digit 2, return the current number
            if (valid) {
                return num;
            }

            num++;
        }
    }

    // This helper function checks if a number contains the digit 2
    private boolean containsDigitTwo(int num) {

        while (num > 0) {

            if (num % 10 == 2) {
                return true;
            }

            num /= 10;
        }

        return false;
    }

    /**
     * num 34
     * <p>
     * Time Complexity: the time complexity is O(n),
     * Although there are two for loops, they are executed sequentially, not nested.
     * Therefore, the overall time complexity is the sum of the two, which is O(n) + O(n), simplified to O(2n).
     * However, in Big O notation, constant factors are ignored, so the time complexity remains O(n).
     * <p>
     * Space Complexity: the space complexity is O(n), used to store the resultList and final result array.
     */
    private int[] clusterCompression(int[] a) {

        if (a.length == 0) {
            return new int[]{};
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add(a[0]); // Add the first element to the result list

        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) { // If the current element is different from the previous one.
                resultList.add(a[i]); // Add the current element to the result list
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 1; i < resultList.size(); i++) {
            result[i] = resultList.get(i); // Convert the result list to an array
        }

        return result;
    }

    /**
     * num 35
     * <p>
     * Time Complexity: the time complexity is O(n), as the algorithm traverse the array once.
     * <p>
     * Space Complexity: the space complexity is O(1), the algorithm uses only a constant amount of space for temporary variables.
     */
    private int isRailroadTie(int[] a) {
        // Check if the array is null or empty
        if (a == null || a.length == 0) {
            return 0; // Return 0 if the array is null or its length is 0
        }

        // Traverse each element in the array
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) { // Should check for non-zero elements (positive or negative)

                // Non-zero element, both left and right are non-zero, does not satisfy - return 0
                if ((i > 0 && a[i - 1] != 0) && (i < a.length - 1 && a[i + 1] != 0)) {
                    return 0;
                }

                // Non-zero element, both left and right are zero (also consider if it's the first or last element), does not satisfy - return 0
                if ((i == 0 || a[i - 1] == 0) && (i == a.length - 1 || a[i + 1] == 0)) {
                    return 0;
                }
            } else {
                // Zero element must have two non-zero neighbors, also cannot be at the beginning or end
                if ((i == 0 || a[i - 1] == 0) || (i == a.length - 1 || a[i + 1] == 0)) {
                    return 0; // If the zero element does not have two non-zero neighbors, return 0
                }
            }
        }

        return 1; // If all checks are passed, return 1
    }

    /**
     * num 36
     * <p>
     * Time Complexity: the time complexity is O(log(n)),
     * The fullnessQuotient method calls hasZeroInBase 8 times.
     * The hasZeroInBase method has a complexity of O(log_base(n)).
     * Although the bases differ, the difference does not significantly impact the complexity's order of magnitude,
     * which approximates O(log(n)).
     * Thus, the overall time complexity of the fullnessQuotient method is O(8 * log(n)), simplified to O(log(n)).
     * <p>
     * Space Complexity: the space complexity is O(1), since we only use a constant amount of extra space for the variables.
     */
    private int fullnessQuotient(int n) {

        if (n < 1) {
            return -1;
        }

        int count = 0; // Initialize counter

        // Iterate 2 to 9
        for (int base = 2; base <= 9; base++) {
            if (!hasZeroInBase(n, base)) {
                count++;
            }
        }

        return count;
    }

    // Helper method: check if representations of n in the given base contains a zero
    private boolean hasZeroInBase(int n, int base) {

        while (n > 0) {

            // If the current digit is zero, return true
            if (n % base == 0) {
                return true;
            }

            // Divide n by the current base to move to the next digit
            n /= base;

        }

        // If no zero is found, return false
        return false;

    }

    /**
     * num 37
     * <p>
     * Time Complexity: the time complexity is O(n * m), where n is the length of the array and m is the number of distinct elements in the array.
     * <p>
     * Space Complexity: the space complexity is O(n), because we use a hashMap to store the count of each number.
     */
    private int isPacked(int[] a) {

        // Crete a counter to record the occurrence of each number
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // Traverse the array to fill counter
        for (int num : a) {
            if (num <= 0) {
                return 0; // If there is non-positive number, return 0
            }
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Traverse the array again to check if each number meets the count and continuity requirements
        for (int i = 0; i < a.length; ) {

            int num = a[i];
            int count = countMap.get(num);

            if (count != num) {
                return 0;
            }

            // Check continuity
            for (int j = 0; j < num; j++) {
                if (i + j > a.length || a[i + j] != num) {
                    return 0; // If not continuous, return 0
                }
            }

            // Note: not i++, for moving to next unchecked number
            i += num;
        }

        return 1;
    }
}
