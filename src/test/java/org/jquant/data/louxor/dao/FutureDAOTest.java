package org.jquant.data.louxor.dao;

import java.util.List;

import org.joda.time.DateTime;
import org.jquant.data.Instruments;
import org.jquant.data.louxor.model.CandleDTO;
import org.jquant.data.louxor.model.FutureTicker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:jquant-louxor-test.xml"})
public class FutureDAOTest {

	
	@Autowired
	FutureDAO dao;
	
	
	@Test
	public void testFindAllByExactName() {
		String instrumentCode = Instruments.CRUDEOIL.getCode();
		String micCode = Instruments.CRUDEOIL.getExchange().getCode();
		List<FutureTicker> list = dao
				.findAll(instrumentCode, micCode, 
				new DateTime("1983-06-01"),
				new DateTime("2010-01-01"));
		Assert.assertTrue(list.size()==309);
		
	}

	@Test
	public void testFindAllCandleByTickerId() {
		List<CandleDTO> candles = dao.findAllCandleByTickerId("34020");
		Assert.assertTrue(candles.get(0).getHigh()>0);
		
	}

	@Test
	public void testFind() {
		
		FutureTicker ticker = dao.find("US 30Y BOND" , "XCBT", 1977, 12);
		Assert.assertNotNull(ticker);
	}

}
