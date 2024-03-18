CREATE TABLE automovel
(
    id     BIGINT      NOT NULL AUTO_INCREMENT,
    placa  VARCHAR(10) NOT NULL,
    marca  VARCHAR(15) NOT NULL,
    modelo VARCHAR(15) NOT NULL,
    cor    VARCHAR(15) NOT NULL,
    ano    VARCHAR(4)  NOT NULL,

    PRIMARY KEY (id)
);