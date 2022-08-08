package proj4;

import java.util.ArrayList;

public class PokerHandTesting {
    public static void main(String[] args) {
            runTests();
        }

        /**
         * runs all tests
         */

        private static void runTests() {
            Testing.startTests();
            Testing.setVerbose(true);
            testFlush1();
            testFlush2();
            testFlush3();
            testFlush4();
            testFlush5();
            testTwoPair1();
            testTwoPair2();
            testTwoPair3();
            testTwoPair4();
            testTwoPair5();
            testPair1();
            testPair2();
            testPair3();
            testPair4();
            testPair5();
            testHighCard1();
            testHighCard2();
            testHighCard3();
            testHighCard4();
            testHighCard5();
            testDifferentHands1();
            testDifferentHands2();
            testDifferentHands3();
            testDifferentHands4();
            testDifferentHands5();
            Testing.finishTests();
        }

        private static void testFlush1(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (2,0));
            hand1List.add(new Card (3, 0));
            hand1List.add(new Card (4, 0));
            hand1List.add(new Card (5,0));
            hand1List.add(new Card (6,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (7,0));
            hand2List.add(new Card (5, 0));
            hand2List.add(new Card (2, 0));
            hand2List.add(new Card (3,0));
            hand2List.add(new Card (4,0));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing basic flush.", -1, test_result);
        }
        private static void testFlush2(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (9,0));
            hand1List.add(new Card (8, 0));
            hand1List.add(new Card (4, 0));
            hand1List.add(new Card (5,0));
            hand1List.add(new Card (6,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (9,0));
            hand2List.add(new Card (5, 0));
            hand2List.add(new Card (2, 0));
            hand2List.add(new Card (3,0));
            hand2List.add(new Card (4,0));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing flush: different on second highest.", 1, test_result);
        }

