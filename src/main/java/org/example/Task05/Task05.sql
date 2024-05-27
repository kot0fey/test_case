CREATE TABLE Users
(
    ID            INT PRIMARY KEY,
    SURNAME       VARCHAR(255) NOT NULL,
    DEPARTMENT_ID INT,
    SALARY        INT,
    FOREIGN KEY (DEPARTMENT_ID) REFERENCES Department (ID)
);

CREATE TABLE Department
(
    ID   INT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL
);

INSERT INTO Department (ID, NAME)
VALUES (1, 'Backend'),
       (2, 'DevOps'),
       (3, 'Android'),
       (4, 'iOS');

INSERT INTO Users (ID, SURNAME, DEPARTMENT_ID, SALARY)
VALUES (1, 'Алексеев', 3, 50000),
       (2, 'Петрухин', 3, 60000),
       (3, 'Есенин', 2, 70000),
       (4, 'Маяковский', 1, 80000),
       (5, 'Нортон', 4, 90000),
       (6, 'Антропов', 1, 100000),
       (7, 'Андреев', 4, 110000),
       (8, 'Силантьев', 1, 120000)
