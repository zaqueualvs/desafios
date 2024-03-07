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
    preco NUMERIC(7, 2),

    PRIMARY KEY (id)
);

CREATE TABLE pedido
(
    id           BIGINT NOT NULL AUTO_INCREMENT,
    data_criacao TIMESTAMP WITH TIME ZONE,
    produto_id   BIGINT,
    cliente_id   BIGINT,
    status       INTEGER,

    PRIMARY KEY (id),

    CONSTRAINT fk_pedido_produto
        FOREIGN KEY (produto_id)
            REFERENCES produto (id),
    CONSTRAINT fk_pedido_cliente
        FOREIGN KEY (cliente_id)
            REFERENCES cliente (id)
);
