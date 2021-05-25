package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.entidad.Cliente;

import java.util.Optional;

public interface DaoCliente {

    /**
     * permite encontar el cliente por id
     * @param id el identificador del cliente
     * @return el cliente
     */
    Cliente findById(long id);
}
