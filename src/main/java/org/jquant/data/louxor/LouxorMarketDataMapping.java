package org.jquant.data.louxor;

import org.jquant.data.JQuantDataProvider;
import org.jquant.data.IMarketDataProviderMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LouxorMarketDataMapping implements IMarketDataProviderMapping {

	@Autowired
	MarketDataReader reader;
	
	public Object getReader(JQuantDataProvider provider) {
		if ( JQuantDataProvider.LOUXOR.equals(provider)){
			return reader;	
		}
		return null;
	}

}
