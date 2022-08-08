package proj3; // do not erase. Gradescope expects this.
// defines the properties and behaviors of a deck of 52 playing cards.

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
public class Deck {
    private static final int CARD_VALUE_MIN = 2;
    private static final int CARD_VALUE_MAX = 14;
    private static final int DECK_VALUE_MAX = 52;

    private ArrayList<Card> deckContents;
    private Card newCard;
    private int nextToDeal;

    /**
     * constructor: makes a deck of 52 playing cards, un-shuffled.
     */
    public Deck() {
        nextToDeal = 0;
        deckContents = new ArrayList<Card>();
        for (int rank = CARD_VALUE_MIN; rank <= CARD_VALUE_MAX; rank++){
            for (String suit : Card.SUITS){
                newCard = new Card(rank, suit);
                deckContents.add(newCard);
            }
        }
    }

    /**
     * Shuffles only the remaining un-dealt cards in the deck by iterating through the ArrayList (excluding dealt cards).
     * For each index, the card at the index is swapped with another card from a random index.
     */
    public void shuffle(){
        ThreadLocalRandom randomInt = ThreadLocalRandom.current();
        for (int index = nextToDeal; index < this.size(); index++){
            Card card = deckContents.get(index);
            int randomIndex = randomInt.nextInt(index, this.size());
            Card card2 = deckContents.get(randomIndex);
            deckContents.set(randomIndex, card);
            deckContents.set(index, card2);

        }
    }

    /**
     * deals the next card in a given deck by returning it. If the deck is empty, returns null.
     * @return the next un-dealt card
     */
    public Card deal(){
        if (isDeckEmpty()){
            return null;
        }
        else {
            Card card = deckContents.get(nextToDeal);
            nextToDeal++;
            return card;
        }
    }

    /**
     * Given an int, deals that amount of cards from the deck by creating an ArrayList
     * containing the dealt cards. If the deck is empty, returns null.
     * @param cardsToDeal int that represents the number of desired cards to deal.
     * @return an ArrayList containing the card objects that were dealt.
     */
    public ArrayList<Card> deal(int cardsToDeal) {
        ArrayList<Card> hand = new ArrayList<Card>();
        if(isDeckEmpty()){
            return null;
        }
        else {
            for (int i = 0; i < cardsToDeal; i++) {
                Card card = deckContents.get(nextToDeal);
                hand.add(card);
                nextToDeal++;
            }
            return hand;
        }
    }

    /**
     * returns the number of un-dealt cards in the deck
     * @return the remaining amount of cards in a deck
     */
    public int size(){
        return DECK_VALUE_MAX - nextToDeal;
    }

    /**
     * returns true if deck is empty, and false if it is not.
     * @return boolean true or false
     */
    public Boolean isDeckEmpty(){
        if(this.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *  returns the deck to a state where all cards are un-dealt, not in a shuffled state.
     */
    public void gather(){
        nextToDeal = 0;
    }

    /**
     * returns a string version of all the un-dealt cards in the deck
     * @return remaining cards in the deck as a String
     */
    public String toString(){
        String toReturn = "DECK CONTENTS\n";
        for (int i = nextToDeal; i < deckContents.size(); i++){
            Card card = deckContents.get(i);
            toReturn += card +"\n";
        }
        return toReturn;
    }
}