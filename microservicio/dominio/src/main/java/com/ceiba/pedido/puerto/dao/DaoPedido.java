package com.ceiba.pedido.puerto.dao;

import com.ceiba.pedido.modelo.entidad.Pedido;

public interface DaoPedido {
    /**
     * permite encontrar el pedido por id
     * @param id identificador de pedido
     * @return el pedido
     */
    Pedido FindById(long id);
}
