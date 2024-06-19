package com.miu.dylan.algorithm.day9;

import java.util.Arrays;

/**
 * day9 with 5 functions
 */
public class Day9 {
    public static void main(String[] args) {

        // Example 1: Input array {1, 2, 3, 4, 5}, n = 2
        int[] a1 = {1, 2, 3, 4, 5};
        int n1 = 2;
        doIntegerBasedRounding(a1, n1);
        System.out.println(Arrays.toString(a1)); // Output: [2, 2, 4, 4, 6]

        // Example 2: Input array {1, 2, 3, 4, 5}, n = 3
        int[] a2 = {1, 2, 3, 4, 5};
        int n2 = 3;
        doIntegerBasedRounding(a2, n2);
        System.out.println(Arrays.toString(a2)); // Output: [0, 3, 3, 3, 6]

        // Example 3: Input array {1, 2, 3, 4, 5}, n = -3
        int[] a3 = {1, 2, 3, 4, 5};
        int n3 = -3;
        doIntegerBasedRounding(a3, n3);
        System.out.println(Arrays.toString(a3)); // Output: [1, 2, 3, 4, 5]

        // Example 4: Input array {-1, -2, -3, -4, -5}, n = 3
        int[] a4 = {-1, -2, -3, -4, -5};
        int n4 = 3;
        doIntegerBasedRounding(a4, n4);
        System.out.println(Arrays.toString(a4)); // Output: [-1, -2, -3, -4, -5]

        // Example 5: Input array {-18, 1, 2, 3, 4, 5}, n = 4
        int[] a5 = {-18, 1, 2, 3, 4, 5};
        int n5 = 4;
        doIntegerBasedRounding(a5, n5);
        System.out.println(Arrays.toString(a5)); // Output: [-18, 0, 4, 4, 4, 4]

        // Example 6: Input array {1, 2, 3, 4, 5}, n = 5
        int[] a6 = {1, 2, 3, 4, 5};
        int n6 = 5;
        doIntegerBasedRounding(a6, n6);
        System.out.println(Arrays.toString(a6)); // Output: [0, 0, 5, 5, 5]

        // Example 7: Input array {1, 2, 3, 4, 5}, n = 100
        int[] a7 = {1, 2, 3, 4, 5};
        int n7 = 100;
        doIntegerBasedRounding(a7, n7);
        System.out.println(Arrays.toString(a7)); // Output: [0, 0, 0, 0, 0]


        // Example 1
        System.out.println(isCubePowerful(153)); // Output: 1
        // Example 2
        System.out.println(isCubePowerful(370)); // Output: 1
        // Example 3
        System.out.println(isCubePowerful(371)); // Output: 1
        // Example 4
        System.out.println(isCubePowerful(407)); // Output: 1
        // Example 5
        System.out.println(isCubePowerful(87)); // Output: 0
        // Example 6
        System.out.println(isCubePowerful(0)); // Output: 0
        // Example 7
        System.out.println(isCubePowerful(-81)); // Output: 0


        // Example 1
        int[] decodeArray_a1 = {0, -3, 0, -4, 0};
        System.out.println(decodeArray(decodeArray_a1)); // Output: 3344
        // Example 2
        int[] decodeArray_a2 = {-1, 5, 8, 17, 15};
        System.out.println(decodeArray(decodeArray_a2)); // Output: -6392
        // Example 3
        int[] decodeArray_a3 = {1, 5, 8, 17, 15};
        System.out.println(decodeArray(decodeArray_a3)); // Output: 4392
        // Example 4
        int[] decodeArray_a4 = {111, 115, 118, 127, 125};
        System.out.println(decodeArray(decodeArray_a4)); // Output: 4392
        // Example 5
        int[] decodeArray_a5 = {1, 1};
        System.out.println(decodeArray(decodeArray_a5)); // Output: 0


        // Example 1
        int[] isZeroPlentiful_a1 = {0, 0, 0, 0};
        System.out.println(isZeroPlentiful(isZeroPlentiful_a1)); // Output: 1
        // Example 2
        int[] isZeroPlentiful_a2 = {1, 2, 0, 0, 0, 0, 2, -18, 0, 0, 0, 0, 12};
        System.out.println(isZeroPlentiful(isZeroPlentiful_a2)); // Output: 2
        // Example 3
        int[] isZeroPlentiful_a3 = {0, 0, 0, 0, 1, 0, 0, 0, 0, 8, 0, 0, 0, 0};
        System.out.println(isZeroPlentiful(isZeroPlentiful_a3)); // Output: 3
        // Example 4
        int[] isZeroPlentiful_a4 = {1, 2, 3, 4};
        System.out.println(isZeroPlentiful(isZeroPlentiful_a4)); // Output: 0
        // Example 5
        int[] isZeroPlentiful_a5 = {1, 0, 0, 0, 2, 0, 0, 0, 0};
        System.out.println(isZeroPlentiful(isZeroPlentiful_a5)); // Output: 0
        // Example 6
        int[] isZeroPlentiful_a6 = {0};
        System.out.println(isZeroPlentiful(isZeroPlentiful_a6)); // Output: 0
        // Example 7
        int[] isZeroPlentiful_a7 = {};
        System.out.println(isZeroPlentiful(isZeroPlentiful_a7)); // Output: 0

        int[] testCases = {7, 36, 984, 7404};
        for (int n : testCases) {
            System.out.println(isDigitIncreasing(n)); // 分别输出：1, 1, 1, 1
        }


    }

