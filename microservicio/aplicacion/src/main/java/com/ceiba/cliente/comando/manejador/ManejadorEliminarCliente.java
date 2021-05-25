package com.ceiba.cliente.comando.manejador;

import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarCliente {

    private ServicioEliminarCliente servicioEliminarCliente;

    @Autowired
    public ManejadorEliminarCliente(ServicioEliminarCliente servicioEliminarCliente) {
        this.servicioEliminarCliente = servicioEliminarCliente;
    }

    public void eliminar(long id){
        servicioEliminarCliente.ejecutar(id);
    }
}
