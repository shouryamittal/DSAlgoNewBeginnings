package medium;
import java.util.Arrays;

/**
 * Q: Given two arrays of different sizes, find 2 numbers for which the difference is minimum.
 */

public class SmallestDiff {

    //method 1: Sort both the arrays, then use the property of sorted arrays which we used in 2 and 3 number sum questions.
    // put i at first element of arr1, and j at arr2
    // if(arr1[i] == arr2[j]) -> means its the minimum difference, hence return with those numbers
    // if(arr1[i] < arr2[j]) -> means, the difference between all the numbers after arr1[i] and the current value of arr[j] would be
    // smaller than difference of arr1[i] and arr2[j]. hence i++
    //if(arr1[i] > arr2[j] -> means ,the difference between all the numbers after arr2[j] and the current value of arr[i] would be
    //smaller than difference of arr1[i] and arr2[j]. hence j++


    //Time: O(NlogN + MlogM) -> N - size of arr1, M - size of arr2
    //Space: O(1) - coz no extra space used.
    private int[] smallestDiff(int arr1[], int arr2[]) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int maxLen1 = arr1.length;
        int maxLen2 = arr2.length;
        int i = 0, j = 0;
        int result[] = new int[2];
        Double diff = Double.POSITIVE_INFINITY;
        Double minDiff = Double.POSITIVE_INFINITY;
        while(i < maxLen1 && j < maxLen2) {
            int fNo = arr1[i];
            int sNo = arr2[j];
            if(fNo == sNo) {
                result[0] = fNo;
                result[1] = sNo;
                break;
            }
            else if(fNo < sNo) {
                diff = (double) (sNo - fNo);
                i++;
            }
            else {
                diff = (double)(fNo - sNo);
                j++;
            }

            if(minDiff > diff) {
                minDiff = diff;
                result[0] = fNo;
                result[1] = sNo;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        SmallestDiff s = new SmallestDiff();
        int arr1[] = {-1,5,10,20,28, 3};
        int arr2[] = {26, 134, 135, 15, 17};
        int result[] = s.smallestDiff(arr1, arr2);
        System.out.println("Min difference between 2 numbers in arrays is: [" + result[0] + "," + result[1] + "]");
    }
}



