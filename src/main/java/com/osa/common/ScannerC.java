package com.osa.common;

import java.util.Scanner;

public class ScannerC {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter your name :");
	String name = scanner.nextLine();
	System.out.println("Enter your age :");
	int age = scanner.nextInt();
	System.out.println("Your Name Length : "+name.length());
	System.out.println("Your Name : "+name +"\nYour Age: "+age);
	
	/*
	 * If I send the value like 5: 
	 * 1+2+3+4+5==15
	 * 
	 * Enter the String value:
	 * Output: reversed order. 
	 * If the entered value is a word: Bank
	 * Output: knaB
	 * IF the enetered value is sentance: I am from Bd
	 * Output: Bd from am I
	 * 
	 * XXXXX   dB morf ma I
	 */
}

}
