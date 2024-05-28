package com.miu.dylan.algorithm.day1;

/**
 * day1 with 5 functions
 */
public class Day1 {
    public static void main(String[] args) {
        Day1 day1 = new Day1();
        // System.out.println(day1.isPerfectSquare(0));
        // System.out.println(day1.nUpCount(new int[]{2, 3, 1, -6, 8, -3, -1, 2}, 5));
        // System.out.println(day1.primeCount(10, 30));
        // System.out.println(day1.isMadhavArray(new int[]{-6, -3, -3, 8, -5, -4}));
        // System.out.println(day1.isInertial(new int[]{12, 11, 4, 9, 2, 3, 10}));
    }

    /**
     * num 1
     */
    private int isPerfectSquare(int n) {

        // handle case where n <= 0
        if (n < 0) {
            return 0;
        }

        // find the next perfect square without using Math.sqrt
        int x = 1;
        while (x * x <= n) {
            x++;
        }

        // return the result
        return x * x;
    }

    /**
     * num 2
     * <p>
     * Partial Sum: The running total as you iterate through the array.
     * <p>
     * Transition: When the partial sum changes from ≤n to >n.
     * <p>
     * Upcount: The count of these transitions.
     */
    private int nUpCount(int[] a, int n) {
        int partialSum = 0;
        int count = 0;
        int previousPartialSum;

        for (int i = 0; i < a.length; i++) {
            previousPartialSum = partialSum;
            partialSum += a[i];

            if (previousPartialSum <= n && partialSum > n) {
                count++;
            }
        }

        return count;
    }

    /**
     * num 3
     * <p>
     * Suppose we want to check if the number 29 is a prime:
     * <p>
     * The square root of 29 is approximately 5.39 (exact value is √29).
     * <p>
     * We only need to check if any integer from 2 to 5 can divide 29.
     * <p>
     * 2 does not divide 29
     * <p>
     * 3 does not divide 29
     * <p>
     * 4 does not divide 29
     * <p>
     * 5 does not divide 29
     * <p>
     * Therefore, 29 is a prime.
     */
    private int primeCount(int start, int end) {
        int count = 0;

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * num 4
     * <p>
     * Time Complexity: The time complexity is O(n2), where n is the length of the array. This is because we have a nested loop structure to check the Madhav property.
     * <p>
     * Space Complexity: The space complexity is O(1) because we only use a fixed amount of extra space for the variables.
     */
    private int isMadhavArray(int[] a) {
        int len = a.length;
        int n = 1;

        // Step 1: Find n such that n*(n+1)/2 = len
        while (n * (n + 1) / 2 < len) {
            n++;
        }

        // The length of array does not match any required length for n
        if (n * (n + 1) / 2 != len) {
            return 0;
        }

        // Step 2: Check the madhav property
        int sum = a[0];
        // index is the initial position of the nex subarray
        int index = 1;

        // 'i' indicates the length of the subarray currently to be checked.
        for (int i = 2; i <= n; i++) {
            int currentSum = 0;
            // j represents the index of the element in the current subarray
            for (int j = 0; j < i; j++) {
                if (index > len) {
                    return 0;
                }
                currentSum += a[index++];
            }

            if (currentSum != sum) {
                return 0;
            }
        }

        return 1;
    }

    /**
     * num 5
     * <p>
     * Time Complexity: The time complexity is O(n2) in the worst case due to the nested loop where each odd value is compared with every even value.
     * <p>
     * Space Complexity: The space complexity is O(1) because we only use a fixed amount of extra space for the variables.
     */
    private int isInertial(int[] a) {

        if (a.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        boolean hasOdd = false;
        // Step 1: Identify the maximum value in the array.
        for (int num : a) {
            if (num > max) {
                max = num;
            }
            if (num % 2 != 0) {
                hasOdd = true;
            }
        }

        // Step 2: Check if the maximum value is even.
        if (max % 2 != 0) {
            return 0; // max value is not even
        }

        // Step 3: Ensure the array contains at least one odd value.
        if (!hasOdd) {
            return 0;
        }

        // Step 4: Check if every odd value greater than every even value that is not the maximum
        for (int num : a) {
            if (num % 2 == 0 && num != max) {
                for (int odd : a) {
                    if (odd % 2 != 0 && odd <= num) {
                        return 0; // Found an even value that is not the max which is >= some odd value
                    }
                }
            }
        }

        return 1;
    }
}
