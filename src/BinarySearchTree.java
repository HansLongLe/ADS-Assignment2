import java.sql.ClientInfoStatus;
import java.util.ArrayList;

public class BinarySearchTree extends BinaryTree {

    private BinarySearchTreeNode root;

    public BinarySearchTree(BinarySearchTreeNode root) {
        super(root);
        this.root = root;
    }

    public boolean insert(int element) {
        if(root == null)
        {
            root = new BinarySearchTreeNode(element);
            return true;
        }
        else {
            return insert(element, root);
        }

    }

    private boolean insert(int element, BinarySearchTreeNode node) {
            if (node.getElement().compareTo(element) >= 0) {
                if (node.getLeftChild() == null) {
                    node.addLeftChild(new BinarySearchTreeNode(element));
                    return true;
                }
                else {
                    return insert(element, (BinarySearchTreeNode) node.getLeftChild());
                }

            } else {
                if (node.getRightChild() == null) {
                    node.addRightChild(new BinarySearchTreeNode(element));
                    return true;
                }
                else{
                    return insert(element, (BinarySearchTreeNode) node.getRightChild());
                }
            }
    }


   public boolean removeElement(int element)
    {
        if (root == null)
        {
            return false;
        }
        try {
            removeElement(element, root);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }
    private BinarySearchTreeNode removeElement(int element, BinarySearchTreeNode node)
    {
        if (node.getElement().compareTo(element) > 0)
        {
            node.addLeftChild(removeElement(element, (BinarySearchTreeNode) node.getLeftChild()));
        }
        else if (node.getElement().compareTo(element) < 0)
        {
            node.addRightChild(removeElement(element,(BinarySearchTreeNode) node.getRightChild()));
        }
        else {
            if (node.getLeftChild() == null)
            {
                return (BinarySearchTreeNode) node.getRightChild();
            }
            else if (node.getRightChild() == null)
            {
                return (BinarySearchTreeNode) node.getLeftChild();
            }
            node.setElement(minValue((BinarySearchTreeNode) node.getRightChild()));
            node.addRightChild(removeElement((int) node.getElement(), (BinarySearchTreeNode) node.getRightChild()));
        }
        return node;
    }

    private int minValue(BinarySearchTreeNode node)
    {
        int minVal = (int) node.getElement();
        while (node.getLeftChild() != null)
        {
            minVal = (int) node.getLeftChild().getElement();
            node = (BinarySearchTreeNode) node.getLeftChild();
        }
        return minVal;
    }

    public int findMin()
    {
     BinarySearchTreeNode node = root;
     while (node.getLeftChild() != null)
     {
         node = (BinarySearchTreeNode) node.getLeftChild();
     }
     return (int) node.getElement();
    }

    public int findMax()
    {
        BinarySearchTreeNode node = root;
        while (node.getRightChild() != null)
        {
            node = (BinarySearchTreeNode) node.getRightChild();
        }
        return (int) node.getElement();
    }

    private void setRoot(BinarySearchTreeNode node)
    {
        super.setRoot(node);
    }

    //it is rebalancing, but does not recognize the biggest number
    public void rebalance()
    {
        ArrayList<Integer> temp = inOrder();
        int lenght = temp.size();
        setRoot(rebalance(temp, 0, lenght - 1));
        root = rebalance(temp, 0, lenght - 1);
    }
    private BinarySearchTreeNode rebalance(ArrayList listOfElements, int start, int end)
    {
        if (start > end)
        {
            return null;
        }
        int middle = (start + end) / 2;
        BinarySearchTreeNode node = new BinarySearchTreeNode((Comparable) listOfElements.get(middle));
        node.addLeftChild(rebalance(listOfElements, start, middle - 1));
        node.addRightChild(rebalance(listOfElements, middle + 1, end));
        return node;
    }


}
