create table tbl_student (
    student_id number constraint pk_student primary key,
    student_name varchar2(1000),
    student_age number,
    student_gender varchar2(100),
    student_address varchar2(1000)
);

create sequence seq_student
increment by 1
nocache;