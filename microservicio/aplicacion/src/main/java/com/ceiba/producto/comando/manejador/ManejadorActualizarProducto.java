package com.ceiba.producto.comando.manejador;

import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.ServicioActualizarProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarProducto {

    private ServicioActualizarProducto servicioActualizarProducto;

    @Autowired
    public ManejadorActualizarProducto(ServicioActualizarProducto servicioActualizarProducto) {
        this.servicioActualizarProducto = servicioActualizarProducto;
    }

    public Producto update(Producto producto){
        return servicioActualizarProducto.actualizar(producto);
    }


}
