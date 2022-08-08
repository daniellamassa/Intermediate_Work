package proj4;

import java.util.ArrayList;

public class StudPokerHand {
    private static final int HAND_VALUE_MAX = 2;
    private ArrayList<Card> handContents;
    private CommunityCardSet communityContents;

    /**
     * constructor: makes a stud hand (2 cards) and has access to the community card set.
     * @param cc
     * @param cardList
     */
    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList){
        handContents = cardList;
        communityContents = cc;
    }

    /**
     * Given a card object, adds the card to a stud hand. If the hand already has 2 cards in it, nothing happens.
     * @param card: a Card object
     */
    public void addCard(Card card) {
        if (handContents.size() < HAND_VALUE_MAX) {
            handContents.add(card);
        }
    }

    /**
     * Given an int index, returns the Card object at that index in the stud hand. Returns null if index is invalid.
     * @param index: an int representing the desired index
     * @return Card object, or null
     */
    public Card getIthCard(int index){
        if(index >= 0 && index < handContents.size()){
            Card card = handContents.get(index);
            return card;
        }
        else{
            return null;
        }
    }


    /**
     * private helper function for latter getBestFiveCardHand. Iterates through all possible 5 card hand options from a
     * stud poker hand and a community card set, and finds the best possible hand; uses recursion. Ignore print line
     * that is commented out, it was used during testing.
     * @param startingIndex: the beginning place (index) for iteration, initialized with zero.
     * @param hands: all possibilities for stud hand with community card set
     * @param bestSoFar: the best possible hand, what is going to be returned. Initialized as the first hand in hands
     * at index 0, and is changed throughout the method.
     * @return: the best possible 5 card hand, aka bestSoFar, once recursion is finished.
     */
    private PokerHand getBestFiveCardHand(int startingIndex, ArrayList<PokerHand> hands, PokerHand bestSoFar){
        if (startingIndex == hands.size()){
            return bestSoFar;
        } else{
            //System.out.println("best is: " + bestSoFar + "\n" + "starting index is " + hands.get(startingIndex)+"\n" + "index is " + startingIndex);
            if (hands.get(startingIndex).compareTo(bestSoFar)>0){
                bestSoFar = hands.get(startingIndex);
                startingIndex += 1;
                return getBestFiveCardHand(startingIndex, hands, bestSoFar);
            } else{
                startingIndex += 1;
                return getBestFiveCardHand(startingIndex, hands, bestSoFar);
            }
        }
    }

    /**
     * calls the private helper function getBestFiveCardHand, which iterates through all possible 5 card hand options
     * from a stud poker hand and a community card set, and finds the best possible hand. This function initializes
     * the parameters for the private helper function.
     * @return: the best possible 5 card hand, aka bestSoFar
     */
    public PokerHand getBestFiveCardHand() {
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(0);
        return getBestFiveCardHand(0, hands, bestSoFar);
    }


    /**
     * Creates an arraylist of Pokerhand objects. The arraylist contains all possible 5 hand option given a stud poker
     * hand and a community card set (21 total elements).
     * @return allFiveCardHands: an arraylist of 5 card pokerhands.
     */
    private ArrayList<PokerHand> getAllFiveCardHands (){
        int forLoopMax = 6;
        ArrayList<PokerHand> allFiveCardHands = new ArrayList<PokerHand>();
        for (int i = 0; i <= forLoopMax; i++){
            for (int j = i+1; j <= forLoopMax; j++){
                ArrayList<Card> allSevenCards = getAllSevenCards();
                allSevenCards.remove(j);
                allSevenCards.remove(i);
                PokerHand fiveCardHand = new PokerHand(allSevenCards);
               allFiveCardHands.add(fiveCardHand);
            }
        }
        return allFiveCardHands;
    }

    /**
     * private helper function for getAllFiveCardHands. Creates an arraylist of 7 card objects (contains the five
     * card community set, and the 2 card stud poker hand).
     * @return allSevenCards: arraylist containing all the cards from community set and stud hand.
     */
    private ArrayList<Card> getAllSevenCards (){
        ArrayList<Card> allSevenCards = new ArrayList<Card>();
        for (Card card : handContents){
           allSevenCards.add(card);
        }
        for (int i = 0; i < communityContents.size(); i++){
            Card card = communityContents.getIthCard(i);
            allSevenCards.add(card);
        }
        return allSevenCards;
    }

    /**
     * Determines how this hand compares to another hand, using the
     * community card set to determine the best 5-card hand it can
     * make. Returns positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(StudPokerHand other){
        PokerHand bestStudFive = this.getBestFiveCardHand();
        PokerHand bestOtherFive = other.getBestFiveCardHand();
        return bestStudFive.compareTo(bestOtherFive);
    }

    /**
     * returns a string version of all the cards in a stud poker hand, as well as the contents (cards) of the
     * community card set, with a header.
     * @return
     */
    public String toString(){
        String toReturn = "";
        for (int i = 0; i < handContents.size(); i++){
            Card card = handContents.get(i);
            toReturn += (card + ", ");
        }
        toReturn += ("\n" + communityContents);
        return toReturn;
    }
}
