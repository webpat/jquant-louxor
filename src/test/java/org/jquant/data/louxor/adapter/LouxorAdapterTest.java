package org.jquant.data.louxor.adapter;

import org.joda.time.DateTime;
import org.jquant.data.Instruments;
import org.jquant.data.louxor.LouxorFacade;
import org.jquant.instrument.GenericFuture;
import org.jquant.serie.CandleSerie;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:jquant-louxor-test.xml"})
public class LouxorAdapterTest {

	@Autowired
	LouxorAdapter adapter;
	
	@Autowired
	LouxorFacade facade;
	
	@Test
	public void testReadGenericFuture() {
		GenericFuture generic1  = adapter.readGenericFuture(Instruments.CRUDEOIL, new DateTime("2000-01-01"), new DateTime("2010-01-01"), facade);
		Assert.assertNotNull(generic1);
		Assert.assertEquals(2564,generic1.getSerie().size());
		
		GenericFuture generic2  = adapter.readGenericFuture(Instruments.COPPER, new DateTime("2000-01-01"), new DateTime("2010-01-01"), facade);
		Assert.assertNotNull(generic2);
	}
	
	
	@Test
	public void testReadCandleSerie() {
		CandleSerie stockHistory  = adapter.readCandleSerie(Instruments.HEINZ, facade);
		Assert.assertNotNull(stockHistory);
		Assert.assertTrue(stockHistory.size()>0);
		
		CandleSerie trackerHistory  = adapter.readCandleSerie(Instruments.LYXOR_EUROSTOXX_50, facade);
		Assert.assertNotNull(trackerHistory);
		Assert.assertTrue(trackerHistory.size()>0);
		
		CandleSerie forexPairHistory  = adapter.readCandleSerie(Instruments.EURUSD, facade);
		Assert.assertNotNull(forexPairHistory);
		Assert.assertTrue(forexPairHistory.size()>0);
	}

}
