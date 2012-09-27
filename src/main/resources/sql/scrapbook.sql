select count(*) from candle_stock cs 
inner join ticker_stock ts on ts.ticker_id = cs.ticker_id
where ts.provider_id = 2;

select count(*) from candle_stock;

select * from ticker_stock where internal_code = 'FR0000130007';
select * from ticker_stock where internal_code = 'US5949181045' and provider_id='2';

select * from ticker_future ;



select * from candle_stock where ticker like 'ALU FP Equity%' order by timestamp asc;

select * from candle_stock where internal_code like 'US4230741039' order by timestamp desc;


--Recherche des stocks dont les historiques ne dépassent pas 250 

select t.* from (
	select internal_code,name,mic_code,count(*) as ticks from candle_stock group by internal_code,name,mic_code 
) t where ticks<250 order by ticks asc;

-- Recherche des dates de début et de fin d'historique pour le stock US4230741039 (Heinz)
select min(timestamp) as debut, max(timestamp) as fin from candle_stock where internal_code='US4230741039'

-- Recherche des dates de début et de fin d'historique pour le stock US4592001014 (IBM)
select min(timestamp) as debut, max(timestamp) as fin from candle_stock where internal_code='US4592001014'

select * from ticker_stock where ticker_id='1394' 
