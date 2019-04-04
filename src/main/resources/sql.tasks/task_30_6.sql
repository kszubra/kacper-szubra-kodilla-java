explain select count(*) from readers where firstname = "John";
create index firstname_index on readers(firstname);
create index lastname_index on readers(lastname);
create index title_index on books(title);
explain select count(*) from readers where firstname = "John";
