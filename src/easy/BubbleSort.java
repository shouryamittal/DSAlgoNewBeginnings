package easy;

public class BubbleSort {

    // TIme: O(N^2) - Avg and worst case, O(N) - best case (when already sorted), Space: O(1)
    private int[] bubbleSort(int[] arr) {
        boolean isSortee = false;
        int counter = 0;
        while(!isSortee) {
            isSortee = true;
            for(int i = 0 ; i < arr.length - 1 - counter; i++) {
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    isSortee = false;
                }
            }
            counter++;
        }

        return arr;
    }

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int arr[] = {2,4,3,6,23,1};
        int result[] = b.bubbleSort(arr);
        for(int ele: result) {
            System.out.println(ele);
        }
    }
}
