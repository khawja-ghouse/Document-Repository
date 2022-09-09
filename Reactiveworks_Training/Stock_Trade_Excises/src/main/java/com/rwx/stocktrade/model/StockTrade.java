package com.rwx.stocktrade.model;

import java.util.Date;

/**
 * StockTrade is a class that implements the requirements of each StockTrade
 * created
 * 
 * @author My KS
 * @version 1.0
 */
public class StockTrade {

	/**
	 * Security is a String that is used to keep name of company
	 */
	String securaty;
	/**
	 * date is of type Date that is used to store Date of joining of Strader
	 */
	Date date;
	/**
	 * open is used to set the open value of StockTrader
	 */
	double open;
	/**
	 * high is used to set the open value of StockTrader
	 */
	double high;
	/**
	 * low is used to set the open value of StockTrader
	 */
	double low;
	/**
	 * close is used to set the open value of StockTrader
	 */
	double close;
	/**
	 * volume is used to set the open value of StockTrader
	 */
	double volume;
	/**
	 * adjClose is used to set the open value of StockTrader
	 */
	double adjClose;

	/**
	 * getSecuraty is method used to get securaty value
	 * 
	 * @return returns the security value
	 */
	public String getSecuraty() {
		return securaty;
	}

	/**
	 * setSecuraty is a method used to set the security of an instance
	 * 
	 * @param securaty :: security value of an instance
	 */
	public void setSecuraty(String securaty) {
		this.securaty = securaty;
	}

	/**
	 * getDate is method used to get date value
	 * 
	 * @return returns the date of an instance
	 */

	public Date getDate() {
		return date;
	}

	/**
	 * setDate is a method used to set the date of an instance
	 * 
	 * @param date :: date value of an instance
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * getOpen is method used to get open value
	 * 
	 * @return returns the open of an instance
	 */

	public double getOpen() {
		return open;
	}

	/**
	 * setOpen is a method used to set the open of an instance
	 * 
	 * @param open :: open value of an instance
	 */
	public void setOpen(double open) {
		this.open = open;
	}

	/**
	 * getHigh is method used to get high value
	 * 
	 * @return returns the high of an instance
	 */

	public double getHigh() {
		return high;
	}

	/**
	 * setHigh is a method used to set the high of an instance
	 * 
	 * @param high :: high value of an instance
	 */
	public void setHigh(double high) {
		this.high = high;
	}

	/**
	 * getLow is method used to get low value
	 * 
	 * @return returns the low of an instance
	 */

	public double getLow() {
		return low;
	}

	/**
	 * setLow is a method used to set the low of an instance
	 * 
	 * @param low :: low value of an instance
	 */
	public void setLow(double low) {
		this.low = low;
	}

	/**
	 * getClose is method used to get close value
	 * 
	 * @return returns the close of an instance
	 */

	public double getClose() {
		return close;
	}

	/**
	 * setClose is a method used to set the close of an instance
	 * 
	 * @param close :: close value of an instance
	 */

	public void setClose(double close) {
		this.close = close;
	}

	/**
	 * getVolume is method used to get volume value
	 * 
	 * @return returns the volume of an instance
	 */

	public double getVolume() {
		return volume;
	}

	/**
	 * setVolume is a method used to set the volume of an instance
	 * 
	 * @param volume :: volume value of an instance
	 */

	public void setVolume(double volume) {
		this.volume = volume;
	}

	/**
	 * getAdjClose is method used to get adjClose value
	 * 
	 * @return returns the adjClose of an instance
	 */

	public double getAdjClose() {
		return adjClose;
	}

	/**
	 * setAdjClose is a method used to set the adjClose of an instance
	 * 
	 * @param adjClose :: adjClose value of an instance
	 */
	public void setAdjClose(double adjClose) {
		this.adjClose = adjClose;
	}

	/**
	 * hashCode is a method ::Whenever it is invoked on the same<br/>
	 * object more than once during an execution of a Java application, <br/>
	 * the hashCode method must consistently return the same integer, <br/>
	 * provided no information used in equals comparisons on the object is modified.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(adjClose);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(close);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		temp = Double.doubleToLongBits(high);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(low);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(open);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((securaty == null) ? 0 : securaty.hashCode());
		temp = Double.doubleToLongBits(volume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * equals(Object obj): a method provided by java.lang.Object that indicates
	 * whether<br/>
	 * some other object passed as an argument is "equal to" the current
	 * instance.<br/>
	 * The default implementation provided by the JDK is based on memory location
	 * —<br/>
	 * two objects are equal if and only if they are stored in the same memory
	 * address
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockTrade other = (StockTrade) obj;
		if (Double.doubleToLongBits(adjClose) != Double.doubleToLongBits(other.adjClose))
			return false;
		if (Double.doubleToLongBits(close) != Double.doubleToLongBits(other.close))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(high) != Double.doubleToLongBits(other.high))
			return false;
		if (Double.doubleToLongBits(low) != Double.doubleToLongBits(other.low))
			return false;
		if (Double.doubleToLongBits(open) != Double.doubleToLongBits(other.open))
			return false;
		if (securaty == null) {
			if (other.securaty != null)
				return false;
		} else if (!securaty.equals(other.securaty))
			return false;
		if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume))
			return false;
		return true;
	}

	/**
	 * toString() is a method used to print the instance of StockTrade Class<br/>
	 * in a required manner.
	 */
	@Override
	public String toString() {
		return "StockTrade [securaty=" + securaty + ", date=" + date + ", open=" + open + ", high=" + high + ", low="
				+ low + ", close=" + close + ", volume=" + volume + ", adjClose=" + adjClose + "]";
	}

}
