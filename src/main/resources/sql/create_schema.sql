CREATE TABLE IF NOT EXISTS TICKER_STOCK
(	INTERNAL_CODE VARCHAR(255),
	INSTRUMENT_ID INTEGER,
	NAME VARCHAR(255),
	QUOTE_PERCENT BOOLEAN,
	ISSUER_ID INTEGER,
	ISSUER_NAME VARCHAR(255),
	ISSUE_AMOUNT INTEGER,
	DIVIDEND_FREQUENCY VARCHAR(30),
	LOT_SIZE INTEGER,
	PROVIDER_ID INTEGER,
	PROVIDER_NAME VARCHAR(30),
	TICKER_ID INTEGER NOT NULL,
 	TICKER VARCHAR(255),
 	PROVIDER_MARKET_NAME VARCHAR(30),
 	MIC_ID INTEGER,
 	MIC_CODE VARCHAR(30),
 	ACRONYM VARCHAR(30),
 	DESCRIPTION VARCHAR(255),
 	CITY VARCHAR(30),
 	PAYMENT_CURRENCY VARCHAR(30),
 	FUNDAMENTAL_CURRENCY VARCHAR(30),
 	UPDATE_FREQUENCY VARCHAR(1),
 	QUOTATION_FACTOR NUMERIC[16,4],
 	FIRST_QUOTE DATE,
 	LAST_QUOTE DATE,
 	START_DATE DATE,
 	DAILY_UPDATE INTEGER,
 	LAST_UPDATE VARCHAR(30),
 	CONSTRAINT TICKER__PK PRIMARY KEY(TICKER_ID)
 );
 	
CREATE TABLE IF NOT EXISTS  CANDLE_STOCK
(	TICKER_ID INTEGER NOT NULL,
	NAME VARCHAR(255),
	INTERNAL_CODE VARCHAR(255),
	TICKER VARCHAR(255),
	MIC_CODE VARCHAR(30),
	PAYMENT_CURRENCY VARCHAR(30),
	TIMESTAMP DATE,
	OPEN NUMERIC[16,4],
	HIGH NUMERIC[16,4],
	LOW NUMERIC[16,4],
	CLOSE NUMERIC[16,4],
	VOLUME INTEGER,
	VWAP NUMERIC[16,4],
	OPEN_INTEREST NUMERIC[16,4],
	CONSTRAINT FK_CANDLE_TICKER FOREIGN KEY (TICKER_ID) references TICKER_STOCK(TICKER_ID)
	);
	
alter table candle_stock add index candle_IDX (ticker_id,timestamp);

CREATE TABLE IF NOT EXISTS TICKER_ETF
(	
	INTERNAL_CODE VARCHAR(255),
	INSTRUMENT_ID INTEGER,
	NAME VARCHAR(255),
	QUOTE_PERCENT BOOLEAN,
	ISSUER_ID INTEGER,
	ISSUER_NAME VARCHAR(255),
	INCEPTION_DATE DATE,
	REDEMPTION_DATE DATE,
	LOT_SIZE INTEGER,
	DIVIDEND_FREQUENCY VARCHAR(30),
	MANAGEMENT_COMPANY VARCHAR(30),
	PARENT_COMPANY_NAME VARCHAR(30),
	REF_INDEX_TICKER INTEGER,
	UNDERLYING_INSTRUMENT_ID INTEGER,
	UNDERLYING_INSTRUMENT_NAME VARCHAR(30),
	UNDERLYING_INSTRUMENT_TYPE VARCHAR(30),
	UNDERLYING_INSTRUMENT_CODE VARCHAR(30),
	UNDERLYING_TICKER_ID VARCHAR(30),
	UNDERLYING_TICKER VARCHAR(30),
	UNDERLYING_MIC_ID INTEGER,
	UNDERLYING_MIC_CODE VARCHAR(30),
	PROVIDER_ID INTEGER,
	PROVIDER_NAME VARCHAR(30),
	TICKER_ID INTEGER NOT NULL,
 	TICKER VARCHAR(255),
 	PROVIDER_MARKET_NAME VARCHAR(30),
 	MIC_ID INTEGER,
 	MIC_CODE VARCHAR(30),
 	ACRONYM VARCHAR(30),
 	DESCRIPTION VARCHAR(255),
 	CITY VARCHAR(30),
 	PAYMENT_CURRENCY VARCHAR(30),
 	FUNDAMENTAL_CURRENCY VARCHAR(30),
 	UPDATE_FREQUENCY VARCHAR(1),
 	QUOTATION_FACTOR NUMERIC[16,4],
 	FIRST_QUOTE DATE,
 	LAST_QUOTE DATE,
 	START_DATE DATE,
 	DAILY_UPDATE INTEGER,
 	LAST_UPDATE VARCHAR(30),
 	CONSTRAINT TICKER__PK PRIMARY KEY(TICKER_ID)
 );
 
 CREATE TABLE IF NOT EXISTS  CANDLE_ETF
