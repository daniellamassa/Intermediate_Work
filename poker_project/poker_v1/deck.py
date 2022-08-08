import random
from card import *

CARD_SUITS = ["S", "C", "H", "D"]
CARD_VALUE_MIN = 2
CARD_VALUE_MAX = 14


def create_deck():
    """
    creates a deck of cards, unshuffled.
    :return: deck of cards
    """
    deck = list()
    for value in range(CARD_VALUE_MIN, CARD_VALUE_MAX + 1):
        for suit in CARD_SUITS:
            card = create_card(value, suit)
            deck.append(card)
    return deck


def shuffle_deck(deck):
    """
    given a deck of cards, shuffles it by putting its contents in a random order
    :param deck: a deck of cards
    :return: shuffled deck
    """
    random.shuffle(deck)
    return deck


def gather_deck(deck, discard_pile):
    """
    adds all cards from the discard pile back into the deck.
    :param deck: a deck of cards
    :param discard_pile: a separate unit containing cards
    :return: deck containing cards from discard pile
    """
    deck += discard_pile
    return deck


def draw_from_deck(deck):
    """
    removes a random card from a deck and returns it.
    :param deck: a deck of cards
    :return: a random card from deck, or None if deck is empty
    """
    if deck_is_empty(deck):
        return None
    else:
        index = random.randint(0, len(deck) - 1)
        card = deck.pop(index)
        return card


def cards_remaining(deck):
    """
    returns the number of cards remaining in a deck
    :param deck: a deck of cards
    :return: length of deck
    """
    return len(deck)


def deck_is_empty(deck):
    """
    returns True if deck is empty, and False if it is not.
    :param deck: a deck of cards
    :return: boolean True or False
    """
    return cards_remaining(deck) == 0


if __name__ == "__main__":
    '''
    deck = (create_deck())
    print(shuffle_deck(deck))
    print(draw_from_deck(deck))
    '''

