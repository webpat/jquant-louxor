package org.jquant.data.louxor.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.louxor.dao.IndexDAO;
import org.louxor.model.CandleDTO;
import org.louxor.model.IndexTicker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:jquant-louxor-test.xml"})
public class IndexDAOTest {
	
	@Autowired
	private IndexDAO dao;

	@Test
	public void testFindByName() {
		IndexTicker ticker = dao.findByName("CAC 40");
		Assert.assertNotNull(ticker);
	}

	@Test
	public void testFindTickerIdByName() {
		String tickerId = dao.findTickerIdByName("CAC 40");
		Assert.assertEquals("2125", tickerId);
	}

	@Test
	public void testFindAllCandleByTickerId() {
		String tickerId = "2125"; //CAC 40
		List<CandleDTO> result = dao.findAllCandleByTickerId(tickerId);
		Assert.assertTrue(result.size()>1);
		for (CandleDTO candle: result){
			Assert.assertTrue(candle.getHigh()>=candle.getLow());
		}
	}

}
