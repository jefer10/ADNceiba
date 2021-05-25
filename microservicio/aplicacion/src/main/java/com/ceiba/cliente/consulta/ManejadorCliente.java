package com.ceiba.cliente.consulta;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioBuscarCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCliente {

    private final ServicioBuscarCliente servicioBuscarCliente;

    @Autowired
    public ManejadorCliente(ServicioBuscarCliente servicioBuscarCliente) {
        this.servicioBuscarCliente = servicioBuscarCliente;
    }

    public Cliente findByid(long id){
        return servicioBuscarCliente.findByid(id);
    }
}
