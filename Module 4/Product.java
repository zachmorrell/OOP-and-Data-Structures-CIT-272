/**
 * This class creates an object called Product.
 */
public class Product {

    // Encapsulated variables for this class.
    private int productID = -1;
    private String name = null;
    private String description = null;
    private double price = -1;

    // Class constructor or template for each product.
    public Product(int productID, String name, String description, double price) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    // When an Product.toString() is called, the variables of that object are formatted and returned.
    public String toString() {
        String result = "==== PRODUCT ====";
        result += "\nproductID: " + ((this.productID > -1) ? this.productID:"not set.");
        result += "\nname: " + ((name != null) ? this.name:"not set.");
        result += "\ndescription: " + ((description != null) ? this.description:"not set.");
        result += "\nprice: " + ((this.price > 0) ? this.price:"not set.");
        return result;
    }

    // Getters and setters to view and manipulate variables.
    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}