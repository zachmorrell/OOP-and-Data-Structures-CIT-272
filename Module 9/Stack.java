// The Stack will not need to use the double link

public class Stack<T>{
    private Node<T> top;

    public Stack(){
        top = null; // What should top be initialized to?
    }

    // Replace ??? with the proper return type
    // Add parameters with valid types, if necessary
    public T push(T data){
        // Create new node with provided data parameter
        // Set new Node's next to current top
        // Set top to new Node
        top = new Node<>(data);
        return top.getData();
    }

    // Replace ??? with the proper return type
    // Add parameters with valid types, if necessary
    public T pop(){
        // if stack is empty
        //      return null
        // else
        //      Get data from top Node, assign to variable
        //      Move top to top's next pointer
        //      return the data
        if(top == null) {
            return null;
        }
        T removed_data = top.getData();
        top = top.getNext();
        return removed_data;
    }

    // Replace ??? with the proper return type
    // Add parameters with valid types, if necessary
    public T peek(){
         // if stack is empty
        //      return null
        // else
        //      Get data from top Node, assign to variable
        //      return the data
        if(top == null) {
            return null;
        }
        T data = top.getData();
        return data;
    }

    // Replace ??? with the proper return type
    // Add parameters with valid types, if necessary
    public boolean isEmpty(){
        // if stack is empty
        //      return true
        //  else
        //      return false
        return (top == null);
    }
}
