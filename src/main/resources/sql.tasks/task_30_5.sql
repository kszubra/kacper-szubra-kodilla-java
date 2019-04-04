create table stats(
STAT_ID INT(11) AUTO_INCREMENT PRIMARY KEY,
STAT_DATE DATETIME NOT NULL,
STAT VARCHAR(20) NOT NULL,
VALUE INT(11) NOT NULL
);

create view bestsellers_number as
select count(*) as bestseller_count from books where bestseller=true;

DELIMITER $$
create event if not exists update_bestsellers
on schedule every 1 day
do begin 
call UpdateBestsellers();
insert into stats(stat_date, stat, value)
values(curdate(), "Bestsellers", (select bestseller_count from bestsellers_number)); 

end$$

DELIMITER ;

