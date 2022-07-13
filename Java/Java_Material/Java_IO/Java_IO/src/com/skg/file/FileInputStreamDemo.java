package com.skg.file;

import java.io.FileInputStream;
import java.io.IOException;

class FileInputStreamDemo {
	public static void main(String[] args) {
		int size;
		// Use try-with-resources to close the stream.
		try (FileInputStream f = new FileInputStream(
				"D:\\Khawja_Ghouse\\Study_Material\\java\\workspace\\Java_IO\\src\\com\\skg\\file\\demo.txt")) {
			System.out.println("Total Available Bytes: " + (size = f.available()));
			int n = size / 40;
			System.out.println("First " + n + " bytes of the file one read() at a time");
			for (int i = 0; i < n; i++) {
				// System.out.println(i);
				System.out.println( f.read());
			}
			System.out.println("\nStill Available: " + f.available());

			System.out.println("Reading the next " + n + " with one read(b[])");

			// As the length of bytes we are giving f.read(b) that many byte read will be
			// completed.
			byte[] b = new byte[200];
			if (f.read(b) != 200) {
				System.err.println("couldn’t read " + n + " bytes.");
			}
			System.out.println(new String(b, 0, 200));
			System.out.println("\nStill Available: " + (size = f.available()));
			System.out.println("Skipping half of remaining bytes with skip()");
			f.skip(size / 2);
			System.out.println("Still Available: " + f.available());
			System.out.println("Reading " + n / 2 + " into the end of array");
			if (f.read(b, n / 2, n / 2) != n / 2) {
				System.err.println("couldn’t read " + n / 2 + " bytes.");
			}
			System.out.println(new String(b, 0, b.length));
			System.out.println("\nStill Available: " + f.available());
		} catch (IOException e) {
			System.out.println("I/O Error: " + e);
		}
	}
}
