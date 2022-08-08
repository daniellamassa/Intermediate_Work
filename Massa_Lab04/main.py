"""
I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.
"""

from die import *

TWELVE_SIDED_DIE = 12
MULTIPLE = 2


def main():
    six_die = Die()
    twelve_die = Die(TWELVE_SIDED_DIE)
    game_over = False
    input("Press the 'return' key to begin.")
    while not game_over:
        six_die.roll()
        twelve_die.roll()
        die1 = six_die.get_value()
        die2 = twelve_die.get_value()
        print(die1)
        print(die2)
        if die1 == (MULTIPLE * die2) or die2 == (MULTIPLE * die1):
            print("Game Won!")
            game_over = True
        else:
            input("Press the 'return' key to continue.")


if __name__ == "__main__":
    main()
