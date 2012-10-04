select count(*) from candle_stock cs 
inner join ticker_stock ts on ts.ticker_id = cs.ticker_id
where ts.provider_id = 2;

select count(*) from candle_stock where ticker_id = 98368;

select * from ticker_stock where internal_code = 'US4230741039';
select * from ticker_stock where internal_code = 'US4592001014';
select count(*) from ticker_stock where mic_code ='HDG_US';
select count(*) from ticker_stock;

select * from candle_stock where ticker like 'ALU FP Equity%' order by timestamp asc;

select * from candle_stock where internal_code like 'US4230741039' order by timestamp desc;


--Recherche des stocks dont les historiques ne dépassent pas 250 

select t.* from (
	select internal_code,name,mic_code,count(*) as ticks from candle_stock group by internal_code,name,mic_code 
) t where ticks<250 order by ticks asc;

select t.* from (
	select internal_code,name,mic_code,count(*) as ticks from candle_stock group by internal_code,name,mic_code 
) t where ticks>2500 order by ticks asc;

-- Recherche des dates de début et de fin d'historique pour le stock US4230741039 (Heinz)
select min(timestamp) as debut, max(timestamp) as fin from candle_stock where internal_code='US4230741039'

-- Recherche des dates de début et de fin d'historique pour le stock US4592001014 (IBM)
select min(timestamp) as debut, max(timestamp) as fin from candle_stock where internal_code='US4592001014'

select * from ticker_stock where ticker_id='1394' 

--- Futures on Debt

select short_name,name,first_delivery_date,first_quote,last_quote,first_trade_date from ticker_future 
where name like '%US 30Y%'
order by first_delivery_date asc

select short_name,name,first_delivery_date,first_quote,last_quote,first_trade_date from ticker_future 
where name like '%US% 5Y%'
order by first_delivery_date asc

select short_name,name,first_delivery_date,first_quote,last_quote,first_trade_date from ticker_future 
where name like '%BUND%'
order by first_delivery_date asc

select short_name,name,first_delivery_date,first_quote,last_quote,first_trade_date from ticker_future 
where name like '%BOBL%'
order by first_delivery_date asc

select short_name,name,first_delivery_date,first_quote,last_quote,first_trade_date from ticker_future 
where name like '%SCHATZ%'
order by first_delivery_date asc



-- Futures on commodities 

select short_name,name,payment_currency,first_delivery_date,first_quote,last_quote,first_trade_date from ticker_future 
where name like '%CRUDE OIL (XNYM)%' and mic_code = 'XNYM' and first_quote >= str_to_date('1983-06-01', '%Y-%m-%d') and last_quote<=str_to_date('2010-01-01', '%Y-%m-%d')
order by first_delivery_date asc

select short_name,name,payment_currency,first_delivery_date,first_quote,last_quote,first_trade_date from ticker_future 
where name like '%NATURAL GAS%' and mic_code = 'XNYM' and first_quote >= str_to_date('1983-06-01', '%Y-%m-%d') and last_quote<=str_to_date('2010-01-01', '%Y-%m-%d')
order by first_delivery_date asc

select short_name,name,payment_currency,first_delivery_date,first_quote,last_quote,first_trade_date from ticker_future 
where name like '%COFFEE%' and first_quote >= str_to_date('1983-06-01', '%Y-%m-%d') and last_quote<=str_to_date('2010-01-01', '%Y-%m-%d')
order by first_delivery_date asc

select short_name,name,payment_currency,first_delivery_date,first_quote,last_quote,first_trade_date from ticker_future 
where name like '%SOY%' and first_quote >= str_to_date('1983-06-01', '%Y-%m-%d') and last_quote<=str_to_date('2010-01-01', '%Y-%m-%d')
order by first_delivery_date asc

select short_name,name,payment_currency,first_delivery_date,first_quote,last_quote,first_trade_date from ticker_future 
where name like '%LUMBER%' and first_quote >= str_to_date('1983-06-01', '%Y-%m-%d') and last_quote<=str_to_date('2010-01-01', '%Y-%m-%d')
order by first_delivery_date asc

select short_name,name,payment_currency,first_delivery_date,first_quote,last_quote,first_trade_date from ticker_future 
where name like '%GOLD%' and first_quote >= str_to_date('1983-06-01', '%Y-%m-%d') and last_quote<=str_to_date('2010-01-01', '%Y-%m-%d')
order by first_delivery_date asc

select short_name,name,payment_currency,first_delivery_date,first_quote,last_quote,first_trade_date from ticker_future 
where name like '%NICKEL%' and first_quote >= str_to_date('1983-06-01', '%Y-%m-%d') and last_quote<=str_to_date('2010-01-01', '%Y-%m-%d')
order by first_delivery_date asc

select short_name,name,payment_currency,first_delivery_date,first_quote,last_quote,first_trade_date from ticker_future 
where name like '%OIL%' and first_quote >= str_to_date('1983-06-01', '%Y-%m-%d') and last_quote<=str_to_date('2010-01-01', '%Y-%m-%d')
order by first_delivery_date asc

select short_name,name,payment_currency,first_delivery_date,first_quote,last_quote,first_trade_date from ticker_future 
where name like '%COPPER%' and first_quote >= str_to_date('1983-06-01', '%Y-%m-%d') and last_quote<=str_to_date('2010-01-01', '%Y-%m-%d')
order by first_delivery_date asc



-- Trackers 
select ticker_id,internal_code,mic_code,name,inception_date,first_quote,last_quote from ticker_tracker where first_quote < str_to_date('2002-01-01', '%Y-%m-%d') ;

-- Forex Pairs

select ticker_id, name,foreign_currency,payment_currency,first_quote,last_quote,quotation_factor from ticker_forex;

alter table candle_forex add open_interest DECIMAL(10,4);
alter table candle_forex add volume INT;
update candle_forex set volume = 0;
alter table candle_forex add vwap DECIMAL(10,4);
