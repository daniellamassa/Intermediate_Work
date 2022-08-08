"""
:author: Dani Massa

'I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.'
"""

from PokerHand import *


def main():
    deck = Deck()
    deck.shuffle_deck()
    points = 0
    GameOver = False
    while not GameOver:
        hand_1 = Hand(deck.draw_from_deck(5))
        hand_2 = Hand(deck.draw_from_deck(5))
        print("Hand 1: " + str(hand_1))
        print("Hand 2: " + str(hand_2))
        user_answer = int(input("Which hand wins?\nInput 1 for Hand 1.\nInput -1 for Hand 2.\nInput 0 if it's a tie."))
        correct_answer = hand_1.compare_to(hand_2)
        if user_answer == correct_answer:
            print("Correct!")
            points += 1
        else:
            print("Sorry! The correct answer was: " + str(correct_answer) + "\nGame Over. Total points: " + str(points))
            GameOver = True
        if deck.cards_remaining() < 5:
            print("Not enough cards remain! Total points: " + str(points))
            GameOver = True

main()
