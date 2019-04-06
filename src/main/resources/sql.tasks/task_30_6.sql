explain select count(*) from readers where firstname = "John";
create index firstname_and_lastname_index on readers(firstname, lastname);
create index title_index on books(title);
explain select count(*) from readers where firstname = "John";
