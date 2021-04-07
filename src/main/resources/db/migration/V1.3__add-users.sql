INSERT INTO users (id, name, surname, email, password, reg_date, is_user, is_operator, is_admin)
VALUES (1, 'Test1', 'User', 'test1-user@test.test',
        '$2y$10$qW5DUpGo8RJU.stivaQ87uX3RC3JUtqVVG7tjdmaRb85Ky9beziBu', '2021-04-07 10:10:10', 1, 0, 0);

INSERT INTO users (id, name, surname, email, password, reg_date, is_user, is_operator, is_admin)
VALUES (2, 'Test2', 'Operator', 'test2-operator@test.test',
        '$2y$10$qW5DUpGo8RJU.stivaQ87uX3RC3JUtqVVG7tjdmaRb85Ky9beziBu', '2021-04-07 11:11:11', 0, 1, 0);

INSERT INTO users (id, name, surname, email, password, reg_date, is_user, is_operator, is_admin)
VALUES (3, 'Test3', 'Admin', 'test3-admin@test.test',
        '$2y$10$qW5DUpGo8RJU.stivaQ87uX3RC3JUtqVVG7tjdmaRb85Ky9beziBu', '2021-04-07 12:12:12', 0, 0, 1);

INSERT INTO users (id, name, surname, email, password, reg_date, is_user, is_operator, is_admin)
VALUES (4, 'Test4', 'UserOperator', 'test4-user-operator@test.test',
        '$2y$10$qW5DUpGo8RJU.stivaQ87uX3RC3JUtqVVG7tjdmaRb85Ky9beziBu', '2021-04-07 13:13:13', 1, 1, 0);

INSERT INTO users (id, name, surname, email, password, reg_date, is_user, is_operator, is_admin)
VALUES (5, 'Test5', 'OperatorAdmin', 'test5-operator-admin@test.test',
        '$2y$10$qW5DUpGo8RJU.stivaQ87uX3RC3JUtqVVG7tjdmaRb85Ky9beziBu', '2021-04-07 14:14:14', 0, 1, 1);

INSERT INTO users (id, name, surname, email, password, reg_date, is_user, is_operator, is_admin)
VALUES (6, 'Test6', 'UserAdmin', 'test6-user-admin@test.test',
        '$2y$10$qW5DUpGo8RJU.stivaQ87uX3RC3JUtqVVG7tjdmaRb85Ky9beziBu', '2021-04-07 15:15:15', 1, 0, 1);

INSERT INTO users (id, name, surname, email, password, reg_date, is_user, is_operator, is_admin)
VALUES (7, 'Test7', 'UserOperatorAdmin', 'test7-user-operator-admin@test.test',
        '$2y$10$qW5DUpGo8RJU.stivaQ87uX3RC3JUtqVVG7tjdmaRb85Ky9beziBu', '2021-04-07 16:16:16', 1, 1, 1);

ALTER SEQUENCE users_id_seq RESTART WITH 8;

-- password = '123456789' in bcrypt