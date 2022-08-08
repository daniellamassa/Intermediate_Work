/**
 * @Author Dani Massa
 *
 * I affirm that I have carried out the attached academic endeavors with full academic honesty,
 * in accordance with the Union College Honor Code and the course syllabus.
 *
 */

import java.util.Random;
public class Die {
    private int numberOfSides;
    private int currentValue;

    /**
     * constructor for a die object
     * @param newNumberOfSides indicates the number of sides the die should have.
     */
    public Die(int newNumberOfSides) {
        numberOfSides = newNumberOfSides;
        currentValue = newNumberOfSides;
    }

    public Die (){
        numberOfSides = 6;
        currentValue = 6;
    }

    /**
     * reassigns the current value property to be a new random number, from 1 to the number of sides.
     */
    public void roll(){
        Random randomInt = new Random ();
        this.currentValue = randomInt.nextInt(numberOfSides)+1;
    }

    /**
     * returns the value currently showing on the die
     * @return currentValue
     */
    public int getValue (){
        return currentValue;
    }

    public int getNumberOfSides (){
        return numberOfSides;
    }


    public String toString(){
        return this.getNumberOfSides() + " sided die showing " + this.getValue();
    }
}
