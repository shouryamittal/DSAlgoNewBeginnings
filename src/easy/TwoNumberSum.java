package easy;
import java.util.Arrays;
import java.util.Hashtable;

/*
Q: Find sum of two numbers such that their sum is equal to the given targetSum.
* */
public class TwoNumberSum {
    //method 1 : Simple 2 for loop method:
    // Time: O(n^2), S: O(1)
    int [] twoSumNumber(int[] arr, int targetSum) {
        int[] result = new int[2];
        for(int i = 0 ; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[i] + arr[j] == targetSum) {
                    result[0] = arr[i];
                    result[1] = arr[j];
                    break;
                }
            }
        }
        return result;
    }

    //method 2 : using hashtable to store the value of y = targetSum - arr[i] for each element in the array;
    //If y is present then return y and arr[i] otherwise store arr[i] for other successive numbers
    //Time: O(N), space: O(N)
    int [] twoNumberSumWithHashTable(int[] arr, int targetSum) {
        int []result = new int[2];
        Hashtable<Integer, Boolean> h = new Hashtable<>();

        for(int i = 0 ; i < arr.length; i++) {
            int y = targetSum - arr[i];
            if(h.containsKey(y)) {
                result[0] = arr[i];
                result[1] = y;
                break;
            }
            else {
                h.put(arr[i], true);
            }
        }
        return result;
    }

    //method 3 : First sort the array, so that smaller number are on left and larger numbers on right.
    // Keep 2 pointers L on 0 and R on arr.length - 1
    //Take sum of S = L and R, compare with TargetSum, if S > targetSum --> this means, we'll have to decrease R, otherwise
    // increase L by 1.
    // Time: O(NlogN), Space: O(1)
    int [] twoNumberSumWithoutHashTable(int [] arr, int targetSum) {
        int []result = new int[2];
        int left = 0;
        int right = arr.length - 1;
        //sort the array --> Time: O(NlogN)
        Arrays.sort(arr);
        int tempSum = 0;
        for(int i = 0 ; i < arr.length; i++) {
            tempSum = arr[left] + arr[right];
            if(tempSum == targetSum) {
                result[0] = arr[left];
                result[1] = arr[right];
                break;
            }
            else if(tempSum > targetSum) {
                right--;
            }
            else if(tempSum < targetSum) {
                left++;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int arr[] = {-2,-1,4,5,-4,6,9};
        int targetSum = 10;
        TwoNumberSum t = new TwoNumberSum();
        int result[] = new int[2];
        result = t.twoSumNumber(arr, targetSum);
        System.out.println("Result: [" + result[0] + "]["+result[1] + "]");

        result = t.twoNumberSumWithHashTable(arr, targetSum);
        System.out.println("Result: [" + result[0] + "]["+result[1] + "]");

        result = t.twoNumberSumWithoutHashTable(arr, targetSum);
        System.out.println("Result: [" + result[0] + "]["+result[1] + "]");
    }
}
