import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode<T extends Comparable<T>> {
    TreeNode<T> leftNode; // left node
    T data; // node value
    TreeNode<T> rightNode; // right node

    public TreeNode(T nodeData) {
        data = nodeData;
        leftNode = rightNode = null; // node has no children
    }

    public void insert(T insertValue) {
        if (insertValue.compareTo(data) < 0) {
            if (leftNode == null) {
                leftNode = new TreeNode<>(insertValue);
            } else {
                leftNode.insert(insertValue);
            }
        } else if (insertValue.compareTo(data) > 0) {
            if (rightNode == null) {
                rightNode = new TreeNode<>(insertValue);
            } else {
                rightNode.insert(insertValue);
            }
        }
    }
}