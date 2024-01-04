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

