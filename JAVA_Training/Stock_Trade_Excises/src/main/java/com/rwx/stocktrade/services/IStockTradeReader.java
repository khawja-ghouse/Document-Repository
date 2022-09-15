package com.rwx.stocktrade.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.rwx.stocktrade.exception.FileNotSupportException;
import com.rwx.stocktrade.exception.StockTradeInValidFormatException;
import com.rwx.stocktrade.model.StockTrade;

/**
 * Interface contains the methods that be implemented on StockTrade Objects
 * 
 * @author My KS
 * @version 1.0
 */
public interface IStockTradeReader {
	/**
	 * This method reads the data from file and store into the StockTrade object and
	 * add each object into the List .
	 * 
	 * @return It returns the ArrayList
	 * @throws StockTradeInValidFormatException Used to throw an custom error is
	 *                                          File not found
	 */
	public List<StockTrade> readStockTrades() throws StockTradeInValidFormatException, FileNotSupportException;

	/**
	 * This is the method used to get the maximum volume of the list passed
	 * 
	 * @param list is accepted to get maximum
	 * @return returns the StockTrade object whose volume is maximum
	 * @throws StockTradeInValidFormatException throws custom Exception
	 */
	public StockTrade getMaxVolumeTrade(List<StockTrade> list) throws StockTradeInValidFormatException;

	/**
	 * This is the method used to get the minimum volume from the list accepted
	 * 
	 * @param list is accepted to get minimum
	 * @return returns the StockTrade object whose volume is minimum
	 */
	public StockTrade getMinVolumeTrade(List<StockTrade> list);

	/**
	 * getMinVolumeTrade() is a method used to get the Minimum volume of the <br/>
	 * of the StockTrade from List(where all the object of the StockTrade are
	 * there)<br/>
	 * 
	 * @return ::returns the StockTrade object whose volume is minimum in entire
	 *         list
	 */
	public Map<Date, Double> getDailyTradingDifferential(List<StockTrade> list);
}