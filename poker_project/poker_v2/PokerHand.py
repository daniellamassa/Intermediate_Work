"""
defines the properties and behaviors of a poker hand. Specifically, compares two poker hands to each other.
"""

from deck import *


class Hand:

    def __init__(self, cards=[]):
        """
        constructor: creates a hand with given cards
        :param cards: cards that make up the hand, use draw_from_deck method
        """
        self.__hand = cards
        self.__HAND_VALUE_MAX = 5

    def add_card(self, card):
        """
        Given a card, adds the card to a hand
        :return: hand with added card
        """
        self.__hand.append(card)
        return self.__hand

    def get_ith_card(self, index):
        """
        given an index, returns the card object at that index in the hand
        :param index: location of desired card
        :return: card object at index
        """
        card = self.__hand[index]
        return card

    def rank_list(self):
        """
        given a hand, returns a list of all its cards' ranks
        :return: list of rank values
        """
        list_rank = []
        for card in self.__hand:
            list_rank.append(card.get_rank())
        return list_rank

    def sorted_rank_list(self):
        """
        given a hand, returns a list of all its cards' ranks, in descending order
        :return: the sorted list of ranks
        """
        sorted_list = self.rank_list()
        sorted_list.sort(reverse=True)
        return sorted_list

    def suit_list(self):
        """
        given a hand, returns a list of all its cards' suits
        :return: list of suit values
        """
        list_suit = []
        for card in self.__hand:
            list_suit.append(card.get_suit())
        return list_suit

    def is_flush(self):
        """
        tests to see whether or not a hand qualifies as a flush.
        :return: True or False
        """
        if len(set(self.suit_list())) == 1:
            return True
        else:
            return False

    def is_pair(self):
        """
        tests to see whether or not a hand qualifies as a pair.
        :return: True or False
        """
        if len(set(self.rank_list())) == self.__HAND_VALUE_MAX - 1:
            return True
        elif len(set(self.rank_list())) == self.__HAND_VALUE_MAX - 2:
            return True
        else:
            return False

    def is_four_of_a_kind(self):
        """
        tests to see whether or not a hand qualifies as a four of a kind.
        :return: True or False
        """
        if len(set(self.rank_list())) == self.__HAND_VALUE_MAX - 3:
            return True
        else:
            return False

    def is_two_pair(self):
        """
        tests to see whether or not a hand qualifies as a two pair.
        :return: True or False
        """
        list_of_ranks = self.rank_list()
        two_pair_list = []
        for i in set(list_of_ranks):
            if list_of_ranks.count(i) >= 2:
                two_pair_list.append(i)
        if len(two_pair_list) == 2:
            return True
        elif self.is_four_of_a_kind():
            return True
        else:
            return False

    def get_hand_type(self):
        """
        given a hand, returns whether or not it qualifies as a flush, two pair, pair, or high card, as a string.
        :return: hand type as a string
        """
        if self.is_flush():
            return "flush"
        elif self.is_two_pair():
            return "two pair"
        elif self.is_pair():
            return "pair"
        else:
            return "high card"

    def get_highest_pair(self):
        """
        given a hand of the pair type, returns the numerical value of a the pair (or three of a kind)
        :return: numerical value of the repeated number, aka the pair
        """
        self_list = self.sorted_rank_list()
        index = 0
        while index <= len(self_list)-1:
            num_at_index = self_list[index]
            value_count = self_list.count(num_at_index)
            if value_count > 1:
                index = len(self_list)+1
            else:
                index += 1
        return num_at_index

    def remove_highest_pair(self):
        """
        given a hand, removes a pair (or three of a kind)
        :return: list of ranks completely without a pair
        """
        self_list = self.sorted_rank_list()
        highest_pair_number = self.get_highest_pair()
        value_count = self_list.count(highest_pair_number)
        for num in range (1, value_count +1):
            self_list.remove(highest_pair_number)
        return self_list

    def compare_flush(self, other_hand):
        """
        helper function for compare_to: compares two hands that are both flushes and determines a winner
        :param self: the first hand
        :param other_hand: the second hand
        :return: 1 if the first hand wins, -1 if the second hand wins, and 0 if it's a tie
        """
        self_list = self.sorted_rank_list()
        other_list = other_hand.sorted_rank_list()
        self_highest = max(self_list)
        other_highest = max(other_list)
        if self_highest == other_highest:
            if self_list == other_list:
                return 0
            else:
                index = 0
                while self_list[index] == other_list[index]:
                    index += 1
                if self_list[index] > other_list[index]:
                    return 1
                else:
                    return -1
        else:
            if self_highest > other_highest:
                return 1
            else:
                return -1

    def compare_pair(self, other_hand):
        """

        :param self: the first hand
        :param other_hand: the second hand
        :return: 1 if the first hand wins, -1 if the second hand wins, and 0 if it's a tie
        """
        self_highest_pair = self.get_highest_pair()
        other_highest_pair = other_hand.get_highest_pair()
        if self_highest_pair > other_highest_pair:
            return 1
        elif other_highest_pair > self_highest_pair:
            return -1
        else:
            self_no_pair = self.remove_highest_pair()
            other_no_pair = other_hand.remove_highest_pair()
            while len(self_no_pair) > 0 or len(other_no_pair) > 0:
                self_highest = max(self_no_pair)
                other_highest = max(other_no_pair)
                if self_highest == other_highest:
                    self_no_pair.remove(self_highest)
                    other_no_pair.remove(other_highest)
                elif self_highest > other_highest:
                    return 1
                else:
                    return -1
            return 0

    def compare_two_pair(self, other_hand):
        """
        helper function for compare_to: compares two hands that are both two pairs and determines a winner
        :param self: the first hand
        :param other_hand: the second hand
        :return: 1 if the first hand wins, -1 if the second hand wins, and 0 if it's a tie
        """
        self_list = self.rank_list()
        other_hand_list = other_hand.rank_list()

        self_pairs_list = []
        other_pairs_list = []
        for i in set(self_list):
            if self_list.count(i) >= 2:
                self_pairs_list.append(i)
            else:
                self_high_card = i
        for i in set(other_hand_list):
            if other_hand_list.count(i) >= 2:
                other_pairs_list.append(i)
            else:
                other_high_card = i
        self_pairs_list.sort(reverse=True)
        other_pairs_list.sort(reverse=True)
        if self_pairs_list == other_pairs_list:
            if self_high_card > other_high_card:
                return 1
            elif other_high_card > self_high_card:
                return -1
            else:
                return 0
        else:
            if self_pairs_list[0] > other_pairs_list[0]:
                return 1
            elif other_pairs_list[0] > self_pairs_list[0]:
                return -1
            else:
                if self_pairs_list[1] > other_pairs_list[1]:
                    return 1
                else:
                    return -1


    def compare_to(self, other_hand):
        """
        Determines which of two poker hands is worth more. Returns an int
        which is either positive, negative, or zero depending on the comparison.
        :param self: The first hand to compare
        :param other_hand: The second hand to compare
        :return: a negative number if self is worth LESS than other_hand,
        zero if they are worth the SAME (a tie), and a positive number if
        self is worth MORE than other_hand
        """

        if self.get_hand_type() != other_hand.get_hand_type():
            if self.get_hand_type() == "flush":
                return 1
            elif other_hand.get_hand_type() == "flush":
                return -1
            elif self.get_hand_type() == "two pair":
                return 1
            elif other_hand.get_hand_type() == "two pair":
                return -1
            elif self.get_hand_type() == "pair":
                return 1
            elif other_hand.get_hand_type() == "pair":
                return -1
            elif self.get_hand_type() == "high card":
                return 1
            elif other_hand.get_hand_type() == "high card":
                return -1
        else:
            if self.get_hand_type() == "flush":
                return self.compare_flush(other_hand)
            elif self.get_hand_type() == "pair":
                return self.compare_pair(other_hand)
            elif self.get_hand_type() == "two pair":
                return self.compare_two_pair(other_hand)
            elif self.get_hand_type() == "high card":
                return self.compare_flush(other_hand)


    def __str__(self):
        """
        :return: hand as printable string
         """
        to_return = ""
        for card in self.__hand:
            to_return += str(card) + ", "
        return to_return


if __name__ == "__main__":
    deck = Deck()
    hand = Hand(deck.draw_from_deck(5))
    hand2 = Hand(deck.draw_from_deck(5))
    print(hand)
    print(hand2)
    print(hand.get_hand_type())
    print(hand2.get_hand_type())
    print(hand.compare_to(hand2))


