create table GRADE
(
    ID_GRADE int auto_increment
        primary key,
    GRADE    double not null
);

create table SUBJECT
(
    ID_SUBJECT int auto_increment
        primary key,
    SUBJECT    text not null
);

create table SCHOOL_SUBJECT_GRADE
(
    ID         int auto_increment
        primary key,
    grade_id   int          null,
    subject_id int          null,
    DATE       varchar(255) null,
    constraint grade_id
        foreign key (grade_id) references GRADE (ID_GRADE),
    constraint subject_id
        foreign key (subject_id) references SUBJECT (ID_SUBJECT)
);

