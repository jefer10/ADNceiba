package com.ceiba.cliente.comando.fabrica;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {

    private ServicioCrearCliente servicioCrearCliente;

    @Autowired
    public FabricaCliente(ServicioCrearCliente servicioCrearCliente) {
        this.servicioCrearCliente = servicioCrearCliente;
    }

    public Cliente crear(Cliente cliente){
        return servicioCrearCliente.ejecutar(cliente);
    }
}
