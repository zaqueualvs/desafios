package com.alves.picpaysimplificado.adapters.in.rest.mappers;

import com.alves.picpaysimplificado.adapters.in.rest.data.request.TransactionRequest;
import com.alves.picpaysimplificado.domain.models.Transaction;
import com.alves.picpaysimplificado.domain.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionRestMapper {

    Transaction toDomain(TransactionRequest transactionRequest);

    default Usuario mapToDomain(Long value) {
        if (value == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setId(value);
        return usuario;
    }

}
