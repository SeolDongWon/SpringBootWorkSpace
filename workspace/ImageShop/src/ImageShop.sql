CREATE TABLE code_group( 
group_code VARCHAR2(3)
NOT NULL, group_name VARCHAR2(30)
NOT NULL, use_yn VARCHAR2(1)
DEFAULT 'Y', reg_date DATE DEFAULT 
SYSDATE, upd_date DATE DEFAULT 
SYSDATE,
PRIMARY KEY (group_code)
);

select * from code_group;


drop table test;
create table test(
testNo number,
id varchar2(200)
);

select * from test;
insert into test VALUES ( 1,'A01');
insert into test VALUES ( 1,'B01');
update test set testNo = 3 where id='A01';
update test set testNo = testNo+1 where id='A01';
update test set testNo = testNo-1 where id='A01';

CREATE TABLE code_detail(
group_code VARCHAR2(3) NOT null,
code_value VARCHAR2(3) NOT NULL, 
code_name VARCHAR2(30) NOT NULL, 
sort_seq NUMBER NOT NULL,
use_yn VARCHAR2(1) DEFAULT 'Y', 
reg_date DATE DEFAULT SYSDATE, 
upd_date DATE DEFAULT SYSDATE,
PRIMARY KEY (group_code, code_value)
);

select * from code_detail;

CREATE TABLE member( 
user_no NUMBER(5)NOT NULL,
user_id VARCHAR2(50) NOT NULL,
user_pw VARCHAR2(100) NOT NULL,
user_name VARCHAR2(100) NOT NULL,
job VARCHAR2(3) DEFAULT '00',
coin NUMBER(10) DEFAULT 0,
reg_date DATE DEFAULT SYSDATE,
upd_date DATE DEFAULT SYSDATE,
enabled VARCHAR2(1) DEFAULT '1',
PRIMARY KEY (user_no)
);

CREATE SEQUENCE member_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE member_auth (
user_no NUMBER(5) NOT NULL,
auth VARCHAR2(50) NOT NULL
);

ALTER TABLE member_auth ADD CONSTRAINT fk_member_auth_user_no FOREIGN KEY (user_no) REFERENCES member(user_no);

