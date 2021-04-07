CREATE TABLE users
(
    id          bigserial PRIMARY KEY NOT NULL,
    name        varchar(255),
    surname     varchar(255),
    email       varchar(255)          NOT NULL,
    password    varchar(50)           NOT NULL,
    reg_date    timestamp             NOT NULL,
    is_user     int4,
    is_operator int4,
    is_admin    int4
);