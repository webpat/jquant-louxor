package org.jquant.data.louxor.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.louxor.dao.TrackerDAO;
import org.louxor.model.CandleDTO;
import org.louxor.model.TrackerTicker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:jquant-louxor-test.xml"})
public class TrackerDAOTest {

	
	@Autowired
	private TrackerDAO dao;
	
	@Test
	public void testFindByISIN() {
		 // 480058 JP3027630007  HDG_JP   NOMURA ETF - TOPIX           2001-07-11     2001-07-13  2010-02-23


		String isin = "JP3027630007";
		TrackerTicker ticker = dao.findByISIN(isin);
		Assert.assertNotNull(ticker);
	}

	@Test
	public void testFindTickerIdByISIN() {
		String isin = "JP3027630007";
		String tickerId = dao.findTickerIdByISIN(isin);
		Assert.assertTrue(StringUtils.isNotBlank(tickerId));
	}

	@Test
	public void testFindAllCandleByTickerId() {
		String tickerId = "480058";
		List<CandleDTO> result = dao.findAllCandleByTickerId(tickerId);
		Assert.assertTrue(result.size()>1);
		for (CandleDTO candle: result){
			Assert.assertTrue(candle.getHigh()>=candle.getLow());
		}
	}

}
