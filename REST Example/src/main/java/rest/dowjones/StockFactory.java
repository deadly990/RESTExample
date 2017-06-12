package rest.dowjones;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.validator.routines.CalendarValidator;
import org.apache.commons.validator.routines.IntegerValidator;

public class StockFactory {
	public  ArrayList<Stock> stocks;
	public StockFactory() {
		try {
			stocks = LoadStocksFromFlatFile();
		} catch (Exception e) {
			stocks = new ArrayList<Stock>();
		}
	}
	private ArrayList<Stock> LoadStocksFromFlatFile() throws Exception {
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		try {
			
			InputStream in = StockFactory.class.getResourceAsStream("dow_jones_index.data");
			CSVParser parser = new CSVParser(new InputStreamReader(in), CSVFormat.DEFAULT);
			List<CSVRecord> list = parser.getRecords();
			IntegerValidator iv = IntegerValidator.getInstance();
			CalendarValidator cv = CalendarValidator.getInstance();
			for (CSVRecord r : list) {
				Integer quarter = iv.validate(r.get(0));
				String stock = r.get(1);
				Calendar date = cv.validate(r.get(2));
				BigDecimal open = new BigDecimal(r.get(3).substring(1));
				BigDecimal high = new BigDecimal(r.get(4).substring(1));
				BigDecimal low = new BigDecimal(r.get(5).substring(1));
				BigDecimal close = new BigDecimal(r.get(6).substring(1));
				
				stocks.add(new Stock(quarter, stock, date, open, high, low, close));
			}
			parser.close();
			in.close();
		} catch (FileNotFoundException e) {
			System.err.println("Unable to find file, path not valid");
			throw new Exception("Unable to find file, path not valid", e);
		} catch (IOException e) {
			System.err.println("Unable to read file, CSV not Valid");
			throw new Exception("Unable to read file, CSV not valid", e);
		}
		return stocks;
	}
	public Stock GetStock(long id) {
		if (id >= stocks.size()) {
			throw new IndexOutOfBoundsException();
		} else {
			System.out.println((int) id);
			return stocks.get((int) id);
		}
	}
}
