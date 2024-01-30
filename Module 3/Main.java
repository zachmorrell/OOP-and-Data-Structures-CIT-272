public class Main {
    public static void main(String[] args) {
        // Create (instantiate) a new DiceSet object.
        DiceSet diceSet = new DiceSet();
        // roll the dice.
        diceSet.roll();
        // print the DiceSet (this will automatically call toString()).
        System.out.println(diceSet.toString());
        // hold the first die.
        diceSet.hold(1);
        // hold the second die.
        diceSet.hold(2);
        // roll the dice.
        diceSet.roll();
        // hold the first die.
        diceSet.unHold(1);
        // hold the second die.
        diceSet.unHold(2);
        // unhold the third die.
        diceSet.hold(3);
        // print the diceset again.
        System.out.println(diceSet.toString());
    }
}