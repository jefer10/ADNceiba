package com.ceiba.cliente.adaptador.repository;

import com.ceiba.cliente.adaptador.dao.ClienteRegistroRepositoryJPA;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RepositorioH2  implements DaoCliente {

    private ClienteRegistroRepositoryJPA clienteRegistroRepositoryJPA;

    @Autowired
    public RepositorioH2(ClienteRegistroRepositoryJPA clienteRegistroRepositoryJPA) {
        this.clienteRegistroRepositoryJPA = clienteRegistroRepositoryJPA;
    }

    @Override
    public Cliente findById(long id) {
        return clienteRegistroRepositoryJPA.findById(id).get();
    }
}
