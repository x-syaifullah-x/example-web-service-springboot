create table data
(
    ID    INT PRIMARY KEY AUTO_INCREMENT,
    NAME  VARCHAR(255) NOT NULL UNIQUE,
    IMAGE LONGBLOB     NOT NULL

);