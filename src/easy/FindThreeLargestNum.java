package easy;

/**
 * Q:  Find three largest numbers in an unsorted array
 */
public class FindThreeLargestNum {
    //method: Create an array X of length 3, then, for each element in actual array Y, starting from the last element of X
    // check if its null of Y[i] > X[i], if true, then replace X[i] with Y[i] and shift rest of the numbers in X one place left.
    // similarly for i = 1, replace X[1] with Y[1] and shift number till index 1 to left by 1.
    void shiftAndUpdate(int[] array, int num,int index) {
        for(int i = 0 ; i < index+1 ; i++) {
            if(i == index) {
                array[i] = num;
            }
            else {
                    array[i] = array[i+1];
            }
        }
    }

    private int[] findThreeLargestNum(int[] arr) {
        int largestArrauy[] = {-1, -1, -1};
        for(int ele: arr) {
            if(largestArrauy[2] == -1 || largestArrauy[2] < ele) {
                shiftAndUpdate(largestArrauy, ele, 2);
            }
            else if(largestArrauy[1] == -1 || largestArrauy[1] < ele) {
                shiftAndUpdate(largestArrauy, ele, 1);
            }
            else if(largestArrauy[0] == -1 || largestArrauy[0] < ele) {
                shiftAndUpdate(largestArrauy, ele, 0);
            }
        }
        return largestArrauy;
    }

    public static void main(String[] args) {
        int [] arr = {23,4,56,3,5,67};
        FindThreeLargestNum f = new FindThreeLargestNum();
        int array[] = f.findThreeLargestNum(arr);
        for(int ele: array) {
            System.out.println(ele);
        }
    }
}
