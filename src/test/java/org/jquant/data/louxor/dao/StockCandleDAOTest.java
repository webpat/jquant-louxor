package org.jquant.data.louxor.dao;


import java.util.List;

import org.jquant.data.louxor.model.StockCandle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:jquant-louxor-test.xml"})
public class StockCandleDAOTest {

	@Autowired
	private StockCandleDAO dao;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testFindAllCandleByTickerId(){
		String tickerId = "97461";
		List<StockCandle> result = dao.findAllByTickerId(tickerId);
		Assert.assertTrue(result.size()>1);
	}

}
