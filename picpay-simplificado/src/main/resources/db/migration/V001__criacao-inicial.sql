CREATE TABLE usuario
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    nome        VARCHAR(50),
    cpf         VARCHAR(50) UNIQUE,
    email       VARCHAR(50) UNIQUE,
    senha       VARCHAR(50),
    saldo       NUMERIC(10, 2),
    tipo_usuario INTEGER,

    PRIMARY KEY (id)

);

CREATE TABLE transaction
(
    id    BIGINT         NOT NULL AUTO_INCREMENT,
    valor NUMERIC(10,2) NOT NULL,
    payer_id BIGINT         NOT NULL,
    payee_id BIGINT         NOT NULL,

    primary key (id),

    CONSTRAINT fk_payer_transaction_usuario
        FOREIGN KEY (payer_id)
            REFERENCES usuario (id),
    CONSTRAINT fk_payee_transaction_usuario
        FOREIGN KEY (payee_id)
            REFERENCES usuario (id)
);