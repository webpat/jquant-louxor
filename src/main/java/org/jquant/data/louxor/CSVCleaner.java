package org.jquant.data.louxor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameMappingStrategy;

public class CSVCleaner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 try {
			CSVReader reader = new CSVReader(new FileReader("\\\\DISKSTATION\\sauvegarde\\loux\\tickers\\stock.txt"));
//			 String [] nextLine;
//			    while ((nextLine = reader.readNext()) != null) {
//			        // nextLine[] is an array of values from the line
//			        System.out.println(nextLine[0] + nextLine[1] + "etc...");
//			    }
			    
			    HeaderColumnNameMappingStrategy<TickerBean> strat = new HeaderColumnNameMappingStrategy<TickerBean>();
			    strat.setType(TickerBean.class);
			    strat.captureHeader(reader);
			   // ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
			   // strat.setType(YourOrderBean.class);
			   // String[] columns = new String[] {"name", "orderNumber", "id"}; // the fields to bind do in your JavaBean
			   // strat.setColumnMapping(columns);

			    CsvToBean<TickerBean> csv = new CsvToBean<TickerBean>();
			   
			    List<TickerBean> list = csv.parse(strat, reader); 
			    
			    for (TickerBean tb : list){
			    	System.out.println(tb.getACRONYM());
			    }
			    
			    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
