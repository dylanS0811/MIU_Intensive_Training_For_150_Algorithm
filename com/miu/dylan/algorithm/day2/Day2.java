package com.miu.dylan.algorithm.day2;

/**
 * day2 with 8 functions
 */
public class Day2 {
    public static void main(String [] args) {

        Day2 day2 = new Day2();
        // System.out.println(day2.countSquarePairs(new int[] {9, 0, 2, -5, 7}));
        // System.out.println(day2.findPorcupineNumber(409));
        // System.out.println(day2.isGuthrieSequence(new int[] {6, 3, 10, 5, 16, 8, 4, 2, 1}));
        // System.out.println(day2.stantonMeasure(new int[] {1, 3, 1, 1, 3, 3, 2, 3, 3, 3, 4}));
        // System.out.println(day2.sumFactor(new int[] {0, 0, 0}));
        // System.out.println(day2.guthrieIndex(342934392));
        // int[] result = day2.solve10();
        // if (result.length == 2 && result[0] != -1 && result[1] != -1) {
        //     System.out.println("x =" + result[0] + ", y= " + result[1]);
        // } else {
        //     System.out.println("No solution found");
        // }
        // System.out.println(day2.repsEqual(new int[] {0, 0, 3, 2, 0, 5, 3}, 32053));
    }

