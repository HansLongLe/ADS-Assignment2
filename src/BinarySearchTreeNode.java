public class BinarySearchTreeNode <E extends Comparable> extends BinaryTreeNode {

    private E element;

    public BinarySearchTreeNode(E element) {
        super(element);
        this.element = element;
    }
}
