LOAD DATA LOCAL INFILE 'd:/loux/tickers/stock-clean.txt' into table TICKER_STOCK 
fields terminated by ',' enclosed by '"' lines terminated by '\n'  IGNORE;

#TODO : Désactiver les indexes 
set foreign_key_checks = 0 ;
LOAD DATA LOCAL INFILE 'd:/loux/candles/stock-clean.txt' into table CANDLE_STOCK 
fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore  ;
set foreign_key_check = 1 ;
