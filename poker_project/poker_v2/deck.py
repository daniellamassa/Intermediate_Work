"""
defines the properties and behaviors of a deck of 52 playing cards.
"""
from card import *
import random

CARD_SUITS = ["S", "C", "H", "D"]
CARD_VALUE_MIN = 2
CARD_VALUE_MAX = 14


class Deck:
    def __init__(self):
        """
        constructor: creates a deck of cards.
        :return: deck of cards (un-shuffled).
        """
        self.__deck = []
        for rank in range(CARD_VALUE_MIN, CARD_VALUE_MAX + 1):
            for suit in CARD_SUITS:
                new_card = Card(rank, suit)
                self.__deck.append(new_card)

    def shuffle_deck(self):
        """
        Given a deck of cards, puts all the cards in a random order (shuffles the deck).
        :return: the shuffled deck
        """
        random.shuffle(self.__deck)

    def draw_from_deck(self, num_cards=1):
        """
        If no given parameter, removes a single card from deck and returns it. if given a numerical value
        parameter, removes that quantitative amount of cards from deck and returns them as a list
        :return: card or cards from deck, or None if deck is empty
        """
        if self.deck_is_empty():
            return None
        elif num_cards == 1:
            card = self.__deck.pop(0)
            return card
        else:
            hand_list = []
            for i in range(num_cards):
                hand_list.append(self.__deck.pop(0))
            return hand_list

    def cards_remaining(self):
        """
        returns the number of cards remaining in a deck
        :return: length of deck
        """
        return len(self.__deck)

    def deck_is_empty(self):
        """
        returns True if deck is empty, and False if it is not.
        :return: boolean True or False
        """
        return self.cards_remaining() == 0

    def __str__(self):
        """
        returns deck as a printable stirng
        """
        to_return = "DECK CONTENTS\n"
        for card in self.__deck:
            to_return += str(card) + "\n"
        return to_return


if __name__ == "__main__":
    deck = Deck()
    print(deck)
    deck.shuffle_deck()
    print(deck)
    x = deck.draw_from_deck()
    print(x)
