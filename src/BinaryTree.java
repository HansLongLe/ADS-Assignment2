import java.util.ArrayList;

public class BinaryTree {
    private BinaryTreeNode root;
    private int size;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public boolean isEmpty(){
        return false;
    }

    public int getSize() {
        return size;
    }
}
