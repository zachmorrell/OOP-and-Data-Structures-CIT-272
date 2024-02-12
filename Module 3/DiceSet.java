public class DiceSet {
    private Die die1;
    // Add four more dice
    private Die die2;
    private Die die3;
    private Die die4;
    private Die die5;

    // instantiate the die to the dice array.
    public DiceSet(){
        die1 = new Die();
        die2 = new Die();
        die3 = new Die();
        die4 = new Die();
        die5 = new Die();
    }

    // Add methods

    // Each unheld die will roll.
    public void roll() {
        if(!die1.isHeld()) {
            die1.roll();
        }
        if(!die2.isHeld()) {
            die2.roll();
        }
        if(!die3.isHeld()) {
            die3.roll();
        }
        if(!die4.isHeld()) {
            die4.roll();
        }
        if(!die5.isHeld()) {
            die5.roll();
        }
    }

    // sets the die held attribute to true.
    public void hold(int die) {
        switch (die) {
            case 1:
                die1.hold(true);
                break;
            case 2:
                die2.hold(true);
                break;
            case 3:
                die3.hold(true);
                break;
            case 4:
                die4.hold(true);
                break;
            case 5:
                die5.hold(true);
                break;
        
            default:
                System.out.println("This is an invalid die number, try a number from 1-6");
                break;
        }
    }

    // sets the die held attribute to false.
    public void unHold(int die) {
        switch (die) {
            case 1:
                die1.hold(false);
                break;
            case 2:
                die2.hold(false);
                break;
            case 3:
                die3.hold(false);
                break;
            case 4:
                die4.hold(false);
                break;
            case 5:
                die5.hold(false);
                break;
        
            default:
                System.out.println("This is an invalid die number, try a number from 1-6");
                break;
        }
    }

    // Creates a return string that is easy to read to print the diceset.
    public String toString() {
        String _string = "";
        _string += "Die 1: " + die1.getValue() + ", held: " + die1.isHeld() + "\n";
        _string += "Die 2: " + die2.getValue() + ", held: " + die2.isHeld() + "\n";
        _string += "Die 3: " + die3.getValue() + ", held: " + die3.isHeld() + "\n";
        _string += "Die 4: " + die4.getValue() + ", held: " + die4.isHeld() + "\n";
        _string += "Die 5: " + die5.getValue() + ", held: " + die5.isHeld() + "\n";
        return(_string);
    }
}