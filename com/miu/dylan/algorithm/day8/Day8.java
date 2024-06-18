package com.miu.dylan.algorithm.day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * day8 with 5 functions
 */
public class Day8 {
    public static void main(String[] args) {

        System.out.println(checkConcatenatedSum(198, 2)); // 1
        System.out.println(checkConcatenatedSum(198, 3)); // 0
        System.out.println(checkConcatenatedSum(2997, 3)); // 1
        System.out.println(checkConcatenatedSum(2997, 2)); // 0
        System.out.println(checkConcatenatedSum(13332, 4)); // 1
        System.out.println(checkConcatenatedSum(9, 1)); // 1


        System.out.println(isSequencedArray(new int[]{1, 2, 3, 4, 5}, 1, 5)); // 1
        System.out.println(isSequencedArray(new int[]{1, 3, 4, 2, 5}, 1, 5)); // 0
        System.out.println(isSequencedArray(new int[]{-5, -5, -4, -4, -4, -3, -3, -2, -2}, -5, -2)); // 1
        System.out.println(isSequencedArray(new int[]{0, 1, 2, 3, 4, 5}, 1, 5)); // 0
        System.out.println(isSequencedArray(new int[]{1, 2, 3, 4}, 1, 5)); // 0
        System.out.println(isSequencedArray(new int[]{1, 2, 5}, 1, 5)); // 0
        System.out.println(isSequencedArray(new int[]{5, 4, 3, 2, 1}, 1, 5)); // 0


        System.out.println(largestPrimeFactor(10));  // Output 5
        System.out.println(largestPrimeFactor(6936));  // Output 17
        System.out.println(largestPrimeFactor(1));  // Output 0


        System.out.println(Arrays.toString(encodeNumber(2)));  // Output [2]
        System.out.println(Arrays.toString(encodeNumber(6)));  // Output [2, 3]
        System.out.println(Arrays.toString(encodeNumber(14)));  // Output [2, 7]
        System.out.println(Arrays.toString(encodeNumber(24)));  // Output [2, 2, 2, 3]
        System.out.println(Arrays.toString(encodeNumber(1200)));  // Output [2, 2, 2, 2, 3, 5, 5]
        System.out.println(Arrays.toString(encodeNumber(1)));  // Output null
        System.out.println(Arrays.toString(encodeNumber(-18)));  // Output null


        System.out.println(matchPattern(new int[]{1, 1, 1, 1, 1}, 5, new int[]{1}, 1)); // 1
        System.out.println(matchPattern(new int[]{}, 0, new int[]{1}, 1)); // 1
        System.out.println(matchPattern(new int[]{1, 1, 2, 2, 2, 2}, 6, new int[]{1, 2}, 2)); // 1
        System.out.println(matchPattern(new int[]{1, 2, 3}, 3, new int[]{1, 2}, 2)); // 0
        System.out.println(matchPattern(new int[]{1, 2}, 2, new int[]{1, 2, 3}, 3)); // 0
        System.out.println(matchPattern(new int[]{1, 1, 2, 2, 2, 2, 3}, 7, new int[]{1, 3}, 2)); // 0
        System.out.println(matchPattern(new int[]{1, 1, 1}, 3, new int[]{1, 2}, 2)); // 0
        System.out.println(matchPattern(new int[]{1, 1, 1, 1, 2, 2, 3, 3}, 8, new int[]{1, 2}, 2)); // 0
        System.out.println(matchPattern(new int[]{1, 1, 10, 4, 4, 3}, 6, new int[]{1, 4, 3}, 3)); // 0


    }

    /**
     * num 43
     * <p>
     * Time complexity: the time complexity is O(d * catlen), where d is the number of digits in n.
     * <p>
     * Space complexity: the space complexity is O(1), since we only use constant space for variables.
     */
    private static int checkConcatenatedSum(int n, int catlen) {

        int original = n;
        int sum = 0;

        while (n > 0) {
            int currentDigit = n % 10;

            int concatenate = 0;
            int factor = 1;
            for (int i = 0; i < catlen; i++) {
                concatenate += currentDigit * factor;
                factor *= 10;
            }

            sum += concatenate;
            n /= 10;
        }

        return sum == original ? 1 : 0;
    }

