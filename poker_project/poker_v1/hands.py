from deck import *

HAND_VALUE_MAX = 5


def create_hand(deck, discard_pile):
    """
    creates a hand of cards (5 cards) from deck. If less than five cards remain in a deck, deck renews
    and hand is created.
    :param deck: a deck of cards
    :param discard_pile: pile of discarded cards
    :return: a hand containing five cards
    """
    hand = list()
    for item in range (1, HAND_VALUE_MAX + 1):
        if deck_is_empty(deck):
            gather_deck(deck, discard_pile)
            shuffle_deck(deck)
        card = draw_from_deck(deck)
        hand.append(card)
    return hand


def get_card_from_hand(hand):
    """
    removes a card from a given hand
    :param hand: a hand of cards
    :return: card that is removed
    """
    card = hand.pop(0)
    return card


def is_flush(hand):
    """
    tests to see whether or not a hand qualifies as a flush.
    :param hand: a hand of cards
    :return: True or False
    """
    hand_copy = hand.copy()
    card = get_card_from_hand(hand_copy)
    for item in hand_copy:
        if get_suit(item) != get_suit(card):
            return False
    else:
        return True


def is_pair(hand):
    """
    tests to see whether or not a hand qualifies as a pair.
    :param hand: a hand of cards
    :return: True or False
    """
    hand_copy = hand.copy()
    while len(hand_copy) > 0:
        card = get_card_from_hand(hand_copy)
        for item in range(len(hand_copy)):
            if get_value(hand[item]) == get_value(card):
                hand_copy.pop(item)
                return True
    return False


def is_two_pair(hand):
    """
    tests to see whether or not a hand qualifies as a two pair.
    :param hand: a hand of cards
    :return: True or False
    """
    hand_copy = hand.copy()
    if is_pair(hand_copy):
        if is_pair(hand_copy):
            return True
        else:
            return False
    else:
        return False


def empty_hand(hand, discard_pile):
    """
    adds all cards in hand to the discard pile.
    :param hand: a hand of cards
    :param discard_pile: a pile of discarded cards
    :return: discard pile containing cards from hand
    """
    discard_pile += hand
    return discard_pile


if __name__ == "__main__":
    '''
    deck = (create_deck())
    print(hand)
    '''
    hand = [(3, 'Spades'), (6, 'Diamonds'), (5, 'Clubs'), (5, 'Hearts'), (7, 'Hearts')]
    print(is_two_pair(hand))

