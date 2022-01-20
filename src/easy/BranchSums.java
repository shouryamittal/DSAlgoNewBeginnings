package easy;
import easy.utils.TreeClass;

import java.util.ArrayList;

/*
* Q: Calculate the sum of each branch in a tree and return a list of all sums;
* */
public class BranchSums {
    //method: use DFS and calculate the running sum at each node until you reach the leaf node, at leaf node,
    //just push the entire sum of branch in the array
    private void calcBranchSums(TreeClass root, int sum, ArrayList<Integer> sums) {
        sum += root.value;
        if(root.left == null && root.right == null) {
            sums.add(sum);
            return;
        }
        calcBranchSums(root.left, sum, sums);
        calcBranchSums(root.right, sum, sums);
    }
    private ArrayList<Integer> calculateBranchSums(TreeClass root) {
        ArrayList<Integer> sums = new ArrayList<>();
        calcBranchSums(root, 0, sums);
        return sums;
    }

    public static void main(String[] args) {
        TreeClass root;
        root = new TreeClass(1, null, null);
        root.left = new TreeClass(2, null, null);
        root.right = new TreeClass(3, null, null);
        root.left.left = new TreeClass(4, null, null);
        root.left.right = new TreeClass(5, null, null);

        BranchSums b = new BranchSums();
        ArrayList<Integer> branchSums = b.calculateBranchSums(root);
        for(Integer sum: branchSums) {
            System.out.println(sum.intValue());
        }
    }
}
