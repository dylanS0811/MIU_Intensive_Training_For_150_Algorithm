package com.miu.dylan.algorithm.day3;

/**
 * day3 with 5 functions
 */
public class Day3 {
    public static void main(String[] args) {
        Day3 day3 = new Day3();
        // System.out.println(day3.isCentered15(new int[]{3, 2, 10, 4, 1, 6, 9})); // 1
        // System.out.println(day3.isCentered15(new int[]{2, 10, 4, 1, 6, 9})); // 0
        // System.out.println(day3.isCentered15(new int[]{3, 2, 10, 4, 1, 6})); // 0
        // System.out.println(day3.isCentered15(new int[]{1, 1, 8, 3, 1, 1})); // 1
        // System.out.println(day3.isCentered15(new int[]{9, 15, 6})); // 1
        // System.out.println(day3.isCentered15(new int[]{1, 1, 2, 2, 1, 1})); // 0
        // System.out.println(day3.isCentered15(new int[]{1, 1, 15, -1, -1})); // 1
        // System.out.println(day3.henry(1, 3)); // 502
    }

    /**
     * num 14
     * <p>
     * Time Complexity: the time complexity is O(n^2), because of the nested loops iterating over all possible subsequence.
     * However, we can significantly reduce the number of inner loop to improve efficiency.
     * <p>
     * Space Complexity: the space complexity is O(1), as only a constant amount of extra space is used for variables.
     */
    private int isCentered15(int[] a) {

        int length = a.length;

        // Step 1: Iterator over each possible starting position of subsequence
        for (int start = 0; start < length; start++) {
            int sum = 0;
            // Step 2: Calculate the sum of the subsequence starting at 'start'
            for (int end = start; end < length; end++) {
                sum += a[end];

                // early exit if sum exceeds 15.
                if (sum > 15) {
                    break;
                }

                int right = length - end - 1; // Calculate the number of elements after the subsequence

                // Step 3: Check if the sum of the subsequence is 15 and if it is centered
                if (sum == 15 && start == right) {
                    return 1;
                }
            }
        }

        return 0;
    }

    /**
     * num 15
     * <p>
     * Time Complexity: the time complexity is O(n^2),
     * The time complexity for determining if a number is a perfect number is O(n/2),
     * and finding the ith and jth perfect numbers has a time complexity of O(n^2).
     * <p>
     * Space Complexity: the space complexity is O(1), as we only use a fixed amount of extra space for the variables.
     */
    // Main function: Return the sum of the i-th and j-th perfect numbers
    private int henry(int i, int j) {
        int perfectCount = 0;
        int currentNumber = 2;
        int firstPerfect = 0;
        int secondPerfect = 0;
        int maxIndex = (i > j) ? i : j;

        while (perfectCount < maxIndex) {
            if (isPerfectNumber(currentNumber)) {
                perfectCount++;
                if (perfectCount == i) {
                    firstPerfect = currentNumber;
                }
                if (perfectCount == j) {
                    secondPerfect = currentNumber;
                }
            }
            currentNumber++;
        }

        return firstPerfect + secondPerfect;
    }

    // Helper function: Determine if a number is a perfect number
    private static boolean isPerfectNumber(int num) {
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i && num / i != num) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }

    /**
     * num 16
     * <p>
     * Time Complexity: the time complexity is
     * <p>
     * Space Complexity: the space complexity is O(1)
     */

    /**
     * num 17
     * <p>
     * Time Complexity: the time complexity is O(n), where n
     * <p>
     * Space Complexity: the space complexity is O(1)
     */

    /**
     * num 18
     * <p>
     * Time Complexity: the time complexity is O(n), where n
     * <p>
     * Space Complexity: the space complexity is O(1)
     */


}
