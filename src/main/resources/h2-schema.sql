create table USER_MGMT_TB
(
    USER_ID varchar(255) not null,
    PASSWORD varchar(255) not null,
    NICKNAME varchar(255),
    EMAIL varchar(255) not null,
    BIRTHDAY varchar(255),
    GENDER varchar(255) check(GENDER IN ('W', 'M')),
    KOR_NAME varchar(255),
    UPDATED_AT timestamp default now(),
    CREATED_AT timestamp not null default now(),
    primary key (USER_ID)
);
comment on table USER_MGMT_TB is '사용자 계정관리 테이블';
comment on column USER_MGMT_TB.USER_ID is '사용자 ID';
comment on column USER_MGMT_TB.PASSWORD is '비밀번호';
comment on column USER_MGMT_TB.NICKNAME is '별명';
comment on column USER_MGMT_TB.EMAIL is '이메일';
comment on column USER_MGMT_TB.BIRTHDAY is '생일';
comment on column USER_MGMT_TB.GENDER is '성별';
comment on column USER_MGMT_TB.KOR_NAME is '국문이름';
comment on column USER_MGMT_TB.UPDATED_AT is '업데이트 일자';
comment on column USER_MGMT_TB.CREATED_AT is '생성 일자';