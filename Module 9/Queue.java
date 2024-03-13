
public class Queue<T> {
    private Node<T> rear, front;
    
    public Queue(){
        // Initialize rear and front as null.
        rear = null; 
        front = null;
    }

    public void enqueue(T data){
		// Defines a new node based on argument data.
        Node<T> new_rear = new Node<>(data);
        // If the list is empty, add it to the front and rear of the list.
        if(front == null) {
            front = new_rear;
            rear = new_rear;
            // Escape from or end the method.
            return;
        }
        // Old rears next = new rear node.
        rear.setNext(new_rear);
        // set current rear = new_rear node.
        rear = new_rear;
    }

    public T dequeue(){
        // If list is emppty return null.
        if(isEmpty()) { return null; }
        // Node to return the first node.
        Node<T> dequeued_node = front;
        // Move front node to the next node in queue.
        front = front.getNext();
        // Return the data of the dequeued node.
        return dequeued_node.getData();
    }

    public T look(){
        // If front is not null return it's data, else return null.
        return (front != null) ? front.getData() : null;
    }

    public void clear(){
        // Clear list by setting front and rear to null.
        front = null;
        rear = null;
    }

    public boolean isEmpty(){
        // Return the logic of: if front == null.
        return front == null;
    }
}