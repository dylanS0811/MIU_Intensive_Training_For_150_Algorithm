/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */

package com.miu.dylan.algorithm.day5;

import java.util.HashSet;
import java.util.Set;

/**
 * day5 with 5 functions
 */
public class Day5 {
    public static void main(String[] args) {
        Day5 day5 = new Day5();
        // System.out.println(day5.isVanilla(new int[]{-9}));
        // System.out.println(day5.isTrivalent(new int[]{2147483647, -1, -1, -2147483648}));
        // System.out.println(day5.countRepresentations(12));
        // System.out.println(day5.countRepresentationsDP(12));
        // System.out.println(day5.isSequentiallyBounded(new int[] {2, 5, 5, 5, 5}));
        // System.out.println(day5.isMinMaxDisjoint(new int[]{5, 4, 1, 3, 2})); // Should return 1
        // System.out.println(day5.isMinMaxDisjoint(new int[]{18, -1, 3, 4, 0})); // Should return 0
        // System.out.println(day5.isMinMaxDisjoint(new int[]{9, 0, 5, 9})); // Should return 0
    }

    /**
     * num 27
     * <p>
     * Time Complexity: the time complexity is O(n * d), where n is the length of the array and d is the number of digits in the number.
     * <p>
     * Space Complexity: the space complexity is O(1), using only constant extra space.
     */
    private int isVanilla(int[] a) {

        if (a.length == 0) {
            return 1;
        }

        int firstDigit = Math.abs(a[0] % 10);

        for (int num : a) {
            num = Math.abs(num);
            while (num > 0) {
                int eachNum = num % 10;
                if (eachNum != firstDigit) {
                    return 0;
                }
                num /= 10;
            }

        }

        return 1;
    }

    /**
     * num 28
     * <p>
     * Time Complexity: the time complexity is O(n), where n is the length of array, as we need to traverse entire array.
     * <p>
     * Space Complexity: the space complexity is O(1), as the set will contain at most 3 different values.
     */
    private int isTrivalent(int[] a) {

        if (a.length == 0) {
            return 0;
        }

        Set<Integer> uniqueValues = new HashSet<>();

        for (int num : a) {
            uniqueValues.add(num);

            if (uniqueValues.size() > 3) {
                return 0;
            }
        }

        return uniqueValues.size() == 3 ? 1 : 0;
    }

    /**
     * num 30
     * <p>
     * Time Complexity: the time complexity is O(n^4), because there are four nested loops, each loop's upper bound is the size of numRupees.
     * <p>
     * Space Complexity: the space complexity is O(1), because extra space used is constant.
     */
    private int countRepresentations(int numRupees) {

        int count = 0;

        // Loop for 20 rupee notes
        for (int rupee20 = 0; rupee20 <= numRupees / 20; rupee20++) {

            // Loop for 10 rupee notes
            for (int rupee10 = 0; rupee10 <= (numRupees - 20 * rupee20) / 10; rupee10++) {

                // Loop for 5 rupee notes
                for (int rupee5 = 0; rupee5 <= (numRupees - 20 * rupee20 - 10 * rupee10) / 5; rupee5++) {

                    // Loop for 2 rupee notes
                    for (int rupee2 = 0; rupee2 <= (numRupees - 20 * rupee20 - 10 * rupee10 - 5 * rupee5) / 2; rupee2++) {

                        // Remaining 1 rupee notes
                        int rupee1 = numRupees - 20 * rupee20 - 10 * rupee10 - 5 * rupee5 - 2 * rupee2;

                        if (rupee1 >= 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * num 30 -》 Dynamic Programming
     * <p>
     * Time Complexity: the time complexity is O(n * k)
     * numRupees is the target amount, and k is the number of different denominations.
     * In this problem, k = 5 (i.e., 1, 2, 5, 10, 20 rupees).
     * We need to iterate over each denomination and update the dp array for all values from the denomination to the target amount.
     * Therefore, the time complexity is the target amount multiplied by the number of denominations.
     * <p>
     * Space Complexity: the space complexity is O(n), because we use an array dp of size numRupees + 1 to store the number of ways to make each amount.
     * The size of the array depends on the target amount numRupees, so the space complexity is O(numRupees).
     */
    private int countRepresentationsDP(int numRupees) {

        int[] dp = new int[numRupees + 1];
        dp[0] = 1;

        int[] notes = new int[]{1, 2, 5, 10, 20};

        for (int note : notes) {
            for (int i = note; i <= numRupees; i++) {
                dp[i] += dp[i - note];
            }
        }

        return dp[numRupees];

    }


    /**
     * num 31
     * <p>
     * Time Complexity: the time complexity is O(n), since we traverse the array twice.
     * <p>
     * Space Complexity: the space complexity is O(1), as we only use a constant amount of extra space.
     */
    private int isSequentiallyBounded(int[] a) {

        // Check array is in ascending order
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return 0;
            }
        }

        int i = 0;
        while (i < a.length) {

            int count = 1;
            int currentValue = a[i];

            // Check if the array contain negative number
            if (currentValue < 0) {
                return 0;
            }

            // Count the occurrences of the current value
            while (i + 1 < a.length && a[i + 1] == currentValue) {
                count++;
                i++;
            }

            // Check if currentValue grater than count, i.e. count >= currentValue
            if (count >= currentValue) {
                return 0;
            }

            i++;
        }

        return 1;
    }


    /**
     * num 32
     * <p>
     * Time Complexity: the time complexity is O(n), as we need to traverse the array once to find the minimum and maximum info.
     * <p>
     * Space Complexity: the space complexity is O(1), as we only use a fixed amount of extra space to store minimum and maximum values, their count and indices.
     */
    private int isMinMaxDisjoint(int[] a) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minCount = 0;
        int maxCount = 0;
        int minIndex = -1;
        int maxIndex = -1;

        // Find the minimum and maximum values, their counts, and positions
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                minCount = 1;
                minIndex = i;
            } else if (a[i] == min) {
                minCount++;
            }

            if (a[i] > max) {
                max = a[i];
                maxCount = 1;
                maxIndex = i;
            } else if (a[i] == max) {
                maxCount++;
            }
        }

        // Check the conditions
        if (min == max || Math.abs(maxIndex - minIndex) == 1 || minCount != 1 || maxCount != 1) {
            return 0;
        }

        return 1;
    }
}
