public class BinarySearchTree<E extends Comparable> extends BinaryTree {

    private BinarySearchTreeNode root;

    public BinarySearchTree(BinarySearchTreeNode root) {
        this.root = root;
    }

    public boolean insert(E element) {
        try {
            insert(element, root);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private BinarySearchTreeNode insert(E element, BinarySearchTreeNode node) {
        if (element != null) {
            if (root == null) root = new BinarySearchTreeNode(element);
            if (element.compareTo(node.getElement()) <= 0) {
                if (node.getLeftChild() != null)
                    node.addLeftChild(insert(element, (BinarySearchTreeNode) node.getLeftChild()));

            } else if (element.compareTo(node.getElement()) >= 0) {
                if (node.getRightChild() != null) ;
                node.addRightChild(insert(element, (BinarySearchTreeNode) node.getRightChild()));
            }

        }
        return node;
    }

  /*  public boolean removeElement(E element)
    {
        return false;
    }

    public E findMin()
    {

    }
    public E findMax()
    {

    }

    public boolean contains(E element)
    {

    }

    public void rebalance()
    {

    }*/

}
