#TODO : Désactiver les indexes 
set foreign_key_checks = 0 ;
LOAD DATA LOCAL INFILE 'd:/loux/candles/stock-clean.txt' into table CANDLE_STOCK 
fields terminated by ',' enclosed by '"' lines terminated by '\n'  ignore 1 lines
(ticker_id,name,internal_code,ticker,mic_code,payment_currency,@timestamp,open,high,low,close,volume,vwap,open_interest)
set 
timestamp=str_to_date(@timestamp, '%Y-%m-%d')
;

LOAD DATA LOCAL INFILE 'd:/loux/candles/etf.txt' into table CANDLE_TRACKER
fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore 1 lines
(ticker_id,name,internal_code,ticker,mic_code,payment_currency,@timestamp,open,high,low,close,volume,vwap,open_interest)
set 
timestamp=str_to_date(@timestamp, '%d/%m/%Y')
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
set 
timestamp=str_to_date(@timestamp, '%d/%m/%Y')
;

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