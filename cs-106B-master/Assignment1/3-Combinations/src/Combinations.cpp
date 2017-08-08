/*
 * File: Combinations.cpp
 * ----------------------
 * Name: Arshad Khan
 *
 * Recursive implementation of C(n,k)
 */

#include <iostream>
#include "console.h"
#include "simpio.h"
using namespace std;

int combination(int n, int k);
void printPascalTriangle(int rows);

int main() {
    while(true){
        int n = getInteger("Enter 'n': ");
        int k = getInteger("Enter 'k': ");
        if (n < k) {
            cout << "Enter 'k' value less than n !" << endl;
            continue;
        }
        cout << "C(n, k) => " << combination(n, k) << endl;
        if( !getYesOrNo("Do you want to continue - 'yes' or 'no' ?") )
            break;
    }
    printPascalTriangle(10);
    return 0;
}

int combination(int n, int k) {
    if(n == k || k == 0)
        return 1;
    else
        return combination(n - 1, k - 1) + combination(n - 1, k);
}

void printPascalTriangle(int rows) {
    cout << endl;
    cout << endl;
    cout << "Here are the ten rows of pascal triangle." << endl;
    cout << endl;
    cout << endl;
    for(int i = 0; i < rows; i++) {
        for(int j = 0; j <= i; j++) {
            cout << combination(i, j) << "  ";
        }
        cout << endl;
    }
}
