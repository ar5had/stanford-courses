/*
 * File: extras.cpp
 * --------------------------
 * Name: Arshad Khan
 *
 * Recursive Backtracking problems:
 *
 * Famous 8 queen problem
 *
 * Status - incomplete without board implementation
 */

#include <iostream>
#include <string>
#include "console.h"
#include "strlib.h"
#include "simpio.h"
#include "grid.h"

using namespace std;

void queenSolve(Board& board);
bool queenHelper(Board& board, int col);

int main2() {
  Board board;
  queenSolve(board);
  return 0;
}

void queenSolve(Board& board) {
  queenHelper(board, 0);
}

bool queenHelper(Board& board, int col) {
  if (col >= 8) {
    cout << board.toString() << endl;
    return true;
  } else {
    for(int row = 0; row < 8; row++) {
      if (board.isSafe(row, col)) {
        board.place(row, col);
        bool finished = queenHelper(board, ++col);
        if (finished) {
          return true;
        }
        board.remove(row, col);
      }
    }
    return false;
  }
}
