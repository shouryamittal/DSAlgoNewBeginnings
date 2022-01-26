package easy;

public class SelectionSort {

    private int[] selectionSort(int[] arr) {
       int currIdx = 0;
       while (currIdx < arr.length - 1) {
           int smallestidx = currIdx;
           for( int i = currIdx + 1; i < arr.length; i++) {
               if(arr[i] < arr[smallestidx]) {
                   smallestidx = i;
               }
           }
           int temp = arr[currIdx];
           arr[currIdx] = arr[smallestidx];
           arr[smallestidx] = temp;
           currIdx += 1;
       }
       return arr;
    }

    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        int arr[] = {2,4,3,1,5,7};
        int result[] = s.selectionSort(arr);
        for(int ele: result) {
            System.out.println(ele);
        }
    }
}
