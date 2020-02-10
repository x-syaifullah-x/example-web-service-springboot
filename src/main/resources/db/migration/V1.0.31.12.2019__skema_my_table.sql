create table data (
    ID    INT PRIMARY KEY AUTO_INCREMENT,
    NAME  VARCHAR(255) NOT NULL UNIQUE,
    IMAGE LONGBLOB     NOT NULL
);

-- create user database
-- grant all on data.* to user@localhost identified by '19021992'