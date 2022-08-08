import sys
from testing import *
from card import *
from PokerHand import *

IGNORE = -100
RANKS = [IGNORE,IGNORE,"2","3","4","5","6","7","8","9","T","J","Q","K","A"]

def make_hand(card_list):
    """
    make a hand out of given list of cards
    :param card_list: list of cards in 2-char string format; e.g.: ["2D","QS","TC","3H","AC"]
    :return: hand of those cards
    """
    hand = []
    for card_string in card_list:
        suit = card_string[1]
        rank = RANKS.index(card_string[0])
        hand.append(Card(rank,suit))
    return Hand(hand)

def create(rank,suit):
    """
    create a new card (since student might not have create() function)
    :param rank: 2-14 where 11=Jack, 12=Queen, 13=King, 14=Ace
    :param suit: 'H' = hearts, 'D' = diamonds, 'S'=spades, 'C'=clubs
    :return: card as dictionary
    """
    d = {}
    d["rank"]=rank
    d["suit"]=suit
    return d

def safe_assert_equals(msg, should_be_positive, winner, loser):
    """
    runs assert_equals in a try block to catch run-time errors
    
    :param msg: message saying what is being tested
    :param should_be_positive: True if compare_to result should be > 0,
    False if compare_to result should be < 0, "tie" if should be == 0
    :param: winner: winning hand
    :param: loser: losing hand
    """
    try:
        actual_pos = winner.compare_to(loser)
        actual_neg = loser.compare_to(winner)
        if should_be_positive == "tie":
            assert_equals(msg,0,actual_pos)
        elif should_be_positive:
            assert_equals(msg,True,actual_pos>0)
        else:
            assert_equals(msg,True,actual_neg<0)
    except:
        fail_on_error(msg,sys.exc_info()[0])

def different_hand_types():
    start_tests("HANDS OF DIFFERENT CATEGORIES")
    one_pair_two_pair()
    one_pair_high_card()
    one_pair_flush()
    two_pair_high_card()
    two_pair_flush()
    flush_high_card()
    three_kind_flush()
    three_kind_two_pair()
    three_kind_high_card()
    full_house_flush()
    full_house_one_pair()
    full_house_high_card()
    four_kind_flush()
    four_kind_one_pair()
    four_kind_high_card()
    finish_tests()

def ties():
    start_tests("SAME CATEGORY")
    flush_tie_1()
    flush_tie_2()
    flush_tie_3()
    flush_tie_4()
    flush_tie_5()
    flush_true_tie()
    two_pair_tie_1()
    two_pair_tie_2()
    two_pair_tie_3()
    two_pair_tie_4()
    two_pair_tie_5()
    two_pair_true_tie()
    one_pair_tie_1()
    one_pair_tie_2()
    one_pair_tie_3()
    one_pair_tie_4()
    one_pair_tie_5()
    one_pair_true_tie()
    high_card_tie_1()
    high_card_tie_2()
    high_card_tie_3()
    high_card_tie_4()
    high_card_tie_5()
    high_card_tie_6()
    high_card_true_tie()
    finish_tests()

"""Individual unit tests start here"""

def one_pair_two_pair():
    msg = "1 pair vs. 2 pair"
    winner = make_hand(["4D","7S","8D","7H","4S"])
    loser = make_hand(["7D","TD","5S","QH","7C"])
    safe_assert_equals(msg,False,winner,loser)

def one_pair_high_card():
    msg = "1 pair vs. high card"
    loser = make_hand(["KD","AS","8D","7H","4S"])
    winner = make_hand(["6D","TD","TS","QH","2C"])
    safe_assert_equals(msg,True,winner,loser)

def one_pair_flush():
    msg = "1 pair vs. flush"
    winner = make_hand(["4H","7H","8H","JH","2H"])
    loser = make_hand(["7D","TD","5S","QH","7C"])
    safe_assert_equals(msg,False,winner,loser)

def two_pair_high_card():
    msg = "2 pair vs. high card"
    loser = make_hand(["KD","AS","8D","7H","4S"])
    winner = make_hand(["6D","TD","TS","QH","QC"])
    safe_assert_equals(msg,True,winner,loser)

def two_pair_flush():
    msg = "2 pair vs. flush"
    winner = make_hand(["4S","7S","8S","JS","2S"])
    loser = make_hand(["7D","TD","7H","TH","AD"])
    safe_assert_equals(msg,False,winner,loser)

def flush_high_card():
    msg = "flush vs. high card"
    loser = make_hand(["KD","AS","8D","7H","4S"])
    winner = make_hand(["6D","TD","3D","QD","AD"])
    safe_assert_equals(msg,True,winner,loser)

