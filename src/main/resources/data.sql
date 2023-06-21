insert into address (id, country, city, street, number, postal_code) values (101, "Serbia", "Novi Sad", "Momcila Tapavice 22", "22", 21000)

COMMIT

insert into user (id, username, description, password, address_id) values (101, "Pera", "bez opisa", 1234, 101)
insert into user (id, username, description, password) values (102, "Vlada", null, 1234)

insert into movie (id, rate, description, title) values (101, 4, "By George Lucas", "Star wars")
-- insert into address (id, country, city, street, number, postalCode) values (101, "Srbija", "Novi Sad", "tapabicvas", 066245116, 21000)