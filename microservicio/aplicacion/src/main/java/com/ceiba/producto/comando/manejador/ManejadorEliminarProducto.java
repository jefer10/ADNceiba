package com.ceiba.producto.comando.manejador;

import com.ceiba.producto.servicio.ServicioEliminarProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarProducto {

    private ServicioEliminarProducto servicioEliminarProducto;
    @Autowired
    public ManejadorEliminarProducto(ServicioEliminarProducto servicioEliminarProducto) {
        this.servicioEliminarProducto = servicioEliminarProducto;
    }
    public void delete(long id){
        servicioEliminarProducto.delete(id);
    }
}
