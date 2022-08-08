"""
defines the properties and behaviors of a single playing card.
"""


class Card:
    def __init__(self, rank, suit):
        """
        constructor: creates a card from the given rank and suit
        :param rank: the value of the card (i.e. 9)
        :param suit: the suit of the card (i.e. Ace)
        :return: card as a dictionary containing a value and suit
        """
        self.__rank = rank
        self.__suit = suit
        self.__card = {'rank': self.__rank, 'suit': self.__suit}

    def get_rank(self):
        """
        returns the numerical value of a given card
        :return: the rank
        """
        return self.__rank

    def get_suit(self):
        """
        returns the suit of a given card
        :return: suit
        """
        return self.__suit

    def __str__(self):
        """
        returns card as a printable string
        """
        suit = self.get_suit()
        rank = self.get_rank()
        if suit == "S":
            suit_string = "Spades"
        elif suit == "C":
            suit_string = "Clubs"
        elif suit == "H":
            suit_string = "Hearts"
        elif suit == "D":
            suit_string = "Diamonds"
        else:
            suit_string = suit
        if rank == 11:
            rank_string = "Jack"
        elif rank == 12:
            rank_string = "Queen"
        elif rank == 13:
            rank_string = "King"
        elif rank == 14:
            rank_string = "Ace"
        else:
            rank_string = rank

        return str(rank_string) + " of " + str(suit_string)


if __name__ == "__main__":
    card = Card(12, "H")
    print(card)
