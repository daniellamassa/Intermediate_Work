class Card:
    def __init__(self, rank, suit):
        """
        creates a card from the given rank and suit.
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
        """return card as a printable string"""
        suit = self.get_suit()
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
        return self.get_rank() + " of " + suit_string

    if __name__ == "__main__":
