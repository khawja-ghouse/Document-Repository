package com.rwx.stocktrade.services.impl;

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
import java.util.List;
import java.util.Map;

import com.rwx.stocktrade.exception.FileNotSupportException;
import com.rwx.stocktrade.exception.StockTradeInValidFormatException;
import com.rwx.stocktrade.model.StockTrade;
import com.rwx.stocktrade.services.IStockTradeReader;

/**
 * CSVStockTradeReader is a class that has the Implementation of methods
 * IStockTradeReader Interface.
 * 
 * @author My KS
 * @version 1.0
 */
public class CSVStockTradeReader implements IStockTradeReader {
	/**
	 * readStockTrades() :: It is a method which is used to read the data of the
	 * StockTrade. <br/>
	 * In csv file the data is read and store it into the instances of the of
	 * StockTrade then each <br/>
	 * is add to the List collection .
	 * 
	 * @return returns the list collection of StockTrade objects
	 */
	public List<StockTrade> readStockTrades() throws FileNotSupportException, StockTradeInValidFormatException {
		/**
		 * list is an instance of ArrayList type :used to store the StockTrade objects
		 */
		ArrayList<StockTrade> list = new ArrayList<StockTrade>();
		/**
		 * fields[] is an String type of Array line is an String type of variable
		 */
		String fields[], line;
		StockTrade s1 = null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("cisco.txt").getFile());
		try (FileReader fin = new FileReader(file); BufferedReader bin = new BufferedReader(fin)) {
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
				list.add(s1);
			}

		} catch (NumberFormatException e) {
			throw new StockTradeInValidFormatException("There is a data miss match", e);
			// TODO: handle exception
		} catch (ParseException e) {
			throw new StockTradeInValidFormatException("There is a problem with date in file", e);
		} catch (IOException e) {
			throw new StockTradeInValidFormatException("Issue with CSV file", e);
		}
		return list;
	}

	/**
	 * getMaxVolumeTrade() is a method used to get the Maximum volume of the of the
	 * StockTrade from List(where all the object of the StockTrade are there )<br/>
	 * 
	 * @return ::returns the StockTrade object whose volume is maximum in entire
	 *         list
	 */

	public StockTrade getMaxVolumeTrade(List<StockTrade> list) {
		/**
		 * Iterator is used to traverse the list one by one
		 */
		Iterator<StockTrade> iterator = list.iterator();
		StockTrade max = iterator.next();
		while (iterator.hasNext()) {
			if (max.getVolume() > iterator.next().getVolume()) {
				max = iterator.next();
			}
		}

		return max;
	}

	/**
	 * getMinVolumeTrade() is a method used to get the Minimum volume of the <br/>
	 * of the StockTrade from List(where all the object of the StockTrade are
	 * there)<br/>
	 * 
	 * @return ::returns the StockTrade object whose volume is minimum in entire
	 *         list
	 */
	@Override
	public StockTrade getMinVolumeTrade(List<StockTrade> list) {
		/**
		 * Iterator is used to traverse the list one by one
		 */
		Iterator<StockTrade> iterator = list.iterator();
		StockTrade min = iterator.next();
		while (iterator.hasNext()) {
			if (min.getVolume() < iterator.next().getVolume()) {
				min = iterator.next();
			}

		}

		return min;

	}

	/**
	 * Method is used to get the Differential value of open and high of every object
	 * in List <br/>
	 * Each differential value is stored in map. <br/>
	 * In map key value is the date of that object and value is the differential
	 * value.
	 * 
	 * @return ::returns the Map <key = date,value = differential value>
	 */
	public Map<Date, Double> getDailyTradingDifferential(List<StockTrade> list) {
		/**
		 * map1 is a Map type Collection
		 */
		Map<Date, Double> map1 = new HashMap<>();
		/**
		 * Iterator is used to traverse the list one by one
		 */
		Iterator<StockTrade> iterator = list.iterator();

		while (iterator.hasNext()) {
			StockTrade s1 = iterator.next();
			map1.put(s1.getDate(), s1.getOpen() - s1.getHigh());
		}

		return map1;
	}

}
