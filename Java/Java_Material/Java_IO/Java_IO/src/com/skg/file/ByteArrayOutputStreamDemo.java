package com.skg.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamDemo {
	public static void main(String[] args) {
		ByteArrayOutputStream f = new ByteArrayOutputStream();
		String s = "This should end up in the array";
		byte[] buf = s.getBytes();
		try {
			f.write(buf);
		} catch (IOException e) {
			System.out.println("Error Writing to Buffer");
			return;
		}
		System.out.println("Buffer as a string");
		System.out.println(f.toString());
		System.out.println("Into array");
		byte[] b = f.toByteArray();
		for (int i = 0; i < b.length; i++)
			System.out.print((char) b[i]);
		System.out.println("\nTo an OutputStream()");
	}
}
