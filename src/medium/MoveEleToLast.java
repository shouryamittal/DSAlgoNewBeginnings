package medium;

/**
 * Q: Shift every occurrence of element X to the last of the array in place.
 */
public class MoveEleToLast {

    /**
     * @param arr
     * @param toMove
     * @return
     */
    //method: Use the same 2 pointer approach, point i to first and j to last.
    private int[] moveEleToLast(int[] arr, int toMove) {
        int i = 0, j = arr.length - 1;
        while(i < j) {
            while((i < j && arr[j] == toMove)) {
                j--;
            }
            if(arr[i] == toMove) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            i++;
        }
        return arr;
    }
    public static void main(String[] args) {
        MoveEleToLast m = new MoveEleToLast();
        int arr[] = {2,3,3,2,3,2,4,2};
        int toMove = 3;
        int result[] = m.moveEleToLast(arr, toMove);
        for(int ele: result) {
            System.out.println(ele);
        }
    }
}
