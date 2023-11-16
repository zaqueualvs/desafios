package com.alves.planetas.infraestructure.shared;

import java.io.Serializable;

public interface RestConverter<D extends Serializable, R extends Serializable> {

    default D mapToDomain(final R rest) {
        throw new UnsupportedOperationException();
    }

    default R mapToRest(final D domain) {
        throw new UnsupportedOperationException();
    }
}
