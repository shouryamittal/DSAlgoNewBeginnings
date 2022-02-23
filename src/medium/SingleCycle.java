package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * This question needs to revisited
 */
public class SingleCycle {

    static boolean singleCycle(int arr[]) {
        boolean isAllVisited = false;
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while(true) {
            if(list.contains(i)) {
                break;
            }
            else {
                list.add(i);
            }
            i = i + arr[i];
            if(i >= arr.length) {
                i = i - arr.length;
            }
            else if( i < 0 ) {
                i = arr.length + i;
            }
        }
        System.out.println(list.size());
        return (list.size() == arr.length);
    }
    public static void main(String[] args) {
        SingleCycle s = new SingleCycle();
        int arr[] = {2,3,1,-4,-4,2};
        System.out.println(singleCycle(arr));;
    }
}



