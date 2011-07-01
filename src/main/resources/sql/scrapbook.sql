select count(*) from candle_stock cs 
inner join ticker_stock ts on ts.ticker_id = cs.ticker_id
where ts.provider_id = 2;

select count(*) from candle_stock;

