package com.ceiba.cliente.adaptador.repository;

import com.ceiba.cliente.adaptador.dao.ClienteRegistroRepositoryJPA;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClienteRepositorioH2 implements DaoCliente, RepositorioCliente {

    private ClienteRegistroRepositoryJPA clienteRegistroRepositoryJPA;

    @Autowired
    public ClienteRepositorioH2(ClienteRegistroRepositoryJPA clienteRegistroRepositoryJPA) {
        this.clienteRegistroRepositoryJPA = clienteRegistroRepositoryJPA;
    }

    @Override
    public Cliente findById(long id) {
        return clienteRegistroRepositoryJPA.findById(id).get();
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRegistroRepositoryJPA.save(cliente);
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        return  clienteRegistroRepositoryJPA.save(cliente);
    }

    @Override
    public void eliminar(long id) {
        clienteRegistroRepositoryJPA.deleteById(id);
    }
}
