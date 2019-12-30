create table table_1
(
    ID    INT PRIMARY KEY AUTO_INCREMENT,
    NAME  VARCHAR(255) NOT NULL UNIQUE,
    IMAGE BLOB         NOT NULL

);

# create table kelurahan_2
# (
#     id      INT PRIMARY KEY AUTO_INCREMENT,
#     kode    VARCHAR(10)  NOT NULL UNIQUE,
#     nama    VARCHAR(255) NOT NULL,
#     kodepos VARCHAR(10)  NOT NULL
# );