def three_kind_flush():
    msg = "3-of-a-kind (1 pair) vs. flush"
    winner = make_hand(["4S", "KS", "8S", "JS", "2S"])
    loser = make_hand(["7D", "5D", "7H", "7S", "8D"])
    safe_assert_equals(msg,False,winner,loser)

def three_kind_two_pair():
    msg = "3-of-a-kind (1 pair) vs. 2 pair"
    loser = make_hand(["AD","AS","3C","AH","9C"])
    winner = make_hand(["6D","TD","TS","6H","QC"])
    safe_assert_equals(msg,True,winner,loser)

def three_kind_high_card():
    msg = "3-of-a-kind (1 pair) vs. high card"
    winner = make_hand(["4S", "KD", "9S", "9D", "9H"])
    loser = make_hand(["7D", "5D", "TH", "8S", "6D"])
    safe_assert_equals(msg,False,winner,loser)

def full_house_flush():
    msg = "full house (2 pair) vs. flush"
    loser = make_hand(["KD","AS","AD","KH","KS"])
    winner = make_hand(["6D","TD","3D","QD","4D"])
    safe_assert_equals(msg,True,winner,loser)

def full_house_one_pair():
    msg = "full house (2 pair) vs. 1 pair"
    winner = make_hand(["KD","AS","AD","KH","KS"])
    loser = make_hand(["7D","TD","5S","QH","7C"])
    safe_assert_equals(msg,False,winner,loser)

def full_house_high_card():
    msg = "full house (2 pair) vs. high card"
    loser = make_hand(["9D","4C","8D","7H","5S"])
    winner = make_hand(["KD","AS","AD","KH","KS"])
    safe_assert_equals(msg,True,winner,loser)

def four_kind_flush():
    msg = "four-of-a-kind (2 pair) vs. flush"
    loser = make_hand(["KD","KC","AD","KH","KS"])
    winner = make_hand(["6D","TD","3D","QD","4D"])
    safe_assert_equals(msg,True,winner,loser)

def four_kind_one_pair():
    msg = "four-of-a-kind (2 pair) vs. 1 pair"
    winner = make_hand(["KD","KC","AD","KH","KS"])
    loser = make_hand(["7D","TD","5S","5H","JC"])
    safe_assert_equals(msg,False,winner,loser)

def four_kind_high_card():
    msg = "four-of-a-kind (2 pair) vs. high card"
    loser = make_hand(["2D","4C","8D","7H","5S"])
    winner = make_hand(["KD","KC","AD","KH","KS"])
    safe_assert_equals(msg,True,winner,loser)

###############  FLUSH TIES ###################

def flush_tie_1():
    msg = "two flushes - different on high card"
    winner = make_hand(["KD","7D","2D","9D","3D"])
    loser = make_hand(["TH","9H","5H","3H","2H"])
    safe_assert_equals(msg,False,winner,loser)

def flush_tie_2():
    msg = "two flushes - different on 2nd highest card"
    winner = make_hand(["8D","7D","2D","9D","3D"])
    loser = make_hand(["6H","9H","5H","3H","2H"])
    safe_assert_equals(msg,False,winner,loser)

def flush_tie_3():
    msg = "two flushes - different on 3rd highest card"
    winner = make_hand(["JD","7D","2D","9D","3D"])
    loser = make_hand(["2H","9H","5H","3H","JH"])
    safe_assert_equals(msg,False,winner,loser)

def flush_tie_4():
    msg = "two flushes - different on 4th highest card"
    winner = make_hand(["KD","7D","2D","9D","5D"])
    loser = make_hand(["KH","9H","3H","7H","2H"])
    safe_assert_equals(msg,False,winner,loser)

def flush_tie_5():
    msg = "two flushes - different on 5th highest card"
    winner = make_hand(["KD","7D","3D","9D","5D"])
    loser = make_hand(["KH","9H","2H","7H","5H"])
    safe_assert_equals(msg,False,winner,loser)

def flush_true_tie():
    msg = "two flushes - tied"
    winner = make_hand(["KD","7D","3D","9D","5D"])
    loser = make_hand(["KH","9H","5H","7H","3H"])
    safe_assert_equals(msg,"tie",winner,loser)

###############  TWO PAIR TIES ###################

def two_pair_tie_1():
    msg = "two 2-pair hands - different on high pair"
    winner = make_hand(["QS","KH","QH","TH","KS"])
    loser = make_hand(["QD","KC","QC","8D","8H"])
    safe_assert_equals(msg,False,winner,loser)

def two_pair_tie_2():
    msg = "two 2-pair hands - different on low pair"
    winner = make_hand(["8D", "2H", "TC", "TD", "8H"])
    loser = make_hand(["6S", "6H", "5H", "TH", "TS"])
    safe_assert_equals(msg,True,winner,loser)

def two_pair_tie_3():
    msg = "two 2-pair hands - all pairs equal, different on high card"
    winner = make_hand(["JD","QS","2D","QD","2C"])
    loser = make_hand(["QH","QC","5H","2H","2S"])
    safe_assert_equals(msg,False,winner,loser)

