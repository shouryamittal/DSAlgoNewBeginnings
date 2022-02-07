package medium;

import com.sun.source.tree.Tree;
import medium.utils.TreeClass;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTInversion {
    //method: Recursive. For each node, swap the children of its left and then right child, and then swap its own.
    // Time: O(N), Space: O(d) == O(log N) -> bcz at a time max number of rec calls in stack would be equal to
    // length of longest branch and its equal to Log N.
    public TreeClass invert(TreeClass root) {
        if(root == null) {
            return null;
        }
        else {
            TreeClass curr = root;
            invert(curr.left);
            invert(curr.right);
            TreeClass temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
        }
        return root;
    }

    public void invertItr(TreeClass root) {
        Queue queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeClass curr = (TreeClass) queue.poll();
            if(curr != null) {
                TreeClass temp1 = curr.left;
                curr.left = curr.right;
                curr.right = temp1;
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
    }

    public void displayTree(TreeClass root) {
        if(root == null) {
            return;

        }
        TreeClass temp = root;
        displayTree(temp.left);
        System.out.println(temp.value);
        displayTree(temp.right);
    }

    public static void main(String[] args) {
        BSTInversion b = new BSTInversion();
        TreeClass tree = new TreeClass(1);
        tree.left = new TreeClass(2);
        tree.left.left = new TreeClass(4);
        tree.left.right = new TreeClass(5);
        tree.right = new TreeClass(3);
        tree.right.left= new TreeClass(6);
        tree.right.right = new TreeClass(7);
        b.displayTree(tree);
        b.invert(tree);
        System.out.println("-----------------------");
        b.displayTree(tree);
        System.out.println("----------------------");
        b.invertItr(tree);
        b.displayTree(tree);
    }
}
