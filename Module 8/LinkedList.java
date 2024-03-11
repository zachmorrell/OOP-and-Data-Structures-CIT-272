public class LinkedList<T> {
    private Node<T> head;

    public LinkedList(){
        head = null;
    }

    public boolean isEmpty(){
        return(head == null);
    }

    public void add(T data){
        Node<T> temp = new Node<>(data);
        if (head == null){
            head = temp;
            return;
        }
        Node<T> cursor = head;
        while (cursor.getNext() != null){
            cursor = cursor.getNext();
        }
        cursor.setNext(temp);
    }

    public T get(int i){
        if (isEmpty()){
            return(null);
        }
        if(i>=this.size() || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        Node<T> cursor = head;
        while (count < i){
            count++;
            cursor = cursor.getNext();
        }
        return(cursor.getData());
    }

    public void set(int i, T data){
        // TODO: Module 8 Exercise
        // identical to get() except instead of returning data
        // you set the data to the parameter
        if(i >= this.size() || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        Node<T> cursor = head;
        while(count < i) {
            count++;
            cursor = cursor.getNext();
        }
        cursor.setData(data);
    }

    public T remove(int i){
        // TODO: Module 8 Exercise
        // if list is empty, return null
        // see other remove() method for hints
        if(isEmpty()) {
            return null;
        }
        if(i >= this.size() || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> cursor = head;
        T removed_data;
        int count = 0;
        while(count < i-1) {
            if(cursor==null) {
                return null;
            }
            cursor = cursor.getNext();
            count++;
        }
        removed_data = cursor.getData();
        // If the cursor.getNext isn't null, set previous next to cursor.getNext else null.
        cursor.setNext(((cursor.getNext().getNext()!=null) ? cursor.getNext().getNext() : null));
        return removed_data;
    }

    public T remove(T data){
        if(isEmpty()) {
            return null;
        }
        Node<T> cursor = head;
        Node<T> previous = cursor;
        while (!cursor.getData().equals(data)) {
            if(cursor.getData() == null) {
                return(null);
            }
            previous = cursor;
            cursor = cursor.getNext();
        }
        previous.setNext(cursor.getNext());
        return data;
    }

    public boolean contains(T data){
        // TODO: Module 8 Exercise
        // very similar to remove() but you just return true if you find it
        // false otherwise
        Node<T> cursor = head;
        while(!cursor.getData().equals(data) && cursor.getNext() != null) {
            cursor = cursor.getNext();
        }
        return cursor.getData().equals(data);
    }

    public int indexOf(T data){
        // TODO: Module 8 Exercise
        // identical to contains(), but you return the index where it was found
        //  returns -1 if it is not found
        //  use a counter variable
        int count = 0;
        Node<T> cursor = head;
        while(cursor!=null) {
            if(cursor.getData().equals(data)) {
                return count;
            }
            count++;
            cursor = cursor.getNext();         
        }
        return -1;
    }

    public void clear(){
        // TODO: Module 8 Exercise
        head = null;
    }

    public int size(){
        // TODO: Module 8 Exercise
        // see the get(int) method
        Node<T> cursor = head;
        int count = 0;
        while(cursor != null) {
            count++;
            cursor = cursor.getNext();
        }
        return count;
    }

    public String toString(){
        // TODO: Module 8 
        // Similar to size(), but with accumulating the string
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