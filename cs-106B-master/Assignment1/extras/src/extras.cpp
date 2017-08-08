/*
 * File: extras.cpp
 * --------------------------
 * Name: Arshad Khan
 *
 * mirrorProblem: Transform {1,2,3} to {1,2,3,3,2,1}
 * stutterProblem: Transform {1,2,3} to {1,1,2,2,3,3}
 * knightCanMove problem : Checks whether knight can move to a particular location on chess grid
 */

#include <iostream>
#include <string>
#include "console.h"
#include "stack.h"
#include "queue.h"
#include "math.h"
#include "grid.h"
using namespace std;

void mirrorProblem();
void stutterProblem();
void knightMoveProblem();
bool knightCanMove(Grid<string> grid, int x1, int y1, int x2, int y2);
void mirrorStack(Stack<int>& s);
void mirrorQueue(Queue<int>& q);
void stutterStack(Stack<int>& s);
void stutterQueue(Queue<int>& q);

int main() {
    mirrorProblem();
    stutterProblem();
    knightMoveProblem();
    return 0;
}

void mirrorProblem() {
    cout << "Mirror Problem" << endl;
    Stack<int> stack;
    Queue<int> queue;
    for(int i = 1; i < 4; i++) {
        stack.push(i);
        queue.enqueue(i);
    }
    mirrorStack(stack);
    mirrorQueue(queue);
    cout << "Stack is " << stack << endl;
    cout << "Queue is " << queue << endl;
    cout << "----------------------------" << endl;
}

void mirrorStack(Stack<int>& stack) {
    Stack<int> ns = stack;
    while(!stack.isEmpty()) {
        ns.push(stack.pop());
    }
    stack = ns;
}

void mirrorQueue(Queue<int>& queue) {
    Stack<int> s;
    Queue<int> q = queue;
    while(!q.isEmpty()) {
        s.push(q.dequeue());
    }
    while(!s.isEmpty()) {
        queue.enqueue(s.pop());
    }
}

void stutterProblem() {
    cout << "stutter Problem" << endl;
    Stack<int> stack;
    Queue<int> queue;
    for(int i = 1; i < 4; i++) {
        stack.push(i);
        queue.enqueue(i);
    }
    stutterStack(stack);
    stutterQueue(queue);
    cout << "Stack is " << stack << endl;
    cout << "Queue is " << queue << endl;
    cout << "----------------------------" << endl;
}

void stutterStack(Stack<int>& stack) {
    Stack<int> ns;
    while(!stack.isEmpty()) {
        ns.push(stack.pop());
    }
    while(!ns.isEmpty()) {
        int elem = ns.pop();
        stack.push(elem);
        stack.push(elem);
    }
}

void stutterQueue(Queue<int>& queue) {
    for(int i = queue.size() - 1; i >= 0; i--) {
        int elem = queue.dequeue();
        queue.enqueue(elem);
        queue.enqueue(elem);
    }
}

void knightMoveProblem() {
    // check whether on a grid 'knight' can move from x1,y1 to x2,y2
    // where x1,x2,y1,y2 are pos on grid.
    Grid<string> grid(8, 8);
    grid[3][2] = "knight";
    if(knightCanMove(grid, 3, 2, 5, 1))
        cout << "Knight can move!" << endl;
    else
        cout << "Knight can't move!" << endl;
}

bool knightCanMove(Grid<string> grid, int x1, int y1, int x2, int y2) {
    if(!grid.inBounds(x1, y1) || !grid.inBounds(x2, y2))
        return false;

    if(!(grid[x1][y1] == "knight") || !(grid[x2][y2] == ""))
        return false;

    int dx = abs(x1 - x2);
    int dy = abs(y1 - y2);

    if( !(dx == 1 && dy == 2) && !(dy == 1 and dx ==2) )
        return false;

    return true;
}
