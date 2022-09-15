package com.rwx.stocktrade;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.junit.Test;

import com.rwx.stocktrade.exception.FileNotSupportException;
import com.rwx.stocktrade.exception.StockTradeInValidFormatException;
import com.rwx.stocktrade.model.StockTrade;
import com.rwx.stocktrade.services.impl.CSVStockTradeReader;

public class CSVStockTradeReaderTest {
	CSVStockTradeReader sn = new CSVStockTradeReader();
	static String line1;
	static String line;
	static String fields[];
	static StockTrade s1 = null;

	// String name = file.getName();
	static String aname = "cisco.txt";
	ClassLoader loder = this.getClass().getClassLoader();
	File name = new File(loder.getResource(aname).getFile());

	@Test
	public void testReaddata_FileExistaOrNot() throws IOException {
		File tmpDir = new File("src\\main\\resources\\cisco.txt");
		File temDir1 = new File("src\\test\\resources\\cisco.txt");
		assertTrue(tmpDir.exists());
		assertTrue(temDir1.exists());
	}

	@Test
	public void testReaddata_FileExisDataOrNot() {
		try (FileReader fin = new FileReader(name); BufferedReader bin = new BufferedReader(fin)) {
			line1 = bin.readLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
		assertNotNull(line1);
	}

	@Test
	public void testreadStockTrades() throws StockTradeInValidFormatException, FileNotSupportException {
		ArrayList<StockTrade> mainL = new ArrayList<>();
		mainL.addAll(sn.readStockTrades());
		ArrayList<StockTrade> listA = new ArrayList<>();
		try (FileReader fin = new FileReader(name); BufferedReader bin = new BufferedReader(fin)) {

			while ((line = bin.readLine()) != null) {
				fields = line.split(",");
				s1 = new StockTrade();
				s1.setSecuraty(fields[0]);
				s1.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(fields[1]));
				s1.setOpen(Double.parseDouble(fields[2]));
				s1.setHigh(Double.parseDouble(fields[3]));
				s1.setLow(Double.parseDouble(fields[4]));
				s1.setClose(Double.parseDouble(fields[5]));
				s1.setVolume(Double.parseDouble(fields[6]));
				s1.setAdjClose(Double.parseDouble(fields[7]));
				listA.add(s1);
			}

			assertEquals(listA, mainL);
		} catch (NumberFormatException e) {
			throw new StockTradeInValidFormatException("There is a data miss match", e);
			// TODO: handle exception
		} catch (ParseException e) {
			throw new StockTradeInValidFormatException("There is a problem with date in file", e);
		} catch (IOException e) {
			throw new FileNotSupportException("Issue with the File ", e);
		}

	}

	@Test
	public void testgetMaxVolumeTrade() throws StockTradeInValidFormatException, FileNotSupportException {
		ArrayList<StockTrade> mainL = new ArrayList<>();
		mainL.addAll(sn.readStockTrades());
		ArrayList<StockTrade> listA = new ArrayList<>();
		try (FileReader fin = new FileReader(name); BufferedReader bin = new BufferedReader(fin)) {

			while ((line = bin.readLine()) != null) {
				fields = line.split(",");
				s1 = new StockTrade();
				s1.setSecuraty(fields[0]);
				s1.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(fields[1]));
				s1.setOpen(Double.parseDouble(fields[2]));
				s1.setHigh(Double.parseDouble(fields[3]));
				s1.setLow(Double.parseDouble(fields[4]));
				s1.setClose(Double.parseDouble(fields[5]));
				s1.setVolume(Double.parseDouble(fields[6]));
				s1.setAdjClose(Double.parseDouble(fields[7]));
				listA.add(s1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Iterator<StockTrade> iterator = listA.iterator();
		StockTrade max = iterator.next();
		while (iterator.hasNext()) {
			if (max.getVolume() > iterator.next().getVolume()) {
				max = iterator.next();
			}
		}
		System.out.println(max);
		System.out.println(sn.getMaxVolumeTrade(mainL));
		assertEquals(max, sn.getMaxVolumeTrade(mainL));
	}

	@Test
	public void testgetMinVolumeTrade() throws StockTradeInValidFormatException, FileNotSupportException {
		ArrayList<StockTrade> mainL = new ArrayList<>();
		mainL.addAll(sn.readStockTrades());
		ArrayList<StockTrade> listA = new ArrayList<>();
		try (FileReader fin = new FileReader(name); BufferedReader bin = new BufferedReader(fin)) {

			while ((line = bin.readLine()) != null) {
				fields = line.split(",");
				s1 = new StockTrade();
				s1.setSecuraty(fields[0]);
				s1.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(fields[1]));
				s1.setOpen(Double.parseDouble(fields[2]));
				s1.setHigh(Double.parseDouble(fields[3]));
				s1.setLow(Double.parseDouble(fields[4]));
				s1.setClose(Double.parseDouble(fields[5]));
				s1.setVolume(Double.parseDouble(fields[6]));
				s1.setAdjClose(Double.parseDouble(fields[7]));
				listA.add(s1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Iterator<StockTrade> iterator = listA.iterator();
		StockTrade min = iterator.next();
		while (iterator.hasNext()) {
			if (min.getVolume() < iterator.next().getVolume()) {
				min = iterator.next();
			}
		}
		System.out.println(min);
		System.out.println(sn.getMinVolumeTrade(mainL));
		assertEquals(min, sn.getMinVolumeTrade(mainL));
	}

	@Test
	public void testgetDailyTradingDifferential() throws StockTradeInValidFormatException, FileNotSupportException {
		ArrayList<StockTrade> mainL = new ArrayList<>();
		mainL.addAll(sn.readStockTrades());
		ArrayList<StockTrade> listA = new ArrayList<>();
		try (FileReader fin = new FileReader(name); BufferedReader bin = new BufferedReader(fin)) {

			while ((line = bin.readLine()) != null) {
				fields = line.split(",");
				s1 = new StockTrade();
				s1.setSecuraty(fields[0]);
				s1.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(fields[1]));
				s1.setOpen(Double.parseDouble(fields[2]));
				s1.setHigh(Double.parseDouble(fields[3]));
				s1.setLow(Double.parseDouble(fields[4]));
				s1.setClose(Double.parseDouble(fields[5]));
				s1.setVolume(Double.parseDouble(fields[6]));
				s1.setAdjClose(Double.parseDouble(fields[7]));
				listA.add(s1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<Date, Double> map1 = new HashMap<>();
		Iterator<StockTrade> iterator = listA.iterator();

		while (iterator.hasNext()) {
			StockTrade s1 = iterator.next();
			map1.put(s1.getDate(), s1.getOpen() - s1.getHigh());
		}
		System.out.println(map1);
		assertEquals(map1, sn.getDailyTradingDifferential(mainL));
	}
}
