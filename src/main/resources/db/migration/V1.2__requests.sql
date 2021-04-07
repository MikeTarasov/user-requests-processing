CREATE TABLE requests
(
    id          bigserial PRIMARY KEY        NOT NULL,
    status      varchar(255)                 NOT NULL,
    text        varchar(255)                 NOT NULL,
    date        timestamp                    NOT NULL,
    user_id     bigint REFERENCES users (id) NOT NULL,
    operator_id bigint REFERENCES users (id)
);