package proj4; // do not erase. Gradescope expects this.
// defines the properties and behaviors of a poker hand. Specifically, compares two poker hands to each other.

import java.util.*;

public class PokerHand {
    private static final int HAND_VALUE_MAX = 5;
    private ArrayList<Card> handContents;

    /**
     * constructor: makes a hand of cards.
     * @param cardList: the list of cards that should be in the hand
     */
    public PokerHand(ArrayList<Card> cardList){
        handContents = cardList;
    }

    /**
     * Given a card object, adds the card to a hand. If the hand already has 5 cards in it, nothing happens.
     * @param card: a Card object
     */
    public void addCard(Card card) {
        if (handContents.size() < HAND_VALUE_MAX) {
            handContents.add(card);
        }
    }

    /**
     * Given an int index, returns the Card object at that index. Returns null if index is invalid.
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
     * given a hand, returns a list of all its cards' ranks
     * @return list of rank values
     */
    private ArrayList rankList(){
        ArrayList<Integer> rankList = new ArrayList<Integer>();
        for (Card card: handContents){
            rankList.add(card.getRank());
        }
        return rankList;
    }

    /**
     * given a hand, returns a list of all its cards' ranks, in descending order
     * @return: the sorted list of ranks
     */
    private ArrayList sortedRankList(){
        ArrayList<Integer> sortedList = this.rankList();
        sortedList.sort(Comparator.reverseOrder());
        return sortedList;
    }

    /**
     * given a hand, returns a set of all its cards' ranks, in descending order. (removes duplicates from a hand's
     * sorted ranks list)
     * @return a Set of sorted ranks
     */
    private Set setOfRanksList() {
        Set<Integer> rankListSet = new HashSet<Integer>();
        ArrayList<Integer> rankList = this.sortedRankList();
        for (Integer rank: rankList) {
            rankListSet.add(rank);
        }
        return rankListSet;
    }

    /**
     * given a hand, returns a list of all its cards' suits
     * @return list of suit values
     */
    private ArrayList suitList(){
        ArrayList<String> suitList = new ArrayList<String>();
        for (Card card: handContents){
            suitList.add(card.getSuit());
        }
        return suitList;
    }

    /**
     * given a hand, returns a set of all its cards' suits (removes duplicates from a hand's suit list)
     * @return a Set of suits
     */
    private Set setOfSuitsList() {
        Set<String> suitListSet = new HashSet<String>();
        ArrayList<String> suitList = this.suitList();
        for (String suit: suitList) {
            suitListSet.add(suit);
        }
        return suitListSet;
    }

