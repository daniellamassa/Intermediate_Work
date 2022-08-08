package proj4;

import java.util.ArrayList;

public class StudPokerHandTesting {

    public static void main(String[] args) {
        runTests();
        ;
    }

    /**
     * runs all tests
     */

    private static void runTests() {
        Testing.startTests();
        Testing.setVerbose(true);
        GetBest5Flush();
        GetBest5FourofAKind();
        GetBest5FullHouse();
        GetBest5HighCard();
        GetBest5Pair();
        GetBest5TwoPair();
        sameCommunityCards();
        twoPairCompareTo();
        Testing.finishTests();
    }

    /**
     * private helper function for testing: creates a hand given an array of ranks and an array of suits
     * @param ranks: array of rank values
     * @param suits: array of suit values
     * @return
     */
    private static ArrayList<Card> createHandHelper(int[] ranks, int[] suits) {
        ArrayList<Card> hand = new ArrayList<Card>();
        for (int i = 0; i < ranks.length; i++) {
            Card card = new Card(ranks[i], suits[i]);
            hand.add(card);
        }
        return hand;
    }

    private static void GetBest5FourofAKind() {
        int[] communityRanks = new int[]{7, 7, 3, 10, 6};
        int[] communitySuits = new int[]{0, 0, 0, 0, 1};
        ArrayList<Card> communityCardList = createHandHelper(communityRanks, communitySuits);
        CommunityCardSet communityCardSet = new CommunityCardSet(communityCardList);

        int[] hand2Ranks = new int[]{7, 7};
        int[] hand2Suits = new int[]{2, 3};
        ArrayList<Card> hand2List = createHandHelper(hand2Ranks, hand2Suits);
        StudPokerHand hand2 = new StudPokerHand(communityCardSet, hand2List);

        int[] hand2ExpectedRanks = new int[]{7, 7, 7, 7, 10};
        int[] hand2ExpectedSuits = new int[]{2, 3, 0, 0, 0};
        ArrayList<Card> hand2ExpectedList = createHandHelper(hand2ExpectedRanks, hand2ExpectedSuits);
        PokerHand hand2Expected = new PokerHand(hand2ExpectedList);

        PokerHand testResult = hand2.getBestFiveCardHand();
        Testing.assertEquals("create best 5 card hand: 4 of a kind", hand2Expected, testResult);
    }

    private static void GetBest5TwoPair() {
        int[] communityRanks = new int[]{7, 7, 3, 10, 6};
        int[] communitySuits = new int[]{0, 0, 0, 0, 1};
        ArrayList<Card> communityCardList = createHandHelper(communityRanks, communitySuits);
        CommunityCardSet communityCardSet = new CommunityCardSet(communityCardList);

        int[] hand1Ranks = new int[]{6, 10};
        int[] hand1Suits = new int[]{2, 1};
        ArrayList<Card> hand1List = createHandHelper(hand1Ranks, hand1Suits);
        StudPokerHand hand1 = new StudPokerHand(communityCardSet, hand1List);

        int[] hand1ExpectedRanks = new int[]{7, 7, 10, 10, 6};
        int[] hand1ExpectedSuits = new int[]{0, 0, 0, 0, 1};
        ArrayList<Card> hand1ExpectedList = createHandHelper(hand1ExpectedRanks, hand1ExpectedSuits);
        PokerHand hand1Expected = new PokerHand(hand1ExpectedList);

        PokerHand testResult = hand1.getBestFiveCardHand();
        Testing.assertEquals("create best 5 card hand: two pair", hand1Expected, testResult);
    }

    private static void GetBest5Flush() {
        int[] communityRanks = new int[]{2, 1, 2, 4, 6};
        int[] communitySuits = new int[]{0, 0, 0, 0, 1};
        ArrayList<Card> communityCardList = createHandHelper(communityRanks, communitySuits);
        CommunityCardSet communityCardSet = new CommunityCardSet(communityCardList);

        int[] hand1Ranks = new int[]{6, 10};
        int[] hand1Suits = new int[]{0, 0};
        ArrayList<Card> hand1List = createHandHelper(hand1Ranks, hand1Suits);
        StudPokerHand hand1 = new StudPokerHand(communityCardSet, hand1List);

        int[] hand1ExpectedRanks = new int[]{6, 10, 2, 2, 1};
        int[] hand1ExpectedSuits = new int[]{0, 0, 0, 0, 0};
        ArrayList<Card> hand1ExpectedList = createHandHelper(hand1ExpectedRanks, hand1ExpectedSuits);
        PokerHand hand1Expected = new PokerHand(hand1ExpectedList);

        PokerHand testResult = hand1.getBestFiveCardHand();
        Testing.assertEquals("create best 5 card hand: flush", hand1Expected, testResult);
    }

