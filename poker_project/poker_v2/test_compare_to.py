from testing import *
from PokerHand import *


def test_compare_to():
    start_tests("Tests for compare_to")
    # test_compare_flush()
    # test_compare_pair()
    test_compare_high_card()
    # test_compare_two_pair()


"""
Individual unit tests start here
"""


def test_compare_flush():
    hand1 = Hand(cards=[Card(10, "C"), Card(8, "C"), Card(3, "C"), Card(4, "C"), Card(2, "C")])
    hand2 = Hand(cards=[Card(4, "C"), Card(3, "C"), Card(11, "C"), Card(3, "C"), Card(8, "C")])
    assert_equals(str(hand1) + "\n" + str(hand2) + "\n" + "The second hans wins.",
                  -1,
                  hand1.compare_to(hand2))


def test_compare_pair():
    hand1 = Hand(cards=[Card(8, "C"), Card(13, "S"), Card(8, "D"), Card(2, "C"), Card(7, "C")])
    hand2 = Hand(cards=[Card(7, "S"), Card(2, "C"), Card(2, "C"), Card(13, "C"), Card(2, "H")])
    assert_equals(str(hand1) + "\n" + str(hand2) + "\n" + "The first hand wins.",
                  1,
                  hand1.compare_to(hand2))


def test_compare_high_card():
    hand1 = Hand(cards=[Card(8, "C"), Card(13, "S"), Card(3, "H"), Card(2, "C"), Card(4, "S")])
    hand2 = Hand(cards=[Card(2, "D"), Card(8, "H"), Card(13, "S"), Card(3, "C"), Card(7, "C")])
    assert_equals(str(hand1) + "\n" + str(hand2) + "\n" + "The second hand wins.",
                  -1,
                  hand1.compare_to(hand2))


def test_compare_two_pair():
    hand1 = Hand(cards=[Card(8, "C"), Card(2, "S"), Card(13, "H"), Card(13, "C"), Card(8, "S")])
    hand2 = Hand(cards=[Card(8, "D"), Card(13, "H"), Card(8, "S"), Card(13, "C"), Card(5, "C")])
    assert_equals(str(hand1) + "\n" + str(hand2) + "\n" + "The second hand wins.",
                  -1,
                  hand1.compare_to(hand2))


if __name__ == "__main__":
    test_compare_to()
