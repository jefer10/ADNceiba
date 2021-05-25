package com.ceiba.pedido.comando.manejador;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.servicio.ServicioActualizarPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPedido {

    private ServicioActualizarPedido servicioActualizarPedido;

    @Autowired
    public ManejadorActualizarPedido(ServicioActualizarPedido servicioActualizarPedido) {
        this.servicioActualizarPedido = servicioActualizarPedido;
    }

    public Pedido actualizar(Pedido pedido){
        return servicioActualizarPedido.actualizar(pedido);
    }
}
