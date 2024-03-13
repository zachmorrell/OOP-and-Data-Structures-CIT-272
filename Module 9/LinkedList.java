public class LinkedList<T> {
    private Node<T> head;
    private int length;

    public LinkedList(){
        // Initialize node head to null.
        head = null;
        // Initialize int length to 0.
        length = 0;
    }

    public boolean isEmpty(){
        // Return the logic of head == null.
        return(head == null);
    }

    public void add(T data){
        Node<T> temp = new Node<>(data);
        if (head == null){
            head = temp;
        } else {
            Node<T> cursor = head;
            while (cursor.getNext() != null){
                cursor = cursor.getNext();
            }
            cursor.setNext(temp);
            // Add the reverse link
            temp.setPrevious(cursor);
        }
        length++;
    }

    public T get(int i){
        if (isEmpty()){
            return(null);
        }else{
            int count = 0;
            Node<T> cursor = head;
            while (count < i){
                count++;
                cursor = cursor.getNext();
            }
            return(cursor.getData());
        }
    }

    public void set(int i, T data){
        // TODO: Module 8 Exercise
        // identical to get() except instead of returning data
        // you set the data to the parametetr
        if(i < 0 || length < i) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        Node<T> cursor = head;
        while(count < i) {
            cursor = cursor.getNext();
            count++;
        }
        cursor.setData(data);
    }

    public T remove(int i) {
        if (isEmpty()) {
            return null;
        }
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0) {
            T removedData = head.getData();
            head = head.getNext();
            if (head != null) {
                head.setPrevious(null);
            }
            length--;
            return removedData;
        }
        int counter = 0;
        Node<T> cursor = head;
        while (counter < i) {
            cursor = cursor.getNext();
            counter++;
        }
        Node<T> previous_node = cursor.getPrevious();
        Node<T> next_node = cursor.getNext();
        previous_node.setNext(next_node);
        if (next_node != null) {
            next_node.setPrevious(previous_node);
        }
        length--;
        return cursor.getData();
    }

    public T remove(T data){
        if(isEmpty() || data == null) {
            return null;
        }
        Node<T> cursor = head;
        while (cursor != null) {
            if(cursor.getData().equals(data)) {
                Node<T> previous_node = cursor.getPrevious();
                Node<T> next_node = cursor.getNext();
                previous_node.setNext(next_node);
                if(next_node != null) {
                    next_node.setPrevious(previous_node);
                }
                return data;
            }
            cursor = cursor.getNext();
        }
        return null;
    }

    public boolean contains(T data){
        if(head == null) {
            return false;
        }
        Node<T> cursor = head;
        while (cursor != null) {
            if(cursor.getData().equals(data)) {
                return true;
            }
            cursor = cursor.getNext();
        }
        return(false);
    }

    public int indexOf(T data){
        if(isEmpty()) {
            return -1;
        }
        Node<T> cursor = head;
        int count = 0;
        while (cursor.getData() != null) {
            if(cursor.getData() == data) {
                return count;
            }
            cursor = cursor.getNext();
            count++;
        }
        return(-1);
    }

    public void clear(){
        // Clear list by setting head = null;
        head = null;
    }

    public int size(){
        // returns the int value of the length of the list.
        return length;
    }

    public String toString(){
        // If list is empty, return "List is empty.".
        if(isEmpty()) {
            return "List is empty.";
        }
        String output = "";
        Node<T> cursor = head;
        int index = 0;
        while (cursor != null) {
            output += "Node: " + index + ", Data: " + cursor.getData() + "\n";
            cursor = cursor.getNext();
            index++;
        }
        return output;
    }

    public void printList(int index) {
        if(head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node<T> cursor = head;
        while (cursor!=null) {
            System.out.println(String.valueOf(index) + cursor.getData());
            cursor = cursor.getNext();
        }
    }
}