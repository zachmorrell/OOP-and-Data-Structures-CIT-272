public class BinaryTree<E extends Comparable<E>> {
    public TreeNode<E> root;

    public BinaryTree() {
        this.root = null;
    }
    
    public void insert(E data) {
        if(root == null && data != null) {
            root = new TreeNode<E>(data);
        } else {
            insert(root, data);
        }
    }

    public void insert(TreeNode<E> rootNode, E data) {
        TreeNode<E> temp = new TreeNode<E>(data);

        if(rootNode.getData().compareTo(data) > 0) {
            if(rootNode.getLeft() == null) {
                rootNode.setLeft(temp);
            } else {
                insert(rootNode.getLeft(), data);
            }

        } else {
            if(rootNode.getRight() == null) {
                rootNode.setRight(temp);
            } else {
                insert(rootNode.getRight(), data);
            }
        }
    }
    /*
     * Searches the binary tree based on value.
     *  returns false if the rootnode is null.
     *  returns true if a match is found.
     *  Goes left if the root node is greater than the data.
     *  Goes right if it is less than the data.
     */

    public boolean search(E query) {
        return search(root, query);
    }
    private boolean search(TreeNode<E> rootNode, E query) {

        if(rootNode == null) {
            return false;
        }
        int compare_value = query.compareTo(rootNode.getData());
        if(compare_value == 0) {
            return true;
        }
        if(compare_value < 0) {
            return search(rootNode.getLeft(), query);
        }
        return search(rootNode.getRight(), query);
    }

    /*
     * Recursive function used to print the Binary Tree.
     */

    public void print() {
        print(root);
    }

    private void print(TreeNode<E> rootNode) {
        if(rootNode == null) {
            return;
        }

        // Preorder Tree Traversal
        System.out.println(rootNode.getData());
        print(rootNode.getLeft());
        print(rootNode.getRight());

        // Inorder Tree Traversal
        print(rootNode.getLeft());
        System.out.println(rootNode.getData());
        print(rootNode.getRight());

        // Postorder Traversal
        print(rootNode.getLeft());
        print(rootNode.getRight());
        System.out.println(rootNode.getData());
    }
}
