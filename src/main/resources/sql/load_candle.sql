#TODO : Désactiver les indexes 
set foreign_key_checks = 0 ;
LOAD DATA LOCAL INFILE 'd:/loux/candles/stock-clean.txt' into table CANDLE_STOCK 
fields terminated by ',' enclosed by '"' lines terminated by '\n'  ignore 1 lines
(ticker_id,name,internal_code,ticker,mic_code,payment_currency,@timestamp,open,high,low,close,volume,vwap,open_interest)
set 
timestamp=str_to_date(@timestamp, '%Y-%m-%d')
;

LOAD DATA LOCAL INFILE 'd:/loux/tickers/tracker.txt' 
into table TICKER_TRACKER fields terminated by '\t' enclosed by '"' lines terminated by '\n' ignore 1 lines
(internal_code,instrument_id,name,issuer_id,issuer_name,@inception_date,@redemption_date,lot_size,dividend_frequency,management_company,parent_company_name,ref_index_ticker,provider_name,ticker_id,ticker,provider_market_name,mic_code,payment_currency,@first_quote,@last_quote)
set 
first_quote=str_to_date(@first_quote, '%d/%m/%Y'),
last_quote=if (@last_quote='',null,str_to_date(@last_quote, '%d/%m/%Y')),
inception_date=str_to_date(@inception_date, '%d/%m/%Y'),
redemption_date=if (@redemption_date='',null,str_to_date(@redemption_date, '%d/%m/%Y'))
;

LOAD DATA LOCAL INFILE 'd:/loux/candles/index.txt' into table CANDLE_INDEX 
fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore 5 lines 
(ticker_id,name,internal_code,ticker,mic_code,payment_currency,@timestamp,open,high,low,close)
set 
timestamp=str_to_date(@timestamp, '%d/%m/%Y')
;


LOAD DATA LOCAL INFILE 'd:/loux/candles/rate.txt' into table CANDLE_RATE 
fields terminated by ',' lines terminated by '\n' ignore 5 lines 
(ticker_id,name,internal_code,ticker,mic_code,payment_currency,@timestamp,open,high,low,close,volume,vwap,open_interest)
set timestamp=str_to_date(@timestamp, '%d/%m/%Y');


LOAD DATA LOCAL INFILE 'd:/loux/candles/forward.txt' into table CANDLE_FRA 
fields terminated by ',' lines terminated by '\n' ignore 5 lines 
(ticker_id,name,internal_code,ticker,mic_code,payment_currency,@timestamp,open,high,low,close,volume,vwap,open_interest)
set 
timestamp=str_to_date(@timestamp, '%d/%m/%Y')
;

LOAD DATA LOCAL INFILE 'd:/loux/candles/future.txt' into table CANDLE_FUTURE 
fields terminated by ',' lines terminated by '\n' ignore 5 lines 
(ticker_id,name,internal_code,ticker,mic_code,payment_currency,@timestamp,open,high,low,close,volume,vwap,open_interest)
set 
timestamp=str_to_date(@timestamp, '%d/%m/%Y')
;

LOAD DATA LOCAL INFILE 'd:/loux/candles/forex.txt' into table CANDLE_FOREX 
fields terminated by ',' lines terminated by '\n' ignore 1 lines
(ticker_id,name,internal_code,ticker,mic_code,payment_currency,@timestamp,open,high,low,close,volume,vwap,open_interest)
set 
timestamp=str_to_date(@timestamp, '%d/%m/%Y')
;
set foreign_key_checks = 1 ;

LOAD DATA LOCAL INFILE 'd:/loux/candles/option.txt' into table CANDLE_OPTION 
fields terminated by ',' lines terminated by '\n' ignore 7 lines
(ticker_id,name,@timestamp,open,high,low,close,volume,vwap,open_interest)
set 
timestamp=str_to_date(@timestamp, '%d/%m/%Y')
;

set foreign_key_checks = 1 ;