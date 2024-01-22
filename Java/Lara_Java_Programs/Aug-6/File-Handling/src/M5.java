package com.lara;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class M5 
{
	public static void main(String[] args) throws IOException
	{
		File f1 = new File("test1.txt");
		FileReader fin = new FileReader(f1);
		char[] data = new char[(int) f1.length()];
		//char[] data = new char[10];
		fin.read(data);
		String s1 = new String(data);
		System.out.println(s1);
		
	}
}
