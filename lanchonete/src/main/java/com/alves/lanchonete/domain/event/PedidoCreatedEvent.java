package com.alves.lanchonete.domain.event;

import java.time.OffsetDateTime;

public class PedidoCreatedEvent {
    private final Long id;
    private final OffsetDateTime date;

    public PedidoCreatedEvent(Long id) {
        this.id = id;
        this.date = OffsetDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public OffsetDateTime getDate() {
        return date;
    }
}
