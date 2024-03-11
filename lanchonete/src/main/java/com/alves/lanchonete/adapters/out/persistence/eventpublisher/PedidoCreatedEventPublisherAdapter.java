package com.alves.lanchonete.adapters.out.persistence.eventpublisher;

import com.alves.lanchonete.applications.ports.out.event.PedidoCreatedEventPublisher;
import com.alves.lanchonete.commons.customannotations.EventPublisherAdapter;
import com.alves.lanchonete.domain.event.PedidoCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
@EventPublisherAdapter
public class PedidoCreatedEventPublisherAdapter implements PedidoCreatedEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void publisherEvent(PedidoCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
