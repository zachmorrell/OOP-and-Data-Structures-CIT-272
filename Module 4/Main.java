public class Main {

    public static void main(String[] args) {
        // Instantiates a Book
        Book javaScriptBook = new Book(5399, "JavaScript and Jquery book", "Interactive front-end web development",
         39.99, "JAVASCRIPT & JQUERY", "Jon Ducket", "Education", 621, 2014);
        // Instantiates a SmartPhone
        SmartPhone onePlus11Phone = new SmartPhone(4253, "One Plus 11 5G", 
        "Smart Phone Produced by One Plus", 799.99, "OnePlus", "11 5G", 
        256);
        // Prints the results
        System.out.println(javaScriptBook.toString());
        System.out.println(onePlus11Phone.toString());
    }
}