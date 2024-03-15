package com.alves.estacionamento.adapters.in.rest.mappers;

import com.alves.estacionamento.adapters.in.rest.data.request.VagaEstacionamentoResquest;
import com.alves.estacionamento.application.domain.models.VagaEstacionamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {EstabelecimentoRestMapper.class,
                VeiculoRestMapper.class})
public interface VagaEstacionamentoRestMapper {


    @Mapping(source = "veiculoId", target = "veiculo.id")
    @Mapping(source = "estabelecimentoId", target = "estabelecimento.id")
    VagaEstacionamento toDomain(VagaEstacionamentoResquest vagaEstacionamentoResquest);
}
