package com.skg.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterDemo {

	public static void main(String[] args) throws IOException {

		BufferedWriter bufferedWriterObj = new BufferedWriter(new FileWriter("abc.txt"));

		bufferedWriterObj.write(100);

		bufferedWriterObj.newLine();// Adding a new Line

		char[] ch = { 'd', 'r', 'y' };
		
		bufferedWriterObj.write(ch);// Writing array of characters
		
		bufferedWriterObj.newLine();// Adding a new Line
		
		bufferedWriterObj.write("My name is khan !!"); // writing a string
		
		bufferedWriterObj.newLine();// Adding a new Line
		
		bufferedWriterObj.flush(); // To make sure everything is written to file
		
		bufferedWriterObj.close();
		
	}
}
