"""
Programmer(s): Dani Massa and Chris Fernandes
Models a boneyard -- a pile of dominoes.
"""

import domino as d
import random

def create():
    """
    Creates a list containing tuples that represent dominoes. Utilizes the create function from domino.py to
    make the tuple, and then appends it to an empty list. Uses for loops to set numerical boundaries.
    :return yard: a list containing multiple dominoes.
    """
    yard = []
    for i in range(0, 7):
        for j in range(0, 7):
            tile = d.create(i, j)
            yard.append(tile)
    return yard

def draw(boneyard):
    """
    Returns a single domino, represented as a tuple, from the boneyard. Uses the .pop function to take out a
    domino from the list. Selects a random index of the boneyard to remove a domino from.
    :param boneyard: a 'pile' of dominoes.
    :return: a single domino that was removed from the 'pile' at a random index.
    """
    n = random.randint(0, len(boneyard)-1)
    return boneyard.pop(n)

def tiles_remaining(boneyard):
    """
    Returns how many dominoes remain in the 'pile', AKA the boneyard.
    :param boneyard: a 'pile' of dominoes.
    :return: the length of the boneyard list.
    """
    return len(boneyard)