    /**
     * tests to see whether or not a hand qualifies as a flush.
     * @return Boolean true or false
     */
    public Boolean isFlush(){
        if(this.setOfSuitsList().size() == 1){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * tests to see whether or not a hand qualifies as a pair.
     * @return Boolean true or false
     */
    public Boolean isPair(){
        if(this.setOfRanksList().size() == HAND_VALUE_MAX-1){
            return true;
        }
        else if (this.setOfRanksList().size() == HAND_VALUE_MAX-2){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * tests to see whether or not a hand qualifies as a four of a kind.
     * @return Boolean true or false
     */
    public Boolean isFourOfAKind(){
        if (this.setOfRanksList().size() == HAND_VALUE_MAX-3){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * tests to see whether or not a hand qualifies as a two pair.
     * @return Boolean true or false
     */
    public Boolean isTwoPair() {
        ArrayList<Integer> twoPairList = new ArrayList<Integer>();
        Set setRankList = this.setOfRanksList();
        ArrayList<Integer> rankList = this.rankList();
        for (Object rank: setRankList) {
            int count = Collections.frequency(rankList, rank);
            if (count >= 2) {
                twoPairList.add(count);
            }
        }
        if (twoPairList.size() == 2) {
            return true;
        } else if (this.isFourOfAKind()) {
            return true;
        } else {
            return false;
            }

    }

    /**
     * given a hand, returns whether or not it qualifies as a flush, two pair, pair, or high card, as a string.
     * @return hand type as a string
     */
    public String getHandType(){
        if (this.isFlush()){
            return "flush";
        } else if (this.isTwoPair()){
            return "two pair";
        } else if (this.isPair()) {
            return "pair";
        } else {
            return "high card";
        }
    }

    /**
     * given a hand of the pair type, returns the numerical value of a the pair (or three of a kind)
     * @return numerical value of the repeated number, aka the pair
     */
    private int getHighestPiar(){
        ArrayList<Integer> sortedRankList = this.sortedRankList();
        int index = 0;
        int numAtIndex = sortedRankList.get(index);
        while (index <= sortedRankList.size()-1){
            numAtIndex = sortedRankList.get(index);
            int valueCount = Collections.frequency(sortedRankList, numAtIndex);
            if (valueCount > 1){
                index = sortedRankList.size()+1;
            } else{
                index++;
            }
        }
        return numAtIndex;
    }

    /**
     * given a hand, removes a pair (or three of a kind)
     * @return list of ranks completely without a pair
     */
    private ArrayList removeHighestPair(){
        ArrayList<Integer> sortedRankList = this.sortedRankList();
        int highestPairNumber = this.getHighestPiar();
        int valueCount = 2;
        //int valueCount = Collections.frequency(sortedRankList, highestPairNumber);
        for (int num = 0; num<valueCount; num ++){
            sortedRankList.remove(new Integer(highestPairNumber));
        }
        return sortedRankList;
    }

    /**
     * helper function for compare_to: compares two hands that are both flushes and determines a winner
     * @param other The hand to compare this hand to
     * @return 1 if the given hand wins, -1 if the other hand wins, and 0 if it's a tie
     */
    private int compareFlush(PokerHand other){
        ArrayList<Integer> thisList = this.sortedRankList();
        ArrayList<Integer> otherList = other.sortedRankList();
        int thisHighest = Collections.max(thisList);
        int otherHighest = Collections.max(otherList);
        if (thisHighest == otherHighest){
            if (thisList.equals(otherList) ){
                return 0;
            } else{
                int index = 0;
                while (thisList.get(index) == otherList.get(index)){
                    index+=1;
                } if (thisList.get(index) > otherList.get(index)){
                    return 1;
                } else{
                    return -1;
                }
            }
        } else{
            if (thisHighest > otherHighest){
                return 1;
            } else{
                return -1;
            }
        }
    }

    /**
     * helper function for compare_to: compares two hands that are both pairs and determines a winner
     * @param other The hand to compare this hand to
     * @return 1 if the given hand wins, -1 if the other hand wins, and 0 if it's a tie
     */
    private int comparePair(PokerHand other){
        int thisHighestPair = this.getHighestPiar();
        int otherHighestPair = other.getHighestPiar();
        if (thisHighestPair > otherHighestPair){
            return 1;
        } else if (otherHighestPair > thisHighestPair){
            return -1;
        } else {
            ArrayList<Integer> thisNoPair = this.removeHighestPair();
            ArrayList<Integer> otherNoPair = other.removeHighestPair();
            while (thisNoPair.size() > 0 || otherNoPair.size() >0 ){
                int thisHighest = Collections.max(thisNoPair);
                int otherHighest = Collections.max(otherNoPair);
                if (thisHighest == otherHighest){
                    thisNoPair.remove(new Integer(thisHighest));
                    otherNoPair.remove(new Integer(otherHighest));
                } else if(thisHighest > otherHighest){
                    return 1;
                } else{
                    return -1;
                }
            }
            return 0;
        }
    }

    /**
     * helper function for compare_to: compares two hands that are both two pairs and determines a winner
     * @param other The hand to compare this hand to
     * @return 1 if the given hand wins, -1 if the other hand wins, and 0 if it's a tie
     */
    private int compareTwoPair (PokerHand other) {
        ArrayList<Integer> thisList = this.sortedRankList();
        Set<Integer> thisSetList = this.setOfRanksList();
        ArrayList<Integer> thisTwoPair = new ArrayList<>();
        int thisHighCard = 0;

        ArrayList<Integer> otherList = other.sortedRankList();
        Set<Integer> otherSetList = other.setOfRanksList();
        ArrayList<Integer> otherTwoPair = new ArrayList<>();
        int otherHighCard = 0;

        int twoPairValueCount = 2;

        for ( int i: thisSetList) {
            int thisValueCount = Collections.frequency(thisList, i);
            if (thisValueCount == twoPairValueCount || thisValueCount == twoPairValueCount+1) {
                thisTwoPair.add(i);
            } else if (thisValueCount == twoPairValueCount + twoPairValueCount){
                thisTwoPair.add(i);
                thisTwoPair.add(i);
            } else {
                thisHighCard = i;
            }
        }
        for (int i: otherSetList) {
            int otherValueCount = Collections.frequency(otherList, i);
            if (otherValueCount == twoPairValueCount || otherValueCount == twoPairValueCount+1) {
                otherTwoPair.add(i);
            } else if (otherValueCount == twoPairValueCount + twoPairValueCount){
                otherTwoPair.add(i);
                otherTwoPair.add(i);
            } else {
                otherHighCard = i;
            }
        }
        thisTwoPair.sort(Comparator.reverseOrder());
        otherTwoPair.sort(Comparator.reverseOrder());
        if (thisTwoPair.equals(otherTwoPair)) {
            if (thisHighCard > otherHighCard) {
                return 1;
            } else if (otherHighCard > thisHighCard) {
                return -1;
            } else {
                return 0;
            }
        } else {
            if (thisTwoPair.get(0) > otherTwoPair.get(0)) {
                return 1;
            } else if (otherTwoPair.get(0) > thisTwoPair.get(0)) {
                return -1;
            } else {
                if (thisTwoPair.get(1) > otherTwoPair.get(1)) { // get(1) is out of range, for some reason the index is out of range (theres a length of 1?)
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

    /**
     * Determines how this hand compares to another hand, returns
     * positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(PokerHand other){
        if (this.getHandType() != other.getHandType()) {
            if (this.getHandType() == "flush") {
                return 1;
            } else if (other.getHandType() == "flush") {
                return -1;
            } else if (this.getHandType() == "two pair") {
                return 1;
            } else if (other.getHandType() == "two pair") {
                return -1;
            } else if (this.getHandType() == "pair") {
                return 1;
            } else if (other.getHandType() == "pair") {
                return -1;
            } else if (this.getHandType() == "high card") {
                return 1;
            } else {
                return -1;
            }
        } else {
            if(this.getHandType() == "flush"){
                return this.compareFlush(other);
            } else if (this.getHandType() == "pair"){
                return this.comparePair(other);
            } else if (this.getHandType() == "two pair"){
                return this.compareTwoPair(other);
            } else{
                return this.compareFlush(other);
            }
        }
    }


    /**
     * returns a string version of all the cards in a hand
     * @return the Card objects in a hand as a String
     */
    public String toString(){
        String toReturn = "";
        for (int i = 0; i < handContents.size(); i++){
            Card card = handContents.get(i);
            toReturn += (card + "| ");
        }
        return toReturn;
    }
}
