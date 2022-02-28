package medium.utils;

public class AncestorTree {
    public String value;
    public AncestorTree ancestor;

    public AncestorTree(String value) {
        this.value = value;
        this.ancestor = null;
    }
}
