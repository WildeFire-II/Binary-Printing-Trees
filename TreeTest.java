public class TreeTest {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        // Adding nodes to the tree
        int[] values = {50, 30, 20, 40, 70, 60, 80};
        for (int value : values) {
            tree.insertNode(value);
        }

        // Preorder traversal
        System.out.print("Preorder Traversal: ");
        tree.preorderTraversal();
        System.out.println();

        // Inorder traversal
        System.out.print("Inorder Traversal: ");
        tree.inorderTraversal();
        System.out.println();

        // Postorder traversal
        System.out.print("Postorder Traversal: ");
        tree.postorderTraversal();
        System.out.println();

        // Search for a node
        System.out.println("Searching for 40: " + (tree.search(40) ? "Found" : "Not Found"));
        System.out.println("Searching for 90: " + (tree.search(90) ? "Found" : "Not Found"));

        // Remove a node
        System.out.println("Removing 70");
        tree.remove(70);
        System.out.print("Inorder Traversal after removing 70: ");
        tree.inorderTraversal();
        System.out.println();

        // Output tree structure
        System.out.println("Tree structure:");
        tree.outputTree(0);
    }
}
