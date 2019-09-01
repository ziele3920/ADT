package Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private TreeNode root;
    private int size;

    public Tree(){}
    public Tree(int [] table) {
        for (int val:table)
            add(val);
    }

    public void remove(int value) {
        if(root == null) return;
        TreeNode nodeToDelete = findNodeByValue(root, value);
        if(nodeToDelete == null) return;

        List children = new ArrayList();
        getChildren(nodeToDelete, children);
        nodeToDelete = null;
    }

    private void getChildren(TreeNode parentNode, List children) {
        if(parentNode.getLeft() != null) {
            children.add(parentNode.getLeft());
            getChildren(parentNode.getLeft(), children);
        }
        if(parentNode.getRight() != null) {
            children.add(parentNode.getRight());
            getChildren(parentNode.getRight(), children);
        }
    }

    public boolean search(int value) {
        if(root == null)
            return false;
        TreeNode tmpNode = root;
        return findNodeByValue(tmpNode, value) == null ? false : true;
    }

    private TreeNode findNodeByValue(TreeNode tmpNode, int value) {
        if(tmpNode == null)
            return null;
        if(tmpNode.getValue() == value)
            return tmpNode;
        if(value < tmpNode.getValue())
            return findNodeByValue(tmpNode.getLeft(), value);
        if(value > tmpNode.getValue())
            return findNodeByValue(tmpNode.getRight(), value);
        return null;
    }

    public void add(int value) {
        TreeNode newNode = new TreeNode(value);
        TreeNode tmpNode = root;
        if(root == null) {
            root = newNode;
            return;
        }
        size = insertNode(newNode, tmpNode) ? ++size : size;
    }

    private boolean insertNode(TreeNode newNode, TreeNode tmpNode) {
        if(newNode.getValue() < tmpNode.getValue()) {
            if (tmpNode.getLeft() == null) {
                tmpNode.setLeft(newNode);
                return true;
            }
            else {
                tmpNode = tmpNode.getLeft();
                insertNode(newNode, tmpNode);
            }
        }
        else if (newNode.getValue() > tmpNode.getValue()) {
            if(tmpNode.getRight() == null) {
                tmpNode.setRight(newNode);
                return true;
            }
            else {
                tmpNode = tmpNode.getRight();
                insertNode(newNode, tmpNode);
            }
        }
        return false;
    }
}
