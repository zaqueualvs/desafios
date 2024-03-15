INSERT INTO veiculo(modelo, marca, cor, placa, tipo_veiculo)
VALUES ('Civic', 'Honda', 'Prata', 'fr8-fre', 2),
       ('Sahara 300', 'Honda', 'Vermelha', 't5r-768', 1),
       ('Fan 160', 'Honda', 'Vermelha', 't5r-ews', 1);

INSERT INTO estabelecimento(cnpj, endereco, telefone, total_vagas_motos, total_vagas_carros)
VALUES ('8857789595', 'Rua das arvores', '556688775', 10, 10),
       ('8832343235', 'Centro', '55877744', 7, 5);

INSERT INTO vaga_estacionamento(estabelecimento_id, veiculo_id, data_entrada)
VALUES (2, 1, '2024-02-20 12:21:21'),
       (2, 2, '2024-02-20 12:50:55');