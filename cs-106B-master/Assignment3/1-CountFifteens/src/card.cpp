/*
 * File: card.cpp
 * --------------
 * This file implements the card.h interface.
 */

#include <iostream>
#include <string>
#include "card.h"
#include "error.h"
#include "strlib.h"
using namespace std;

/* Constants */

extern const int ACE = 1;
extern const int JACK = 11;
extern const int QUEEN = 12;
extern const int KING = 13;

/* Implementation of the Suit type */

Card::Card() {
   /* Empty */
}

Card::Card(string name) {
   if (name.length() < 2) error("Invalid card name");
   int suitIndex = 1;
   switch (name[0]) {
    case 'A': case 'a':
      cardRank = 1;
      break;
    case '2': case '3': case '4': case '5':
    case '6': case '7': case '8': case '9':
      cardRank = name[0] - '0';
      break;
    case '1':
      if (name[1] != '0') error("Invalid card name");
      cardRank = 10;
      suitIndex = 2;
      break;
    case 'J': case 'j':
      cardRank = 11;
      break;
    case 'Q': case 'q':
      cardRank = 12;
      break;
    case 'K': case 'k':
      cardRank = 13;
      break;
    default:
      error("Illegal card name");
   }
   if (name.length() != suitIndex + 1) error("Illegal card name");
   switch (name[suitIndex]) {
    case 'C': case 'c':
      cardSuit = CLUBS;
      break;
    case 'D': case 'd':
      cardSuit = DIAMONDS;
      break;
    case 'H': case 'h':
      cardSuit = HEARTS;
      break;
    case 'S': case 's':
      cardSuit = SPADES;
      break;
    default:
      error("Illegal card name");
   }
}

Card::Card(int rank, Suit suit) {
   cardRank = rank;
   cardSuit = suit;
}

string Card::toString() {
   string str = "???";
   switch (cardRank) {
    case ACE:   str = "A"; break;
    case JACK:  str = "J"; break;
    case QUEEN: str = "Q"; break;
    case KING:  str = "K"; break;
    default:    str = integerToString(cardRank); break;
   }
   switch (cardSuit) {
    case CLUBS:    return str + "C";
    case DIAMONDS: return str + "D";
    case HEARTS:   return str + "H";
    case SPADES:   return str + "S";
    default:       return "???";
   }
}

int Card::getRank() {
   return cardRank;
}

Suit Card::getSuit() {
   return cardSuit;
}

ostream & operator<<(ostream & os, Card card) {
   return os << card.toString();
}

Suit operator++(Suit & suit, int) {
   Suit old = suit;
   suit = Suit(suit + 1);
   return old;
}

