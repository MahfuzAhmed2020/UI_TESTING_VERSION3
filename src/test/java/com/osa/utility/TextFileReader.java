package com.osa.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
	public static void main(String[] args) {
		textFileReader("C:\\Users\\mahfu\\Desktop\\ppp.txt");
	}

public static void textFileReader(String excelPath) {
	 BufferedReader br = null;

	    try {

	        String sCurrentLine;
	        br = new BufferedReader(new FileReader(excelPath));
	       // br = new BufferedReader(new FileReader("C:\\Users\\mahfu\\Desktop\\ppp.txt"/*excelPath*/));

	        while ((sCurrentLine = br.readLine()) != null) {
	            System.out.println(sCurrentLine);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (br != null)br.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }

	}
	


}
