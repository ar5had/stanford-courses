/*
 * File: section-1.cpp
 * --------------------------
 * Name: Arshad Khan
 *
 *1 - censorString
 *    Removes all the censored chars passed to it from a given string
 *    Example:    "Stanford University" with "nt" removed becomes "Saford Uiversiy"
 *                "Llamas like to laugh" with "la" removed becomes "Lms ike to ugh"
 *
 *2 - File processing and reference parameters
 *    When we grade exams, we typically keep track of various statistics like the
 *    minimum, maximum, and mean (i.e., the traditional average) scores. Write a function
 *    that takes the name of an input file and three reference parameters that will hold this
 *    statistical information. Your implementation should open the file, read the scores one
 *    line at a time, close the file, and then return to the client with the values of min , max , and
 *    mean correctly set. For efficiency’s sake, your function should make only a single pass
 *    over the file. Your implementation should also call error with an appropriate message if
 *    the file does not exist or if any of the scores are not in the range 0 to 100.
 *
 *3 - cannonBall count
 *    War. You have been assigned a dangerous reconnaissance mission: evaluate the amount
 *    of ammunition available to the British for use with their large cannon, which has been
 *    shelling the Revolutionary forces. Fortunately for you, the British—being neat and
 *    orderly—have stacked the cannonballs into a single pyramid-shaped stack with one
 *    cannonball at the top, sitting on top of a square composed of four cannonballs, sitting on
 *    top of a square composed of nine cannonballs, and so forth. Unfortunately, however, the
 *    Redcoats are also vigilant, and you only have time to count the number of layers in the
 *    pyramid before you are able to escape back to your own troops. To make matters worse,
 *    computers will not be invented for at least 150 years, but you should not let that detail get
 *    in your way. Your mission is to write a recursive function cannonball that takes as its
 *    argument the height of the pyramid and returns the number of cannonballs it contains.
 *    Your function must operate recursively and must not use any iterative constructs, such as
 *    while or for
 *
 */


#include <iostream>
#include <string>
#include "console.h"
#include "simpio.h"
#include "strlib.h"
#include "filelib.h"

using namespace std;

void censorString();
void fileProcessing();
void cannonBallCount();
string censorString1(string str, string remove);
void censorString2(string& str, string remove);
string censorString3(string str, string remove);
void readStats(string fname, int & min, int & max, double & mean);
int cannonBall(int height);

int main() {
    censorString();
    fileProcessing();
    cannonBallCount();
    return 0;
}

void censorString() {
    string str = getLine("Enter text : ");
    string remove = getLine("Enter censored characters: ");
    cout << "Censored string using pass by value method: " << censorString1(str, remove) << endl;
    censorString2(str, remove);
    cout << "Censored string using pass by reference method: " << str << endl;
}

void fileProcessing() {
    int min, max;
    double mean;
    string fname = getLine("Enter file name: ");
    readStats(fname, min, max, mean);
    cout << "Minimum marks are " << min << endl;
    cout << "Maximum marks are " << max << endl;
    cout << "Mean marks are " << mean << endl;
}

void cannonBallCount() {
   int totalBalls = cannonBall(getInteger("Enter the height of cannon balls pyramid: "));
   cout << "Total no of balls is " << totalBalls << endl;
}

string censorString1(string str, string remove) {
    for (int i = 0; i < remove.length(); i++) {
       str = stringReplace(str, string() + remove[i], "");
    }
    return str;
}

void censorString2(string& str, string remove) {
    for (int i = 0; i < remove.length(); i++) {
       str = stringReplace(str, string() + remove[i], "");
    }
}

void readStats(string fname, int & min, int & max, double & mean) {
    if (fileExists(fname)) {
        ifstream input;
        input.open(fname);
        string no;
        int count = 0;
        while(getline(input, no)) {
            int noVal = stringToInteger(trim(no));
            if (noVal > 100 || noVal < 0)
                throw "Improper marks in file!";
            else if (input.fail()) {
                throw "Some error happened while reading file.";
            }
            else {
                // count condition is important because
                // int initial value is 0 so min will auto will
                // be zero.
                min = (count == 0 || min > noVal) ? noVal : min;
                max = (count == 0 || max < noVal) ? noVal : max;
            }
            // count condition is important because
            // double's initial val is not zero.
            mean = count == 0 ? noVal : mean + noVal;
            count++;
        }
        mean /= count;
        input.close();
    } else {
        throw "File doesn't exists!";
    }
}

int cannonBall(int height) {
    if(height == 1)
        return 1;
    else
        return (height * height) + cannonBall(height - 1);
}

string censorString3(string str, string remove) {
    string result = "";
    for (int i = 0; i < str.length(); i++) {
        if(remove.find(str[i]) == string::npos) {
            result += str[i];
        }
    }
    return result;
}
