package com.miu.dylan.algorithm.day4;

/**
 * day4 with 8 functions
 */
public class Day4 {

    public static void main(String[] args) {

        Day4 day4 = new Day4();
        // System.out.println(day4.isLegalNumber(new int[] {3, 2, 1}, 4));
        //  2 * 1 + 1 * 3 + 1 * 9 = 14
        // System.out.println(day4.convertToBase10(new int[] {1, 1, 2}, 3));
        // System.out.println(day4.arrayHasNoZeroes(new int[]{}));
        // System.out.println(day4.computeDepth(42));
        // System.out.println(day4.isStacked(7));
    }

    /**
     * num 19
     * <p>
     * Time Complexity: the time complexity is O(n), where n is the length of the array, because we need to iterate through the entire array.
     * <p>
     * Space Complexity: the space complexity is O(1), because we are using a constant amount of extra space for variables.
     */
    private int isLegalNumber(int[] a, int base) {
        if (a.length == 0) {
            return 0;
        }

        // Each number in the array must be less than given base, if all the numbers less than the base, return 1, otherwise, return 0;
        for (int num : a) {
            if (num >= base) {
                return 0;
            }
        }

        return 1;
    }

    /**
     * num 20
     * <p>
     * Time Complexity: the time complexity is O(n), because we need to iterate through the array once for the base conversion.
     * <p>
     * Space Complexity: the space complexity is O(1), requiring only constant extra space to store intermediate results.
     */
    private int convertToBase10(int[] a, int base) {

        if (isLegalNumber(a, base) != 1) {
            return -1;
        }

        int result = 0;
        int power = 1;

        for (int i = a.length - 1; i >= 0; i--) {
            result += a[i] * power;
            power *= base;
        }
        return result;
    }

    /**
     * num 21
     * <p>
     * Time Complexity: the time complexity is O(n), where n is the length of the array since we need to traverse entire array.
     * <p>
     * Space Complexity: the space complexity is O(1), using only constant extra space for storing intermediate results.
     */
    private int arrayHasNoZeroes(int[] a) {

        for (int num : a) {
            if (num == 0) {
                return 0;
            }
        }

        return 1;
    }

    /**
     * num 22
     * <p>
     * Time Complexity: the time complexity is O(d * log(n * d)), The outer 'while' loop runs d times,
     * where d is the number of multiples needed to see all digits at from 0 to 9 at least once.
     * For each multiple "n * d", we need to extract each digit through log10 operation, hence the time complexity is O(d * log(n * d))
     * <p>
     * Space Complexity: the space complexity is O(1), we only use boolean array 'seenDigits' of length 10 to track seen digits
     * and a few integer variables for calculations. Regardless of the input size, the space required is constant.
     */
    private int computeDepth(int n) {

        boolean[] seenDigits = new boolean[10]; // Array to track seen digits

        int uniqueDigitsCount = 0; // Counter for unique digits seen

        int count = 0; // Counter for depth

        while (uniqueDigitsCount < 10) {

            count++; // Increment depth
            int currentMultiple = n * count; // Calculate current multiple

            // Traverse each digit of the current multiple
            while (currentMultiple > 0) {
                int digit = currentMultiple % 10; // Extract the last digit
                if (!seenDigits[digit]) {
                    seenDigits[digit] = true; // Mark it as seen
                    uniqueDigitsCount++;
                }
                currentMultiple /= 10; // Remove the last Digits
            }
        }

        return count;
    }

    /**
     * num 23
     * <p>
     * Time Complexity: the time complexity is
     * <p>
     * Space Complexity: the space complexity is O(1)
     */
    private int matches(int[] a, int[] p) {
        return 1;
    }

    /**
     * num 24
     * <p>
     * Time Complexity: the time complexity is O(√n), in the worst case, the number of iterations needed will not exceed √2n, neglecting constant factors -> √n
     * <p>
     * Space Complexity: the space complexity is O(1), We only use a few additional integer variables for accumulation and checking.
     */
    private int isStacked(int n) {

        int sum = 0;
        int count = 1;

        while (sum < n) {
            sum += count;
            if (sum == n) {
                return 1;
            }

            count++;
        }

        return 0; // If the loop ends without finding the sum equal to the given number, return 0
    }

    /**
     * num 25
     * <p>
     * Time Complexity: the time complexity is
     * <p>
     * Space Complexity: the space complexity is O(1)
     */
    private int isSumSafe(int[] a) {
        return 1;
    }

    /**
     * num 26
     * <p>
     * Time Complexity: the time complexity is
     * <p>
     * Space Complexity: the space complexity is O(1)
     */
    private int isIsolated(long n) {
        return 1;
    }

}
