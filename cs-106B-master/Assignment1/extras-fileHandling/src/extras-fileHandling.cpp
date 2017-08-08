/*
 * File: extras.cpp
 * --------------------------
 * Name: Arshad Khan
 *
 * some file handling problems...
 */

#include <iostream>
#include <string>
#include "console.h"
#include <fstream>
#include "simpio.h"
#include "filelib.h"

using namespace std;

void readAndPrintFile(ifstream& input, string fn);

int main() {
    ifstream input;
    string filename = getLine("Enter file path : ");
    if(fileExists(filename)){
        readAndPrintFile(input, filename);
    } else {
        cout << "Illegal file path." << endl;
    }
    return 0;
}

void readAndPrintFile(ifstream& input, string fn) {
        input.open(fn);
        string line;
        while(getline(input, line)){
            cout << trim(line)  << "- " << trim(line).length() << endl;
        }
        input.close();
}
