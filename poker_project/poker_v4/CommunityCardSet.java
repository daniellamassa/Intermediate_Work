package proj4;
// defines the properties and behaviors of a community card set (hand) of 5 cards.
import java.util.ArrayList;

public class CommunityCardSet {
    private static final int HAND_VALUE_MAX = 5;
    private ArrayList<Card> handContents;

        /**
         * constructor: makes a community hand of cards.
         * @param cardList: the list of cards that should be in the community hand.
         */
        public CommunityCardSet(ArrayList<Card> cardList){
            handContents = cardList;
        }

        /**
         * Given a card object, adds the card to the community hand. If the community set is full, nothing happens.
         * @param card: a Card object
         */
        public void addCard(Card card) {
            if (handContents.size() < HAND_VALUE_MAX) {
                handContents.add(card);
            }
        }

        /**
         * returns the size of the community card set.
         * @return the number of cards in the community card set
         */
        public int size(){
                return handContents.size();
            }

        /**
         * Given an int index, returns the Card object at that index in the community set. Returns null if index is invalid.
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
         * returns a string version of all the cards in the community cards set, with a header.
         * @return the Card objects in the community hand as a String
         */
        public String toString(){
            String toReturn = "The community cards are: |";
            for (int i = 0; i < handContents.size(); i++){
                Card card = handContents.get(i);
                toReturn += (card + "| ");
            }
            return toReturn;
        }
}
