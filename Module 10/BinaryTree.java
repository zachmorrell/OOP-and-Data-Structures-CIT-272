public class BinaryTree<E extends Comparable<E>> {
    public TreeNode<E> root;

    public BinaryTree() {
        this.root = null;
    }
    
    public void insert(E data) {
        if(data != null) {
            TreeNode<E> temp = new TreeNode<>(data);
            root = temp;
        }else {
            insert(root, data);
        }
    }

    /*
     * Recursion to find an empty node based on data size.
     * If root data is greater than new data place left if empty or more left.
     * If root data is less than the new data place it right if empty or more right.
     * Continue until the data is placed.
     */
    private void insert(TreeNode<E> treeRoot, E data) {
        TreeNode<E> temp = new TreeNode<>(data);
        // If new data is less than root - LEFT
        if(root.getData().compareTo(data) == -1) {
            // If left is null, place the temp data.
            if(treeRoot.getLeft() == null) {
                treeRoot.setLeft(temp);
            } else {
                // Else recursion to go left and try again.
                insert(treeRoot.getLeft(), data);
            }
        } else {
            // Else data is greater than root.
            // If root right is null, place data right.
            if(treeRoot.getRight() == null) {
                treeRoot.setRight(temp);
            } else {
                // Else recursion to go right and try again.
                insert(treeRoot.getRight(), data);
            }
        }       

    }
}
