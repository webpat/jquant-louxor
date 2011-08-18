LOAD DATA LOCAL INFILE 'd:/loux/tickers/stock-clean.txt' into table TICKER_STOCK fields terminated by ',' enclosed by '"' lines terminated by '\n';

LOAD DATA LOCAL INFILE 'd:/loux/tickers/tracker.txt' 
into table TICKER_ETF fields terminated by ',' enclosed by '"' lines terminated by '\n';

LOAD DATA LOCAL INFILE 'd:/loux/tickers/index.txt' 
into table TICKER_INDEX fields terminated by ',' enclosed by '"' lines terminated by '\n';

LOAD DATA LOCAL INFILE 'd:/loux/tickers/rate_term_structure.txt' 
into table TICKER_RATE fields terminated by ','  lines terminated by '\n';

LOAD DATA LOCAL INFILE 'd:/loux/tickers/forward_rate_term_structure.txt' 
into table TICKER_FRA fields terminated by ','  lines terminated by '\n';

LOAD DATA LOCAL INFILE 'd:/loux/tickers/future.txt' 
into table TICKER_FUTURE fields terminated by ','  lines terminated by '\n';

LOAD DATA LOCAL INFILE 'd:/loux/tickers/forex.txt' 
into table TICKER_FOREX fields terminated by ','  lines terminated by '\n';

LOAD DATA LOCAL INFILE 'd:/loux/tickers/volatility_term_structure.txt' 
into table TICKER_VOL fields terminated by ','  lines terminated by '\n';

LOAD DATA LOCAL INFILE 'd:/loux/tickers/option.txt' 
into table TICKER_OPTION fields terminated by ','  lines terminated by '\n';