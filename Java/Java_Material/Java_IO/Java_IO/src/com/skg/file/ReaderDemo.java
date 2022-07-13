package com.skg.file;

import java.io.*;

public class ReaderDemo {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = new FileInputStream(
				"D:\\Khawja_Ghouse\\Study_Material\\java\\workspace\\Java_IO\\file1.txt");
		System.out.println(inputStream.read());
		Reader inputStreamReader = new InputStreamReader(inputStream);

		int data = inputStreamReader.read();
		while (data != -1) {
			char theChar = (char) data;
			System.out.println("As a character :" + theChar);
			data = inputStreamReader.read();
			System.out.println("Data : " + data);
		}

		inputStreamReader.close();
	}
}
