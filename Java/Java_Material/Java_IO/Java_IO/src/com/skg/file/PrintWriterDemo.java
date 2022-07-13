package com.skg.file;

import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter("printWriterDemo1.txt");
		pw.write(100);
		pw.println(100);
		pw.println(true);
		pw.println('c');
		pw.println("durga");
		pw.append((char) 101);

		pw.flush();
		pw.close();
	}

}
