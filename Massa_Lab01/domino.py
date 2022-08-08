"""
Programmer(s): Dani Massa and Chris Fernandes
Models a single domino: with a left and right side.
"""

def create(left, right):
    """
    Creates a single domino as a tuple, with two integers representing the left and right side.
    :param left: the integer for the left side of a domino.
    :param right: the integer for the right side of a domino.
    :return domino: a complete domino as a tuple.
    """
    domino = (left, right)
    return domino

def get_left(domino):
    """
    Returns the integer value for the left side of a single domino through indexing.
    :param domino: a complete domino as a tuple.
    :return left: the integer at index 0 of the domino tuple.
    """
    left = domino[0]
    return left

def get_right(domino):
    """
    Returns the integer value for the right side of a single domino through indexing.
    :param domino: a complete domino as a tuple.
    :return right: the integer at index 1 of the domino tuple.
    """
    right = domino[1]
    return right

def as_str(domino):
    """
    Returns a string formatted to look like domino, which contains a left and right value by calling
    their corresponding functions.
    :param domino: a complete domino as a tuple.
    :return: a format string to look like a domino, with the left and right integers on each side.
    """
    return "[%d | %d]" % (get_left(domino), get_right(domino))

