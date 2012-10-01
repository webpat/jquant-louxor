LOAD DATA LOCAL INFILE 'd:/loux/composition/composition_part8.txt' 
into table INDEX_COMPOSITION fields terminated by ',' lines terminated by '\n' ignore 1 lines
(@dummy,@dummy,@dummy,INDEX_TICKER_ID,@dummy,@dummy,@dummy,INDEX_COMPOSITION_ID,@START_DATE,@END_DATE,@dummy,@dummy,INSTRUMENT_ID,
@dummy,WEIGHT,@dummy,@dummy,@dummy,@dummy,@dummy,@dummy,@dummy,@dummy,@dummy,@dummy)
set 
start_date=if (@start_date='',null,str_to_date(@start_date, '%d/%m/%Y')),
end_date=if (@end_date='',null,str_to_date(@end_date, '%d/%m/%Y'));

LOAD DATA LOCAL INFILE 'd:/loux/composition/composition_part7.txt' 
into table INDEX_COMPOSITION fields terminated by ',' lines terminated by '\n' ignore 1 lines
(@dummy,@dummy,@dummy,INDEX_TICKER_ID,@dummy,@dummy,@dummy,INDEX_COMPOSITION_ID,@START_DATE,@END_DATE,@dummy,@dummy,INSTRUMENT_ID,
@dummy,WEIGHT,@dummy,@dummy,@dummy,@dummy,@dummy,@dummy,@dummy,@dummy,@dummy,@dummy)
set 
start_date=if (@start_date='',null,str_to_date(@start_date, '%d/%m/%Y')),
end_date=if (@end_date='',null,str_to_date(@end_date, '%d/%m/%Y'));