(	TICKER_ID INTEGER NOT NULL,
	NAME VARCHAR(255),
	INTERNAL_CODE VARCHAR(255),
	TICKER VARCHAR(255),
	MIC_CODE VARCHAR(30),
	PAYMENT_CURRENCY VARCHAR(30),
	TIMESTAMP DATE,
	OPEN NUMERIC[16,4],
	HIGH NUMERIC[16,4],
	LOW NUMERIC[16,4],
	CLOSE NUMERIC[16,4],
	VOLUME INTEGER,
	VWAP NUMERIC[16,4],
	OPEN_INTEREST NUMERIC[16,4],
	CONSTRAINT FK_CANDLE_ETF FOREIGN KEY (TICKER_ID) references TICKER_ETF(TICKER_ID)
	);
	
CREATE TABLE IF NOT EXISTS TICKER_INDEX
(	
	INTERNAL_CODE VARCHAR(255),
	INSTRUMENT_ID INTEGER,
	NAME VARCHAR(255),
	QUOTE_PERCENT BOOLEAN,
	PROVIDER_ID INTEGER,
	PROVIDER_NAME VARCHAR(30),
	TICKER_ID INTEGER NOT NULL,
 	TICKER VARCHAR(255),
 	PROVIDER_MARKET_NAME VARCHAR(30),
 	MIC_ID INTEGER,
 	MIC_CODE VARCHAR(30),
 	ACRONYM VARCHAR(30),
 	DESCRIPTION VARCHAR(255),
 	CITY VARCHAR(30),
 	PAYMENT_CURRENCY VARCHAR(30),
 	UPDATE_FREQUENCY VARCHAR(1),
 	QUOTATION_FACTOR NUMERIC[16,4],
 	FIRST_QUOTE DATE,
 	LAST_QUOTE DATE,
 	START_DATE DATE,
 	DAILY_UPDATE INTEGER,
 	LAST_UPDATE VARCHAR(30),
 	CONSTRAINT TICKER__PK PRIMARY KEY(TICKER_ID)
 );
 
 CREATE TABLE IF NOT EXISTS  CANDLE_INDEX
(	TICKER_ID INTEGER NOT NULL,
	NAME VARCHAR(255),
	INTERNAL_CODE VARCHAR(255),
	TICKER VARCHAR(255),
	MIC_CODE VARCHAR(30),
	PAYMENT_CURRENCY VARCHAR(30),
	TIMESTAMP DATE,
	OPEN NUMERIC[16,4],
	HIGH NUMERIC[16,4],
	LOW NUMERIC[16,4],
	CLOSE NUMERIC[16,4],
	VOLUME INTEGER,
	VWAP NUMERIC[16,4],
	OPEN_INTEREST NUMERIC[16,4],
	CONSTRAINT FK_CANDLE_INDEX FOREIGN KEY (TICKER_ID) references TICKER_INDEX(TICKER_ID)
	);

