package com.ceiba.cliente.comando.manejador;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCliente {

    private ServicioActualizarCliente servicioActualizarCliente;

    @Autowired
    public ManejadorActualizarCliente(ServicioActualizarCliente servicioActualizarCliente) {
        this.servicioActualizarCliente = servicioActualizarCliente;
    }

   public Cliente actualizar(Cliente cliente){
        return servicioActualizarCliente.ejecutar(cliente);
    }
}