        private static void testFlush3(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,0));
            hand1List.add(new Card (9, 0));
            hand1List.add(new Card (8, 0));
            hand1List.add(new Card (5,0));
            hand1List.add(new Card (6,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (7,0));
            hand2List.add(new Card (10, 0));
            hand2List.add(new Card (9, 0));
            hand2List.add(new Card (3,0));
            hand2List.add(new Card (4,0));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing flush: different on third highest.", 1, test_result);
        }

        private static void testFlush4(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,0));
            hand1List.add(new Card (9, 0));
            hand1List.add(new Card (8, 0));
            hand1List.add(new Card (5,0));
            hand1List.add(new Card (6,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (7,0));
            hand2List.add(new Card (10, 0));
            hand2List.add(new Card (9, 0));
            hand2List.add(new Card (8,0));
            hand2List.add(new Card (4,0));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing flush: different on fourth highest.", -1, test_result);
        }

        private static void testFlush5(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,0));
            hand1List.add(new Card (9, 0));
            hand1List.add(new Card (8, 0));
            hand1List.add(new Card (5,0));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (7,0));
            hand2List.add(new Card (10, 0));
            hand2List.add(new Card (9, 0));
            hand2List.add(new Card (8,0));
            hand2List.add(new Card (4,0));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing flush: different on high card.", 1, test_result);
        }


        private static void testTwoPair1(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (2,3));
            hand1List.add(new Card (2, 1));
            hand1List.add(new Card (3, 0));
            hand1List.add(new Card (3,2));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (4,1));
            hand2List.add(new Card (4, 1));
            hand2List.add(new Card (3, 3));
            hand2List.add(new Card (3,2));
            hand2List.add(new Card (4,0));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing basic two pairs", -1, test_result);
        }

        private static void testTwoPair2(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (4,3));
            hand1List.add(new Card (4, 1));
            hand1List.add(new Card (5, 0));
            hand1List.add(new Card (5,2));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (4,1));
            hand2List.add(new Card (4, 1));
            hand2List.add(new Card (3, 3));
            hand2List.add(new Card (3,2));
            hand2List.add(new Card (4,0));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing two pair, different on second pair.", 1, test_result);
        }
        private static void testTwoPair3(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (2,3));
            hand1List.add(new Card (2, 1));
            hand1List.add(new Card (3, 0));
            hand1List.add(new Card (3,2));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (2,1));
            hand2List.add(new Card (2, 1));
            hand2List.add(new Card (3, 3));
            hand2List.add(new Card (3,2));
            hand2List.add(new Card (4,0));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing two pair, different on high card.", 1, test_result);
        }
        private static void testTwoPair4(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (2,3));
            hand1List.add(new Card (2, 1));
            hand1List.add(new Card (2, 0));
            hand1List.add(new Card (2,2));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (2,1));
            hand2List.add(new Card (2, 1));
            hand2List.add(new Card (3, 3));
            hand2List.add(new Card (3,2));
            hand2List.add(new Card (4,0));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing two pair, four of a kind.", -1, test_result);
        }
        private static void testTwoPair5(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (5,3));
            hand1List.add(new Card (5, 1));
            hand1List.add(new Card (5, 0));
            hand1List.add(new Card (3,2));
            hand1List.add(new Card (3,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (5,1));
            hand2List.add(new Card (5, 1));
            hand2List.add(new Card (2, 3));
            hand2List.add(new Card (2,2));
            hand2List.add(new Card (4,0));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing two pair, full house.", 1, test_result);
        }

        private static void testPair1(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,1));
            hand1List.add(new Card (9, 0));
            hand1List.add(new Card (9, 2));
            hand1List.add(new Card (5,3));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (7,2));
            hand2List.add(new Card (8, 0));
            hand2List.add(new Card (9, 1));
            hand2List.add(new Card (8,3));
            hand2List.add(new Card (4,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing basic pair.", 1, test_result);
        }

        private static void testPair2(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,1));
            hand1List.add(new Card (9, 0));
            hand1List.add(new Card (9, 2));
            hand1List.add(new Card (5,3));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (7,2));
            hand2List.add(new Card (9, 0));
            hand2List.add(new Card (9, 1));
            hand2List.add(new Card (8,3));
            hand2List.add(new Card (4,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing pair: different on first high card.", 1, test_result);
        }

        private static void testPair3(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,1));
            hand1List.add(new Card (9, 0));
            hand1List.add(new Card (9, 2));
            hand1List.add(new Card (5,3));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (7,2));
            hand2List.add(new Card (9, 0));
            hand2List.add(new Card (9, 1));
            hand2List.add(new Card (10,3));
            hand2List.add(new Card (4,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing pair: different on second high card.", 1, test_result);
        }

        private static void testPair4(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,1));
            hand1List.add(new Card (9, 0));
            hand1List.add(new Card (9, 2));
            hand1List.add(new Card (4,3));
            hand1List.add(new Card (8,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (7,2));
            hand2List.add(new Card (9, 0));
            hand2List.add(new Card (9, 1));
            hand2List.add(new Card (10,3));
            hand2List.add(new Card (4,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing pair: different on last high card.", 1, test_result);
        }

        private static void testPair5(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,1));
            hand1List.add(new Card (9, 0));
            hand1List.add(new Card (9, 2));
            hand1List.add(new Card (5,3));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (7,2));
            hand2List.add(new Card (9, 0));
            hand2List.add(new Card (9, 1));
            hand2List.add(new Card (10,3));
            hand2List.add(new Card (5,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing pair: tie.", 0, test_result);
        }

        private static void testHighCard1(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,1));
            hand1List.add(new Card (9, 0));
            hand1List.add(new Card (8, 2));
            hand1List.add(new Card (5,3));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (7,2));
            hand2List.add(new Card (11, 0));
            hand2List.add(new Card (9, 1));
            hand2List.add(new Card (10,3));
            hand2List.add(new Card (4,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing basic high card.", -1, test_result);
        }

        private static void testHighCard2(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,1));
            hand1List.add(new Card (9, 0));
            hand1List.add(new Card (11, 2));
            hand1List.add(new Card (5,3));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (7,2));
            hand2List.add(new Card (11, 0));
            hand2List.add(new Card (9, 1));
            hand2List.add(new Card (2,3));
            hand2List.add(new Card (4,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing hgih card: different on first high card.", 1, test_result);
        }

        private static void testHighCard3(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,1));
            hand1List.add(new Card (11, 0));
            hand1List.add(new Card (8, 2));
            hand1List.add(new Card (5,3));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (7,2));
            hand2List.add(new Card (11, 0));
            hand2List.add(new Card (9, 1));
            hand2List.add(new Card (10,3));
            hand2List.add(new Card (4,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing basic high card: different on second high card.", -1, test_result);
        }

        private static void testHighCard4(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,1));
            hand1List.add(new Card (11, 0));
            hand1List.add(new Card (9, 2));
            hand1List.add(new Card (8,3));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (7,2));
            hand2List.add(new Card (11, 0));
            hand2List.add(new Card (9, 1));
            hand2List.add(new Card (10,3));
            hand2List.add(new Card (4,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing basic high card: different on third high card.", 1, test_result);
        }

        private static void testHighCard5(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,1));
            hand1List.add(new Card (11, 0));
            hand1List.add(new Card (9, 2));
            hand1List.add(new Card (8,3));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (7,2));
            hand2List.add(new Card (11, 0));
            hand2List.add(new Card (9, 1));
            hand2List.add(new Card (10,3));
            hand2List.add(new Card (8,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing basic high card: tie", 0, test_result);
        }

        private static void testDifferentHands1(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,0));
            hand1List.add(new Card (11, 0));
            hand1List.add(new Card (9, 0));
            hand1List.add(new Card (8,0));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (11,2));
            hand2List.add(new Card (11, 0));
            hand2List.add(new Card (10, 1));
            hand2List.add(new Card (10,3));
            hand2List.add(new Card (8,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing flush vs two pair", 1, test_result);
        }

        private static void testDifferentHands2(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (11,1));
            hand1List.add(new Card (11, 0));
            hand1List.add(new Card (9, 0));
            hand1List.add(new Card (8,2));
            hand1List.add(new Card (7,3));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (11,2));
            hand2List.add(new Card (11, 0));
            hand2List.add(new Card (10, 1));
            hand2List.add(new Card (10,3));
            hand2List.add(new Card (8,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing two pair vs pair", -1, test_result);
        }

        private static void testDifferentHands3(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (11,1));
            hand1List.add(new Card (11, 2));
            hand1List.add(new Card (9, 3));
            hand1List.add(new Card (8,1));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (11,2));
            hand2List.add(new Card (9, 0));
            hand2List.add(new Card (2, 1));
            hand2List.add(new Card (10,3));
            hand2List.add(new Card (8,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing pair vs high card", 1, test_result);
        }

        private static void testDifferentHands4(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (10,0));
            hand1List.add(new Card (11, 0));
            hand1List.add(new Card (9, 0));
            hand1List.add(new Card (8,0));
            hand1List.add(new Card (7,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (12,2));
            hand2List.add(new Card (11, 0));
            hand2List.add(new Card (9, 1));
            hand2List.add(new Card (10,3));
            hand2List.add(new Card (8,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing flush vs high card", 1, test_result);
        }

        private static void testDifferentHands5(){
            ArrayList<Card> hand1List = new ArrayList<Card>();
            hand1List.add(new Card (3,1));
            hand1List.add(new Card (3, 2));
            hand1List.add(new Card (3, 3));
            hand1List.add(new Card (2,1));
            hand1List.add(new Card (2,0));
            PokerHand hand1 = new PokerHand(hand1List);

            ArrayList<Card> hand2List = new ArrayList<Card>();
            hand2List.add(new Card (4,2));
            hand2List.add(new Card (11, 0));
            hand2List.add(new Card (10, 1));
            hand2List.add(new Card (10,3));
            hand2List.add(new Card (8,1));
            PokerHand hand2 = new PokerHand(hand2List);

            int test_result = hand1.compareTo(hand2);
            Testing.assertEquals("testing full house vs pair", 1, test_result);
        }

}

