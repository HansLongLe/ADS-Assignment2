public class BinaryTreeNode <E extends Comparable> {

    private E element;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode(E element)
    {
        this.element = element;
        leftChild = null;
        rightChild = null;
    }

    public BinaryTreeNode()
    {
        element = null;
        leftChild = null;
        rightChild = null;
    }

    public void setElement(E element)
    {
        this.element = element;
    }

    public E getElement()
    {
        return element;
    }

    public void addLeftChild(BinaryTreeNode leftChild)
    {
        this.leftChild = leftChild;
    }

    public void addRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

}