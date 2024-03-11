package com.alves.lanchonete.applications.ports.in.event;

import com.alves.lanchonete.domain.event.PedidoCreatedEvent;

public interface PedidoCreatedEventListener {
    void handle(PedidoCreatedEvent event);
}
