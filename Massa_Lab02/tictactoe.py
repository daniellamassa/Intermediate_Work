"""
functions related to creating, printing,
and evaluating tic-tac-toe boards

:author: Dani Massa
:note: I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.
"""


def remove_blank_lines(list_of_strings):
    """
    Given a list of strings, return a copy
    with all empty strings removed
    :param list_of_strings: list of strings, some of which may be ''; this list is unchanged
    :return: list identical to list_of_strings, but all empty strings removed
    """
    result = list()
    for s in list_of_strings:
        if s != '':
            result.append(s)
    return result


def get_board_from_file(filename):
    """
    Reads board, returns a list of rows.
    :param filename: text file with a tic-tac-toe board such as
    X X X
    O X O
    X O O
    where each line is one row
    :return: list of strings where each string is a
    row from filename; any blank lines in the file are removed
    Example: ["X X X", "O X O", "X O O"]
    """
    board_list = []
    board_file = open(filename, "r")
    for line in board_file:
        board_list.append(line.strip())
    board_file.close()
    board_list = remove_blank_lines(board_list)
    return board_list


def print_row(row):
    """
    Nicely prints a row of the board.
    :param row: string of Xs and Os
    """
    nice_row = ''
    for i in range(0, len(row)):
        nice_row += row[i]
        if i != len(row) - 1:
            nice_row += ' | '
    print(nice_row)


def print_board(board):
    """
    prints the tic-tac-toe board
    :param board: list of rows
    """
    for i in range(0, len(board)):
        row = board[i]
        print_row(row)
        if i != len(board) - 1:
            print('----------')


def three_in_row(board, player, start_x, start_y, dx, dy):
    """
    Determines if a player has three in a row, starting
    from a starting position (start_x, start_y) and going
    in the direction indicated by (dx, dy). Example:
    (start_x, start_y) = (2,2) means we start at the lower
    right (row 2, col 2). (dx, dy) = (-1, 0) means the next
    square we check is (2+dx, 2+dy) = (1,2).  And the last
    square we check is (1+dx, 2+dy) = (0,2).  So we've just
    checked the rightmost column - (2,2), (1,2), and (0,2).
    :param board: list of rows
    :param player: string -- either "X" or "O"
    :param start_x: row to start checking at; first row is row 0
    :param start_y: col to start checking at; first col is col 0
    :param dx: 1 if checking downward, -1 if checking upward, 0 if checking this row
    :param dy: 1 if checking rightward, -1 if checking leftward, 0 if checking this col
    """
    x = start_x
    y = start_y
    for i in range(0, 3):
        if board[x][y] != player:
            return False
        x += dx
        y += dy
    return True


def is_winner(board, player):
    """
    Returns True if and only if the given player has won.
    :param board: list of row strings
    :param player: string - "X" or "O"
    :return: True if player won; False if player lost or tied
    """
    if (three_in_row(board, player, 0, 0, 1, 1)
            or three_in_row(board, player, 0, 2, 1, -1)):
        return True
    else:
        for i in range(0, 3):
            if (three_in_row(board, player, 0, i, 1, 0)
                    or three_in_row(board, player, i, 0, 0, 1)):
                return True
        return False


def get_winner(board):
    """
    Returns the name of the winner, or None if there is no winner
    :param board: list of row strings
    :return: "X" if X is winner, "O" if O is winner, None if tie
    """
    if is_winner(board, 'X'):
        return 'X'
    elif is_winner(board, 'O'):
        return 'O'
    else:
        return None


def confirm_result(board, expected_winner):
    """
    Compares the actual computed winner results to the expected winner results.
    :param board: list of row strings.
    :param expected_winner: who the winner ought to be, represented as a string 'X' or 'O', or
    the special value None if it's a tie.
    :return: prints "PASS" if the actual and expected winners are equivalent. If they are not equal,
    prints "FAIL" with the expected results versus actual results, as well as the failed board layout.
    """
    actual_result = get_winner(board)
    if actual_result == expected_winner:
        print("PASS")
    else:
        print_board(board)
        print("FAIL: The expected winner was %s but the actual result was %s" % (expected_winner, actual_result))


def test_all_files(file_list):
    """
    Iterates through a list to test each file.
    :param file_list: a list containing tuples, in the format (filename, expected_winner)
    """
    for item in file_list:
        board = get_board_from_file(item[0])
        expected_winner = item[1]
        confirm_result(board, expected_winner)


def test_all_boards(board_list):
    """
    Iterates through a list to test each hard-coded board.
    :param board_list: a list containing tuples, in the format (board, expected_winner)
    """
    for item in board_list:
        board = item[0]
        expected_winner = item[1]
        confirm_result(board, expected_winner)


def main():
    main_list = [("None_wins.txt", None), ("O_wins_across.txt", 'O'), ("X_wins_across.txt", 'X'),
                 ("O_wins_down.txt", 'O'), ("X_wins_down.txt", 'X'), ("O_wins_diagonal.txt", 'O'),
                 ("X_wins_diagonal.txt", 'X'), ("O_wins_blank.txt", 'O'), ("X_wins_blank.txt", 'X')]
    test_all_files(main_list)


def main2():
    board_none_wins = ["XOX",
                       "OOX",
                       "XXO"]
    board_o_wins_across = ["OOO",
                           "XXO",
                           "OXX"]
    board_x_wins_across = ["XXX",
                           "OOX",
                           "XOO"]
    board_o_wins_down = ["OXO",
                         "OXX",
                         "OOX"]
    board_x_wins_down = ["XOX",
                         "XOO",
                         "XXO"]
    board_o_wins_diagonal = ["XXO",
                             "OOX",
                             "OXX"]
    board_x_wins_diagonal = ["XOX",
                             "OXO",
                             "OOX"]
    board_o_wins_blank = ["XO_",
                          "_OX",
                          "_O_"]
    board_x_wins_blank= ["O_X",
                         "_OX",
                         "OXX"]
    board_list = [(board_none_wins, None), (board_o_wins_across, 'O'), (board_x_wins_across, 'X'),
                  (board_o_wins_down, 'O'), (board_x_wins_down, 'X'), (board_o_wins_diagonal, 'O'),
                  (board_x_wins_diagonal, 'X'), (board_o_wins_blank, 'O'), (board_x_wins_blank, 'X')]
    test_all_boards(board_list)


if __name__ == "__main__":
    main()
    main2()
