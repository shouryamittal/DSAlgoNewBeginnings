package medium;

/**
 * Q: Given an array of integers, find a sum that is maximum such that no two adjacent numbers are added
 */
public class MaxSumSubsetNoAdjancent {

    //method: Traverse the array from start. For first number, the max sum until first index could be that number itself.
    // for second number, max sum could be max(firstNUm, secondNUm). From third onwards, maxSum = max(a,b) where:
    // a: max sum up until (i-2)th index + num[i]. Here we did not count i-1th bcz that would be adjacent number which we dont want to add
    // b: max sum until (i-1)th index.

    // Time: O(N), Space: O(1)
    public int maxSumSubsetNoAdjacent (int arr[]) {
        if(arr.length == 0) {
            return 0;
        }
        if(arr.length == 1) {
            return arr[0];
        }
        int first = arr[0];
        int second = Math.max(arr[0], arr[1]);
        for(int i = 2; i< arr.length; i++) {
            int sum = Math.max(first + arr[i], second);
            first = second;
            second = sum;
        }
        return second;
    }

    public static void main(String[] args) {
        MaxSumSubsetNoAdjancent m = new MaxSumSubsetNoAdjancent();
        int arr[] = {4,5,2,45,78};
        System.out.println("Max sum subset with no adjacent is: " + m.maxSumSubsetNoAdjacent(arr));
    }
}