CREATE TABLE cliente
(
    id       BIGINT NOT NULL AUTO_INCREMENT,
    nome     VARCHAR(30),
    email    VARCHAR(30),
    telefone VARCHAR(30),
    endereco VARCHAR(30),

    PRIMARY KEY (id)
);
CREATE TABLE produto
(
    id    BIGINT NOT NULL AUTO_INCREMENT,
    nome  VARCHAR(30),
    preco NUMERIC(7,2),

    PRIMARY KEY (id)
)