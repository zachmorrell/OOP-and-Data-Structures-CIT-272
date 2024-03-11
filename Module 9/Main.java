public class Main {
    public static void main(String[] args) {
		testList();
        testStack();
        testQueue();
    }

		public static void testList(){
        LinkedList<String> names = new LinkedList<>();
        names.add("Luke");
        names.add("Leia");
        names.add("Han Solo");
        names.add("Spock");
        names.add("Obeewon");
        names.add("Seven of Nine");

        names.set(4, "Obi-Wan");
        if (names.get(4).equals("Obi-Wan")){
            System.out.println("Set and Get Passed");
        }

        names.remove("Spock");
        if (names.get(3).equals("Obi-Wan")){
            System.out.println("remove(Object) Passed");
        }
        if (names.indexOf("Obi-Wan") == 3){
            System.out.println("indexOf() Passed");
        }
        names.remove(4);

        if (names.contains("Luke")){
            System.out.println("contains() with existing element Passed");
        }
        if (!names.contains("Yoda")){
            System.out.println("contains() with non-existing element Passed");
        }

        names.clear();
        if (names.isEmpty()) {
            System.out.println("clear() and isEmpty() Passed");			 
		}		
	}

    public static void testStack(){
        Stack<String> myStack = new Stack<>();
		boolean emptyBefore, emptyAfter;
		emptyBefore = myStack.isEmpty();
        myStack.push("Luke");
		emptyAfter = myStack.isEmpty();

		if (emptyBefore && !emptyAfter){
			System.out.println("Stack.isEmpty() Passed");
		} else {
			System.out.println("Stack.isEmpty() FAILED");
		}

        myStack.push("Leia");
        myStack.push("Yoda");
        System.out.println(myStack.peek());

		if (myStack.peek() == "Yoda"){
			System.out.println("Stack.peek() Passed");
		} else {
			System.out.println("Stack.peek() FAILED");
		}

		if (myStack.pop() == "Yoda"){
			System.out.println("Stack.pop() Passed");
		} else {
			System.out.println("Stack.pop() FAILED");
		}

		myStack.pop();
		myStack.pop();

		if (myStack.pop() == null){
			System.out.println("Stack.pop() with empty Stack Passed");
		} else {
			System.out.println("Stack.pop() with empty Stack FAILED");
		}
    }

    public static void testQueue() {
        Queue<String> myQueue = new Queue<>();
		boolean emptyBefore, emptyAfter;
		emptyBefore = myQueue.isEmpty();
        myQueue.enqueue("Luke");
		emptyAfter = myQueue.isEmpty();

		if (emptyBefore && !emptyAfter){
			System.out.println("Queue.isEmpty() Passed");
		} else {
			System.out.println("Queue.isEmpty() FAILED");
		}

        myQueue.enqueue("Leia");
        myQueue.enqueue("Yoda");
        System.out.println(myQueue.look());

		if (myQueue.look() == "Luke"){
			System.out.println("Queue.look() Passed");
		} else {
			System.out.println("Queue.look() FAILED");
		}

		if (myQueue.dequeue() == "Luke"){ // dequeue Luke
			System.out.println("Queue.dequeue() Passed");
		} else {
			System.out.println("Queue.dequeue() FAILED");
		}

        System.out.println(myQueue.dequeue()); // dequeue Leia 
        System.out.println(myQueue.dequeue()); // dequeue Yoda

		if (myQueue.dequeue() == null){ // should be null now
			System.out.println("Queue.dequeue() empty Queue Passed");
		} else {
			System.out.println("Queue.dequeue() empty Queue FAILED");
		}
    }
}
