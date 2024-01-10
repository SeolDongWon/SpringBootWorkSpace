/*******************
system �������� ����
*******************/
--c## ���ξ���� ������ �����ϱ� ���� ���� ����
alter session set "_ORACLE_SCRIPT"=true;

--���� ����
create user musthave identified by 1234;

--���� �ο�
grant connect, resource to musthave;

--�� �������� ����Ŭ ����
conn musthave/1234;

/*******************
musthave �������� ����
********************/
--���̺� ��� ��ȸ
select * from tab;

/*
���� : ���� ������ ���̺��� �����ϰ� ���� �����Ϸ��� ��� �������ּ���.
*/
drop table member;
drop table board;
drop sequence seq_board_num;

--[���� 5-1] ȸ�� ���̺� ����
create table member (
    id varchar2(10) not null,
    pass varchar2(10) not null,
    name varchar2(30) not null,
    regidate date default sysdate not null,
    primary key (id)
);

--[���� 5-2] ��1 ����� �Խ��� ���̺� ����
create table board (
    num number primary key,
    title varchar2(200) not null,
    content varchar2(2000) not null,
    id varchar2(10) not null,
    postdate date default sysdate not null,
    visitcount number(6)
);

--[���� 5-3] �ܷ�Ű ����
alter table board
    add constraint board_mem_fk foreign key (id)
    references member (id);
    
--[���� 5-4] ������ ����
create sequence seq_board_num 
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;
    
/*******************
system �������� ����
: ���ڵ带 �����ϱ� �� ���̺� �����̽� ������ ���� �����մϴ�. 
********************/    
--���̺� �����̽��� ��ȸ    
select tablespace_name, status, contents from dba_tablespaces;

--���̺� �����̽��� ���� ������ Ȯ�� 
select tablespace_name, sum(bytes), max(bytes) from dba_free_space
group by tablespace_name;


--musthave ������ ����ϴ� ���̺� �����̽��� Ȯ��
select username, default_tablespace from dba_users
where username in upper('musthave');

--musthave ������ USERS ���̺� �����̽��� �����͸� �Է��� �� �ֵ��� 5m�� �뷮 �Ҵ�
alter user musthave quota 5m on users;
    
/*******************
musthave �������� ����
********************/    
--[���� 5-5] ���� ������ �Է�
insert into member (id, pass, name) values ('musthave', '1234', '�ӽ�Ʈ�غ�');
insert into board  (num, title, content, id, postdate, visitcount) 
	values (seq_board_num.nextval, '����1�Դϴ�', '����1�Դϴ�', 'musthave', sysdate, 0);
commit;
--�˻��� ���� ���̵����� �߰� �Է�
insert into board
	values (seq_board_num.nextval, '������ ���Դϴ�', '���ǿ���', 'musthave', sysdate, 0);
insert into board
	values (seq_board_num.nextval, '������ �����Դϴ�', '�������', 'musthave', sysdate, 0);
insert into board
	values (seq_board_num.nextval, '������ �����Դϴ�', '������ȭ', 'musthave', sysdate, 0);
insert into board
	values (seq_board_num.nextval, '������ �ܿ��Դϴ�', '�ܿ￬��', 'musthave', sysdate, 0);		

commit;
select * from board order by num desc;
select rownum, b.* from( select * from board order by num desc) b;
select * from(
    select rownum rn,tb.* from(
        select * from board order by num desc
    ) tb
)
where rn between 21 and 30;
select * from member;
--���� ���ε�� �ٿ�ε带 ���� ���̺� ����
drop table myfile;
create table myfile (
    idx number primary key,
    title varchar2(200) not null,
    cate varchar2(100),
    ofile varchar2(100) not null,
    sfile varchar2(30) not null,
    postdate date default sysdate not null
);
