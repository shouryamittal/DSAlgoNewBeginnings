package medium;

/**
 * Q: Find the maximum sum of continous subarray in an array
 */
public class KadaneAlgo {
    // method: For each index, find the maximum number till that index, either it is the number itself, or the number + sum till previous index
    // also maintain a maxSoFar, which just keep the track of maximum value till the current index.
    // Time: O(N), space: O(1)
    static int findMaxSum(int arr[]) {
        int maxEndingHere = 0;
        int maxSoFar = 0;

        for(int i = 0; i < arr.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + arr[i], arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        KadaneAlgo k = new KadaneAlgo();
        int arr[] = {3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4};
        System.out.println("Max sum is " + k.findMaxSum(arr));
    }
}