    /**
     * num 48
     * <p>
     * Time Complexity: the time complexity is O(), where n is the length of array since we need to iterate through each element.
     * <p>
     * Space Complexity: the space complexity is O(1), as we only use a constant amount of extra space
     */
    private static void doIntegerBasedRounding(int[] a, int n) {

        // If n is less than or equal to 0, do nothing
        if (n <= 0) return;

        for (int i = 0; i < a.length; i++) {
            // Only round positive integers
            if (a[i] > 0) {

                // Calculate the nearest multiple of n that is less than or equal to the current number
                int lower = (a[i] / n) * n;
                // Calculate the nearest multiple of n that is greater than the current number
                int upper = lower + n;

                // Choose the closer multiple, if equidistant choose the larger one
                if (upper - a[i] <= a[i] - lower) {
                    a[i] = upper;
                } else {
                    a[i] = lower;
                }
            }
        }
    }

    /**
     * num 49
     * <p>
     * Time Complexity: the time complexity is O(d), where d is the number of digits in the number since we need to iterate through each digit.
     * <p>
     * Space Complexity: the space complexity is O(1), as we only use a constant amount of extra space.
     */
    private static int isCubePowerful(int n) {

        if (n <= 0) return 0;

        int cubeSum = 0;
        int original = n;

        while (n > 0) {
            int digit = n % 10;
            n /= 10;

            cubeSum += (int) Math.pow(digit, 3);
        }

        return cubeSum == original ? 1 : 0;
    }

    /**
     * num 50
     * <p>
     * Time Complexity: the time complexity is O(n), where n is the length of the array.
     * <p>
     * Space Complexity: the space complexity is O(1), since no additional space is used that grows with the size of the input.
     */
    private static int decodeArray(int[] a) {

        int factor = 1;
        int result = 0;

        for (int i = a.length - 2; i >= 0; i--) {
            result += Math.abs(a[i] - a[i + 1]) * factor;
            factor *= 10;
        }

        return a[0] >= 0 ? result : -result;
    }

    /**
     * num 51
     * <p>
     * Time Complexity: the time complexity is O(n), where n is the length of the array.
     * <p>
     * Space Complexity: the space complexity is O(1), since no additional space is used that grows with the size of the input.
     */
    private static int isZeroPlentiful(int[] a) {

        if (a == null || a.length < 4) {
            return 0;
        }

        // Count of zero sequences
        int zeroSequenceCount = 0;

        for (int i = 0; i < a.length; ) {

            // Length of the current zero sequence
            int zeroCount = 0;

            if (a[i] == 0) {

                // Count the number of consecutive zeros
                while (i < a.length && a[i] == 0) {
                    zeroCount++;
                    i++;
                }

                // If the zero sequence length is less than 4, return 0
                if (zeroCount < 4) {
                    return 0;
                }

                zeroSequenceCount++;
            } else {
                i++; // Move to the next element
            }

        }

        return zeroSequenceCount;
    }

    /**
     * num 52
     * <p>
     * Time Complexity: the time complexity is O(1), because the algorithm iterates through a fixed number of digits(from 1 to 9) regardless of the input size.
     * <p>
     * Space Complexity: the space complexity is O(1), since the algorithm use a fixed amount of additional memory to store variables.
     */
    private static int isDigitIncreasing(int n) {

        // iterate through all digit from 1 to 9
        for (int i = 1; i <= 9; i++) {
            int sum = 0;
            int term = 0;

            // Construct the digit sequence and calculate its sum
            while (sum < n) {
                term = term * 10 + i;
                sum += term;
            }

            if (sum == n) {
                return 1;
            }
        }

        return 0;
    }
}
