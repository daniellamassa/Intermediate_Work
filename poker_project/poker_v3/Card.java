package proj3; // do not erase. Gradescope expects this.
// defines the properties and behaviors of a single playing card.

public class Card {
        public static final String[] SUITS = {"Spades", "Hearts", "Clubs", "Diamonds"};

        private int[] contents;

        /**
         * constructor: makes a card using given rank (int) and suit (String)
         * @param newRank int from 2-14 (14 is Ace)
         * @param newSuit String either "Hearts", "Clubs", "Spades", "Diamonds"
         */
        public Card(int newRank, String newSuit) {
            contents = new int[2];
            contents[0] = newRank;
            contents[1] = suitStringToInt(newSuit);
        }

        /**
         * constructor: makes a card using given rank (int) and suit (int)
         * @param newRank int from 2-14 (14 is Ace)
         * @param newSuit into from 0-3 where Spades = 0, Hearts = 1, Clubs = 2, Diamonds = 3
         */
        public Card(int newRank, int newSuit){
            contents = new int[2];
            contents[0] = newRank;
            contents[1] = newSuit;
        }

        /**
         * getter for the card's rank
         * @return int from 2-14 (14 is Ace)
         */
        public int getRank() {
            return contents[0];
        }

        /**
         * getter for the card's suit
         * @return suit written out as string
         */
        public String getSuit() {
            return Card.SUITS[contents[1]];
        }

    /**
     * helper method to convert numeric rank to string
     * @return rank string like "4" or "Jack"
     */
    private String getRankAsString() {
        int rank = this.getRank();
        if (rank == 11) {
            return "Jack";
        }
        else if (rank == 12) {
            return "Queen";
        }
        else if (rank == 13) {
            return "King";
        }
        else if (rank == 14) {
            return "Ace";
        }
        else {
            return "" + rank;
        }
    }

    /**
     *  helper method to convert suit in String format to int format
     * @param suitString suit such as "Spades" or "Diamonds"
     * @return int for suit: Spades = 0, Hearts = 1, Clubs = 2, Diamonds = 3. Returns -1 if suit is invalid
     */
    private int suitStringToInt(String suitString){
        int index = 0;
        boolean found = false;
        while (!found && index < SUITS.length) {
            if (suitString.equals(SUITS[index])){
                found = true;
            }
            else {
                index++;
            }
        }
        if (found) {
            return index;
        }
        else {
            return -1; // invalid suit
        }
    }

    /**
         * return a string version of the Card
         * @return card showing rank and suit
         */
        public String toString() {
            return getRankAsString() + " of " + getSuit();
        }

}
