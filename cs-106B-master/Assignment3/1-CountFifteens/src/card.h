/*
 * File: card.h
 * ------------
 * This file defines the Card class, which is used to represent an
 * individual card.
 */

#ifndef _card_h
#define _card_h

#include <iostream>
#include <string>

/*
 * Constants: ACE, JACK, QUEEN, KING
 * ---------------------------------
 * These constants assign conventional names to the values 1, 11, 12, and 13.
 */

extern const int ACE;
extern const int JACK;
extern const int QUEEN;
extern const int KING;

/*
 * Type: Suit
 * ----------
 * This enumerated type defines the constants for the four suits.
 */

enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES };

/*
 * Operator: ++
 * Usage: suit++
 * -------------
 * Overloads the suffix version of the ++ operator to work with Suit values.
 * The sole purpose of this definition is to support the idiom
 *
 *    for (Suit suit = CLUBS; suit <= SPADES; suit++) . . .
 */

Suit operator++(Suit & suit, int);

/*
 * Class: Card
 * -----------
 * This class represents a playing card.
 */

class Card {

public:

/*
 * Constructor: Card
 * Usage: Card card;
 *        Card card(name);
 *        Card card(rank, suit);
 * -----------------------------
 * Creates a playing card with the specified rank and suit.  The
 * default constructor creates an uninitialized card that can be
 * assigned a value later.  The second form creates a card using
 * the printed name of the card, as in "JH" for the Jack of Hearts.
 * The third creates a card from the rank and suit values.
 */

   Card();
   Card(std::string name);
   Card(int rank, Suit suit);

/*
 * Method: toString
 * Usage: string str = card.toString();
 * ------------------------------------
 * Translates the card into a string consisting of the conventional
 * designation of the rank (A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K)
 * and the first letter of the suit.  Thus, the string representation
 * of the Jack of Clubs would be "JC".
 */

   std::string toString();

/*
 * Method: getRank
 * Usage: int rank = card.getRank();
 * ---------------------------------
 * Returns the rank of the card as an integer between 1 and 13.
 */

   int getRank();

/*
 * Method: getSuit
 * Usage: Suit suit = card.getSuit();
 * ----------------------------------
 * Returns the rank of the card as one of the enumeration constants
 * of the Suit type.
 */

   Suit getSuit();

private:

/* Instance variables */

   int cardRank;      /* The rank of the card (A=1, J=11, Q=12, K=13) */
   Suit cardSuit;     /* The suit (CLUBS, DIAMONDS, HEARTS, SPADES)   */

};

/*
 * Operator: <<
 * Usage: cout << card;
 * --------------------
 * Overloads the << operator so that it is able to display Card values
 */

std::ostream & operator<<(std::ostream & os, Card card);

#endif
