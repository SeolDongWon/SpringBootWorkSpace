-- SYSTEM 계정으로 실행
-- C:\oradata\imageshop 폴더에 imageshop_db.dbf 테이블스페이스 생성
CREATE TABLESPACE imageshop
DATAFILE 'C:\oradata\imageshop\imageshop_db.dbf' SIZE 10M
AUTOEXTEND ON NEXT 5M MAXSIZE 20M;

--C##을 붙이지 않고 계정생성을 가능하게 설정 변경
alter session set "_ORACLE_SCRIPT"=true;

-- 아이디 : shopadmin 비밀번호 : shop1234
CREATE USER shopadmin IDENTIFIED BY shop1234 
DEFAULT TABLESPACE imageshop TEMPORARY TABLESPACE temp;

-- 생성한 계정에 권한 부여
GRANT CONNECT, RESOURCE, DBA TO shopadmin;
GRANT CREATE VIEW, CREATE SYNONYM TO shopadmin;
GRANT UNLIMITED TABLESPACE TO shopadmin;
ALTER USER shopadmin ACCOUNT UNLOCK;
