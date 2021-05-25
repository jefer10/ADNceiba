package com.ceiba.pedido.comando.manejador;

import com.ceiba.pedido.servicio.ServicioEliminarPedido;
import com.ceiba.producto.servicio.ServicioEliminarProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ManejadorEliminarPedido {

    private ServicioEliminarPedido servicioEliminarPedido;

    @Autowired
    public ManejadorEliminarPedido(ServicioEliminarPedido servicioEliminarPedido) {
        this.servicioEliminarPedido = servicioEliminarPedido;
    }

    public void delete(long id){
        servicioEliminarPedido.delete(id);
    }
}
