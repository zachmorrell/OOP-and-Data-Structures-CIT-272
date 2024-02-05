/*
 * This Class extends the Product class for SmartPhone objects.
 */
public class SmartPhone extends Product {

    // Encapsulated variables for this class.
    private String make = null;
    private String model = null;
    private int storageCapacity = -1;

    // Class Constructor.
    public SmartPhone(int productID, String name, String description, double price, String make, String model, int storageCapacity) {
        super(productID, name, description, price);

        this.make = make;
        this.model = model;
        this.storageCapacity = storageCapacity;
    }

    // Getters and Setters for the encapsulated variables.
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getStorageCapacity() {
        return storageCapacity;
    }
    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    // Override to add onto the superclass's toString method.
    @Override
    public String toString() {
        String result = super.toString();
        result += "\nmake: " + ((this.make != null) ? this.make:"not set.");
        result += "\nmodel: " + ((this.model != null) ? this.model:"not set.");
        result += "\nstorageCapacity: " + ((this.storageCapacity > -1) ? this.storageCapacity:"not set.");
        result += "\n==== END OF PRODUCT ====\n";
        return result;
    }
}