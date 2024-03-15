CREATE TABLE veiculo
(
    id           BIGINT      NOT NULL AUTO_INCREMENT,
    marca        VARCHAR(20) NOT NULL,
    modelo       VARCHAR(20) NOT NULL,
    cor          VARCHAR(20) NOT NULL,
    placa        VARCHAR(10) NOT NULL,
    tipo_veiculo INTEGER     NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE estabelecimento
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    cnpj             VARCHAR(14)           NOT NULL,
    endereco         VARCHAR(50)           NOT NULL,
    telefone         VARCHAR(12)           NOT NULL,
    total_vagas_motos  INTEGER               NOT NULL,
    total_vagas_carros INTEGER               NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE historico_estacionamento
(
    estabelecimento_id BIGINT,
    veiculo_id         BIGINT,
    data_entrada       TIMESTAMP WITH TIME ZONE,
    data_saida         TIMESTAMP WITH TIME ZONE,

    CONSTRAINT fk_historico_estacionamento_estabelecimento
        FOREIGN KEY (estabelecimento_id)
            REFERENCES estabelecimento (id),
    CONSTRAINT fk_historico_estacionamento_veiculo
        FOREIGN KEY (veiculo_id)
            REFERENCES veiculo (id)

);
CREATE TABLE vaga_estacionamento
(
    estabelecimento_id BIGINT,
    veiculo_id         BIGINT,
    data_entrada       TIMESTAMP WITH TIME ZONE,

    CONSTRAINT fk_vaga_estacionamento_estabelecimento
        FOREIGN KEY (estabelecimento_id)
            REFERENCES estabelecimento (id),
    CONSTRAINT fk_vaga_estacionamento_veiculo
        FOREIGN KEY (veiculo_id)
            REFERENCES veiculo (id)

);