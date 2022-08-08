"""
Programmer: Dani Massa
I affirm that I have carried out the attached academic endeavors with full academic honesty, in accordance with the
Union College Honor Code and the course syllabus.

Module that evaluates a tic tac toe board and states its winner, or if its a tie.
"""


def print_board(board):
    """
    Given a tic tac toe board, prints the layout of the board and its contents (i.e. Xs and Os)
    :param board: a tic tac toe board
    :return: a printed formatted tic tac toe board
    """
    num_rows = len(board)
    num_cols = len(board[0])
    for row_num, row in enumerate(board):
        row_str = ''
        for col_num, marker in enumerate(row):
            row_str += marker
            if col_num < num_cols - 1:
                row_str += ' | '
        print(row_str)
        if row_num < num_rows - 1:
            print('---------')


def row_all_same(board, row):
    """
    Given a tic tac toe board and a row, checks to see if all values in a row of the board are equal.
    :param board: a tic tac toe
    :param row: contains values to test
    :return: function is passed if all values in the row are equal
    """
    return board[row][0] == board[row][1] == board[row][2]


def column_all_same(column):
    """
    Given a column checks to see if all its values are equal.
    :param column: contains values to test
    :return: function is passed if all values in the column are equal
    """
    return column[0] == column[1] == column[2]


def diagonal_all_same(diagonal):
    """
    Given a diagonal checks to see if all its values are equal.
    :param diagonal: contains values to test
    :return: function is passed if all values in the diagonal are equal
    """
    return diagonal[0] == diagonal[1] == diagonal[2]


def get_back_slash(board):
    return [board[i][i] for i in range(len(board))]


def get_forward_slash(board):
    return [board[len(board) - i - 1][i] for i in range(len(board))]


def columns(board):
    """
    given a tic tac toe board, returns a list containing its columns.
    :param board: a tic tac toe board
    :return: a list of of the values in each column
    """
    num_cols = len(board[0])
    num_rows = len(board)

    column_list = []

    for i in range(num_cols):
        col_str = ''
        for j in range(num_rows):
            col_str += board[j][i]
        column_list.append(col_str)
    return column_list


def check_winner(board):
    """
    given a tic tac board, checks to see if there is a winner by testing if there are equivalent values in any of its
    rows, columns, or diagonals.
    :param board: a tic tac toe board
    :return: an X or an O depending on which one won.
    """
    for row_num, row in enumerate(board):
        if row_all_same(board, row_num):
            return board[row_num][0]

    for col in columns(board):
        if column_all_same(col):
            return col[0]

    if diagonal_all_same(get_back_slash(board)):
        return board[0][0]

    if diagonal_all_same(get_forward_slash(board)):
        return board[2][0]


def get_board_from_file(filename):
    """
    Given a file, opens the file for reading, strips it of whitespace, and returns the contents of the file as a list.
    :param filename: a file
    :return: file as list
    """
    board_list = []
    board_file = open(filename, "r")
    for line in board_file:
        board_list.append(line.strip())
    board_file.close()
    return board_list


def main():
    input_file = 'input.txt'
    board = get_board_from_file(input_file)

    print_board(board)

    winner = check_winner(board)

    if winner != '':
        print(winner + ' WINS!!!!')
    else:
        print("TIE GAME!!!!")


main()
