/*
 * File: NumericConversion.cpp
 * ---------------------------
 * Name: Arshad Khan
 *
 * Implement intToString and stringToInt recursively.
 */

#include <iostream>
#include <string>
#include "console.h"
#include "simpio.h"
#include <cmath>
using namespace std;

/* Function prototypes */

string intToString(int n);
int stringToInt(string str, string sign="not-set");

/* Main program */

int main() {
    while(true) {
        cout << "Enter an integer and get result in string format" << endl;
        string numStr = intToString(getInteger("Integer: Enter no..."));
        cout << "String form of the no is " << numStr << endl;
        cout << "\n\n";
        cout << "Enter a string no and get result in integer format" << endl;
        int numInt = stringToInt(getLine("String: Enter no..."));
        cout << "Int form of the no is " << numInt << endl;
        cout << "\n\n";
    }
    return 0;
}

string intToString(int n) {
    if(n < 0) {
        return "-" + intToString(-n);
    }
    else if(n / 10 == 0) {
        char letter = '0' + n;
        return letter + string();
    } else {
        int digit = n % 10;
        char letter = '0' + digit;
        return intToString(n / 10) + letter + string();
    }
}

int stringToInt(string str, string sign) {
    if(sign == "not-set"){
        if(str[0] == '-')
            return -1 * stringToInt(str.substr(1, str.length()), "set");
    }
    if(str.length() > 0) {
        int firstDigit = str[0] - '0';
        if(firstDigit > 9 || firstDigit < 0)
            throw "BAD NUMBER!";
        return firstDigit * pow(10, str.length() - 1) + stringToInt(str.substr(1, str.length()), "set");
    }
    else
        return 0;
}


