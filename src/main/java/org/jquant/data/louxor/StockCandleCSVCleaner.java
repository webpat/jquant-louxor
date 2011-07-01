package org.jquant.data.louxor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

/**
 * TICKER_ID,NAME,INTERNAL_CODE,TICKER,MIC_CODE,PAYMENT_CURRENCY,TIMESTAMP,OPEN,HIGH,LOW,CLOSE,VOLUME,VWAP,OPEN_INTEREST
 * @author patrick.merheb
 *
 */
public class StockCandleCSVCleaner {

	private static final int INDEX_TIMESTAMP = 6;
	private static final int INDEX_NAME = 1;
	private static final int INDEX_TICKER = 3;
	private static final int INDEX_VOLUME = 11;
	private static final int INDEX_VWAP = 12;
	private static final int INDEX_OPEN_INTEREST = 13;
	private static final int INDEX_CLOSE = 10;
	private static final int INDEX_LOW = 9;
	private static final int INDEX_HIGH = 8;
	private static final int INDEX_OPEN = 7;

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {

		String[] row = null;

		try {
			// CSVReader reader = new CSVReader(new FileReader("\\\\DISKSTATION\\sauvegarde\\loux\\tickers\\stock.txt"));
			CSVReader reader = new CSVReader(new FileReader("D:\\dev\\hsqldb-2.2.4\\hsqldb\\data\\daily\\stock.txt"),CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER,4);
			CSVWriter writer = new CSVWriter(new FileWriter("D:\\dev\\hsqldb-2.2.4\\hsqldb\\data\\daily\\stock-clean.txt"),CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER);



			String[] header = reader.readNext();
			writer.writeNext(header);

			row = reader.readNext();
			long i = 1;
			while (row !=null){

				if (row.length==14){

					//Deal with Timestamp 
					String timestamp = StringUtils.EMPTY;
					if (StringUtils.isNotBlank(row[INDEX_TIMESTAMP])){
						try {
							timestamp = DateFormatUtils.format(DateUtils.parseDate(row[INDEX_TIMESTAMP],new String[]{"dd/MM/yy"}),"yyyy-MM-dd");
						} catch (ParseException e) {
							System.out.println("Problème de parsing de date sur la ligne: "+row[INDEX_TICKER] + row[INDEX_NAME]);
							row = reader.readNext();i = i+1;
							continue;
						}
					}else{
						System.out.println("Pas de date date sur la ligne : " + row[INDEX_TICKER]);
					}

					row[INDEX_TIMESTAMP] = timestamp;
					
					// Deal with NUMERIC VALUES
					
					String open = row[INDEX_OPEN];
					if ("null".equalsIgnoreCase(open)){
						row[INDEX_OPEN]=StringUtils.EMPTY;
					}
					
					String high = row[INDEX_HIGH];
					if ("null".equalsIgnoreCase(high)){
						row[INDEX_HIGH]=StringUtils.EMPTY;
					}
					
					String low = row[INDEX_LOW];
					if ("null".equalsIgnoreCase(low)){
						row[INDEX_LOW]=StringUtils.EMPTY;
					}
					
					String close = row[INDEX_CLOSE];
					if ("null".equalsIgnoreCase(close)){
						row[INDEX_CLOSE]=StringUtils.EMPTY;
					}
					
					
					
					String volume = row[INDEX_VOLUME];
					if ("null".equalsIgnoreCase(volume)){
						row[INDEX_VOLUME]=StringUtils.EMPTY;
					}
					
					String vwap = row[INDEX_VWAP];
					if ("null".equalsIgnoreCase(vwap)){
						row[INDEX_VWAP]=StringUtils.EMPTY;
					}
					
					String openInterest = row[INDEX_OPEN_INTEREST];
					if ("null".equalsIgnoreCase(openInterest)){
						row[INDEX_OPEN_INTEREST]=StringUtils.EMPTY;
					}
					
					
					writer.writeNext(row);				
				}else {
					System.out.printf("Problème  sur la ligne %1$d --> %2$s \n" ,i, StringUtils.join(row, ";"));
				}
				row = reader.readNext();
				i = i+1;
			}



			writer.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
