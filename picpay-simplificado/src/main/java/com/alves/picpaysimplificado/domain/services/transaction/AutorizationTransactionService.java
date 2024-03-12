package com.alves.picpaysimplificado.domain.services.transaction;

import com.alves.picpaysimplificado.common.customannotations.UseCase;
import com.alves.picpaysimplificado.domain.models.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.Map;

@RequiredArgsConstructor
@UseCase
public class AutorizationTransactionService {
    private final WebClient webClient;

    private final String api = "https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc";

    public Boolean autorizeTransaction(Usuario payer, BigDecimal value) {
        ResponseEntity<Map> response = webClient.get().uri(api).retrieve().toEntity(Map.class).block();
        if(response.getStatusCode().equals(HttpStatus.OK)){
            String message =(String) response.getBody().get("message");
            return message.equals("Autorizado");
        }
        return false;
    }
}
