/*
 * File: ConsecutiveHeads.cpp
 * --------------------------
 * Name: Arshad Khan
 *
 * This file is the starter project for the coin-flipping problem.
 *
 * This program simulates flipping a coin repeatedly and continues until three
 * consecutive heads are tossed. At that point, it displays the total
 * number of coin flips that were made.
 */

#include <iostream>
#include <string>
#include "console.h"
#include "random.h"
using namespace std;

string flipCoin();

int main() {
   int flips = 0, consecHeads = 0;

   while(consecHeads < 3) {
       string result = flipCoin();
       cout << result << endl;

       if(result == "Heads")
           consecHeads++;
       else
           consecHeads = 0;

       flips++;
   }

   cout << "It tooks " << flips << " flips to get 3 consecutive heads." << endl;
   return 0;
}

string flipCoin(){
    if(randomBool())
        return "Heads";
    else
        return "Tails";
}