    /**
     * num 6
     * <p>
     * Time Complexity: The time complexity is O(n2) because we have a nested loop that checks each pair in the array.
     * <p>
     * Space Complexity: The space complexity is O(1) because we only use a fixed amount of extra space for the variables.
     */
    private int countSquarePairs(int[ ] a) {
        // Step 1: Check if the array length is greater than 2.
        if (a.length <= 2) {
            return 0; // Array must have at least 2 elements.
        }

        // Step 2: Iterate through the array to find all possible pairs<x, y> where x > y.
        // Step 3: Check if x + y is perfect square using the helper function.
        // Step 4: Count and return the number of valid square pairs.
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j =0; j < a.length; j++) {
                if (i != j && a[i] > 0 && a[j] > 0 && a[i] < a[j] && isPerfectSquare(a[i] + a[j])) {
                    count ++;
                }
            }
        }

        return count;
    }

    // Helper function to check if the num is perfect square
    private boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }

        int sqrt = (int)Math.sqrt(num);

        return sqrt * sqrt == num;
    }



    /**
     * num 7
     * <p>
     * Time Complexity: The time complexity difficult to define precisely because it depends on the distribution of prime numbers. On average, it is O(n log log n) for finding primes.
     * <p>
     * Space Complexity: The space complexity is O(1) because we only use a fixed amount of extra space for the variables.
     *
     */
    private int findPorcupineNumber(int n) {

        // Step 1: Iterate through numbers starting from n+1 to find the first porcupine.
        int num = n + 1;
        while (true) {
            // Step 2: Check if the number is prime and ends in 9.
            if (isPrime(num) && num % 10 == 9) {
                int nextNum = num + 1;
                // Step 3: Find the next number that is the prime
                while (!isPrime(nextNum)) {
                    nextNum ++;
                }
                // Step 4: Check if the next prime number also ends in 9.
                if (nextNum % 10 == 9) {
                    // return first num that satisfies these conditions.
                    return num;
                }
            }
            num ++;
        }
    }

    // Define a helper function to check if the number is prime
    private boolean isPrime(int num) {

        // According to the definition of prime numbers, a prime number is a natural number greater than 1.
        if (num <= 1) {
            return false;
        }

        // To iterate from 2 up to the square root of num to check for divisors.
        for (int i = 2; i * i <= num; i++) {
            // To check if num can be divided by i.
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }


    /**
     * num 8
     * <p>
     * Time Complexity: The time complexity is O(n) where n is the length of the array, as we are iterating through the array once.
     * <p>
     * Space Complexity: The space complexity is O(1) as we only use a fixed amount of extra space for the variables.
     *
     */
    private int isGuthrieSequence(int[ ] a) {
        if (a.length == 0) {
            return 0; // An empty array cannot be a Guthrie sequence.
        }

        int current = a[0];

        for (int i = 1; i < a.length; i ++) {
            // Step 1: Check if the current is even, / 2
            if (current % 2 == 0) {
                current = current / 2;
            } else {
                // Step 2: If the current is odd, * 3 + 1
                current = current * 3 + 1;
            }
            // Step 3: To check if the generated current matches the next element in the array
            if (current != a[i]) {
                // If any generated current does not match the corresponding element in the array,
                // the function immediately returns 0,
                // indicating that the array is not a Guthrie sequence.
                return 0;
            }
        }

        return a[a.length - 1] == 1 ? 1 : 0;
    }



    /**
     * num 9
     * <p>
     * Time Complexity: The time complexity is O(n), where n is the length of the array, as we need to traverse the array twice.
     * <p>
     * Space Complexity: The space complexity is O(1) since we only use a fixed amount of extra space for the variables.
     *
     */
    private int stantonMeasure(int[ ] a) {
        int countForOne = 0;
        for (int j : a) {
            if (j == 1) {
                countForOne++;
            }
        }

        int countStanton = 0;
        for (int j : a) {
            if (j == countForOne) {
                countStanton++;
            }
        }

        return countStanton;
    }

    /**
     * num 10
     * <p>
     * Time Complexity: The time complexity is O(n),where n is the length of the array, we need to traverse the array twice.
     * <p>
     * Space Complexity: The space complexity is O(1) since we only use a fixed amount of extra space for the variables.
     *
     */
    private int sumFactor(int[ ] a) {

        // Step 1: Calculate the sum of the array elements.
        int sum = 0;
        for (int i : a) {
            sum += i;
        }

        // Step 2: Count the number of 'sum' appears in the array.
        int countOfSumFactor = 0;
        for (int i : a) {
            if (i == sum) {
                countOfSumFactor ++;
            }
        }

        return countOfSumFactor;
    }

    /**
     * num 11
     * <p>
     * Time Complexity: The time complexity is O(m), where m is the number of steps required to reduce n to 1, this depends on the value of n and the sequence of the transformations.
     * <p>
     * Space Complexity: The space complexity is O(n), since we only use a fixed amount of extra space of the counter and the variable n.
     *
     */
    private int guthrieIndex(int n) {
        if (n <= 0) {
            return 0;
        }

        int count = 0; // Initialize the counter

        // Apply the algorithm until n becomes 1
        while (n != 1) {
            // Step 1: Check if the n is even -> divide it by 2
            if (n % 2 ==0) {
                n = n / 2;
            } else {
                // Step 2: If the n is odd -> multiply it by 3 and add 1
                n = n * 3 + 1;
            }
            count ++; // Increment the counter
        }

        return count; // return the Guthrie index
    }

    /**
     * num 12
     * <p>
     * Time Complexity: The time complexity is O(n2), where n is 10 in this case, as we are iterating through all pairs of x and y up to 10.
     * <p>
     * Space Complexity: The space complexity is O(n) since we only use a fixed amount of extra space for the variables and result array.
     *
     */
    private int[ ] solve10() {
        for (int x = 0; x <= 10; x++) {
            for (int y = 0; y <= 10; y++) {
                if (factorial(x) + factorial(y) == factorial(10)) {
                    return new int[] {x, y};
                }
            }
        }

        return new int[]{-1, -1}; // In case no solution is found
    }


    private int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    /**
     * num 13
     * <p>
     * Time Complexity: The time complexity is O(n), where n is the length of the array because we need to iterate through the array to compare each digit.
     * <p>
     * Space Complexity: The space complexity is O(1), as we don't use any additional space to store data.
     *
     */
    private int repsEqual(int[] a, int n) {
        // Step 1: Convert int to a String for compare each digit
        String numStr = String.valueOf(n);

        // Step 2:
        int numStrLength = numStr.length();

        // Step 3: Compare each digit from the end of the array to the beginning
        int index = a.length - numStrLength;

        // if the length of the array is less then the length of the number, return 0
        if (index < 0) {
            return 0;
        }

        // Step 4: Compare each digit in the array to the with corresponding digit in the integer
        for(int i = 0; i < numStrLength; i++) {
            if (a[index + i] != Character.getNumericValue(numStr.charAt(i))) {
                return 0;
            }
        }

        return 1;
    }

}
