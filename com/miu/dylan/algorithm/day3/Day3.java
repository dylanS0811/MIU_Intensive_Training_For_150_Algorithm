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
        // System.out.println(day3.isDivisible(new int[] {3, 4, 3, 6, 36}, 3));
        // System.out.println(day3.isNUnique(new int[] {7,3,3,2,4}, 11));
        // System.out.println(day3.isSquare(6));
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
     * Time Complexity: the time complexity is O(n), where n is the length of the array, since we need to traverse each element in the array.
     * <p>
     * Space Complexity: the space complexity is O(1), as we are using a constant amount of extra space.
     */
    private int isDivisible(int [] a, int divisor) {

        // Check if the array is null or its length is 0, if so return 1.
        if (a == null || a.length == 0) {
            return 1;
        }

        for (int element : a) {
            if (element % divisor != 0) {
                return 0;
            }
        }

        return 1;
    }

    /**
     * num 17
     * <p>
     * Time Complexity: the time complexity is O(n^2), where n is the length of the array. We need to iterate through each pair of elements.
     * <p>
     * Space Complexity: the space complexity is O(1), only constant extra space is used.
     */
    private int isNUnique(int[] a, int n) {

        if (a == null || a.length < 2) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {

                    if(a[i] + a[j] == n) {
                        count++;
                    }

                    if (count > 1) {
                        return 0;
                    }
            }
        }
        return count == 1 ? 1 : 0;
    }

    /**
     * num 18
     * <p>
     * Time Complexity: the time complexity is O(√n), because we iterate from 0 to √n.
     * <p>
     * Space Complexity: the space complexity is O(1),only constant extra space is used.
     */
    private int isSquare(int n) {

        // Negative numbers cannot be perfect squares.
        if (n < 0) {
            return 0;
        }

        int x = 0;

        while (x * x < n) {
            x++;
        }

        return x * x == n ? 1 : 0;
    }
}
