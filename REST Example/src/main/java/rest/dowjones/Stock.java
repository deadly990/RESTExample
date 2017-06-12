package rest.dowjones;

import java.math.BigDecimal;
import java.util.Calendar;

public class Stock {
	private int quarter;
	private String stock;
	private Calendar date;
	private BigDecimal open;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal close;
	public Stock() {
		
	}
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
	
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public void setOpen(BigDecimal open) {
		this.open = open;
	}
	public void setHigh(BigDecimal high) {
		this.high = high;
	}
	public void setLow(BigDecimal low) {
		this.low = low;
	}
	public void setClose(BigDecimal close) {
		this.close = close;
	}
}
