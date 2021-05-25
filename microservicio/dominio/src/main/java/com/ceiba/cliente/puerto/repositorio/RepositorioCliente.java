package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {

    /**
     * permite crear usuario
     * @param cliente
     * @return el nuevo cliente
     */
    Cliente crear(Cliente cliente);

    /**
     * permite actualizar el cliente
     * @param cliente
     * @return el cliente actualizado
     */
    Cliente actualizar(Cliente cliente);

    /**
     * permite eliminar el cliente por identificador
     * @param id identificador del cliente
     */
    void eliminar(long id);
}
