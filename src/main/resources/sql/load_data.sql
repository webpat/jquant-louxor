#TODO : Désactiver les indexes 
set foreign_key_checks = 0 ;
LOAD DATA LOCAL INFILE 'd:/loux/candles/stock-clean.txt' into table CANDLE_STOCK 
fields terminated by ',' enclosed by '"' lines terminated by '\n'  ;

LOAD DATA LOCAL INFILE 'd:/loux/candles/etf.txt' into table CANDLE_ETF 
fields terminated by ',' enclosed by '"' lines terminated by '\n'  ;

LOAD DATA LOCAL INFILE 'd:/loux/candles/index.txt' into table CANDLE_INDEX 
fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore 4 lines ;

LOAD DATA LOCAL INFILE 'd:/loux/candles/rate.txt' into table CANDLE_RATE 
fields terminated by ',' lines terminated by '\n' ignore 4 lines ;

LOAD DATA LOCAL INFILE 'd:/loux/candles/forward.txt' into table CANDLE_FRA 
fields terminated by ',' lines terminated by '\n' ignore 4 lines ;

LOAD DATA LOCAL INFILE 'd:/loux/candles/future.txt' into table CANDLE_FUTURE 
fields terminated by ',' lines terminated by '\n' ignore 4 lines ;

LOAD DATA LOCAL INFILE 'd:/loux/candles/forex.txt' into table CANDLE_FOREX 
fields terminated by ',' lines terminated by '\n' ;
set foreign_key_checks = 1 ;

LOAD DATA LOCAL INFILE 'd:/loux/candles/option.txt' into table CANDLE_OPTION 
fields terminated by ',' lines terminated by '\n' ignore 6 lines;
set foreign_key_checks = 1 ;