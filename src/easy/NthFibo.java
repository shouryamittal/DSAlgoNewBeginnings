package easy;

import java.util.Hashtable;

/**
 * Q: Find nth fibonacci number
 */

public class NthFibo {

    //method 1: Recursive;
    //Time: O(2^n), Space: O(N) -> bcz recursive calls get stored in call stack
    public int findNthFibNum(int n) {
        if(n == 1) {
            return 0;
        }
        else if(n == 2) {
            return 1;
        }
        else {
            return findNthFibNum(n-1) + findNthFibNum(n-2);
        }
    }


    //method 2: Recursive with memoization
    //Time: O(N) -> bcz every element is calculated only once and then memoized for further use, space: O(N)
    public int fibNthNumMemoize(int n, Hashtable obj) {
        if(n == 1) {
            return 0;
        }
        else if(n == 2) {
            return 1;
        }
        else if(obj.containsKey(n)) {
            return (Integer)obj.get(n);
        }
        else {
            int ret = fibNthNumMemoize(n-1, obj) + fibNthNumMemoize(n-2, obj);
            obj.put(n, ret);
            return ret;
        }
    }


    //method 3:Best method
    // here we keep an array of last 2 nums in the list and start with [0, 1] as first 2 numbers of Fibo are 0 1.
    //then successively compute new number and adding it to end of the array and discarding first number.

    //Time: O(N), space: O(1)
    public int findNthFibBest(int n, int[] lastTwoNums) {
        int result = 0;
        if(n == 1) {
            return 0;
        }
        else if(n == 2) {
            return 2;
        }
        for(int i = 3; i <= n; i++) {
            result = lastTwoNums[0] + lastTwoNums[1];
            lastTwoNums[0] = lastTwoNums[1];
            lastTwoNums[1] = result;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 7;
        Hashtable<Integer, Integer> table = new Hashtable<>();
        int []lastTwoNums = {0, 1};
        NthFibo fib = new NthFibo();
        System.out.println(n+"th fibonacci num is " + fib.findNthFibNum(n));
        System.out.println(n+"th fibonacci num is " + fib.fibNthNumMemoize(n, table));
        System.out.println(n+"th fibonacci num is " + fib.findNthFibBest(n, lastTwoNums));
    }
}
