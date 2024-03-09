package com.alves.lanchonete.applications.ports.out.pedido;

import com.alves.lanchonete.domain.models.Cliente;
import com.alves.lanchonete.domain.models.Pedido;

import java.util.List;

public interface FindAllPedidoByClientePort {

    List<Pedido> find(Cliente cliente);
}
