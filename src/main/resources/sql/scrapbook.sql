select count(*) from candle_stock cs 
inner join ticker_stock ts on ts.ticker_id = cs.ticker_id
where ts.provider_id = 2;

select count(*) from candle_stock;

select * from ticker_stock where internal_code = 'FR0000130007';

select * from candle_stock where ticker_id = 24093;

select * from candle_stock where ticker like 'ALU FP Equity%' order by timestamp asc;

select * from candle_stock where internal_code like 'US5949181045' order by timestamp asc;


