/*
 * File: extras.cpp
 * --------------------------
 * Name: Arshad Khan
 *
 * Recursive Backtracking problems:
 *
 * printBinary - prints all binary nos of x digits. No of digits is given by user
 * printBinary - prints all decimal nos of x digits. No of digits is given by user
 * diceRoll - prints all the possible outcomes when n no of dices are rolled.
 * diceSumRoll - prints all the possible outcomes whose sum is equal to desired sum when
 *               n no of dices are rolled.
 * sublists - print out all the sublists of a list given by user.
 */

#include <iostream>
#include <string>
#include "console.h"
#include "strlib.h"
#include "simpio.h"
#include "vector.h"

using namespace std;

void printBinary(int digits, string prefix = "");
void printDecimal(int digits, string prefix = "");
void diceRoll(int dices);
void diceRollHelper(int dices, Vector<int>& chosen);
void diceSumRoll(int dices, int sum);
void diceSumRollBadHelper(int dices, int sum, Vector<int>& chosen);
void diceSumRollEffHelper(int dices, int sum, int sofar, Vector<int>& chosen);
int sumOfElems(Vector<int>& vect);
void sublists(Vector<string>& str);
void sublistsHelper(Vector<string>& str, Vector<string>& chosen);
int badHelperCount = 0, goodHelperCount = 0;

int main() {
    printBinary(getInteger("Enter the no of digits upto which you want a list of binary nos: "));
    cout << endl;
    cout << endl;
    printDecimal(getInteger("Enter the no of digits upto which you want a list of decimal nos: "));
    cout << endl;
    cout << endl;
    diceRoll(getInteger("Enter the no of dices: "));
    cout << endl;
    cout << endl;
    diceSumRoll(getInteger("Enter the no of dices: "), getInteger("Enter the sum: "));
    cout << "Bad helper took " << badHelperCount << " calls." << endl;
    cout << "Good helper took " << goodHelperCount << " calls." << endl;
    cout << "\n\nEnter the string in list to get all of its sublists" << endl;
    Vector<string> list;
    string line = getLine("Enter string: ");
    while(true) {
        list.add(line);
        line = getLine("Enter string: ");
        if(line == "") break;
    }
    sublists(list);
    return 0;
}

void printBinary(int digits, string prefix) {
    if (digits == 0) {
        cout << prefix << endl;
    } else {
        printBinary(digits - 1, prefix + "0");
        printBinary(digits - 1, prefix + "1");
    }
}

void printDecimal(int digits, string prefix) {
    if (digits == 0) {
        cout << prefix << endl;
    } else {
        for (int i = 0; i < 10; i++) {
            printDecimal(digits - 1, prefix  + integerToString(i));
        }
    }
}

void diceRoll(int dices) {
    // using helper when we dont want to change signature of
    // original function.
    Vector<int> chosen;
    diceRollHelper(dices, chosen);
}

void diceRollHelper(int dices, Vector<int>& chosen) {
    if (dices == 0)
        cout << chosen << endl;
    else {
        for (int i = 1; i < 7; i++) {
            chosen.add(i);
            diceRollHelper(dices - 1, chosen);
            chosen.remove(chosen.size() - 1);
        }
    }
}

void diceSumRoll(int dices, int sum) {
    // using helper when we dont want to change signature of
    // original function.
    Vector<int> chosen;
    cout << "Using bad helper "<< endl;
    diceSumRollBadHelper(dices, sum, chosen);
    cout << "\nUsing good helper "<<endl;
    diceSumRollEffHelper(dices, sum, 0, chosen);
}


// 'bad' because method to get result is very inefficient.
void diceSumRollBadHelper(int dices, int sum, Vector<int>& chosen) {
    badHelperCount++;
    if (dices == 0) {
        if (sumOfElems(chosen) == sum)
            cout << chosen << endl;
    } else {
        for (int i = 1; i < 7; i++) {
            chosen.add(i);
            diceSumRollBadHelper(dices - 1, sum, chosen);
            chosen.remove(chosen.size() - 1);
        }
    }
}

// efficient helper
void diceSumRollEffHelper(int dices, int sum, int sofar, Vector<int>& chosen) {
    goodHelperCount++;
    if (dices == 0) {
        cout << chosen << endl;
    } else {
        for (int i = 1; i < 7; i++) {
             // if sofar is not too big and not too small
            if (sofar + i + 1*(dices - 1) <= sum &&
                sofar + i + 6*(dices - 1) >= sum) {
                chosen.add(i);
                diceSumRollEffHelper(dices - 1, sum, sofar + i, chosen);
                chosen.remove(chosen.size() - 1);
            }
        }
    }
}

int sumOfElems(Vector<int>& vect) {
    int total = 0;
    for(int elem: vect)
        total += elem;
    return total;
}

void sublists(Vector<string>& list) {
    Vector<string> chosen;
    sublistsHelper(list, chosen);
}

void sublistsHelper(Vector<string>& list, Vector<string>& chosen) {
    if (list.isEmpty())
        cout << chosen << endl;
    else {
        string first = list[0];
        list.remove(0);
        chosen.add(first);
        // exploring with first
        sublistsHelper(list, chosen);
        chosen.remove(chosen.size() - 1);
        // exploring without first
        sublistsHelper(list, chosen);
        // adding back to first place or zeroth index
        list.insert(0, first);
    }
}
