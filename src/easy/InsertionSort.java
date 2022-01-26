package easy;

public class InsertionSort {
    private int[] insertionSort(int[] arr) {
        int j = 0;
        for(int i = 1; i < arr.length; i++) {
            j = i;
            while(j > 0 && arr[j] < arr[j-1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertionSort i = new InsertionSort();
        int arr[] = {2,40,3,1,6,4};
        int result[] = i.insertionSort(arr);
        for(int ele: result) {
            System.out.println(ele);
        }
    }
}
