package org.jquant.data.louxor.adapter;

import org.jquant.data.JQuantDataProvider;
import org.jquant.data.IMarketDataProviderMapping;
import org.jquant.data.louxor.LouxorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LouxorMapping implements IMarketDataProviderMapping {

	@Autowired
	LouxorFacade reader;
	
	public Object getReader(JQuantDataProvider provider) {
		if ( JQuantDataProvider.LOUXOR.equals(provider)){
			return reader;	
		}
		return null;
	}

}
