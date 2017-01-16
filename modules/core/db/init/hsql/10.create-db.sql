-- begin DEMO_SPARE_PART
create table DEMO_SPARE_PART (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE integer not null,
    TITLE varchar(255) not null,
    --
    primary key (ID)
)^
-- end DEMO_SPARE_PART
