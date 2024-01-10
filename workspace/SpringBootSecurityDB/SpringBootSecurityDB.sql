CREATE TABLE securitymember
(user_no NUMBER,
user_id VARCHAR2(50) NOT NULL,
user_pw VARCHAR2(100) NOT NULL,
user_name VARCHAR2(100) NOT NULL,
coin NUMBER(10)DEFAULT 0,
reg_date DATE DEFAULT SYSDATE,
upd_date DATE DEFAULT SYSDATE,
enabled CHAR(1) DEFAULT '1',
PRIMARY KEY (user_no)
);
CREATE TABLE securitymember_auth
(user_no NUMBER NOT NULL,
auth VARCHAR2(50) NOT NULL
);
ALTER TABLE securitymember_auth ADD CONSTRAINT fk_securitymember_auth_user_no
FOREIGN KEY (user_no) REFERENCES securitymember(user_no);

create sequence securitymember_seq
start with 1
increment by 1;
INSERT INTO securitymember(user_no, user_id, user_pw, user_name) VALUES
(securitymember_seq.NEXTVAl,
'member0','$2a$10$ohA1zfwg.el0qEbcUisAtOwfEM/Q0XikaQqzLF4RLvvlQBHjNhkUG','ȸ�� 0');
INSERT INTO securitymember(user_no, user_id, user_pw, user_name) VALUES
(securitymember_seq.NEXTVAl,
'member1','$2a$10$0YeNJZi0ZpHNJ962vF4KbOPbiiAW/FWaIOu8PTypWyzKnqmHDXEbe','ȸ�� 1');
INSERT INTO securitymember(user_no, user_id, user_pw, user_name) VALUES
(securitymember_seq.NEXTVAl,
'member2','$2a$10$q8SAiCddta4vsxze3klZKOWWLoo1qwgwTQ7MdBcN3ZV8oL435vszm','ȸ�� 2');
INSERT INTO securitymember(user_no, user_id, user_pw, user_name) VALUES
(securitymember_seq.NEXTVAl,
'admin3','$2a$10$tu7hm6.6uYkcvMi//ol9A.gLeyGFwezZmtlSnvgUeBhgZ1UaSN1CG','������ 3');
INSERT INTO securitymember(user_no, user_id, user_pw, user_name) VALUES
(securitymember_seq.NEXTVAl,
'admin4','$2a$10$SAipGDDRGkCStRyrao.pPeseuMoeBFiifUH0RAFDyyb.p/WG59zuS','������ 4');
INSERT INTO securitymember_auth (user_no, auth) VALUES ((SELECT user_no FROM securitymember
WHERE user_id = 'member0'),'ROLE_MEMBER');
INSERT INTO securitymember_auth (user_no, auth) VALUES ((SELECT user_no FROM securitymember
WHERE user_id = 'member1'),'ROLE_MEMBER');
INSERT INTO securitymember_auth (user_no, auth) VALUES ((SELECT user_no FROM securitymember
WHERE user_id = 'member2'),'ROLE_MEMBER');
INSERT INTO securitymember_auth (user_no, auth) VALUES ((SELECT user_no FROM securitymember
WHERE user_id = 'admin3'),'ROLE_ADMIN');
INSERT INTO securitymember_auth (user_no, auth) VALUES ((SELECT user_no FROM securitymember
WHERE user_id = 'admin4'),'ROLE_ADMIN');
commit;

CREATE TABLE persistent_logins (
username VARCHAR2(64) NOT NULL,
series VARCHAR2(64) NOT NULL,
token VARCHAR2(64) NOT NULL,
last_used DATE NOT NULL,
PRIMARY KEY (series)
);

select * from persistent_logins;