    /**
     * num 44
     * <p>
     * Time complexity: the time complexity is O(n), where n is the length of the array.
     * <p>
     * Space complexity: the space complexity is O(n), due to the use of a hash set to store the elements of the array.
     */
    private static int isSequencedArray(int[] a, int m, int n) {

        HashSet<Integer> set = new HashSet<>();

        // Check if the array is in ascending order and if it contains out-of-range numbers
        for (int i = 0; i < a.length; i++) {
            if (a[i] < m || a[i] > n) {
                return 0; // Out of range
            }

            if (i + 1 < a.length && a[i] > a[i + 1]) {
                return 0; // Not in ascending order
            }

            set.add(a[i]);
        }

        // Check if the array contains all integers between m and n
        for (int i = m; i <= n; i++) {
            if (!set.contains(i)) {
                return 0;
            }
        }

        return 1;
    }

    /**
     * num 45
     * <p>
     * Time complexity: the time complexity is O(√n), as we check all factors up to √n in the worst case.
     * <p>
     * Space complexity: the space complexity is O(1), as we only use constant space.
     */
    private static int largestPrimeFactor(int n) {

        if (n <= 1) {
            return 0;
        }

        int maxPrime = -1;

        // Check if 2 is the factor
        while (n % 2 == 0) {
            maxPrime = 2;
            n /= 2;
        }

        // Check for odd factors
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                maxPrime = i;
                n /= i;
            }
        }

        // If n is still greater than 2 at this step, the largest prime factor is n itself.
        if (n > 2) {
            maxPrime = n;
        }

        return maxPrime;
    }

    /**
     * num 46
     * <p>
     * Time complexity: the time complexity is O(√n), as we check all factors up to √n in the worst case.
     * <p>
     * Space complexity: the space complexity is O(log n), as the maximum number of prime factors in the worst case is log n.
     */
    private static int[] encodeNumber(int n) {

        if (n <= 1) {
            return null;
        }

        // Dynamic array to store prime factors
        List<Integer> factors = new ArrayList<>();

        // Check if 2 is a factor
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // Check for odd factors
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // If n is still greater than 2 at this step, the prime factor is the n itself
        if (n > 2) {
            factors.add(n);
        }

        // Convert List to array
        int[] result = new int[factors.size()];
        for (int i = 0; i < factors.size(); i++) {
            result[i] = factors.get(i);
        }

        return result;
    }

    /**
     * num 47
     * <p>
     * Time complexity: the time complexity is O(n), where n is the length of array. We traverse the array once, and each operation is performed in constant time.
     * <p>
     * Space complexity: the space complexity is O(1), as we only use a few additional variables without any extra space.
     */
    private static int matchPattern(int[] a, int len, int[] pattern, int patternLen) {
        // len is the number of elements in the array a, patternLen is the number of elements in the pattern.
        int i = 0; // index into a
        int k = 0; // index into pattern
        int matches = 0; // how many times current pattern character has been matched so far
        for (i = 0; i < len; i++) {
            if (a[i] == pattern[k])
                matches++; // current pattern character was matched
            else if (matches == 0 || k == patternLen - 1)
                return 0; // if pattern[k] was never matched (matches==0) or at end of pattern (k==patternLen-1)
            else { //advance to next pattern character
                // !!You write this code !!
                k++;
                if (a[i] == pattern[k]) {
                    matches = 1; // reset matches because a[i] matches the new pattern character
                } else {
                    return 0; // a[i] does not match the new pattern character
                }
            } // end of else
        } // end of for
        // return 1 if at end of array a (i==len) and also at end of pattern (k==patternLen-1)
        if (i == len && k == patternLen - 1) return 1;
        else return 0;
    }
}
