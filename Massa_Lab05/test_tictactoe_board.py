"""
:author: Dani Massa and Chris Fernandes

'I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.'
"""

from tictactoe_board import *
from testing import *


def test_get_winner():
    start_tests("Tests for tictactoe_board.get_winner()")
    test_get_winner_horiz_X()
    test_get_winner_down_O()
    test_get_winner_diagonal_O()
    test_get_winner_diagonal_X()
    test_get_winner_incomplete_board()
    test_get_winner_empty()
    test_get_winner_tie()
    finish_tests()


"""
Individual unit tests start here
"""


def test_get_winner_horiz_X():
    a_board = Tictactoe_board(['XXX', 'OOX', 'XOO'])
    assert_equals(str(a_board) + "Three Xs in a row horizontally",
                  'X',
                  a_board.get_winner())


def test_get_winner_down_O():
    a_board = Tictactoe_board(['OXO', 'OOX', 'OOX'])
    assert_equals(str(a_board) + "Three Os in a column down",
                  'O',
                  a_board.get_winner())


def test_get_winner_diagonal_O():
    a_board = Tictactoe_board(['OXX', 'XOX', 'XXO'])
    assert_equals(str(a_board) + "Three Os in a diagonal",
                  'O',
                  a_board.get_winner())


def test_get_winner_diagonal_X():
    a_board = Tictactoe_board(['OOX', 'OXO', 'XOO'])
    assert_equals(str(a_board) + "Three Xs in a diagonal",
                  'X',
                  a_board.get_winner())


def test_get_winner_incomplete_board():
    a_board = Tictactoe_board(['XXX', 'OOX', 'XOO'])
    a_board.clear_cell(0, 0)
    assert_equals(str(a_board) + "Incomplete board, no winner yet",
                  None,
                  a_board.get_winner())


def test_get_winner_empty():
    a_board = Tictactoe_board(None)
    assert_equals(str(a_board) + "Empty board, no winner yet",
                  None,
                  a_board.get_winner())


def test_get_winner_tie():
    a_board = Tictactoe_board(['XXO', 'XOO', 'XXO'])
    assert_equals(str(a_board) + "Tie, X and O both win",
                  'X and O',
                  a_board.get_winner())


if __name__ == "__main__":
    test_get_winner()
