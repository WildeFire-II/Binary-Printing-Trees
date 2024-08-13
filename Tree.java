
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public Tree() {
        root = null;
    }

    public void insertNode(T insertValue) {
        if (root == null) {
            root = new TreeNode<>(insertValue);
        } else {
            root.insert(insertValue);
        }
    }

    public void preorderTraversal() {
        if (root == null) return;
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.pop();
            System.out.printf("%s ", node.data);
            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }
            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }
        }
    }

    public void inorderTraversal() {
        if (root == null) return;
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftNode;
            }
            current = stack.pop();
            System.out.printf("%s ", current.data);
            current = current.rightNode;
        }
    }

    public void postorderTraversal() {
        if (root == null) return;
        Stack<TreeNode<T>> stack1 = new Stack<>();
        Stack<TreeNode<T>> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode<T> node = stack1.pop();
            stack2.push(node);
            if (node.leftNode != null) {
                stack1.push(node.leftNode);
            }
            if (node.rightNode != null) {
                stack1.push(node.rightNode);
            }
        }
        while (!stack2.isEmpty()) {
            TreeNode<T> node = stack2.pop();
            System.out.printf("%s ", node.data);
        }
    }

    public boolean search(T value) {
        TreeNode<T> current = root;
        while (current != null) {
            int cmp = value.compareTo(current.data);
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                current = current.leftNode;
            } else {
                current = current.rightNode;
            }
        }
        return false;
    }

    public void remove(T value) {
        root = removeNode(root, value);
    }

    private TreeNode<T> removeNode(TreeNode<T> root, T value) {
        if (root == null) return null;

        int cmp = value.compareTo(root.data);
        if (cmp < 0) {
            root.leftNode = removeNode(root.leftNode, value);
        } else if (cmp > 0) {
            root.rightNode = removeNode(root.rightNode, value);
        } else {
            if (root.leftNode == null) return root.rightNode;
            if (root.rightNode == null) return root.leftNode;

            TreeNode<T> minNode = findMin(root.rightNode);
            root.data = minNode.data;
            root.rightNode = removeNode(root.rightNode, root.data);
        }
        return root;
    }

    private TreeNode<T> findMin(TreeNode<T> node) {
        while (node.leftNode != null) {
            node = node.leftNode;
        }
        return node;
    }

    public void outputTree(int totalSpace) {
        if (root == null) return;
        Queue<TreeNode<T>> nodes = new LinkedList<>();
        nodes.add(root);
        int depth = 0;
        while (!nodes.isEmpty()) {
            int count = nodes.size();
            for (int i = 0; i < count; i++) {
                TreeNode<T> currentNode = nodes.poll();
                if (currentNode != null) {
                    System.out.print(currentNode.data + " ");
                    nodes.add(currentNode.leftNode);
                    nodes.add(currentNode.rightNode);
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
            depth++;
        }
    }
}