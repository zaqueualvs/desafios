package com.alves.lanchonete.adapters.in.eventlistener;

import com.alves.lanchonete.applications.ports.in.event.PedidoCreatedEventListener;
import com.alves.lanchonete.commons.customannotations.EventListenerAdapter;
import com.alves.lanchonete.domain.event.PedidoCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

import java.time.format.DateTimeFormatter;

@EventListenerAdapter
@Slf4j
public class PedidoCreatedEventListenerAdapter implements PedidoCreatedEventListener {

    @EventListener
    @Override
    public void handle(PedidoCreatedEvent event) {
        DateTimeFormatter dtm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        log.info(String.format("Pedido criado com o id %d na data %s", event.getId(), dtm.format(event.getDate())));
    }
}
