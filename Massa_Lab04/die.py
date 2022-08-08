"""
defines the properties and behavior of a single playing die.
:author Dani Massa
"""
import random

CURRENT_VALUE = 6


# this constant is used to give the value variable within the constructor some arbitrary value. The value variable
# could have also been set equal to the parameter sides.


class Die:

    def __init__(self, sides=6):  # if no parameter is given, the default number of sides for the die is 6.
        """
        constructor
        :param sides: the number of sides the die has
        """
        self.__sides = sides
        self.__value = CURRENT_VALUE
        # value is the current value showing on the die

    def roll(self):
        """
        rolls a die by reassigning its current value property to a random number between 1 and its number of sides.
        """
        self.__value = random.randint(1, self.__sides)

    def get_value(self):
        """
        returns the value currently showing on the die.
        """
        return self.__value
