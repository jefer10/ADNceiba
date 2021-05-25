package com.ceiba.pedido.comando.fabrica;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaPedido {

    private ServicioCrearPedido servicioCrearPedido;

    @Autowired
    public FabricaPedido(ServicioCrearPedido servicioCrearPedido) {
        this.servicioCrearPedido = servicioCrearPedido;
    }

    public Pedido crear(Pedido pedido){
        return servicioCrearPedido.crear(pedido);
    }
}
