package org.louxor.tools;

/**
 *  --TICKER_ID,NAME,INTERNAL_CODE,TICKER,MIC_CODE,PAYMENT_CURRENCY,TIMESTAMP,OPEN,HIGH,LOW,CLOSE,VOLUME,VWAP,OPEN_INTEREST
 * @author patrick.merheb
 *
 */
public class StockDailyCandleBean {

	private String INTERNAL_CODE;

	private String name;

	private String ticker_id;
	
	private String ticker;
	
	private String mic_code;

	private String payment_currency;
	
	private String timestamp;

	private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
    private String open_interest;
    
	public String getINTERNAL_CODE() {
		return INTERNAL_CODE;
	}
	public void setINTERNAL_CODE(String iNTERNAL_CODE) {
		INTERNAL_CODE = iNTERNAL_CODE;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTicker_id() {
		return ticker_id;
	}
	public void setTicker_id(String ticker_id) {
		this.ticker_id = ticker_id;
	}
	public String getMic_code() {
		return mic_code;
	}
	public void setMic_code(String mic_code) {
		this.mic_code = mic_code;
	}
	public String getPayment_currency() {
		return payment_currency;
	}
	public void setPayment_currency(String payment_currency) {
		this.payment_currency = payment_currency;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getClose() {
		return close;
	}
	public void setClose(String close) {
		this.close = close;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getOpen_interest() {
		return open_interest;
	}
	public void setOpen_interest(String open_interest) {
		this.open_interest = open_interest;
	}
    
	
}
