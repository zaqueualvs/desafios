package com.alves.lanchonete.applications.ports.out.event;

import com.alves.lanchonete.domain.event.PedidoCreatedEvent;

public interface PedidoCreatedEventPublisher {

    void publisherEvent(PedidoCreatedEvent event);
}
