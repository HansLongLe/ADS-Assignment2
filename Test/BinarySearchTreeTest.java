import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

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
        BinarySearchTreeNode sixth = new BinarySearchTreeNode(6);

        tree = new BinarySearchTree(forth);
        forth.addLeftChild(second);
        forth.addRightChild(fifth);
        second.addLeftChild(first);
        second.addRightChild(third);

        //wrong position to check rebalance
        third.addRightChild(sixth);


    }

    @Test
    void insert()
    {
    assertTrue(tree.insert(6));
    tree.insert(6);
    assertEquals(6, tree.getRoot().getRightChild().getRightChild().getElement());
    }

    @Test
    void removeElement()
    {
        assertTrue(tree.removeElement(3));
        tree.removeElement(2);
        assertEquals(3, tree.getRoot().getLeftChild().getElement());
    }

    @Test
    void  findMin(){
        assertEquals(1, tree.findMin());
    }

    @Test
    void  findMax(){
        assertEquals(5, tree.findMax());
    }

    @Test
    void rebalance()
    {
        tree.rebalance();
        assertEquals(3, tree.getRoot().getElement());
    }
}