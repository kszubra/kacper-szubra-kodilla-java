drop procedure if exists UpdateBestsellers;

DELIMITER $$

create procedure UpdateBestsellers()
begin

declare bookrents, days, bk_id int;
declare rentspermonth decimal(5,2);
declare finished int default 0;
declare allbooks cursor for select book_id from books;
declare continue handler for not found set finished = 1;

open allbooks;
while(finished = 0) do
fetch allbooks into bk_id;
if(finished = 0) then
select count(*) from rents where book_id = bk_id into bookrents;
select datediff(max(rent_date), min(rent_date)) + 1 from rents where book_id = bk_id into days;
set rentspermonth = bookrents / days * 30;
if rentspermonth >= 2 then
update books set bestseller = true where book_id = bk_id; commit;
else
update books set bestseller = false where book_id = bk_id; commit;
end if;
end if;
end while;
close allbooks;
    
end$$

DELIMITER ;

call UpdateBestsellers;
select * from books;