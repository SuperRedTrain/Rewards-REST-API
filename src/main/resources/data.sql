insert into customer(id, customer_name) values (1000, 'Max');
insert into customer(id, customer_name) values (1001, 'Alex');
insert into customer(id, customer_name) values (1002, 'Violet');
insert into customer(id, customer_name) values (1003, 'May');

insert into transactions(id, customer_id, amount, transaction_date) values (1001, 1000, 100, '2019-8-17 10:20:10');
insert into transactions(id, customer_id, amount, transaction_date) values (1002, 1000, 50, '2019-8-01 18:20:10');
insert into transactions(id, customer_id, amount, transaction_date) values (1003, 1000, 110, '2019-10-10 15:03:00');
insert into transactions(id, customer_id, amount, transaction_date) values (1004, 1000, 175, '2019-10-07 9:30:30');

insert into transactions(id, customer_id, amount, transaction_date) values (1005, 1001, 65.75, '2019-10-05 10:20:10');
insert into transactions(id, customer_id, amount, transaction_date) values (1006, 1001, 210, '2019-8-03 10:00:32');
insert into transactions(id, customer_id, amount, transaction_date) values (1009, 1001, 102.85, '2019-9-18 17:10:00');
insert into transactions(id, customer_id, amount, transaction_date) values (1200, 1001, 75.60, '2019-10-01 12:20:10');
insert into transactions(id, customer_id, amount, transaction_date) values (1201, 1001, 80.50, '2019-8-05 15:00:10');
insert into transactions(id, customer_id, amount, transaction_date) values (1202, 1001, 120, '2019-9-10 11:30:10');

insert into transactions(id, customer_id, amount, transaction_date) values (1008, 1002, 200, '2019-10-17 10:20:10');
insert into transactions(id, customer_id, amount, transaction_date) values (1100, 1002, 120, '2019-9-18 10:20:10');
