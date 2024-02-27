public class Die {
    private int value;
    private boolean held = false;

    public Die(){
        this.roll();
    }

    public void roll(){
        value = randint(1,6);
    }

    public int getValue(){
        return(value);
    }

    // Returns the held attribute of the object.
    public boolean isHeld() {
        return(held);
    }

    // Sets the held attribute equal to the argument boolean.
    public void hold(boolean holdDie) {
        held = holdDie;
    }

    public static int randint(int min, int max){
        int result = (int)(Math.random() * (max - min + 1) + min);
        return(result);
    }
}
