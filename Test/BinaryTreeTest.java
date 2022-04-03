import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest
{
  BinaryTree tree;

  @BeforeEach
      void setUp()
  {
    tree = new BinaryTree();
    BinaryTreeNode first = new BinaryTreeNode(1);
    BinaryTreeNode second = new BinaryTreeNode(2);
    BinaryTreeNode third = new BinaryTreeNode(3);
    BinaryTreeNode forth = new BinaryTreeNode(4);
    BinaryTreeNode fifth = new BinaryTreeNode(5);


    tree.setRoot(forth);
    forth.addLeftChild(second);
    forth.addRightChild(fifth);
    second.addLeftChild(first);
    second.addRightChild(third);
  }

  @Test void getSize()
  {
    assertEquals(5,tree.getSize());
  }

  @Test void contains()
  {
    BinaryTreeNode test = new BinaryTreeNode(4);
    assertTrue(tree.contains(test));
  }

  @Test void inOrder()
  {
    ArrayList<Integer> expect = new ArrayList<>();
    expect.add(1);
    expect.add(2);
    expect.add(3);
    expect.add(4);
    expect.add(5);
    assertEquals(expect,tree.inOrder());
  }

  @Test void preOrder()
  {
    ArrayList<Integer> expect = new ArrayList<>();
    expect.add(4);
    expect.add(2);
    expect.add(1);
    expect.add(3);
    expect.add(5);
    assertEquals(expect,tree.preOrder());
  }

  @Test void postOrder()
  {
    ArrayList<Integer> expect = new ArrayList<>();
    expect.add(1);
    expect.add(3);
    expect.add(2);
    expect.add(5);
    expect.add(4);
    assertEquals(expect,tree.postOrder());
  }

  @Test void levelOrder()
  {
    ArrayList<Integer> expect = new ArrayList<>();
    expect.add(4);
    expect.add(2);
    expect.add(5);
    expect.add(1);
    expect.add(3);
    assertEquals(expect,tree.levelOrder());
  }

  @Test void height()
  {
    assertEquals(2,tree.height());
  }

  @Test void isEmpty()
  {
    assertFalse(tree.isEmpty());
  }
}