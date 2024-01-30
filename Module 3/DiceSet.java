public class DiceSet {
    //private Die die1, die2, die3, die4, die5;
    // Add four more dice
    private Die[] dice = new Die[5];

    // instantiate the die to the dice array.
    public DiceSet(){
        //die1 = new Die();
        // Fill in code to create the rest of the die objects
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
        }
    }

    // Add methods

    // Each unheld die will roll.
    public void roll() {
        for (Die die : dice) {
            if(!die.isHeld()) {
                die.roll();
            }
        }
    }

    // sets the die held attribute to true.
    public void hold(int die) {
        dice[(die-1)].hold(true);
    }

    // sets the die held attribute to false.
    public void unHold(int die) {
        dice[(die-1)].hold(false);
    }

    // Creates a return string that is easy to read to print the diceset.
    public String toString() {
        String _string = "";
        int position = 1;
        for (Die die : dice) {
            _string += "Dice " + position + ": " + die.getValue() + ", held: " + die.isHeld() + "\n";
            position++;
        }
        return(_string);
    }
}