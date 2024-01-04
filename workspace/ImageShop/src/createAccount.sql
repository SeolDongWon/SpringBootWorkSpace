-- SYSTEM �������� ����
-- C:\oradata\imageshop ������ imageshop_db.dbf ���̺����̽� ����
CREATE TABLESPACE imageshop
DATAFILE 'C:\oradata\imageshop\imageshop_db.dbf' SIZE 10M
AUTOEXTEND ON NEXT 5M MAXSIZE 20M;

--C##�� ������ �ʰ� ���������� �����ϰ� ���� ����
alter session set "_ORACLE_SCRIPT"=true;

-- ���̵� : shopadmin ��й�ȣ : shop1234
CREATE USER shopadmin IDENTIFIED BY shop1234 
DEFAULT TABLESPACE imageshop TEMPORARY TABLESPACE temp;

-- ������ ������ ���� �ο�
GRANT CONNECT, RESOURCE, DBA TO shopadmin;
GRANT CREATE VIEW, CREATE SYNONYM TO shopadmin;
GRANT UNLIMITED TABLESPACE TO shopadmin;
ALTER USER shopadmin ACCOUNT UNLOCK;
