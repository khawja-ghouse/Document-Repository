 package com.skg.productuser;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.skg.productuser.exception.FileNotSupportException;

public class FileExistsContentOrNot {
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource("Product.csv").getFile());
	String line, fields[];
	int count = 5;

	@Test
	public void test() throws FileNotSupportException {
		try (FileReader fin = new FileReader(file); BufferedReader bin = new BufferedReader(fin)) {
			line = bin.readLine();
			assertNotNull(line);
			fields = line.split(",");
			assertEquals(count, fields.length);
		} catch (IOException e) {
			throw new FileNotSupportException("Error in file content", e);
		}

	}

}
