package com.skg.productuser;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FileExistsOrNot {
	public static final String USERCS_FILENAME = "User.csv";
	public static final String PRODUCTCS_FILENAME = "Product.csv";
	public static final String PRODUCTCSMAIN_FILENAME = "D:\\Excesise4\\com.reactiveworks.excesise4\\src\\main\\resources\\Product.csv";
	public static final String USERMAINCS_FILENAME = "D:\\Excesise4\\com.reactiveworks.excesise4\\src\\main\\resources\\User.csv";

	public FileExistsOrNot() {
		// TODO Auto-generated constructor stub

	}

	// File file = new File(classLoader.getResource("Product.csv").getFile());

	@Test
	public void testProductCsv() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File tmpDir = new File(classLoader.getResource(PRODUCTCS_FILENAME).getFile());
		File tmpDir1 = new File(classLoader.getResource(USERCS_FILENAME).getFile());
		File tmpDir2 = new File(PRODUCTCSMAIN_FILENAME);
		File tmpDir3 = new File(USERMAINCS_FILENAME);
		assertTrue(tmpDir.exists());
		assertTrue(tmpDir1.exists());
		assertTrue(tmpDir2.exists());
		assertTrue(tmpDir3.exists());
	}
}
