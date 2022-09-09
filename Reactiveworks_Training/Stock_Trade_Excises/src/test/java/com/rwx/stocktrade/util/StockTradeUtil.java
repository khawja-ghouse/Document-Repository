package com.rwx.stocktrade.util;

import java.io.IOException;

public class StockTradeUtil {

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
