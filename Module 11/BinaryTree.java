public class BinaryTree<T extends Comparable<T>> {
    public TreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }
    
    public void insert(T data) {
        if(root == null && data != null) {
            root = new TreeNode<T>(data);
        } else {
            insert(root, data);
        }
    }

    public void insert(TreeNode<T> rootNode, T data) {
        TreeNode<T> temp = new TreeNode<T>(data);

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

    public boolean search(T query) {
        return search(root, query);
    }
    private boolean search(TreeNode<T> rootNode, T query) {

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

    public void preOrderPrint() {
        System.out.println("=== Pre Order Print ==");
        preOrderPrint(root);
        System.out.println("======================");
    }
    public void inOrderPrint() {
        System.out.println("=== In Order Print ===");
        inOrderPrint(root);
        System.out.println("======================");
    }
    public void postOrderPrint() {
        System.out.println("== Post Order Print ==");
        postOrderPrint(root);
        System.out.println("======================");
    }

    private void preOrderPrint(TreeNode<T> rootNode) {
        if(rootNode == null) {
            return;
        }
        System.out.println(rootNode.getData());
        preOrderPrint(rootNode.getLeft());
        preOrderPrint(rootNode.getRight());
    }

    private void inOrderPrint(TreeNode<T> rootNode) {
        if(rootNode == null) {
            return;
        }
        inOrderPrint(rootNode.getLeft());
        System.out.println(rootNode.getData());
        inOrderPrint(rootNode.getRight());
    }

    private void postOrderPrint(TreeNode<T> rootNode) {
        if(rootNode == null) {
            return;
        }
        postOrderPrint(rootNode.getLeft());
        postOrderPrint(rootNode.getRight());
        System.out.println(rootNode.getData());
    }
}