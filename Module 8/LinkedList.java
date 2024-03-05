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
        }else{
            Node<T> cursor = head;
            while (cursor.getNext() != null){
                cursor = cursor.getNext();
            }
            cursor.setNext(temp);
        }
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

        Node<T> cursor = head;
        T removed_data;
        if(i == 0) {
            removed_data = cursor.getData();
            cursor = head.getNext();

        } else {

            int count = 0;
            Node<T> previous = head;
            while(count < i) {
                count++;
                previous = cursor;
                cursor = cursor.getNext();
            }
            removed_data = cursor.getData();

            // If the cursor.getNext isn't null, set previous next to cursor.getNext else null.
            previous.setNext(((cursor.getNext()!=null) ? cursor.getNext() : null));
        }
        return removed_data;
    }

    public T remove(T data){
        
        if (isEmpty()){
            return(null);
        }else if (head.getData().equals(data)){
            head = head.getNext();
            return(data);
        }else{
            Node<T> cursor = head.getNext();
            Node<T> previous = head;
            while (cursor != null){
                if (cursor.getData().equals(data)){
                    previous.setNext(cursor.getNext());
                    return(data);
                }
                cursor = cursor.getNext();
                previous = previous.getNext();
            }
            return(null);
        }
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
        return(-1);
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
            return;
        }
        Node<T> cursor = head;
        while (cursor!=null) {
            System.out.println(String.valueOf(index) + cursor.getData());
            cursor = cursor.getNext();
        }
    }

}
