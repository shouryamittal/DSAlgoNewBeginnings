package easy.utils;

public class TreeClass {
    public int value;
    public  TreeClass left;
    public  TreeClass right;

    public TreeClass(int value, TreeClass ...links) {
        this.value = value;
        this.left = links[0];
        this.right = links[1];
    }
}
