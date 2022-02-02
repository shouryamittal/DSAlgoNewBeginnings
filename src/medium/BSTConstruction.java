package medium;
import com.sun.source.tree.Tree;
import medium.utils.TreeClass;

public class BSTConstruction {

    public TreeClass insert(TreeClass root, int value) {
        if(root == null) {
            root = new TreeClass(value);
            return root;
        }
        else {
            TreeClass current = root;
            while(true) {
                if(value < current.value) {
                    if(current.left == null) {
                        current.left = new TreeClass(value);
                        break;
                    }
                    else {
                        current = current.left;
                    }
                }
                else {
                    if(current.right == null ) {
                        current.right = new TreeClass(value);
                        break;
                    }
                    else {
                        current = current.right;
                    }
                }
            }
        }
        return root;
    }

    public int searchElement(TreeClass root, int element) {
        TreeClass current = root;
        int retVal = -1;
        while(current != null) {
            if(current.value == element) {
                retVal = 1;
                break;
            }
            else if(current.value > element) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        return retVal;
    }

    static TreeClass getInorderSuccessor(TreeClass current) {
        TreeClass curr = current.right;
        TreeClass successor = null;
        while(curr != null) {
            successor = curr;
            curr = curr.left;
        }
        return successor;
    }

    public void deleteElement(TreeClass root, int ele) {
        TreeClass current = root;
        TreeClass parent = null;

        while(current != null) {
            if(current.value > ele) {
                parent = current;
                current = current.left;
            }
            else if(current.value < ele) {
                parent =current;
                current = current.right;
            }
            else {
                if(current.right == null && current.left == null) {
                    current = null;
                    break;
                }
                else if(current.left == null) {
                    if(parent.left == current) {
                        parent.left = current.right;
                    }
                    else {
                        parent.right = current.right;
                    }
                    current = null;
                }
                else if(current.right == null) {
                    if(parent.left == current) {
                        parent.left = current.left;
                    }
                    else {
                        parent.right = current.left;
                    }
                    current = null;
                }
                else {
                    TreeClass inorderSuccessor = BSTConstruction.getInorderSuccessor(current);
                    current.value = inorderSuccessor.value;
                    this.deleteElement(current.right, inorderSuccessor.value);
                }
            }
        }
    }

    //method: Check for each node and set max and min values. if the current number is out of range, its not a valid BST.
    // TIme: (N), O(d) ->  bcz at a time call stack will have as many number of function calls as the length of longest branch
    public boolean isValidBST(TreeClass root, Double max, Double min) {
        if(root == null) {
            return true;
        }
        if(root.value > max || root.value < min) {
            return false;
        }
        return isValidBST(root.left, (double)root.value, min)
        && isValidBST(root.right, max, (double)root.value);
    }

    public void displayTree(TreeClass root) {
        if(root == null) {
            return;
        }
        displayTree(root.left);
        System.out.println(root.value);
        displayTree(root.right);
    }

    public static void main(String[] args) {
        BSTConstruction tree = new BSTConstruction();
        int array [] = {1, 12, 4 ,5,9,6,14, 12, 15};
        TreeClass root = null;
        for(int ele: array) {
           root =  tree.insert(root, ele);
        }
        tree.displayTree(root);
        int isFound = tree.searchElement(root, 5);
        System.out.println("Is element found ? -> " + isFound);
        tree.deleteElement(root,14);
        System.out.println("After deletion:");
        tree.displayTree(root);
        System.out.println("is BST valid ? -> " + tree.isValidBST(root, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
    }
}
