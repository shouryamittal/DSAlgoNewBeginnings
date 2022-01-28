package medium;

import java.util.Arrays;

public class SmallestDiff {

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



