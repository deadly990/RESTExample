package test.dowjones;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

public class Stock {
	private final int quarter;
	private final String stock;
	private final Calendar date;
	private final BigDecimal open;
	private final BigDecimal high;
	private final BigDecimal low;
	private final BigDecimal close;
	public Stock(int quarter, String stock, Calendar date, BigDecimal open, BigDecimal high, BigDecimal low,
			BigDecimal close) {
		super();
		this.quarter = quarter;
		this.stock = stock;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
	}
	public int getQuarter() {
		return quarter;
	}
	public String getStock() {
		return stock;
	}
	public Calendar getDate() {
		return date;
	}
	public BigDecimal getOpen() {
		return open;
	}
	public BigDecimal getHigh() {
		return high;
	}
	public BigDecimal getLow() {
		return low;
	}
	public BigDecimal getClose() {
		return close;
	}
	
	
}
