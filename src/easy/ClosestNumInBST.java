package easy;
import easy.utils.TreeClass;

/**
 * Q: Find closest element in a BST to a targetNum.
 */
public class ClosestNumInBST {

    //Solution: We start at root, check if root.value - targetNum == 0, then root is answer
    // else if root > targetNum -> go to left subtree
    // if root < targetNum --> go to right

    //recursive method
    private int findClosestNumBSTRec(TreeClass root, int target, int closest) {
        if(root == null) {
            return closest;
        }
        if(Math.abs(target - root.value) < Math.abs(target - closest)) {
            closest = root.value;
        }
        if (target > root.value) {
            return findClosestNumBSTRec(root.right, target, closest);
        }
        else if (target < root.value) {
            return findClosestNumBSTRec(root.left, target, closest);
        }
        else {
            return closest;
        }
    }

    //method 2 : Iterative
    private int findClosestNumBSTItr(TreeClass root, int target, int closest) {
        TreeClass curr = root;
        while(curr != null) {
            if (Math.abs(target - curr.value) < Math.abs(target - closest)) {
                closest = curr.value;
            }
            if (target > curr.value) {
                curr = curr.right;
            } else if (target < curr.value) {
                curr = curr.left;
            }
            else {
                break;
            }
        }
        return closest;
    }

    private int findClosestNumBST(TreeClass root, int target, String type) {
        int closest = root.value;
        if(type == "rec") {
            return findClosestNumBSTRec(root, target, closest);
        }
        else {
            return findClosestNumBSTItr(root, target, closest);
        }
    }


    public static void main(String[] args) {
        TreeClass root = new TreeClass(10, null, null);;
        root.right = new TreeClass(15, null, null);
        root.left = new TreeClass(5, null, null);
        root.right.left = new TreeClass(13, null, null);
        root.right.right = new TreeClass(22, null, null);
        root.left.left = new TreeClass(2, null, null);
        root.left.right = new TreeClass(7, null, null);

        ClosestNumInBST c = new ClosestNumInBST();
        int closest = c.findClosestNumBST(root, 12, "rec");
        System.out.println(closest);
        closest = c.findClosestNumBST(root, 12, null);
        System.out.println(closest);
    }
}
