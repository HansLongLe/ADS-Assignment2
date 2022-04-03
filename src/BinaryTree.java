import java.util.ArrayList;

public class BinaryTree<E extends Comparable>
{
    private BinaryTreeNode root;
    private int size;
    private ArrayList<E> temp = new ArrayList<>();



    public BinaryTree()
    {
        root = new BinaryTreeNode();
    }

    public BinaryTreeNode getRoot()
    {
        return root;
    }

    public void setRoot(BinaryTreeNode root)
    {
        this.root = root;
    }

    public boolean isEmpty()
    {
        return root.getElement() == null;
    }

    public int getSize()
    {
        return setSize(root);
    }

    private int setSize(BinaryTreeNode node)
    {
        if (node == null)
        {
            size = 0;
            return size;
        }
        else
        {
            size = setSize(node.getLeftChild()) + 1 + setSize(node.getRightChild());
        }
        return size;
    }

    public boolean contains(BinaryTreeNode node)
    {
        return contains(root, node);
    }

    private boolean contains(BinaryTreeNode treeNode1, BinaryTreeNode treeNode2)
    {
        if (treeNode1 == null)
        {
            return false;
        }

        if (treeNode1.getElement() == treeNode2.getElement())
        {
            return true;
        }

        boolean node1 = contains(treeNode1.getLeftChild(), treeNode2);

        if (node1)
            return true;

        boolean node2 = contains(treeNode1.getRightChild(), treeNode2);
        if (node2)
        {
            return true;
        }
        return false;
    }

    private ArrayList<E> inOrder(BinaryTreeNode node)
    {
        if (node == null)
        {
            return null;
        }

        inOrder(node.getLeftChild());
        temp.add((E)node.getElement());
        inOrder(node.getRightChild());

        return temp;
    }

    public ArrayList<E> inOrder()
    {
        temp = new ArrayList<>();
        return inOrder(root);
    }

    private ArrayList<E> preOrder(BinaryTreeNode node)
    {
        if (node == null)
        {
            return null;
        }

        temp.add((E)node.getElement());
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());

        return temp;
    }

    public ArrayList<E> preOrder()
    {
        temp = new ArrayList<>();
        return preOrder(root);
    }

    private ArrayList<E> postOrder(BinaryTreeNode node)
    {
        if (node == null)
        {
            return null;
        }

        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        temp.add((E)node.getElement());

        return temp;
    }

    public ArrayList<E> postOrder()
    {
        temp = new ArrayList<>();
        return postOrder(root);
    }

    private boolean levelOrder(BinaryTreeNode node, int level)
    {
        if (node == null) {
            return false;
        }

        if (level == 1)
        {
            temp.add((E)node.getElement());
            return true;
        }

        boolean left = levelOrder(node.getLeftChild(), level - 1);
        boolean right = levelOrder(node.getRightChild(), level - 1);

        return left || right;
    }

    public ArrayList<E> levelOrder()
    {
        temp = new ArrayList<>();

        int level = 1;
        while (levelOrder(root,level))
        {
            level++;
        }
        return temp;
    }

    public int height(BinaryTreeNode node)
    {
        int left = 0;
        int right = 0;

        if (node == null)
        {
            return -1;
        }

        left = height(node.getLeftChild());
        left++;
        right = height(node.getRightChild());

        return Math.max(left, right);
    }

    public int height()
    {
        return height(root);
    }
}