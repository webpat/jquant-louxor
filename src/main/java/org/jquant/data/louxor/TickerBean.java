package org.jquant.data.louxor;

public class TickerBean {

	// QUOTATION_FACTOR,FIRST_QUOTE,LAST_QUOTE,LAST_AUDIT,START_DATE,DAILY_UPDATE,LAST_UPDATE,INSTRUMENT_CREATED,INSTRUMENT_CREATOR,INSTRUMENT_UPDATED,INSTRUMENT_UPDATER,TICKER_CREATED,TICKER_CREATOR,TICKER_UPDATED,TICKER_UPDATER
	private String internal_code;
	private String instrument_id;
	private String name;
	private String quote_percent;
	private String provider_id;
	private String provider_name;
	private String ticker;
	private String provider_market_name;
	private String mic_id;
	private String mic_code;
	private String ACRONYM;
	private String description;
	private String city;
	private String payment_currency;
	private String update_frequency;
	private String quotation_factor;
	private String first_quote;
	private String last_quote;
	private String start_date;
	
	
	
	public TickerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getInternal_code() {
		return internal_code;
	}
	public void setInternal_code(String internal_code) {
		this.internal_code = internal_code;
	}
	public String getInstrument_id() {
		return instrument_id;
	}
	public void setInstrument_id(String instrument_id) {
		this.instrument_id = instrument_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuote_percent() {
		return quote_percent;
	}
	public void setQuote_percent(String quote_percent) {
		this.quote_percent = quote_percent;
	}
	public String getProvider_id() {
		return provider_id;
	}
	public void setProvider_id(String provider_id) {
		this.provider_id = provider_id;
	}
	public String getProvider_name() {
		return provider_name;
	}
	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getProvider_market_name() {
		return provider_market_name;
	}
	public void setProvider_market_name(String provider_market_name) {
		this.provider_market_name = provider_market_name;
	}
	public String getMic_id() {
		return mic_id;
	}
	public void setMic_id(String mic_id) {
		this.mic_id = mic_id;
	}
	public String getMic_code() {
		return mic_code;
	}
	public void setMic_code(String mic_code) {
		this.mic_code = mic_code;
	}
	
	public String getACRONYM() {
		return ACRONYM;
	}
	public void setACRONYM(String aCRONYM) {
		ACRONYM = aCRONYM;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPayment_currency() {
		return payment_currency;
	}
	public void setPayment_currency(String payment_currency) {
		this.payment_currency = payment_currency;
	}
	public String getUpdate_frequency() {
		return update_frequency;
	}
	public void setUpdate_frequency(String update_frequency) {
		this.update_frequency = update_frequency;
	}
	public String getQuotation_factor() {
		return quotation_factor;
	}
	public void setQuotation_factor(String quotation_factor) {
		this.quotation_factor = quotation_factor;
	}
	public String getFirst_quote() {
		return first_quote;
	}
	public void setFirst_quote(String first_quote) {
		this.first_quote = first_quote;
	}
	public String getLast_quote() {
		return last_quote;
	}
	public void setLast_quote(String last_quote) {
		this.last_quote = last_quote;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	
}
