package com.skg.userproduct.util;

import java.io.IOException;

public class ProductUserUtil {

	public String getResourceFile(String fileName) throws IOException {
		String fileData = null;
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			fileData = classLoader.getResourceAsStream(fileName).toString();
			return fileData;
		} catch (Exception e) {
			throw new IOException("Unable to find the required file " + fileName);
		}

	}
}
