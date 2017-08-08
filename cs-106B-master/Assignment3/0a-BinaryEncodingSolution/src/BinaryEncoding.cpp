/*
 * File: BinaryEncoding.cpp
 * ------------------------
 * Starter file for the binary encoding problem on Assignment #3.
 */

#include <iostream>
#include "console.h"
#include "error.h"
#include "simpio.h"
using namespace std;

/* Function prototypes */

void generateBinaryCode(int nBits);
void generateBinaryWithPrefix(int nBits, string prefix);

/* Main program */

int main() {
   int nBits = getInteger("Number of bits: ");
   generateBinaryCode(nBits);
   return 0;
}

/*
 * Function: generateBinaryCode
 * Usage: generateBinaryCode(nBits);
 * ---------------------------------
 * Lists all the binary values containing the specified number of bits.
 * As is common with recursive functions, generateBinaryCode is a
 * "wrapper function" that exists only to pass additional arguments
 * to a function that solves a more general problem.
 */

void generateBinaryCode(int nBits) {
   if (nBits <= 0) error("The number of bits must be positive");
   generateBinaryWithPrefix(nBits, "");
}

/*
 * Function: generateBinaryWithPrefix
 * Usage: generateBinaryWithPrefix(nBits, prefix);
 * -----------------------------------------------
 * Lists all binary values with the specified number of bits, adding the
 * specified prefix to the beginning of each value.
 */

void generateBinaryWithPrefix(int nBits, string prefix) {
   if (nBits == 0) {
      cout << prefix << endl;
   } else {
      generateBinaryWithPrefix(nBits - 1, prefix + "0");
      generateBinaryWithPrefix(nBits - 1, prefix + "1");
   }
}
