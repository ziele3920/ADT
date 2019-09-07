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

        TreeNode parentNode = findParent(nodeToDelete, root);

        List<TreeNode> children = new ArrayList();
        getChildren(nodeToDelete, children);
        if(parentNode.getRight() != null && nodeToDelete.getValue() == parentNode.getRight().getValue())
            parentNode.setRight(null);
        else if(parentNode.getLeft() != null)
            parentNode.setLeft(null);
        for (TreeNode node:children)
            this.add(node.getValue());
    }

    private TreeNode findParent(TreeNode childNode, TreeNode tmpNode) {
        if(tmpNode == null)
            return null;
        if(tmpNode.getLeft() != null && childNode.getValue() == tmpNode.getLeft().getValue())
            return tmpNode;
        if(tmpNode.getRight() != null && childNode.getValue() == tmpNode.getRight().getValue())
            return tmpNode;
        if(childNode.getValue() < tmpNode.getValue())
            return findParent(childNode, tmpNode.getLeft());
        if(childNode.getValue() > tmpNode.getValue())
            return findParent(childNode, tmpNode.getRight());
        return null;
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