def two_pair_tie_4():
    msg = "2-pair vs. 4-of-a-kind: different on high pair"
    winner = make_hand(["5D","AD","AS","3H","3D"])
    loser = make_hand(["KH","KS","KC","KD","8H"])
    safe_assert_equals(msg,True,winner,loser)

def two_pair_tie_5():
    msg = "2-pair vs. full house: different on low pair"
    winner = make_hand(["6C","7D","3H","7S","6D"])
    loser = make_hand(["7H","7C","5H","5D","5S"])
    safe_assert_equals(msg,False,winner,loser)

def two_pair_true_tie():
    msg = "two 2-pair hands - tied"
    winner = make_hand(["KD","7D","3D","7S","3H"])
    loser = make_hand(["KH","3C","3S","7H","7C"])
    safe_assert_equals(msg,"tie",winner,loser)

###############  ONE PAIR TIES ###################

def one_pair_tie_1():
    msg = "two 1-pair hands - different on pair"
    winner = make_hand(["QS","JH","QH","2C","4S"])
    loser = make_hand(["QD","JC","AC","JD","KH"])
    safe_assert_equals(msg,True,winner,loser)

def one_pair_tie_2():
    msg = "two 1-pair hands - pairs equal, different on high card"
    winner = make_hand(["8D", "2H", "2C", "TD", "9H"])
    loser = make_hand(["2D", "6H", "5H", "9D", "2S"])
    safe_assert_equals(msg,False,winner,loser)

def one_pair_tie_3():
    msg = "two 1-pair hands - pairs equal, different on 2nd highest card"
    winner = make_hand(["6D","6S","2D","QD","4C"])
    loser = make_hand(["QH","6C","6D","3H","2S"])
    safe_assert_equals(msg,True,winner,loser)

def one_pair_tie_4():
    msg = "two 1-pair hands - pairs equal, different on 3rd highest card"
    winner = make_hand(["6D","6S","AD","9D","JC"])
    loser = make_hand(["4H","AS","6C","JD","6H"])
    safe_assert_equals(msg,False,winner,loser)

def one_pair_tie_5():
    msg = "1-pair vs. three-of-a-kind: different on pair"
    winner = make_hand(["6C","7D","3H","KS","6D"])
    loser = make_hand(["7H","AC","5H","5D","5S"])
    safe_assert_equals(msg,True,winner,loser)

def one_pair_true_tie():
    msg = "two 1-pair hands - tied"
    winner = make_hand(["KD","7D","3D","7S","TH"])
    loser = make_hand(["KH","TC","3S","7H","7C"])
    safe_assert_equals(msg,"tie",winner,loser)

###############  HIGH CARD TIES ###################

def high_card_tie_1():
    msg = "two high-card hands - different on high card"
    winner = make_hand(["QS","JH","3H","2C","4S"])
    loser = make_hand(["7D","JC","TC","5D","2H"])
    safe_assert_equals(msg,True,winner,loser)

def high_card_tie_2():
    msg = "two high-card hands - different on 2nd highest card"
    winner = make_hand(["8D", "2H", "3C", "5D", "9H"])
    loser = make_hand(["2D", "4H", "5H", "9D", "6S"])
    safe_assert_equals(msg,False,winner,loser)

def high_card_tie_3():
    msg = "two high-card hands - different on 3rd highest card"
    winner = make_hand(["6D","7S","2D","QD","TC"])
    loser = make_hand(["QH","6C","TD","3H","2S"])
    safe_assert_equals(msg,True,winner,loser)

def high_card_tie_4():
    msg = "two high-card hands - different on 4th highest card"
    winner = make_hand(["TD","6S","AD","9D","JC"])
    loser = make_hand(["4H","AS","6C","JD","TH"])
    safe_assert_equals(msg,False,winner,loser)

def high_card_tie_5():
    msg = "two high-card hands - different on 5th highest card"
    winner = make_hand(["6C","7D","JH","KS","QD"])
    loser = make_hand(["7H","KC","QH","JD","5S"])
    safe_assert_equals(msg,True,winner,loser)

def high_card_tie_6():
    msg = "high-card hand vs. straight - different on high card"
    winner = make_hand(["6C","7D","JH","KS","3D"])
    loser = make_hand(["8H","TC","QH","JD","9S"])
    safe_assert_equals(msg,True,winner,loser)

def high_card_true_tie():
    msg = "two high-card hands - tied"
    winner = make_hand(["KD","7D","3D","JS","TH"])
    loser = make_hand(["KH","TC","3S","JH","7C"])
    safe_assert_equals(msg,"tie",winner,loser)

if __name__ == "__main__":
    different_hand_types()
    ties()

