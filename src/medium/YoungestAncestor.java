package medium;

import medium.utils.AncestorTree;

/**
 * Q: Given a tree in which each node has ancestor property, and we can only traverse upward to node's ancestor.
 * Given two nodes, find common ancestor which is youngest.
 */
public class YoungestAncestor {

    /*
    * Method: We will find depth of both the nodes. There are three cases.
    * 1. Both depths are equal:
    *   1(a) : Both element are same, return any of them.
    *   1(b): Both are different, traverse upward until both become equal such that we got their common ancestor.
    *
    * 2. Depth1 > Depth 2: Move the element with higher depth to the depth equal to lower depth element, once both are at same level, apply step 1.
    * 3: Depth1 < Depth 2 : Same as point 2.
    *
    *
    * Time: O(d) -> D is depth of longest depth element in the tree.
    * Space: O(1)
    * */
    AncestorTree findYoungestAncestor( AncestorTree top, AncestorTree first, AncestorTree second ) {
        int firstDepth = getDepth(first, top);
        int secondDepth = getDepth(second, top);

        if(firstDepth > secondDepth) {
            return backTrackAncestor(first, second, firstDepth - secondDepth);
        }
        else {
            return backTrackAncestor(second, first, secondDepth - firstDepth);
        }
    }

    static AncestorTree backTrackAncestor(AncestorTree eleToMove, AncestorTree lowerDepthEle, int diff) {
        while(diff > 0) {
            eleToMove = eleToMove.ancestor;
            diff--;
        }

        while(eleToMove != lowerDepthEle) {
            eleToMove = eleToMove.ancestor;
            lowerDepthEle = lowerDepthEle.ancestor;
        }

        return lowerDepthEle;
    }

    static int getDepth(AncestorTree descendant, AncestorTree top) {
        int depth = 0;
        while(descendant != top) {
            depth++;
            descendant = descendant.ancestor;
        }
        return depth;
    }
    public static void main(String[] args) {
        AncestorTree head = new AncestorTree("A");
        AncestorTree level1Left = new AncestorTree("B");
        AncestorTree level1Middle = new AncestorTree("C");
        AncestorTree level1Right = new AncestorTree("D");
        AncestorTree level1LeftLeft = new AncestorTree("E");
        AncestorTree level1LeftRight = new AncestorTree("F");
        AncestorTree level1MiddleLeft = new AncestorTree("G");
        AncestorTree level1RightLeft = new AncestorTree("H");
        AncestorTree level1RightRight = new AncestorTree("I");

        level1Left.ancestor = head;
        level1Middle.ancestor = head;
        level1Right.ancestor = head;

        level1LeftLeft.ancestor = level1Left;
        level1LeftRight.ancestor = level1Left;
        level1MiddleLeft.ancestor = level1Middle;
        level1RightLeft.ancestor = level1Right;
        level1RightRight.ancestor = level1Right;


        YoungestAncestor y = new YoungestAncestor();
        AncestorTree result = y.findYoungestAncestor(head, level1Left, level1Middle);
        System.out.println("Youngest Ancestor is: " + result.value);

    }
}
