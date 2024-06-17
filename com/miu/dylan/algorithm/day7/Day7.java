package com.miu.dylan.algorithm.day7;

import java.util.Arrays;

/**
 * day7 with 5 functions
 */
public class Day7 {

    public static void main(String[] args) {

        System.out.println(isOddHeavy(new int[]{-2, -4, -6, -8, -11})); // 0

        System.out.println(getExponent(27, 3)); // 3

        System.out.println(is121Array(new int[]{1, 2, 1})); // 1

        System.out.println(Arrays.toString(filterArray(new int[]{9, -9}, 0))); // {}
        System.out.println(Arrays.toString(filterArray(new int[]{9, -9}, 1))); // {9}
        System.out.println(Arrays.toString(filterArray(new int[]{9, -9}, 2))); // {-9}
        System.out.println(Arrays.toString(filterArray(new int[]{9, -9}, 3))); // {9, -9}
        System.out.println(Arrays.toString(filterArray(new int[]{9, -9}, 4))); // null
        System.out.println(Arrays.toString(filterArray(new int[]{0, 9, 12, 18, -6}, 11))); // {0, 9, 18}

        System.out.println(largestAdjacentSum(new int[]{1, 2, 3, 4})); // 7
        System.out.println(largestAdjacentSum(new int[]{18, -12, 9, -10})); // 6
        System.out.println(largestAdjacentSum(new int[]{1, 1, 1, 1, 1, 1, 1, 1})); // 2
        System.out.println(largestAdjacentSum(new int[]{1, 1, 1, 1, 1, 2, 1, 1, 1})); // 3
    }

    /**
     * num 38
     * <p>
     * Time Complexity: the time complexity is O(n), where n is the length of the array, we need to traverse the entire array.
     * <p>
     * Space Complexity: the space complexity is O(1), since we only use a fixed amount of extra space to store variables.
     */
    private static int isOddHeavy(int[] a) {

        int minOdd = Integer.MAX_VALUE;
        int maxEven = Integer.MIN_VALUE;
        boolean hasOdd = false;

        for (int num : a) {
            if (num % 2 == 0) {
                if (num > maxEven) {
                    maxEven = num;
                }
            } else {
                hasOdd = true;
                if (num < minOdd) {
                    minOdd = num;
                }
            }
        }

        if (!hasOdd) {
            return 0;
        }

        return minOdd > maxEven ? 1 : 0;
    }

    /**
     * num 39
     * <p>
     * Time Complexity: the time complexity is O(log_p(n)), where n is input value and p is the divisor.
     * Each division operation reduce n by a factor of 1/p.
     * <p>
     * Space Complexity: the space complexity is O(1), because we only use constant space for variables.
     */
    private static int getExponent(int n, int p) {

        if (p <= 1) {
            return -1; // if P is less than or equal 1, directly return -1
        }

        int x = 0;
        while (n % p == 0) { // while n can be divided by p
            n /= p;
            x++;
        }

        return x;
    }

    /**
     * num 40
     * <p>
     * Time Complexity: the time complexity is O(n), where n is the length of the array.
     * <p>
     * Space Complexity: the space complexity is O(1), since we only use constant space for variables.
     */
    private static int is121Array(int[] a) {
        // If the array is null or its length is less than 3, it cannot be a 121 array
        if (a == null || a.length < 3) {
            return 0;
        }

        int n = a.length;
        int start = 0;
        int end = n - 1;

        // [1, 1, 2, 2, 2, 1, 1] n=7 start = 1 end = 5
        // Check if the array starts with one or more 1s
        while (start < n && a[start] == 1) {
            start++;
        }

        // If the array doesn't start with 1, or the entire array is 1s, return 0
        if (start == 0 || start == n) {
            return 0;
        }

        // Check if the array ends with one or more 1s
        while (end >= 0 && a[end] == 1) {
            end--;
        }

        // If the array doesn't end with 1, or the entire array is 1s, return 0
        if (end == n - 1 || end == -1) {
            return 0;
        }

        // If the number of 1s at the beginning and the end are not equal, return 0
        if (start != n - end - 1) {
            return 0;
        }

        // If the middle part is not all 2s, return 0
        for (int i = start; i <= end; i++) {
            if (a[i] != 2) {
                return 0;
            }
        }

        // If all conditions are met, return 1
        return 1;
    }

    /**
     * num 41
     * <p>
     * Time Complexity: the time complexity is O(n), where n is the length of the array.
     * <p>
     * Space Complexity: the space complexity is O(1), since we only use constant space for variables.
     */
    private static int[] filterArray(int[] a, int n) {

        int count = 0;
        int temp = n;

        // Count the number of 1s
        while (temp > 0) {
            if (temp % 2 == 1) {
                count++;
            }

            temp /= 2;
        }

        // If the input array length is less than the number of 1s in the binary representation, return null
        if (count > a.length) {
            return null;
        }

        int[] result = new int[count];
        int index = 0;
        int i = 0;

        while (n > 0) {
            if (n % 2 == 1) {

                // Check if the current index is within the valid range of array a
                if (i >= a.length) {
                    return null;
                }

                result[index++] = a[i];
            }

            n /= 2;
            i++;
        }

        return result;
    }

    /**
     * num 42
     * <p>
     * Time Complexity: the time complexity is O(n), where n is the length of the array.
     * <p>
     * Space Complexity: the space complexity is O(1), since we only use constant space for variables.
     */
    private static int largestAdjacentSum(int[] a) {

        int maxSum = a[0] + a[1];

        for (int i = 0; i < a.length - 1; i++) {
            int currentSum = a[i] + a[i + 1];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

}
