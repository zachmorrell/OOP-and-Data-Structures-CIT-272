public class DiceSet {
    Die[] dice = new Die[5];

    // instantiate the die to the dice array.
    public DiceSet(){
        for(int i = 0; i<dice.length; i++){
            dice[i] = new Die();
        }
    }

    // Each unheld die will roll.
    public void roll() {
        for(Die die : dice){
            if(!die.isHeld()){
                die.roll();
            }
        }
    }

    // sets the die held attribute to true.
    public void hold(int die) {
        dice[die-1].hold(true);
    }

    // sets the die held attribute to false.
    public void unHold(int die) {
        dice[die-1].hold(false);
    }

    // Creates a return string that is easy to read to print the diceset.
    public String toString() {
        String formatted_string = "";
        for(int i = 0; i < dice.length; i++) {
            formatted_string += "\nDice "+(i+1)+ ": " +dice[i].getValue()+", held: "+dice[i].isHeld();
        }
        return(formatted_string);
    } 
}