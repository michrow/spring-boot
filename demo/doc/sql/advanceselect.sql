-- 本SQL脚本为演示MyBatis高级查询准备

CREATE TABLE demo.user (
id int NOT NULL, 
name varchar(20) NOT NULL, 
gender int NOT NULL, 
age int NOT NULL, 
status int NOT NULL, 
remark varchar(256), 
my_addr varchar(16),
PRIMARY KEY (id)
) 
INSERT INTO user (id, name, gender, age, status, remark,my_addr) VALUES (1,'df', 1, 21, 1, '2','dsad');

        
CREATE TABLE tb_order (
id int NOT NULL generated always as identity(start with 1,increment by 1),
user_id int DEFAULT NULL,
order_number varchar(255) DEFAULT NULL,
create timestamp DEFAULT NULL,
updated timestamp DEFAULT NULL,
PRIMARY KEY (id)
)
INSERT INTO tb_order(user_id,order_number,create,updated) VALUES (2, '201807010001', '2018-07-01 19:38:35','2018-07-01 19:38:40');


CREATE TABLE tb_item (
item_id int NOT NULL,
item_name varchar(255) DEFAULT NULL,
item_price decimal(10,2) DEFAULT NULL,
item_detail varchar(255) DEFAULT NULL,
PRIMARY KEY (item_id)
)

INSERT INTO tb_item VALUES (1, 'wazi', '29.90', 'ds');
INSERT INTO tb_item VALUES (2, 'wjej', '99.99', 'ds');


CREATE TABLE tb_orderdetail (
id int NOT NULL generated always as identity(start with 1,increment by 1),
order_id int DEFAULT NULL,
total_price decimal(10,0) DEFAULT NULL,
item_id int DEFAULT NULL,
status int,
PRIMARY KEY (id)
) 
INSERT INTO tb_orderdetail(order_id,total_price,item_id,status) VALUES (1, 10000, 1, 0000000001);
INSERT INTO tb_orderdetail(order_id,total_price,item_id,status)VALUES (1, 2000, 2, 0000000000);