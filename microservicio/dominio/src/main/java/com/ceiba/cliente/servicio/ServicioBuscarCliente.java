package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioBuscarCliente {

    private DaoCliente daoCliente;

    @Autowired
    public ServicioBuscarCliente(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }

    public Cliente findByid(long id){
        return daoCliente.findById(id);
    }
}