CREATE TABLE IF NOT EXISTS TICKER_RATE
(	
	TICKER_ID INTEGER NOT NULL,	
	INTERNAL_CODE VARCHAR(255),
 	PAYMENT_CURRENCY VARCHAR(30),
 	MATURITY NUMERIC[16,4],
 	TIME_UNIT VARCHAR(1),
 	CONSTRAINT TICKER__PK PRIMARY KEY(TICKER_ID)
 );
 
  CREATE TABLE IF NOT EXISTS  CANDLE_RATE
(	TICKER_ID INTEGER NOT NULL,
	NAME VARCHAR(255),
	INTERNAL_CODE VARCHAR(255),
	TICKER VARCHAR(255),
	MIC_CODE VARCHAR(30),
	PAYMENT_CURRENCY VARCHAR(30),
	TIMESTAMP DATE,
	OPEN NUMERIC[16,4],
	HIGH NUMERIC[16,4],
	LOW NUMERIC[16,4],
	CLOSE NUMERIC[16,4],
	VOLUME INTEGER,
	VWAP NUMERIC[16,4],
	OPEN_INTEREST NUMERIC[16,4],
	CONSTRAINT FK_CANDLE_RATE FOREIGN KEY (TICKER_ID) references TICKER_RATE(TICKER_ID)
	);

	CREATE TABLE IF NOT EXISTS TICKER_FRA
(	
	TICKER_ID INTEGER NOT NULL,	
	INTERNAL_CODE VARCHAR(255),
 	PAYMENT_CURRENCY VARCHAR(30),
 	FOREIGN_CURRENCY VARCHAR(30),
 	MATURITY NUMERIC[16,4],
 	TIME_UNIT VARCHAR(1),
 	CONSTRAINT TICKER__PK PRIMARY KEY(TICKER_ID)
 );
 
  CREATE TABLE IF NOT EXISTS  CANDLE_FRA
(	TICKER_ID INTEGER NOT NULL,
	NAME VARCHAR(255),
	INTERNAL_CODE VARCHAR(255),
	TICKER VARCHAR(255),
	MIC_CODE VARCHAR(30),
	PAYMENT_CURRENCY VARCHAR(30),
	TIMESTAMP DATE,
	OPEN NUMERIC[16,4],
	HIGH NUMERIC[16,4],
	LOW NUMERIC[16,4],
	CLOSE NUMERIC[16,4],
	VOLUME INTEGER,
	VWAP NUMERIC[16,4],
	OPEN_INTEREST NUMERIC[16,4],
	CONSTRAINT FK_CANDLE_FRA FOREIGN KEY (TICKER_ID) references TICKER_FRA(TICKER_ID)
	);
	
CREATE TABLE IF NOT EXISTS TICKER_FUTURE
(	
	INTERNAL_CODE VARCHAR(255),
	INSTRUMENT_ID INTEGER,
	NAME VARCHAR(255),
	QUOTE_PERCENT BOOLEAN,
	FIRST_TRADE_DATE DATE,
 	LAST_TRADE_DATE DATE,
 	FIRST_NOTICE_DATE DATE,
 	FIRST_DELIVERY_DATE DATE,
 	LAST_DELIVERY_DATE DATE,
 	BASIS_POINT_VALUE INTEGER,
 	NOTIONAL_BOND VARCHAR(30),
 	QUOTE_UNITS NUMERIC[16,4],
 	SHORT_NAME VARCHAR(30),
	TICK_SIZE INTEGER,
	PROVIDER_ID INTEGER,
	UNDERLYING_INSTRUMENT_ID INTEGER,
	UNDERLYING_INSTRUMENT_NAME VARCHAR(30),
	UNDERLYING_INSTRUMENT_TYPE VARCHAR(30),
	UNDERLYING_INSTRUMENT_CODE VARCHAR(30),
	UNDERLYING_TICKER_ID VARCHAR(30),
	UNDERLYING_TICKER VARCHAR(30),
	UNDERLYING_MIC_ID INTEGER,
	UNDERLYING_MIC_CODE VARCHAR(30),
	PROVIDER_NAME VARCHAR(30),
	TICKER_ID INTEGER NOT NULL,
 	TICKER VARCHAR(255),
 	PROVIDER_MARKET_NAME VARCHAR(30),
 	MIC_ID INTEGER,
 	MIC_CODE VARCHAR(30),
 	ACRONYM VARCHAR(30),
 	DESCRIPTION VARCHAR(255),
 	CITY VARCHAR(30),
 	PAYMENT_CURRENCY VARCHAR(30),
 	FUNDAMENTAL_CURRENCY VARCHAR(30),
 	UPDATE_FREQUENCY VARCHAR(1),
 	QUOTATION_FACTOR NUMERIC[16,4],
 	FIRST_QUOTE DATE,
 	LAST_QUOTE DATE,
 	START_DATE DATE,
 	DAILY_UPDATE INTEGER,
 	LAST_UPDATE VARCHAR(30),
 	CONSTRAINT TICKER__PK PRIMARY KEY(TICKER_ID)
 );
 
 CREATE TABLE IF NOT EXISTS  CANDLE_FUTURE
