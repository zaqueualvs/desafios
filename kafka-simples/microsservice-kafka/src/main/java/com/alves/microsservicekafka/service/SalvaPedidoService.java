package com.alves.microsservicekafka.service;

import com.alves.microsservicekafka.data.PedidoData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SalvaPedidoService {

    @KafkaListener(topics = "SalvarPedido", groupId = "MicrosservicoSalvaPedido")
    private void executar(ConsumerRecord<String, String> record) {
        log.info("Key ={}", record.key());
        log.info("Header ={}", record.headers());
        log.info("Partition ={}", record.partition());

        String dados = record.value();
        ObjectMapper mapper = new ObjectMapper();
        PedidoData pedidoData = null;
        try {
            pedidoData = mapper.readValue(dados, PedidoData.class);
        } catch (JsonProcessingException e) {
            log.error("Falha ao converter evento");
        }
        log.info("Evento recebido ={}", pedidoData);


    }
}
