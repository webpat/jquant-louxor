package org.louxor.tools;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameMappingStrategy;

public class StockTickerCSVCleaner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		try {
			//CSVReader reader = new CSVReader(new FileReader("\\\\DISKSTATION\\sauvegarde\\loux\\tickers\\stock.txt"));
			CSVReader reader = new CSVReader(new FileReader("D:\\dev\\hsqldb-2.2.4\\hsqldb\\data\\tickers\\stock.txt"));
			CSVWriter writer = new CSVWriter(new FileWriter("D:\\dev\\hsqldb-2.2.4\\hsqldb\\data\\tickers\\stock-clean.txt"));
			HeaderColumnNameMappingStrategy<StockTickerBean> strat = new HeaderColumnNameMappingStrategy<StockTickerBean>();
			strat.setType(StockTickerBean.class);
			CsvToBean<StockTickerBean> csv = new CsvToBean<StockTickerBean>();
			List<StockTickerBean> list = csv.parse(strat, reader); 

			for (StockTickerBean tb : list){
				if (StringUtils.isBlank(tb.getTicker_id())){
					System.out.println(tb.toString());
				}
				
				String last_update = StringUtils.EMPTY;
				if (StringUtils.isNotBlank(tb.getLast_update())){
					last_update = DateFormatUtils.format(DateUtils.parseDate(tb.getLast_update(),new String[]{"dd/MM/yy K:mm:ss aa"}),"yyyy-MM-dd hh:mm:ss.SSSSSSSSS");
				}
				
				String nextLine[] = {tb.getINTERNAL_CODE(),tb.getInstrument_id(),tb.getName(),tb.getQuote_percent(),
						tb.getIssuer_id(),tb.getIssuer_name(),tb.getIssuer_amount(),tb.getDividend_frequency(),tb.getLot_size(),
						tb.getProvider_id(),tb.getProvider_name(),tb.getTicker_id(),tb.getTicker(),tb.getProvider_market_name(),
						tb.getMic_id(),tb.getMic_code(),tb.getACRONYM(),tb.getDescription(),tb.getCity(),tb.getPayment_currency(),tb.getFundamental_currency(),
						tb.getUpdate_frequency(),tb.getQuotation_factor(),
						DateFormatUtils.format(DateUtils.parseDate(tb.getFirst_quote(),new String[]{"dd/MM/yy"}),"yyyy-MM-dd"),//dd/MM/yy
						DateFormatUtils.format(DateUtils.parseDate(tb.getLast_quote(),new String[]{"dd/MM/yy"}),"yyyy-MM-dd"),//dd/MM/yy,//dd/MM/yy
						DateFormatUtils.format(DateUtils.parseDate(tb.getStart_date(),new String[]{"dd/MM/yy"}),"yyyy-MM-dd"),//dd/MM/yytb.getStart_date(),//dd/MM/yy
						tb.getDaily_update(),//0 ou 1
						last_update}; //dd/mm/yy h:mm:ss PM|AM
				writer.writeNext(nextLine);
			}
			
			writer.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