(	TICKER_ID INTEGER NOT NULL,
	NAME VARCHAR(255),
	INTERNAL_CODE VARCHAR(255),
	TICKER VARCHAR(255),
	MIC_CODE VARCHAR(30),
	PAYMENT_CURRENCY VARCHAR(30),
	TIMESTAMP DATE,
	OPEN NUMERIC[16,4],
	HIGH NUMERIC[16,4],
	LOW NUMERIC[16,4],
	CLOSE NUMERIC[16,4],
	VOLUME INTEGER,
	VWAP NUMERIC[16,4],
	OPEN_INTEREST NUMERIC[16,4],
	CONSTRAINT FK_CANDLE_FUTURE FOREIGN KEY (TICKER_ID) references TICKER_FUTURE(TICKER_ID)
	);
	
CREATE TABLE IF NOT EXISTS TICKER_FOREX
(	
	INTERNAL_CODE VARCHAR(255),
	INSTRUMENT_ID INTEGER,
	NAME VARCHAR(255),
	QUOTE_PERCENT BOOLEAN,
	PROVIDER_ID INTEGER,
	PROVIDER_NAME VARCHAR(30),
	TICKER_ID INTEGER NOT NULL,
 	TICKER VARCHAR(255),
 	PROVIDER_MARKET_NAME VARCHAR(30),
 	MIC_ID INTEGER,
 	MIC_CODE VARCHAR(30),
 	ACRONYM VARCHAR(30),
 	DESCRIPTION VARCHAR(255),
 	CITY VARCHAR(30),
 	PAYMENT_CURRENCY VARCHAR(30),
 	UPDATE_FREQUENCY VARCHAR(1),
 	QUOTATION_FACTOR NUMERIC[16,4],
 	FIRST_QUOTE DATE,
 	LAST_QUOTE DATE,
 	START_DATE DATE,
 	DAILY_UPDATE INTEGER,
 	LAST_UPDATE VARCHAR(30),
 	CONSTRAINT TICKER__PK PRIMARY KEY(TICKER_ID)
 );
 
 CREATE TABLE IF NOT EXISTS  CANDLE_FOREX
(	TICKER_ID INTEGER NOT NULL,
	NAME VARCHAR(255),
	INTERNAL_CODE VARCHAR(255),
	TICKER VARCHAR(255),
	MIC_CODE VARCHAR(30),
	PAYMENT_CURRENCY VARCHAR(30),
	TIMESTAMP DATE,
	OPEN NUMERIC[16,4],
	HIGH NUMERIC[16,4],
	LOW NUMERIC[16,4],
	CLOSE NUMERIC[16,4],
	VOLUME INTEGER,
	VWAP NUMERIC[16,4],
	OPEN_INTEREST NUMERIC[16,4],
	CONSTRAINT FK_CANDLE_FOREX FOREIGN KEY (TICKER_ID) references TICKER_FOREX(TICKER_ID)
	);
	
