/*
 * File: extras.cpp
 * --------------------------
 * Name: Arshad Khan
 *
 * some recursion problems...
 */

#include <iostream>
#include <string>
#include "console.h"
#include "strlib.h"
#include "simpio.h"
#include "filelib.h"
#include "gwindow.h"
#include "gobjects.h"
#include "gevents.h"
#include "random.h"

using namespace std;

bool palindrome(string str);
void printBinary(int no);
void reverseLine(ifstream& input);
void printTOH(int rings, string s, string t, string d);
void printFolderStructure(string name, string indent);
void main_simple_recursion();
void main_fractal_recursion();
void cantor_set(GWindow& window, int x, int y, int width, int levels);
void mondrianPainting(GWindow& window, double x, double y, double w, double h);
void permutation(string str, string sofar = "");
string randomColor();

int main() {
//    main_simple_recursion();
    main_fractal_recursion();
    return 0;
}

void main_fractal_recursion() {
//    GWindow window1(800, 800), window2(800, 800);
//    window1.setWindowTitle("Cantor Set");
//    cantor_set(window1, 50, 50, 600, 7);

//    window2.setWindowTitle("Mondarian Painting");
//    mondrianPainting(window2, 50, 50, 700, 600);
    permutation(getLine("Enter a string to get its all permutation: "));
}

void cantor_set(GWindow& window, int x, int y, int width, int levels) {
    window.drawLine(x, y, x + width, y);
    window.drawLine(x, y, x + width, y);
    if(levels > 1) {
        // left
        cantor_set(window, x, y + 50, width / 3, levels - 1);
        // right
        cantor_set(window, x + 2*(width / 3), y + 50, width / 3, levels - 1);
    }
}

void mondrianPainting(GWindow& window, double x, double y, double w, double h) {
    if(w < 10 || y < 10) return;

    window.setColor(randomColor());
    window.fillRect(x, y, w, h);
    double breakPointY, breakPointX;
    switch(randomInteger(0, 2)) {
        case 0:
            break;
        // dividing vertically
        case 1:
            breakPointX = randomInteger(0, w);
            window.fillRect(x + breakPointX, y, 5, h);
            window.setColor(randomColor());
            mondrianPainting(window, x, y, breakPointX, h);
            mondrianPainting(window, x + breakPointX, y, w - breakPointX, h);
            break;
        // divinding horizontally
        case 2:
            breakPointY = randomInteger(0, h);
            window.fillRect(x, y + breakPointY, w, 5);

            window.setColor(randomColor());
            mondrianPainting(window, x, y, w, breakPointY);
            mondrianPainting(window, x, y + breakPointY, w, h - breakPointY);
            break;
    }
}

string randomColor() {
    switch(randomInteger(0, 5)) {
        case 1:
            return "red";
        case 2:
            return "blue";
        case 3:
            return "green";
        case 4:
            return "yellow";
        case 5:
            return "pink";
        case 0:
            return "magenta";
    }
    return "black";
}

void permutation(string str, string sofar) {
    if(str == "") {
        cout << sofar << endl;
    } else {
        for (int i = 0; i < str.length(); i++) {
            string next = sofar + str[i];
            string remaining = str.substr(0,i) + str.substr(i+1);
            permutation(remaining, next);
        }
    }
}

void main_simple_recursion() {
    bool result = palindrome(getLine("Enter string: "));
    cout << "String is " << (result ? "" : "not ") << "palindrome" << endl;

    string fileName = getLine("Enter file path: ");
    if (fileExists(fileName)) {
        ifstream input;
        input.open(fileName.c_str());
        reverseLine(input);
        input.close();
    } else {
        cout << "You have entered a wrong file path." << endl;
    }

    printTOH(getInteger("Enter no of rings for TOH: "), "source tower", "temporary tower", "destination tower");

    int no = getInteger("Enter an integer: ");
    cout << "Binary of the " << no << " is ";
    printBinary(no);
    cout << endl;

    string filename = getLine("Enter file name: ");
    if (fileExists(filename)) {
        printFolderStructure(filename, "");
    } else {
        cout << "You have entered wrong folder path." << endl;
    }

}

bool palindrome(string str) {
    str = toLowerCase(str);
    if (str.length() == 0)
        return true;
    else if (str[0] == str[str.length() - 1])
        return palindrome(str.substr(1, str.length() - 2));
    else
        return false;
}

void reverseLine(ifstream& input) {
    string line;
    if (getline(input, line)) {
        reverseLine(input);
        cout << line << endl;
    }
}

void printTOH(int rings, string s, string t, string d) {
    if (rings > 0) {
        printTOH(rings - 1, s, d, t);
        cout << "Move a ring from " << s << " to " << d << "." << endl;
        printTOH(rings - 1, t, s, d);
    }

}

void printBinary(int no) {
    if(no < 2){
        cout << no;
    } else {
        printBinary(no/2);
        cout << (no % 2) ;
    }
}

void printFolderStructure(string name, string indent) {
    cout << indent << getTail(name) << endl;
    if (isDirectory(name)) {
        Vector<string> directory;
        listDirectory(name, directory);
        for(string item : directory) {
            printFolderStructure(name + "/" + trim(item), indent + "---");
        }
    }
}
