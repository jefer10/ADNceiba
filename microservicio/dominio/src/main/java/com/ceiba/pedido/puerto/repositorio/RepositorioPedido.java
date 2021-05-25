package com.ceiba.pedido.puerto.repositorio;

import com.ceiba.pedido.modelo.entidad.Pedido;

public interface RepositorioPedido {

    /**
     * permite crear un pedido
     * @param pedido pedido a crear
     * @return
     */
    Pedido crear(Pedido pedido);

    /**
     * permite actualizar un pedido
     * @param pedido
     * @return
     */
    Pedido actualizar(Pedido pedido);

    /**
     * permite eliminar un pedido
     * @param id
     */
    void eliminar(long id);
    
}
