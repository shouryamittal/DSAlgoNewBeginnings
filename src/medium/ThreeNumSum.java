package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q: Find all the triplets for which the sum is equal to target sum
 */
public class ThreeNumSum {

    // method: for each element in the array, start with the number at the index +1, to the last element,
    // and check if the sum is equal to target then add that triplet and continue until let < right.
    // for other cases, increment and decrement left/right accordingly.

    // Time: O(n^2), Space: O(n)
    private List<List<Integer>> findThreeNumSum(int []arr, int targetSum) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            List<Integer> triplet = new ArrayList<>();
            while(left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if(currentSum == targetSum) {
                    triplet.add(arr[i]);
                    triplet.add(arr[left]);
                    triplet.add(arr[right]);
                    //here we cannot just break the loop once we have found 1 triplet, bcz we can have more triplet
                    // for the same arr[i]. And both left and right have been changed for the reason that if left was
                    // increased the currentSum would be > targetSum, if right was decreased then currentSum < targetSum
                    left++;
                    right--;
                }
                else if(currentSum < targetSum) {
                    left++;
                }
                else {
                    right--;
                }
            }
            list.add(triplet);
        }
        return list;
    }


    public static void main(String[] args) {
        ThreeNumSum t = new ThreeNumSum();
        int arr [] = {-2,-4,-3,-1,2,4, -5};
        List<List<Integer>> result = t.findThreeNumSum(arr, -5);
        for(List subList: result) {
            for(Object ele: subList) {
                System.out.println((int)ele);
            }
        }
    }
}
