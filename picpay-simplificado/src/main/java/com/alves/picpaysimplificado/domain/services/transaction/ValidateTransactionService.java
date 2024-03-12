package com.alves.picpaysimplificado.domain.services.transaction;

import ch.qos.logback.core.net.server.Client;
import com.alves.picpaysimplificado.domain.models.Usuario;
import com.alves.picpaysimplificado.domain.models.enuns.TipoUsuario;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ValidateTransactionService {

    public void valid(Usuario payer, BigDecimal value) {
        if (payer.getTipoUsuario() == TipoUsuario.LOGISTA) {
            throw new RuntimeException("Logista não autorizado a enviar dinheiro");
        }

        if (!((payer.getSaldo().compareTo(value)) >= 0)){
            throw new RuntimeException("Saldo insuficiente para realizar tranferencia");
        }
    }
}
