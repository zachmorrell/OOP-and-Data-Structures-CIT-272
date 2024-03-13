public class Stack<T>{
    private Node<T> top;

    public Stack(){
        // Initialize Node top to null.
        top = null;
    }

    public void push(T data){
        // Create a node using argument T data.  
        Node<T> new_node = new Node<>(data);
        // Set the next node equal to the current top.
        new_node.setNext(top);
        // Change current top to the new node.
        top = new_node;
    }

    public T pop(){
        // return null if stack is empty.
        if(isEmpty()) {
            return null;
        }

        // store the removed top data as a T variable.
        T removed_data = top.getData();
        // set top equal to the next_node.
        top = top.getNext();
        // Return the data, from the node, that was removed.
        return removed_data;
    }

    public T peek(){
        // return null if stack is null, else return top's data.
        return (top == null) ? null : top.getData();
    }

    public boolean isEmpty(){
        // return the logic of top == null as a boolean.
        return (top == null);
    }
}