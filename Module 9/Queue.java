
public class Queue<T> {
    private Node<T> rear;
    private Node<T> front;
    
    public Queue(){
        rear = null; // what should end be initialized to?
        front = null; // what should end be initialized to?
    }

    // Replace ??? with the proper return type
    // Add parameters with valid types, if necessary
    public T enqueue(T data){
		// TODO
		// add item to rear of the queue
        Node<T> new_rear = new Node<>(data);
        if(front == null) {
            front = new_rear;
            rear = new_rear;
        } else {
            rear.setNext(new_rear);
            rear = new_rear;
        }
        return rear.getData();
    }

    // Replace ??? with the proper return type
    // Add parameters with valid types, if necessary
    public T dequeue(){
		// TODO
		// remove item from front of queue and return the data
		//
        // if Queue is empty
        //      return null
        // if it has only one item
        //
        // else
		//
        if(front == null) {
            return null;
        }
        Node<T> first_item = front;
        front = front.getNext();
        if(front == null) {
            rear = null;
        }
        return first_item.getData();
    }

    // Replace ??? with the proper return type
    // Add parameters with valid types, if necessary
    public T look(){
			  // TODO
			  // display data at front of queue
        // if Queue is empty
        //       return null
        return (front != null) ? front.getData() : null;
    }

    // Replace ??? with the proper return type
    // Add parameters with valid types, if necessary
    public void clear(){
        // TODO
        front = null;
        rear = null;
    }

    // Replace ??? with the proper return type
    // Add parameters with valid types, if necessary
    public boolean isEmpty(){
        // TODO
        return front == null;
    }
}
