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
        // int[] A1 = {1, 2, 3, -5, -5, 2, 3, 18};
        // int[] P1 = {3, -2, 3};
        // System.out.println(day4.matches(A1, P1)); // Output 1
        // int[] A2 = {1, 2, 3, -5, -5, 2, 3, 18};
        // int[] P2 = {4, -1, 3};
        // System.out.println(day4.matches(A2, P2)); // Output 0
        // System.out.println(day4.isSumSafe(new int[] {5, -2, 1}));
        // System.out.println(day4.isIsolated(2097151L));
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
     * Time Complexity: the time complexity is O(n + m), where n is the length of the array A and the m is the length of the array P
     * <p>
     * Space Complexity: the space complexity is O(1)
     */
    private int matches(int[] a, int[] p) {

        int index = 0; // To track the current position in array a

        for (int i = 0; i < p.length; i++) {

            int length = getAbsoluteValue(p[i]); // Get the length of the current segment

            boolean isPositive = p[i] > 0; // Determine if the current segment should be positive or negative

            // Check all elements in the current segment
            for (int j = 0; j < length; j++) {

                if (isPositive && a[index] <= 0) {
                    return 0;
                }

                if (!isPositive && a[index] >= 0) {
                    return 0;
                }

                index++; // Move to next element
            }
        }

        return 1;
    }

    private int getAbsoluteValue(int num) {
        if (num < 0) {
            return -num;
        }
        return num;
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
     * Time Complexity: the time complexity is O(n), Although we traverse the array twice, making the total number of operations O(2n),
     * we ignore constant factors in the time complexity analysis, so the final time complexity is O(n).
     * <p>
     * Space Complexity: the space complexity is O(1), as we only use a constant amount of extra space.
     */
    private int isSumSafe(int[] a) {

        if (a.length == 0) {
            return 0;
        }

        int sum = 0;

        for (int num : a) {
            sum += num;
        }

        for (int num : a) {
            if (num == sum) {
                return 0;
            }
        }

        return 1;
    }

    /**
     * num 26
     * <p>
     * Time Complexity: the time complexity is O((log n) ^2),
     * Extracting each digit: O(log n)
     * Checking for repeated digits: O((log n) ^2)
     * <p>
     * Space Complexity: the space complexity is O(1)
     */
    private int isIsolated(long n) {

        // We should maintain rigor, Because when n equals 2,097,151, cubing it will cause an ArrayIndexOutOfBoundsException.
        if (n < 1 || n >= 2097151) {
            return -1;
        }

        long square = n * n;
        long cube = n * n * n;
        boolean[] digitsInSquare = new boolean[10];

        // n % 10 is the rightmost digit of n, n = n/10 shifts the digits of n one place to the right.
        while (square > 0) {
            digitsInSquare[(int) (square % 10)] = true;
            square /= 10;
        }

        while (cube > 0) {
            if (digitsInSquare[(int) cube % 10]) {
                return 0;
            }
            cube /= 10;
        }

        return 1;
    }

}
