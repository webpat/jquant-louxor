package org.jquant.data.louxor.tools;

public class StockTickerBean {

	// INSTRUMENT_CREATED,INSTRUMENT_CREATOR,INSTRUMENT_UPDATED,INSTRUMENT_UPDATER,TICKER_CREATED,TICKER_CREATOR,TICKER_UPDATED,TICKER_UPDATER
	private String INTERNAL_CODE;
	private String instrument_id;
	private String name;
	private String quote_percent;
	private String issuer_id;
	private String issuer_name;
	private String issuer_amount;
	private String dividend_frequency;
	private String lot_size;
	private String provider_id;
	private String provider_name;
	private String ticker;
	private String ticker_id;
	private String provider_market_name;
	private String mic_id;
	private String mic_code;
	private String ACRONYM;
	private String description;
	private String city;
	private String payment_currency;
	private String fundamental_currency;
	private String update_frequency;
	private String quotation_factor;
	private String first_quote;
	private String last_quote;
	private String start_date;
	private String daily_update;
	private String last_update;
	
	
	
	public StockTickerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getINTERNAL_CODE() {
		return INTERNAL_CODE;
	}
	public void setINTERNAL_CODE(String internal_code) {
		this.INTERNAL_CODE = internal_code;
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
	public String getDaily_update() {
		return daily_update;
	}
	public void setDaily_update(String daily_update) {
		this.daily_update = daily_update;
	}
	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	public String getIssuer_id() {
		return issuer_id;
	}
	public void setIssuer_id(String issuer_id) {
		this.issuer_id = issuer_id;
	}
	public String getIssuer_name() {
		return issuer_name;
	}
	public void setIssuer_name(String issuer_name) {
		this.issuer_name = issuer_name;
	}
	public String getIssuer_amount() {
		return issuer_amount;
	}
	public void setIssuer_amount(String issuer_amount) {
		this.issuer_amount = issuer_amount;
	}
	public String getDividend_frequency() {
		return dividend_frequency;
	}
	public void setDividend_frequency(String dividend_frequency) {
		this.dividend_frequency = dividend_frequency;
	}
	public String getLot_size() {
		return lot_size;
	}
	public void setLot_size(String lot_size) {
		this.lot_size = lot_size;
	}
	public String getTicker_id() {
		return ticker_id;
	}
	public void setTicker_id(String ticker_id) {
		this.ticker_id = ticker_id;
	}
	public String getFundamental_currency() {
		return fundamental_currency;
	}
	public void setFundamental_currency(String fundamental_currency) {
		this.fundamental_currency = fundamental_currency;
	}
	@Override
	public String toString() {
		return "StockTickerBean [INTERNAL_CODE=" + INTERNAL_CODE + ", instrument_id=" + instrument_id + ", name=" + name + ", quote_percent=" + quote_percent + ", issuer_id=" + issuer_id
				+ ", issuer_name=" + issuer_name + ", issuer_amount=" + issuer_amount + ", dividend_frequency=" + dividend_frequency + ", lot_size=" + lot_size + ", provider_id=" + provider_id
				+ ", provider_name=" + provider_name + ", ticker=" + ticker + ", ticker_id=" + ticker_id + ", provider_market_name=" + provider_market_name + ", mic_id=" + mic_id + ", mic_code="
				+ mic_code + ", ACRONYM=" + ACRONYM + ", description=" + description + ", city=" + city + ", payment_currency=" + payment_currency + ", fundamental_currency=" + fundamental_currency
				+ ", update_frequency=" + update_frequency + ", quotation_factor=" + quotation_factor + ", first_quote=" + first_quote + ", last_quote=" + last_quote + ", start_date=" + start_date
				+ ", daily_update=" + daily_update + ", last_update=" + last_update + "]";
	}
	
}
