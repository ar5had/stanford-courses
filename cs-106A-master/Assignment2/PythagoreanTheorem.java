/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends DialogProgram {
	public void run() {
		int a,b;
		a=readInt("enter a? ");
		b=readInt("enter b? ");
		double c;
		c=Math.sqrt(a*a+b*b);
		println("c will be = "+c+" according to PT");
	}
}
