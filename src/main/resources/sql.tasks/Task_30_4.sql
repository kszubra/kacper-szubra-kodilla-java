create table books_aud (
event_id int(11) not null auto_increment,
event_date datetime not null,
event_type varchar(10) default null,
book_id int(11) not null,

old_title varchar(255),
new_title varchar(255),
old_pubyear int(4),
new_pubyear int(4),
old_bestseller boolean,
new_bestseller boolean,
primary key (event_id)
);

create table readers_aud (
event_id int(11) not null auto_increment,
event_date datetime not null,
event_type varchar(10) default null,
reader_id int(11) not null,

old_firstname varchar(255),
new_firstname varchar(255),
old_lastname varchar(255),
new_lastname varchar(255),
old_peselid varchar(11),
new_peselid varchar(11),
old_vip_level varchar(20),
new_vip_level varchar(20),

primary key (event_id)
);

DELIMITER $$

create trigger books_insert after insert on books
for each row
begin
insert into books_aud (event_date, event_type, book_id, new_title, new_pubyear, new_bestseller)
values(curtime(), "insert", new.book_id, new.title, new.pubyear, new.bestseller);
end$$

DELIMITER ;

DELIMITER $$

create trigger readers_insert after insert on readers
for each row
begin
insert into readers_aud (event_date, event_type, reader_id, new_firstname, new_lastname, new_peselid, new_vip_level)
values(curtime(), "insert", new.reader_id, new.firstname, new.lastname, new.peselid, new.vip_level);
end$$

DELIMITER ;

DELIMITER $$

create trigger books_delete after delete on books
for each row
begin
insert into books_aud (event_date, event_type, book_id)
values(curtime(), "delete", old.book_id);
end$$

DELIMITER ;

DELIMITER $$

create trigger readers_delete after delete on readers
for each row
begin
insert into readers_aud (event_date, event_type, reader_id)
values(curtime(), "delete", old.reader_id);
end$$

DELIMITER ;

DELIMITER $$

create trigger books_update after update on books
for each row
begin
insert into books_aud (event_date, event_type, book_id, new_title, new_pubyear, new_bestseller,
														old_title, old_pubyear, old_bestseller)

values(curtime(), "update", old.book_id, new.title, new.pubyear, new.bestseller,
										 old.title, old.pubyear, old.bestseller);
end$$

DELIMITER ;

DELIMITER $$

create trigger readers_update after update on readers
for each row
begin
insert into readers_aud (event_date, event_type, reader_id, new_firstname, new_lastname, new_peselid, new_vip_level,
															old_firstname, old_lastname, old_peselid, old_vip_level)

values(curtime(), "update", old.reader_id, new.firstname, new.lastname, new.peselid, new.vip_level,
										   old.firstname, old.lastname, old.peselid, old.vip_level);
end$$

DELIMITER ;