CREATE TABLE IF NOT EXISTS TICKER_VOL
(	
	TICKER_ID INTEGER NOT NULL,	
	INTERNAL_CODE VARCHAR(255),
 	UNDERLYING_TICKER_ID INTEGER,
 	TYPE VARCHAR(1),
 	STRIKE NUMERIC[16,4],
 	MATURITY NUMERIC[16,4],
 	TIME_UNIT VARCHAR(1),
 	CONSTRAINT TICKER__PK PRIMARY KEY(TICKER_ID)
 );
 
  CREATE TABLE IF NOT EXISTS  CANDLE_VOL
(	TICKER_ID INTEGER NOT NULL,
	NAME VARCHAR(255),
	INTERNAL_CODE VARCHAR(255),
	TICKER VARCHAR(255),
	MIC_CODE VARCHAR(30),
	PAYMENT_CURRENCY VARCHAR(30),
	TIMESTAMP DATE,
	OPEN NUMERIC[16,4],
	HIGH NUMERIC[16,4],
	LOW NUMERIC[16,4],
	CLOSE NUMERIC[16,4],
	VOLUME INTEGER,
	VWAP NUMERIC[16,4],
	OPEN_INTEREST NUMERIC[16,4],
	CONSTRAINT FK_CANDLE_FRA FOREIGN KEY (TICKER_ID) references TICKER_FRA(TICKER_ID)
	);


CREATE TABLE IF NOT EXISTS TICKER_OPTION
(
	INTERNAL_CODE VARCHAR(255),
	INSTRUMENT_ID INTEGER,
	NAME VARCHAR(255),
	QUOTE_PERCENT BOOLEAN,
	OPTION_TYPE VARCHAR(1),
	EXERCICE_TYPE VARCHAR(30),
	DELIVERY DATE,
	STRIKE NUMERIC[16,4],
	CONTRACT_UNIT INTEGER,
	FIRST_TRADE_DATE DATE,
 	EXPIRATION_DATE DATE,
	PROVIDER_ID INTEGER,
	UNDERLYING_INSTRUMENT_ID INTEGER,
	UNDERLYING_INSTRUMENT_NAME VARCHAR(30),
	UNDERLYING_INSTRUMENT_TYPE VARCHAR(30),
	UNDERLYING_INSTRUMENT_CODE VARCHAR(30),
	UNDERLYING_TICKER_ID VARCHAR(30),
	UNDERLYING_TICKER VARCHAR(30),
	UNDERLYING_MIC_ID INTEGER,
	UNDERLYING_MIC_CODE VARCHAR(30),
	PROVIDER_NAME VARCHAR(30),
	TICKER_ID INTEGER NOT NULL,
 	TICKER VARCHAR(255),
 	PROVIDER_MARKET_NAME VARCHAR(30),
 	MIC_ID INTEGER,
 	MIC_CODE VARCHAR(30),
 	ACRONYM VARCHAR(30),
 	DESCRIPTION VARCHAR(255),
 	CITY VARCHAR(30),
 	PAYMENT_CURRENCY VARCHAR(30),
 	UPDATE_FREQUENCY VARCHAR(1),
 	QUOTATION_FACTOR NUMERIC[16,4],
 	FIRST_QUOTE DATE,
 	LAST_QUOTE DATE,
 	START_DATE DATE,
 	DAILY_UPDATE INTEGER,
 	LAST_UPDATE VARCHAR(30),
 	CONSTRAINT TICKER__PK PRIMARY KEY(TICKER_ID)
 );	
 
 CREATE TABLE IF NOT EXISTS  CANDLE_OPTION
(	TICKER_ID INTEGER NOT NULL,
	NAME VARCHAR(255),
	TIMESTAMP DATE,
	OPEN NUMERIC[16,4],
	HIGH NUMERIC[16,4],
	LOW NUMERIC[16,4],
	CLOSE NUMERIC[16,4],
	VOLUME INTEGER,
	VWAP NUMERIC[16,4],
	OPEN_INTEREST NUMERIC[16,4],
	MIC_ID NUMERIC INTEGER,
	CONSTRAINT FK_CANDLE_OPTION FOREIGN KEY (TICKER_ID) references TICKER_OPTION(TICKER_ID)
	);
	