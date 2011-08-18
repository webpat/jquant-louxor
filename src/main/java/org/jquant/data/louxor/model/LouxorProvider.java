package org.jquant.data.louxor.model;

public enum LouxorProvider {

	HDG(1),BLOOMBERG(2),DATASTREAM(3),PER_SECURITY(20);
	
	private Integer id;

	
	
	private LouxorProvider(Integer id) {
		this.id = id;
	}



	public Integer getId() {
		return id;
	}
	
	
}
