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

select * from member;
select * from member_auth;
select * from code_detail;

SELECT code_name FROM code_detail
		WHERE group_code ='A01' AND code_value = job;
SELECT
		user_no,user_id,user_pw,user_name,
		(SELECT code_name FROM code_detail
		WHERE group_code ='A01' AND code_value = job) AS job,
		coin,reg_date
		FROM member
		ORDER BY reg_date DESC;
        
insert into member_auth (user_no, auth) values(1,'ROLE_USER');
commit;
SELECT
		mem.user_no,mem.user_id,user_pw,user_name,job,coin,reg_date,upd_date,auth
		FROM member mem
		LEFT OUTER JOIN member_auth auth
		ON mem.user_no =
		auth.user_no
		WHERE mem.user_no = 1;

delete from member_auth where user_no=1 and auth='ROLE_USER';
