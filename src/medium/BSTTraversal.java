package medium;
import medium.utils.TreeClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Q: Inorder, preorder and postorder traversal
 */

/**
 * All methods have Time: O(N), Space: O(N)
 */
public class BSTTraversal extends BSTConstruction{
    private List<Integer> traversed = new ArrayList<>();
    public void inorder(TreeClass root) {
        if(root == null) {
            return;
        }
        this.inorder(root.left);
        traversed.add(root.value);
        this.inorder(root.right);
        int result[] = new int[traversed.size()];
        return;
    }

    public void inorderItr(TreeClass root) {
        TreeClass curr = root;
        TreeClass parent = curr;
        Stack stack = new Stack();
        stack.push(root);
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        while(!stack.isEmpty()) {

        }
    }

    public void preOrder(TreeClass root) {
        if(root == null) {
            return;
        }
        this.traversed.add(root.value);
        preOrder(root.left);
        preOrder(root.right);
        return;
    }

    public void postorder(TreeClass root) {
        if(root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        this.traversed.add(root.value);
        return;
    }
    public void displayTraversal(List<Integer> array) {
        for(int ele: array) {
            System.out.print(ele + " ");
        }
    }

    public static void main(String[] args) {
        BSTTraversal bst = new BSTTraversal();
        TreeClass root = null;
        root = bst.insert(root, 10);
        root = bst.insert(root, 2);
        root = bst.insert(root, 5);
        root = bst.insert(root, 13);
        root = bst.insert(root, 16);
        root = bst.insert(root, 12);
        root = bst.insert(root, 1);

        bst.inorder(root);
        System.out.println("Inorder: ");
        bst.displayTraversal(bst.traversed);
        bst.traversed.clear();
        bst.preOrder(root);
        System.out.println("\nPre order:");
        bst.displayTraversal(bst.traversed);
        bst.traversed.clear();
        System.out.println("\nPost order:");
        bst.postorder(root);
        bst.displayTraversal(bst.traversed);
    }
}