    private static void GetBest5FullHouse() {
        int[] communityRanks = new int[]{2, 3, 2, 3, 6};
        int[] communitySuits = new int[]{0, 1, 0, 0, 1};
        ArrayList<Card> communityCardList = createHandHelper(communityRanks, communitySuits);
        CommunityCardSet communityCardSet = new CommunityCardSet(communityCardList);

        int[] hand1Ranks = new int[]{3, 1};
        int[] hand1Suits = new int[]{0, 0};
        ArrayList<Card> hand1List = createHandHelper(hand1Ranks, hand1Suits);
        StudPokerHand hand1 = new StudPokerHand(communityCardSet, hand1List);

        int[] hand1ExpectedRanks = new int[]{2, 2, 3, 3, 3};
        int[] hand1ExpectedSuits = new int[]{0, 0, 1, 0, 0};
        ArrayList<Card> hand1ExpectedList = createHandHelper(hand1ExpectedRanks, hand1ExpectedSuits);
        PokerHand hand1Expected = new PokerHand(hand1ExpectedList);

        PokerHand testResult = hand1.getBestFiveCardHand();
        Testing.assertEquals("create best 5 card hand: full house", hand1Expected, testResult);
    }

    private static void GetBest5Pair() {
        int[] communityRanks = new int[]{2, 3, 2, 3, 6};
        int[] communitySuits = new int[]{0, 1, 0, 0, 1};
        ArrayList<Card> communityCardList = createHandHelper(communityRanks, communitySuits);
        CommunityCardSet communityCardSet = new CommunityCardSet(communityCardList);

        int[] hand1Ranks = new int[]{4, 1};
        int[] hand1Suits = new int[]{0, 0};
        ArrayList<Card> hand1List = createHandHelper(hand1Ranks, hand1Suits);
        StudPokerHand hand1 = new StudPokerHand(communityCardSet, hand1List);

        int[] hand1ExpectedRanks = new int[]{2, 2, 3, 3, 6};
        int[] hand1ExpectedSuits = new int[]{0, 0, 1, 0, 1};
        ArrayList<Card> hand1ExpectedList = createHandHelper(hand1ExpectedRanks, hand1ExpectedSuits);
        PokerHand hand1Expected = new PokerHand(hand1ExpectedList);

        PokerHand testResult = hand1.getBestFiveCardHand();
        Testing.assertEquals("create best 5 card hand: pair", hand1Expected, testResult);
    }

    private static void GetBest5HighCard() {
        int[] communityRanks = new int[]{1, 3, 2, 4, 6};
        int[] communitySuits = new int[]{0, 1, 0, 0, 1};
        ArrayList<Card> communityCardList = createHandHelper(communityRanks, communitySuits);
        CommunityCardSet communityCardSet = new CommunityCardSet(communityCardList);

        int[] hand1Ranks = new int[]{7, 8};
        int[] hand1Suits = new int[]{0, 0};
        ArrayList<Card> hand1List = createHandHelper(hand1Ranks, hand1Suits);
        StudPokerHand hand1 = new StudPokerHand(communityCardSet, hand1List);

        int[] hand1ExpectedRanks = new int[]{8, 7, 6, 4, 3};
        int[] hand1ExpectedSuits = new int[]{0, 0, 1, 0, 1};
        ArrayList<Card> hand1ExpectedList = createHandHelper(hand1ExpectedRanks, hand1ExpectedSuits);
        PokerHand hand1Expected = new PokerHand(hand1ExpectedList);

        PokerHand testResult = hand1.getBestFiveCardHand();
        Testing.assertEquals("create best 5 card hand: highcard", hand1Expected, testResult);
    }


    private static void twoPairCompareTo() {
        int[] hand1Ranks = new int[]{7, 7, 7, 7, 6};
        int[] hand1Suits = new int[]{0, 1, 2, 1, 0};
        ArrayList<Card> hand1List = createHandHelper(hand1Ranks, hand1Suits);
        PokerHand hand1 = new PokerHand(hand1List);

        int[] hand2Ranks = new int[]{10, 10, 7, 7, 6};
        int[] hand2Suits = new int[]{2, 3, 1, 0, 1};
        ArrayList<Card> hand2List = createHandHelper(hand2Ranks, hand2Suits);
        PokerHand hand2 = new PokerHand(hand2List);

        int testResult = hand1.compareTo(hand2);
        Testing.assertEquals("testing three of a kind vs pair", 1, testResult);
    }

    private static void sameCommunityCards() {
        int[] hand1Ranks = new int[]{10, 14, 4, 9, 14};
        int[] hand1Suits = new int[]{0, 1, 2, 1, 0};
        ArrayList<Card> hand1List = createHandHelper(hand1Ranks, hand1Suits);
        PokerHand hand1 = new PokerHand(hand1List);

        int[] hand2Ranks = new int[]{10, 14, 14, 14, 14};
        int[] hand2Suits = new int[]{0, 2, 2, 1, 0};
        ArrayList<Card> hand2List = createHandHelper(hand2Ranks, hand2Suits);
        PokerHand hand2 = new PokerHand(hand2List);

        int testResult = hand1.compareTo(hand2);
        Testing.assertEquals("testing same community cards", -1, testResult);
    }
}