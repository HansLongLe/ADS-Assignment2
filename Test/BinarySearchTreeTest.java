import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree tree;

    @BeforeEach
    void setUp() {
        BinarySearchTreeNode first = new BinarySearchTreeNode(1);
        BinarySearchTreeNode second = new BinarySearchTreeNode(2);
        BinarySearchTreeNode third = new BinarySearchTreeNode(3);
        BinarySearchTreeNode forth = new BinarySearchTreeNode(4);
        BinarySearchTreeNode fifth = new BinarySearchTreeNode(5);

        tree = new BinarySearchTree(forth);
        forth.addLeftChild(second);
        forth.addRightChild(fifth);
        second.addLeftChild(first);
        second.addRightChild(third);
    }

    @Test
    void insert()
    {
        assertTrue(tree.insert(6));
    }
}