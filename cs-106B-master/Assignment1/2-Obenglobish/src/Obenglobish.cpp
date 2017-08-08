/*
 * File: Obenglobish.java
 * ----------------------
 * Name: Arshad Khan
 *
 * This program that takes an English word and returns its Obenglobish equivalent,
 * using the translation rule given below.
 * Rule - add 'ob' before every vowel in word given by user.
 */

#include <iostream>
#include <string>
#include "console.h"
#include "simpio.h"
#include "strlib.h"
#include "vector.h"

using namespace std;
/* Main program */

string obenglobish(string word);
bool containsVowel(char s);

int main(){

    while(true) {
        string word = getLine("Enter the word...");
        word = toLowerCase(word);
        if(word == "")
            break;
        else
            cout << word << "=>" << obenglobish(word) << endl;
    }

    return 0;
}

string obenglobish(string word) {
    string holder = "";
    for(int i = 0; i < word.length(); i++) {
        if(containsVowel(word[i])) {
            holder += "ob";
        }
        holder += word[i];
    }
    return holder;
}

bool containsVowel(char s) {
    if(s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u')
        return true;
    else
        return false;
}
