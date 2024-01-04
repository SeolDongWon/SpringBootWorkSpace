select count(*) from myboard;

select concat('asdf',1) from dual;
select count(*) from myboard;
select board_seq.nextval as cnt from dual;
select count(*) as cnt from myboard;
select nvl(max(seq),0)+1 from myboard;

select * from myboard order by seq desc;
select * from board;
select * from myboard;
select * from JPABOARD;

CREATE TABLE jdbcBoard(
board_no NUMBER,
title VARCHAR2(100) NOT NULL,
content VARCHAR2(1000) NULL,
writer VARCHAR2(50) NOT NULL,
reg_date DATE DEFAULT SYSDATE,
PRIMARY KEY (board_no)
);

create sequence jdbcBoard_seq start with 1
increment by 1;

CREATE TABLE
mybatisboard(board_no
NUMBER,
title VARCHAR2(100) NOT NULL,
content VARCHAR2(500) NULL,
writer VARCHAR2(50) NOT NULL,
reg_date DATE DEFAULT SYSDATE,
PRIMARY KEY (board_no)
);
create sequence mybatisboard_seq
start with 1
increment by 1;

select * from mybatisboard;

CREATE TABLE item(
item_id NUMBER(5),
item_name VARCHAR2(20),
price NUMBER(6),
description VARCHAR2(50),
picture_url VARCHAR2(200),
PRIMARY KEY (item_id)
);

select * from item;

create sequence item_seq 
start with 1 
increment by 1;

CREATE TABLE item2(
item_id NUMBER(5),
item_name VARCHAR2(20),
price NUMBER(6),
description VARCHAR2(50),
picture_url VARCHAR2(200),
picture_url2 VARCHAR2(200),
PRIMARY KEY (item_id)
);

create sequence item2_seq
start with 1
increment by 1;

CREATE TABLE item3(
item_id NUMBER(5),
item_name VARCHAR2(50),
price NUMBER(10),
description VARCHAR2(100),
PRIMARY KEY (item_id)
);

CREATE TABLE 
item_attach( fullName 
VARCHAR2(100), item_id
NUMBER(5) NOT NULL,
regdate DATE DEFAULT SYSDATE,
PRIMARY KEY (fullName)
);

ALTER TABLE item_attach 
ADD CONSTRAINT fk_item_attch
FOREIGN KEY(item_id) 
REFERENCES item3(item_id);

create sequence item3_seq
start with 1
increment by 1;

